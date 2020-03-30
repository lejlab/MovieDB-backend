package com.moviedb.Movies.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "genres")
public class Genre {



    public Genre () {}

    public Genre(String name){
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genre_id")
    private Integer id;

    @NotNull(message = "Genre name must not be empty.")
    @Size(min = 2, message = "Genre name must have at least 2 characters ")
    @Column(name = "name")
    private String name;

    @OneToMany(targetEntity = GenreMovie.class, mappedBy = "genre", fetch = FetchType.LAZY)
    private List<GenreMovie> movies;



    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<GenreMovie> getMovies() {
        return movies;
    }

    public void setMovies(List<GenreMovie> movies) {
        this.movies = movies;
    }

    @Override
    public String toString(){
        return String.format(
                "Genre[id=%d, name=%s]",
                id, name
        );

    }
}
