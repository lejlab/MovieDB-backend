package com.moviedb.Movies.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

@Entity
@Table(name = "movies")
public class Movie {

    public Movie(){}

    public Movie(String title, Date releaseDate, double boxOffice){
        this.title = title;
        this.releaseDate = releaseDate;
        this.boxOffice = boxOffice;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private Integer id;

    @Column(name = "title")
    @NotBlank(message = "Title is mandatory")
    private String title;

    @Column(name = "release_date")
    private Date releaseDate;

    @Column(name = "box_office")
    @PositiveOrZero(message="Box office must be nonnegative")
    private double boxOffice;
/*
    @ManyToMany(mappedBy = "movies")
    private Set<Genre> genres;

*/

    @OneToMany(targetEntity = GenreMovie.class, mappedBy = "movie", fetch = FetchType.LAZY)
    @Fetch(value = FetchMode.SUBSELECT)
    @JsonIgnoreProperties(value = "movie", allowSetters = true)
    private List<GenreMovie> genres;


    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public double getBoxOffice() {
        return boxOffice;
    }

    public void setBoxOffice(double boxOffice) {
        this.boxOffice = boxOffice;
    }

    public List<GenreMovie> getGenres() {
        return genres;
    }

    public void setGenres(List<GenreMovie> genres) {
        this.genres = genres;
    }

    @Override
    public String toString(){
        return String.format(
                "Movie[id=%d, title=%s, releaseDate=%s, boxOffice=%f]",
                id, title, releaseDate.toString(), boxOffice
        );

    }




}
