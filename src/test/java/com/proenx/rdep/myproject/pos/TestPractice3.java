package com.proenx.rdep.myproject.pos;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.proenx.rdep.myproject.TestBase;

import pages.SignInPage;
import utility.DataCollection;

public class TestPractice3 extends TestBase {
	@BeforeClass
	public void getTestCaseName() {
			testCaseName = this.getClass().getSimpleName();
			if(!run_mode.get(testCaseName).equalsIgnoreCase("Y")) {
				throw new SkipException("Skipping Test  case as Run mode is set to no");// this is a user created exception
			}
		}
	
	@Test(dataProvider = "data_Collection")
	public void SalesReportvaliddata(Hashtable<String, String> ht) throws InterruptedException {
		SignInPage sp = new SignInPage();

	sp.signin(ht).clickOnSalesReportSubMenu(ht).Sales_Filter_with_validdata(ht).verify_total_numberof_items_in_sales_table(ht);
	
	
	}
	
	
	

	
	}

