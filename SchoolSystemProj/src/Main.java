import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        StudentManager manager = new StudentManager();
        Scanner scanner = new Scanner(System.in);
        Student loginstudent = null;

        while(true){
            System.out.println("\n studenent management system");
            System.out.println("1. regester");
            System.out.println("2. Login");
            System.out.println("3. exit");
            System.out.println("Enter your choice: " );

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice){
                case 1:
                    registerUser(manager,scanner);
                    break;
                case 2:
                    loginstudent = loginUser(manager, scanner);
                    if(loginstudent != null){
                        studentMenu(manager,scanner,loginstudent);
                    }
                    break;
                case 3:
                    System.out.println("exiting.....");
                    scanner.close();
                    return;
                default:
                    System.out.println("invalid choise please try again");
            }

        }
    }
    public static void registerUser(StudentManager manager, Scanner scanner){
        System.out.println("\n enter details for student registeration: ");
        System.out.println("Name: ");
        String name = scanner.nextLine();
        System.out.println("ID: ");
        int id = scanner.nextInt();
        System.out.println("GPA: ");
        double gpa = scanner.nextDouble();
        System.out.println("credit hours: ");
        int creditHour = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Department: ");
        String dept= scanner.nextLine();
        System.out.println("email: ");
        String email = scanner.nextLine();
        System.out.println("password: ");
        String pass = scanner.nextLine();

        manager.registerStudent(name,id,gpa,creditHour,dept,email,pass);
    }
    public static Student loginUser(StudentManager manager, Scanner scanner){
        System.out.println("\n enter email: ");
        String email = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();
        Student std = manager.loginStudent(email, password);
        if(std != null){
            return std;
        }
        return null;
    }
    public static void studentMenu(StudentManager manager, Scanner scanner, Student loginstudent){
       while(true){
           System.out.println("\n studentMenu ");
           System.out.println("1. view students");
           System.out.println("2.update student");
           System.out.println("3.delete student");
           System.out.println("4.logout");
           System.out.println("enter your choice: ");

           int choice = scanner.nextInt();
           scanner.nextLine();

           switch(choice){
               case 1:
                   manager.readStudent();
                   break;
               case 2:
                   updateUser(manager,scanner);
                   break;
               case 3:
                   deleteUser(manager,scanner);
                   break;
               case 4:
                   System.out.println("logging out ....");
                   return;
               default:
                   System.out.println("invalid choice try again");
           }
       }
    }
    public static void updateUser(StudentManager manager, Scanner scanner){
        System.out.println("\n enter student id to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("new name: ");
        String newName = scanner.nextLine();
        System.out.print("New GPA: ");
        double newGpa = scanner.nextDouble();
        System.out.print("New Credit Hours: ");
        int newCreditHour = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("New Department: ");
        String newDept = scanner.nextLine();
        System.out.print("New Email: ");
        String newEmail = scanner.nextLine();
        System.out.print("New Password: ");
        String newPass = scanner.nextLine();

        manager.updateStudent(id, newName, newGpa, newCreditHour, newDept, newEmail, newPass);
    }
    public static void deleteUser(StudentManager manager, Scanner scanner){
        System.out.println("\n enter student id to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        manager.deleteStudent(id);
    }
}