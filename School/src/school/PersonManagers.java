/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package school;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author PC
 */
public class PersonManagers <T extends Person>{
    
    public String tableName ;

    public PersonManagers(String tableName){
        this.tableName = tableName;
    }

    public void register(T person){
         String sql = "INSERT INTO " + tableName + " (id, name, email, password";
    
    if (person instanceof Student) sql += ", gpa, creditHour, department";
    if (person instanceof Employee) sql += ", salary, position";
    if (person instanceof Teacher) sql += ", department";
    
    sql += ") VALUES (?, ?, ?, ?";  // Base placeholders for id, name, email, password
    
    if (person instanceof Student) sql += ", ?, ?, ?"; // For gpa, creditHour, department
    if (person instanceof Employee) sql += ", ?, ?"; // For salary, position
    if (person instanceof Teacher) sql += ", ?"; // For department
    
    sql += ")"; // Closing bracket

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        // Common fields
        stmt.setInt(1, person.getId()); 
        stmt.setString(2, person.getName());
        stmt.setString(3, person.getEmail());
        stmt.setString(4, person.getPassword());

        int index = 5; // Start from the next available index

        if (person instanceof Student) {
            stmt.setDouble(index++, ((Student) person).getGpa());
            stmt.setInt(index++, ((Student) person).getCreditHour());  // ✅ Fix: Add creditHour
            stmt.setString(index++, ((Student) person).getDepartment());  // ✅ Fix: Add department
        } else if (person instanceof Employee) {
            stmt.setDouble(index++, ((Employee) person).getSalary());
            stmt.setString(index++, ((Employee) person).getPosition());
        } else if (person instanceof Teacher) {
            stmt.setString(index++, ((Teacher) person).getSubject());
        }

        stmt.executeUpdate();
        System.out.println(person.getName() + " registered successfully.");
    } catch (SQLException e) {
        e.printStackTrace();
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(PersonManagers.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    public T login(String email, String password, String role){

 
     String tableName;
    switch (role.toLowerCase()) {
        case "student":
            tableName = "Student";
            break;
        case "employee":
            tableName = "Employee";
            break;
        case "teacher":
            tableName = "Teacher";
            break;
        default:
            System.out.println("Invalid role specified.");
            return null;
    }

    // Corrected SQL query with a space before "WHERE"
    String sql = "SELECT * FROM " + tableName + " WHERE email = ? AND password = ?";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        stmt.setString(1, email);
        stmt.setString(2, password);

        try (ResultSet rs = stmt.executeQuery()) { // Use try-with-resources for ResultSet
            if (rs.next()) {
                System.out.println("Login successful! Welcome " + rs.getString("name") + "!");

                switch (role.toLowerCase()) {
                    case "student":
                        return (T) new Student(
                            rs.getString("name"), rs.getInt("id"), rs.getString("email"),
                            rs.getString("password"), rs.getDouble("gpa"), 
                            rs.getInt("creditHour"), rs.getString("department")
                        );
                    case "employee":
                        return (T) new Employee(
                            rs.getString("name"), rs.getInt("id"), rs.getString("email"),
                            rs.getString("password"), rs.getString("position"), rs.getDouble("salary")
                        );
                    case "teacher":
                        return (T) new Teacher(
                            rs.getString("name"), rs.getInt("id"), rs.getString("email"),
                            rs.getString("password"), rs.getString("subject")
                        );
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(PersonManagers.class.getName()).log(Level.SEVERE, null, ex);
    }

    System.out.println("Invalid email or password.");
    return null;
}


    public void readAll() {
    String sql = "SELECT * FROM " + tableName;
    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {  // ✅ FIXED: No argument here

        while (rs.next()) {
            System.out.println("Name: " + rs.getString("name") +
                               ", ID: " + rs.getInt("id") +
                               ", Email: " + rs.getString("email"));  // ✅ Added commas for readability
        }

    } catch (SQLException e) {
        e.printStackTrace();
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(PersonManagers.class.getName()).log(Level.SEVERE, null, ex);
    }
}
    

    
    public void update(int id, String newName, String newEmail, String newPassword, T person) {
    String sql = "UPDATE " + tableName + " SET name = ?, email = ?, password = ?";

    if (person instanceof Student) sql += ", gpa = ?, creditHour = ?, department = ?";
    if (person instanceof Employee) sql += ", salary = ?, position = ?";
    if (person instanceof Teacher) sql += ", department = ?";

    sql += " WHERE id = ?"; // Important: WHERE clause to specify which record to update

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        // Common fields
        stmt.setString(1, newName);
        stmt.setString(2, newEmail);
        stmt.setString(3, newPassword);

        int index = 4; // Start from the next available index

        if (person instanceof Student) {
            stmt.setDouble(index++, ((Student) person).getGpa());
            stmt.setInt(index++, ((Student) person).getCreditHour()); // ✅ Fix: Add missing creditHour
            stmt.setString(index++, ((Student) person).getDepartment()); // ✅ Fix: Add missing department
        } else if (person instanceof Employee) {
            stmt.setDouble(index++, ((Employee) person).getSalary());
            stmt.setString(index++, ((Employee) person).getPosition());
        } else if (person instanceof Teacher) {
            stmt.setString(index++, ((Teacher) person).getSubject());
        }

        stmt.setInt(index, id); // Last parameter: WHERE id = ?

        stmt.executeUpdate();
        System.out.println("Record updated successfully.");
    } catch (SQLException e) {
        e.printStackTrace();
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(PersonManagers.class.getName()).log(Level.SEVERE, null, ex);
    }
}
    

    public void deleteById(int id){
        String sql = "DELETE FROM "+ tableName + " WHERE id = ?";

        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Record deleted successfully");
        } catch(SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PersonManagers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
