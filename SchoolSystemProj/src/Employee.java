import java.io.Serializable;

enum Gender {male,female};
public abstract class Employee implements Serializable {
    String name;
    String address;
    int SSN;
    Gender sex;
    String Email;
    String password;
    public Employee(){

    }
    public Employee(String name, String address,int SSN,Gender sex,String Email, String password){
        this.name = name;
        this.address = address;
        this.SSN = SSN;
        this.sex = sex;
        this.Email = Email;
        this.password = password;
    }


    public void setName(String name){
        this.name = name;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public void setSSN(int ssn){
        SSN = ssn;
    }
    public void setSex(Gender sex){
        this.sex = sex;
    }
    public void setEmail(String Email){
        this.Email = Email;
    }
    public void setPassword(String Password){
        this.password = password;
    }
    public String getName(){
        return name;
    }
    public String getAddress(){
        return address;
    }
    public int getSSN(){
        return SSN;
    }
    public Gender getSex(){
        return sex;
    }
    public String getEmail(){
        return Email;
    }
    public String getPassword(){
        return password;
    }
   public abstract double earning();

    public String toString(){
        return "Employee{ "+"name "+name +"address "+ address +"SSN "+ SSN+"sex "+ sex+'}';
    }

    public boolean checkPassword(String pass){
        return this.password.equals(pass);
    }
}
