package sisima.com.WassimWebApi.Entities;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyToOne;

@Entity
@Table(name = "Employe")
// @SequenceGenerator(name = "GEN_SEQ_USERAPP", sequenceName = "SEQ_USERAPP", allocationSize = 1)
public class Employe implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="firstName")
	private String firstName;
	@Column
	private String lastName;
	@Column
	private Date birthDate;
	@Column
	private String email;
	
	@OneToMany(mappedBy="employe", fetch= FetchType.LAZY)
	private List<ProjectEmploye> projects;
	
	
	public Employe() {
		
	}
	
	public Employe(Long id, String firstName, String lastName, Date birthDate, String email,
			List<ProjectEmploye> projects) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.email = email;
		this.projects = projects;
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
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
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
		return "Name : ".concat(this.getFirstName().concat(" ").concat(getLastName())).concat(" BirhtDate : ").concat(getBirthDate().toString());
	}
	
	public List<ProjectEmploye> getProjects() {
		return projects;
	}
	public void setProjects(List<ProjectEmploye> projects) {
		this.projects = projects;
	}
	
	
	//private Project project;
}
