package Main_Test;

import java.util.Scanner;

import Main_packAge_SinhVien.DanhSachSInhVien;
import Main_packAge_SinhVien.SinhVien;

public class Test_QuanLySV{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        DanhSachSInhVien dssv = new DanhSachSInhVien();

        System.out.println(dssv.checkDanhSachRong());

        SinhVien sv = new SinhVien("1234", "thanh", 2003, 9);
        dssv.themSinhVien(sv);
        System.out.println(dssv.soLuongSinhVien());

        SinhVien sv1 = new SinhVien("12343", "tam", 2003, 4);
        dssv.themSinhVien(sv1);
        System.out.println(dssv.soLuongSinhVien());

        dssv.inDanhSachSV();

        System.out.println(dssv.checkDanhSachRong());
        
        dssv.lamRongDanhSachSV();
        dssv.inDanhSachSV();
        System.out.println(dssv.soLuongSinhVien());

        

    }
}