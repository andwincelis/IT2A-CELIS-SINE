/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sinehan;

import java.util.Scanner;

/**
 *
 * @author SCC-COLLEGE
 */
public class Moviegoer {
    
    
    public void addGoer(){
        Config ci  = new Config();
        Scanner sc = new Scanner(System.in);
        
        
        System.out.print("Enter first Name: ");
        String fname = sc.next();
        System.out.print("Enter Last Name: ");
        String lname = sc.next();
        System.out.print("Age: ");
        int age = sc.nextInt();
        System.out.print("Gender: ");
        String gender  = sc.next();
        System.out.print("Email: ");
        String email = sc.next();
        System.out.print("Contact No. ");
        String con = sc.next();
        
        
        String goer = "INSERT INTO Goer(First_Name, Last_Name, Age, Gender, Email, Contact_No) VALUES (?,?,?,?,?,?)";
        
        ci.addRecord(goer, fname, lname, age, gender, email, con);
        
        
    }
    
    
    public void viewGoer(){
        
        String viewGoer = "SELECT * FROM Goer";
        String[] header = {"Goer ID", "First Name", "Last Name", "Age","Gender", "Email","Contact No"};        
        String[] column = {"Goer_ID","First_Name", "Last_Name", "Age", "Gender", "Email", "Contact_No"};
        Config ci  = new Config();
        ci.viewRecords(viewGoer, header, column);
    }
    
    public void mainGoer(){
          Config ci  = new Config();
        Moviegoer mg = new Moviegoer();
          Scanner sc = new Scanner(System.in);
          
          
          
          
          
          String res;
       do{   
        System.out.println("1. Add Goer");
        System.out.println("2. View Goer");
        System.out.println("3. Update Goer");
        System.out.println("4. Delete Goer");
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
             mg.addGoer();
             break;
         case 2:
             mg.viewGoer();
             break;
         case 3:
             mg.viewGoer();
             String update = "UPDATE Goer SET Gender = ?, Email = ?, Contact_No = ? = WHERE Goer_ID  = ? ";
             
             System.out.print("Enter Goer ID  to update: ");
             int goer = sc.nextInt();
             
             System.out.print("Enter new Gender: ");
             String newgen = sc.next();
             System.out.print("Enter new Email: ");
             String newemail = sc.next();
             System.out.print("Enter new Contact No: ");
             String newcon = sc.next();
             
             ci.updateRecord(update, newgen, newemail, newcon, goer);
             break;
         case 4:
             mg.viewGoer();
             String delete = "DELETE FROM Goer WHERE Goer_ID = ?";
             
             System.out.print("Enter Goer ID to delete: ");
             int del = sc.nextInt();
             
             ci.deleteRecord(delete, del);
             break;
         case 5:
             System.out.println("Exitingg....");
             break;
 
     }   
     
        System.out.println("");
        System.out.print("Do you want to continue? Yes or No: ");
        res = sc.next();
    }while(res.equalsIgnoreCase("yes"));
    }
    
    
    
    
    
    
    
    
}
