public class Receptionist extends Employee implements ISalary{
    public Receptionist(int ID, String fullName, String address, String phoneNumber) {
        super(ID, fullName, address, phoneNumber);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public double heSoLuong() {
        double luong = 15.0;
        return luong;
    }

    @Override
    public double workHours() {
        double time = 10;
        return time;
    }

    @Override
    public void showHowToWork() {
        System.out.println("Receptionist is Working"); 
    }

    @Override
    public double getSalary(){
        return heSoLuong() * 55000.0;
    }
    
}
