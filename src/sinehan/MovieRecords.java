
package sinehan;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class MovieRecords {
    
    
    
    public void addMovie(){
          Config ci  = new Config();
             Scanner sc = new Scanner(System.in);
        System.out.println(" - Goer List - ");  
        Moviegoer mg = new Moviegoer();
        mg.viewGoer();
        System.out.println(" - Movie List - ");
        Moview mv = new Moview();
        mv.viewMovie();
        
       
        
         int goer;
                while (true) {
                System.out.print("Enter Goer ID: ");
                if (sc.hasNextInt()) {
                    goer = sc.nextInt();
                    if (ci.getSingleValues("SELECT Goer_ID FROM Goer  WHERE Goer_ID = ?", goer) != 0) {
                        break;
                    } else {
                        System.out.println("Selected Goer doesn't exist.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a valid numeric Goer ID.");
                    sc.next(); 
                }
            }
        
        
        
        int movie;
                while (true) {
                System.out.print("Enter Movie ID: ");
                if (sc.hasNextInt()) {
                    movie = sc.nextInt();
                    if (ci.getSingleValues("SELECT Movie_ID FROM Movie  WHERE Movie_ID = ?", movie) != 0) {
                        break;
                    } else {
                        System.out.println("Selected Movie doesn't exist.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a valid numeric Movie ID.");
                    sc.next(); 
                }
            }
        
        
        String price = "SELECT Movie_Price FROM Movie WHERE Movie_ID = ? ";
        double price1 = ci.getSingleValue(price, movie);
        
        System.out.print("Enter Cash: ");
        double cash = sc.nextInt();
        
        while(cash < price1){
            System.out.print("Not enough cash, Try Again: ");
            cash = sc.nextInt();
            
        }
        
        double change = cash - price1;
        
        System.out.println("------------------------------------");
        System.out.printf("Total Change: %.2f\n", change);
        System.out.println("------------------------------------");
        
        
        LocalDate currdate = LocalDate.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date = currdate.format(format);
        
        String status = "On going";
        
        String records = "INSERT INTO MovieRecords(Goer_ID, Movie_ID, Price, Cash, Change, Date, Status) VALUES (?,?,?,?,?,?,?)";
        
        ci.addRecord(records, goer, movie, price1, cash, change, date, status);
    }
    
    public void viewRecords(){
        String view = "SELECT MovieRercords_ID, First_Name, Last_Name, Email, Movie_Name, Duration, Date, Status FROM MovieRecords "
                + "LEFT JOIN Goer ON Goer.Goer_ID = MovieRecords.Goer_ID "
                + "LEFT JOIN Movie ON Movie.Movie_ID  = MovieRecords.Movie_ID";
        String[] header = {"Movie Records Id", "First Name", "Last Name", "Email", "Movie Name", "Duration", "Date","Status"};
        String[] column = {"MovieRercords_ID", "First_Name", "Last_Name", "Email", "Movie_Name", "Duration","Date", "Status"};
         
            Config ci  = new Config();
            ci.viewRecords(view, header, column);
    }
    
    public void viewing(){
           Config ci  = new Config();
        
           Scanner sc = new Scanner(System.in);

    int goer;
    while (true) {
        System.out.print("Enter Goer ID to view all movie: ");
        if (sc.hasNextInt()) {
            goer = sc.nextInt();
            if (ci.getSingleValues("SELECT Goer_ID FROM MovieRecords WHERE Goer_ID = ?", goer) != 0) {
                break;
            } else {
                System.out.println("Goer with this ID does not exist.");
            }
        } else {
            System.out.println("Invalid input. Please enter a valid numeric ID.");
            sc.next(); // clear the invalid input
        }
    }

           
        String view = "SELECT MovieRecords.MovieRercords_ID, Goer.First_Name, Movie.Movie_Name, MovieRecords.Date, MovieRecords.Status FROM MovieRecords "
                + "LEFT JOIN Goer ON Goer.Goer_ID = MovieRecords.Goer_ID "
                + "LEFT JOIN Movie ON Movie.Movie_ID = MovieRecords.Movie_ID "
                + "WHERE MovieRecords.Goer_ID = ?";
        
        String[] header = {"Movie Record ID ", "First Name", " Movie Name", "Date", "Status"};
        String[] column = {"MovieRercords_ID","First_Name","Movie_Name","Date","Status"};
        
        ci.viewApplicantss(view, header, column,goer );
        
    }
    
    public void mainSine(){
        
        MovieRecords mr = new MovieRecords();
        
        Config ci  = new Config();
        Scanner sc = new Scanner(System.in);
        
        String res;
        do{
            System.out.println("");
        System.out.println("1. Add Movie Records");
        System.out.println("2. View ");
        System.out.println("3. Update ");
        System.out.println("4. Delete ");
        System.out.println("5. View By ID");
            System.out.println("6. Exit");
        
         int choice;
         while(true){
            System.out.print("Enter Choice: ");
            if(sc.hasNextInt()){
                choice = sc.nextInt();
                if(choice >= 1 && choice <= 6){
                    break;
                }else{
                    System.out.println("Enter a number between 1 and 4 ");
                }
              
            }else{
                System.out.println("Invalid Input Character !! ");
            }
        }
         
         switch(choice){
             case 1:
                 mr.addMovie();
                 break;
             case 2:
                 mr.viewRecords();
                 break;
             case 3:
                 mr.viewRecords();
                 String up  = "UPDATE MovieRecords SET Status = ? WHERE MovieRercords_ID = ?";
                 
                 
                 int re;
                while (true) {
                System.out.print("Enter Records ID to update: ");
                if (sc.hasNextInt()) {
                    re = sc.nextInt();
                    if (ci.getSingleValues("SELECT MovieRercords_ID FROM MovieRecords  WHERE MovieRercords_ID = ?", re) != 0) {
                        break;
                    } else {
                        System.out.println("Selected Record doesn't exist.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a valid numeric Record ID.");
                    sc.next(); 
                }
            }
                 
                 System.out.print("Enter new Status: ");
                 String stats = sc.next();
                 
                 ci.updateRecord(up, stats, re);
                 
                 break;
             case 4:
                 mr.viewRecords();
                 String del = "DELETE FROM MovieRecords WHERE MovieRercords_ID = ?";
                   
                 int dele;
                while (true) {
                System.out.print("Enter Records ID to delete: ");
                if (sc.hasNextInt()) {
                    dele = sc.nextInt();
                    if (ci.getSingleValues("SELECT MovieRercords_ID FROM MovieRecords  WHERE MovieRercords_ID = ?", dele) != 0) {
                        break;
                    } else {
                        System.out.println("Selected Record doesn't exist.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a valid numeric Record ID.");
                    sc.next(); 
                }
            }
                 ci.deleteRecord(del, dele);
                 break;
             case 5:
                Moviegoer mg = new Moviegoer();
                mg.viewGoer();
                mr.viewing();
                 break;
             case 6:
                 System.out.println("Exittttt....");
                 break;
         }
         System.out.println("");
         System.out.print("Do you want to continue? Yes or No: ");
         res = sc.next();
    }while(res.equalsIgnoreCase("yes"));
     
    }
    
    
    
    
    
    
}
