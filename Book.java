class Book {
    private String title;
    private String isbn;
    private String author;
    private boolean isAvailable;
    
    public Book(String title, String author, String isbn){
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable=  true;
    }

    public boolean isAvailable(){
        return isAvailable;
    }

    public void setAvailable(boolean available){
        isAvailable = available;
    }

    public void printBookInfo(){
        System.out.println("Title: " + title + "Author: "+ author+ "ISBN: "+ isbn +"Availability: "+ isAvailable);
    }

    public String getTitle(){
        return title;
    }
}