import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        Book book1 = new Book("Abu", "GISBH", "001");
        Book book2 = new Book("Abuyah", "GISBH II", "002");
        Book book3 = new Book("Abuyah yang Teliti", "Ikhwan", "003");
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        User user1 = new User("Arif", 26);
        User user2 = new User("Aiman", 24);
        User user3 = new User("Amir", 24);
        library.addUser(user1);
        library.addUser(user2);
        library.addUser(user3);

        library.listAvailableBooks();

        library.borrowBook(user3, "Abuyah yang Teliti");
        library.borrowBook(user1, "Abuyah");
        library.borrowBook(user2, "Abu");

        library.getBorrowedBooksForAllUsers();

        System.out.println("----- Talabih sdh masa anjing -----");
        user1.checkDueDates();
    }
}
