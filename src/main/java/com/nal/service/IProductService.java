package com.nal.service;

import com.nal.model.Song;

import java.util.List;

public interface IProductService {
    List<Song> findAll();

    void save(Song song);

    Song findById(int id);

    void update(int id, Song song);

    void remove(int id);

}
