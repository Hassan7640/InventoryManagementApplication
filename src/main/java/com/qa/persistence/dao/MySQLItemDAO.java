package com.qa.persistence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;

//import com.qa.persistence.domain.Customer;
import com.qa.persistence.domain.Items;

import utils.Config;

public class MySQLItemDAO implements ItemDAO<Items> {

public static final Logger lOGGER = Logger.getLogger(MySQLCustomerDAO.class);
	

//	public Items create(Items item) {
//		try (Connection connection = DriverManager.getConnection("jdbc:mysql://34.89.115.165:3306/ims", Config.username, Config.password)){
//				 
//			Statement stmt = connection.createStatement();
//			stmt.executeUpdate("insert into item(item_name, item_value) values('" + item.getItemName() + "','" + item.getItemValue()+"')");
//			System.out.println("Insert complete.");
//		} catch (SQLException e) {
//			lOGGER.debug(e.getStackTrace());
//			lOGGER.error(e.getMessage());
//		}
//		return null;
//	}
 
public Items create(Items item) {
try (Connection connection = DriverManager.getConnection("jdbc:mysql://34.89.115.165:3306/ims", Config.username, Config.password)){
		 
	Statement stmt = connection.createStatement();
	stmt.executeUpdate("insert into item(item_name, item_value) values('" + item.getItemName() + "','" + item.getItemValue()+ "')");
	System.out.println("Insert complete.");
} catch (SQLException e) {
	lOGGER.debug(e.getStackTrace());
	lOGGER.error(e.getMessage());
}
return null;
}

	public ArrayList<Items> readAll() {
		ArrayList<Items> items = new ArrayList<Items>();
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://34.89.115.165:3306/ims", Config.username, Config.password)){
			System.out.println("Database connected!");
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from item");
			while (resultSet.next()) {
				Long id = resultSet.getLong("id");
				String itemName = resultSet.getString("item_name");
				Double itemValue = resultSet.getDouble("item_value");
				Items item = new Items(id, itemName, itemValue);
				items.add(item);
			}
			
		} catch (SQLException e) {
			lOGGER.debug(e.getStackTrace());
			lOGGER.error(e.getMessage());
		}
		
		return items;
	}
	 
	public Items update(Items item) {

		try (Connection connection = DriverManager.getConnection("jdbc:mysql://34.89.115.165:3306/ims", Config.username, Config.password))
			 {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate("UPDATE item SET item_name ='" + item.getItemName() + "', item_value ='" + item.getItemValue() + "' WHERE id = " + item.getId());
			System.out.println("Update completed.");

		} catch (Exception e) {
			lOGGER.debug(e.getStackTrace());
			lOGGER.error(e.getMessage());
		}
return null;
	}
	
	public void delete(long id) {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://34.89.115.165:3306/ims", Config.username,
				Config.password)) {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate("DELETE from item WHERE id = " + id);
			System.out.println("Delete completed");

		} catch (Exception e) {
			lOGGER.debug(e.getStackTrace());
			lOGGER.error(e.getMessage());
		}
	}
	
//	public Double getItemPrice(Items item) {
//		Double itemValue=0.00;
//		try (Connection connection = DriverManager.getConnection("jdbc:mysql://34.89.115.165:3306/ims", Config.username,
//				Config.password)) {
//			Statement statement = connection.createStatement();
//			ResultSet resultSet = statement.executeQuery("select item_value from item where id="+item.getId());
//			while (resultSet.next()) {
//			   itemValue = resultSet.getDouble("item_value");
//			}
//			
//
//			
//		}catch(Exception e) {
//			
//		}
//		return itemValue;
//	}
	


}
