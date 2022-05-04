package ClassWork.Bai3;

public class ItStudent extends Student{
    private int sID;

    public ItStudent(String sName, double gpa, int sID) {
        super(sName, gpa);
        this.sID = sID;
    }

    public int getsID() {
        return sID;
    }

    public void setsID(int sID) {
        this.sID = sID;
    }

    @Override
    public String getRank() {
        double gpa = super.getGpa();
        String rank = "";

        if(gpa >8 && gpa <= 10){
            rank = "A";
        }else if(gpa >5 && gpa <= 8){
            rank = "B";
        }else{
            rank = "C";
        }

        return rank;
    }
}
