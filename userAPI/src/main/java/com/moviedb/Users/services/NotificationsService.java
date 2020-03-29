package com.moviedb.Users.services;

import com.moviedb.Users.models.Notification;
import com.moviedb.Users.repositories.NotificationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationsService {
    @Autowired
    private NotificationsRepository notificationsRepository;

    public List<Notification> getAllNotifications() {
        return notificationsRepository.findAll();
    }

    public Notification addNewNotification(Notification notification) {
        return notificationsRepository.save(notification);
    }

    public Optional<Notification> getOneById(Integer id) {
        return notificationsRepository.findById(id);
    }

    public Optional<List<Notification>> getOneByOwnerUserId(Integer id) {
        return notificationsRepository.findByOwnerUserId(id);
    }

    public void removeOne(Integer id) {
        notificationsRepository.deleteById(id);
    }
}
