import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {
  private Connection connection;
  private BufferedWriter writer;

  public EmployeeDaoImpl() throws SQLException, IOException {
    connection = DatabaseConnection.getConnection();
    writer = new BufferedWriter(new FileWriter("logs.txt", true));
  }

  public void addEmployee(Employee employee) {
    try {
      PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO employees (id, fname, lname, age, registered, post) VALUES (?, ?, ?, ?, ?, ?)");
      preparedStatement.setInt(1, employee.getId());
      preparedStatement.setString(2, employee.getFname());
      preparedStatement.setString(3, employee.getLname());
      preparedStatement.setInt(4, employee.getAge());
      preparedStatement.setDate(5, new java.sql.Date(employee.getRegistered().getTime()));
      preparedStatement.setString(6, employee.getPost());
      preparedStatement.executeUpdate();
      writer.write("Added employee: " + employee.getFname().toString());
      writer.newLine();
      writer.flush();
    } catch (SQLException | IOException e) {
      e.printStackTrace();
    }
  }

  public void deleteEmployee(int id) {
    try {
      PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM employees WHERE id=?");
      preparedStatement.setInt(1, id);
      preparedStatement.executeUpdate();
      writer.write("Deleted employee with ID: " + id);
      writer.newLine();
      writer.flush();
    } catch (SQLException | IOException e) {
      e.printStackTrace();
    }
  }

  public void deleteAllEmployees() {
    try {
    	PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM employees");
      preparedStatement.executeUpdate();
      writer.write("Deleted all employees");
      writer.newLine();
      writer.flush();
    } catch (SQLException | IOException e) {
      e.printStackTrace();
    }
  }

  public void updateEmployee(Employee employee) {
	    try {
	      PreparedStatement preparedStatement = connection.prepareStatement("UPDATE employees SET fname=?, lname=?, age=?, registered=?, post=? WHERE id=?");
	      preparedStatement.setString(1, employee.getFname());
	      preparedStatement.setString(2, employee.getLname());
	      preparedStatement.setInt(3, employee.getAge());
	      preparedStatement.setDate(4, new java.sql.Date(employee.getRegistered().getTime()));
	      preparedStatement.setString(5, employee.getPost());
	      preparedStatement.setInt(6, employee.getId());
	      preparedStatement.executeUpdate();
	      writer.write("Updated employee: " + employee.toString());
	      writer.newLine();
	      writer.flush();
	    } catch (SQLException | IOException e) {
	      e.printStackTrace();
	    }
	  }
  public Employee getEmployee(int id) {
	    Employee employee = null;
	    try {
	      PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM employees WHERE id=?");
	      preparedStatement.setInt(1, id);
	      ResultSet resultSet = preparedStatement.executeQuery();
	      if (resultSet.next()) {
	        String fname = resultSet.getString("fname");
	        String lname = resultSet.getString("lname");
	        int age = resultSet.getInt("age");
	        java.util.Date registered = resultSet.getDate("registered");
	        String post = resultSet.getString("post");
	        employee = new Employee(id, fname, lname, age, registered, post);
	      }
	      writer.write("Retrieved employee with ID: " + id);
	      writer.newLine();
	      writer.flush();
	    } catch (SQLException | IOException e) {
	      e.printStackTrace();
	    }
	    return employee;
	  }

	  public List<Employee> getAllEmployees() {
	    List<Employee> employees = new ArrayList<>();
	    try {
	      PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM employees");
	      ResultSet resultSet = preparedStatement.executeQuery();
	      while (resultSet.next()) {
	        int id = resultSet.getInt("id");
	        String fname = resultSet.getString("fname");
	        String lname = resultSet.getString("lname");
	        int age = resultSet.getInt("age");
	        java.util.Date registered = resultSet.getDate("registered");
	        String post = resultSet.getString("post");
	        employees.add(new Employee(id, fname, lname, age, registered, post));
	      }
	      writer.write("Retrieved all employees");
	      writer.newLine();
	      writer.flush();
	    } catch (SQLException | IOException e) {
	    	 e.printStackTrace();
	    }
	    return employees;
	  }
	}