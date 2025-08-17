public class HourlyEmployee extends Employee implements Displayable{
    private double Hour_rate;
    private int Number_of_hours;

    public HourlyEmployee(){

    }
    public HourlyEmployee(double Hour_rate, int Number_of_hours,String name,String address,int SSN,Gender sex){
        this.Hour_rate = Hour_rate;
        this.Number_of_hours = Number_of_hours;
        this.name = name;
        this.address = address;
        this.SSN = SSN;
        this.sex = sex;

    }

    public void setHour_rate(double Hour_rate){
        this.Hour_rate =Hour_rate;
    }
    public void setNumber_of_hours(int number_of_hours){
        this.Number_of_hours = Number_of_hours;
    }
    public double getHour_rate(){
        return Hour_rate;
    }
    public int getNumber_of_hours(){
        return Number_of_hours;
    }
    public  double earning(){
        return Number_of_hours * Hour_rate;
    }

    public void Displayallditails(){
        System.out.println(super.toString());
        System.out.println(toString());
    }
    public void Displayearnings(){
        System.out.println(earning());
    }

    public String toString(){
        return "HourlyEmployee{ "+ "Hour_rate " +Hour_rate+"Number_of_hours "+ Number_of_hours+"}";
    }
}
