public class SalariedEmployee extends Employee implements Displayable{
    private double salary;
    private double bonus;
    private double deduction;

    public SalariedEmployee(){

    }
    public SalariedEmployee(String name, String address,int SSN,Gender sex,double salary,double bonus ,double deduction,String mail,String pass){
        super(name,address,SSN,sex,mail,pass);
        this.salary = salary;
        this.bonus = bonus;
        this.deduction = deduction;
    }

    public void setSalary(double salary){
        this.salary =salary;
    }
    public void setBonus(double bonus){
        this.bonus =bonus;
    }
    public void setDeduction(double deduction){
        this.deduction =deduction;
    }
    public double getSalary(){
        return salary;
    }
    public double getBonus(){
        return bonus;
    }
    public double getDeduction(){
        return deduction;
    }

  public double earning(){
        return (salary + bonus)- deduction;
  }
    public void Displayallditails(){
        System.out.println(super.toString());
        System.out.println(toString());
    }
    public void Displayearnings(){
        System.out.println(earning());
    }

    public String toString(){
        return "SalariedEmployee{ "+"salary "+salary +"bonus "+ bonus+ "deduction "+ deduction +"}";
    }

}
