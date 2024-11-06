
package sinehan;

import java.util.Scanner;


public class Moview {
    
    
    
    public void addMovie(){
        
           Config ci  = new Config();
        Scanner sc = new Scanner(System.in);
        
        
         System.out.print("Name of Movie: ");
        String mname = sc.nextLine();

       
        System.out.print("Genre: ");
        String genre = sc.nextLine();

       
        System.out.print("Duration: ");
        String dur = sc.nextLine();

       
        System.out.print("Price: ");
        double pri = sc.nextDouble();

      
        System.out.print("Format (2D/3D): ");
        sc.nextLine(); 
        String format = sc.nextLine();

        System.out.print("Age Rating (G/PG/SPG): ");
        String rating = sc.nextLine();
        
        String movie = "INSERT INTO Movie(Movie_Name, Genre, Duration, Movie_Price, Format, Age_Rating) VALUES (?,?,?,?,?,?)";
        ci.addRecord(movie, mname, genre, dur, pri, format, rating);
        
    }
    public void viewMovie(){
        
         String viewGoer = "SELECT * FROM Movie";
        String[] header = {"Movie ID", "Movie Name", "Genre", "Duration","Movie Price", "Format","Age Rating"};        
        String[] column = {"Movie_ID","Movie_Name", "Genre", "Duration", "Movie_Price", "Format", "Age_Rating"};
        Config ci  = new Config();
        ci.viewRecords(viewGoer, header, column);   
    }
    
    
    public void MovieDetails(){
        
        
        
         Moview mv = new Moview();
           Config ci  = new Config();
        Scanner sc = new Scanner(System.in);
        
        String res;
        do{
        System.out.println("1. Add Movie");
        System.out.println("2. View Movie");
        System.out.println("3. Update Movie");
        System.out.println("4. Delete Movie");
        System.out.println("5. Exit");
        
        
        int choice;
         while(true){
            System.out.print("Enter Choice: ");
            if(sc.hasNextInt()){
                choice = sc.nextInt();
                if(choice >= 1 && choice <= 4){
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
                 mv.addMovie();
                 break;
             case 2:
                 mv.viewMovie();
                 break;
             case 3:
                 mv.viewMovie();
                 String movieup = "UPDATE Movie SET Movie_Price = ?, Format = ?, Age_Rating = ? WHERE Movie_ID = ? ";
                 
                 System.out.print("Enter Movie ID to update: ");
                 int movie = sc.nextInt();
                 
                 System.out.print("Enter new Movie Price: ");
                 double pr = sc.nextDouble();
                 
                 System.out.print("Enter new Format: ");
                 String newfor = sc.next();
                 
                 System.out.print("Enter new Age Rating: ");
                 String newage = sc.next();
                 
                 ci.updateRecord(movieup, pr, newfor, newage, movie);
                 break;
             case 4:
                 mv.viewMovie();
                 
                 String movidel = "DELETE FROM Movie WHERE Movie_ID = ? ";
                 
                 System.out.print("Enter Movie ID to delete: ");
                 int idel = sc.nextInt();
                 
                 ci.deleteRecord(movidel, idel);
                 break;
             case 5:
                 System.out.println("Exiting.....");
                 break;
         }
         System.out.println("");
        System.out.print("Do you want to continue ? Yes or No: ");
        res = sc.next();
        }while(res.equalsIgnoreCase("yes"));
    }
    
    
    
    
}
