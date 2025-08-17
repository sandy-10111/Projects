public class BasePlusCommissionEmployee extends CommissionEmployee{
    private double base;

    public void setBase(double base){
        this.base = base;
    }
    public double getBase(){
        return base;
    }

    public double earning(){
        return base + super.earning();
    }
    public void Displayallditails(){
        super.Displayallditails();
        Displayearnings();
    }
    public void Displayearnings(){
        System.out.println(earning());
    }
}
