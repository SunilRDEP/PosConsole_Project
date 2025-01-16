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
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.proenx.rdep.myproject.TestBase;

import utility.CommonMethod;

public class CreatePromotion_Page extends TestBase {

	public CreatePromotion_Page() {
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
	private static WebElement Simpleline_coupon_Checkbox;

	@FindBy(xpath = "//input[@placeholder='Enter Qualifier Code']")
	private static WebElement Simpleline_coupon_field;

	@FindBy(xpath = "//input[@id='customStore']")
	private static WebElement Simpleline_Custom_Stores_Check_Box;

	@FindBy(xpath = "//span[@class='multiselect__single']")
	private static WebElement clickonselectstoreoption;

	@FindBy(xpath = "//*[@class=\"multiselect__content-wrapper\"]//ul//span//span")
	private static WebElement clickonparticulastore;

	@FindBy(xpath = "//label[normalize-space()='Target Stores:']")
	private static WebElement clicko_on_outside;

	@FindBy(xpath = "//input[@id='customProduct']")
	private static WebElement Simpleline_Custom_Products_Check_Box;

	@FindBy(xpath = "//button[contains(text(),'Import')]")
	private static WebElement Simpleline_Custom_Products_Import;

	@FindBy(xpath = "//div[@id='customSaleSetModal']//input[@id='fileProduct']")
	private static WebElement Simpleline_Custom_Products_Select_File;

	@FindBy(xpath = "//div[@id='customSaleSetModal']//button[@aria-label='Import']")
	private static WebElement Simpleline_Custom_Products_import;

	@FindBy(xpath = "//button[@aria-label='OK']")
	private static WebElement Simpleline_Custom_Products_import_OK_Button;
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

	@FindBy(xpath = "//h4[@id='offcanvasRightLabel']")
	private static WebElement Products_Filter_Outside;

	@FindBy(xpath = "//span[contains(text(),'Close')]")
	private static WebElement ProductsFilter_Close;
	
	@FindBy(xpath = "//div[@class='px-1 py-2']//div[@class='col-12']//input[@placeholder='Select Date']")
	private static WebElement clickedonstartdatecalenderfield;
	
	@FindBy(xpath = "//div[@class='col-12 mt-2']//input[@placeholder='Select Date']")
	private static WebElement clicked_on_End_date_calender_field;
	
	@FindBy(xpath = "//label[normalize-space()='Start Date']")
	private static WebElement clicko_on_outside_of_Calender;
	
	SoftAssert softassert= new SoftAssert();
//=======================================================================================================================

	public MasterPromotion_Pages create_Simpleline_promo_systembased(Hashtable<String, String> ht)
			throws InterruptedException { 
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
		CommonMethod.entertextintoinputbox(Promotion_Code, ht.get("Promotion Code"));
		CommonMethod.entertextintoinputbox(Promotion_Description, ht.get("Description"));
		CommonMethod.entertextintoinputbox(Promotion_Discount_value, ht.get("Discount Value"));
		WebElement element = driver.findElement(
				By.xpath("//span[@type='button']//span[@class='p-button-label'][normalize-space()='Next']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

		WebElement nextButton = driver
				.findElement(By.xpath("//li[@class='next float-end list-inline-item']//button[@aria-label='Next']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextButton);
		Thread.sleep(3000);
		nextButton.click();
		CommonMethod.clickonWebElement(Promotion_Create_Button, "Create Button");
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(60));
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
		test.pass("TThe Latest Created Promotion details are " + rowdata);
		CommonMethod.clickonWebElement(Products_Filter, "filter of Products Screen");
		Thread.sleep(3000);

		CommonMethod.entertextintoinputbox(Products_Filter_Search_Box,
				ht.get("Promotion Data for Master Promotion FilterSearch"));
		CommonMethod.inputCalenderDate(clickedonstartdatecalenderfield, ht.get("start date in filter"));
		CommonMethod.clickonWebElement(clicko_on_outside_of_Calender, "outside to Overlapping");
		
		CommonMethod.inputCalenderDate(clicked_on_End_date_calender_field, ht.get("end date in filter"));
		CommonMethod.clickonWebElement(clicko_on_outside_of_Calender, " Masterpromotion  Filter Apply Button");
		
		
		CommonMethod.clickonWebElement(Products_Filter_Apply, " Products Filter Apply Button");

		Thread.sleep(3000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//table[@class='bh-table-compact']//tbody/tr")));

		test.pass("@@@@@PLEASE CROSS CHECH BELOW DATA WITH MPOS AND DEBEAVER @@@@" );
		String Promotion_Name = driver.findElement(By.xpath("//tbody//tr[1]//td[1]")).getText();
		String Start_Date = driver.findElement(By.xpath("//tbody//tr[1]//td[2]")).getText();
		String Promo_type = driver.findElement(By.xpath("//tbody//tr[1]//td[4]")).getText();
		String Promo_Code = driver.findElement(By.xpath("//tbody//tr[1]//td[4]")).getText();
	
		test.pass("PLEASE CHECK WHETHER My latest created Promotion Name in DBeaver and Mpos is -->> " + Promotion_Name + " <<-- OR NOT ");
		test.pass("PLEASE CHECK WHETHER My latest created Promotion Start Date in DBeaver and Mpos is  -->> " + Start_Date + " <<--  OR NOT ");
		test.pass("PLEASE CHECK WHETHER My latest created Promotion Type in DBeaver and Mpos is  -->> " +  Promo_type  +  " <<--  OR NOT ");
		test.pass("PLEASE CHECK WHETHER My latest created Promotion Type in DBeaver and Mpos is  -->>" +  Promo_Code  +  " <<--  OR NOT ");
		
		Thread.sleep(3000);
		softassert.assertAll();
		return new MasterPromotion_Pages();
	}
//======================================================================================================================
	
	public CreatePromotion_Page promotion_Details_error_Message_Validation(Hashtable<String, String> ht)
			throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.inputCalenderDate(Promotion_Start_Date, ht.get("Master Promotion Start Date Format"));
		CommonMethod.inputCalenderDate(Promotion_End_Date, ht.get("Master Promotion End Date Format"));
		WebElement promotype = driver.findElement(By.xpath("//select[@placeholder='select']"));
		Select select1 = new Select(promotype);
		// select1.selectByVisibleText(ht.get("Promotion Type1"));
		CommonMethod.entertextintoinputbox(Promotion_Name, ht.get("Promotion Name"));
		WebElement promo_Subtype = driver.findElement(By.xpath("//select[@id='subType']"));
		Select select2 = new Select(promo_Subtype);
		select2.selectByVisibleText(ht.get("Promotion Sub type1"));
		CommonMethod.entertextintoinputbox(Promotion_Code, ht.get("Promotion Code"));
		CommonMethod.entertextintoinputbox(Promotion_Description, ht.get("Description"));
		CommonMethod.entertextintoinputbox(Promotion_Discount_value, ht.get("Discount Value"));
		WebElement element = driver.findElement(
				By.xpath("//span[@type='button']//span[@class='p-button-label'][normalize-space()='Next']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement toastMessage = wait2
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//p[@class='v-toast__text'])[1]")));

		if (toastMessage.isDisplayed()) {
			String Actual_Pagetitle = toastMessage.getText();

			softassert.assertEquals(Actual_Pagetitle, ht.get("Promotion Details Error PopUp"));
			System.out.println("Page title is verified and Title is: " + Actual_Pagetitle);
			test.pass("The Pop-UP error  messge is verified and the Pup-UP Message   is: " + Actual_Pagetitle);
			CommonMethod.takescreenshot();
		} else {
			System.out.println("Toast message is not visible.");
		}
		softassert.assertAll();
		return this;

	}
//======================================================================================================================
	
	public MasterPromotion_Pages clickon_MasterPromotion_Bredcrunch_Create() {
		CommonMethod.clickonWebElement(Master_Promotion_Bredcrunch, "Master Promotion BredCrunch");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));

		
		return new MasterPromotion_Pages();
	}
//=======================================================================================================================
	
	public MasterPromotion_Pages simpleLine_with_coupon_Based_All_Store(Hashtable<String, String> ht)
			throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-w"
				+ "rapper")));
		CommonMethod.inputCalenderDate(Promotion_Start_Date, ht.get("Master Promotion Start Date Format"));
		CommonMethod.inputCalenderDate(Promotion_End_Date, ht.get("Master Promotion End Date Format"));
		WebElement promotype = driver.findElement(By.xpath("//select[@placeholder='select']"));
		Select select1 = new Select(promotype);
		select1.selectByVisibleText(ht.get("Promotion Type1"));
		CommonMethod.entertextintoinputbox(Promotion_Name, ht.get("Promotion Name"));
		WebElement promo_Subtype = driver.findElement(By.xpath("//select[@id='subType']"));
		Select select2 = new Select(promo_Subtype);
		select2.selectByVisibleText(ht.get("Promotion Sub type1"));
		CommonMethod.entertextintoinputbox(Promotion_Code, ht.get("Promotion Code"));
		CommonMethod.entertextintoinputbox(Promotion_Description, ht.get("Description"));
		CommonMethod.entertextintoinputbox(Promotion_Discount_value, ht.get("Discount Value"));
		WebElement element = driver.findElement(
				By.xpath("//span[@type='button']//span[@class='p-button-label'][normalize-space()='Next']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

		WebElement coupon = driver.findElement(By.xpath("//input[@id='coupon']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", coupon);
		Thread.sleep(3000);
		coupon.click();
		CommonMethod.entertextintoinputbox(Simpleline_coupon_field, ht.get("Coupon Field"));
		WebElement nextButton = driver
				.findElement(By.xpath("//li[@class='next float-end list-inline-item']//button[@aria-label='Next']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextButton);
		Thread.sleep(3000);
		nextButton.click();
		CommonMethod.clickonWebElement(Promotion_Create_Button, "Create Button");
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(60));
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
		test.pass("TThe Latest Created Promotion details are " + rowdata);
		CommonMethod.clickonWebElement(Products_Filter, "filter of Products Screen");
		Thread.sleep(3000);

		CommonMethod.entertextintoinputbox(Products_Filter_Search_Box,
				ht.get("Promotion Data for Master Promotion FilterSearch"));
		CommonMethod.inputCalenderDate(clickedonstartdatecalenderfield, ht.get("Master Promotion Start Date Format"));
		CommonMethod.inputCalenderDate(clickedonstartdatecalenderfield, ht.get("start date in filter"));
		CommonMethod.clickonWebElement(clicko_on_outside_of_Calender, "outside to Overlapping");
		
		CommonMethod.inputCalenderDate(clicked_on_End_date_calender_field, ht.get("end date in filter"));
		CommonMethod.clickonWebElement(clicko_on_outside_of_Calender, " Masterpromotion  Filter Apply Button");
		
		
		CommonMethod.clickonWebElement(Products_Filter_Apply, " Products Filter Apply Button");
		Thread.sleep(3000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//table[@class='bh-table-compact']//tbody/tr")));

		test.pass("@@@@@PLEASE CROSS CHECH BELOW DATA WITH MPOS AND DEBEAVER @@@@" );
		String Promotion_Name = driver.findElement(By.xpath("//tbody//tr[1]//td[1]")).getText();
		String Start_Date = driver.findElement(By.xpath("//tbody//tr[1]//td[2]")).getText();
		String Promo_type = driver.findElement(By.xpath("//tbody//tr[1]//td[4]")).getText();
		String Promo_Code = driver.findElement(By.xpath("//tbody//tr[1]//td[4]")).getText();
	
		test.pass("PLEASE CHECK WHETHER My latest created Promotion Name in DBeaver and Mpos is -->> " + Promotion_Name + " <<-- OR NOT ");
		test.pass("PLEASE CHECK WHETHER My latest created Promotion Start Date in DBeaver and Mpos is  -->> " + Start_Date + " <<--  OR NOT ");
		test.pass("PLEASE CHECK WHETHER My latest created Promotion Type in DBeaver and Mpos is  -->> " +  Promo_type  +  " <<--  OR NOT ");
		test.pass("PLEASE CHECK WHETHER My latest created Promotion Type in DBeaver and Mpos is  -->>" +  Promo_Code  +  " <<--  OR NOT ");
		
		Thread.sleep(3000);
		softassert.assertAll();
		return new MasterPromotion_Pages();

	}
//====================================================================================================================

	//Test Case Name= simpleLine_with_coupon_Based_Custom_Store
	
	public MasterPromotion_Pages simpleLine_with_coupon_Based_Custom_Store(Hashtable<String, String> ht)
			throws InterruptedException {

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
		CommonMethod.entertextintoinputbox(Promotion_Code, ht.get("Promotion Code"));
		CommonMethod.entertextintoinputbox(Promotion_Description, ht.get("Description"));
		CommonMethod.entertextintoinputbox(Promotion_Discount_value, ht.get("Discount Value"));
		WebElement element = driver.findElement(
				By.xpath("//span[@type='button']//span[@class='p-button-label'][normalize-space()='Next']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element); 

		WebElement coupon = driver.findElement(By.xpath("//input[@id='coupon']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", coupon);
		Thread.sleep(3000);
		coupon.click();
		CommonMethod.entertextintoinputbox(Simpleline_coupon_field, ht.get("Coupon Field"));
		WebElement nextButton = driver
				.findElement(By.xpath("//li[@class='next float-end list-inline-item']//button[@aria-label='Next']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextButton);
		Thread.sleep(3000);
		nextButton.click();
		CommonMethod.clickonWebElement(Simpleline_Custom_Stores_Check_Box, "Custom Stores Check Box");
		CommonMethod.bootstrapdropdownselection(clickonselectstoreoption, "clickonparticulastore",
				ht.get("StoreName1"));
		CommonMethod.clickonWebElement(clicko_on_outside, "clicked on outside");
		CommonMethod.bootstrapdropdownselection(clickonselectstoreoption, "clickonparticulastore",
				ht.get("StoreName2"));
		CommonMethod.clickonWebElement(clicko_on_outside, "clicked on outside");
		CommonMethod.clickonWebElement(Promotion_Create_Button, "Create Button");
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(60));
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
		test.pass("TThe Latest Created Promotion details are " + rowdata);
		
		test.pass("@@@@@PLEASE CROSS CHECH BELOW DATA WITH MPOS AND DEBEAVER @@@@" );
		
		CommonMethod.clickonWebElement(Products_Filter, "filter of Products Screen");
		Thread.sleep(3000);

		CommonMethod.entertextintoinputbox(Products_Filter_Search_Box,
				ht.get("Promotion Data for Master Promotion FilterSearch"));
		CommonMethod.inputCalenderDate(clickedonstartdatecalenderfield, ht.get("Master Promotion Start Date Format"));
		CommonMethod.clickonWebElement("outsideclick", "Outside to avoid element overlaping");
		
		CommonMethod.clickonWebElement(Products_Filter_Apply, " Products Filter Apply Button");

		Thread.sleep(3000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//table[@class='bh-table-compact']//tbody/tr")));

		String Promotion_Name = driver.findElement(By.xpath("//tbody//tr[1]//td[1]")).getText();
		String Start_Date = driver.findElement(By.xpath("//tbody//tr[1]//td[2]")).getText();
		String Promo_type = driver.findElement(By.xpath("//tbody//tr[1]//td[4]")).getText();
		String Promo_Code = driver.findElement(By.xpath("//tbody//tr[1]//td[4]")).getText();
	
		test.pass("PLEASE CHECK WHETHER My latest created Promotion Name in DBeaver and Mpos is " + Promotion_Name + " OR NOT ");
		test.pass("PLEASE CHECK WHETHER My latest created Promotion Start Date in DBeaver and Mpos is" + Start_Date + " OR NOT ");
		test.pass("PLEASE CHECK WHETHER My latest created Promotion Type in DBeaver and Mpos is  -->> " +  Promo_type  +  " <<--  OR NOT ");
		test.pass("PLEASE CHECK WHETHER My latest created Promotion Type in DBeaver and Mpos is  -->>" +  Promo_Code  +  " <<--  OR NOT ");
		
		Thread.sleep(3000);
		softassert.assertAll();
		return new MasterPromotion_Pages();
	}
//========================================================================================================================
	
	public MasterPromotion_Pages simpleLine_with_coupon_Based_Custom_Store_custom_Product(Hashtable<String, String> ht)
			throws InterruptedException {

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
		CommonMethod.entertextintoinputbox(Promotion_Code, ht.get("Promotion Code"));
		CommonMethod.entertextintoinputbox(Promotion_Description, ht.get("Description"));
		CommonMethod.entertextintoinputbox(Promotion_Discount_value, ht.get("Discount Value"));
		WebElement element = driver.findElement(
				By.xpath("//span[@type='button']//span[@class='p-button-label'][normalize-space()='Next']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

		WebElement coupon = driver.findElement(By.xpath("//input[@id='coupon']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", coupon);
		Thread.sleep(3000);
		coupon.click();
		CommonMethod.entertextintoinputbox(Simpleline_coupon_field, ht.get("Coupon Field"));
		WebElement nextButton = driver
				.findElement(By.xpath("//li[@class='next float-end list-inline-item']//button[@aria-label='Next']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextButton);
		Thread.sleep(3000);
		nextButton.click();
		CommonMethod.clickonWebElement(Simpleline_Custom_Stores_Check_Box, "Custom Stores Check Box");
		CommonMethod.bootstrapdropdownselection(clickonselectstoreoption, "select_store_dropdown_Create_Promotion",
				ht.get("StoreName1"));
		CommonMethod.clickonWebElement(clicko_on_outside, "clicked on outside");
		CommonMethod.bootstrapdropdownselection(clickonselectstoreoption, "select_store_dropdown_Create_Promotion",
				ht.get("StoreName2"));
		CommonMethod.clickonWebElement(clicko_on_outside, "clicked on outside");
		CommonMethod.clickonWebElement(Simpleline_Custom_Products_Check_Box, "Custom Products Check Box");
		driver.findElement(By.xpath("//button[contains(text(),'Import')]")).click();
		// driver.findElement(By.xpath("//div[@id='customSaleSetModal']//input[@id='fileProduct']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='customSaleSetModal']//input[@id='fileProduct']"))
				.sendKeys("C:\\Users\\sunil\\Downloads\\suniltest.csv");
		// CommonMethod.entertextintoinputbox(Simpleline_Custom_Products_Select_File,
		// ht.get("Product file Path"));
		CommonMethod.clickonWebElement(Simpleline_Custom_Products_import, "import ");

		CommonMethod.clickonWebElement(Simpleline_Custom_Products_import_OK_Button, "OK to import the product file  ");
		CommonMethod.clickonWebElement(Promotion_Create_Button, "Create Button");
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
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
		test.pass("TThe Latest Created Promotion details are " + rowdata);
		
		CommonMethod.clickonWebElement(Products_Filter, "filter of Products Screen");
		Thread.sleep(3000);

		CommonMethod.entertextintoinputbox(Products_Filter_Search_Box,
				ht.get("Promotion Data for Master Promotion FilterSearch"));
		CommonMethod.inputCalenderDate(clickedonstartdatecalenderfield, ht.get("Master Promotion Start Date Format"));
		CommonMethod.clickonWebElement("outsideclick", "Outside to avoid element overlaping");
		
		
		CommonMethod.clickonWebElement(Products_Filter_Apply, " Products Filter Apply Button");

		Thread.sleep(3000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//table[@class='bh-table-compact']//tbody/tr")));

		test.pass("@@@@@PLEASE CROSS CHECH BELOW DATA WITH MPOS AND DEBEAVER @@@@" );
		String Promotion_Name = driver.findElement(By.xpath("//tbody//tr[1]//td[1]")).getText();
		String Start_Date = driver.findElement(By.xpath("//tbody//tr[1]//td[2]")).getText();
		String Promo_type = driver.findElement(By.xpath("//tbody//tr[1]//td[4]")).getText();
		String Promo_Code = driver.findElement(By.xpath("//tbody//tr[1]//td[4]")).getText();
	
		test.pass("PLEASE CHECK WHETHER My latest created Promotion Name in DBeaver and Mpos is -->> " + Promotion_Name + " <<-- OR NOT ");
		test.pass("PLEASE CHECK WHETHER My latest created Promotion Start Date in DBeaver and Mpos is  -->> " + Start_Date + " <<--  OR NOT ");
		test.pass("PLEASE CHECK WHETHER My latest created Promotion Type in DBeaver and Mpos is  -->> " +  Promo_type  +  " <<--  OR NOT ");
		test.pass("PLEASE CHECK WHETHER My latest created Promotion Type in DBeaver and Mpos is  -->>" +  Promo_Code  +  " <<--  OR NOT ");
		
		Thread.sleep(3000);
		softassert.assertAll();
		return new MasterPromotion_Pages();
	}


}
