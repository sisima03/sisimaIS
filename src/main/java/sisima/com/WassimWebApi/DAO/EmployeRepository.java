package sisima.com.WassimWebApi.DAO;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

import sisima.com.WassimWebApi.Entities.Employe;
import sisima.com.WassimWebApi.Entities.Project;
import sisima.com.WassimWebApi.Entities.ProjectEmploye;
import sisima.com.WassimWebApi.Entities.Task;
import sisima.com.WassimWebApi.DAO.hql.*;

@Repository
public interface EmployeRepository extends JpaRepository<Employe, Long> {

	@Query(EmployeHql.getEmployeByLastName)
	public List<Employe> getEmployeByLastName (String lastName);
	
	@Query(EmployeHql.getProjectsByIdEmploye)
	public List<Employe> findProjectsById (Long idEmploye);

}