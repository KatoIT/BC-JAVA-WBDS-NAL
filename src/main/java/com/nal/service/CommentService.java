package com.nal.service;

import com.nal.model.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> findAll();

    Comment findOne(Long id);

    Comment save(Comment comment);
}
