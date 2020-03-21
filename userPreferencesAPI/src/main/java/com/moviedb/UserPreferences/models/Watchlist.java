package com.moviedb.UserPreferences.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "watchlists")
public class Watchlist {
    public Watchlist() {}

    public Watchlist(Integer userId, Integer movieId, boolean isPublic, LocalDateTime createdAt) {
        this.userId = userId;
        this.movieId = movieId;
        this.isPublic = isPublic;
        this.createdAt = createdAt;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "watchlist_id")
    private Integer id;

    @NotNull(message = "UserId must not be null.")
    @Min(value = 1, message = "UserId must be positive.")
    @Column(name = "user_id")
    private Integer userId;

    @NotNull(message = "MovieId must not be null.")
    @Min(value = 1, message = "MovieId must be positive")
    @Column(name = "movie_id")
    private Integer movieId;

    @NotNull(message = "IsPublic must not be empty.")
    @Column(name = "is_public")
    private boolean isPublic;

    @NotNull(message = "CreatedAt must not be null.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @Column(name = "created_at")
    private LocalDateTime createdAt;

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

    public boolean getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(boolean isPublic) {
        this.isPublic = isPublic;
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
                "Watchlist[id=%d, user_id=%d, movie_id=%d, is_public=%b]",
                id, userId, movieId, isPublic);
    }
}
