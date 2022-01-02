public class Student {
    private int id;
    private String firstName;
    private String lastName;

    public Student(int id, String firstName, String lastName){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getID(){
        return this.id;
    }

    public void setID(int id){
        this.id = id;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public void setFirstName(String FN){
        this.firstName = FN;
    }

    public String getLastName(){
        return this.lastName;
    }

    public void setLastName(String LN){
        this.lastName = LN;
    }

    @Override
    public String toString(){
        return " id: " + this.id + "\nfirstname: " + this.firstName + "\n lastName: " + this.lastName;
    }
}
