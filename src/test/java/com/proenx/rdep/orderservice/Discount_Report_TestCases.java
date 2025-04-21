package com.proenx.rdep.orderservice;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.proenx.rdep.myproject.TestBase;

import pages.SignInPage;
import utility.DataCollection;

public class Discount_Report_TestCases extends TestBase {
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

		sp.signin(ht).clickOnSalesReportSubMenu(ht)
		
		.Sales_Filter_with_validdata(ht)
		.Sales_Report_Download_Conformation_Test(ht)
		.Sales_Report_All_Button(ht)
		.verify_total_numberof_items_in_sales_table(ht)
		.Sales_Report_BillID_Hyperlink(ht);

	}

}
