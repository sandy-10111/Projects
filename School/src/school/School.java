/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package school;

import java.util.Scanner;

/**
 *
 * @author PC
 */
public class School {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner (System.in);
        PersonManagers<Student> studentManager = new PersonManagers<>("Student");
        PersonManagers<Employee> employeeManager = new PersonManagers<>("Employee");
        PersonManagers<Teacher> teacherManager = new PersonManagers<>("Teacher");
        
        
        while (true) {
            System.out.println("School management system");
            System.out.println("1. Register ");
            System.out.println("2. Login");
            System.out.println("3. Read all Records");
            System.out.println("4. updata data");
            System.out.println("5. Delete by id");
            System.out.println("6. Exit");
            System.out.println("Enter your choice: ");
            
            int choice = scanner.nextInt();
            
            switch(choice){
                case 1: 
                    registerUser(scanner , studentManager, employeeManager, teacherManager);
                    break;
                    
                case 2: 
                    loginUser(scanner, studentManager, employeeManager, teacherManager);
                    break;
                    
                case 3:
                    ReadAllRecords(scanner, studentManager, employeeManager, teacherManager);
                    break;
                    
                case 4:
                    updateUser(scanner, studentManager, employeeManager, teacherManager);
                    break;
                    
                case 5:
                    deleteUser(scanner, studentManager, employeeManager, teacherManager);
                    break;
                    
                case 6:
                    System.out.println("Exiting.........");
                    scanner.close();
                    return;
                    
                default :
                    System.out.println("Invalid choice please try again");
                    
            }
            
        }
    }
    

//    public static void registerUser(Scanner scanner, PersonManagers<Student> studentManager, PersonManagers<Employee> employeeManager, PersonManagers<Teacher> teacherManager) {
//   
//        System.out.println("Enter role (Student, Employee, Teacher): ");
//        String role = scanner.nextLine();
//        scanner.nextLine();
//        System.out.println("Enter name: ");
//        String name = scanner.nextLine();
//        
//        System.out.println("Enter Email: ");
//        String email = scanner.nextLine();
//        
//        System.out.println("Enter Password: ");
//        String password = scanner.nextLine();
//        
//        System.out.println("Enter ID: ");
//        int id = scanner.nextInt();
//        scanner.nextLine();
//        
//        if(role.equalsIgnoreCase("Student")){
//            System.out.println("Enter GPA: ");
//            double gpa = scanner.nextDouble();
//            
//            System.out.println("Enter Credit Hour: ");
//            int creditHour = scanner.nextInt();
//            scanner.nextLine();
//            
//            System.out.println("Enter Department: ");
//            String department = scanner.nextLine();
//            
//            Student newstd = new Student(name, id, email, password, gpa, creditHour, department);
//            studentManager.register(newstd);
//            
//        } else if (role.equalsIgnoreCase("Employee")) {
//            System.out.println("enter Salary: ");
//            double salary = scanner.nextDouble();
//            scanner.nextLine();
//            
//            System.out.println("Enter Position: ");
//            String position = scanner.nextLine();
//            
//            Employee newEmp = new Employee(name, id ,email, password, position ,salary);
//            employeeManager.register(newEmp);
//            
//        } else if (role.equalsIgnoreCase("Teacher")) {
//            System.out.println("Enter Subject: ");
//            String subject = scanner.nextLine();
//            
//            Teacher newTeacher = new Teacher(name ,id, email, password, subject);
//            teacherManager.register(newTeacher);
//            
//        } else {
//            System.out.println("Invalid role");
//        }
//        
//        
//    }
    
  public static void registerUser(Scanner scanner, 
                                PersonManagers<Student> studentManager, 
                                PersonManagers<Employee> employeeManager, 
                                PersonManagers<Teacher> teacherManager) {

    scanner.nextLine(); // Consume leftover newline before reading role input

    System.out.print("Enter role (Student, Employee, Teacher): ");
    String role = scanner.nextLine().trim();  // Trim spaces

    // Debugging: Print the exact role entered
    System.out.println("DEBUG: Role entered -> '" + role + "'");

    if (!(role.equalsIgnoreCase("Student") || role.equalsIgnoreCase("Employee") || role.equalsIgnoreCase("Teacher"))) {
        System.out.println("Invalid role! Please enter 'Student', 'Employee', or 'Teacher'.");
        return;  // Stop execution if role is invalid
    }

    System.out.print("Enter Name: ");
    String name = scanner.nextLine();

    System.out.print("Enter Email: ");
    String email = scanner.nextLine();

    System.out.print("Enter Password: ");
    String password = scanner.nextLine();

    System.out.print("Enter ID: ");
    int id = scanner.nextInt();
    scanner.nextLine();  // Consume leftover newline

    if (role.equalsIgnoreCase("Student")) {
        System.out.print("Enter GPA: ");
        double gpa = scanner.nextDouble();

        System.out.print("Enter Credit Hours: ");
        int creditHour = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        System.out.print("Enter Department: ");
        String department = scanner.nextLine();

        Student newStudent = new Student(name, id, email, password, gpa, creditHour, department);
        studentManager.register(newStudent);
        System.out.println("Student registered successfully!");

    } else if (role.equalsIgnoreCase("Employee")) {
        System.out.print("Enter Salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine();  

        System.out.print("Enter Position: ");
        String position = scanner.nextLine();

        Employee newEmployee = new Employee(name, id, email, password, position, salary);
        employeeManager.register(newEmployee);
        System.out.println("Employee registered successfully!");

    } else if (role.equalsIgnoreCase("Teacher")) {
        System.out.print("Enter Subject: ");
        String subject = scanner.nextLine();

        Teacher newTeacher = new Teacher(name, id, email, password, subject);
        teacherManager.register(newTeacher);
        System.out.println("Teacher registered successfully!");
    }
}


    

  
  public static void loginUser(Scanner scanner, 
                             PersonManagers<Student> studentManager, 
                             PersonManagers<Employee> employeeManager, 
                             PersonManagers<Teacher> teacherManager) {
    
    System.out.print("Enter role (Student, Employee, Teacher): ");

    // Force role input until it's valid
    String role = scanner.nextLine().trim();
    while (role.isEmpty()) {
        System.out.println("Role cannot be empty! Please enter a valid role.");
        System.out.print("Enter role (Student, Employee, Teacher): ");
        role = scanner.nextLine().trim();
    }

    System.out.print("Enter Email: ");
    String email = scanner.nextLine().trim();

    System.out.print("Enter Password: ");
    String password = scanner.nextLine().trim();

    Person loggedInUser = null;

    switch (role.toLowerCase()) {
        case "student": 
            loggedInUser = studentManager.login(email, password, "Student");
            break;
        case "employee":
            loggedInUser = employeeManager.login(email, password, "Employee");
            break;
        case "teacher":
            loggedInUser = teacherManager.login(email, password, "Teacher");
            break;
        default:
            System.out.println("Invalid role entered!");
            return;  // Stop execution if role is invalid
    }

    if (loggedInUser != null) {
        System.out.println("Login successful! Welcome, " + loggedInUser.getName());
    } else {
        System.out.println("Invalid email or password.");
    }
}
    
  
  public static void ReadAllRecords(Scanner scanner, 
                                  PersonManagers<Student> studentManager, 
                                  PersonManagers<Employee> employeeManager, 
                                  PersonManagers<Teacher> teacherManager) {
    
    // FIX: Consume any leftover newline to prevent skipping input
    scanner.nextLine();  

    System.out.print("Enter role (Student, Employee, Teacher) to read: ");
    String role = scanner.nextLine().trim();  

    System.out.println("DEBUG: Role entered -> '" + role + "'");  

    switch (role.toLowerCase()) {
        case "student":
            studentManager.readAll();
            break;
        case "employee":
            employeeManager.readAll();
            break;
        case "teacher":
            teacherManager.readAll();
            break;
        default:
            System.out.println("Invalid role! Please enter 'Student', 'Employee', or 'Teacher'.");
    }
}



    public static void updateUser(Scanner scanner, PersonManagers<Student> studentManager, PersonManagers<Employee> employeeManager, PersonManagers<Teacher> teacherManager) {
        scanner.nextLine();
        
        System.out.println("Enter role (Student , Employee, Teacher): " );
        String role = scanner.nextLine().trim();
        scanner.nextLine();
        System.out.println("Enter ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter new name: ");
        String newName = scanner.nextLine();
        System.out.println("Enter new email: ");
        String newEmail = scanner.nextLine();
        System.out.println("Enter new password: ");
        String newPassword = scanner.nextLine();
        
        if(role.equals("Student")) {
            System.out.println("Enter gpa: ");
            double newGPA = scanner.nextDouble();
            System.out.println("Enter new credit hour: ");
            int newcreditHour = scanner.nextInt();
            System.out.println("Enter new department: ");
            String newDepartment = scanner.nextLine();
            
            Student updateStudent = new Student(newName,id,newEmail,newPassword,newGPA,newcreditHour,newDepartment);
            studentManager.update(id, newName, newEmail, newPassword, updateStudent);
            
        } else if(role.equals("Employee")) {
            System.out.println("enter new salary: ");
            double newsalary = scanner.nextDouble();
            scanner.nextLine();
            System.out.println("Enter new position");
            String newPosition = scanner.nextLine();
            
            Employee updateEmpoyee = new Employee(newName,id,newEmail,newPassword,newPosition,newsalary);
            employeeManager.update(id, newName, newEmail, newPassword, updateEmpoyee);
            
        } else if(role.equals("Teacher")) {
            System.out.println("Enter new subject: ");
            String newSubject = scanner.nextLine();
            
            Teacher updateTeacher = new Teacher(newName,id,newEmail,newPassword,newSubject);
            teacherManager.update(id, newName, newEmail, newPassword, updateTeacher);
            
        } else{
            System.out.println("Invalid role");
        }
    }
    

    public static void deleteUser(Scanner scanner, PersonManagers<Student> studentManager, PersonManagers<Employee> employeeManager, PersonManagers<Teacher> teacherManager) {
        
        System.out.println("Enter role (Student , Employee, Teacher): ");
        String role = scanner.nextLine();
        System.out.println("enter id to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        if(role.equals("Student")) {
            studentManager.deleteById(id);
        } else if(role.equals("Employee")) {
            employeeManager.deleteById(id);
        } else if(role.equals("Teacher")){
            teacherManager.deleteById(id);
        } else{
            System.out.println("Invalid role");
        }
    }
    
}
