package ltts.com.JPA;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ltts.com.model.Users;

@Repository
public interface MyUserrepository extends CrudRepository<Users, String> {

    Users findByEmail(String email);
}