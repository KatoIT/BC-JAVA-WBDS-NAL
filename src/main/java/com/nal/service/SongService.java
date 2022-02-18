package com.nal.service;

import com.nal.model.Song;

import java.util.List;

public interface SongService {
    List<Song> findAll();

    Song findOne(Long id);

    Song save(Song customer);

    List<Song> save(List<Song> customers);

    boolean exists(Long id);

    List<Song> findAll(List<Long> ids);

    long count();

    void delete(Long id);

    void delete(Song song);

    void delete(List<Song> songs);

    void deleteAll();
}
