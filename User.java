import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class User{
    private String name;
    private int age;
    private ArrayList<String> borrowedBooks;
    private Map<String,LocalDate> borrowedBooksDueDates;

    public User(String name, int age){
        this.name = name;
        this.age = age;
        this.borrowedBooks = new ArrayList<>();
        this.borrowedBooksDueDates = new HashMap<>();
    }

    //Getter and setter 
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

    //Borrow Book
    public void borrowBook(String bookTitle, LocalDate dueDate){
        borrowedBooks.add(bookTitle);
        borrowedBooksDueDates.put(bookTitle, dueDate);
        System.out.println("Book borrowed" + bookTitle);
    }

    //Return Book
    public void returnBook(String bookTitle){
        if (borrowedBooks.contains(bookTitle)){
            borrowedBooks.remove(bookTitle);
            borrowedBooksDueDates.remove(bookTitle);
            System.out.println("Book returned: " + bookTitle);
        }else {
            System.out.println("Book is not found");
        }
    }

    //Print borrowed books
    public void printBorrowedBooks(){
        System.out.println("Borrowed Books: ");
        for (String book : borrowedBooks){
            System.out.println(book + "- Due: " +borrowedBooksDueDates.get(book));
        }
    }

    //check due dates
    public void checkDueDates(){
        for (Map.Entry<String, LocalDate> entry : borrowedBooksDueDates.entrySet()){
            System.out.println("Book: " + entry.getKey() + ", Due Date" + entry.getValue());
        }
    }

    //check overdue books
    public void checkOverdueBooks() {
        LocalDate today = LocalDate.now();
        for (Map.Entry<String, LocalDate> entry : borrowedBooksDueDates.entrySet()) {
            String bookTitle = entry.getKey();
            LocalDate dueDate = entry.getValue();
            
            if (today.isAfter(dueDate)) {
                long daysOverdue = ChronoUnit.DAYS.between(dueDate, today);
                System.out.println("User: " + this.name + ", Book: " + bookTitle + ", Overdue by " + daysOverdue + " days");
            }
        }
    }
    
}
