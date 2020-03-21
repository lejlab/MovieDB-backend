package com.moviedb.Users;

import com.moviedb.Users.models.*;
import com.moviedb.Users.repositories.NotificationsRepository;
import com.moviedb.Users.repositories.SubscriptionsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.moviedb.Users.models.Role;
import com.moviedb.Users.repositories.UsersRepository;
import com.moviedb.Users.repositories.RolesRepository;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class UsersApplication {
	private static final Logger log = LoggerFactory.getLogger(UsersApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(UsersApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(UsersRepository usersRepository, RolesRepository rolesRepository, SubscriptionsRepository subscriptionsRepository, NotificationsRepository notificationsRepository) {
		return (args) -> {
			log.info("Dohvatanje svih redova users: ");
			for (User user : usersRepository.findAll()) {
				log.info(user.toString());
			}

			log.info("Dohvatanje svih roles: ");
			for (Role role : rolesRepository.findAll()) {
				log.info(role.toString());
			}

			log.info("Dohvatanje svih subscriptions: ");
			for (Subscribe subscribe : subscriptionsRepository.findAll()) {
				log.info(subscribe.toString());
			}

			log.info("Dohvatanje svih notifications: ");
			for (Notification notification : notificationsRepository.findAll()) {
				log.info(notification.toString());
			}
		};
	}

}
