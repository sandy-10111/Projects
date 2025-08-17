import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class StudentManager {
    int deptNumber;
    String deptName;
    public ArrayList<Student> students;
    ArrayList<Employee> empp;
    public String file_name = "F:\\javatask\\unit4\\students.txt";

    public StudentManager(){
         students = loadStudents();

    }

    public void registerStudent(String Name,int ID, double GPA, int creditHour,String Department,String Email, String Password){
        if(getstudentByEmail(Email) != null){
            System.out.println("this email is already exist . write another");
            return;
        }
        students.add(new Student(Name, ID, GPA, creditHour, Department,Email,Password));
        saveStudent();
        System.out.println("student registered successfully");
    }

    public Student loginStudent(String email, String Password){
        for(Student s : students){
            if(s.getEmail().equals(email) && s.checkpassword(Password)){
                System.out.println("student login successfully "+ s.getName());
                return s;
            }
        }
        //System.out.println("your email or password is wrong");
        return null;
    }

    public Student createStudent (String Name,int ID, double GPA, int creditHour,String Department,String Email, String Password){
        Student newst= new Student(Name,ID,GPA,creditHour,Department,Email,Password);
        saveStudent();
        System.out.println("student created successfully "+ newst.getName());
        return newst;
    }

    public void readStudent(){
        if(students.isEmpty()){
            System.out.println("no student found");
        }
        else{
            for(Student s : students){
                System.out.println(s);
            }
        }
    }
    public void updateStudent(int ID, String newname , double newGPA,int newcreadedHour,String newdept,String newemail,String newpass){
        for(Student s : students){
            if(s.getID()==ID){
                s.setName(newname);
                s.setGPA(newGPA);
                s.setCreditHour(newcreadedHour);
                s.setDepartment(newdept);
                s.setEmail(newemail);
                s.setPassword(newpass);
                saveStudent();
                System.out.println("students's data updated successfully");
            }
        }
        System.out.println("student with id : "+ ID+ " not found");
    }

    public void deleteStudent(int id){
        students.removeIf(s->s.getID()==id);
            saveStudent();
            System.out.println("student with id: "+id + "is removed");

    }

    private void saveStudent(){

        try {
            ObjectOutputStream out =   new ObjectOutputStream(new FileOutputStream(file_name));
            out.writeObject(students);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }

    private ArrayList<Student> loadStudents(){
       File ff = new File(file_name);
       if(!ff.exists()){
           System.out.println("file not found");
           return new ArrayList<>();
       }

        try {
            ObjectInputStream innn = new ObjectInputStream(new FileInputStream(file_name));
             return (ArrayList<Student>) innn.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }
    }

    public Student getstudentByEmail(String email){
        for(Student s : students){
            if(s.getEmail().equals(email)){
                return s;
            }
        }
        return null;
    }

}
