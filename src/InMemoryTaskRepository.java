import java.util.HashMap;
import java.util.Map;

public class InMemoryTaskRepository implements ITaskRepository{
    private Map<Integer,Task> tasks = new HashMap<>();

    @Override
    public void addTask(Task task) {
        tasks.put(task.getId(), task);
    }
    @Override
    public Task getTaskById(int id){
        return tasks.get(id);
    }
    @Override
    public void updateTask(Task task){
        tasks.put(task.getId(),task);
    }

    public void deleteTask(int id){
        tasks.remove(id);
    }

    public Map<Integer,Task> getTasks() {
        return tasks;
    }

    public static class  ConsoleNotificationService implements INotificationService{
        public void sendNotification(String message){
            System.out.println("Notificacion: "+message);
        }
    }
}
