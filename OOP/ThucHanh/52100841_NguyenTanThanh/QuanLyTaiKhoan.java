import java.util.*;
import java.io.*;

public class QuanLyTaiKhoan{
    private ArrayList<TaiKhoan> tkList;

    public QuanLyTaiKhoan(String path){
        this.tkList = docDanhSachTaiKhoan(path);
    }

    public ArrayList<TaiKhoan> docDanhSachTaiKhoan(String path){
        ArrayList<TaiKhoan> temp = new ArrayList<TaiKhoan>();
        //code here
        File file = new File(path);
        try {
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()){
                String data;
                data = sc.nextLine();
                String[] arr = data.split(",");
                TaiKhoan tk = new TaiKhoan(arr[0], arr[1], arr[2]);
                temp.add(tk);
                
            }
            sc.close();
        } catch (FileNotFoundException e) {
            
        }
        
        return temp;
    }

    public TaiKhoan dangNhap(String tenDangNhap, String matKhau){
        //code here
        for (TaiKhoan taiKhoan : tkList) {
            if(taiKhoan.getTenDangNhap().equals(tenDangNhap)){
                if(taiKhoan.kiemTraDangNhap(matKhau)){
                    return taiKhoan;
                }
            }
        }
        return null;
    }

}