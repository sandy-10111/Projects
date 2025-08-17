/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package school;

import java.io.Serializable;

/**
 *
 * @author PC
 */
public class Person implements Serializable{
    protected static String name;
    protected static int id;
    protected static String email;
    protected static String password;

    public Person(String name , int id , String email, String password){
        this.name = name ;
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public static String getName(){
        return name;
    }

    public static int getId(){
        return id;
    }

    public static String getEmail(){
        return email;
    }

    public static String getPassword(){
        return password;
    }

    public boolean checkPassword(String password){
        return this.password.equals(password);
    }

    @Override
    public String toString(){
        return "ID: "+ id+" name: "+ name+ " email: "+ email;
    }
    
}
