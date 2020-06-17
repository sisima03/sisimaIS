package sisima.com.WassimWebApi.DTO;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GeneratorType;


public class EmployeDTO {

	
	private Long id;
	private String firstName;
	private String lastName;
	private String birthDate;
	private String email;
	
	//private List<ProjectEmploye> projects;
	

	public EmployeDTO() {
		
	}
	public EmployeDTO(Long id, String firstName, String lastName, String birthDate, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.email = email;
	}
	
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "DTO ==> Name : ".concat(this.getFirstName().concat(" ").concat(getLastName())).concat(" BirhtDate : ").concat(getBirthDate().toString());
	}
	
	
	//private Project project;
}
