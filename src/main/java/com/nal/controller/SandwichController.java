package com.nal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/sandwich")
public class SandwichController {
    @GetMapping("")
    public ModelAndView showForm() {
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }

    @RequestMapping("/save")
    public ModelAndView save(@RequestParam(required = false, name = "condiment") String[] condiment) {
        ModelAndView modelAndView = new ModelAndView("save");
        if (condiment == null) {
            String[] noCondiment = {"No Spices in Sandwich"};
            modelAndView.addObject("condiment", noCondiment);
        } else {
            modelAndView.addObject("condiment", condiment);
        }
        return modelAndView;
    }
}
