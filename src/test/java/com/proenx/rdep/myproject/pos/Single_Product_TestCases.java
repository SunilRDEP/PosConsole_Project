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

		
		@Test(dataProvider = "data_Collection", enabled = true,priority=1)
		public void single_Product3(Hashtable<String, String> ht) throws InterruptedException, AWTException {
			SignInPage sp = new SignInPage();

		sp.signin(ht)
		.Products_SubMenu(ht)
		.Adding_Single_Product_Validate_catagory_details_with_Debeaver_and_SKU_for_Default_Catalogue(ht);
		
		
		}
		
}
