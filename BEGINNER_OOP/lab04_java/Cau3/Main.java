public class Main {
    public static void main(String[] args) {
        Student st1 = new Student(1234, "Nguyen", "Thanh");

        System.out.println(st1.getID());
        System.out.println(st1.getLastName());

        st1.setID(121);
        System.out.println(st1.getID());

        System.out.println(st1.toString());
    }
}
