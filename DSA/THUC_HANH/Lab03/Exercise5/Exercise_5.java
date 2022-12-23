public class Exercise_5{
    public static void converseBinary(int n, int base){ 
        if(n > 1)
            converseBinary(n/base,base);
            System.out.print(n%base); 
    }

    public static void main(String[] args) {
        converseBinary(10, 2);
    }
}