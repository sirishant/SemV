/*
 *  Write a Java program to search and display details of book(s) authored by a 
    particular author from a “BOOKS” table. Assume an appropriate structure and attributes for 
    the table.
 */

package TW8;

// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.sql.SQLException;
import java.sql.*;

public class TW8 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/empdb";
        String username = "root";
        String password = "root";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String sql = "Select employee_id, first_name FROM employee";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        int employeeId = resultSet.getInt("employee_id");
                        String firstName = resultSet.getString("first_name");

                        System.out.println("Employee ID: " + employeeId + ", First Name: " + firstName);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
