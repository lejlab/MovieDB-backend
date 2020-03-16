package com.moviedb.Users;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class UsersApplication {
	private static final Logger log = LoggerFactory.getLogger(UsersApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(UsersApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(UsersRepository repository) {
		return (args) -> {
			//repository.save(new User("mnedic", "12313", "dummy"));
			//repository.save(new User("ppejovic", "2121", "dummy12"));
			//repository.save(new User("agobeljic", "3131", "dummy345"));

			log.info("Dohvatanje svih redova: ");
			for (User user : repository.findAll()) {
				log.info(user.toString());
			}

			log.info("Pretraga po imenu: ");
			log.info(repository.findByUsername("mnedic").toString());
		};
	}

}
