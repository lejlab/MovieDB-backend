package com.moviedb.Users.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "subscribe")
public class Subscribe {
    public Subscribe() {}

    public Subscribe(User subscribedUser, User ownerUser){
        this.subscribedUser = subscribedUser;
        this.ownerUser = ownerUser;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subscribe_id")
    private Integer id;

    @NotNull(message = "SubscribedUser must not be empty.")
    @ManyToOne
    @JsonIgnoreProperties(value = "owners", allowSetters = true)
    @JoinColumn(name = "subscribed_user_id")
    private User subscribedUser;

    @NotNull(message = "OwnerUser must not be empty.")
    @ManyToOne
    @JsonIgnoreProperties(value = "subscribers", allowSetters = true)
    @JoinColumn(name = "owner_user_id")
    private User ownerUser;

    public Integer getId() {
        return id;
    }

    public User getSubscribedUser(){
        return subscribedUser;
    }

    public void setSubscribedUser(User subscribedUser){
        this.subscribedUser = subscribedUser;
    }

    public User getOwnerUser(){
        return ownerUser;
    }

    public void setOwnerUser(){
        this.ownerUser = ownerUser;
    }

    @Override
    public String toString(){
        return String.format(
                "Subscribe[id=%d, subscribed_user_id=%d, owner_user_id=%d]",
                id, subscribedUser.getId(), ownerUser.getId()
        );

    }


}
