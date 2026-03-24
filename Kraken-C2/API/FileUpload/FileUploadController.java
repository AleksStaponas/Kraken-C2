package com.example.Kraken_C2.API.FileUpload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.example.Kraken_C2.API.FileUpload.Storage.StorageFileNotFoundException;
import com.example.Kraken_C2.API.FileUpload.Storage.StorageService;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

@Controller
@RequestMapping("/api/files")
public class FileUploadController {

    private final StorageService storageService;

    @Autowired
    public FileUploadController(StorageService storageService) {
        this.storageService = storageService;
    }

    @PostMapping("/delete/{filename}")
    @ResponseBody
    public String deleteFile(@PathVariable String filename) {

        try {
            String directoryPath = "Kraken-C2/upload-dir";
            File directory = new File(directoryPath);

            ArrayList<String> discoveredFileArray = new ArrayList<>();
            File[] discoveredFiles = directory.listFiles();

            if (discoveredFiles != null) {
                for (File file : discoveredFiles) {
                    discoveredFileArray.add(file.getName());
                }
            } else {
                return "No discovered files";
            }

            //Linear search to find and delete file

            for (int i = 0; i < discoveredFileArray.size(); i++) {
                if (discoveredFileArray.get(i).equals(filename)) {

                    File fileToDelete = new File(directoryPath + "/" + filename);

                    if (fileToDelete.delete()) {
                        return "File " + filename + " has been deleted successfully";
                    } else {
                        return "File found but could not be deleted";
                    }
                }
            }

            return "File not found";

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/list")
    @ResponseBody
    public String displayFiles() {

        try {
            String filePath = "Kraken-C2/Logs/DiscoveredFiles.txt";
            String directoryPath = "Kraken-C2/upload-dir";

            File directory = new File(directoryPath);
            File[] discoveredFiles = directory.listFiles();

            FileWriter fileWriter = new FileWriter(filePath);

            if (discoveredFiles != null) {
                for (File file : discoveredFiles) {
                    fileWriter.write(file.getName() + "\n");
                }
            } else {
                return "No discovered files";
            }

            fileWriter.close();

            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            StringBuilder content = new StringBuilder();
            String line;

            int counter = 1;

            content.append("Files discovered: \n");
            while ((line = reader.readLine()) != null) {
                content.append(counter).append(": ").append(line).append("\n");
                counter++;
            }

            reader.close();
            return content.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

    @GetMapping("/download/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

        Resource file = storageService.loadAsResource(filename);

        if (file == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @PostMapping("/upload")
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {

        storageService.store(file);
        return ResponseEntity.ok("You successfully uploaded " + file.getOriginalFilename() + "!");
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }

}
