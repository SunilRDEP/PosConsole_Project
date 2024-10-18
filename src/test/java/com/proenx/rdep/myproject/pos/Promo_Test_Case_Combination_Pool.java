package com.proenx.rdep.myproject.pos;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.proenx.rdep.myproject.TestBase;

import pages.SignInPage;

public class Promo_Test_Case_Combination_Pool  extends TestBase{
	
	@BeforeClass
public void getTestCaseName() {
		testCaseName = this.getClass().getSimpleName();
	if(!run_mode.get(testCaseName).equalsIgnoreCase("Y")) {
		throw new SkipException("Skipping Test  case as Run mode is set to no");// this is a user created exception
	}
	} 

	@Test(dataProvider = "data_Collection",invocationCount = 1)
	public void create_promotion(Hashtable<String, String> ht) throws InterruptedException {
		SignInPage sp = new SignInPage();

	sp.signin(ht).MasterPromotion(ht).create_Combination_Pool_Promotion(ht).create_CombinationPool_promo_couponbased_Custom_Store(ht);
	}
	}
