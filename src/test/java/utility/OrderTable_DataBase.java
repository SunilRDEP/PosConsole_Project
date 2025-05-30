package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.proenx.rdep.myproject.TestBase;

public class OrderTable_DataBase extends TestBase{
	public static boolean validateTestCaseData(String query, String expected_bill_id) {
        String url = "jdbc:postgresql://px-qa-db.cfksqimc28v1.ap-south-1.rds.amazonaws.com:5432/rdep_order";
        String username = "devserver";
        String password = "z5liAKP8cqzNXVFn5jp";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            // Loop through all rows in the result set
            while (resultSet.next()) {
                 String bill_id = resultSet.getString("bill_id"); // Assuming column name is 'first_name'
               

                // Compare the result with expected test case data
                if (bill_id.equals(expected_bill_id) ) {
                	
                	test.pass("Expcted firstname in DB is " + bill_id);
                	
                    return true; // Test case data found in database
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
}}