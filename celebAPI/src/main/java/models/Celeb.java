package models;

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

    public Celeb(@NotNull(message = "First name must not be empty.") @Size(max = 2, message = "First name must not be longer than 30 characters.") String first_name, @NotNull(message = "Last name must not be empty.") @Size(max = 2, message = "Last name must not be longer than 30 characters.") String last_name, @NotNull(message = "Date of birst must not be empty.") Date date_of_birth) {
        this.firstName = first_name;
        this.lastName = last_name;
        this.dateOfBirth = date_of_birth;
        celebJobs = new ArrayList<CelebJobs>();
        movieCelebs = new ArrayList<MovieCeleb>();
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

    @NotNull(message = "Date of birst must not be empty.")
    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @OneToMany(targetEntity = CelebJobs.class, mappedBy = "celeb", fetch = FetchType.EAGER)
    @JsonIgnoreProperties(value = "celeb", allowSetters = true)
    private List<CelebJobs> celebJobs;

    @OneToMany(targetEntity = CelebJobs.class, mappedBy = "celeb", fetch = FetchType.EAGER)
    @JsonIgnoreProperties(value = "celeb", allowSetters = true)
    private List<MovieCeleb> movieCelebs;

    public Integer getId() {
        return id;
    }

    public String getFirst_name() {
        return firstName;
    }

    public void setFirst_name(String first_name) {
        this.firstName = first_name;
    }

    public String getLast_name() {
        return lastName;
    }

    public void setLast_name(String last_name) {
        this.lastName = last_name;
    }

    public Date getDate_of_birth() {
        return dateOfBirth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.dateOfBirth = date_of_birth;
    }

    public List<CelebJobs> getCeleb_jobs() {
        return celebJobs;
    }

    public void setCeleb_jobs(List<CelebJobs> celeb_jobs) {
        this.celebJobs = celeb_jobs;
    }

    public List<MovieCeleb> getMovie_celebs() {
        return movieCelebs;
    }

    public void setMovie_celebs(List<MovieCeleb> movie_celebs) {
        this.movieCelebs = movie_celebs;
    }

    @Override
    public String toString(){
        return String.format(
                "Celeb[id=%d, first_name=%s, last_name=%s, date_of_birth=%c]",
                id, firstName, lastName, dateOfBirth);
    }

}
