package Main_packAge_SinhVien;

import java.util.ArrayList;

import javax.sound.sampled.ReverbType;

public class DanhSachSInhVien{
    private ArrayList<SinhVien> danhSachSV;

    public DanhSachSInhVien(){
        this.danhSachSV = new ArrayList<>();
    }

    public DanhSachSInhVien(ArrayList<SinhVien> danhSachSV){
        this.danhSachSV = danhSachSV;
    }

    public void themSinhVien(SinhVien SV){
        this.danhSachSV.add(SV);
    }

    public void inDanhSachSV(){
        for (SinhVien sinhVien : danhSachSV) {
            System.out.println(sinhVien);
        }
    }

    public boolean checkDanhSachRong(){
        return this.danhSachSV.isEmpty();
    }

    public int soLuongSinhVien(){
        return this.danhSachSV.size();
    }

    public void lamRongDanhSachSV(){
        //this.danhSachSV.clear();
        this.danhSachSV.removeAll(danhSachSV);
    }

    public boolean kiemTraSinhVien(SinhVien sv){
        return this.danhSachSV.contains(sv);
    }
}