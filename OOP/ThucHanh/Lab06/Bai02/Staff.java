package Bai02;

public class Staff extends Person{
    private String School;
    private double pay;

    public Staff() {
    }

    public Staff(String name, String address, String School, double pay) {
        super(name, address);
        this.School = School;
        this.pay = pay;
    }

    public String getSchool() {
        return School;
    }

    public void setSchool(String School) {
        this.School = School;
    }

    public double getPay() {
        return pay;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }

    @Override
    public String toString() {
        return super.toString() + "Staff{" + "School=" + School + ", pay=" + pay + '}';
    }
}
