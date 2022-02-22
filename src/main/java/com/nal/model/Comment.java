package com.nal.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(schema = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime time;
    private String contentCommend;
    private String author;
    private int rate;
    private int numberOfLikes = 0;

    public Comment() {
    }

    public Comment(Long id, LocalDateTime time, String contentCommend, String author, int rate, int numberOfLikes) {
        this.id = id;
        this.time = time;
        this.contentCommend = contentCommend;
        this.author = author;
        this.rate = rate;
        this.numberOfLikes = numberOfLikes;
    }

    public Comment(LocalDateTime time,String contentCommend, String author, int rate) {
        this.time = time;
        this.contentCommend = contentCommend;
        this.author = author;
        this.rate = rate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getContentCommend() {
        return contentCommend;
    }

    public void setContentCommend(String contentCommend) {
        this.contentCommend = contentCommend;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getNumberOfLikes() {
        return numberOfLikes;
    }

    public void setNumberOfLikes(int numberOfLikes) {
        this.numberOfLikes = numberOfLikes;
    }
}
