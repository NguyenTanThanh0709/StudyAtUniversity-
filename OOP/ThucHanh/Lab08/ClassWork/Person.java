package ClassWork;

public class Person{
    private String name;
    private int birthYear;

    public Person(String name, int birthYear){
        this.name = name;
        this.birthYear = birthYear;
    }

    public Person(){
        this.name = "";
        this.birthYear = 0;
    }

    public String getName(){
        return this.name;
    }

    public int getBirthYear(){
        return this.birthYear;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setBirthYear(int birthYear){
        this.birthYear = birthYear;
    }

    
    @Override
    public String toString(){
        return "Name: " + this.name + "\nBirth Year: " + this.birthYear;
    }
}