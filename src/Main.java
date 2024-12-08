import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        IEmployeeRepository employeeRepository = new InMemoryEmployeeRepository();
        INotificationService notificationService = new ConsoleNotificationService();
        EmployeeManager employeeManager = new EmployeeManager(employeeRepository, notificationService);

       Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\nMenú de Gestión de Empleados:");
            System.out.println("1. Agregar empleado");
            System.out.println("2. Eliminar empleado");
            System.out.println("3. Listar empleados");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            System.out.println("\n");
            option = scanner.nextInt();

            switch (option){
                case 1:
                    System.out.print("Ingrese ID del empleado: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consumir salto de línea
                    System.out.print("Ingrese nombre del empleado: ");
                    String name = scanner.nextLine();
                    System.out.print("Ingrese puesto del empleado: ");
                    String position = scanner.nextLine();
                    employeeManager.addEmployee(new Employee(id, name, position));
                    break;
                case 2:
                    System.out.print("Ingrese ID del empleado a eliminar: ");
                    int removeId = scanner.nextInt();
                    employeeManager.removeEmployee(removeId);
                    break;
                case 3:
                    employeeManager.listEmployees();
                    break;
                case 4:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }while (option!=4);
        scanner.close();
    }
}