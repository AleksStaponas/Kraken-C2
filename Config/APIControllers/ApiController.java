package com.example.Kraken_C2.Config.APIControllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {
    @GetMapping("/test")
    public String getData() {
        return "Test API endpoint";
    }
}
