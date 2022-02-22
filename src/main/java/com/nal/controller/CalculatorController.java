package com.nal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/calculator")
public class CalculatorController {

    @GetMapping()
    public ModelAndView showForm() {
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }

}
