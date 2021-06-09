package com.virtusa.onlineBeautySalonProject;


	import java.util.List;

import com.virtusa.onlineBeautySalonProject.Appointment;
import com.virtusa.onlineBeautySalonProject.MenuItem;

	public interface MenuItemService {

		public List<MenuItem> listMenu();  

	    public MenuItem getMenu(String id);
	
}


