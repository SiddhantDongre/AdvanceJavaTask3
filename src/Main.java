import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

                Scanner sc = new Scanner(System.in);

                // Take input from the user
                System.out.print("Enter Student ID: ");
                int id = sc.nextInt();
                sc.nextLine(); // consume newline
                System.out.print("Enter Student Name: ");
                String name = sc.nextLine();
                System.out.print("Enter Student Age: ");
                int age = sc.nextInt();

                Connection con = null;
                Statement stmt = null;

                try {
                    // Load MySQL JDBC Driver
                    Class.forName("com.mysql.cj.jdbc.Driver");

                    // Establish connection (replace with your DB details)
                    con = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/student_db", "root", "Siddhant");

                    // Form INSERT SQL query (use studentadd table)
                    String sql = "INSERT INTO studentaddinto (id, name, age) VALUES ("
                            + id + ", '" + name + "', " + age + ")";

                    // Execute query
                    stmt = con.createStatement();
                    int rowsInserted = stmt.executeUpdate(sql);

                    // Confirmation
                    if (rowsInserted > 0) {
                        System.out.println("Student inserted successfully into studentadd table!");
                    }

                } catch (ClassNotFoundException e) {
                    System.out.println("MySQL JDBC Driver not found. Include it in your library path.");
                    e.printStackTrace();
                } catch (SQLException e) {
                    System.out.println("SQL Error occurred!");
                    e.printStackTrace();
                } finally {
                    // Close resources
                    try {
                        if (stmt != null) stmt.close();
                        if (con != null) con.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    sc.close();
                }
            }
        }
