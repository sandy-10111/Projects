import java.io.*;
import java.util.ArrayList;

public class studentmang {
    ArrayList<Student> students;
    public String file_name = "efjhgvbre";

    public studentmang()  {
        students  = loadStudents();
    }

    public void register(String name, int ID, double GPA, int creditHour, String Department, String Email, String Password){
        if(searchByEmail(Email).equals(Email)){
            System.out.println("email is already exist . try another");
            return;
        }
        students.add(new Student(name, ID, GPA,creditHour, Department,Email, Password));
        saveStudent();
        System.out.println("Student registered successfully");
    }


    public Student login(String email, String password){
        for(Student s : students){
            if(s.getEmail().equals(email) && s.checkpassword(password)){
                System.out.println("student "+ s.getName() +"is registered successfully");
                return s;
            }
        }
        return null;
    }


    public void createStudent(String name, int ID, double GPA, int creditHour, String Department, String Email, String Password){
        Student newstd = new Student(name, ID, GPA, creditHour , Department,Email, Password);
        saveStudent();
        System.out.println("student added successfully");

    }

    public void readStudent(){
        if(students.isEmpty()){
            System.out.println("no data found");
        }else {
            for (Student s : students) {
                System.out.println(s);
            }
        }
    }

    public void updateStudent (int ID, String newName, double newGPA,int newcreadedHour,String newdept,String newemail,String newpass){
        for(Student s : students){
            if(s.getID() == ID){
                s.setName(newName);
                s.setGPA(newGPA);
                s.setCreditHour(newcreadedHour);
                s.setDepartment(newdept);
                s.setEmail(newemail);
                s.setPassword(newpass);
                saveStudent();
                System.out.println("student's data updated successsfully");
            }
        }
    }

    public void deleteStudent(int ID){
        students.removeIf(s -> s.getID()==ID);
        saveStudent();
        System.out.println("student removed successfully");
    }


    private void saveStudent() {

        try {
            ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(file_name));
            oo.writeObject(students);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }




    private Student searchByEmail(String email) {
        for(Student s: students){
            if(s.getEmail().equals(email)){
                return s;
            }
        }
        return null;
    }




    private ArrayList<Student> loadStudents()  {
        File myfile = new File(file_name);
        if(!myfile.exists()){
            System.out.println("the file not found");
            return new ArrayList<>();
        }

        try {
            ObjectInputStream ii = new ObjectInputStream(new FileInputStream(file_name));
            return (ArrayList<Student>)ii.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
           return new ArrayList<>();
        }
    }


}
