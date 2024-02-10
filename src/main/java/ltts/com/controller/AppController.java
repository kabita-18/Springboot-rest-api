package ltts.com.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ltts.com.exception.ResourceNotFoundException;
import ltts.com.model.Login;
import ltts.com.model.Movies;
import ltts.com.service.MovieService;
import ltts.com.service.MovieServiceException;

@RestController
@RequestMapping("mainapp")
@CrossOrigin

public class AppController {
	@Autowired
	private MovieService service;
	
	
//	@GetMapping("/welcome")
//	public String welcome() {
//		return "Welcome to first spring web Application";
//	}
	
	@PostMapping("/movie/add")
	public String getAddMovies(@RequestBody Movies m) throws ResourceNotFoundException, MovieServiceException
	{
		
		if(service.addMovies(m)) {
			return "Movie added successfully...";
		}
		throw new ResourceNotFoundException("Movie not added..");
	}
	
	@GetMapping("/movie/category/{category}")
	public List<Movies> getMoviesByCatg(@PathVariable("category") String catg)throws ResourceNotFoundException
	{
		List <Movies> m = service.getMovieByCatg(catg);
		if(m != null) {
			return m;
		}
		throw new ResourceNotFoundException("No movies found to fetch");
	}
	
	@PutMapping("movie/update/{mid}")
	public String getUpdateMovies(@PathVariable("mid") int mid, @RequestBody Movies m) throws ResourceNotFoundException
	{
		
		 int ticketprice = m.getTicketprice();
		  Date releasedate = m.getReleasedate();

		    // Call the service method to update the movie
		    int updatedRows = service.getUpdateMovies(mid, ticketprice, releasedate);

		    if (updatedRows >= 1) {
		        System.out.println(mid + " " + ticketprice + " " + releasedate);
		        return "Movies Updated Successfully";
		    }

		    throw new ResourceNotFoundException("Movie Not Exist..." );
	}
	@DeleteMapping("/delete/movie/{category}")
	public String deleteMoviesByCatg(@PathVariable("category") String catg)throws ResourceNotFoundException
	{
		int deletedCount = service.deleteMoviesByCatg(catg);

	    if (deletedCount > 0) {
	        return "Successfully deleted " + deletedCount + " movies for category: " + catg;
	    } 
	    throw new ResourceNotFoundException("No movies found for category:" + catg);
	       
	    
	}
	
	@PostMapping("/login")
	public String getLogin(@RequestBody Login l) throws ResourceNotFoundException
	{
		if(service.getLoginUsers(l)) {
			return "Login successfully...";
		}
		throw new ResourceNotFoundException("login failed");
	}
}
