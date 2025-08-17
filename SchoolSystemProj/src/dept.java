import java.io.*;
import java.util.ArrayList;

public class dept {
   int deptNumber;
   String deptName;
   ArrayList<Employee> empp;
    String file = "F:\\javatask\\unit4\\emp.txt";
   public dept(int deptNumber, String deptName){
       this.deptNumber = deptNumber;
       this.deptName = deptName;
       empp = loadEmployee();
   }

   public void registerEmployee(String name, String address,int SSN,Gender sex,String Email, String password,int deptNumber, String deptName) {
       if (getEmployeebyEmail(Email) != null) {
           System.out.println("this email is already exist please try again");
           return;
       }
       empp.add(new Employee(name, address, SSN, sex, Email, password) {
           @Override
           public double earning() {
               return 0;
           }
       });
       saveEmployee();
       System.out.println("Employee regestered successfully ");
   }

   public Employee loginEmployee(String email, String password){
       for(Employee e : empp){
           if(e.getEmail().equals(email) && e.checkPassword(password)){
               System.out.println("you login sucessfully "+ e.getName());
               return e;
           }
       }
       System.out.println("your email or password invalid ");
       return null;
   }
   public Employee createEmployee(String name, String address,int SSN,Gender sex,String Email, String password,int deptNumber, String deptName){
       Employee newone = new Employee(name, address, SSN, sex, Email, password) {
           @Override
           public double earning() {
               return 0;
           }
       };
       System.out.println("Employee added sucessfully "+ newone.getName());
       return newone;
   }

   public void readEmployee() {
       if (empp.isEmpty()) {
           System.out.println("no employees found");
       }
       else {
           for (Employee e : empp) {
               System.out.println(e);
           }
       }
   }

   public void updateEmployee(String newname, String newaddress,int SSN,Gender sex,String Email, String password){
       for(Employee e : empp){
           if(e.getSSN() == SSN){
               e.setName(newname);
               e.setAddress(newaddress);
               saveEmployee();
               System.out.println("Employee is added sucessfully");
           }
       }
       System.out.println("Employee with "+ SSN + "not found");
   }

   private void deleteEmployee(int SSN){
       empp.removeIf(e -> e.getSSN() == SSN);
       saveEmployee();
       System.out.println("emp removed successfully");
   }

   private void saveEmployee(){
       try {
           ObjectOutputStream sw = new ObjectOutputStream(new FileOutputStream(file));
           sw.writeObject(empp);

       } catch (IOException e) {
           System.out.println(e.getMessage());
       }

   }

   private ArrayList<Employee> loadEmployee(){
       File newfile = new File(file);
       if(!newfile.exists()){
           System.out.println("file not found");
       }

       try {
           ObjectInputStream iis  = new ObjectInputStream(new FileInputStream(file));
           return (ArrayList<Employee>) iis.readObject();
       } catch (IOException | ClassNotFoundException e) {
           System.out.println(e.getMessage());
           return new ArrayList<>();
       }

   }

   private Employee getEmployeebyEmail(String email){
       for(Employee e : empp){
           if(e.getEmail().equals(email)){
               return e;
           }
       }
       return null;
   }


}
