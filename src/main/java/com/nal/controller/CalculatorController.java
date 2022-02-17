package com.nal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/calculator")
public class CalculatorController {
    @GetMapping()
    public ModelAndView showForm() {
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }

    @PostMapping()
    public ModelAndView showResult(@RequestParam("cal") int cal, double stn, double sth) {
        ModelAndView modelAndView = new ModelAndView("/index");
        double result = 0.0f;
        switch (cal) {
            case 1 -> {
                result = stn + sth;
            }
            case 2 -> {
                result = stn - sth;
            }
            case 3 -> {
                result = stn * sth;
            }
            case 4 -> {
                result = stn / sth;
            }
        }
        modelAndView.addObject("result", result);
        modelAndView.addObject("stn", stn);
        modelAndView.addObject("sth", sth);
        return modelAndView;
    }
}
