/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package school;

/**
 *
 * @author PC
 */
public class Employee extends Person{
    private String position;
    private double salary;

    public Employee(String name , int id , String email, String password, String position, double salary){
        super(name, id , email, password);
        this.position = position;
        this.salary = salary;
    }

    public void setSalary(double salary){
        this.salary = salary;
    }

    public void setPosition(String position){
        this.position = position;
    }

    public double getSalary(){
        return salary;
    }

    public String getPosition(){
        return position;
    }

    @Override
    public String toString(){
        return "Employee: "+ super.toString()+" position: "+position +" salary: "+ salary;
    }
    
}
