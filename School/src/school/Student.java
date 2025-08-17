/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package school;

import java.util.ArrayList;
import javax.security.auth.Subject;

/**
 *
 * @author PC
 */
public class Student extends Person{
    private double gpa;
    private int creditHour;
    private String department;
    private ArrayList<Subject> subjects;

    public Student(String name, int id, String email, String password,double gpa, int creditHour,String department){
        super(name,id ,email,password);
        this.gpa = gpa;
        this.creditHour = creditHour;
        this.department = department;
        subjects = new ArrayList<>();
    }

    

    

    public void setGpa(double gpa){
        this.gpa = gpa;
    }

    public void setCreditHour(int creditHour){
        this.creditHour = creditHour;
    }

    public void setDepartment(String dept){
        department = dept;
    }

    public void setSubjects(ArrayList subject){
        subjects = subject;
    }

    public double getGpa(){
        return gpa;
    }

    public int getCreditHour(){
        return creditHour;
    }

    public String getDepartment(){
        return department;
    }

    public ArrayList<Subject> getSubjects(){
        return subjects;
    }

    @Override
    public String toString(){
        return "Student: "+ super.toString() +" GPA: "+ gpa+" CreditHour: "+creditHour+" department: "+ department +"subject: "+ subjects;
    }
    
}
