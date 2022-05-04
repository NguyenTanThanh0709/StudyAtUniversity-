package ClassWork.Bai1;

public class Student extends Person{
    private int id;
    private double score;

    public Student(String name, int birthYear, int id, double score){
        super(name, birthYear);
        this.id = id;
        this.score = score;
    }

    public Student(){
        super();
        this.id = 0;
        this.score = 0;
    }

    public int getId(){
        return this.id;
    }

    public double getScore(){
        return this.score;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setScore(double score){
        this.score = score;
    }

    @Override
    public String toString(){
        return super.toString() + "\nID: " + this.id + "\nScore: " + this.score;
    }
}
