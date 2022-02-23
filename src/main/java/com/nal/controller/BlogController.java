package com.nal.controller;

import com.nal.model.Blog;
import com.nal.model.Category;
import com.nal.service.blog.IBlogService;
import com.nal.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.Optional;

@Controller
@RequestMapping("blogs")
public class BlogController {
    @Autowired
    private IBlogService blogService ;

    @Autowired
    private ICategoryService categoryService ;

    @ModelAttribute("categories")
    public Iterable<Category> categories(){
        return categoryService.findAll();
    }

    @GetMapping()
    public ModelAndView showBlogList(@RequestParam("search") Optional<String> search, Pageable pageable) {
        Page<Blog> blogs;
        if(search.isPresent()){
            blogs = blogService.findAllByTitleContaining(search.get(), pageable);
        } else {
            blogs = blogService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/list");
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
        System.out.println(blog);
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("redirect:blogs");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("/edit");
        Optional<Blog> blog = blogService.findById(id);
        modelAndView.addObject("blog", blog.get());
        return modelAndView;
    }

    @GetMapping("/detail/{id}")
    public ModelAndView showDetail(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("/detail");
        Optional<Blog> blog = blogService.findById(id);
        modelAndView.addObject("blog", blog.get());
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDelete(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("redirect:/blogs");
        blogService.remove(id);
        return modelAndView;
    }
}
