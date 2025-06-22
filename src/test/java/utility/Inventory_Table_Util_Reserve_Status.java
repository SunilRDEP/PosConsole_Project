package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.aventstack.extentreports.ExtentTest;
import com.proenx.rdep.myproject.TestBase;
import com.proenx.rdep.myproject.TestBase_Mobile;

public class Inventory_Table_Util_Reserve_Status extends TestBase_Mobile{
	
	public static void getInventoryDetails(String storeCode, String sku, ExtentTest test) {
		 String dbHost = mobile_configue.getProperty("db.url");
		    String dbName = mobile_configue.getProperty("db.name");

		    String url = dbHost + dbName;
		    
		    
		    String username = mobile_configue.getProperty("db.username");
		    String password = mobile_configue.getProperty("db.password");

        String query = "SELECT available_on_hand, available_to_order, reserved FROM inventory WHERE store_code = ? AND sku = ?";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setString(1, storeCode);
            ps.setString(2, sku);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int onHand = rs.getInt("available_on_hand");
                int toOrder = rs.getInt("available_to_order");
                int reserved = rs.getInt("reserved");

                test.info("Available On Hand: " + onHand);
                test.info("Available To Order: " + toOrder);
                test.info("Reserved: " + reserved);
            } else {
                test.fail("No record found for store " + storeCode + " and SKU " + sku);
            }

        } catch (Exception e) {
            test.fail("Exception occurred: " + e.getMessage());
        }
    }	}