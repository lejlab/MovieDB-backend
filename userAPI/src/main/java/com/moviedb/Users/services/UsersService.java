package com.moviedb.Users.services;

import com.moviedb.Users.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.moviedb.Users.models.User;
import java.util.List;
import java.util.Optional;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;

    public List<User> getAllUsers() {
        return usersRepository.findAll();
    }

    public User addNewUser(User user) {
        return usersRepository.save(user);
    }

    public void removeOne(Integer id) {
        usersRepository.deleteById(id);
    }

    public Optional<User> getOneById(Integer id) {
        return usersRepository.findById(id);
    }

    public Optional<User> getOneByUsername(String username) {
        return usersRepository.findByUsername(username);
    }

    public User editOne(User newData, Integer id) {
        return usersRepository.findById(id)
                .map(user -> {
                    user.setUsername(newData.getUsername());
                    user.setPassword(newData.getPassword());
                    user.setAvatarUrl(newData.getAvatarUrl());
                    user.setRole(newData.getRole());
                    user.setSubscribers(newData.getSubscribers());
                    user.setOwners(newData.getOwners());
                    user.setNotifications(newData.getNotifications());
                    return usersRepository.save(user);
                }).orElseGet(() -> usersRepository.save(newData));
    }

    public Optional<User> changePassword(Integer id, String password) {
        return usersRepository.findById(id).map(user -> {
            user.setPassword(password);
            return usersRepository.save(user);
        });
    }

    public Optional<User> changeAvatar(Integer id, String avatarUrl) {
        return usersRepository.findById(id).map(user -> {
            user.setAvatarUrl(avatarUrl);
            return usersRepository.save(user);
        });
    }
}
