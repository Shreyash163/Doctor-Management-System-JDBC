package com.amdocs.DMS.main;
import  com.amdocs.DBConnection.DoctorFunctions;
import com.amdocs.DMS.Exception.InvalidInputforMenuSelect;
import com.amdocs.DMS.model.DoctorEntity;

import java.util.Scanner;
import java.util.regex.Pattern;


public class Main {
	

    public static void main(String[] args){
    	
		
    	
        try {
        	//System.out.println("inside main");
    		

    		 Scanner scanner = new Scanner(System.in);
             
             while (true) {
                 System.out.println("Doctor Management System");
                 System.out.println("1. Add Doctor");
                 System.out.println("2. View All Doctors");
                 System.out.println("3. Search Doctors by Availability");
                 System.out.println("4. Remove Doctor Information");
                 System.out.println("5. Count Number of Doctor By Shift");
                 System.out.println("6. Update doctor Fees");
                 System.out.println("7. Exit");
                 System.out.print("Select an option: ");
                 int choice = scanner.nextInt();
                 scanner.nextLine(); // Consume the newline character
                 
                 if(choice<=0)
                 {
                	 throw new InvalidInputforMenuSelect("Given value is less than 0 , please select greater than 0");
                 }
                 else if((choice*0!=0))
                 {
                	 throw new InvalidInputforMenuSelect("Given value is not integer");

                 }
                 
                 switch (choice) {
                     case 1:
                    	 DoctorEntity doc = new DoctorEntity();
                    	System.out.print("Enter doctor's name: ");
             	        doc.setName(scanner.next());
             	        System.out.print("Enter doctor's specialization: ");
             	        doc.setSpecialization(scanner.next());
             	       System.out.print("Enter doctor's consultation fees: ");
             	       doc.setFees(scanner.nextDouble());
             	        System.out.print("Enter doctor's availability: ");
             	       doc.setAvailability(scanner.next());
             	       
                        DoctorFunctions.addDoctor(doc);
                        
                         break;
                    case 2:
                         DoctorFunctions.viewALLDoctors();
                         break;
                     case 3:
                    	 System.out.println("Please type Morning/Evening to check Availability ");
            			 String checkShift = scanner.nextLine();
                         DoctorFunctions.searchDoctorsByAvailability( checkShift);
                         break;
                         
                     case 4:
                    	 System.out.println("Write ID of Doctor : ");
                		 int deleteID = scanner.nextInt();
                    	 DoctorFunctions.deleteDoctor( deleteID);
                         return;
                     case 5:
                    	 System.out.println("Please type Morning/Evening to check Availability ");
            			 String countDocShift = scanner.nextLine();
                    	 DoctorFunctions.CountDocShift( countDocShift);
                         return;
                     case 6:

                		 System.out.println("Enter the Doctor ID you want to update fees : ");
                		 int id=0;
                		 id = scanner.nextInt();
                		 System.out.println("enter the Amount to be updated : ");
                		 double docFees = 0;
                		 docFees = scanner.nextDouble();
                    	 DoctorFunctions.UpdateFees( id , docFees);
                         return;
                        
                    
                     case 7:
                    	 DoctorFunctions.CloseConnection();
                         System.out.println("Exiting...");
                         return;
                    	
                     default:
                         System.out.println("Invalid option. Please try again.");
                         break;
                 }
                
             }
            
            
        } 
        
        catch (InvalidInputforMenuSelect b)
        {
        	System.out.println(b);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    
   
}
   