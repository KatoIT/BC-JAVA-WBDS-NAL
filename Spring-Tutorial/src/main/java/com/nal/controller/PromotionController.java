package com.nal.controller;

import com.nal.model.Promotion;
import com.nal.service.promotion.IPromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/promotions")
public class PromotionController {
    @Autowired
    private IPromotionService promotionService;

    @GetMapping()
    public ModelAndView showListProduct() {
        ModelAndView modelAndView = new ModelAndView("/promotion/list");
        modelAndView.addObject("promotions", promotionService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/promotion/create");
        modelAndView.addObject("promotion", new Promotion());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView saveProduct(@Validated @ModelAttribute("promotion") Promotion promotion, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ModelAndView("/promotion/create");
        } else {
            promotionService.save(promotion);
            return new ModelAndView("redirect:/promotions");
        }
    }

    @PostMapping()
    public ModelAndView saveProduct(@ModelAttribute("search") Optional<String> search) {
        ModelAndView modelAndView = new ModelAndView("/promotion/list");
        if (search.isPresent()) {
            String txtSearch = search.get();
            if (isNumeric(txtSearch)) {
                modelAndView.addObject("promotions", promotionService.findAllByDiscount(Double.parseDouble(txtSearch)));
            }
//            TODO Search by startDay and End day
//            else {
//
//            }
        } else {
            modelAndView.addObject("promotions", promotionService.findAll());
        }
        return modelAndView;
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }


    @GetMapping("/delete/{id}")
    public ModelAndView deleteProductNew(@PathVariable Long id) {
        promotionService.remove(id);
        return new ModelAndView("redirect:/promotions");
    }


}
