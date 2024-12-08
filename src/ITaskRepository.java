public interface ITaskRepository {
    void addTask(Task task);
    Task getTaskById(int id);
    void updateTask(Task task);
    void deleteTask(int id);
}

