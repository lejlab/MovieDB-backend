package com.moviedb.Movies.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private Integer id;

    @Column(name = "title")
    @NotBlank(message = "Title is mandatory")
    private String title;
    
    @Column(name = "releaseDate")
    private Date releaseDate;
    
    @Column(name = "boxOffice")
    @PositiveOrZero(message="Box office must be nonnegative")
    private double boxOffice;
    
    @ManyToMany(mappedBy = "movies")
    private Set<Genre> genres;
    
    
    public Movie () {}    
    
    
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
    
    public Set<Genre> getGenres() {
        return genres;
    }
    
    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    
    
    
    
}
