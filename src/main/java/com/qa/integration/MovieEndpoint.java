package com.qa.integration;

import javax.inject.Inject;
import javax.websocket.server.PathParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.qa.business.service.IMovieService;

@Path ("/Movie")
public class MovieEndpoint {
	
	@Inject
	private IMovieService service;
	
	@GET
	@Path("/json")
	@Produces ({"application/json"})
	
	public String getAllMovies() {
		
		return service.getAllMovies();
	}
	
	@GET
	@Path("/json/{id}")
	@Produces ({"application/json"})
	
	public String getMovie(@PathParam("id") Long id){
		
		return service.getMovie(id);
	}
	
	@POST
	@Path("/json")
	@Produces ({"application/json"})
	public String creatMovie(String json) {
		return service.createMovie(json);
	}
	
	@DELETE
	@Path("/json/{id}")
	@Produces({ "application/json" })
	public String createMovie(@PathParam("id") Long id) {
		return service.deleteMovie(id);
	}
	
	@Path("/json/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateMovie(@PathParam("id") Long id, String updateMovie) {
		return service.updateMovie(id, updateMovie);

}
	
}



