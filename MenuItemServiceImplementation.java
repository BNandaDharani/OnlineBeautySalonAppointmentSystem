package com.virtusa.onlineBeautySalonProject;

	import java.sql.Connection;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.ArrayList;
	import java.util.List;

import com.virtusa.onlineBeautySalonProject.DBConnection;
import com.virtusa.onlineBeautySalonProject.DBConnectionImplementation;
import com.virtusa.onlineBeautySalonProject.MenuItem;

	public class MenuItemServiceImplementation implements MenuItemService {


	    @Override
	    public List<MenuItem> listMenu() {
	        DBConnection db = new DBConnectionImplementation();
	        Connection con = db.getConnection();
	        Statement stmt = null;
	        List<MenuItem> menuItemList = new ArrayList<MenuItem>();
	        try {
	            stmt = con.createStatement();
	            ResultSet rs = stmt.executeQuery("select * from menuitem");
	            while (rs.next()) {
	                MenuItem menuItem = new MenuItem();
	                menuItem.setId((rs.getString("id")));
	                menuItem.setName((rs.getString("name")));
	                menuItem.setPrice((rs.getInt("price")));
	                menuItemList.add(menuItem);
	            }
	            con.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return menuItemList;
	    }


	    @Override
	    public MenuItem getMenu(String id) {
	        DBConnectionImplementation db = new DBConnectionImplementation();
	        Connection con = db.getConnection();
	        Statement stmt = null;
	        MenuItem menuItem = null;
	        try {
	            stmt = con.createStatement();
	            ResultSet rs = stmt.executeQuery("select * from menuitem where id='" + id + "'");
	            while (rs.next()) {
	                menuItem = new MenuItem();
	                menuItem.setId((rs.getString("id")));
	                menuItem.setName((rs.getString("name")));
	                menuItem.setPrice((rs.getInt("price")));
	            }
	            con.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return menuItem;
	    }
	}


