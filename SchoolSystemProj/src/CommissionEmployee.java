public class CommissionEmployee extends Employee implements Displayable{
    private double gross_Sales;
    private double Commission_rate;

    public CommissionEmployee(){

    }
     public CommissionEmployee(String name, String address,int SSN,Gender sex,double gross_Sales,double Commission_rate){
         this.name = name;
         this.address = address;
         this.SSN =SSN;
         this.sex =sex;
         this.gross_Sales = gross_Sales;
         this.Commission_rate =Commission_rate;
     }

    public void setGross_Sales(double gross_Sales){
        this.gross_Sales = gross_Sales;
    }
    public void setCommission_rate(double commission_rate){
        this.Commission_rate = commission_rate;
    }
    public double getGross_Sales(){
        return gross_Sales;
    }
    public double getCommission_rate(){
        return Commission_rate;
    }

    public String toString(){
        return "CommissionEmployee{ "+"gross_Sales " + gross_Sales+ "Commission_rate "+ Commission_rate +"}" ;
    }
    public  double earning(){
        return gross_Sales * Commission_rate;
    }
    public void Displayallditails() {
        System.out.println(super.toString());
        System.out.println(toString());
    }
    public void Displayearnings(){
        System.out.println(earning());
    }

}
