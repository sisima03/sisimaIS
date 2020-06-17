package sisima.com.WassimWebApi.Provider;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import sisima.com.WassimWebApi.DAO.EmployeRepository;
import sisima.com.WassimWebApi.DAO.ProjectEmployeRepository;
import sisima.com.WassimWebApi.DAO.ProjectRepository;
import sisima.com.WassimWebApi.DTO.EmployeDTO;
import sisima.com.WassimWebApi.Entities.Employe;
import sisima.com.WassimWebApi.Entities.Project;
import sisima.com.WassimWebApi.Entities.ProjectEmploye;
import sisima.com.WassimWebApi.Mapper.EmployeMapper;
import sisima.com.WassimWebApi.ProviderInterface.IEmployeProvider;

@Service
public class EmployeProviderImp implements IEmployeProvider{

	@Autowired
	private EmployeRepository empRepo;
	
	@Autowired
	private ProjectEmployeRepository projectEmployeRepo;
	
	@Autowired
	private ProjectRepository projectRepo;
	
	@Override
	public List<Employe> getAllEmployees() {
		// TODO Auto-generated method stub
		List<Employe> listeEmp = new ArrayList<Employe>();
		listeEmp =  (List<Employe>) empRepo.findAll();
		return listeEmp;
	}

	@Override
	public EmployeDTO createEmploye(EmployeDTO dto) {
		
		Employe employe = new Employe();
		
		employe = EmployeMapper.mapObjetToData(dto);		
//		employe = (employe.getId() == null) ? empRepo.save(employe) : new Employe();
		
		Employe ret_employe = new Employe();
		ret_employe = empRepo.save(employe);
		return (ret_employe != null) ? EmployeMapper.mapDataToObject(ret_employe) : new EmployeDTO();
	}

	@Override
	public EmployeDTO updateEmploye(EmployeDTO dto) {
		
		Employe employe = new Employe();
		Employe empToUpdate = (Employe) empRepo.findById(dto.getId()).get();

		
		employe = (empToUpdate != null) ? EmployeMapper.mapObjetToData(dto) : new Employe();
		employe = (employe != null) ? empRepo.save(employe) : new Employe();
		
		return (employe != null) ? EmployeMapper.mapDataToObject(employe) : new EmployeDTO();
	}

	@Override
	public EmployeDTO deleteEmploye(Long idEmploye) {
		
		Optional<Employe> Opt_emp =  empRepo.findById(idEmploye);
		Employe emp = Opt_emp.get();
		
		if (emp != null) 
			empRepo.delete(emp);
		
		return (emp != null) ? EmployeMapper.mapDataToObject(emp) : new EmployeDTO();
		
	}

	@Override
	public List<Employe> getEmployeesByLastName(String lastName) {
		
		return empRepo.getEmployeByLastName(lastName);
	}

	@Override
	public Map<String, List<Project>> getEmployeProjectsById(Long id) {
		// TODO Auto-generated method stub
		List<Employe> listeEmploye = empRepo.findProjectsById(id);
		Map<String, List<Project>> projects = new HashMap<String, List<Project>>();
		listeEmploye.forEach(employe -> {
			List<Project> employeProjects = new ArrayList<Project>();
			for(ProjectEmploye pe : employe.getProjects()) {
				
				employeProjects.add(pe.getProject());
			}
			
			projects.put(employe.getLastName(), employeProjects);
		});
		
		return projects;
		 
		
	}
}


