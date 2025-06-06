package pages;

import java.time.Duration;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.proenx.rdep.myproject.TestBase;

import utility.CommonMethod;

public class Simple_Total_Reward_Page extends TestBase {
	public Simple_Total_Reward_Page() {
		PageFactory.initElements(driver, this);
	} 
	@FindBy(xpath = "(//input[@name='date'])[1]")
	private static WebElement Promotion_Start_Date;

	@FindBy(xpath = "(//input[@name='date'])[2]")
	private static WebElement Promotion_End_Date;

	@FindBy(xpath = "//select[@placeholder='select']")
	private static WebElement Select_Promotion_Type;

	@FindBy(xpath = "//input[@id='name']")
	private static WebElement Promotion_Name;

	@FindBy(xpath = "//select[@id='subType']")
	private static WebElement Select_Promotion_SubType;

	@FindBy(xpath = "//input[@id='code']")
	private static WebElement Promotion_Code;

	@FindBy(xpath = "//input[@id='description']")
	private static WebElement Promotion_Description;

	@FindBy(xpath = "//input[@id='discount']")
	private static WebElement Promotion_Discount_value;

	@FindBy(xpath = "//li[@class='next float-end']")
	private static WebElement Promotion_Next_Button;

	@FindBy(xpath = "//li[@class='next float-end list-inline-item']")
	private static WebElement Promotion_Next2_Button;

	@FindBy(xpath = "//button[@aria-label='Create']")
	private static WebElement Promotion_Create_Button;

	@FindBy(xpath = "/html/body/div[3]/div/p\r\n" + "")
	private static WebElement Promotion_Successful_Toast_Message;

	@FindBy(xpath = "//tbody/tr[1]")
	private static WebElement Promotion_1strow_Data;

	@FindBy(xpath = "//a[@class='p-menuitem-link']//span[contains(text(),'Master Promotions')]")
	private static WebElement Master_Promotion_Bredcrunch;

	@FindBy(xpath = "//span[contains(text(),'Create')]")
	private static WebElement Master_Promotion_Create;

	@FindBy(xpath = "//input[@id='coupon']")
	private static WebElement Simple_Total_coupon_Checkbox;

	@FindBy(xpath = "//input[@placeholder='Enter Qualifier Code']")
	private static WebElement Simple_Total_coupon_field;

	@FindBy(xpath = "//input[@id='customStore']")
	private static WebElement Simple_Total_Custom_Stores_Check_Box;

	@FindBy(xpath = "//span[@class='multiselect__single']")
	private static WebElement clickonselectstoreoption;

	@FindBy(xpath = "//*[@class=\"multiselect__content-wrapper\"]//ul//span//span")
	private static WebElement clickonparticulastore;

	@FindBy(xpath = "//label[normalize-space()='Target Stores:']")
	private static WebElement clicko_on_outside;

	@FindBy(xpath = "//input[@id='customProduct']")
	private static WebElement Simple_Total_Custom_Products_Check_Box;

	@FindBy(xpath = "//div[@id='customSaleSetModal']//span[@class='p-button-label'][normalize-space()='Import']")
	private static WebElement Simple_Total_Custom_Products_Import;

	@FindBy(xpath = "//div[@id='customSaleSetModal']//input[@id='fileProduct']")
	private static WebElement Simple_Total_Custom_Products_Select_File;

	@FindBy(xpath = "//div[@id='customSaleSetModal']//button[@aria-label='Import']")
	private static WebElement Simple_Total_Custom_Products_import_Button;

	@FindBy(xpath = "//button[@aria-label='OK']")
	private static WebElement Simple_Total_Custom_Products_import_OK_Button;

	@FindBy(xpath = "//button[@aria-label='OK']")
	private static WebElement Simple_Total_Custom_Products_import_Close_Button_Next_to_OK;

	@FindBy(xpath = "//input[@id='triggerAmount']")
	private static WebElement Simple_Total_Trigger_Amount;
	
	@FindBy(xpath = "//input[@id='discountQuantity']")
	private static WebElement Simple_Total_Discount_Quantity;

	@FindBy(xpath = "//input[@id='maxDiscountValue']")
	private static WebElement Simple_Total_Maximum_Discount_Value;

//======================================================================================================================

	@FindBy(xpath = "//span[contains(text(),'Filter')]")
	private static WebElement Products_Filter;

	@FindBy(xpath = "//input[@placeholder='Search']")
	private static WebElement Products_Filter_Search_Box;

	@FindBy(xpath = "//span[contains(text(),'Select Store')]")
	private static WebElement Products_Filter_Select_STore;

	@FindBy(xpath = "//span[contains(text(),'Apply')]")
	private static WebElement Products_Filter_Apply;

	@FindBy(xpath = "//span[@class='p-button-icon p-button-icon-left ri-restart-line ri-xl me-1']")
	private static WebElement Products_Filter_Reset;

	@FindBy(xpath = "//label[normalize-space()='Start Date']")
	private static WebElement Simple_Ttal_reward_Filter_Outside;

	@FindBy(xpath = "//span[contains(text(),'Close')]")
	private static WebElement ProductsFilter_Close;

	@FindBy(xpath = "//div[@class='px-1 py-2']//div[@class='col-12']//input[@placeholder='Select Date']")
	private static WebElement clickedonstartdatecalenderfield;

	@FindBy(xpath = "//div[@class='col-12 mt-2']//input[@placeholder='Select Date']")
	private static WebElement clicked_on_End_date_calender_field;

	@FindBy(xpath = "//input[@id='customStore']")
	private static WebElement SimpleTotal_Custom_Stores_Check_Box;
	
	
	SoftAssert softassert = new SoftAssert();

	
	public MasterPromotion_Pages Simple_Total_SystemBased_Promotion_With_All_Store_All_Product(
			Hashtable<String, String> ht) throws InterruptedException {
		test.pass("TC- is loading");
		test.info(ht.get("Test Case Description"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.inputCalenderDate(Promotion_Start_Date, ht.get("Master Promotion Start Date Format"));
		CommonMethod.inputCalenderDate(Promotion_End_Date, ht.get("Master Promotion End Date Format"));
		WebElement promotype = driver.findElement(By.xpath("//select[@placeholder='select']"));
		Select select1 = new Select(promotype);
		select1.selectByVisibleText(ht.get("Promotion Type1"));
		CommonMethod.entertextintoinputbox(Promotion_Name, ht.get("Promotion Name"));
		WebElement promo_Subtype = driver.findElement(By.xpath("//select[@id='subType']"));
		Select select2 = new Select(promo_Subtype);
		select2.selectByVisibleText(ht.get("Promotion Sub type1"));
		CommonMethod.entertextintoinputbox(Promotion_Code, ht.get("Promo Code for all store and all product"));
		CommonMethod.entertextintoinputbox(Promotion_Description, ht.get("Description"));
		CommonMethod.entertextintoinputbox(Promotion_Discount_value, ht.get("Discount Value"));
		WebElement element = driver.findElement(
				By.xpath("//span[@type='button']//span[@class='p-button-label'][normalize-space()='Next']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

		CommonMethod.entertextintoinputbox(Simple_Total_Discount_Quantity, ht.get("Simple_Total_Reward_Discount_Quantity"));
		CommonMethod.entertextintoinputbox(Simple_Total_Trigger_Amount, ht.get("Simple_Total_Trigger_Amount"));
		WebElement nextButton = driver
				.findElement(By.xpath("//li[@class='next float-end list-inline-item']//button[@aria-label='Next']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextButton);
		Thread.sleep(3000);
		nextButton.click();
		CommonMethod.clickonWebElement(Promotion_Create_Button, "Create Button");
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(90));
		WebElement toastMessage = wait2
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div/p")));

		if (toastMessage.isDisplayed()) {
			String Actual_Pagetitle = toastMessage.getText();

			softassert.assertEquals(Actual_Pagetitle, ht.get("Promotion successful Message"));
			System.out.println("Page title is verified and Title is: " + Actual_Pagetitle);
			test.pass("The Pop-UP successful messge is verified and the Pup-UP Message   is: " + Actual_Pagetitle);
			CommonMethod.takescreenshot();
		} else {
			System.out.println("Toast message is not visible.");
		}
		Thread.sleep(3000);
		String rowdata = driver.findElement(By.xpath("//tbody/tr[1]")).getText();
		test.pass("The Latest Created Promotion details are " + rowdata);
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.clickonWebElement(Products_Filter, "filter of Products Screen");
		Thread.sleep(3000);

		CommonMethod.entertextintoinputbox(Products_Filter_Search_Box,
				ht.get("Promo code  for all store and all product type to Search  in Master Promotion Filter"));
		CommonMethod.inputCalenderDate(clickedonstartdatecalenderfield, ht.get("Start Date Format inside Filter"));
		
		CommonMethod.clickonWebElement(Simple_Ttal_reward_Filter_Outside, " Outside to avoide overlapping of element ");
		CommonMethod.clickonWebElement(Products_Filter_Apply, " Products Filter Apply Button");
		
		Thread.sleep(3000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//table[@class='bh-table-compact']//tbody/tr")));

		test.pass("@@@@@PLEASE CROSS CHECH BELOW DATA WITH MPOS AND DEBEAVER @@@@");
		String Promotion_Name = driver.findElement(By.xpath("//tbody//tr[1]//td[1]")).getText();
		String Start_Date = driver.findElement(By.xpath("//tbody//tr[1]//td[2]")).getText();
		String Promo_type = driver.findElement(By.xpath("//tbody//tr[1]//td[4]")).getText();
		String Promo_Code = driver.findElement(By.xpath("//tbody//tr[1]//td[9]")).getText();

		test.pass("PLEASE CHECK WHETHER My latest created Promotion Name in DBeaver and Mpos is -->> " + Promotion_Name
				+ " <<-- OR NOT ");
		test.pass("PLEASE CHECK WHETHER My latest created Promotion Start Date in DBeaver and Mpos is  -->> "
				+ Start_Date + " <<--  OR NOT ");
		test.pass("PLEASE CHECK WHETHER My latest created Promotion Type in DBeaver and Mpos is  -->> " + Promo_type
				+ " <<--  OR NOT ");
		test.pass("PLEASE CHECK WHETHER My latest created Promotion code in DBeaver and Mpos is  -->>" + Promo_Code
				+ " <<--  OR NOT ");

		Thread.sleep(3000);
		softassert.assertAll();

		return new MasterPromotion_Pages();

	}
	
	
	public MasterPromotion_Pages Simple_Total_Reward_System_Based_Promotion_With_Custom_Store_All_Product(
			Hashtable<String, String> ht) throws InterruptedException {
		test.pass("TC- is loading");
		test.info(ht.get("Test Case Description for custom store"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.inputCalenderDate(Promotion_Start_Date, ht.get("Master Promotion Start Date Format"));
		CommonMethod.inputCalenderDate(Promotion_End_Date, ht.get("Master Promotion End Date Format"));
		WebElement promotype = driver.findElement(By.xpath("//select[@placeholder='select']"));
		Select select1 = new Select(promotype);
		select1.selectByVisibleText(ht.get("Promotion Type1"));
		CommonMethod.entertextintoinputbox(Promotion_Name, ht.get("Promotion Name"));
		WebElement promo_Subtype = driver.findElement(By.xpath("//select[@id='subType']"));
		Select select2 = new Select(promo_Subtype);
		select2.selectByVisibleText(ht.get("Promotion Sub type1"));
		CommonMethod.entertextintoinputbox(Promotion_Code, ht.get("Promo Code for custom store and all product"));
		CommonMethod.entertextintoinputbox(Promotion_Description, ht.get("Description"));
		CommonMethod.entertextintoinputbox(Promotion_Discount_value, ht.get("Discount Value"));
		WebElement element = driver.findElement(
				By.xpath("//span[@type='button']//span[@class='p-button-label'][normalize-space()='Next']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

		
		CommonMethod.entertextintoinputbox(Simple_Total_Discount_Quantity, ht.get("Simple_Total_Reward_Discount_Quantity"));
		CommonMethod.entertextintoinputbox(Simple_Total_Trigger_Amount, ht.get("Simple_Total_Trigger_Amount"));
		WebElement nextButton = driver
				.findElement(By.xpath("//li[@class='next float-end list-inline-item']//button[@aria-label='Next']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextButton);
		Thread.sleep(3000);
		nextButton.click();
		CommonMethod.clickonWebElement(SimpleTotal_Custom_Stores_Check_Box, "Custom Stores Check Box");
		CommonMethod.bootstrapdropdownselection(clickonselectstoreoption, "clickonparticulastore",
				ht.get("StoreName1"));
		CommonMethod.clickonWebElement(clicko_on_outside, "clicked on outside");
		CommonMethod.bootstrapdropdownselection(clickonselectstoreoption, "clickonparticulastore",
				ht.get("StoreName2"));
		CommonMethod.clickonWebElement(clicko_on_outside, "clicked on outside");

		CommonMethod.clickonWebElement(Promotion_Create_Button, "Create Button");
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(90));
		WebElement toastMessage = wait2
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div/p")));

		if (toastMessage.isDisplayed()) {
			String Actual_Pagetitle = toastMessage.getText();

			softassert.assertEquals(Actual_Pagetitle, ht.get("Promotion successful Message"));
			System.out.println("Page title is verified and Title is: " + Actual_Pagetitle);
			test.pass("The Pop-UP successful messge is verified and the Pup-UP Message   is: " + Actual_Pagetitle);
			CommonMethod.takescreenshot();
		} else {
			System.out.println("Toast message is not visible.");
		}
		Thread.sleep(3000);
		String rowdata = driver.findElement(By.xpath("//tbody/tr[1]")).getText();
		test.pass("The Latest Created Promotion details are " + rowdata);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Products_Filter);
		CommonMethod.clickonWebElement(Products_Filter, "filter of promotion Screen");
		Thread.sleep(3000);

		CommonMethod.entertextintoinputbox(Products_Filter_Search_Box,
				ht.get("Promo code  for custom store and all product type to Search  in Master Promotion Filter"));
		CommonMethod.inputCalenderDate(clickedonstartdatecalenderfield, ht.get("start date in filter"));
		CommonMethod.clickonWebElement("outsideclick", "Outside to avoid element overlaping");
		CommonMethod.inputCalenderDate(clicked_on_End_date_calender_field, ht.get("end date in filter"));
		
		CommonMethod.clickonWebElement("outsideclick", "Outside to avoid element overlaping");

		CommonMethod.clickonWebElement(Products_Filter_Apply, " Products Filter Apply Button");

		Thread.sleep(3000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//table[@class='bh-table-compact']//tbody/tr")));

		test.pass("@@@@@PLEASE CROSS CHECH BELOW DATA WITH MPOS AND DEBEAVER @@@@");
		String Promotion_Name = driver.findElement(By.xpath("//tbody//tr[1]//td[1]")).getText();
		String Start_Date = driver.findElement(By.xpath("//tbody//tr[1]//td[2]")).getText();
		String Promo_type = driver.findElement(By.xpath("//tbody//tr[1]//td[4]")).getText();
		String Promo_Code = driver.findElement(By.xpath("//tbody//tr[1]//td[9]")).getText();

		test.pass("PLEASE CHECK WHETHER My latest created Promotion Name in DBeaver and Mpos is -->> " + Promotion_Name
				+ " <<-- OR NOT ");
		test.pass("PLEASE CHECK WHETHER My latest created Promotion Start Date in DBeaver and Mpos is  -->> "
				+ Start_Date + " <<--  OR NOT ");
		test.pass("PLEASE CHECK WHETHER My latest created Promotion Type in DBeaver and Mpos is  -->> " + Promo_type
				+ " <<--  OR NOT ");
		test.pass("PLEASE CHECK WHETHER My latest created Promotion Code in DBeaver and Mpos is  -->>" + Promo_Code
				+ " <<--  OR NOT ");

		Thread.sleep(3000);
		softassert.assertAll();

		return new MasterPromotion_Pages();

	}

	

}
