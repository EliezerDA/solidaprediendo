import java.util.List;

public class EmployeeManager {
    private IEmployeeRepository employeeRepository;
    private INotificationService notificationService;

    public EmployeeManager(IEmployeeRepository employeeRepository, INotificationService notificationService) {
        this.employeeRepository = employeeRepository;
        this.notificationService = notificationService;
    }
    public void addEmployee(Employee employee){
        employeeRepository.addEmployee(employee);
        notificationService.notify("Empleado agregado: "+employee.getName());
    }

    public void removeEmployee(int id){
       Employee employee = employeeRepository.getEmployeeById(id);
       if (employee!=null){
           employeeRepository.removeEmployee(id);
           notificationService.notify("Empleado eliminado: "+employee.getName());
       }else {
           System.out.println("Empleado no encontrado");
       }
    }

    public void listEmployees() {
        List<Employee> employees = employeeRepository.getAllEmployees();  // Obtenemos los empleados del repositorio
        if (employees.isEmpty()) {
            System.out.println("No hay empleados registrados.");
        } else {
            System.out.println("Lista de empleados:");
            for (Employee employee : employees) {
                System.out.println("ID: " + employee.getId() + ", Nombre: " + employee.getName() + ", Puesto: " + employee.getPosition());
            }
        }
    }


}

