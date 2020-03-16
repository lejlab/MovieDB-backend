package com.moviedb.Users;
import javax.persistence.*;

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
    private int id;

    @Column(name="username", nullable = false)
    private String username;

    @Column(name="password", nullable = false)
    private String password;

    @Column(name="avatar_url", nullable = false)
    private String avatarUrl;

    public int getId() {
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

    @Override
    public String toString() {
        return String.format(
                "User[id=%d, username='%s', password='%s', avatarUrl='%s']",
                id, username, password, avatarUrl);
    }
}
