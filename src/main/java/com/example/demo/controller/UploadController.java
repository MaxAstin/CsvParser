package com.example.demo.controller;

import com.example.demo.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Controller
public class UploadController {

    @Autowired
    public FormService formService;

    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("file") MultipartFile file){
        if (!file.isEmpty()) {
            formService.updateDatabase(file);
            System.out.println("Done");
        } else {
            return "Вам не удалось загрузить потому что файл пустой.";
        }
        return "parsingDone";
    }
}