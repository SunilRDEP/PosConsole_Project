package com.proenx.rdep.mpos;

import java.sql.SQLException;
import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.proenx.rdep.myproject.TestBase;
import com.proenx.rdep.myproject.TestBase_Mobile;

import MposPages.QA_Mpos_Signin_Page;
import MposPages.QA_Mpos_Signin_Page_Existing_APK;
import pages.SignInPage;
import utility.DataCollection;
import utility.RetryAnalyser;

public class MposLoginTest extends TestBase_Mobile{
	 
	@BeforeClass
public void getTestCaseName() {
		testCaseName = this.getClass().getSimpleName(); 
	if(!run_mode.get(testCaseName).equalsIgnoreCase("Y")) {
		throw new SkipException("Skipping Test  case as Run mode is set to no");// this is a user created exception
	} 
	} 
	  
	@Test(dataProvider = "data_Collection" ,enabled = false,retryAnalyzer = RetryAnalyser.class)
	public void create_promotion(Hashtable<String, String> ht) throws InterruptedException, SQLException {
		

		 test = report.createTest("Login with  Mobile Number");
			
		  QA_Mpos_Signin_Page sp = new QA_Mpos_Signin_Page(driver,test );

		 sp.signin_with_APK(ht);
		 Thread.sleep(3000);
	}
	
	  
		@Test(dataProvider = "data_Collection" ,enabled = true,retryAnalyzer = RetryAnalyser.class)
		public void Valid_Transaction(Hashtable<String, String> ht) throws InterruptedException, SQLException {
			

			 test = report.createTest("Login with  Mobile Number");
				
			  QA_Mpos_Signin_Page_Existing_APK sp = new QA_Mpos_Signin_Page_Existing_APK(driver,test );

			 sp.signin_with_Existing_APK(ht);
			 Thread.sleep(3000);
		}
		
	
	

	

}
