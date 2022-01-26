package Main_packAge_SinhVien;

public class SinhVien implements Comparable<SinhVien>{
    private String maSoSV;
    private String Name;
    private int birthDay;
    private float diemTrungBinh;

    public SinhVien(String maSoSV, String Name, int birthDay, float diemTrungBinh){
        this.Name = Name;
        this.maSoSV = maSoSV;
        this.birthDay = birthDay;
        this.diemTrungBinh =diemTrungBinh;
    }

    public void setMaSoSV(String maSoSv){
        this.maSoSV = maSoSv;
    }

    public String getMaSoSv(){
        return this.maSoSV;
    }

    public void setName(String Name){
        this.Name = Name;
    }

    public String getName(){
        return this.Name;
    }

    public void setBirthDay(int birth){
        this.birthDay = birth;
    }

    public int getBirthday(){
        return this.birthDay;
    }

    public void setDiemTrungBinh(Float diemtb){
        this.diemTrungBinh = diemtb;
    }

    public float getDiemTB(){
        return this.diemTrungBinh;
    }

    

    @Override
    public String toString(){
        return "Sinh Vien [ MSSV: " + this.maSoSV + " - Name: " + this.Name + " - BirthDay: " + this.birthDay + " - Diem: " + this.diemTrungBinh + " ]";
    }

    @Override
    public int compareTo(SinhVien o) {
        // TODO Auto-generated method stub
        return this.maSoSV.compareTo(o.maSoSV);
    }
}