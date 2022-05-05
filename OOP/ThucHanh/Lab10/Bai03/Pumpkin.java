public class Pumpkin implements Vegetable{

    private double Weight;

    public Pumpkin( double Weight) {
        this.Weight = Weight;
    }

    public Pumpkin() {
    }

    public double getWeight() {
        return Weight;
    }

    public void setWeight(double Weight) {
        this.Weight = Weight;
    }

    @Override
    public String getInFo() {
        // TODO Auto-generated method stub
        return  " " + this.Weight;
    }
}