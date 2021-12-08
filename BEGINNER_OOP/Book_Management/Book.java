public class Book {
    private String nameOfBook;
    private double Price;
    private int yearOfBook;
    private Author tacgia;

    public Book(String nameOfBook, double Price, int year, Author tacgia){
        this.nameOfBook = nameOfBook;
        this.Price = Price;
        this.yearOfBook = year;
        this.tacgia = tacgia;
    }

    public String getNameOfBook(){
        return this.nameOfBook;
    }

    public void setNameOfBook(String name){
        this.nameOfBook = name;
    }

    public double getPrice(){
        return this.Price;
    }

    public void setPrice(double price){
        this.Price = price;
    }

    public int getYearOfbook(){
        return this.yearOfBook;
    }

    public void setYearOfBook(int year){
        this.yearOfBook = year;
    }

    public Author getTacGia(){
        return this.tacgia;
    }

    public void setTacGia(Author tacgia){
        this.tacgia = tacgia;
    }

    public void printNameBook(){
        System.out.println("Name Of Book is : " + this.nameOfBook);
    }

    public boolean sameYearOfBook(Book other){
        // if(this.yearOfBook == other.yearOfBook){
        //     return true;
        // }
        // return false;
        return this.yearOfBook == other.yearOfBook;
    }

    public double priceAfterDiscount(int x){
        return (double)this.Price - (x/100.0)*this.Price;
    }

}
