
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author anton
 */
public class LMS {

 
    private static Scanner s = new Scanner(System.in);

    private String currentUser;

    public void catalog() {
                    
      
      int option = 0;
      Catalog c = new Catalog();
        do { 
           System.out.println("Catalog");
           System.out.println("Enter 1 to view catalog, 2 to add book,3 to update book, 4 to remove from catalog,5 to exit catalog");
           option = s.nextInt(); 
           switch(option){
            case 1:
                 c.showCatalog();
                 break;
            
            case 2:
                 String ISBN1,name1,author1;
                 System.out.println("Enter ISBN of book to Update: ");
                 ISBN1 = s.next();
                 System.out.println("Enter new book name: ");
                 name1 = s.next();
                 System.out.println("Enter new author name: ");
                 author1 = s.next();
                 c.addToCatalog(ISBN1, name1,author1);
                 break;
            case 3:
                 String ISBN,name,author;
                 System.out.println("Enter ISBN of book to Update: ");
                 ISBN = s.next();
                 System.out.println("Enter new book name: ");
                 name = s.next();
                 System.out.println("Enter new author name: ");
                 author = s.next();
                 c.updateCatalog(ISBN, name,author);
                 break;
            
            case 4:
                String ISBNo;
                System.out.println("Enter ISBN to remove: ");
                ISBNo = s.next();
                c.removeFromCatalog(ISBNo);
                break;
                
            case 5:
                System.out.println("Exiting Catalog...");
                break;
            
            default:
                System.out.println("Enter Valid Choice");
            
           }
        } while (option!=5);
    }

    public void issue() {
       
      int option = 0;
      IssueDatabase id = new IssueDatabase();
        do { 
           System.out.println("Issue Section");
           System.out.println("Enter 1 to view all issues, 2 to add issue,3 to find issue, 4 to fulfill issue,5 to renew issue,6 to exit");
           option = s.nextInt(); 
           switch(option){
            case 1:
                 id.showIssues();
                 break;
            
            case 2:
                 id.newIssue();
                 break;
            case 3:
                 String issD;
                 System.out.println("Enter Issue ID: ");
                 issD = s.next();
                 
                 id.getIssueByID(issD);
                 break;
            
            case 4:
                 String issD1;
                 System.out.println("Enter Issue ID: ");
                 issD1 = s.next();
                 
                 id.fulfillIssue(issD1);
                 break;
                
            case 5:
                 String issD2;
                 int days;
                 System.out.println("Enter Issue ID: ");
                 issD2 = s.next();
                 System.out.println("Enter No of Days to extend: ");
                 days = s.nextInt();
                 id.renewIssue(issD2,days);
                 break;
                
            case 6:
                System.out.println("Exiting Catalog");
            default:
                System.out.println("Enter Valid Choice");
            
           }
        } while (option!=6);

    }

    public String getUser(){
        return this.currentUser;
    }
    
    public void signoutUser(){
        this.currentUser = "Invalid";
    }
    
    public void myAccount() {
                 
      int accType,mode;
      System.out.println("Welcome to Library Management System");
      System.out.println("Choose 1 to Register or 2 to Login");
      mode = s.nextInt();
      System.out.println("Choose Account Type - 1 : Librarian or 2: Member");
      accType = s.nextInt();
      if(accType==1){
          Librarian l = new Librarian();
          if(mode == 1){
              l.register();
              this.currentUser = "Librarian";
          }else{
              l.login();
              this.currentUser = "Librarian";
          }
          
          
      }
      else if(accType==2){
          Member l = new Member();
          if(mode == 1){
              l.register();
              this.currentUser = "Member";
          }else{
              l.login();
              this.currentUser = "Member";
          }
      }
      else{
          this.currentUser = "Invalid";
      }
        
    }
    
   

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
     LMS l = new LMS();
     
     l.myAccount();
     
     
     int choice=0;
     do {  
        
         
      String user = l.getUser();
         System.out.println(user);
      if(user=="Invalid"){
         choice=3;
       }
      else if(user == "Librarian"){
        System.out.println("Welcome to Library Management System");
       System.out.println("Enter 1 for Issue, 2  for Account, 3 to quit");
        
       choice = s.nextInt();
       
       switch(choice){
           case 1:
               l.issue();
               break;
           case 2:
               l.myAccount();
               break;
           case 3:
               l.signoutUser();
               break;
               
            default:
                System.out.println("Invalid Choice");
       }

      }
      else{
       System.out.println("Welcome to Library Management System");
       System.out.println("Enter 1 for Catalog, 2 for Account, 3 to quit");
        
       choice = s.nextInt();
       
       
       switch(choice){
           case 1:
               l.catalog();
               break;
           case 2:
               l.myAccount();
               break;
           case 3:
               l.signoutUser();
               break;
               
            default:
                System.out.println("Invalid Choice");
       }
       
       
       
     }
     } while (choice != 3);
     
        
    
    
}
    
}
