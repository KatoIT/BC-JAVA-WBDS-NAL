package com.nal.controller;

import com.nal.model.User;
import com.nal.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/register")
    public ModelAndView showFromRegister() {
        ModelAndView modelAndView = new ModelAndView("/register");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @PostMapping("/register")
    public ModelAndView saveUser(@Valid @ModelAttribute("user") User user,
                                 RedirectAttributes redirectAttributes,
                                 BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("redirect:/info");
        if (bindingResult.hasErrors()) {
            modelAndView = new ModelAndView("/register");
        } else {
            userService.save(user);
            redirectAttributes.addFlashAttribute("user", user);
        }
        return modelAndView;
    }

    @GetMapping("/info")
    public ModelAndView showInfo(@ModelAttribute("user") User user) {
        ModelAndView modelAndView = new ModelAndView("/info");
        modelAndView.addObject("user", user);
        return modelAndView;
    }
}
