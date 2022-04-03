package Bai02;

public class resizableCircle extends Circle implements Resizable{

    public resizableCircle(double radius) {
        super(radius);
    }

    @Override
    public void resize(int percent) {
        double r = super.getRadius();

        r = r * percent /100.0;

        super.setRadius(r);
        
    }
    
}
