package com.virtusa.onlineBeautySalonProject;

	import java.util.List;

	public interface AppointmentService {

	    public Appointment placeAppointment(Appointment appointment);    
	    public List<Appointment> listAppointments();  
	    public Appointment getAppointmentdetails(String appointmentid); 
	    public String giveFeedback(Feedback feedback);
	}


