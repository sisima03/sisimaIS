package sisima.com.WassimWebApi.ProviderInterface;

import java.util.List;
import java.util.Map;

import sisima.com.WassimWebApi.DTO.EmployeDTO;
import sisima.com.WassimWebApi.Entities.Employe;
import sisima.com.WassimWebApi.Entities.Project;
import sisima.com.WassimWebApi.Entities.ProjectEmploye;

public interface IEmployeProvider {

	public EmployeDTO createEmploye(EmployeDTO emp);
	public EmployeDTO updateEmploye(EmployeDTO emp);
	public EmployeDTO deleteEmploye(Long idEmploye);
	public List<Employe> getAllEmployees();
	public List<Employe> getEmployeesByLastName(String lastName);
	public Map<String, List<Project>> getEmployeProjectsById(Long id);
	
	
	
}
