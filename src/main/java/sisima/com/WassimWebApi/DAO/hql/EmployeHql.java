package sisima.com.WassimWebApi.DAO.hql;

public class EmployeHql {

	public static final String getEmployeByLastName = "from Employe e Where e.lastName = ?1";
	
	public static final String getProjectsByIdEmploye = " from Employe e join fetch ProjectEmploye pe on e.id = pe.employe.id where pe.employe.id=?1 ";
	
}
