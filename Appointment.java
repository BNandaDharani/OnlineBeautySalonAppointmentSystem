package com.virtusa.onlineBeautySalonProject;

import java.util.Date;
public class Appointment {
	
	

	    private String appointmentid;
	    private String serviceid;
	    private float price;
	    private Date appointmentat;
	    private String stylistid;
	    private Date servedat; // ignore this for now while feeding data to DB
	    private String paymentId;
	    private String addressId;
	    private String feedbackId;
	    private PaymentDetails paymentdetails;
	    private CustomerDetails customerdetails;
	    private Stylist stylist;
	    private Feedback feedback;

	    public float getPrice() {
	        return price;
	    }

	    public void setPrice(float price) {
	        this.price = price;
	    }

	    public String getAppointmentid() {
	        return appointmentid;
	    }

	    public void setAppointmentid(String appointmentid) {
	        this.appointmentid = appointmentid;
	    }

	    public String getServiceid() {
	        return serviceid;
	    }

	    public void setServiceid(String serviceid) {
	        this.serviceid = serviceid;
	    }

	    public Date getAppointmentat() {
	        return appointmentat;
	    }

	    public void setAppointmentat(Date appointmentid) {
	        this.appointmentat = appointmentid;
	    }

	    public String getStylistid() {
	        return stylistid;
	    }

	    public void setStylistid(String stylistid) {
	        this.stylistid = stylistid;
	    }

	    public Date getServedat() {
	        return servedat;
	    }

	    public void setServedat(Date servedat) {
	        this.servedat = servedat;
	    }

	    public String getPaymentId() {
	        return paymentId;
	    }

	    public void setPaymentId(String paymentId) {
	        this.paymentId = paymentId;
	    }

	    public String getAddressId() {
	        return addressId;
	    }

	    public void setAddressId(String addressId) {
	        this.addressId = addressId;
	    }

	    public PaymentDetails getPaymentdetails() {
	        return paymentdetails;
	    }

	    public void setPaymentdetails(PaymentDetails paymentdetails) {
	        this.paymentdetails = paymentdetails;
	    }

	    public CustomerDetails getCustomerdetails() {
	        return customerdetails;
	    }

	    public void setCustomerdetails(CustomerDetails customerdetails) {
	        this.customerdetails = customerdetails;
	    }

	    public Stylist getStylist() {
	        return stylist;
	    }

	    public Feedback getFeedback() {
	        return feedback;
	    }

	    public void setFeedback(Feedback feedback) {
	        this.feedback = feedback;

	    }

	    public void setStylist(Stylist stylist) {
	        this.stylist =stylist;
	    }

	    public String getFeedbackId() {
	        return feedbackId;
	    }

	    public void setFeedbackId(String feedbackId) {
	        this.feedbackId = feedbackId;
	    }

		public String getItemId() {
			// TODO Auto-generated method stub
			return null;
		}


		

		public String getServiceid1() {
	
			return null;
		}

		public void add(Appointment appointment) {
			
			
		}

			
		}
	


