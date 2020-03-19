package com.moviedb.Movies.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "movies")
public class Movie {
    public Movie () {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private Integer id;

    private String title;
    
    private Date releaseDate;
    
    private double boxOffice;

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

    
}
