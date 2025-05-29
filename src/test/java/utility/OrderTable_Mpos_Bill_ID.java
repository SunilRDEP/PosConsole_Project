package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.aventstack.extentreports.ExtentTest;
import com.proenx.rdep.myproject.TestBase;
import com.proenx.rdep.myproject.TestBase_Mobile;

public class OrderTable_Mpos_Bill_ID extends TestBase_Mobile{
	public static String  expectedBillId(ExtentTest test) throws SQLException {
		 String billId = null;
		 String query = "SELECT bill_id FROM orders WHERE bill_id IS NOT NULL ORDER BY created_date DESC LIMIT 1";

		    
        String url = "jdbc:postgresql://px-qa-rds.cfksqimc28v1.ap-south-1.rds.amazonaws.com:5432/rdep_order";
        String username = "devserver";
        String password = "Ljn38UcRyvLNq3A";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
        	  if (resultSet.next()) {
                  billId = resultSet.getString("bill_id");
                  test.pass("Fetched bill_id from DB: " + billId);
            
        	  }
        	  
        } catch (Exception e) {
            test.fail("Error fetching bill_id from DB: " + e.getMessage());
            e.printStackTrace();
        }

        return billId;
}}