package Bai05;

public class Employee {
    private String ID;
    private String fullName;
    private int yearJoined;
    private double coefficientsSalary;
    private int numDaysOff;

    public Employee() {
        this.ID = "0";
        this.fullName = "";
        this.yearJoined = 2020;
        this.coefficientsSalary = 1;
        this.numDaysOff = 0;
    }

    public Employee(String ID, String fullName, double coefficientsSalary){
        this.ID = ID;
        this.fullName = fullName;
        this.yearJoined = 2020;
        this.coefficientsSalary = coefficientsSalary;
        this.numDaysOff = 0;
    }

    public Employee(String ID, String fullName, int yearJoined, double coefficientsSalary, int numDaysOff) {
        this.ID = ID;
        this.fullName = fullName;
        this.yearJoined = yearJoined;
        this.coefficientsSalary = coefficientsSalary;
        this.numDaysOff = numDaysOff;
    }   

    public double getSenioritySalary(){
        if(2022-this.yearJoined >= 5){
            return (2022-this.yearJoined)*this.coefficientsSalary*1150/100;
        }
        return 0;
    } 

    public String considerEmulation(){
        if(this.numDaysOff <= 1){
            return "A";
        }else if(this.numDaysOff <= 3){
            return "B";
        }else{
            return "C";
        }
    }

    public double getSalary(){
        String rate = this.considerEmulation();
        double emulation;

        if(rate.equals("A")){
            emulation = 1;
        }else if(rate.equals("B")){
            emulation = 0.75;
        }else{
            emulation = 0.5;
        }

        return 1150 + 1150*(this.coefficientsSalary + emulation) + this.getSenioritySalary();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "ID='" + ID + '\'' +
                ", fullName='" + fullName + '\'' +
                ", yearJoined=" + yearJoined +
                ", coefficientsSalary=" + coefficientsSalary +
                ", numDaysOff=" + numDaysOff +
                '}';
    }
}
