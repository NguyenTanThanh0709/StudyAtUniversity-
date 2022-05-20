public class FullTimeStaff extends Staff{
    protected int baseSalary;
    protected double bonusRate;

    public FullTimeStaff(String sID, String sName, int baseSalary, double bonusRate) {
        super(sID, sName);
        this.baseSalary = baseSalary;
        this.bonusRate = bonusRate;
    }

    public int getBaseSalary() {
        return this.baseSalary;
    }

    public void setBaseSalary(int baseSalary) {
        this.baseSalary = baseSalary;
    }

    public double getBonusRate() {
        return this.bonusRate;
    }

    public void setBonusRate(double bonusRate) {
        this.bonusRate = bonusRate;
    }

    @Override
    public double paySalary(int workedDays) {
        // TODO Auto-generated method stub
        double bonus  = 0.0;
        double salary = 0.0;
        if(workedDays <= 21){
            bonus = 0.0;
        }else if(workedDays > 21){
            bonus = (workedDays-21)*100000.0;
        }
        salary = getBaseSalary()*getBonusRate()*1.0 + bonus;
        return salary;
    }

    @Override
    public String toString() {
        return super.toString() + "_"  + this.bonusRate  + "_" + this.baseSalary  ;
    }
    
}
