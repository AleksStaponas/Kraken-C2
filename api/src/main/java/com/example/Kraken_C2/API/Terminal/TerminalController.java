package com.example.Kraken_C2.API.Terminal;

import com.example.Kraken_C2.Config.DirectoryValues;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("/api/terminal")
@RestController
public class TerminalController {

    private final DirectoryValues directoryValues;

    public TerminalController(DirectoryValues directoryValues) {
        this.directoryValues = directoryValues;
    }

    @PostMapping("/run")
    public ResponseEntity<Map<String, String>> runCommand(@RequestBody Map<String, String> body) {

        String cmd = body.getOrDefault("cmd", "dir");

        boolean isWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");

        ProcessBuilder pb = new ProcessBuilder();

        if (isWindows) {

            pb.command("cmd.exe", "/c", cmd);

        } else {

            pb.command("sh", "-c", cmd);

        }

        try {

            pb.directory(new File(directoryValues.getKrakenPath()));
            Process process = pb.start();
            String output = new String(process.getInputStream().readAllBytes());
            String error = new String(process.getErrorStream().readAllBytes());
            int exitCode = process.waitFor();

            Map<String, String> result = new HashMap<>();

            result.put("output", output);
            result.put("error", error);
            result.put("exitCode", String.valueOf(exitCode));

            return ResponseEntity.ok(result);

        } catch (Exception e) {

            return ResponseEntity.status(500).body(Map.of("error", e.getMessage()));

        }
    }
}