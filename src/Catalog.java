
import java.util.HashMap;
import sun.security.x509.InvalidityDateExtension;




public class Catalog {
    
    private HashMap<String,Book>  Books = new HashMap<String,Book>();

    public Catalog(){
     
        Book b1=new Book("Harry Potter","1001","Rowling");
        this.Books.put("1001",b1);
        Book b2=new Book("War and Peace","1002","Leo Tolstoy");
        this.Books.put("1002",b2);
        Book b3=new Book("Half Girlfriend","1003","Chetan Bhagath");
        this.Books.put("1003",b3);
     
    }
    
    
    public void showCatalog() {
        for(Book b : Books.values()){
            b.getBookInfo();
            System.out.println("----------");
        }
    }
    
    public void addToCatalog(String ISBN1, String name1,String author1) {
       Book bn = new Book(name1,ISBN1,author1);
        System.out.println("Book added to Catalog");
    }

    public void updateCatalog(String ISBN, String name,String author) {
        Book b = Books.get(ISBN);
        b.getBookInfo();
        b.updateBookInfo( name, ISBN, author);
        System.out.println("Catalog Updated");
    }
    
    public void removeFromCatalog(String ISBN) {
        Books.remove(ISBN);
        System.out.println("Catalog Updated");
    }
}
