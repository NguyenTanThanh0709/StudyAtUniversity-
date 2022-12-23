package Fraction;

public class Fraction{
    int numer = 0;
    int demon = 1;

    public Fraction(){

    }

    public Fraction(int x, int y){
        this.numer = x;
        this.demon = y;
    }

    public Fraction(Fraction f){
        this.numer = f.numer;
        this.demon = f.demon;
    }

    @Override
    public String toString(){
        return this.numer + "/" + this.demon;
    }

    @Override
    public boolean equals(Object f){
        if(this == f){
            return true;
        }
        if(f == null || getClass() != f.getClass()){
            return false;
        }

        Fraction temp = (Fraction) f;
        return this.demon == temp.demon && this.numer == temp.numer;
    }
}