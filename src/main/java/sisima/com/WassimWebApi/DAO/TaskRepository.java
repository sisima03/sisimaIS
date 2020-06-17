package sisima.com.WassimWebApi.DAO;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sisima.com.WassimWebApi.Entities.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{
	
	@Query("select t from Task t where t.title=?")
	public Task getTaskByTitle (String title);

}
