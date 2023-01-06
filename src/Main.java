import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws SQLException, IOException, ParseException {
    Scanner scanner = new Scanner(System.in);
    EmployeeDao dao = new EmployeeDaoImpl();

    while (true) {
      System.out.println("Enter a number to select a method:");
      System.out.println("1. Add employee");
      System.out.println("2. Delete employee");
      System.out.println("3. Delete all employees");
      System.out.println("4. Update employee");
      System.out.println("5. Get employee");
      System.out.println("6. Get all employees");
      System.out.println("0. Exit");

      int choice = scanner.nextInt();
      switch (choice) {
        case 1:
          // add employee
          System.out.println("Enter employee ID:");
          int id = scanner.nextInt();
          System.out.println("Enter first name:");
          String fname = scanner.next();
          System.out.println("Enter last name:");
          String lname = scanner.next();
          System.out.println("Enter age:");
          int age = scanner.nextInt();
          System.out.println("Enter registered date (yyyy-mm-dd):");
          String registeredString = scanner.next();
          Date registered = new SimpleDateFormat("yyyy-mm-dd").parse(registeredString);
          System.out.println("Enter post:");
          String post = scanner.next();
          Employee employee = new Employee(id, fname, lname, age, registered, post);
          dao.addEmployee(employee);

          break;
        case 2:
          // delete employee
          System.out.println("Enter employee ID:");
          id = scanner.nextInt();
          dao.deleteEmployee(id);

          break;
        case 3:
          // delete all employees
          dao.deleteAllEmployees();

          break;
        case 4:
            // update employee
            System.out.println("Enter employee ID:");
            id = scanner.nextInt();
            System.out.println("Enter first name:");
            fname = scanner.next();
            System.out.println("Enter last name:");
            lname = scanner.next();
            System.out.println("Enter age:");
            age = scanner.nextInt();
            System.out.println("Enter registered date (yyyy-mm-dd):");
            registeredString = scanner.next();
            registered = new SimpleDateFormat("yyyy-mm-dd").parse(registeredString);
            System.out.println("Enter post:");
            post = scanner.next();
            employee = new Employee(id, fname, lname, age, registered, post);
            dao.updateEmployee(employee);

            break;
          case 5:
            // get employee
            System.out.println("Enter employee ID:");
            id = scanner.nextInt();
            employee = dao.getEmployee(id);
            System.out.println("ID: " + employee.getId());
            System.out.println("First name: " + employee.getFname());
            System.out.println("Last name: " + employee.getLname());
            System.out.println("Age: " + employee.getAge());
            System.out.println("Registered: " + employee.getRegistered());
            System.out.println("Post: " + employee.getPost());
            break;
          case 6:
              // get all employees
              List<Employee> employees = dao.getAllEmployees();
              for (Employee emp : employees) {
                System.out.println("ID: " + emp.getId());
                System.out.println("First name: " + emp.getFname());
                System.out.println("Last name: " + emp.getLname());
                System.out.println("Age: " + emp.getAge());
                System.out.println("Registered: " + emp.getRegistered());
                System.out.println("Post: " + emp.getPost());
              }
              break;
            case 0:
            	System.out.println("You exited the programme");
              System.exit(0);
              break;
            default:
              System.out.println("Invalid choice.");
              break;
          }
        }
      }
    }
