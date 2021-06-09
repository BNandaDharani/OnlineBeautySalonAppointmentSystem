package com.virtusa.onlineBeautySalonProject;


	import java.sql.Connection;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.ArrayList;
	import java.util.Date;
	import java.util.List;
	import java.util.Random;

import com.virtusa.onlineBeautySalonProject.*;

	public class AppointmentServiceImplementation implements AppointmentService {
	    @Override
	    public Appointment placeAppointment(Appointment appointment) {
	        DBConnectionImplementation db = new DBConnectionImplementation();
	        Connection con = db.getConnection();
	        Random random = new Random();

	        try {
	           
	            Statement stmt = con.createStatement();
	            String paymentId = String.valueOf(random.nextInt(200000));
	            appointment.setPaymentId(paymentId);
	            String appointmentid = String.valueOf(random.nextInt(500000));
	            appointment.setAppointmentid(appointmentid);
	            String addressId = String.valueOf(random.nextInt(800000));
	            appointment.setAddressId(addressId);

	            String stylistid = String.valueOf(random.nextInt(4) + 1);
	            appointment.setStylistid(stylistid);
	            appointment.setStylist(getStylist(stylistid));

	            MenuItem menuItem = new MenuItemServiceImplementation().getMenu(appointment.getServiceid());
	            if (menuItem != null)
	             

	            stmt.executeUpdate("INSERT INTO payment " + "VALUES('" + paymentId + "','" + appointmentid + "','" + appointment.getPaymentdetails().getType() + "','" + appointment.getPaymentdetails().getCardNumber() + "','" + appointment.getPaymentdetails().getCardHolderName() + "')");
	            stmt.executeUpdate("INSERT INTO customerdetails " + "VALUES('" + addressId + "','" + appointment.getCustomerdetails().getCustomerName() + "','" + appointment.getStylist() + "','" + appointment.getCustomerdetails()+ "','" +appointment.getCustomerdetails().getState() + "','"  + "','" + appointment.getCustomerdetails().getCity() + "','" + appointment.getCustomerdetails().getState() + "','" + appointment.getCustomerdetails().getPincode() + "')");
	            stmt.executeUpdate("INSERT INTO appointmentdetails " + "VALUES('" + appointmentid + "','" + appointment.getServiceid() + "'," + appointment.getPrice() + "," + "," + null + ",'" + stylistid + "'," + null + ",'" + paymentId + "','" + addressId + "')");
	            return appointment;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return null;
	    }

	    private Stylist getStylist(String stylistid) {

			return null;
		}

		@Override
	    public List<Appointment> listAppointments() {
	        DBConnection db = new DBConnectionImplementation();
	        Connection con = db.getConnection();
	        Statement stmt = null;
	        List<Appointment> appointments = new ArrayList<>();
	        try {
	            stmt = con.createStatement();
	            ResultSet rs = stmt.executeQuery("select * from appointmentdetails");
	            while (rs.next()) {
	                Appointment appointment = new Appointment();
	                appointment.setAppointmentid((rs.getString("id")));
	                appointment.setServiceid((rs.getString("Id")));
	                appointment.setStylistid((rs.getString("Stylist")));
	                appointment.setPrice((rs.getInt("price")));
	                MenuItem menuItem = new MenuItemServiceImplementation().getMenu( appointment.getServiceid());
	                appointment.setServiceid(menuItem.getName());

	                 Stylist stylist = getStylist(appointment.getStylistid());
	                appointment.setStylist(stylist);
	                appointment.add(appointment);
	            }
	            con.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return  appointments;
	    }

	    
	   

	    @Override
	    public String giveFeedback(Feedback feedback) {
	        DBConnectionImplementation db = new DBConnectionImplementation();
	        Connection con = db.getConnection();
	        Random random = new Random();
	        try {
	            Statement stmt = con.createStatement();

	            String feedbackId = String.valueOf(random.nextInt(500000)); 
	            stmt.executeUpdate("INSERT INTO feedback " + "VALUES('" + feedbackId + "','" + feedback.getCustomerName() + "','" + feedback.getMessage() + "','" + feedback.getOrderId() + "')");
	            return feedbackId;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }


	        return null;
	    }

		@Override
		public Appointment getAppointmentdetails(String appointmentid) {
			
			return null;
		}

	    

	}


