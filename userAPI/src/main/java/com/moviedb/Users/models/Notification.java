package com.moviedb.Users.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "notifications")
public class Notification {
    public Notification () {}

    public Notification (String message, User ownerUser) {
        this.message = message;
        this.ownerUser = ownerUser;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notification_id")
    private Integer id;

    @ManyToOne
    @JsonIgnoreProperties(value = "notifications", allowSetters = true)
    @JoinColumn(name = "owner_user_id", nullable = false)
    private User ownerUser;

    private String message;

    public Integer getId(){
        return id;
    }

    public User getOwnerUser(){
        return ownerUser;
    }

    public void setOwnerUser(User ownerUser) {
        this.ownerUser = ownerUser;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    @Override
    public String toString(){
        return String.format(
                "Notification[id=%d, message='%s', owner_user_id=%d]",
                id, message, ownerUser.getId()
        );
    }
}
