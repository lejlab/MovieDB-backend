package com.moviedb.Users.models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.aspectj.weaver.ast.Not;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name ="users")
public class User {
    public User(){}

    public User(String username, String password, String avatarUrl){
        this.username = username;
        this.password = password;
        this.avatarUrl = avatarUrl;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer id;

    @NotNull(message = "Username must not be empty.")
    @Size(max = 50, message = "Username must not be longer than 50 characters.")
    @Column(name="username")
    private String username;

    @NotNull(message = "Password must not be empty.")
    @Size(max = 100, message = "Password must not be longer than 100 characters.")
    @Column(name="password")
    private String password;

    @NotNull(message = "AvatarUrl must not be empty.")
    @Size(max = 200, message = "AvatarUrl must not be longer than 200 characters.")
    @Column(name="avatar_url")
    private String avatarUrl;

    @ManyToOne
    @JsonIgnoreProperties(value = "users", allowSetters = true)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @OneToMany(targetEntity = Subscribe.class, mappedBy = "ownerUser", fetch = FetchType.EAGER,  cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = "ownerUser", allowSetters = true)
    private List<Subscribe> subscribers;

    @OneToMany(targetEntity = Subscribe.class, mappedBy = "subscribedUser", fetch = FetchType.EAGER,  cascade = CascadeType.ALL)
    @Fetch(value = FetchMode.SUBSELECT)
    @JsonIgnoreProperties(value = "subscribedUser", allowSetters = true)
    private List<Subscribe> owners;

    @OneToMany(targetEntity = Notification.class, mappedBy = "ownerUser", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Fetch(value = FetchMode.SUBSELECT)
    @JsonIgnoreProperties(value = "ownerUser", allowSetters = true)
    private List<Notification> notifications;

    public Integer getId() {
        return id;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getAvatarUrl(){
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl){
        this.avatarUrl = avatarUrl;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role){
        this.role = role;
    }

    public List<Subscribe> getOwners() {
        return owners;
    }

    public void setOwners(List<Subscribe> owners) {
        this.owners = owners;
    }

    public List<Subscribe> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(List<Subscribe> subscribers) {
        this.subscribers = subscribers;
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }

    @Override
    public String toString() {
        Integer roleId = 0;
        if (role != null) {
            roleId = role.getId();
        }
        return String.format(
                "User[id=%d, username='%s', password='%s', avatarUrl='%s', roleId=%d]",
                id, username, password, avatarUrl, roleId);
    }
}
