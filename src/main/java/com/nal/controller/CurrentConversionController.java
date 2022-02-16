package com.nal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrentConversionController {
    @GetMapping("/convert")
    public String showForm() {
        return "current-conversion";
    }

    @GetMapping("/display")
    public String result(@RequestParam double USD, Model model) {
        double vnd = USD * 23000;
        model.addAttribute("usd", USD);
        model.addAttribute("vnd", vnd);
        return "display";
    }
}
