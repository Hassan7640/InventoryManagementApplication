package com.qa.persistence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
//import java.util.List;

import org.apache.log4j.Logger;

import com.qa.persistence.domain.Customer;

import utils.Config;

public class MySQLCustomerDAO implements CustomerDAO<Customer> {


	public static final Logger lOGGER = Logger.getLogger(MySQLCustomerDAO.class);
	

	public Customer create(Customer customer) {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://34.89.115.165:3306/ims", Config.username, Config.password)){
				 
			Statement stmt = connection.createStatement();
			stmt.executeUpdate("insert into customer(firstname, surname) values('" + customer.getFirstName() + "','" + customer.getSurname()+"')");
			System.out.println("Insert complete.");
		} catch (SQLException e) {
			lOGGER.debug(e.getStackTrace());
			lOGGER.error(e.getMessage());
		}
		return null;
	}
 
	public ArrayList<Customer> readAll() {
		ArrayList<Customer> customers = new ArrayList<Customer>();
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://34.89.115.165:3306/ims", Config.username, Config.password)){
			System.out.println("Database connected!");
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from customer");
			while (resultSet.next()) {
				Long id = resultSet.getLong("id");
				String firstName = resultSet.getString("firstname");
				String surName = resultSet.getString("surname");
				Customer customer = new Customer(id, firstName, surName);
				customers.add(customer);
			}
		} catch (SQLException e) {
			lOGGER.debug(e.getStackTrace());
			lOGGER.error(e.getMessage());
		}
	
		return customers;
	}
	public Customer update(Customer customer) {

		try (Connection connection = DriverManager.getConnection("jdbc:mysql://34.89.115.165:3306/ims", Config.username, Config.password))
			 {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate("UPDATE customer SET firstname= '" + customer.getFirstName() + "', surname= '"
					+ customer.getSurname() + "' WHERE id = " +customer.getId());
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
			stmt.executeUpdate("DELETE from customer WHERE id = " + id);
			System.out.println("Delete completed");

		} catch (Exception e) {
			lOGGER.debug(e.getStackTrace());
			lOGGER.error(e.getMessage());
		}
 
	}
}