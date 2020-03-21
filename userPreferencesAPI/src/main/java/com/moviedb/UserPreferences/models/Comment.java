package com.moviedb.UserPreferences.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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

    @NotNull(message = "UserId must not be null.")
    @Min(value = 1, message = "UserId must be positive.")
    @Column(name = "user_id")
    private Integer userId;

    @NotNull(message = "MovieId must not be null.")
    @Min(value = 1, message = "MovieId must be positive")
    @Column(name = "movie_id")
    private Integer movieId;

    @NotNull(message = "Text must not be empty/null.")
    @Size(max = 200, message = "Text must not be longer than 200 characters.")
    @Column(name = "text")
    private String commentText;

    @NotNull(message = "CreatedAt must not be null.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @Column(name = "created_at")
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
