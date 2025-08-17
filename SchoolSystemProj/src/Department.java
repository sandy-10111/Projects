import java.util.ArrayList;

public class Department {
    int departNo;
    String deName;
    ArrayList<Employee> emplist;


    public Department(){

    }

    public Department(int departNo, String deName){
        this.departNo = departNo;
        this.deName = deName;
       emplist = new ArrayList<Employee>();
    }
    public void setDepartNo(int departno){
        departNo = departno;
    }
    public void setDeName(String deName){
        this.deName = deName;
    }
    public void setEmplist(ArrayList emp){
        emplist = emp;
    }
    public int getDepartNo(){
        return departNo;
    }
    public String getDeName(){
        return deName;
    }
    public ArrayList getempList(){
        return emplist;
    }
    public void AddEmployee(Employee e){
        emplist.add(e);
    }
    public void RemoveEmployee(int ind ){
        emplist.remove(ind);
    }
    public int getemployeeCount(){
        return emplist.size();
    }
    public void print_basic_data(){
        for(int i=0;i<emplist.size();i++){
            System.out.println(emplist.get(i).getSSN()+"  "+ emplist.get(i).getName() +"  "+ emplist.get(i).getSex());
        }
    }
    public void print_All_details(){
        for(int i=0;i<emplist.size();i++){
            if(emplist.get(i) instanceof SalariedEmployee) {
                ((SalariedEmployee) emplist.get(i)).Displayallditails();
            }
            if(emplist.get(i) instanceof HourlyEmployee){
                ((HourlyEmployee) emplist.get(i)).Displayallditails();
            }
            if(emplist.get(i) instanceof CommissionEmployee ){
                ((CommissionEmployee) emplist.get(i)).Displayallditails();
            }
        }
    }

}
