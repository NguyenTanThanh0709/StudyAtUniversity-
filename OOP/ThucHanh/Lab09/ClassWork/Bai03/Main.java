import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {

  public static ArrayList<Student> findStudent(ArrayList<Student> lStudents) {
    ArrayList<Student> res = new ArrayList<>();

    for (Student student : lStudents) {
      if (student.getRank().equals("A") | student.getRank().equals("Passed")) {
        res.add(student);
      }
    }

    return res;
  }

  public static boolean writeFile(String path, ArrayList<Student> lst) {
    // output
    try {
      FileWriter out = new FileWriter(path);
      //sName, sID, gpa
      for (Student student : lst) {
        String data = "";
        if (student instanceof ITStudent) {
          data =
            student.getsName() +
            " " +
            ((ITStudent) student).getsID() +
            " " +
            student.getGpa() +
            "\n";
        } else {
          data =
            student.getsName() +
            " " +
            ((MathStudent) student).getsID() +
            " " +
            student.getGpa() +
            "\n";
        }

        out.write(data);
      }
      out.close();
    } catch (IOException e) {
      System.out.println("Catch an error.");
      return false;
    }
    return true;
  }

  public static void main(String[] args) {
    ArrayList<Student> lStudents = new ArrayList<>();

    lStudents.add(new ITStudent("Truc", 9.5, 4));
    lStudents.add(new ITStudent("Tien", 4.5, 3));


    ArrayList<Student> res = findStudent(lStudents);
    System.out.printf("%b", writeFile("out.txt", res));
  }
}