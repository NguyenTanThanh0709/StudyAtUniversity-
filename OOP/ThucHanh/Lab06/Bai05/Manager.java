package Bai05;

public class Manager extends Employee{
    private String position;
    private double salaryCoefficientPosition;


    public Manager() {
        super();
        this.position = "";
        this.salaryCoefficientPosition = 1;
    }

    public Manager(String ID, String fullName, double salaryCoefficientPosition) {
        super(ID, fullName, 2020,salaryCoefficientPosition,0);
        this.position = "";
        this.salaryCoefficientPosition = salaryCoefficientPosition;

    }

    public Manager(String ID, String fullName, int yearJoined, double salaryCoefficientPosition, int numDaysOff) {
        super(ID, fullName, yearJoined, salaryCoefficientPosition, numDaysOff);
        this.position = "";
        this.salaryCoefficientPosition = salaryCoefficientPosition;
    }

    @Override
    public String considerEmulation(){
        return "A";
    }

    public double bonusByPosition(){
        return 1150*this.salaryCoefficientPosition;
    }

    @Override
    public double getSalary(){
        return super.getSalary() +  this.bonusByPosition();
    }

    @Override
    public String toString(){
        return super.toString() + "Position: " + this.position + "\n" + "Salary coefficient position: " + this.salaryCoefficientPosition + "\n" + "Salary: " + this.getSalary();
    }

}
