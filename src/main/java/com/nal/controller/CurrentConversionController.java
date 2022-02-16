package com.nal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class CurrentConversionController {
    @GetMapping("/dictionary")
    public String showForm() {
        return "dictionary";
    }

    @GetMapping("/vietnamese")
    public String result(@RequestParam String english, Model model) {
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
        model.addAttribute("ENG", english);
        model.addAttribute("VIE", vietNam);
        return "vietnamese";
    }
}
