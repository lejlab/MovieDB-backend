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
			/* testni kod za unos i dohvaćanje
			List<Role> roles = rolesRepository.findAll();
			List<User> users = usersRepository.findAll();

			User U1 = new User("testname", "testpw", "testurl");
			User U2 = new User("testname12344", "testpw1", "testurl11");

			Role R = new Role("roletype124");

			List<User> newUsers = new ArrayList<User>();

			newUsers.add(U1);
			newUsers.add(U2);

			U1.setRole(R);
			U2.setRole(R);

			R.setUsers(newUsers);
			rolesRepository.save(R);

			usersRepository.save(U1);
			usersRepository.save(U2);

			if (roles != null && users != null) {
				users.forEach(user -> {
					user.setRole(roles.get(0));
					usersRepository.save(user);
				});

				roles.get(0).setUsers(users);
				rolesRepository.save(roles.get(0));
			}

			List<User> users = repository.findAll();
			Subscribe S = new Subscribe(users.get(0), users.get(1));

			subscriptionsRepository.save(S);

			List<User> users = usersRepository.findAll();
			Notification N = new Notification("Notifikacija prvog usera iz liste...", users.get(0));
			notificationsRepository.save(N);

			 */


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
