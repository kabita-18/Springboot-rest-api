package ltts.com.DAO;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import ltts.com.JPA.MyJPARepository;
import ltts.com.JPA.MyUserrepository;
import ltts.com.model.Login;
import ltts.com.model.Users;
import ltts.com.model.Movies;
@Repository

public class MovieDAOImpl implements MovieDAO{
	@Autowired
	private MyJPARepository myRepo;
	
	@Autowired
	private MyUserrepository myRepo1;
	
	public boolean addMovies(Movies m ){
		if(myRepo.save(m)!= null) return true;
		return false;
	}
	
	public List<Movies> getMovieByCatg(String catg){
		String cat = "%" + catg + "%";
		List<Movies>getData=myRepo.findAllByCategoryLike(cat);
		if(getData.size()>0) {
			System.out.println("movie found");
			return getData;
		}
		return null;
	}
	
	@Override
	@Transactional
	public int getUpdateMovies(int mid, int ticketprice, Date releasedate) {

		return  myRepo.getUpdate(mid, ticketprice, releasedate);
		
	}
	
	@Transactional
	public int deleteMoviesByCatg(String catg){
		List<Movies> moviesList = myRepo.findAllByCategory(catg);

	    if (!moviesList.isEmpty()) {
	        myRepo.deleteAllByCategory(catg);
	        return moviesList.size();
	    }
		return 0;
	}
	

	@Override
	public boolean getloginUsers(Login l) {
		// TODO Auto-generated method stub
		Users user = myRepo1.findByEmail(l.getEmail());
		
		if(user != null && user.getPass().equals(l.getPassword())) {
			 return true;
		}
		
		return false;
	}
}
