import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
  private static final String DB_URL = "jdbc:mysql://localhost:3306/java__proj";
  private static final String DB_USERNAME = "root";
  private static final String DB_PASSWORD = "root";

  private static Connection connection;

  public static Connection getConnection() throws SQLException {
    if (connection == null || connection.isClosed()) {
      try {
        Class.forName("com.mysql.cj.jdbc.Driver");
      } catch (ClassNotFoundException e) {
        System.out.println(e);
      }
      connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
    }
    return connection;
  }
}
