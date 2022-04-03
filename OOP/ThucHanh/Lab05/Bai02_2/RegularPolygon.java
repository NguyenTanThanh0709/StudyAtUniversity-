public class RegularPolygon {
    private String name;
    private int egdeAmount;
    private double sideLength;

    public RegularPolygon(String name, int egdeAmount, double sideLength) {
        this.name = name;
        this.egdeAmount = egdeAmount;
        this.sideLength = sideLength;
    }

    public RegularPolygon() {
        this.name = "";
        this.egdeAmount = 3;
        this.sideLength = 1;
    }

    public RegularPolygon(RegularPolygon rp) {
        this.name = rp.name;
        this.egdeAmount = rp.egdeAmount;
        this.sideLength = rp.sideLength;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEgdeAmount() {
        return egdeAmount;
    }

    public void setEgdeAmount(int egdeAmount) {
        this.egdeAmount = egdeAmount;
    }

    public double getSideLength() {
        return sideLength;
    }

    public void setSideLength(double sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public String toString() {
        return "RegularPolygon{" + "name=" + name + ", egdeAmount=" + egdeAmount + ", sideLength=" + sideLength + '}';
    }

    public String getPolygon(){
        if(this.egdeAmount == 3){
            return "Triangle";
        }
        else if(this.egdeAmount == 4){
            return "Square";
        }
        else if(this.egdeAmount == 5){
            return "Pentagon";
        }
        else if(this.egdeAmount == 6){
            return "Hexagon";
        }
        else if(this.egdeAmount == 7){
            return "Heptagon";
        }
        else if(this.egdeAmount == 8){
            return "Octagon";
        }
        else if(this.egdeAmount == 9){
            return "Nonagon";
        }
        else if(this.egdeAmount == 10){
            return "Decagon";
        }
        else{
            return "";
        }
    }

    public double getPerimeter(){
        return this.egdeAmount * this.sideLength;
    }

    public double getArea(){
        double  a = 0.0;

        if(this.egdeAmount == 3){
            a = 0.4333;
        }else if(this.egdeAmount == 4){
            a = 1;
        }else if(this.egdeAmount == 5){
            a = 1.72;
        }else if(this.egdeAmount == 6){
            a = 2.595;
        }
        return (double)this.sideLength * this.sideLength * a; 
    }

}
