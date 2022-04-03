package Bai01;
public class Cylinder extends Circle{
    private double high = 1.0f;

    public Cylinder(){
        super();
    }

    public Cylinder(double radius){
        super(radius);
    }

    public Cylinder(double radius, double high){
        super(radius);
        this.high = high;
    }

    public Cylinder(double radius, double high, String color){
        super(radius, color);
        this.high = high;
    }

    public double getHigh(){
        return this.high;
    }

    public void setHigh(double high){
        this.high = high;
    }

    public double getVolume(){
        return getArea() * high;
    }

    @Override
    public String toString(){
        return "A Cylinder with radius=" + super.toString() + " and high=" + this.high;
    }

}
