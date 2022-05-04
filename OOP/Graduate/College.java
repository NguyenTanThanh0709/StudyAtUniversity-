public class College extends Student implements IGraduate {
    private double graduatePoint;

    public College(String name, String address, String ID, int credit, double GPA, double graduatePoint){
        super(name, address, ID, credit, GPA);
        this.graduatePoint = graduatePoint;
    }

    public College(){
        super();
        this.graduatePoint = 0;
    }

    public double getGraduatePoint(){
        return graduatePoint;
    }

    public void setGraduatePoint(double graduatePoint){
        this.graduatePoint = graduatePoint;
    }
    
    @Override
    public String toString(){
        return super.toString() + "\nGraduate Point: " + graduatePoint;
    }

    @Override
    public boolean isGraduate() {
        boolean _isGraduate = false;

        if(super.getCredit() >= 120 && super.getGPA() >= 5.0 && this.getGraduatePoint() >= 5){
            _isGraduate = true;
        }
        return _isGraduate;
        }
        
    
    
}
