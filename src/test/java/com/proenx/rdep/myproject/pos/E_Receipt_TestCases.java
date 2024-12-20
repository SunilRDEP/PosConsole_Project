package com.proenx.rdep.myproject.pos;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.proenx.rdep.myproject.TestBase;

import pages.SignInPage;

public class E_Receipt_TestCases extends TestBase {
	@BeforeClass
	public void getTestCaseName() {
		testCaseName = this.getClass().getSimpleName();
		if (!run_mode.get(testCaseName).equalsIgnoreCase("Y")) {
			throw new SkipException("Skipping Test  case as Run mode is set to no");// this is a user created exception
		}
	}
		
	@Test(dataProvider = "data_Collection")
	public void SalesReportvaliddata(Hashtable<String, String> ht) throws InterruptedException {
		SignInPage sp = new SignInPage();

	sp.signin(ht)
	.E_Receipt(ht)
	.digital_Receipt_Table_Data_Verification(ht);
	
	
	}
	
}
 