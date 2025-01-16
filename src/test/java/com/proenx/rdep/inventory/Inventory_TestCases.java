package com.proenx.rdep.inventory;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.proenx.rdep.myproject.TestBase;

import pages.SignInPage;
import utility.RetryAnalyser;

public class Inventory_TestCases extends TestBase {

	@BeforeClass
	public void getTestCaseName() {
		testCaseName = this.getClass().getSimpleName();
		if (!run_mode.get(testCaseName).equalsIgnoreCase("Y")) {
			throw new SkipException("Skipping Test  case as Run mode is set to no");// this is a user created exception
		} 
	}  

	@Test(dataProvider = "data_Collection", enabled = false, priority = 1)
	public void Inventory_List1(Hashtable<String, String> ht) throws InterruptedException {
		SignInPage sp = new SignInPage();
sp.signin(ht)
.inventory_List(ht)
.inventoryList_Adjustment_Error_Message_Without_File(ht)
.inventoryList_Adjustment_Error_Message_Without_Store(ht)
.inventoryList_Adjustment_with_InValid_Inputs(ht)
.inventoryList_Adjustment_with_Valid_Inputs(ht);
		
	}
	
	@Test(dataProvider = "data_Collection", enabled = false, priority = 2)
	public void Inventory_List2(Hashtable<String, String> ht) throws InterruptedException {
		SignInPage sp = new SignInPage();
sp.signin(ht)
.inventory_List(ht)

.inventoryList_Import_Update_with_Three_Valid_SKU_(ht)
.inventoryList_Import_Update_with_One_Valid_SKU_(ht)
.inventoryList_Import_Update_with_InValid_Data_(ht)
.inventoryList_Import_Update_ErrorMessage_with_Without_File(ht)
.inventoryList_Import_Update_ErrorMessage_Without_Store(ht);
		
	}
	@Test(dataProvider = "data_Collection", enabled = true, priority = 3)
	public void Inventory_List3(Hashtable<String, String> ht) throws InterruptedException {
		SignInPage sp = new SignInPage();
sp.signin(ht)
.inventory_List(ht)
.inventoryList_Import_File_Reset_with_Three_Valid_SKU_(ht)
.inventoryList_Import_FileReset_ErrorMessage_Without_File(ht)
.inventoryList_Import_FileReset_ErrorMessage_Without_Store(ht)
.inventoryList_Import_FileReset_with_InValid_Data_(ht);

		
	}
}
