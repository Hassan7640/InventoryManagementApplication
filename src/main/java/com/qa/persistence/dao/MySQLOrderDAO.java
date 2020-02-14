package com.qa.persistence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.qa.persistence.domain.Orders;

import utils.Config;

public class MySQLOrderDAO  implements OrderDAO<Orders>{

	
//	public MySQLOrderDAO() throws SQLException {
//		this.connection=  DriverManager.getConnection("jdbc:mysql://34.89.115.165:3306/ims", "root", "root");
//	}
//	
	public static final Logger lOGGER = Logger.getLogger(MySQLOrderDAO.class);

	public Orders create(Orders order) {
		
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://34.89.14.13:3306/inventory", Config.username, Config.password)){
			Statement stmt = connection.createStatement();
			stmt.executeUpdate("INSERT INTO orders(order_cost, customer_id) VALUES (' "+order.getOrderCost()+ "','" + order.getCustomerId()+ "')");
			System.out.println("insert complete");
		}catch (SQLException e) {
			lOGGER.debug(e.getStackTrace());
			lOGGER.error(e.getMessage());

		}
		return null;
		
	}
	
	public ArrayList<Orders> readAll() {
		ArrayList<Orders> orders = new ArrayList<Orders>();
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://34.89.14.13:3306/inventory", Config.username, Config.password)){
			System.out.println("Database connected!");
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from orders");
			while (resultSet.next()) {
				Long id = resultSet.getLong("id");
				Double orderCost = resultSet.getDouble("order_cost");
				Long customerId = resultSet.getLong("customer_id");
				Orders order =new Orders(id, orderCost, customerId);
				orders.add(order);
			}
		} catch (SQLException e) {
			lOGGER.debug(e.getStackTrace());
			lOGGER.error(e.getMessage());
		} 
		return orders;
		
	}

	public Orders update(Orders order) {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://34.89.14.13:3306/inventory", Config.username,
				Config.password)) {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate("UPDATE items SET order_cost = '" + order.getOrderCost() + "', customer_id= '"
					+ order.getCustomerId() + "' WHERE id= " + order.getId());
			System.out.println("Update completed.");

		} catch (Exception e) {
			lOGGER.debug(e.getStackTrace());
			lOGGER.error(e.getMessage());
		}
		return null;
	}		
	

	public void delete(long id) {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://34.89.14.13:3306/inventory", Config.username,
				Config.password)) {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate("DELETE from orders WHERE id = " + id);
			System.out.println("Delete completed");

		} catch (Exception e) {
			lOGGER.debug(e.getStackTrace());
			lOGGER.error(e.getMessage());
		}
		
	}


 
}
