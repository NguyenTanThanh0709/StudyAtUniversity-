public class Waiter extends Employee implements ISalary{
    private String position;

    public Waiter(int ID, String fullName, String address, String phoneNumber, String position) {
        super(ID, fullName, address, phoneNumber);
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString(){
        return super.toString() + "\nPosition: " + position;
    }


    @Override
    public double heSoLuong() {
        double hesoLuong = 10.5;
        return hesoLuong;
    }

    @Override
    public double workHours() {
        double workhours = 9;
        return workhours;
    }

    @Override
    public void showHowToWork() {
        System.out.println("Waiter is Working");
    }

    public double bonusByPosition(){
        double bonus = 0.0;
        if(position.equals("Waiter")){
            bonus = heSoLuong() * workHours() * 0.1;
        }
        return bonus;
    }

    @Override
    public double getSalary(){
        return heSoLuong() * 50000.0 + this.bonusByPosition();
    }
    
}
