package ltts.com.model;

import java.util.Date;

import javax.validation.constraints.Min;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@SequenceGenerator(name="port_gen", sequenceName = "port_gen", initialValue = 1000)
public class Movies {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "port_gen")
	private int mid;
	@Column(unique=true, nullable = false)
	private String mname;
	@Column(length= 30)
	private String category;
	@Min(value = 1, message ="value must be greater than 1")
	
//	@Column(updatable = false)
	private int ticketprice;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(name="releasedate")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date releasedate = new Date();
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getTicketprice() {
		return ticketprice;
	}
	public void setTicketprice(int ticketprice) {
		this.ticketprice = ticketprice;
	}
	public Date getReleasedate() {
		return releasedate;
	}
	public void setReleasedate(Date releasedate) {
		this.releasedate = releasedate;
	}
	@Override
	public String toString() {
		return "Movies [mid=" + mid + ", mname=" + mname + ", category=" + category + ", ticketprice=" + ticketprice
				+ ", releasedate=" + releasedate + "]";
	}
	public Movies(int mid, String mname, String category, int ticketprice, Date releasedate) {
		super();
		this.mid = mid;
		this.mname = mname;
		this.category = category;
		this.ticketprice = ticketprice;
		this.releasedate = releasedate;
	}
	public Movies() {
		super();
	}
	

}
