

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.qa.persistence.dao.MySQLCustomerDAO;
import com.qa.persistence.domain.Customer;

public class Runner {

	public static final Logger LOGGER = Logger.getLogger(Runner.class);
	
	
	public static void main(String[] args) throws SQLException {
		Ims ims = new Ims();
		ims.imventoryManagementSystem();

	}
}