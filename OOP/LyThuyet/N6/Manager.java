public class Manager extends Employee implements ISalary {
    private int NumCustomer;

    public Manager(int iD, String fullName, String address, String phoneNumber) {
        super(iD, fullName, address, phoneNumber);
    }

    public Manager(int ID, String fullName, String address, String phoneNumber, int numCustomer) {
        super(ID, fullName, address, phoneNumber);
        this.NumCustomer = numCustomer;
    }

    public int getNumCustomer() {
        return NumCustomer;
    }

    public void setNumCustomer(int numCustomer) {
        NumCustomer = numCustomer;
    }

    @Override
    public String toString(){
        return super.toString() + "\nNumber of Customer: " + NumCustomer;
    }

    @Override
    public double heSoLuong() {
        double hesoLuong = 12.5;
        return hesoLuong;
    }

    @Override
    public double workHours() {
        double time = 8;
        return time;
    }

    @Override
    public void showHowToWork() {
        System.out.println("Manager is Working");
    }

    public double byBonusByNumCustomer(){
        double bonus = 0.0;
        if(NumCustomer > 100){
            bonus = heSoLuong() * workHours() * 0.5;
        }else if(NumCustomer < 100 && NumCustomer > 50){
            bonus = heSoLuong() * workHours() * 0.3;
        }else if(NumCustomer < 50){
            bonus = heSoLuong() * workHours() * 0.1;
        }
        return bonus;
    }

    @Override
    public double getSalary(){
        return heSoLuong() * 65000.0 + this.byBonusByNumCustomer();
    }   
}
