package com.nal.controller;

import com.nal.model.Blog;
import com.nal.service.IGeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("blog")
public class BlogController {
    @Autowired
    private IGeneralService<Blog> customerService;


    @GetMapping()
    public ModelAndView showBlogList() {
        ModelAndView modelAndView = new ModelAndView("/list");
        List<Blog> blogs = customerService.findAll();
        modelAndView.addObject("blogs", blogs);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("blog", new Blog());
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView saveCustomer(@ModelAttribute("blog") Blog blog) {
        blog.setTime(LocalDateTime.now());
        System.out.println(blog.getId());
        customerService.save(blog);
        ModelAndView modelAndView = new ModelAndView("redirect:/blog");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("/edit");
        Blog blog = customerService.findById(id);
        modelAndView.addObject("blog", blog);
        return modelAndView;
    }

    @GetMapping("/detail/{id}")
    public ModelAndView showDetail(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("/detail");
        Blog blog = customerService.findById(id);
        modelAndView.addObject("blog", blog);
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDelete(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("redirect:/blog");
        customerService.remove(id);
        return modelAndView;
    }
}
