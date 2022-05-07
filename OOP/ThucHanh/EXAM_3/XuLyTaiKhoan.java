import java.io.IOException;

public class XuLyTaiKhoan{
    private TaiKhoan tkDangXuLy;

    public XuLyTaiKhoan(String tenDangNhap, String matKhau) throws IOException{
        QuanLyTaiKhoan qltk = new QuanLyTaiKhoan("DanhSachTaiKhoan.txt");
        tkDangXuLy = qltk.dangNhap(tenDangNhap, matKhau);
    }

    public boolean kiemTraDangNhap(){
        if(tkDangXuLy == null){
            return false;
        }
        return true;
    }

    public boolean doiMatKhau(String matKhauCu, String matKhauMoi){
        boolean check = false;
        if(kiemTraDangNhap() == false){
            check =  false;
        }else{
            this.tkDangXuLy.doiMatKhau(matKhauCu, matKhauMoi);
            check = true;
        }
        
        return check;
    }

    public boolean congDiemThuong(int diemThuong){
        boolean check = false;
        if(kiemTraDangNhap() == false){
            return  false;
        }
        if(tkDangXuLy instanceof TaiKhoan){
            check = false;
        }else{
            check= true;
        }
        return check;
    }

    public String inThongTin(){
        if(kiemTraDangNhap() == false){
            return "Dang nhap that bai";
        }
        return tkDangXuLy.toString();
    }
}