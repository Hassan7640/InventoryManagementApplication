//package com.qa.persistence.dao;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//
//import com.qa.persistence.domain.Orders;
//
//public class MySQLOrderDAO  implements DAO<Orders>{
//
//	private Connection connection;
//	
//	public MySQLOrderDAO() throws SQLException {
//		this.connection=  DriverManager.getConnection("jdbc:mysql://34.89.115.165:3306/ims", "root", "root");
//	}
//	
//	public void create(Orders order) {
//		
//		try(Connection connection = DriverManager.getConnection("jdbc:mysql://34.89.115.165:3306/ims", "root", "root")){
//			Statement stmt = connection.createStatement();
//			stmt.executeUpdate("INSERT INTO orders(order_cost, customer_id) VALUES (' "+order.getOrder_cost()+ "','" + order.getCustomer_id()+ "");
//			System.out.println("insert complete");
//		}catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//	}
//
//	public ArrayList<Orders> readAll() {
//		ArrayList<Orders> orders = new ArrayList<Orders>();
//		try {
//			//System.out.println("Database connected!");
//			Statement statement = connection.createStatement();
//			ResultSet resultSet = statement.executeQuery("select * from orders");
//			while (resultSet.next()) {
//				Long id = resultSet.getLong("id");
//				Long customer_id = resultSet.getLong("customer_id");
//				float order_cost = resultSet.getFloat("order_cost");
//				Orders order =new Orders(id, customer_id, order_cost);
//				orders.add(order);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} 
//		return orders;
//		
//	}
//	public void update(Orders order) {
////		try (Connection connection )
////		
//	}
//
//	public void delete(int id) {
//		// TODO Auto-generated method stub
//		
//	}
//
//}
