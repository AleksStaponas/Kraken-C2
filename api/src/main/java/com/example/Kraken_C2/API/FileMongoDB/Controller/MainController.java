package com.example.Kraken_C2.API.FileMongoDB.Controller;

import com.example.Kraken_C2.API.FileMongoDB.Model.File;
import com.example.Kraken_C2.API.FileMongoDB.Repository.FileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MainController {

    @Autowired
    FileRepo fileRepo;

    //Add file
    @PostMapping("/file")
    public void addFile(@RequestBody File file) {
        fileRepo.save(file);
    }

    //Get file by id
    @GetMapping("/file/{id}")
    public File retrieveFile(@PathVariable String id) {
        return fileRepo.findById(id).orElse(null);
    }

    //Get all files
    @GetMapping("/file")
    public List<File> fetchFiles(){
        return fileRepo.findAll();
    }

    //Delete file
    @DeleteMapping("/file/{id}")
    public void removeFile(@PathVariable String id) {
        fileRepo.deleteById(id);
    }

}