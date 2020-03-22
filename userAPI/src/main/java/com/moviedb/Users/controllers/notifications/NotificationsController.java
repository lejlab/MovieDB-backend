package com.moviedb.Users.controllers.notifications;

import com.moviedb.Users.controllers.notifications.exceptions.NotificationNotFoundByOwnerIdException;
import com.moviedb.Users.controllers.notifications.exceptions.NotificationNotFoundException;
import com.moviedb.Users.models.Notification;
import com.moviedb.Users.repositories.NotificationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NotificationsController {
    @Autowired
    NotificationsRepository notificationsRepository;

    @GetMapping("/notifications")
    public List<Notification> find(){
        return notificationsRepository.findAll();
    }

    @PostMapping("/notifications")
    public Notification newNotification(@RequestBody Notification newNotification) {
        return notificationsRepository.save(newNotification);
    }

    @DeleteMapping("/notifications/{id}")
    public void deleteNotification(@PathVariable Integer id){ notificationsRepository.deleteById(id); }

    @GetMapping("/notifications/{id}")
    public Object findById(@PathVariable("id") Integer id){
        return notificationsRepository.findById(id).orElseThrow(() -> new NotificationNotFoundException(id));
    }

    @GetMapping("/notifications/identification/{id}")
    public Object findByOwnerUserId(@PathVariable("id") Integer id){
        return notificationsRepository.findByOwnerUserId(id).orElseThrow(() -> new NotificationNotFoundByOwnerIdException(id));
    }
}
