package com.proenx.rdep.promotion.listner;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.proenx.rdep.myproject.TestBase;

import pages.SignInPage;
import utility.DataCollection;

public class Create_Package_Quantity_System_Based extends TestBase{
	
	@BeforeClass
public void getTestCaseName() {
		testCaseName = this.getClass().getSimpleName(); 
	if(!run_mode.get(testCaseName).equalsIgnoreCase("Y")) {
		throw new SkipException("Skipping Test  case as Run mode is set to no");// this is a user created exception
	} 
	} 
	 
	@Test(dataProvider = "data_Collection")
	public void create_promotion(Hashtable<String, String> ht) throws InterruptedException {
		SignInPage sp = new SignInPage();

	sp.signin(ht)
	.MasterPromotion(ht)
	.create_Package_Quantity_Promotion(ht)
	.create_Package_Quantity_promo_systembased(ht)
	.create_Package_Quantity_Promotion(ht)
	.create_Package_Quantity_promo_systembased_All_Store_Custom_Products(ht)
	.create_Package_Quantity_Promotion(ht)
	.create_Package_Quantity_promo_systembased_Custom_Store_Custom_Products(ht)
	.create_Package_Quantity_Promotion(ht)
	.create_Package_Quantity_promo_systembased_Custom_Store(ht);
	
	
	 
	
	}
	
	

}
