import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable {
    public String Name;
    public int ID;
    public double GPA;
    public int creditHour;
    public String Department;
    public String Email;
    public String Password;
    public ArrayList<Courses> course;
    public Student(){

    }
    public Student(String Name,int ID, double GPA, int creditHour,String Department,String Email, String Password){
        this.Name = Name;
        this.ID = ID;
        this.GPA = GPA;
        this.creditHour = creditHour;
        this.Department = Department;
        this.Email = Email;
        this.Password = Password;
        course = new ArrayList<>();
    }
    public void setName(String Name){
        this.Name = Name;
    }
    public void setID(int ID){
        this.ID =ID;
    }
    public void setGPA(double GPA){
        this.GPA = GPA;
    }
    public void setCreditHour(int creditHour){
        this.creditHour = creditHour;
    }
    public void setDepartment(String Department){
        this.Department = Department;
    }
    public void setEmail(String Email){
        this.Email = Email;
    }
    public void setPassword(String Pass){
        Password = Pass;
    }
    public void setCourse(ArrayList c){
        course = c;
    }
    public String getName(){
        return Name;
    }
    public int getID(){
        return ID;
    }
    public double GPA(){
        return GPA;
    }
    public int getCreditHour(){
        return creditHour;
    }
    public String getDepartment(){
        return Department;
    }
    public String getEmail(){
        return Email;
    }
    public String getPassword(){
        return Password;
    }
    public ArrayList getCourse(){
        return course;
    }
    public boolean checkpassword(String Password){
        return this.Password.equals(Password);
    }

    public void AddCourse(Courses Course){
        course.add(Course);
    }
    public void RemoveCourse(String Course){
        course.remove(Course);
    }
    public void RemovesameCourse(String courseCode){
        course.removeIf(course-> course.getCourseCode().equals(courseCode));
    }
    public String toString(){
        return "Students{ id= "+ID + " name "+Name + "email "+ Email  ;
    }

}
