package ClassWork.Bai3;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Student> listStudent = new ArrayList<>();
        listStudent.add(new ItStudent("Nguyen Van A", 9.5, 123));
        listStudent.add(new ItStudent("Nguyen Van B", 8.5, 124));
        listStudent.add(new ItStudent("Nguyen Van C", 7.5, 125));
        listStudent.add(new MathStudent("Nguyen Van D", 7.5, "12aH"));

        System.out.println("Danh sach sinh vien: ");
        for (Student student : listStudent) {
            System.out.println(student.getsName() + " - " + student.getGpa() + " - " + student.getRank());
        }
    }
    
}
