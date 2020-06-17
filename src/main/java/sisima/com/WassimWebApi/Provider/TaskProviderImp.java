package sisima.com.WassimWebApi.Provider;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sisima.com.WassimWebApi.DAO.TaskRepository;
import sisima.com.WassimWebApi.Entities.Task;
import sisima.com.WassimWebApi.ProviderInterface.ITaskProvider;

@Service
public class TaskProviderImp implements ITaskProvider{

	@Autowired
	private TaskRepository taskRepo;
	
	@Override
	public List<Task> getAllTasks() {
		// TODO Auto-generated method stub
		List<Task> listeTasks = new ArrayList<Task>();
		listeTasks =  (List<Task>) taskRepo.findAll();
		return listeTasks;
	}

	@Override
	public Task createTask(Task task) {
		
		return (task.getId() == null) ? taskRepo.save(task) : new Task();
	}

	@Override
	public Task updateTask(Task task) {
		
		return (task.getId() != null) ? taskRepo.save(task) : new Task();
	}

	@Override
	public void deleteTask(Long idTask) {
		
		Optional<Task> Opt_emp =  taskRepo.findById(idTask);
		Task emp = Opt_emp.get();
		taskRepo.delete(emp);
	}

}



