package com.proenx.rdep.orderservice;

import java.sql.SQLException;
import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.proenx.rdep.myproject.TestBase;
import com.proenx.rdep.myproject.TestBase_Mobile;


import MposPages.QA_Mpos_Signin_Page;
import pages.SignInPage;
import utility.DataCollection;

public class Article_Report_TestCases extends TestBase_Mobile {
	@BeforeClass
	public void getTestCaseName() {
		testCaseName = this.getClass().getSimpleName();
		if (!run_mode.get(testCaseName).equalsIgnoreCase("Y")) {
			throw new SkipException("Skipping Test  case as Run mode is set to no");// this is a user created exception
		}
	}

	@Test(dataProvider = "data_Collection")
	public void SalesReportvaliddata(Hashtable<String, String> ht) throws InterruptedException, SQLException {
		  test = report.createTest("Login with Wrong Mobile Number");
		
		  QA_Mpos_Signin_Page sp = new QA_Mpos_Signin_Page(driver,test );

		 sp.signinwithwrongdata(ht);
	}

}
