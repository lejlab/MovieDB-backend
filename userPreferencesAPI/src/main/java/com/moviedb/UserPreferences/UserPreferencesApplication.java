package com.moviedb.UserPreferences;

import com.moviedb.UserPreferences.models.Comment;
import com.moviedb.UserPreferences.models.Review;
import com.moviedb.UserPreferences.models.Watchlist;
import com.moviedb.UserPreferences.reviews.CommentsRepository;
import com.moviedb.UserPreferences.reviews.ReviewsRepository;
import com.moviedb.UserPreferences.reviews.WatchlistsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class UserPreferencesApplication {
	private static final Logger log = LoggerFactory.getLogger(UserPreferencesApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(UserPreferencesApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CommentsRepository commentsRepository, WatchlistsRepository watchlistsRepository, ReviewsRepository reviewsRepository){
		return (args) -> {
			log.info("Dohvatanje svih redova comments: ");

			for (Comment comment : commentsRepository.findAll()) {
				log.info(comment.toString());
			}

			log.info("Dohvatanje svih redova watchlists: ");

			for (Watchlist watchlist : watchlistsRepository.findAll()) {
				log.info(watchlist.toString());
			}

			log.info("Dohvatanje svih redova reviews: ");

			for (Review review : reviewsRepository.findAll()) {
				log.info(review.toString());
			}
		};
	}

}
