package ClassWork.Bai3;

public class MathStudent extends Student {

    private String sID;

    public MathStudent(String sName, double gpa, String sID) {
        super(sName, gpa);
        this.sID = sID;
    }

    public String getsID() {
        return sID;
    }

    public void setsID(String sID) {
        this.sID = sID;
    }

    @Override
    public String getRank() {
        double gpa = super.getGpa();
        String rank = "";
        if(gpa >= 5){
            rank = "excellent";
        }else{
            rank = "failed";
        }
        // TODO Auto-generated method stub
        return rank;
    }
    
}
