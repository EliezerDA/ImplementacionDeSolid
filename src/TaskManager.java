public class TaskManager {
    private ITaskRepository taskRepository;
    private INotificationService notificationService;

    public TaskManager(ITaskRepository taskRepository, INotificationService notificationService) {
        this.taskRepository = taskRepository;
        this.notificationService = notificationService;
    }

    public void createTask(int id, String title, String description) {
        Task task = new Task(id,title,description);
        taskRepository.addTask(task);
        notificationService.sendNotification("Nueva tarea creada: " + title);
    }

    public void completeTask(int id){
        Task task = taskRepository.getTaskById(id);
        if (task !=null ){
            task.completeTask();
            taskRepository.updateTask(task);
            notificationService.sendNotification("Tarea completa " +task.getTitle());
        }else {
            System.out.println("Tarea no encontrada");
        }
    }
    public void listTasks(){
        System.out.println("Tareas disponibles:");
        // Verifica si hay tareas en el repositorio
        if (taskRepository instanceof InMemoryTaskRepository) {
            InMemoryTaskRepository inMemoryRepo = (InMemoryTaskRepository) taskRepository;
            if (inMemoryRepo.getTasks().isEmpty()) {
                System.out.println("No hay tareas disponibles.");
            } else {
                for (Task task : inMemoryRepo.getTasks().values()) {
                    System.out.println("ID: " + task.getId() + ", Título: " + task.getTitle() + ", Estado: " + (task.isCompleted() ? "Completada" : "Pendiente"));
                }
            }
    }

    }
}
