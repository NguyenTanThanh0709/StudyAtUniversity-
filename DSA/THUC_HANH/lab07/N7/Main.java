import java.io.*;
import java.util.*;

public class Main {

    public static String loadFile(String filePath) {
        String data = "";
        ArrayList<String> list = new ArrayList<String>();

        try {
            FileReader reader = new FileReader(filePath);
            BufferedReader fReader = new BufferedReader(reader);

            while ((data = fReader.readLine()) != null) {
                list.add(data);
                break;
            }

            fReader.close();
            reader.close();

        } catch (Exception e) { 
            System.out.println("Cannot load file");
        }
        return list.get(0);
    }

    public static boolean writeFile(String path, String kq1 , String kq2, String kq3) {
        try {
            FileWriter writer = new FileWriter(path);
            
            writer.write(kq1);
            writer.write(kq2);
            writer.write(kq3);
            
            System.out.println("write file ok");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error.");
            return false;
        }

        return true;
    }
    public static void main(String[] args) {
        AVL avl = new AVL();
        String[] list = loadFile("input.txt").split(" ");

        for(String each : list){
            avl.insert(Integer.parseInt(each));
        }

        String pre1 = avl.preOrder();
        boolean t = writeFile("output.txt", pre1,avl.inorder(), avl.posOrder());

}
}
