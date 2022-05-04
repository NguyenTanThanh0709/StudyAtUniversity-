public class Chef extends Employee implements ISalary{
    private String rate;
    public Chef(int ID, String fullName, String address, String phoneNumber, String rate) {
        super(ID, fullName, address, phoneNumber);
        this.rate = rate;
    }

    @Override
    public String toString() {
        return super.toString() + "\nRate: " + rate;
    }

    public double bonusByrating(){
        double bonus = 0.0;
        if(rate.equals("A")){
            bonus = heSoLuong() * workHours() * 0.1;
        }
        else if(rate.equals("B")){
            bonus = heSoLuong() * workHours() * 0.05;
        }
        else if(rate.equals("C")){
            bonus = heSoLuong() * workHours() * 0.02;
        }
        return bonus;
    }

    @Override
    public double heSoLuong() {
        double luong = 17.5;
        return luong;
    }

    @Override
    public double workHours() {
        double time = 12.5;
        return time;
    }

    @Override
    public void showHowToWork() {
        System.out.println("Chef is Working");
    }

    @Override
    public double getSalary(){
        return heSoLuong() * 75400.0 + this.bonusByrating();
    }
    
}
