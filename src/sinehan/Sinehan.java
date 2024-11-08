
package sinehan;

import java.util.Scanner;


public class Sinehan {

    
    public static void main(String[] args) {
        
          Scanner sc = new Scanner(System.in);
        
          
          
          int choice;
          
          boolean exit = true;
          
          do{
              
              System.out.println("");
        System.out.println("1. MovieGoer");
        System.out.println("2. Movie");
        System.out.println("3. Movie Records");
        
        
        
        while(true){
            System.out.println("");
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
                Moviegoer mg = new Moviegoer();
                mg.mainGoer();
                break;
            case 2:
                Moview mv = new Moview();
                mv.MovieDetails();
                break;
            case 3:
                MovieRecords mr = new MovieRecords();
                mr.mainSine();
                break;
            case 4:
                System.out.print("Do you want to log out? Yes or No: ");
                String response = sc.next();
                if(response.equalsIgnoreCase("yes")){
                    exit = false;
                    
                }
                
                break;
        }
        
          }while(exit);
        
        
    }
    
}
