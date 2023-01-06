import java.util.List;

public interface EmployeeDao {
  public void addEmployee(Employee employee);
  public void deleteEmployee(int id);
  public void deleteAllEmployees();
  public void updateEmployee(Employee employee);
  public Employee getEmployee(int id);
  public List<Employee> getAllEmployees();
}