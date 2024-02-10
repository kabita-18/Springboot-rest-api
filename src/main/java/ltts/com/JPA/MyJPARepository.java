package ltts.com.JPA;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ltts.com.model.Movies;
import ltts.com.model.Users;


@Repository
public interface MyJPARepository extends CrudRepository<Movies,String>{

	List<Movies> findAllByCategoryLike(String cat);
	@Modifying
	@Query("update Movies m set m.ticketprice=:ticketprice, m.releasedate=:releasedate where m.mid =:mid")

	int getUpdate(@Param("mid") int mid, @Param("ticketprice")int ticketprice,@Param("releasedate")Date releasedate);
	int deleteAllByCategory(String catg);
	List<Movies> findAllByCategory(String catg);
   
	

	
}
