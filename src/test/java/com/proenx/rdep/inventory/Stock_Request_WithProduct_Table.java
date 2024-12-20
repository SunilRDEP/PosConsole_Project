package com.proenx.rdep.inventory;

import java.awt.AWTException;
import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.proenx.rdep.myproject.TestBase;

import pages.SignInPage;
import utility.RetryAnalyser;

public class Stock_Request_WithProduct_Table extends TestBase {

	@BeforeClass
	public void getTestCaseName() {
		testCaseName = this.getClass().getSimpleName();
		if (!run_mode.get(testCaseName).equalsIgnoreCase("Y")) {
			throw new SkipException("Skipping Test  case as Run mode is set to no");// this is a user created exception
		}
	}  

	@Test(dataProvider = "data_Collection", enabled = true, priority = 1)
	public void Inventory_List1(Hashtable<String, String> ht) throws InterruptedException, AWTException {
		SignInPage sp = new SignInPage();

		sp.signin(ht)
		.Stock_request_Outward_SubMenu(ht)
		.stock_request_Create_Valid_Outward_using_Product_File(ht);
		
	}
	
	

	

	
}
