package com.moviedb.Movies;

import com.moviedb.Movies.models.Genre;
import com.moviedb.Movies.models.GenreMovie;
import com.moviedb.Movies.models.Movie;
import com.moviedb.Movies.repositories.GenreMoviesRepository;
import com.moviedb.Movies.repositories.GenresRepository;
import com.moviedb.Movies.repositories.MoviesRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Date;

@SpringBootApplication
public class MoviesApplication {
	private static final Logger log = LoggerFactory.getLogger(MoviesApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(MoviesApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(MoviesRepository moviesRepository, GenresRepository genresRepository, GenreMoviesRepository genreMoviesRepository) {

		return (args) -> {
			log.info("Dohvatanje svih redova movies: ");
			for (Movie movie : moviesRepository.findAll()) {
				log.info(movie.toString());
			}

			log.info("Dohvatanje svih redova genreMovies: ");
			for (GenreMovie genreMovie : genreMoviesRepository.findAll()) {
				log.info(genreMovie.toString());
			}

			log.info("Dohvatanje svih genres: ");
			for (Genre genre : genresRepository.findAll()) {
				log.info(genre.toString());
			}
		};
	}

}
