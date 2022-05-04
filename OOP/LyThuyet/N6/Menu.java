import java.util.HashMap;

public class Menu {
    private int idMonAn;
    private String tenMonAn;
    private int gia;
    public HashMap<Integer, String> listMonAn = new HashMap<>();

    public Menu(int idMonAn, String tenMonAn, int gia) {
        this.idMonAn = idMonAn;
        this.tenMonAn = tenMonAn;
        this.gia = gia;
        taoMonAn();
    }

    public int getIdMonAn() {
        return idMonAn;
    }

    public void setIdMonAn(int idMonAn) {
        this.idMonAn = idMonAn;
    }

    public String getTenMonAn() {
        return tenMonAn;
    }

    public void setTenMonAn(String tenMonAn) {
        this.tenMonAn = tenMonAn;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public void taoMonAn(){
        listMonAn.put(1, "bun bo");
        listMonAn.put(2, "pho bo");
        listMonAn.put(3, "pho bo");
        listMonAn.put(4, "pho bo");
    }

    public void showMenu(){
        System.out.println("Danh sach mon an");
        System.out.println("bun bo-10k");
        System.out.println("pho bo-20k");
        System.out.println("pho bo-30k");
        System.out.println("pho bo-40k");
        
        for(int i = 1; i <= listMonAn.size(); i++){
            System.out.println(i + ": " + listMonAn.get(i));
        }
    }
}
