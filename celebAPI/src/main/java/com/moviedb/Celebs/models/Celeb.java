package com.moviedb.Celebs.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "celebs")
public class Celeb {
    public Celeb() {}

    public Celeb(@NotNull(message = "First name must not be empty.") @Size(max = 2, message = "First name must not be longer than 30 characters.") String first_name, @NotNull(message = "Last name must not be empty.") @Size(max = 2, message = "Last name must not be longer than 30 characters.") String last_name, @NotNull(message = "Date of birst must not be empty.") Date date_of_birth) {
        this.firstName = first_name;
        this.lastName = last_name;
        this.dateOfBirth = date_of_birth;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "celeb_id")
    private Integer id;

    @NotNull(message = "First name must not be empty.")
    @Size(max = 2, message = "First name must not be longer than 30 characters.")
    @Column(name = "first_name")
    private String firstName;

    @NotNull(message = "Last name must not be empty.")
    @Size(max = 2, message = "Last name must not be longer than 30 characters.")
    @Column(name = "last_name")
    private String lastName;

    @NotNull(message = "Date of birth must not be empty.")
    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @OneToMany(targetEntity = CelebJobs.class, mappedBy = "celeb", fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = "celeb", allowSetters = true)
    private List<CelebJobs> jobs;

    @OneToMany(targetEntity = CelebJobs.class, mappedBy = "celeb", fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = { "celeb", "job"}, allowSetters = true)
    private List<MovieCeleb> movies;

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<CelebJobs> getJobs() {
        return jobs;
    }

    public void setJobs(List<CelebJobs> jobs) {
        this.jobs = jobs;
    }

    public List<MovieCeleb> getMovies() {
        return movies;
    }

    public void setMovies(List<MovieCeleb> movies) {
        this.movies = movies;
    }

    @Override
    public String toString(){
        return String.format(
                "Celeb[id=%d, first_name=%s, last_name=%s, date_of_birth=%s]",
                id, firstName, lastName, dateOfBirth);
    }

}
