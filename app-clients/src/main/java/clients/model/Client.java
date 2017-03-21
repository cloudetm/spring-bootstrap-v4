package clients.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="t_clients")
public class Client implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String first_name;
	private String last_name;
	private String email;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;
	
	public Client(){}
	
	public Client(String first_name, String last_name, String email, Date dateCreated) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.dateCreated = dateCreated;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	@Override
	public String toString() {
		return "Clients [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", email=" + email
				+ ", dateCreated=" + dateCreated + "]";
	}

	
}
