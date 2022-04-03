package Bai02;

public class Circle implements GeometricObject{
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getPerimeter() {
        // TODO Auto-generated method stub
        
        return this.radius * this.radius * Math.PI;
    }

    @Override
    public double getArea() {
        // TODO Auto-generated method stub
        return 2* Math.PI * this.radius;
    }
    
}
