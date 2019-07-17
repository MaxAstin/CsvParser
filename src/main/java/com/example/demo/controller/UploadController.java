package com.example.demo.controller;

import com.example.demo.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {

    @Autowired
    public FormService formService;

    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam(value = "file") MultipartFile file, Model model){
        if (!file.isEmpty()) {
            if(file.getOriginalFilename().matches(".+\\.csv")) {
                formService.updateDatabase(file);
                model.addAttribute("result", "Parsing done!");
            } else {
                model.addAttribute("result", "Invalid file format! (let`s only .csv)");
            }
        } else {
            model.addAttribute("result", "File is empty");
        }
        return "parsingResult";
    }
}