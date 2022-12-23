
public class EX3 {
    public static long usingRecursion(int n){
        if(n == 1){
            return 3;
        }
        long result = (long)Math.pow(2, n) + n*n + usingRecursion(n-1);
        return result;
    }

    public static long kqtQua(int n){
        return (long)Math.pow(2, n) + (long)n*n;
    }

    public static long eliminateRecursive(int n){
        MyStack<Integer> listN = new MyStack<>();
        long result = 0;
        while(n <= 1){
            if(n == 1){
                listN.push(3);
            }else{
                listN.push(n);
            }
            result += kqtQua(listN.pop());
            n--;
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 2;
        System.out.println(eliminateRecursive(n));
    }
}
