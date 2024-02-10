package ltts.com.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Users {
	@Id
	private String uname;
	public Users() {
		super();
	}
	private String email;
	private String pass;
	private String city;
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Users(String uname, String email, String pass, String city) {
		super();
		this.uname = uname;
		this.email = email;
		this.pass = pass;
		this.city = city;
	}
	
}
