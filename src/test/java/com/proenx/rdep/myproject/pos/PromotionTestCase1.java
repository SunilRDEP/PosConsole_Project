package com.proenx.rdep.myproject.pos;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.proenx.rdep.myproject.TestBase;

import pages.SignInPage;
import utility.DataCollection;
import utility.RetryAnalyser;

public class PromotionTestCase1 extends TestBase{
	
	@BeforeClass
public void getTestCaseName() {
		testCaseName = this.getClass().getSimpleName();
	if(!run_mode.get(testCaseName).equalsIgnoreCase("Y")) {
		throw new SkipException("Skipping Test  case as Run mode is set to no");// this is a user created exception
	}
	} 
	  
	
	
	@Test(dataProvider = "data_Collection",retryAnalyzer=RetryAnalyser.class)
	public void promotionTC1(Hashtable<String, String> ht) throws InterruptedException {
		SignInPage sp = new SignInPage();

	sp.signin(ht).MasterPromotion(ht).create_Promotion(ht).create_Simpleline_promo_systembased(ht);
	
	}
	
//	@DataProvider
//	public Object[][] data_Collection() {
//		DataCollection dc = new DataCollection(excel, "Test Sunil", "PromotionTest1");
//		return dc.dataArray();
//	}


}
