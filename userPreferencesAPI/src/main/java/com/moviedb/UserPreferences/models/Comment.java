package com.moviedb.UserPreferences.models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
public class Comment {
    public Comment() {}

    public Comment(Integer userId, Integer movieId, String commentText, LocalDateTime createdAt) {
        this.userId = userId;
        this.movieId = movieId;
        this.commentText = commentText;
        this.createdAt = createdAt;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Integer id;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "movie_id", nullable = false)
    private Integer movieId;

    @Column(name = "text", nullable = false)
    private String commentText;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    public Integer getId(){
        return id;
    }

    public Integer getUserId(){
        return userId;
    }

    public void setUserId(Integer userId){
        this.userId = userId;
    }

    public Integer getMovieId(){
        return movieId;
    }

    public void setMovieId(Integer movieId){
        this.movieId = movieId;
    }

    public String getCommentText(){
        return commentText;
    }

    public void setCommentText(String commentText){
        this.commentText = commentText;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return String.format(
                "Comment[id=%d, user_id=%d, movie_id=%d, text='%s']",
                id, userId, movieId, commentText);
    }
}
