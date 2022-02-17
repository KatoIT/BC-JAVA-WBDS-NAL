package com.nal.controller;

import com.nal.model.SettingEmail;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/setting")
public class SettingEmailController {

    SettingEmail settingEmail = new SettingEmail("Vietnamese", 10, false, "An");

    @GetMapping("")
    public ModelAndView showInfo() {
        ModelAndView modelAndView = new ModelAndView("info");
        modelAndView.addObject("settingEmail", settingEmail);
        return modelAndView;
    }

    @GetMapping("/edit")
    public ModelAndView showForm() {
        ModelAndView modelAndView = new ModelAndView("edit");
        String[] languages = {"English", "Vietnamese", "Japanese", "Chinese"};
        int[] pageSize = {5, 10, 15, 25, 50, 100};
        modelAndView.addObject("settingEmail", this.settingEmail);
        modelAndView.addObject("pageSizes", pageSize);
        modelAndView.addObject("languages", languages);
        return modelAndView;
    }

    @PostMapping("")
    public ModelAndView save(@ModelAttribute("settingEmail") SettingEmail settingEmail) {
        ModelAndView modelAndView = new ModelAndView("redirect:setting");
        this.settingEmail = settingEmail;
        modelAndView.addObject("settingEmail", settingEmail);
        return modelAndView;
    }
}
