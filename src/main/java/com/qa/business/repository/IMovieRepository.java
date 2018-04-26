package com.qa.business.repository;

public interface IMovieRepository {
	
	String getAllMovies();

	String getMovie(Long id);
	
	String createMovie (String movieJSON);
	
	String deleteMovie(Long id);

	String updateMovie(Long id, String updateMovie);
}


