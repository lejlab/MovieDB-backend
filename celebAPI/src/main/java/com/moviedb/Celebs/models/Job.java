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

    public Job(@NotNull(message = "Title must not be empty.") @Size(max = 2, message = "Title must not be longer than 2 characters.") String title) {
        this.title = title;
        celebJobs = new ArrayList<CelebJobs>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_id")
    private Integer id;

    @NotNull(message = "Title must not be empty.")
    @Size(max = 2, message = "Title must not be longer than 2 characters.")
    @Column(name = "title")
    private String title;

    @OneToMany(targetEntity = CelebJobs.class, mappedBy = "job", fetch = FetchType.EAGER)
    @JsonIgnoreProperties(value = "job", allowSetters = true)
    private List<CelebJobs> celebJobs;

    public Integer getId() {
        return id;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public List<CelebJobs> getCeleb_jobs() {
        return celebJobs;
    }

    public void setCeleb_jobs(List<CelebJobs> celeb_jobs) {
        this.celebJobs = celeb_jobs;
    }

    @Override
    public String toString(){
        return String.format(
                "Job[id=%d, title='%s']",
                id, title);
    }
}
