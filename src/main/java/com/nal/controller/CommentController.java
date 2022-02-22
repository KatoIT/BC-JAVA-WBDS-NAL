package com.nal.controller;

import com.nal.model.Comment;
import com.nal.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("image")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("index");
        List<Comment> comments = commentService.findAll();
        modelAndView.addObject("comments", comments);
        modelAndView.addObject("comment", new Comment(LocalDateTime.now(), "", "", 1));
        return modelAndView;
    }

    @PostMapping
    public String createComment(Comment comment) {
        comment.setTime(LocalDateTime.now());
        commentService.save(comment);
        return "redirect:/image";
    }

    @GetMapping("/{id}")
    public String createComment(@PathVariable("id") Long id) {
        Comment comment = commentService.findOne(id);
        comment.setNumberOfLikes(comment.getNumberOfLikes() + 1);
        commentService.save(comment);
        return "redirect:/image";
    }
}
