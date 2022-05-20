public class SeasonalStaff extends Staff{
    private int hourlyWage;

    public SeasonalStaff(String sID, String sName, int hourlyWage) {
        super(sID, sName);
        this.hourlyWage = hourlyWage;
    }

    public int getHourlyWage() {
        return this.hourlyWage;
    }

    public void setHourlyWage(int hourlyWage) {
        this.hourlyWage = hourlyWage;
    }

    @Override
    public double paySalary(int workedHoues) {
        // TODO Auto-generated method stub
        return  1.0*getHourlyWage()*workedHoues;
    }

    @Override
    public String toString() {
        return super.toString() + "_" + this.hourlyWage;
    }

}