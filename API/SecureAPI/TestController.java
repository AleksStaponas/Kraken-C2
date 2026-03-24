package com.example.Kraken_C2.API.SecureAPI;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @GetMapping("api/authorization/test")
    public String getTodos() {
        return "Response from test";
    }
}
