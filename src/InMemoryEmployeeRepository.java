import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryEmployeeRepository implements IEmployeeRepository{
    private Map<Integer, Employee> employees= new HashMap<>();

    @Override
    public void addEmployee(Employee employee){
        employees.put(employee.getId(), employee);
    }
    @Override
    public void removeEmployee(int id) {
        employees.remove(id);
    }
    @Override
    public Employee getEmployeeById(int id) {
        return employees.get(id);
    }
    @Override
    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employees.values());
    }
}
