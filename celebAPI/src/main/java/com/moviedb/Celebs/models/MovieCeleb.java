package com.moviedb.Celebs.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "movie_celebs")
public class MovieCeleb {
    public MovieCeleb() {}

    public MovieCeleb(@NotNull(message = "Celeb must not be empty.") Celeb celeb, @NotNull(message = "MovieId must not be null.") @Min(value = 1, message = "MovieId must be positive") Integer movieId) {
        this.celeb = celeb;
        this.movieId = movieId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_celeb_id")
    private Integer id;

    @NotNull(message = "Celeb must not be empty.")
    @ManyToOne
    @JsonIgnoreProperties(value = "movies", allowSetters = true)
    @JoinColumn(name = "celeb_id", nullable = false)
    private Celeb celeb;

    @NotNull(message = "MovieId must not be null.")
    @Min(value = 1, message = "MovieId must be positive")
    @Column(name = "movie_id")
    private Integer movieId;

    public Integer getId() {
        return id;
    }

    public Celeb getCeleb() {
        return celeb;
    }

    public void setCeleb(Celeb celeb) {
        this.celeb = celeb;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    @Override
    public String toString(){
        return String.format(
                "MovieCelebs[id=%d, celeb_id=%d, movie_id=%d]",
                id, celeb.getId(), movieId);
    }
}
