import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.qa.controller.Action;
import com.qa.controller.CrudCustomerController;
import com.qa.controller.CrudItemsController;
import com.qa.controller.CrudOrderItemController;
import com.qa.controller.CrudOrdersController;
import com.qa.controller.CustomerController;
import com.qa.controller.ItemsController;
import com.qa.controller.OrderItemController;
import com.qa.controller.OrdersController;
//import com.qa.controller.OrdersController;
import com.qa.persistence.dao.MySQLCustomerDAO;
import com.qa.persistence.dao.MySQLItemDAO;
import com.qa.persistence.dao.MySQLOrderDAO;
import com.qa.persistence.dao.MySQLOrderItemDAO;
import com.qa.persistence.domain.Domain;
import com.qa.services.CustomerServices;
import com.qa.services.ItemServices;
import com.qa.services.OrderItemServices;
import com.qa.services.OrderServices;

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
		   break;
	   case ITEM:
		   ItemsController itemsController = new ItemsController(new ItemServices(new MySQLItemDAO()));
		   doActionItems(itemsController, action);
		   break;
	   case ORDER:
		   OrdersController ordersController = new OrdersController(new OrderServices(new MySQLOrderDAO()));
		   doActionOrders(ordersController, action);
		   break;
	   case ORDERITEM:
		    OrderItemController orderItemController = new OrderItemController(new OrderItemServices(new MySQLOrderItemDAO()));
		    doActionOrdersItem(orderItemController,action);
		    break;
	   case STOP:
		   break;
	   default:
		   break;
	   }
   }
 


	public void doAction(CrudCustomerController<?> crudController,  Action action) {
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

	public void doActionItems( CrudItemsController<?> itemController,  Action action) {
		switch (action) {
		case CREATE:
			itemController.create();
			break;
		case READ:
			itemController.readAll();
			break;
		case UPDATE:
			itemController.update();
			break; 
		case DELETE:
			itemController.delete();
			break;
		case RETURN:
			break;
		 default:
			 break;
		}
	}
	
	public void doActionOrders( CrudOrdersController<?> ordersController,  Action action) {
		switch (action) {
		case CREATE:
			ordersController.create();
			break;
		case READ:
			ordersController.readAll();
			break;
		case UPDATE:
			ordersController.update();
			break; 
		case DELETE:
			ordersController.delete();
			break;
		case RETURN:
			break;
		 default:
			 break;
		}
	}
	
	private void doActionOrdersItem(CrudOrderItemController<?> orderItemController, Action action) {
		switch (action) {
		case CREATE:
			orderItemController.create();
			break;
		case READ:
			orderItemController.readAll();
			break;
		case UPDATE:
			orderItemController.update();
			break; 
		case DELETE:
			orderItemController.delete();
			break;
		case RETURN:
			break;
		 default:
			 break;
		}
		
	}
}