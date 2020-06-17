package sisima.com.WassimWebApi.Provider;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sisima.com.WassimWebApi.DAO.ProjectRepository;
import sisima.com.WassimWebApi.Entities.Project;
import sisima.com.WassimWebApi.ProviderInterface.IProjectProvider;

@Service
public class ProjectProviderImp implements IProjectProvider{

	@Autowired
	private ProjectRepository projectRepo;
	
	@Override
	public List<Project> getAllProjects() {
		// TODO Auto-generated method stub
		List<Project> listeEmp = new ArrayList<Project>();
		listeEmp =  (List<Project>) projectRepo.findAll();
		return listeEmp;
	}

	@Override
	public Project createProject(Project emp) {
		
		return (emp.getId() == null) ? projectRepo.save(emp) : new Project();
	}

	@Override
	public Project updateProject(Project emp) {
		
		return (emp.getId() != null) ? projectRepo.save(emp) : new Project();
	}

	@Override
	public void deleteProject(Long idProject) {
		
		Optional<Project> Opt_project =  projectRepo.findById(idProject);
		Project project = Opt_project.get();
		projectRepo.delete(project);
	}

}


