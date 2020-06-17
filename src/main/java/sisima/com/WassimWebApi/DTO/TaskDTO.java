package sisima.com.WassimWebApi.DTO;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.context.annotation.Primary;

public class TaskDTO implements Serializable{
	
	
	private Long id;
	private String title;
	private String description;
	private Long priority;
	
	private ProjectDTO project;
	
	
	
	public ProjectDTO getProject() {
		return project;
	}
	public void setProject(ProjectDTO project) {
		this.project = project;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getPriority() {
		return priority;
	}
	public void setPriority(Long priority) {
		this.priority = priority;
	}
	
	
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return "Task DTO : ".concat(this.getTitle()).concat("/ Priority : ").concat(this.getPriority().toString());
    }
}
