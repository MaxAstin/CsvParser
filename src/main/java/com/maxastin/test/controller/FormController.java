package com.maxastin.test.controller;

import com.maxastin.test.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormController {

    @Autowired
    public FormService formService;

    @GetMapping("/main")
    public String getTestData() {
        return "main";
    }

    @GetMapping("/report/forms")
    public String showFormsReport(@RequestParam(value = "date", required = false, defaultValue = "2017-07-11-11") String date, Model model) {
        model.addAttribute("forms", formService.findRecentForms(date));
        return "recentFormsReport";
    }

    @GetMapping("/report/unfinished")
    public String showUnfinishedReport(Model model) {
        model.addAttribute("forms", formService.findUnfinishedForms());
        return "unfinishedFormsReport";
    }

    @GetMapping("/report/top")
    public String showTop(Model model) {
        model.addAttribute("top", formService.findTopForms());
        return "topFormsReport";
    }
}
