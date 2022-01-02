public class Fraction {
    private int numeration;
    private int denominator;

    public Fraction(int num, int deno){
        this.numeration = num;
        this.denominator = deno;
    }

    public int getNumer(){
        return this.numeration;
    }

    public void setNumer(int num){
        this.numeration = num;
    }

    public int getDeno(){
        return this.denominator;
    }

    public void setDeno(int deno){
        this.denominator = deno;
    }

    public int Add(){
        return this.denominator + this.numeration;
    }

    public int Sub(){
        return this.denominator - this.numeration;
    }

    public int  Mul(){
        return this.denominator * this.numeration;
    }

    public float Div(){
        return this.denominator / this.numeration;
    }

    public void reducer(){
        System.out.println("reducer!!!!");
    }

    public String toString(){
        return "demo: " + this.denominator + "\n num : " + this.numeration; 
    }

}
