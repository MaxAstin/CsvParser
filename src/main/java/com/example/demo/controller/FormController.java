package com.example.demo.controller;

import com.example.demo.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
/*@RequestMapping("/")*/
public class FormController {

    @Autowired
    public FormService formService;

    @GetMapping("/main")
    public String getTestData() {
        return "main";
    }

    @GetMapping("/report/forms")
    public String showFormsReport(@RequestParam(value = "date", required = false, defaultValue = "2017-07-11-09") String date, Model model) {
        model.addAttribute("forms", formService.findAll(date));
        return "formsReport";
    }

    @GetMapping("/report/unfinished")
    public String showUnfinishedReport(Model model) {
        model.addAttribute("steps", formService.findUnfinished());
        return "stepsReport";
    }

    @GetMapping("/report/top")
    public String showTop(Model model) {
        model.addAttribute("top", formService.findTopForms());
        return "topReport";
    }
}
