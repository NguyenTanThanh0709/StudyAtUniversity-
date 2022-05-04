// import java.io.*;
// public class Bai1 {

//    public static void main(String args[]) throws IOException {
//       FileReader in = null;
//       FileWriter out = null;

//       try {
//          in = new FileReader("input.txt");
//          out = new FileWriter("output.txt");
         
//          int c;
        
//          while ((c = in.read()) != -1) {
//             out.write(c);
   
//          }
//       }finally {
//          if (in != null) {
//             in.close();
//          }
//          if (out != null) {
//             out.close();
//          }
//       }
//    }
// }

// import java.io.File;  // Import the File class
// import java.io.FileNotFoundException;  // Import this class to handle errors
// import java.io.FileOutputStream;
// import java.io.FileWriter;
// import java.io.IOException;
// import java.util.Scanner; // Import the Scanner class to read text files

// public class Bai1 {
//   public static  void main(String[] args) throws IOException {
    
   
//     try {
//       File myObj = new File("input.txt");
//       FileWriter fWriter = new FileWriter("output.txt");
//       Scanner myReader = new Scanner(myObj);
      
//       int sum = 0;
//       while (myReader.hasNextLine()) {

//         String data = myReader.nextLine();
//         String[] arr = data.split(" ");
//         for (String string : arr) {
//             sum += Integer.parseInt(string);
//         }
//       }
//     //   try {
//     //     fWriter.write(sum + "");
//     // } catch (IOException e) {
//     //     // TODO Auto-generated catch block
//     //     e.printStackTrace();
//     // }
//         fWriter.write(sum + "");
//       System.out.println(sum);
      
      
//       myReader.close();
//       fWriter.close();
//     } catch (FileNotFoundException e) {
//       System.out.println("An error occurred.");
//       e.printStackTrace();
//     }
//   }
// }

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    int sum = 0;
    String pathname = "input.txt";

    //input
    try {
      File file = new File(pathname);
      Scanner sc = new Scanner(file);
      while (sc.hasNextLine()) {
        sum += sc.nextInt();
        System.out.println(sum);
      }
    } catch (FileNotFoundException e) {
      System.out.println("Catch an error.");
    }
    // output
    pathname = "output.txt";
    try {
      FileWriter out = new FileWriter(pathname);
      out.write(String.format("%d", sum));
      out.close();
    } catch (IOException e) {
      System.out.println("Catch an error.");
    }
  }
}