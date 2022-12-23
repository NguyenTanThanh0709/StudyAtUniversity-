public class Exercise_4{
    public  static int a(int n){
        if (n == 1){
            return 3;
        }

        return 2 *n + 1 + a(n-1);
    }

    public static int factorial (int n ){
        if( n == 1){
            return 1;
        }
        return n *factorial(n-1);
    }

    public static int b(int n){
        if(n == 1){
            return factorial(n);
        }
        return factorial(n) + b(n-1);
    }

    public static int c(int n){
        if(n == 1){
            return factorial(n);
        }
        return factorial(n) * c(n-1);
    }

    public static int d(int n, int r){
        if (0 > r && r>= n){
            return 1;
        }

        return (n-r+1) * d(n, r-1);
    }

    public static int e(int n){
        if(n == 1){
            return 3;
        }
        return (int) (Math.pow(2,n) + n*n + e(n-1));
    }


    public static void main(String[] args) {
        System.out.println(b(3));
    }
}