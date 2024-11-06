
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
        
        System.out.print("Select Goer ID: ");
        int goer = sc.nextInt();
        System.out.print("Select Movie ID: ");
        int movie = sc.nextInt();
        
        
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
    
    
    
    
    
    
    
}
