package com.virtusa.onlineBeautySalonProject;

	import java.util.Date;

	public class Feedback {
	    private String id;
	    private String customerName;
	    private String message;
	    private Date date;
	    private String orderId;


	    public String getOrderId() {
	        return orderId;
	    }

	    public void setOrderId(String orderId) {
	        this.orderId = orderId;
	    }

	    public String getId() {
	        return id;
	    }

	    public void setId(String id) {
	        this.id = id;
	    }

	    public String getCustomerName() {
	        return customerName;
	    }

	    public void setCustomerName(String customerName) {
	        this.customerName = customerName;
	    }

	    public String getMessage() {
	        return message;
	    }

	    public void setMessage(String message) {
	        this.message = message;
	    }

	    public Date getDate() {
	        return date;
	    }

	    public void setDate(Date date) {
	        this.date = date;
	    }
	}


