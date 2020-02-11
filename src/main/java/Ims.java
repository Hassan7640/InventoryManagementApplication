import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.qa.controller.Action;
import com.qa.controller.CrudController;
import com.qa.controller.CustomerController;
import com.qa.persistence.dao.MySQLCustomerDAO;
import com.qa.persistence.domain.Domain;
import com.qa.services.CustomerServices;

import utils.Config;
import utils.Utils;

public class Ims {
	public static final Logger LOGGER = Logger.getLogger(Ims.class);

	public void imventoryManagementSystem() throws SQLException {
	   LOGGER.info("What is your username");
	   Config.username= Utils.getInput();
	   LOGGER.info("What is your password");
	   Config.password= Utils.getInput();
	  
	   LOGGER.info("Which entity would you like to use?");
	   Domain.printDomains();
	   
	   Domain domain = Domain.getDomain();
	   LOGGER.info("What would you like to do with " + domain.name().toLowerCase() + ":");
	   
	   Action.printAction();
	   Action action = Action.getAction();
	   
	   switch (domain) {
	   case CUSTOMER:
		   CustomerController customerController = new CustomerController(new CustomerServices(new MySQLCustomerDAO()));
		   doAction(customerController, action);
	   case ITEM:
		   break;
	   case ORDER:
		   break;
	   case STOP:
		   break;
	   default:
		   break;
	   }
   }

	public void doAction(CrudController<?> crudController, Action action) {
		switch (action) {
		case CREATE:
			crudController.create();
			break;
		case READ:
			crudController.readAll();
			break;
		case UPDATE:
			crudController.update();
			break; 
		case DELETE:
			crudController.delete();
			break;
		case RETURN:
			break;
		 default:
			 break;
		}
	}
}