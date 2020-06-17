package sisima.com.WassimWebApi.DAO;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import sisima.com.WassimWebApi.DAO.hql.EmployeHql;
import sisima.com.WassimWebApi.Entities.ProjectEmploye;

public interface ProjectEmployeRepository extends JpaRepository<ProjectEmploye, Long> {

	
//	@Query(EmployeHql.getProjectsByIdEmploye)
//	public List<ProjectEmploye> getProjectEmployeByIdEmploye(Long EmployeId);
}
