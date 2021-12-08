public class Author {
    private String nameOfAuthor;
    private Date dateOfBirth;

    public Author(String name, Date day){
        this.nameOfAuthor = name;
        this.dateOfBirth = day;
    }

    public String getName(){
        return this.nameOfAuthor;
    }

    public void setName(String name){
        this.nameOfAuthor = name;
    }

    public Date getBirth(){
        return this.dateOfBirth;
    }

    public void setBirth(Date birth){
        this.dateOfBirth = birth;   
    }
}
