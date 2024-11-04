package com.proenx.rdep.myproject.pos;

import java.awt.AWTException;
import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.proenx.rdep.myproject.TestBase;

import pages.SignInPage;
import utility.RetryAnalyser;

public class Single_Product_TestCases extends TestBase {
	@BeforeClass
	public void getTestCaseName() {
			testCaseName = this.getClass().getSimpleName();
		if(!run_mode.get(testCaseName).equalsIgnoreCase("Y")) {
			throw new SkipException("Skipping Test  case as Run mode is set to no");// this is a user created exception
		}
		}  
		//===================================================================================================
		@Test(dataProvider = "data_Collection", enabled = false,priority=2)
		public void single_Product1(Hashtable<String, String> ht) throws InterruptedException, AWTException {
			SignInPage sp = new SignInPage();

		sp.signin(ht).Products_SubMenu(ht).add_Single_Product_ErrorMessage_Checking_for_Mandatory_Field2(ht);
		} 
		
		//====================================================================================================
		@Test(dataProvider = "data_Collection", enabled = true,priority=3)
		public void single_Product2(Hashtable<String, String> ht) throws InterruptedException, AWTException {
			SignInPage sp = new SignInPage();

		sp.signin(ht).Products_SubMenu(ht).add_Single_Product_Check_ForMaximum_Character_For_Name_Field(ht);
		}
		//---------------------------------------------------------------------------------------------
		//=============================================================================================
		
		@Test(dataProvider = "data_Collection", enabled = false,priority=4)
		public void single_Product3(Hashtable<String, String> ht) throws InterruptedException, AWTException {
			SignInPage sp = new SignInPage();

		sp.signin(ht).Products_SubMenu(ht).add_Single_Product_with_Valid_Data_Cross_Check_With_DBEAVER(ht);
		}
		//----------------------------------------------------------------------------------------------------------
		//----------------------------------------------------------------------------------------------------------
		@Test(dataProvider = "data_Collection", enabled = false,priority=1) 
		public void single_Product4(Hashtable<String, String> ht) throws InterruptedException, AWTException {
			SignInPage sp = new SignInPage();

		sp.signin(ht).Products_SubMenu(ht).add_Single_Product_with_Valid_Data(ht);
		}
}
