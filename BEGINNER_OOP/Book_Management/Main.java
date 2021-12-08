public class Main {
    public static void main(String[] args) {

        // có thể dùng scanner để nhập
        Date day1 = new Date(1, 2, 2022);
        Date day2 = new Date(1, 1, 2000);
        Date day3 = new Date(4, 12, 1979);

        Author tacgia1 = new Author("Tan Thanh", day1);
        Author tacgia2 = new Author("Thanh Tam", day2);
        Author tacgia3 = new Author("Bao long", day3);

        Book book1 = new Book("harry potter", 250020, 1985, tacgia1);
        Book book2 = new Book("game of thorn", 500000, 2945, tacgia2);
        Book book3 = new Book("one pice", 100000, 1985, tacgia3);


        book1.printNameBook();
        book2.printNameBook();
        book3.printNameBook();

        System.out.println("year of book (1 and 2) " + book1.sameYearOfBook(book2));
        System.out.println("year of book (1 and 3) " + book1.sameYearOfBook(book3));

        System.out.println("book1 : price after dis cout 20% : " + book1.priceAfterDiscount(20));
    }
}
