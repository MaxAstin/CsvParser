package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {

    @GetMapping(value = "/main")
    public String getTestData() {
        return "main";
    }

    @RequestMapping(value="/upload", method= RequestMethod.POST)
    public String handleFileUpload(@RequestParam("file") MultipartFile file){
        if (!file.isEmpty()) {
            System.out.println("Done");
        } else {
            return "Вам не удалось загрузить потому что файл пустой.";
        }
        return "redirect:/main";
    }
}