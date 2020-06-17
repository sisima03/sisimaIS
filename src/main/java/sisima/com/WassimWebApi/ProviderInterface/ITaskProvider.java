package sisima.com.WassimWebApi.ProviderInterface;

import java.util.List;

import sisima.com.WassimWebApi.Entities.Task;

public interface ITaskProvider {
	
	public Task createTask(Task task);
	public Task updateTask(Task task);
	public void deleteTask(Long idTask);
	public List<Task> getAllTasks();
	

}
