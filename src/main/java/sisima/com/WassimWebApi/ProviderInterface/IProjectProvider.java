package sisima.com.WassimWebApi.ProviderInterface;

import java.util.List;

import sisima.com.WassimWebApi.Entities.Project;

public interface IProjectProvider {
	
	public Project createProject(Project project);
	public Project updateProject(Project project);
	public void deleteProject(Long idProject);
	public List<Project> getAllProjects();

}
