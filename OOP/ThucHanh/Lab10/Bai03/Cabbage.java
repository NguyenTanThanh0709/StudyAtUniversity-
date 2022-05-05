public class Cabbage implements Vegetable {
    private String type;
    private double Weight;

    public Cabbage(String type , double Weight) {
        this.type = type;
        this.Weight = Weight;
    }

    public Cabbage() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
        return this.type + " " + this.Weight;
    }
}
    

