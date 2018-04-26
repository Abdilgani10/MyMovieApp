package com.qa.business.service;

import javax.inject.Inject;

import com.qa.business.repository.IMovieRepository;

public class MovieService implements IMovieService {
	
	@Inject
	private IMovieRepository repo;

	
	public String getAllMovies() {
		
		return repo.getAllMovies();
	}
	
	public String getMovie(Long id) {
		
		return repo.getMovie(id);
	}
	
	public String createMovie (String jsonMovie) {
		
		return repo.createMovie(jsonMovie);
	}
	
	public String deleteMovie(Long id) {
		return repo.deleteMovie(id);
	}

}
	
	