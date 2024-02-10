package ltts.com.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ltts.com.DAO.MovieDAO;
import ltts.com.model.Login;
import ltts.com.model.Movies;

@Service
public class MovieServiceImpl implements MovieService{
	
	@Autowired
	private MovieDAO movieDAO;
	
	public boolean addMovies(Movies m) throws MovieServiceException
	{
		if(m.getTicketprice()<100) throw new MovieServiceException("ticketprice should be greater than 1");
		return movieDAO.addMovies(m);
	}
	
	public List<Movies> getMovieByCatg(String catg){
		return movieDAO.getMovieByCatg(catg);
	}
	
	public int getUpdateMovies(int mid, int ticketprice, Date releasedate) {
		return movieDAO.getUpdateMovies(mid, ticketprice, releasedate);
	}
	
	public int deleteMoviesByCatg(String catg){
		return movieDAO.deleteMoviesByCatg(catg);
	}
	
	public boolean getLoginUsers(Login l) {
		return movieDAO.getloginUsers(l);
	}

}
