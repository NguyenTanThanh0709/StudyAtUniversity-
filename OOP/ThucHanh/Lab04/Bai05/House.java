package Bai05;

public class House {
    private String houseCode;
    private int numOfBedRooms;
    private boolean hasSwimmingPool;
    private double area;
    private double costPerSquareMeter;

    public House() {
        this.area = 0;
        this.costPerSquareMeter = 0;
        this.houseCode = "A01";
        this.numOfBedRooms = 2;
        this.hasSwimmingPool = false;
    }

    public House(String houseCode, int numOfBedRooms, boolean hasSwimmingPool, double area, double costPerSquareMeter) {
        this.houseCode = houseCode;
        this.numOfBedRooms = numOfBedRooms;
        this.hasSwimmingPool = hasSwimmingPool;
        this.area = area;
        this.costPerSquareMeter = costPerSquareMeter;
    }

    public String getHouseCode() {
        return houseCode;
    }

    public void setHouseCode(String houseCode) {
        this.houseCode = houseCode;
    }

    public int getNumOfBedRooms() {
        return numOfBedRooms;
    }

    public void setNumOfBedRooms(int numOfBedRooms) {
        this.numOfBedRooms = numOfBedRooms;
    }

    public boolean isHasSwimmingPool() {
        return hasSwimmingPool;
    }

    public void setHasSwimmingPool(boolean hasSwimmingPool) {
        this.hasSwimmingPool = hasSwimmingPool;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getCostPerSquareMeter() {
        return costPerSquareMeter;
    }

    public void setCostPerSquareMeter(double costPerSquareMeter) {
        this.costPerSquareMeter = costPerSquareMeter;
    }

    public double calculateSellingPrice(){
        double SubTotal = this.area * this.costPerSquareMeter;
        if(isHasSwimmingPool()){
            SubTotal += SubTotal * 0.1;
        }

        return SubTotal + 0.15*SubTotal;
    }

    @Override
    public String toString(){
        return "House{" +
                "houseCode='" + houseCode + '\'' +
                ", numOfBedRooms=" + numOfBedRooms +
                ", hasSwimmingPool=" + hasSwimmingPool +
                ", area=" + area +
                ", costPerSquareMeter=" + costPerSquareMeter +
                '}' + "\n" + "Selling Price: " + calculateSellingPrice();
    }

}
