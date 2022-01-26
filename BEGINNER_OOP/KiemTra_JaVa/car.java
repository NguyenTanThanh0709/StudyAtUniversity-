public class car {
    private String name;
    private String id;
    private int cost;
    private int number;

    public Car() {

    }

    public Car(String name, String id, int cost, int number) {
        this.name = name;
        this.id = id;
        this.cost = cost;
        this.number = number;
    }

    public Car(Car car) {
        this.name = car.name;
        this.id = car.id;
        this.cost = car.cost;
        this.number = car.number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return this.cost;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

    public double getAmount() {
        return number * cost;
    }

    public double getDiscountMoney() {
        double discount = 0;
        if (this.number >= 5) {
            discount = (this.cost * this.number) * 10 / 100;
        } else if (this.number >= 3 && this.number < 5) {
            discount = (this.cost * this.number) * 5 / 100;
        }
        return discount;
    }

    public double getTotalMoney() {
        return this.cost * this.number - this.getDiscountMoney();
    }

    public String toString() {
        return "Car[" + this.name + "_" + this.id + "_" + this.cost + "_" + this.number + "]";
    }
}