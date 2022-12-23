
public class Person {
    String name;
    int priority;
    public Person(){}
    public Person(String name, int priority){
        this.name = name;
        this.priority = priority;
    }

    @Override
    public String toString(){
        return this.name + ", " + this.priority;
    }
}
