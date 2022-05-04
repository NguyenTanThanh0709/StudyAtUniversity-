

// import java.io.BufferedInputStream;
// import java.io.BufferedReader;
// import java.io.File;
// import java.io.FileInputStream;
// import java.io.InputStream;
// import java.io.InputStreamReader;
// import java.nio.charset.StandardCharsets;

// public class readFile {
//     public static void readFIleUpperCase(String nameFile){
//         FileInputStream fis = null;
//         InputStreamReader isr = null;
//         BufferedReader bis = null;

//         try {
//             fis = new FileInputStream(nameFile);
//             isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
//             bis = new BufferedReader(isr);
//             String line = "";
//             while((line = bis.readLine()) != null){
//                 if(line.isEmpty()){
//                     continue;
//                 }

//                 System.out.println(line.toUpperCase());
//             }
//         } catch (Exception e) {

//         }finally{

//         }

//     }

//     public static void main(String[] args) {
//         readFIleUpperCase("input.txt");
//     }
// }

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FilterWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    String data = "";
    String pathname = "input.txt";

    //input
    try {
      File in = new File(pathname);
      Scanner sc = new Scanner(in);
      while (sc.hasNextLine()) {
        data += sc.next() + " ";
      }
    } catch (FileNotFoundException e) {
      System.out.println("Catch an error.");
    }

    data = data.trim().toUpperCase();
    pathname = "output.txt";

    // output
    try {
      FileWriter out = new FileWriter("out.txt");
      out.write(data);
      out.close();
    } catch (IOException e) {
      System.out.println("Catch an error.");
    }
  }
}