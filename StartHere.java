package com.virtusa.onlineBeautySalonProject;

	import java.util.List;
	import java.util.Scanner;

import com.virtusa.onlineBeautySalonProject.*;

	public class StartHere {
	    public static String menu = "MENU";
	    public static String APPOINTMENT = "APPOINTMENT";
	    public static String LIST_APPOINTMENTS = "LIST_APPOINTMENTS";
	    static AppointmentService appointmentService = null;
	    static MenuItemService menuItemService = null;

	    public static void main(String[] args) {
	        appointmentService = new AppointmentServiceImplementation();
	        menuItemService = new MenuItemServiceImplementation();
	        System.out.println("----------WELCOME TO ONLINE BEAUTY SALON APPOINTMENT SYSTEM-------------");
	        printOptions();
	    }

	    public static void readInput(Scanner scanner) {
	        String next = scanner.next();

	        if (menu.equalsIgnoreCase(next)) {
	        	  System.out.println("---------SERVICES OFFERED-----------");
	        	  System.out.println("--------SERVICES MENU START-----------");
	          
	            
	            List<MenuItem> items = menuItemService.listMenu();
	            System.out.print(" Id ");
	            System.out.print(" Name ");
	            System.out.println("Price");
	            for (int i = 0; i < items.size(); i++) {
	                MenuItem m = items.get(i);
	                System.out.print("  " + m.getId());
	                System.out.print("    " + m.getName());
	                System.out.println("      " + m.getPrice());
	            }
	            System.out.println("--------SERVICES MENU END---------");
	           
	            printOptions();
	        } else if (APPOINTMENT.equalsIgnoreCase(next)) {
	            Appointment appointment = new Appointment();
	            System.out.println("Please enter required  Service Id");
	            String appointmentid = scanner.next();
	            appointment.setAppointmentid(appointmentid);
	            System.out.println("======= PaymentDetails =======");
	            System.out.println("Total amount is :: " + (menuItemService.getMenu(appointmentid).getPrice() ));
	            PaymentDetails paymentDetails = new PaymentDetails();

	            System.out.println("Please enter Payment Type CASH/CARD");
	            String type = scanner.next();
	            paymentDetails.setType(type);

	            if (type.equalsIgnoreCase("card")) {
	                System.out.println("please enter the card number");
	                String cardNumber = scanner.next();
	                paymentDetails.setCardNumber(cardNumber);
	                System.out.println("please enter the card holder name");
	                String cardHolderName = scanner.next();
	                paymentDetails.setCardHolderName(cardHolderName);
	            }
	            if (type.equalsIgnoreCase("Cash")) {
	                System.out.println("DeliveryExecutive will collect the cash");
	            }
	            appointment.setPaymentdetails(paymentDetails);
	            System.out.println("-------------- ADDRESS DETAILS--------------");
	            CustomerDetails customerDetails = new CustomerDetails();
	            System.out.print("Name :");
	            String name = scanner.next();
	            customerDetails.setCustomerName(name);
	            System.out.print("PhoneNumber :");
	            System.out.print("City :");
	            String city = scanner.next();
	            customerDetails.setCity(city);
	            System.out.print("State :");
	            String state = scanner.next();
	            customerDetails.setState(state);
	            System.out.print("Pincode :");
	            String pincode = scanner.next();
	            customerDetails.setPincode(Integer.parseInt(pincode));
	            appointment.setCustomerdetails(customerDetails);
	            Appointment updatedAppointment = appointmentService.placeAppointment(appointment);
	            if (updatedAppointment != null) {
	                System.out.println(" -------------- APPOINTMENT BOOKED, THANKS FOR CHOOSING US--------------");
	                System.out.println("Your Appointment id is :: " + updatedAppointment.getAppointmentid());
	                System.out.println("Your payment id is :: " + updatedAppointment.getPaymentId());
	                System.out.println("Delivery Executive details: ");
	                System.out.println(" -> Name = " + appointment.getStylist().getStylistname());
	                System.out.println("   > PhoneNumber = " + appointment.getStylist().getStylistphonenumber());
	                System.out.println("-------------- FEEDBACK--------------");
	                Feedback feedback = new Feedback();
	                feedback.setCustomerName(customerDetails.getCustomerName());
	                System.out.println("Kindly share your feedback here : ");
	                String message = scanner.next();
	                feedback.setMessage(message);
	                feedback.setOrderId(updatedAppointment.getAppointmentid());
	                appointment.setFeedback(feedback);
	                appointmentService.giveFeedback(feedback);
	                System.out.println("--------------THANKS FOR YOUR FEEDBACK HOPE TO  SEE YOU BACK --------------");
	            }
	            printOptions();
	        } else if (LIST_APPOINTMENTS.equalsIgnoreCase(next)) {
	            System.out.println("-------------- Appointments LIST START--------------");
	            
	            List<Appointment> appointments = appointmentService.listAppointments();
	            if (appointments.size() > 0) {
	                System.out.print("Id");
	                System.out.print("  item name");
	                System.out.print("  Price");
	                System.out.print(" Serviced By");
	                System.out.println("");
	                for (int i = 0; i < appointments.size(); i++) {
	                    Appointment appointment = appointments.get(i);
	                    System.out.print(appointment.getAppointmentid());
	                    System.out.print("    " + appointment.getAppointmentid());
	                    System.out.print("    " + appointment.getPrice());
	                    System.out.print("    " + appointment.getStylist().getStylistname());
	                    System.out.println();
	                }
	            } else {
	                System.out.println("No Appointment");
	            }
	            System.out.println();
	            System.out.println("-------------- Appointments LIST END--------------");
	            System.out.println();
	            printOptions();

	        } else {
	            System.out.println("INVALID input, try again");
	            readInput(scanner);
	        }

	    }

	    static void printOptions() {
	        Scanner scanner = new Scanner(System.in);
	        System.out.println("");
	        System.out.println("--------------OPTIONS START--------------");
	        System.out.println("Type MENU to see the menu items");
	        System.out.println("Type Appointment"+ " to book Appointment");
	        System.out.println("Type LIST_AppointmentS to see all appointments");
	        System.out.println("--------------OPTIONS END------------------");
	        readInput(scanner);
	    }
	}


