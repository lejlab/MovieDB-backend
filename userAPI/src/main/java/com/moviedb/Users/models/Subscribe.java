package com.moviedb.Users.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

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

    @ManyToOne
    @JsonIgnoreProperties(value = "owners", allowSetters = true)
    @JoinColumn(name = "subscribed_user_id", nullable = false)
    private User subscribedUser;

    @ManyToOne
    @JsonIgnoreProperties(value = "subscribers", allowSetters = true)
    @JoinColumn(name = "owner_user_id", nullable = false)
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
