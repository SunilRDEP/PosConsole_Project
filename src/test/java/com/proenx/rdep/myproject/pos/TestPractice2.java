package com.proenx.rdep.myproject.pos;

import java.util.Hashtable;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.proenx.rdep.myproject.TestBase;

import pages.SignInPage;
import utility.DataCollection;

public class TestPractice2 extends TestBase {
	
	@Test(dataProvider = "data_Collection")
	public void SalesReportvaliddata(Hashtable<String, String> ht) throws InterruptedException {
		SignInPage sp = new SignInPage();

	sp.signin(ht).clickOnSalesReportSubMenu(ht).Sales_Filter_with_validdata(ht).verify_total_numberof_items_in_sales_table(ht);
	
	
	}
	
	@DataProvider
	public Object[][] data_Collection() {
		DataCollection dc = new DataCollection(excel, "Test Sunil", "TestPractice2");
		return dc.dataArray();
	}

	
	}

