package sisima.com.WassimWebApi.DAO;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sisima.com.WassimWebApi.DAO.hql.EmployeHql;
import sisima.com.WassimWebApi.Entities.Project;
import sisima.com.WassimWebApi.Entities.ProjectEmploye;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>{
	
//	@Query("select t from Task t where t.title=?")
//	public Task getPrpjectByTitle (String title);

//	@Query(EmployeHql.getProjectsByEmployeId)
//	public List<ProjectEmploye> listEmployeProjectsById(Long id);

}
