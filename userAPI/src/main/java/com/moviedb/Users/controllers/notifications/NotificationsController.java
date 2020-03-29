package com.moviedb.Users.controllers.notifications;

import com.moviedb.Users.controllers.notifications.exceptions.NotificationNotFoundByOwnerIdException;
import com.moviedb.Users.controllers.notifications.exceptions.NotificationNotFoundException;
import com.moviedb.Users.models.Notification;
import com.moviedb.Users.repositories.NotificationsRepository;
import com.moviedb.Users.services.NotificationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NotificationsController {
    @Autowired
    NotificationsService notificationsService;

    @GetMapping("/notifications")
    public List<Notification> getAllNotifications(){
        return notificationsService.getAllNotifications();
    }

    @PostMapping("/notifications")
    public Notification addNewNotification(@RequestBody Notification newNotification) {
        return notificationsService.addNewNotification(newNotification);
    }

    @DeleteMapping("/notifications/{id}")
    public void removeOne(@PathVariable Integer id){ notificationsService.removeOne(id); }

    @GetMapping("/notifications/{id}")
    public Object findById(@PathVariable("id") Integer id){
        return notificationsService.getOneById(id).orElseThrow(() -> new NotificationNotFoundException(id));
    }

    @GetMapping("/notifications/identification/{id}")
    public Object findByOwnerUserId(@PathVariable("id") Integer id){
        return notificationsService.getOneByOwnerUserId(id).orElseThrow(() -> new NotificationNotFoundByOwnerIdException(id));
    }
}
