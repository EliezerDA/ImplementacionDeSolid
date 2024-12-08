import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    ITaskRepository taskRepository = new InMemoryTaskRepository();
    INotificationService notificationService = new InMemoryTaskRepository.ConsoleNotificationService();
    TaskManager taskManager = new TaskManager(taskRepository, notificationService);

        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\nMenú de Gestión de Tareas:");
            System.out.println("1. Crear tarea");
            System.out.println("2. Completar tarea");
            System.out.println("3. Listar tareas");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            System.out.println("\n");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Ingrese ID de la tarea: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consumir salto de línea
                    System.out.print("Ingrese título de la tarea: ");
                    String title = scanner.nextLine();
                    System.out.print("Ingrese descripción de la tarea: ");
                    String description = scanner.nextLine();
                    taskManager.createTask(id, title, description);
                    break;
                case 2:
                    System.out.print("Ingrese ID de la tarea a completar: ");
                    int completeId = scanner.nextInt();
                    taskManager.completeTask(completeId);
                    break;
                case 3:
                    taskManager.listTasks();
                    break;
                case 4:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida.");
        }
    } while (option != 4);
    scanner.close();
    }
}