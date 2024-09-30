import java.time.LocalDate;
import java.util.ArrayList;


class Library {
    private ArrayList<Book> books;
    private ArrayList<User> users;

    public Library(){
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public void addBook(Book book){
        books.add(book);
        System.out.println("Book added :"+ book.getTitle());
    }

    public void searchByTitle(String title){
        for  (Book book : books){
            if(book.getTitle().contains(title)){
                book.printBookInfo();
            }
        }
    }

    public void addUser(User user){
        users.add(user);
        System.out.println("User added: "+ user.getName());
    }

    public void borrowBook(User user, String title){
        for (Book book : books){
            if (book.getTitle().equalsIgnoreCase(title) && book.isAvailable()){
                book.setAvailable(false);
                LocalDate dueDate = LocalDate.now().plusDays(14);
                user.borrowBook(title, dueDate);
                System.out.println("Book borrowed: " + title);
            }
        }
        System.out.println("Book not found or unavailable.");
    }

    public void listAvailableBooks() {
        System.out.println("--- Available Books ---");
        for (Book book : books) {
            if (book.isAvailable()) {
                book.printBookInfo();
            }
        }
    }

    public void getBorrowedBooksForAllUsers() {
        for (User user : users) {
            System.out.println("User: " + user.getName());
            user.printBorrowedBooks();
        }
    }
    

}
