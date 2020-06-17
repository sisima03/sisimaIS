package sisima.com.WassimWebApi.DTO;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

public class ProjectDTO implements Serializable{


	private Long id;
	private String Name;
	private String description;
	private String clientName;
	private String status;
	
	private Set<TaskDTO> tasks;
	//private Set<ProjectEmploye> employes;
	
	
	
	public Long getId() {
		return id;
	}
	public Set<TaskDTO> getTasks() {
		return tasks;
	}
	public void setTasks(Set<TaskDTO> tasks) {
		this.tasks = tasks;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Project DTO ==>  Title : ".concat(this.getName());
	}
	
	
}
