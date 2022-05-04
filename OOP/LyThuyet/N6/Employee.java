public abstract class Employee extends Person{

    public Employee(int iD, String fullName, String address, String phoneNumber) {
        super(iD, fullName, address, phoneNumber);
    }
    
    public abstract double heSoLuong();
    public abstract double workHours();
    public abstract void showHowToWork();

    
}
