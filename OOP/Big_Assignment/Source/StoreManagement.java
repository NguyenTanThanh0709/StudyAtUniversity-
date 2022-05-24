import java.io.*;
import java.util.*;

public class StoreManagement {
    private ArrayList<Staff> staffs;
    private ArrayList<String> workingTime;
    private ArrayList<Invoice> invoices;
    private ArrayList<InvoiceDetails> invoiceDetails;
    private ArrayList<Drink> drinks;

    public StoreManagement(String staffPath, String workingTimePath, String invoicesPath, String detailsPath, String drinksPath) {
        this.staffs = loadStaffs(staffPath);
        this.workingTime = loadFile(workingTimePath);
        this.invoices = loadInvoices(invoicesPath);
        this.invoiceDetails = loadInvoicesDetails(detailsPath);
        this.drinks = loadDrinks(drinksPath);
    }

    public ArrayList<Staff> getStaffs() {
        return this.staffs;
    }

    public void setStaffs(ArrayList<Staff> staffs){
        this.staffs = staffs;
    }
    
    public ArrayList<Drink> loadDrinks(String filePath) {
        ArrayList<Drink> drinksResult = new ArrayList<Drink>();
        ArrayList<String> drinks = loadFile(filePath);

        for (String drink : drinks) {
            String[] information = drink.split(",");
            drinksResult.add(new Drink(information[0], Integer.parseInt(information[1])));
        }

        return drinksResult;
    }

    public ArrayList<Invoice> loadInvoices(String filePath) {
        ArrayList<Invoice> invoiceResult = new ArrayList<Invoice>();
        ArrayList<String> invoices = loadFile(filePath);

        for (String invoice : invoices) {
            String[] information = invoice.split(",");
            invoiceResult.add(new Invoice(information[0], information[1], information[2]));
        }

        return invoiceResult;
    }

    public ArrayList<InvoiceDetails> loadInvoicesDetails(String filePath) {
        ArrayList<InvoiceDetails> invoiceResult = new ArrayList<InvoiceDetails>();
        ArrayList<String> invoices = loadFile(filePath);

        for (String invoice : invoices) {
            String[] information = invoice.split(",");
            invoiceResult.add(new InvoiceDetails(information[0], information[1], Integer.parseInt(information[2])));
        }

        return invoiceResult;
    }

    // requirement 1
    public ArrayList<Staff> loadStaffs(String filePath) {
        ArrayList<Staff> staffsResult = new ArrayList<Staff>();
        ArrayList<String> staffs = loadFile(filePath);

        for(String staff: staffs){
            String[] information = staff.split(",");
            int lenghtInformation = information.length;
            if(lenghtInformation == 3){
                Staff newStaff = new SeasonalStaff(information[0], information[1], Integer.parseInt(information[2]));
                staffsResult.add(newStaff);
            }else if(lenghtInformation == 4){
                Staff newStaff = new FullTimeStaff(information[0], information[1], Integer.parseInt(information[2]), Double.parseDouble(information[3]));
                staffsResult.add(newStaff);
            }else if(lenghtInformation == 5){
                Staff newStaff = new Manager(information[0], information[1], Integer.parseInt(information[2]), Double.parseDouble(information[3]),  Integer.parseInt(information[4]));
                staffsResult.add(newStaff);
            }else{
                continue;
            }
        }

        return staffsResult;
    }

    public int getWorkedHoues(String idName){
        int workedHoues = 0;
        for(String workingTime: this.workingTime){
            String[] information = workingTime.split(",");
            if(information[0].equals(idName)){
                workedHoues = Integer.parseInt(information[1]);
                break;
            }
        }
        return workedHoues;
    }

    // requirement 2
    public ArrayList<SeasonalStaff> getTopFiveSeasonalStaffsHighSalary() {
        // code here and modify the return value
        ArrayList<SeasonalStaff> result = new ArrayList<SeasonalStaff>();
        ArrayList<SeasonalStaff> seasonalStaffs = new ArrayList<SeasonalStaff>();
        for(Staff staff: staffs){
            if(staff instanceof SeasonalStaff){
                seasonalStaffs.add((SeasonalStaff) staff);
            }
        }
        Collections.sort(seasonalStaffs, new Comparator<SeasonalStaff>() {
            @Override
            public int compare(SeasonalStaff o1, SeasonalStaff o2) {
                return (int) (o2.paySalary(getWorkedHoues(o2.sID)) - o1.paySalary(getWorkedHoues(o1.sID)));
            }
        });
        for(int i = 0; i < 5; i++){
            result.add(seasonalStaffs.get(i));
        }

        // for (SeasonalStaff Result : result) {
        //     System.out.println(Result.toString());
        // }
        return result;

    }

    // requirement 3
    public ArrayList<FullTimeStaff> getFullTimeStaffsHaveSalaryGreaterThan(int lowerBound) {
        //code here and modify the return value
        ArrayList<FullTimeStaff> result = new ArrayList<FullTimeStaff>();
        ArrayList<FullTimeStaff> fullTimeStaffs = new ArrayList<FullTimeStaff>();
        for(Staff staff: staffs){
            if(staff instanceof FullTimeStaff){
                fullTimeStaffs.add((FullTimeStaff) staff);
            }
        }
        for(FullTimeStaff fullTimeStaff: fullTimeStaffs){
            if(fullTimeStaff.paySalary(getWorkedHoues(fullTimeStaff.sID)) > lowerBound){
                result.add(fullTimeStaff);
            }
        }

        // for (FullTimeStaff Result : result) {
        //     // System.out.println(Result.toString());
        // }
        return result;
    }

    public ArrayList<String> codeBillInQuarter(int quarter){
        ArrayList<String> result = new ArrayList<String>();
        for (Invoice INVOICE : invoices) {
            String[] informationDate = INVOICE.getDate().split("/");
            int month = Integer.parseInt(informationDate[1]);
            if(quarter == 1){
                if(month == 1 || month == 2 || month == 3){
                    result.add(INVOICE.getInvoiceID());
                }
            }else if(quarter == 2){
                if(month == 4 || month == 5 || month == 6){
                    result.add(INVOICE.getInvoiceID());
                }
            }else if(quarter == 3){
                if(month == 7 || month == 8 || month == 9){
                    result.add(INVOICE.getInvoiceID());
                }
            }else if(quarter == 4){
                if(month == 10 || month == 11 || month == 12){
                    result.add(INVOICE.getInvoiceID());
                }
            }
        }
        return result;
    }

    public double getTotalPriceOfBill(ArrayList<String> billID){
        double totalPrice = 0.0;
        for(String bill: billID){
            for(InvoiceDetails ID: invoiceDetails){
                if(ID.getInvoiceID().equals(bill)){
                    String drinkID = ID.getDName();
                    int soLuong = ID.getAmount();
                    for(Drink drink: drinks){
                        if(drink.getdName().equals(drinkID)){
                            totalPrice += drink.getPrice() * soLuong;
                        }
                    }
                }
            }
        }
        return totalPrice;
    }

    // requirement 4
    public double totalInQuarter(int quarter) {
        double total = 0;
        ArrayList<String> LISTinvoicesID = codeBillInQuarter(quarter);
        System.out.println(LISTinvoicesID.size());
        for (String string : LISTinvoicesID) {
            System.out.println(string);
        }

        total = getTotalPriceOfBill(LISTinvoicesID);
        return total;
    }


    // public ArrayList<ListMaNVANDMaHD> getListMaNVANDMaHDTrongThang(int month){
    //     ArrayList<ListMaNVANDMaHD> result = new ArrayList<ListMaNVANDMaHD>();
    //     for(Invoice INVOICE : invoices){
    //         String[] informationDate = INVOICE.getDate().split("/");
    //         int monthInvoices = Integer.parseInt(informationDate[1]);
    //         if(monthInvoices == month){
    //             ListMaNVANDMaHD nhanVien = new ListMaNVANDMaHD(INVOICE.getStaffID(), INVOICE.getInvoiceID());
    //             result.add(nhanVien);
    //         }
    //     }
    //     return result;
    // }

    // public ArrayList<String> getListNhanVienTrongThang(ArrayList<ListMaNVANDMaHD> getListMaNVANDMaHDTrongThang){
    //     ArrayList<String> NhanVien = new ArrayList<String>();
    //     for(ListMaNVANDMaHD nhanVien: getListMaNVANDMaHDTrongThang){
    //         NhanVien.add(nhanVien.getMaNV());
    //     }

    //     ArrayList<String> TEMP_NhanVien = new ArrayList<String>();
    //     for(int i = 0; i < NhanVien.size(); i++){
    //         if( !TEMP_NhanVien.contains(NhanVien.get(i))){
    //             TEMP_NhanVien.add(NhanVien.get(i));
    //         }
    //     }
    //     return TEMP_NhanVien;
    // }

    // public ArrayList<MaNVANDTienTrongThang> getMaNVANDTienTrongThang(ArrayList<ListMaNVANDMaHD> _listMaNVANDMaHD,ArrayList<String> listNhanVien){
    //     ArrayList<MaNVANDTienTrongThang> result = new ArrayList<MaNVANDTienTrongThang>();

    //     for (String nhanvien : listNhanVien) {
    //         int TongTien = 0;
    //         for (ListMaNVANDMaHD MANhanVien: _listMaNVANDMaHD) {
    //             if(nhanvien.equals(MANhanVien.getMaNV())){
    //                 String maHD = MANhanVien.getMaHD();
    //                 for (InvoiceDetails invoice: invoiceDetails) {
    //                     if(maHD.equals(invoice.getInvoiceID())){
    //                         String drinkID = invoice.getDName();
    //                         int soLuong = invoice.getAmount();
    //                         for(Drink drink: drinks){
    //                             if(drinkID.equals(drink.getdName())){
    //                                 TongTien += drink.getPrice()*soLuong;
    //                             }
    //                         }
    //                     }
    //                 }

    //             }
    //         }
    //         MaNVANDTienTrongThang nhanVien = new MaNVANDTienTrongThang(nhanvien, TongTien);
    //         result.add(nhanVien);
    //     }
    //     return result;
    // }

    // public MaNVANDTienTrongThang TimMaxNhanVien(ArrayList<MaNVANDTienTrongThang> listMaNVANDTienTrongThang){
    //     MaNVANDTienTrongThang maxObject = Collections.max(listMaNVANDTienTrongThang, new Comparator<MaNVANDTienTrongThang>() {
    //         @Override
    //         public int compare(MaNVANDTienTrongThang o1, MaNVANDTienTrongThang o2) {
    //             if (o1.getTien() == o2.getTien()) {
    //                 return 0;
    //             } else if (o1.getTien() < o2.getTien()) {
    //                 return -1;
    //             } else if (o1.getTien() > o2.getTien()) {
    //                 return 1;
    //             }
    //             return 0;
    //         }
    //     });
    //     return maxObject;
    // }

    // public Staff MAXSTAFF(MaNVANDTienTrongThang maxObject){
    //     Staff staff = null;
    //     String MaNhanVien = maxObject.getMaNV();
    //     for(Staff STAFF:staffs){
    //         if(MaNhanVien.equals(STAFF.getsID())){
    //             staff = STAFF;
    //             break;
    //         }
    //     }
    //     return staff;
    // }
    // requirement 5

    public ArrayList<String> getListNhanVienTrongThang(int month){
        ArrayList<String> NhanVien = new ArrayList<String>();
        for(Invoice nhanVien: invoices){
            String DATE = nhanVien.getDate();
            String[] inforDate = DATE.split("/");
            int thang = Integer.parseInt(inforDate[1]);
            if(thang == month){
                NhanVien.add(nhanVien.getStaffID());
            }

        }

        ArrayList<String> TEMP_NhanVien = new ArrayList<String>();
        for(int i = 0; i < NhanVien.size(); i++){
            if( !TEMP_NhanVien.contains(NhanVien.get(i))){
                TEMP_NhanVien.add(NhanVien.get(i));
            }
        }
        return TEMP_NhanVien;
    }

    public HashMap<String, Integer> list_Money_Staff(ArrayList<String> listNhanVien, int month){
        HashMap<String, Integer> result = new HashMap<String, Integer>();
        for (String nhanvien : listNhanVien) {
            int money = 0;
            for (Invoice IDStaff : invoices) {
                String DATE = IDStaff.getDate();
                String[] inforDate = DATE.split("/");
                int thang = Integer.parseInt(inforDate[1]);
                if(nhanvien.equals(IDStaff.getStaffID()) && thang == month){
                    String maHD = IDStaff.getInvoiceID();
                    for (InvoiceDetails invoice: invoiceDetails) {
                        if(maHD.equals(invoice.getInvoiceID())){
                            String drinkID = invoice.getDName();
                            int soLuong = invoice.getAmount();
                            for(Drink drink: drinks){
                                if(drinkID.equals(drink.getdName())){
                                    money += drink.getPrice()*soLuong;
                                }
                            }
                        }
                    }
                }
            }
            result.put(nhanvien, money);
        }
        return result;
    }

    public String MAXSTAFF(HashMap<String, Integer> list_Money_Staff){
        String staff = "";
        int max = Collections.max(list_Money_Staff.values());
        for(String key: list_Money_Staff.keySet()){
            if(list_Money_Staff.get(key) == max){
                staff = key;
                break;
            }
        }
        return staff;
    }

    public Staff getStaffHighestBillInMonth(int month) {
        Staff maxStaff = null;
        ArrayList<String> listNhanVien = getListNhanVienTrongThang(month);
        for (String string : listNhanVien) {
            System.out.println(string);
        }

        HashMap<String, Integer> list_Money_Staff = list_Money_Staff(listNhanVien, month);
        for (String string : list_Money_Staff.keySet()) {
            System.out.println(string + ": " + list_Money_Staff.get(string));
        }

        String staff = MAXSTAFF(list_Money_Staff);
        System.out.println(staff);
        for(Staff STAFF:staffs){
            if(staff.equals(STAFF.getsID())){
                maxStaff = STAFF;
                break;
            }
        }
        return maxStaff;
        //code here
        // ArrayList<ListMaNVANDMaHD> _listMaNVANDMaHD = getListMaNVANDMaHDTrongThang(month);
        // System.out.println(_listMaNVANDMaHD.size());
        // if(_listMaNVANDMaHD.size() == 0){
        //     Staff _maxStaff = null;
        //     return _maxStaff;
        // }
        // for (ListMaNVANDMaHD listMaNVANDMaHD2 : _listMaNVANDMaHD) {
        //     System.out.println(listMaNVANDMaHD2.toString());
        // }
        // System.out.println("==========================================================");

        // ArrayList<String> listNhanVien = getListNhanVienTrongThang(_listMaNVANDMaHD);
        // for (String string : listNhanVien) {
        //     System.out.println(string);
        // }
        //  System.out.println("==========================================================");
        // ArrayList<MaNVANDTienTrongThang> listMaNVANDTienTrongThang = getMaNVANDTienTrongThang(_listMaNVANDMaHD, listNhanVien);
        // // for (MaNVANDTienTrongThang maNVANDTienTrongThang : listMaNVANDTienTrongThang) {
        // //     System.out.println(maNVANDTienTrongThang.toString());
        // // }

        // MaNVANDTienTrongThang maxObject = TimMaxNhanVien(listMaNVANDTienTrongThang);
        // // System.out.println(maxObject.toString());
        // maxStaff = MAXSTAFF(maxObject);
        // return maxStaff;
    }

    // load file as list
    public static ArrayList<String> loadFile(String filePath) {
        String data = "";
        ArrayList<String> list = new ArrayList<String>();

        try {
            FileReader reader = new FileReader(filePath);
            BufferedReader fReader = new BufferedReader(reader);

            while ((data = fReader.readLine()) != null) {
                list.add(data);
            }

            fReader.close();
            reader.close();

        } catch (Exception e) {
            System.out.println("Cannot load file");
        }
        return list;
    }

    public void displayStaffs() {
        for (Staff staff : this.staffs) {
            System.out.println(staff);
        }
    }

    public <E> boolean writeFile(String path, ArrayList<E> list) {
        try {
            FileWriter writer = new FileWriter(path);
            for (E tmp : list) {
                writer.write(tmp.toString());
                writer.write("\r\n");
            }

            writer.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("Error.");
            return false;
        }

        return true;
    }

    public <E> boolean writeFile(String path, E object) {
        try {
            FileWriter writer = new FileWriter(path);

            writer.write(object.toString());
            writer.close();

            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("Error.");
            return false;
        }

        return true;
    }
}

// class ListMaNVANDMaHD{
//     String maNV;
//     String maHD;
//     public ListMaNVANDMaHD(String maNV, String maHD){
//         this.maNV = maNV;
//         this.maHD = maHD;
//     }
//     public String getMaNV(){
//         return this.maNV;
//     }
//     public String getMaHD(){
//         return this.maHD;
//     }

//     @Override
//     public String toString() {
//         return maHD + " " + maNV;
//     }
// }

// class MaNVANDTienTrongThang{
//     String maNV;
//     double tien;
//     public MaNVANDTienTrongThang(String maNV, double tien){
//         this.maNV = maNV;
//         this.tien = tien;
//     }
//     public String getMaNV(){
//         return this.maNV;
//     }
//     public double getTien(){
//         return this.tien;
//     }

//     @Override
//     public String toString() {
//         return maNV + " " + tien;
//     }
// }

