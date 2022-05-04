import java.util.Scanner;

public class Customer extends Person{
    private Menu menu;
    private String level;
    private double discount;
    private String service;
    private String waitingPlace;
    private double tipsMoney;

    public Customer(int ID, String fullName, String address, String phoneNumber, Menu menu, String level, double discount, String service, String waitingPlace, double tipsMoney) {
        super(ID, fullName, address, phoneNumber);
        this.menu = menu;
        this.level = level;
        this.discount = discount;
        this.service = service;
        if(service.equals("Online")){
            this.waitingPlace = "shipper delivery";
        }else if(service.equals("Offline")){
            this.waitingPlace = "block A";
        }else if(service.equals("takeAway")){
            this.waitingPlace = "block B";
        } else{
            this.waitingPlace = "";
        }
        this.tipsMoney = tipsMoney;
    }

    public Customer() {
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getWaitingPlace() {
        return waitingPlace;
    }

    public void setWaitingPlace(String waitingPlace) {
        this.waitingPlace = waitingPlace;
    }

    public double getTipsMoney() {
        return tipsMoney;
    }

    public void setTipsMoney(double tipsMoney) {
        this.tipsMoney = tipsMoney;
    }

    @Override
    public String toString() {
        return  super.toString() +
                "Customer{" +
                "menu=" + menu +
                ", level='" + level + '\'' +
                ", discount=" + discount +
                ", service='" + service + '\'' +
                ", waitingPlace='" + waitingPlace + '\'' +
                ", tipsMoney=" + tipsMoney +
                '}';
    }

    public double totalMoney(){
        double totalmoney = 0.0;
        try (Scanner scanner = new Scanner(System.in)) {
            int id;
            
            menu.showMenu();

                for(;;){
                    System.out.print("id mon an: ");
                    id = scanner.nextInt();

                    menu.showMenu();

                    if(id == 0){
                        break;
                    } else if(id == 1){
                        System.out.println("Bun bo dat thanh cong");
                        totalmoney += 10000;

                    } else if(id == 2){
                        System.out.println("pho bo dat thanh cong");
                        totalmoney += 20000;

                    } else if( id == 3){
                        System.out.println("pho ga dat thanh cong");
                        totalmoney += 30000;

                    }else if(id == 4){
                        System.out.println("pho chay bo dat thanh cong");
                        totalmoney += 40000;

                    }else{
                        System.out.println("het mon an");
                    }

                }
        }
        return totalmoney;
    }

    public double thanhToanHoaDon(){
        double tienLevel = 0.0;
        if(this.level.equals("Vip")){
            tienLevel = totalMoney() * 0.1;
        } else if(this.level.equals("Gold")){
            tienLevel = totalMoney() * 0.05;
        } else if(this.level.equals("Silver")){
            tienLevel = totalMoney() * 0.02;
        } else if(this.level.equals("Normal")){
            tienLevel = totalMoney() * 0.01;
        }

        double phuthu = 0.0;
        if(this.service.equals("online")){
            phuthu = 30000;
        }else if(this.service.equals("offline")){
            phuthu = 10000;
        }else if(this.service.equals("takeAway")){
            phuthu = 0.0;
        }

        return this. totalMoney() - (totalMoney() * discount + tipsMoney + tienLevel + phuthu);
    }

}
