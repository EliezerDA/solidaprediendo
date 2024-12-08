import java.util.List;

public interface IEmployeeRepository {
    void addEmployee(Employee employee);
    void removeEmployee(int id);
    Employee getEmployeeById(int id);
    List<Employee> getAllEmployees();
}

