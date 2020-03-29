package com.moviedb.Celebs.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "jobs")
public class Job {
    public Job() {}

    public Job(@NotNull(message = "Title must not be empty.") @Size(min = 2, message = "Title must not be longer than 2 characters.") String title) {
        this.title = title;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_id")
    private Integer id;

    @NotNull(message = "Title must not be empty.")
    @Size(min = 2, message = "Title must be longer than 2 characters.")
    @Column(name = "title")
    private String title;

    @OneToMany(targetEntity = CelebJobs.class, mappedBy = "job", fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = "job", allowSetters = true)
    private List<CelebJobs> celebs;

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<CelebJobs> getCelebs() {
        return celebs;
    }

    public void setCelebs(List<CelebJobs> celebs) {
        this.celebs = celebs;
    }

    @Override
    public String toString(){
        return String.format(
                "Job[id=%d, title='%s']",
                id, title);
    }
}
