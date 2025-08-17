/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package school;

/**
 *
 * @author PC
 */
public class Teacher extends Person{
     private String subject;
    private double salary;

    public Teacher(String name , int id , String email, String password,String subject){
        super(name, id ,email, password);
        this.subject = subject;
       // this.salary = salary;
    }

    

    

    public String getSubject(){
        return subject;
    }

     @Override
    public String toString(){
        return super.toString() + "subject: "+ subject + "salary: "+ salary;
    }
    
}
