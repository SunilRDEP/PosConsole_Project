package com.proenx.rdep.customer;

import java.util.Hashtable;
import java.util.concurrent.TimeoutException;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.proenx.rdep.myproject.TestBase;

import pages.SignInPage;
import utility.DataCollection;
import utility.RetryAnalyser;

public class Customer_Screen_Test_Cases extends TestBase{
	 
	@BeforeClass
public void getTestCaseName() {
		testCaseName = this.getClass().getSimpleName(); 
	if(!run_mode.get(testCaseName).equalsIgnoreCase("Y")) {
		throw new SkipException("Skipping Test  case as Run mode is set to no");// this is a user created exception
	} 
	} 
	  
	@Test(dataProvider = "data_Collection" ,enabled = true)
	public void create_promotion(Hashtable<String, String> ht) throws InterruptedException, TimeoutException {
		SignInPage sp = new SignInPage();

	sp.signin(ht) 
	.customer_List_SubMenu(ht)
	.import_Customer_File(ht);
	}
	
	

	

}
