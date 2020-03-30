package com.moviedb.Movies.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "genre_movie")
public class GenreMovie {
    public GenreMovie() {}

    public GenreMovie(Genre genre, Movie movie){
        this.genre = genre;
        this.movie = movie;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genre_movie_id")
    private Integer id;

    @NotNull(message = "Genre must not be empty.")
    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @NotNull(message = "Movie must not be empty.")
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    public Integer getId() {
        return id;
    }

    public Genre getGenre(){
        return genre;
    }

    public void setGenre(Genre genre){
        this.genre = genre;
    }

    public Movie getMovie(){
        return movie;
    }

    public void setMovie(Movie movie){
        this.movie = movie;
    }

    @Override
    public String toString(){
        return String.format(
                "GenreMovie[id=%d, movie_id=%d, genre_id=%d]",
                id, movie.getId(), genre.getId()
        );

    }


}