public class Student{
    private String name, address, ID;
    private int credit;
    private double GPA;

    public Student(String name, String address, String ID, int credit, double GPA){
        this.name = name;
        this.address = address;
        this.ID = ID;
        this.credit = credit;
        this.GPA = GPA;

    }

    public Student(){
        this.name = "";
        this.address = "";
        this.ID = "";
        this.credit = 0;
        this.GPA = 0;
    }

    public String getName(){
        return name;
    }

    public String getAddress(){
        return address;
    }

    public String getID(){
        return ID;
    }

    public int getCredit(){
        return credit;
    }

    public double getGPA(){
        return GPA;
    }


    public void setName(String name){
        this.name = name;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public void setID(String ID){
        this.ID = ID;
    }

    public void setCredit(int credit){
        this.credit = credit;
    }

    public void setGPA(double GPA){
        this.GPA = GPA;
    }


    @Override
    public String toString(){
        return "Name: " + name + "\nAddress: " + address + "\nID: " + ID + "\nCredit: " + credit + "\nGPA: " + GPA + "\nGraduate Point: ";
    }
}