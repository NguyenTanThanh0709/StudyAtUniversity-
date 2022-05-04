public class University extends Student implements IGraduate {
    private double essayPoint;
    private String essayName;

    public University(String name, String address, String ID, int credit, double GPA, double essayPoint, String essayName){
        super(name, address, ID, credit, GPA);
        this.essayPoint = essayPoint;
        this.essayName = essayName;
    }

    public University(){
        super();
        this.essayPoint = 0;
        this.essayName = "";
    }

    public double getEssayPoint(){
        return essayPoint;
    }

    public String getEssayName(){
        return essayName;
    }

    public void setEssayPoint(double essayPoint){
        this.essayPoint = essayPoint;
    }

    public void setEssayName(String essayName){
        this.essayName = essayName;
    }

    @Override
    public String toString(){
        return super.toString() + "\nEssay Point: " + essayPoint + "\nEssay Name: " + essayName;
    }

    @Override
    public boolean isGraduate() {
        boolean _isGraduate = false;

        if(super.getCredit() >= 170 && super.getGPA() >= 5.0 && this.getEssayPoint() >= 5){
            _isGraduate = true;
        }
        return _isGraduate;
    }

    
}
