public class Main {
    public static void main(String[] args) {

        Vegetable cabbage = VegetableFactory.getVegetable("Cabbage");
        Vegetable pumpkin = VegetableFactory.getVegetable("Pumpkin");
        Vegetable carroto = VegetableFactory.getVegetable("Carrot");

        System.out.println(cabbage.getInFo());
        System.out.println(pumpkin.getInFo());
        System.out.println(carroto.getInFo());

        
    }
}
