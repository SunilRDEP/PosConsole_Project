package com.proenx.rdep.inventory;

import java.awt.AWTException;
import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.proenx.rdep.myproject.TestBase;

import pages.SignInPage;
import utility.RetryAnalyser;

public class Stock_Request_Inward extends TestBase {

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
		.Products_SubMenu_for_Other_Feature(ht)
		.SKU_Verification_For_InVentory_Inward_Request_with_File_Upload(ht)
		.Return_to_Dashboard_Page(ht)
		.Stock_request_Inward_SubMenu(ht)
		.stock_request_Create_Valid_Inward_using_Product_File(ht);

	}

	@Test(dataProvider = "data_Collection", enabled = false, priority = 2)
	public void Inventory_List2(Hashtable<String, String> ht) throws InterruptedException, AWTException {
		SignInPage sp = new SignInPage();

		sp.signin(ht)
		.Products_SubMenu_for_Other_Feature(ht)
		.SKU_Verification_For_InVentory_Inward_Request_with_Manual_SKU_Entry(ht)
		.Return_to_Dashboard_Page(ht)
		.Stock_request_Inward_SubMenu(ht)
		.stock_request_Create_Valid_Inward_With_Manual_entry_of_SKU(ht)
		.Return_to_Dashboard_Page(ht)
		.Stock_request_Inward_SubMenu(ht)
		.stock_request_Inward_Error_Message_Validation(ht);

	}
	@Test(dataProvider = "data_Collection", enabled = false, priority = 1)
	public void Stock_Inward(Hashtable<String, String> ht) throws InterruptedException, AWTException {
		SignInPage sp = new SignInPage();

		sp.signin(ht)
		.Stock_request_Inward_SubMenu(ht)
		.stock_request_inward_filter_operation(ht)
		.stock_request_Inward_Cancel_Request(ht);

	}
}
