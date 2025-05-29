package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.aventstack.extentreports.ExtentTest;
import com.proenx.rdep.myproject.TestBase;
import com.proenx.rdep.myproject.TestBase_Mobile;

public class Inventory_Table_Util_Available_Status extends TestBase_Mobile{
	
	//POJO CLASS
	public static class InventoryData {
	        public String availableOnHand;
	        public String availableToOrder;

	        public InventoryData(String availableOnHand, String availableToOrder) {
	            this.availableOnHand = availableOnHand;
	            this.availableToOrder = availableToOrder;
	        }
	    }

	    // Utility method to fetch inventory data by store code
	public static InventoryData getInventoryDataByStoreAndSku(String storeCode, String sku, ExtentTest test) {
	    // Load database configuration	
	    
	    String dbHost = mobile_configue.getProperty("db.url");
	    String dbName = mobile_configue.getProperty("db.name");

	    String url = dbHost + dbName;
	    
	    
	    String username = mobile_configue.getProperty("db.username");
	    String password = mobile_configue.getProperty("db.password");
	    
	    String query = "SELECT available_on_hand, available_to_order " +
	                   "FROM inventory WHERE store_code = '" + storeCode + 
	                   "' AND sku = '" + sku + "'";

	    try (
	        Connection connection = DriverManager.getConnection(url, username, password);
	        Statement statement = connection.createStatement();
	        ResultSet resultSet = statement.executeQuery(query)
	    ) {
	        if (resultSet.next()) {
	            String availableOnHand = resultSet.getString("available_on_hand");
	            String availableToOrder = resultSet.getString("available_to_order");

	            test.pass("Fetched inventory for store " + storeCode + ", SKU " + sku +
	                      " - OnHand: " + availableOnHand + ", ToOrder: " + availableToOrder);

	            return new InventoryData(availableOnHand, availableToOrder);
	        } else {
	            test.fail("No inventory data found for store: " + storeCode + ", SKU: " + sku);
	        }
	    } catch (Exception e) {
	        test.fail("Error fetching inventory data: " + e.getMessage());
	        e.printStackTrace();
	    }

	    return new InventoryData("0", "0"); // fallback if no result
	}}