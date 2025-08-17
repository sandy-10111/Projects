import java.io.Serializable;

public class newStudent implements Serializable {
    private int id;
    private String name;
    private String email;


    public newStudent(String name,String email,int id){
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public void setId(int id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getemail(){
        return email;
    }



}
