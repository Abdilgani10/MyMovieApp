package com.qa.business.service;

import javax.inject.Inject;

import com.qa.business.repository.IMovieRepository;

public class MovieService implements IMovieService {
	
	@Inject
	private IMovieRepository repo;

	
	public String getAllMovies() {
		// TODO Auto-generated method stub
		return repo.getAllMovies();
	}}
	
	