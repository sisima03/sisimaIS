package sisima.com.WassimWebApi.Entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class TaskAffectation implements Serializable {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="projectEmploye_id")
	private ProjectEmploye projectEmploye;
	
	@ManyToOne
	@JoinColumn(name="task_id")
	private Task task;
	
	private Long isClosed; 
	private Date dateAffectation;
	private Date dateClose;
}
