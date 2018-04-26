package com.qa.business.service;

public interface IMovieService {
	
	String getAllMovies();
	String getMovie(Long id);
	
	String createMovie (String jsonMovie);
	
	String deleteMovie(Long id);

	String updateMovie (Long id, String updateMovie);
}
