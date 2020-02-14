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

public class MySQLCustomerDAO implements CustomerDAO<Customer> {

	public static final Logger LOGGER = Logger.getLogger(MySQLCustomerDAO.class);

	private String jdbcConnectionUrl;
	private String username;
	private String password;

	public MySQLCustomerDAO(String username, String password) {
		this.jdbcConnectionUrl = "jdbc:mysql://34.89.115.165:3306/ims";
		this.username = username;
		this.password = password;
	}

	public MySQLCustomerDAO(String jdbcConnectionUrl, String username, String password) {
		this.jdbcConnectionUrl = jdbcConnectionUrl;
		this.username = username;
		this.password = password;
	}

	Customer customerFromResultSet(ResultSet resultSet) throws SQLException {
		Long id = resultSet.getLong("id");
		String firstname = resultSet.getString("firstname");
		String surname = resultSet.getString("surname");
		return new Customer(id, firstname, surname);
	}

	/**
	 * Reads all customers from the database
	 * 
	 * @return A list of customers
	 */
	@Override
	public ArrayList<Customer> readAll() {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("select * from customer");) {
			ArrayList<Customer> customers = new ArrayList<>();
			while (resultSet.next()) {
				customers.add(customerFromResultSet(resultSet));
			}
			return customers;
		} catch (SQLException e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

//	public Customer readLatest() {
//		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
//				Statement statement = connection.createStatement();
//				ResultSet resultSet = statement.executeQuery("select from customer order by id DESC LIMIT 1");) {
//			resultSet.next();
//			return customerFromResultSet(resultSet);
//		} catch (Exception e) {
//			LOGGER.debug(e.getStackTrace());
//			LOGGER.error(e.getMessage());
//		}
//		return null;
//	}

	/**
	 * Creates a customer in the database
	 * 
	 * @param customer - takes in a customer object. id will be ignored
	 */
	@Override
	public Customer create(Customer customer) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("insert into customer(firstname, surname) values('" + customer.getFirstName()
					+ "','" + customer.getSurname() + "')");
			//return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	public Customer readCustomer(Long id) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT FROM customer where id = " + id);) {
			resultSet.next();
			return customerFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Updates a customer in the database
	 * 
	 * @param customer - takes in a customer object, the id field will be used to
	 *                 update that customer in the database
	 * @return
	 */
	@Override
	public Customer update(Customer customer) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("update customer set firstname ='" + customer.getFirstName() + "', surname ='"
					+ customer.getSurname() + "' where id =" + customer.getId());
			return readCustomer(customer.getId());
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Deletes a customer in the database
	 * 
	 * @param id - id of the customer
	 */
	@Override
	public void delete(long id) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("delete from customer where id = " + id);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
	}

//	public static final Logger lOGGER = Logger.getLogger(MySQLCustomerDAO.class);
//	
//
//	public Customer create(Customer customer) {
//		try (Connection connection = DriverManager.getConnection("jdbc:mysql://34.89.115.165:3306/ims", Config.username, Config.password)){
//				 
//			Statement stmt = connection.createStatement();
//			stmt.executeUpdate("insert into customer(firstname, surname) values('" + customer.getFirstName() + "','" + customer.getSurname()+"')");
//			System.out.println("Insert complete.");
//		} catch (SQLException e) {
//			lOGGER.debug(e.getStackTrace());
//			lOGGER.error(e.getMessage());
//		}
//		return null;
//	}
// 
//	public ArrayList<Customer> readAll() {
//		ArrayList<Customer> customers = new ArrayList<Customer>();
//		try (Connection connection = DriverManager.getConnection("jdbc:mysql://34.89.115.165:3306/ims", Config.username, Config.password)){
//			System.out.println("Database connected!");
//			Statement statement = connection.createStatement();
//			ResultSet resultSet = statement.executeQuery("select * from customer");
//			while (resultSet.next()) {
//				Long id = resultSet.getLong("id");
//				String firstName = resultSet.getString("firstname");
//				String surName = resultSet.getString("surname");
//				Customer customer = new Customer(id, firstName, surName);
//				customers.add(customer);
//			}
//		} catch (SQLException e) {
//			lOGGER.debug(e.getStackTrace());
//			lOGGER.error(e.getMessage());
//		}
//	
//		return customers;
//	}
//	public Customer update(Customer customer) {
//
//		try (Connection connection = DriverManager.getConnection("jdbc:mysql://34.89.115.165:3306/ims", Config.username, Config.password))
//			 {
//			Statement stmt = connection.createStatement();
//			stmt.executeUpdate("UPDATE customer SET firstname= '" + customer.getFirstName() + "', surname= '"
//					+ customer.getSurname() + "' WHERE id = " +customer.getId());
//			System.out.println("Update completed.");
//
//		} catch (Exception e) {
//			lOGGER.debug(e.getStackTrace());
//			lOGGER.error(e.getMessage());
//		}
//return null;
//	}
// 
//	public void delete(long id) {
//		try (Connection connection = DriverManager.getConnection("jdbc:mysql://34.89.115.165:3306/ims", Config.username,
//				Config.password)) {
//			Statement stmt = connection.createStatement();
//			stmt.executeUpdate("DELETE from customer WHERE id = " + id);
//			System.out.println("Delete completed");
//
//		} catch (Exception e) {
//			lOGGER.debug(e.getStackTrace());
//			lOGGER.error(e.getMessage());
//		}
//
//	}
}