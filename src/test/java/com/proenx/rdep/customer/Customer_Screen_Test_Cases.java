package com.proenx.rdep.customer;

import java.io.IOException;
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
	  
	@Test(dataProvider = "data_Collection" ,enabled = false,retryAnalyzer = RetryAnalyser.class)
	public void Customer_Screen(Hashtable<String, String> ht) throws InterruptedException, TimeoutException {
		SignInPage sp = new SignInPage();

	sp.signin(ht) 
	.customer_List_SubMenu(ht)
	.Global_SerchKey_with_filter_download(ht)
	.import_Customer_File(ht);
	 
	}
	
	@Test(dataProvider = "data_Collection" ,enabled = true,retryAnalyzer = RetryAnalyser.class)
	public void Customer_Screen2(Hashtable<String, String> ht) throws InterruptedException, TimeoutException, IOException {
		SignInPage sp = new SignInPage();

	sp.signin(ht) 
	.customer_List_SubMenu(ht)
	.pos_consolle_all_api_response_check(ht);
	 
	}
	
	

	

}
