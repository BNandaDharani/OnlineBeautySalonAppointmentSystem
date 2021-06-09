package com.virtusa.onlineBeautySalonProject;

public class PaymentDetails {
	
		

	    private String id;
	    private String appointmentid;
	    private PaymentType type;
	    private String cardNumber;
	    private String cardHolderName;

	    enum PaymentType {
	        CASH,
	        CARD,
	        UPI,
	        INTERNET_BANKING
	    }

	    public String getId() {
	        return id;
	    }

	    public void setId(String id) {
	        this.id = id;
	    }

	    public String getAppointmentid() {
	        return appointmentid;
	    }

	    public void setAppointmentid(String appointmentid) {
	        this.appointmentid = appointmentid;
	    }

	    public PaymentType getType() {
	        return type;
	    }

	    public void setType(String type) {
	        try {
	            PaymentType payment = Enum.valueOf(PaymentType.class, type);
	            this.type = payment;
	        } catch (Exception e) {

	        }

	    }

	    public String getCardNumber() {

	        return cardNumber;
	    }

	    public void setCardNumber(String cardNumber) {
	        this.cardNumber = cardNumber;
	    }

	    public String getCardHolderName() {
	        return cardHolderName;
	    }

	    public void setCardHolderName(String cardHolderName) {
	        this.cardHolderName = cardHolderName;
	    }
	}


