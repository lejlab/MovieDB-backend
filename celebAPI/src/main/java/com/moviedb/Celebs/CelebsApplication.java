package com.moviedb.Celebs;

import com.moviedb.Celebs.models.Celeb;
import com.moviedb.Celebs.models.CelebJobs;
import com.moviedb.Celebs.models.Job;
import com.moviedb.Celebs.models.MovieCeleb;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.moviedb.Celebs.repositories.CelebJobsRepository;
import com.moviedb.Celebs.repositories.CelebsRepository;
import com.moviedb.Celebs.repositories.JobsRepository;
import com.moviedb.Celebs.repositories.MovieCelebsRepository;

@SpringBootApplication
public class CelebsApplication {
	private static final Logger log = LoggerFactory.getLogger(CelebsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CelebsApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CelebsRepository celebsRepository, JobsRepository jobsRepository, CelebJobsRepository celebJobsRepository, MovieCelebsRepository movieCelebsRepository) {
		return (args) -> {
			log.info("Dohvatanje svih redova celebs: ");
			for (Celeb celeb : celebsRepository.findAll()) {
				log.info(celeb.toString());
			}

			log.info("Dohvatanje svih jobs: ");
			for (Job job : jobsRepository.findAll()) {
				log.info(job.toString());
			}

			log.info("Dohvatanje svih celeb_jobs: ");
			for (CelebJobs celebJobs : celebJobsRepository.findAll()) {
				log.info(celebJobs.toString());
			}

			log.info("Dohvatanje svih movie_celebs: ");
			for (MovieCeleb movieCeleb : movieCelebsRepository.findAll()) {
				log.info(movieCeleb.toString());
			}
		};
	}

}
