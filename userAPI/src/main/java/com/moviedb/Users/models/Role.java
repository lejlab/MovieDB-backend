package com.moviedb.Users.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "roles")
public class Role {
    public Role(){}

    public Role(String type){
        this.type = type;
        users = new ArrayList<User>();
    }

    public Role(String type, List<User> users){
        this.users = users;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Integer id;

    @NotNull(message = "Type must not be empty.")
    @Size(max = 30, message = "Type must not be longer than 30 characters.")
    @Column(name = "type")
    private String type;

    @OneToMany(targetEntity = User.class, mappedBy = "role", fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = "role", allowSetters = true)
    private List<User> users;

    public Integer getId() {
        return id;
    }

    public String getType(){
        return type;
    }

    public void setType(String type){
        this.type = type;
    }

    public List<User> getUsers(){
        return users;
    }

    public void setUsers(List<User> users){
        this.users = users;
    }

    public void addUser(User user){
        users.add(user);
    }

    @Override
    public String toString(){
        return String.format(
                "Role[id=%d, type='%s']",
                id, type);
    }
}
