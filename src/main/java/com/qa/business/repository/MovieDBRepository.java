package com.qa.business.repository;

import javax.persistence.Query;
import javax.transaction.Transactional;

import java.util.Collection;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import com.qa.persistence.domain.Movie;
import com.qa.util.JSONUtil;
import static javax.transaction.Transactional.TxType.REQUIRED;

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
	


	@Transactional(REQUIRED)
	public String createMovie(String movieJSON) {
		Movie aMovie = util.getObjectForJSON(movieJSON, Movie.class);
		manager.persist(aMovie);
		return "{\"massage\":\"movie created\"}";
	} 
	
	
	
	
	public String deleteMovie(Long id) {
		Movie movie = findMovie(id);
		if (movie != null) {
			manager.remove(movie);
			return "{\"message\":\"movie successfully deleted\"}";
		} else {
			return "{\"massage\":\"movie was not found\"}";
		}
			
		}
		
		@Transactional(REQUIRED)
		public String updateMovie(Long id, String updateMovie) {
			Movie updatedMovie = util.getObjectForJSON(updateMovie, Movie.class);
			Movie MovieInDB = findMovie(id);
			if (MovieInDB != null) {
				MovieInDB = updatedMovie;
				manager.merge(MovieInDB);
				return "{\"message\": \"Movie sucessfully updated.\"}";
			}else {
				return "{\"message\": \"Movie not Found.\"}";
			}
}
	
}


