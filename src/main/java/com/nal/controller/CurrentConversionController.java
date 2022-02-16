package com.nal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class CurrentConversionController {
    @GetMapping("/dictionary")
    public ModelAndView showForm() {
        ModelAndView modelAndView = new ModelAndView("dictionary");
        return modelAndView;
    }

    @PostMapping("/dictionary")
    public ModelAndView result(@RequestParam String english, Model model) {
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("Hello", "Xin chào");
        dictionary.put("Hi", "Xin chào");
        dictionary.put("Good", "Tốt");
        dictionary.put("Dictionary", "Từ điển");
        dictionary.put("Car", "Ô tô");
        String vietNam = null;
        for (String key :
                dictionary.keySet()) {
            if (english.equalsIgnoreCase(key)) {
                vietNam = dictionary.get(key);
            }
        }
        if (vietNam == null) {
            vietNam = "Không tìm thấy từ này";
        }
        ModelAndView modelAndView = new ModelAndView("vietnamese");
        modelAndView.addObject("ENG", english);
        modelAndView.addObject("VIE", vietNam);
        return modelAndView;
    }
}
