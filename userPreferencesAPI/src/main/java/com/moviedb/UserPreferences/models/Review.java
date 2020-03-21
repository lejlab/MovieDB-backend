package com.moviedb.UserPreferences.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "reviews")
public class Review {
    public Review () {}

    public Review (Integer userId, Integer movieId, double grade, LocalDateTime createdAt){
        this.userId = userId;
        this.movieId = movieId;
        this.grade = grade;
        this.createdAt = createdAt;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Integer id;

    @NotNull(message = "UserId must not be null.")
    @Min(value = 1, message = "UserId must be positive.")
    @Column(name = "user_id")
    private Integer userId;

    @NotNull(message = "MovieId must not be null.")
    @Min(value = 1, message = "MovieId must be positive")
    @Column(name = "movie_id")
    private Integer movieId;

    @NotNull(message = "Grade must not be null.")
    @Min(value = 1, message = "Grade must be at least 1.")
    @Max(value = 10, message = "Grade must not be higher than 10.")
    @Column(name = "grade")
    private double grade;

    @NotNull(message = "CreatedAt must not be null.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return String.format(
                "Review[id=%d, user_id=%d, movie_id=%d, grade=%.2f]",
                id, userId, movieId, grade);
    }
}
