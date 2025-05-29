package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.proenx.rdep.myproject.TestBase;

public class DatabaseOTP_Table {
	 public static String  fetchOTPFromDatabase(String phoneNumber) throws SQLException {
		  String otp = "";
		try {
        String dbUrl = "jdbc:postgresql://px-qa-rds.cfksqimc28v1.ap-south-1.rds.amazonaws.com:5432/rdep_auth_dev";
        String username = "devserver";
        String password = "Ljn38UcRyvLNq3A";
        Connection con = DriverManager.getConnection(dbUrl, username, password);
        Statement stmt = con.createStatement();
      
        
        String query = "SELECT otp FROM otp WHERE recipient_number = '" + phoneNumber + "' ORDER BY created_date DESC LIMIT 1";
        ResultSet rs = stmt.executeQuery(query);
        if (rs.next()) {
            otp = rs.getString("otp");
        }
        
        con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return otp;
}}