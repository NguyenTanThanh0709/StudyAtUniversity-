import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) {


        String data = "";
        int m = 0,  n = 0;
        try {
            FileReader reader = new FileReader("input.txt");
            BufferedReader fReader = new BufferedReader(reader);
            data = fReader.readLine();
            String[] tempData1 = data.trim().split(" ");
             m = Integer.parseInt(tempData1[0]);
             n = Integer.parseInt(tempData1[1]);
    

            fReader.close();
            reader.close();
            
        } catch (Exception e) {
            System.out.println("Cannot load file");
            
        }

        System.out.println(m +" " + n);


        MST mst = new MST(m, n);
        mst.loadFile("input.txt");
        // mst.print();
        mst.kruskal();
        
    }
}
