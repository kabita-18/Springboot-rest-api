package ltts.com.service;

import java.util.Date;
import java.util.List;

import ltts.com.model.Login;
import ltts.com.model.Movies;

public interface MovieService {

	public boolean addMovies(Movies m) throws MovieServiceException;

	public List<Movies> getMovieByCatg(String catg);

	public int getUpdateMovies(int mid, int ticketprice, Date releasedate);

	public int deleteMoviesByCatg(String catg);

	public boolean getLoginUsers(Login l);



}
