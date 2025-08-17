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
public class Subject implements Serializable{
  String name;
    int code;

    public Subject( String name , int code){
        this.name = name;
        this.code = code;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setCode(int code){
        this.code = code;
    }

    public String getName(){
        return name;
    }

    public int getCode(){
        return code;
    }  
    
}
