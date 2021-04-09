
import java.util.ArrayList;
import java.util.HashMap;

class Book {

    private String bName;

    private String ISBN;

    private String author;
    
    public Book(String name, String ISBN, String author) {
        this.bName = name;
        this.ISBN = ISBN;
        this.author =author;
    }

    public void getBookInfo() {
        System.out.println("Book Name : "+ this.bName); 
        System.out.println("Book ISBN : "+ this.ISBN); 
        System.out.println("Book Author : "+ this.author); 
    }

    public void updateBookInfo(String name, String ISBN, String author) {
        this.bName = name;
        this.ISBN = ISBN;
        this.author =author;
    }

//    public void deleteBookInfo() {
//    }
}
