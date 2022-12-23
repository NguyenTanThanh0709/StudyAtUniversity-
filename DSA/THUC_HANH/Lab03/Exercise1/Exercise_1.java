public class Exercise_1{
    public int factorial(int n){
        if(n == 1){
            return 1;
        }
        return n*factorial(n-1);
    }

    public int computeXMUN(int x, int n){
        if(n == 1){
            return x;
        }
        return x * computeXMUN(x, n-1);
    }

    public int countNumber(int n){
        if(n < 0){
            return 1;
        }
        return 1 + countNumber(n/10);
    }

    public boolean checkPrimeNumber(int n){
        return checkPrimeNumber(n,2);
    }

    public boolean checkPrimeNumber(int n, int i){
        if( n <= 2){
            return (n==2) ? true : false;
        }

        if(n % i == 0){
            return false;
        }

        if( i >= n){
            return true;
        }

        return checkPrimeNumber(n, i+1);
    }

    public int GCD(int a, int b){
        if(b == 0){
            return a;
        }
        return GCD(b, a%b);
    }


    
}