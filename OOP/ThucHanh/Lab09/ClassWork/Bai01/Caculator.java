
public class Caculator{
    public double mutiply(int a, int b){
        double result = 0.0;
        try {
            if(a<1 || a>100 && b<1 || b>100){
                throw new Exception("Number out of range. Must be in 1..100 inclusive:");
            }
                    
                            
        result = a*b;
        } catch (Exception e) {
            System.out.println("error");
        }
        
        return result;
    }

    public double devide(int a, int b) throws ArithmeticException{
        double result = 0.0;
        try {
            result = a/b;
            return result;
        } catch (ArithmeticException e) {
            System.err.println("divide by 0");
            e.printStackTrace();
        }
        return 0;
    }

    public static void main(String[] args) {
        Caculator c1 = new Caculator();
        System.out.println(c1.devide(1, 0));
    }


}