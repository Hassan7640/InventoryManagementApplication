package com.qa.persistence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.qa.persistence.domain.OrderItems;

import utils.Config;

public class MySQLOrderItemDAO implements OrderItemDAO<OrderItems>{

	public static final Logger lOGGER = Logger.getLogger(MySQLOrderItemDAO.class);

	public OrderItems create(OrderItems orderItem) {
		
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://34.89.14.13:3306/inventory",  Config.username, Config.password )){
			Statement stmt = connection.createStatement();
			stmt.executeUpdate("INSERT INTO itemsorder(order_id, item_id) VALUES (' " +orderItem.getOrderId()+ "','" +orderItem.getItemId()+ "')");
			System.out.println("insert complete");
		}catch (SQLException e) {
			lOGGER.debug(e.getStackTrace());
			lOGGER.error(e.getMessage());

		}
		return null;
		
	}
	
	public ArrayList<OrderItems> readAll() {
		ArrayList<OrderItems> orders = new ArrayList<OrderItems>();
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://34.89.14.13:3306/inventory", Config.username, Config.password)){
			System.out.println("Database connected!");
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from itemsorder");
			while (resultSet.next()) {
				Long id = resultSet.getLong("id");
				Long orderId = resultSet.getLong("order_id");
				Long itemId = resultSet.getLong("item_id");
				OrderItems order =new OrderItems(id, orderId, itemId);
				orders.add(order);
			}
		} catch (SQLException e) {
			lOGGER.debug(e.getStackTrace());
			lOGGER.error(e.getMessage());
		} 
		return orders;
		
	}

	public OrderItems update(OrderItems orderItem) {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://34.89.14.13:3306/inventory", Config.username,
				Config.password)) {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate("UPDATE itemsorder SET item_ordered = '"+orderItem.getOrderId()+ "', item_id= '" +orderItem.getItemId()+"' WHERE id= " + orderItem.getId());
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
			stmt.executeUpdate("DELETE from itemsorder WHERE id = " + id);
			System.out.println("Delete completed");

		} catch (Exception e) {
			lOGGER.debug(e.getStackTrace());
			lOGGER.error(e.getMessage());
		}
		 
	}
}
