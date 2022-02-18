package com.nal.controller;

import com.nal.model.Song;
import com.nal.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("songs")
public class SongController {
    @Autowired
    private SongService songService;

    @GetMapping
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("songs/list");
        List<Song> songs = songService.findAll();
        modelAndView.addObject("songs", songs);
        return modelAndView;
    }

    @GetMapping("{id}")
    public ModelAndView showInformation(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("songs/info");
        Song song = songService.findOne(id);
        modelAndView.addObject("song", song);
        return modelAndView;
    }

    @PostMapping
    public String updateCustomer(Song song) {
        songService.save(song);
        return "redirect:/songs";
    }
}
