public class Application {
    public static void main(String[] args) {
        
        Waiter waiter = new Waiter(0, "ntzz", "hanoi", "121", "Waiter");
        System.out.println(waiter.toString());
        System.out.println(waiter.getSalary());

        Chef chef = new Chef(1, "nz31", "hanoi", "121212121", "A");
        System.out.println(chef.toString());
        System.out.println(chef.getSalary());

        Receptionist receptionist = new Receptionist(3, "anh", "hcm", "121721");
        System.out.println(receptionist.toString());
        System.out.println(receptionist.getSalary());

        Menu menu = new Menu(1,null,0);

        Customer customer = new Customer(3, "anh", "hcm", "121721",menu,"Gold",0.0,"online", null,2);
        System.out.println(customer.toString());
        System.out.println(customer.totalMoney());
        System.out.println(customer.thanhToanHoaDon());
    }
}
