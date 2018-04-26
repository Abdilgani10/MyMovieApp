package com.qa.business.repository;

import javax.persistence.Query;

import java.util.Collection;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import com.qa.persistence.domain.Movie;
import com.qa.util.JSONUtil;

public class MovieDBRepository implements IMovieRepository {
	
	private static final Logger LOGGER = Logger.getLogger(MovieDBRepository.class); 
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager; 
	
	@Inject
	private JSONUtil util;
	
	public String getAllMovies() {
		
		LOGGER.info("MovieDBRepository getAllMovies" );
		
		Query query = manager.createQuery("Select m FROM Movie m");
		Collection<Movie> movies = (Collection<Movie>) query.getResultList();
		

		return util.getJSONForObject(movies);
	}

	public String getMovie(Long id) {
		
		Movie aMovie = findMovie(id);
		
		if (aMovie != null) {
			
			return util.getJSONForObject(aMovie);
		}
		else {
			
			return "{\"massage\":\"movie not found\"}";
		}
		
	}

	private Movie findMovie(Long id) {
		return manager.find(Movie.class, id);
	}

}
