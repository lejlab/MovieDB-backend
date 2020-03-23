package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "celeb_jobs")
public class CelebJobs {

    public CelebJobs(Integer id, @NotNull(message = "Job must not be empty.") Job job, @NotNull(message = "Celeb must not be empty.") Celeb celeb) {
        this.id = id;
        this.job = job;
        this.celeb = celeb;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "celeb_job_id")
    private Integer id;

    @NotNull(message = "Job must not be empty.")
    @ManyToOne
    @JsonIgnoreProperties(value = "celeb_jobs", allowSetters = true)
    @JoinColumn(name = "job_id", nullable = false)
    private Job job;

    @NotNull(message = "Celeb must not be empty.")
    @ManyToOne
    @JsonIgnoreProperties(value = "celeb_jobs", allowSetters = true)
    @JoinColumn(name = "celeb_id", nullable = false)
    private Celeb celeb;

    public Integer getId() {
        return id;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Celeb getCeleb() {
        return celeb;
    }

    public void setCeleb(Celeb celeb) {
        this.celeb = celeb;
    }

    @Override
    public String toString(){
        return String.format(
                "CelebJob[id=%d, job_id=%d, movie_id=%d]",
                id, job.getId(), celeb.getId());
    }
}
