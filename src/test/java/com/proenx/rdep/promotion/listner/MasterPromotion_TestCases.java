package com.proenx.rdep.promotion.listner;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.proenx.rdep.myproject.TestBase;

import pages.SignInPage;
import utility.DataCollection;

public class MasterPromotion_TestCases extends TestBase{
	
	@BeforeClass
public void getTestCaseName() {
		testCaseName = this.getClass().getSimpleName(); 
	if(!run_mode.get(testCaseName).equalsIgnoreCase("Y")) {
		throw new SkipException("Skipping Test  case as Run mode is set to no");// this is a user created exception
	} 
	} 
	 
	
	
	@Test(dataProvider = "data_Collection" ,enabled = true)
	public void create_promotion2(Hashtable<String, String> ht) throws InterruptedException {
		SignInPage sp = new SignInPage();

	sp.signin(ht) 
	.MasterPromotion(ht)
	.edit_Promotion_from_Promotion_Table(ht)
	.filterOperation(ht)
	.clickOnDownload_Filter(ht)
	.MasterPromo_filter_all_button(ht);
	
	 
	}
	
	@Test(dataProvider = "data_Collection" ,enabled = true)
	public void create_promotion(Hashtable<String, String> ht) throws InterruptedException {
		SignInPage sp = new SignInPage();

	sp.signin(ht) 
	.MasterPromotion(ht)
	.edit_Promotion_from_Promotion_Table_with_invalid_File_Format(ht);
	
	 
	}
	
	

}
