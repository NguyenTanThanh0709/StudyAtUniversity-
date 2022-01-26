public class Main {
    public static void main(String[] args) {
        car car_1 = new car("toyota", "1234" , 12000, 5);
        

        System.out.println(car_1.getId());
        car_1.setId("44444");
        System.out.println(car_1.getId());
        System.out.println(car_1.toString());

        System.out.println(car_1.getDiscountMoney());
        System.out.println(car_1.getTotalMoney());
    }
}
