package com.amdocs.DMS.model;


public class DoctorEntity {
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public double getFees() {
		return consultation_fees;
	}

	public String getSpecialization() {
		return specialization;
	}
	public void setFees(double consultation_fees) {
		this.consultation_fees = consultation_fees;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	private int id;
    private String Name;
    private String specialization;
    private double consultation_fees;
    private String availability;
    

    // Constructors
    public DoctorEntity() {
    }

    public DoctorEntity(String Name,  String specialization,double consultation_fees , String availability) {
        this.Name = Name;  
        this.specialization = specialization;
        this.consultation_fees = consultation_fees;
        this.availability = availability;
       
    }

    // Getters and setters for all attributes
    // ...

    // Additional methods
   
    @Override
    public String toString() {
        return "Doctor ID: " + id + "\n" +
               "Full Name: " + getFullName() + "\n" +
               "Specialization: " + getSpecialization() + "\n" +
               "Consultation Fees : " + getFees()+ "\n"+
               "Availability :" + getAvailability() + "\n";
              
    }
}
