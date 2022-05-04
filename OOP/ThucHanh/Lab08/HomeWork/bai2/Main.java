package HomeWork.bai2;
import HomeWork.bai1.*;

public class Main {
    public static void main(String[] args) {
        HashMapDictionary test = new HashMapDictionary();
        test.add("hello", "xin chao");
        test.add("hi", "xin chao");
        test.add("bye", "tam biet");
        test.add("goodbye", "tam biet");
        
        test.print();
        System.out.println(test.checkContain("bye"));

        test.printWord("bye");
        

    }
    
}
