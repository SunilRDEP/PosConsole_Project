package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.proenx.rdep.myproject.TestBase;

public class DatabaseUtils extends TestBase{
	public static boolean validateTestCaseData(String query, String expectedSku, String expectedOnhand) {
        String url = "jdbc:postgresql://dev-pg-db.cdrr5mgbdwch.ap-south-1.rds.amazonaws.com:5432/inventory";
        String username = "devserver";
        String password = "AsunVfAWXDdSqj9C3hQe";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            // Loop through all rows in the result set
            while (resultSet.next()) {
                String sku = resultSet.getString("sku"); // Assuming column name is 'sku'
                String available_on_hand = resultSet.getString("available_on_hand"); // Assuming column name is 'onhand'

                // Compare the result with expected test case data
                if (sku.equals(expectedSku) && available_on_hand.equals(expectedOnhand)) {
                	
                	test.pass("Expcted SKU in DB is " + sku);
                	test.pass("Expcted SKU in DB is " + available_on_hand);
                    return true; // Test case data found in database
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
}}