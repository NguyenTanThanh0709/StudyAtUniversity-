public class Employee{
    private String eID;
    private String eName;
    private int eSalary;
    private String eDept;

    public Employee(String eID, String eName, int eSalary, String eDept){
        String temp = "Administration";
        if(eDept.equals("Administration") || eDept.equals("Accounting") || eDept.equals("Human Resources") || eDept.equals("Customer Service")){
            temp = eDept;
        }else{
            temp = "Administration";
        }

        this.eID =  eID;
        this.eName = eName;
        this.eSalary = eSalary;
        this.eDept = temp;
    }

    public double getBonus(){
        double Bonus = 0;
        if(this.eDept.equals("Administration")){
            Bonus = this.eSalary * 0.5;
        }
        else if(this.eDept.equals("Accounting") || this.eDept.equals("Human Resources")){
            Bonus = this.eSalary * 0.3;
        }
        else if(this.eDept.equals("Customer Service")){
            Bonus = this.eSalary * 0.1;
        }
      
        return Bonus;
    }

    public double totalSalary(int numOfWorkingDays){
        double total1 = 0.0;
        double total2 = 0.0;

        total1 = this.eSalary*numOfWorkingDays + this.getBonus();

        if(numOfWorkingDays >= 20){
            total2 = total1 * 0.05;
        }

        return total1+total2;
    }

    public String geteID() {
        return eID;
    }

    public void seteID(String eID) {
        this.eID = eID;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public int geteSalary() {
        return eSalary;
    }

    public void seteSalary(int eSalary) {
        this.eSalary = eSalary;
    }

    public String geteDept() {
        return eDept;
    }

    public void seteDept(String eDept) {
        this.eDept = eDept;
    }

   
}