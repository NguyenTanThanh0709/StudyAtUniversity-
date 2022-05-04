public class Person{
    private int ID;
    private String fullName;
    private String address;
    private String phoneNumber;

    public Person(int ID, String fullName, String address, String phoneNumber){
        this.ID = ID;
        this.fullName = fullName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Person(){
    }

    public int getID(){
        return ID;
    }

    public void setID(int ID){
        this.ID = ID;
    }

    public String getFullName(){
        return fullName;
    }

    public void setFullName(String fullName){
        this.fullName = fullName;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString(){
        return "ID: " + ID + "\nFull Name: " + fullName + "\nAddress: " + address + "\nPhone Number: " + phoneNumber;
    }
}