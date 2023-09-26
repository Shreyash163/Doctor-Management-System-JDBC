package com.amdocs.DBConnection;

import  com.amdocs.DBConnection.DbConnection;
import  com.amdocs.DBConnection.DoctorFunctions;
import com.amdocs.DMS.Exception.*;
import com.amdocs.DMS.model.DoctorEntity;

import java.sql.*;
import java.util.Scanner;

public class DoctorFunctions 
{
	static DbConnection dbConnect =	new DbConnection();
	
	
	static Connection con1 = dbConnect.getConnection();
	
	 public static void addDoctor(DoctorEntity doc) throws SQLException
	 {
	        PreparedStatement preparedStatement = con1.prepareStatement("INSERT INTO DoctorInfo (name, specialization, consultation_fees, availability) VALUES (?, ?, ?, ?)");
	        preparedStatement.setString(1, doc.getFullName());
	        preparedStatement.setString(2, doc.getSpecialization());
	        preparedStatement.setDouble(3, doc.getFees());
	        preparedStatement.setString(4, doc.getAvailability());
	        
	        int rowsAffected = preparedStatement.executeUpdate();
	        if (rowsAffected > 0) {
	            System.out.println("Doctor added successfully!");
	        } else {
	            System.out.println("Failed to add doctor.");
	        }
	    }
	 
	 public static void viewALLDoctors() throws SQLException
	 {	
		 String sql = "SELECT * FROM DoctorInfo";
		 PreparedStatement st = con1.prepareStatement(sql);
		 try {
			 
			  //System.out.println("after select");
	            // Execute the query
	            ResultSet resultSet = st.executeQuery(sql);

	            // Process and display the query results
	            while (resultSet.next()) {
	                // Retrieve data from the result set
	                int id = resultSet.getInt("id"); // Replace "id" with your column name
	                String name = resultSet.getString("name"); 
	                String specialization= resultSet.getString("SPECIALIZATION");// Replace "name" with your column name
	                double fees = resultSet.getDouble("CONSULTATION_FEES");
	                String availability = resultSet.getString("AVAILABILITY");
	                		// Add more columns as needed

	                // Display the data
	                System.out.println("ID: " + id + "  Name: " + name +" SPECIALIZATION : " + specialization + " CONSULTATION_FEES : " + fees + " AVAILABILITY : " + availability);
	                // Print additional columns here as needed
	            }
		 }
	            
	      catch(Exception e)
	      {
	    	  System.out.println(e);
	      }
		 }
	 
	 public static void deleteDoctor( int deleteID) throws InvalidInputforDeleteException
	 {
		 
		 if(deleteID <=0)
		 {
			 throw new InvalidInputforDeleteException("Entered value is less than 0 please enter value greater than 0");
		 }
		
		 String delete = "Delete from DoctorInfo where ID = ?";
		 try {
		 PreparedStatement st = con1.prepareStatement(delete);
		 st.setInt(1, deleteID);
		 int rows = st.executeUpdate();
		 if(rows>0)
		 {
			 System.out.println("Record Deleted Successfully");
		 }
		 else {
			 System.out.println("Delete Failed/No such Record found");
		 }
		 
		 }
		 catch(Exception e)
		 {
			 System.out.println(e);
		 }
	 }
		 
	 public static void searchDoctorsByAvailability( String checkShift) throws InvalidInputforAvailability
	 {
		 if((!checkShift.equals(checkShift)))  
		 {
			 throw new InvalidInputforAvailability("Entered value is not among Morning , Please Correct the Input");
		 }
		
		 String search = "Select * from DoctorInfo where UPPER(availability) = UPPER(?)";
		 
		 try {
			 
			 PreparedStatement st = con1.prepareStatement(search);
			
			 st.setString(1, checkShift.toUpperCase()); // Set the availability parameter

			 ResultSet resultSet = st.executeQuery();
			 while (resultSet.next()) {
			
	                // Retrieve data from the result set
	                int id = resultSet.getInt("id"); // Replace "id" with your column name
	                String name = resultSet.getString("name"); 
	                String specialization= resultSet.getString("SPECIALIZATION");// Replace "name" with your column name
	                double fees = resultSet.getDouble("CONSULTATION_FEES");
	                String availability = resultSet.getString("AVAILABILITY");
	                
	                System.out.println("ID: " + id + "  Name: " + name +" SPECIALIZATION : " + specialization + " CONSULTATION_FEES : " + fees + " AVAILABILITY : " + availability);

			 }
			 
		 }
		 catch(Exception e)
		 {
			 System.out.println(e);
		 }
	 }
	 
	 public static void CountDocShift( String countDocShift) throws InvalidInputforCountShift
	 {
		 if(!(countDocShift.equals(countDocShift)))
		 {
			 throw new InvalidInputforCountShift("Entered value is not among Morning or Evening , Please Correct the Input");
		 }
		 
		 String search = "Select * from DoctorInfo where availability = ?";
		 int Count=0;
		 try {
			 
			 PreparedStatement st = con1.prepareStatement(search);
			
			 st.setString(1, countDocShift); 

			 ResultSet resultSet = st.executeQuery();
			 while (resultSet.next()) {
				 Count++;      

			 }
			 System.out.println("Number of Doctor Available in "+countDocShift+ " are : "+Count);
			 
		 }
		 catch(Exception e)
		 {
			 System.out.println(e);
		 }
	 }
	 
	 public static void UpdateFees( int id , double docFees) throws InvalidInputforUpdateFees
	 {
		 if(id <=0)
		 {
			 throw new InvalidInputforUpdateFees("Entered value for ID is less than 0 please enter value greater than 0");
		 }
		 else if(docFees <=0)
		 {
			 throw new InvalidInputforUpdateFees("Entered value for Fees is less than 0 please enter value greater than 0");

		 }
		 
		  String query = "UPDATE DOCTORINFO SET CONSULTATION_FEES = ? where id= ? ";
			 
		  try {
			  PreparedStatement st = con1.prepareStatement(query);
				
				 st.setDouble(1, docFees); 
				 st.setInt(2, id);
				 st.executeUpdate();
				 System.out.println("Doctor fees Updated Successfully");
		  }
		 
		  catch(Exception e)
		  {
			  System.out.println(e);
		  }
		  
		 
	 }
	 
	
	 public static void CloseConnection()
	  {
		  try {
			con1.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
}

