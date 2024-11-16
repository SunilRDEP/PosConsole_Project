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

public class Package_Quantity_Page extends TestBase {

	public Package_Quantity_Page() {
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
	private static WebElement Package_Quantity_coupon_field;

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
	
	@FindBy(xpath = "//div[@class='input-grid']//input[@id='triggerQuantity']")
	private static WebElement Qualified_Quantity_Trigger_Quantity;
//======================================================================================================================
	
	SoftAssert softassert=new SoftAssert();
	
	public MasterPromotion_Pages create_Package_Quantity_promo_systembased(Hashtable<String, String> ht)
			throws InterruptedException {
		test.pass("TC-038 is loading");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.inputCalenderDate(Promotion_Start_Date, ht.get("Package Quantity Start Date Format"));
		CommonMethod.inputCalenderDate(Promotion_End_Date, ht.get("Package Quantity End Date Format"));
		WebElement promotype = driver.findElement(By.xpath("//select[@placeholder='select']"));
		Select select1 = new Select(promotype);
		select1.selectByVisibleText(ht.get("Package Quantity Type1")); 
		CommonMethod.entertextintoinputbox(Promotion_Name, ht.get("Package Quantity Promotion Name"));
		WebElement promo_Subtype = driver.findElement(By.xpath("//select[@id='subType']"));
		Select select2 = new Select(promo_Subtype);
		select2.selectByVisibleText(ht.get("Package Quantity Promotion Sub type1"));
		CommonMethod.entertextintoinputbox(Promotion_Code, ht.get("Package Quantity Promotion Code"));
		CommonMethod.entertextintoinputbox(Promotion_Description, ht.get("Package Quantity Description"));
		CommonMethod.entertextintoinputbox(Promotion_Discount_value, ht.get("Package Quantity Discount Value"));
		WebElement element = driver.findElement(
				By.xpath("//span[@type='button']//span[@class='p-button-label'][normalize-space()='Next']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

		CommonMethod.entertextintoinputbox(Qualified_Quantity_Trigger_Quantity, ht.get("Package Quatity Trigger Quantiy"));
		//CommonMethod.clickonWebElement(Qualified_Quantity_Trigger_Quantity, "Trigger Quantity");
//		WebElement coupon = driver.findElement(By.xpath("//input[@id='coupon']"));
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", coupon);
		Thread.sleep(3000);
		WebElement nextButton = driver
				.findElement(By.xpath("//li[@class='next float-end list-inline-item']//button[@aria-label='Next']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextButton);
		Thread.sleep(3000);
		nextButton.click();

		
		CommonMethod.clickonWebElement(Promotion_Create_Button, "Create Button");
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement toastMessage = wait2
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div/p")));

		if (toastMessage.isDisplayed()) {
			String Actual_Pagetitle = toastMessage.getText();

			softassert.assertEquals(Actual_Pagetitle, ht.get("Package Quantity  Promotion successful Message"));
			System.out.println("Page title is verified and Title is: " + Actual_Pagetitle);
			test.pass("The Pop-UP successful messge is verified and the Pup-UP Message   is: " + Actual_Pagetitle);
			CommonMethod.takescreenshot();
		} else {
			System.out.println("Toast message is not visible.");
		}
		Thread.sleep(3000);
		String rowdata = driver.findElement(By.xpath("//tbody/tr[1]")).getText();
		test.pass("The Latest Created Promotion details are " + rowdata);
		softassert.assertAll();
		return new MasterPromotion_Pages();
	}
//==================================================================================================================
	
	public MasterPromotion_Pages create_Package_Quantity_promo_couponbased(Hashtable<String, String> ht)
			throws InterruptedException {
		test.pass("TC-041 is loading");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.inputCalenderDate(Promotion_Start_Date, ht.get("Package Quantity Start Date Format"));
		CommonMethod.inputCalenderDate(Promotion_End_Date, ht.get("Package Quantity End Date Format"));
		WebElement promotype = driver.findElement(By.xpath("//select[@placeholder='select']"));
		Select select1 = new Select(promotype);
		select1.selectByVisibleText(ht.get("Package Quantity Type1"));
		CommonMethod.entertextintoinputbox(Promotion_Name, ht.get("Package Quantity Promotion Name"));
		WebElement promo_Subtype = driver.findElement(By.xpath("//select[@id='subType']"));
		Select select2 = new Select(promo_Subtype);
		select2.selectByVisibleText(ht.get("Package Quantity Promotion Sub type1"));
		CommonMethod.entertextintoinputbox(Promotion_Code, ht.get("Package Quantity Promotion Code"));
		CommonMethod.entertextintoinputbox(Promotion_Description, ht.get("Package Quantity Description"));
		CommonMethod.entertextintoinputbox(Promotion_Discount_value, ht.get("Package Quantity Discount Value"));
		WebElement element = driver.findElement(
				By.xpath("//span[@type='button']//span[@class='p-button-label'][normalize-space()='Next']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		CommonMethod.entertextintoinputbox(Qualified_Quantity_Trigger_Quantity, ht.get("Package Quatity Trigger Quantiy"));
		WebElement coupon = driver.findElement(By.xpath("//input[@id='coupon']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", coupon);
		Thread.sleep(3000);
		coupon.click();
		CommonMethod.entertextintoinputbox(Package_Quantity_coupon_field, ht.get("Package Quantity Pool Coupon Field"));
		CommonMethod.takescreenshot();
		//CommonMethod.clickonWebElement(Qualified_Quantity_Trigger_Quantity, "Trigger Quantity");
//		WebElement coupon = driver.findElement(By.xpath("//input[@id='coupon']"));
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", coupon);
		Thread.sleep(3000);
		WebElement nextButton = driver
				.findElement(By.xpath("//li[@class='next float-end list-inline-item']//button[@aria-label='Next']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextButton);
		Thread.sleep(3000);
		nextButton.click();

		
		CommonMethod.clickonWebElement(Promotion_Create_Button, "Create Button");
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement toastMessage = wait2
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div/p")));

		if (toastMessage.isDisplayed()) {
			String Actual_Pagetitle = toastMessage.getText();

			softassert.assertEquals(Actual_Pagetitle, ht.get("Package Quantity  Promotion successful Message"));
			System.out.println("Page title is verified and Title is: " + Actual_Pagetitle);
			test.pass("The Pop-UP successful messge is verified and the Pup-UP Message   is: " + Actual_Pagetitle);
			CommonMethod.takescreenshot();
		} else {
			System.out.println("Toast message is not visible.");
		}
		Thread.sleep(3000);
		String rowdata = driver.findElement(By.xpath("//tbody/tr[1]")).getText();
		test.pass("The Latest Created Promotion details are " + rowdata);
		test.pass("Coupon based Package Quantity Promotion Created successfully  " );
		softassert.assertAll();
		return new MasterPromotion_Pages();
	}
//========================================================================================================================
	
	public MasterPromotion_Pages create_Package_Quantity_promo_systembased_Custom_Store(Hashtable<String, String> ht)
			throws InterruptedException {
		test.pass("TC-044 is loading");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.inputCalenderDate(Promotion_Start_Date, ht.get("Package Quantity Start Date Format"));
		CommonMethod.inputCalenderDate(Promotion_End_Date, ht.get("Package Quantity End Date Format"));
		WebElement promotype = driver.findElement(By.xpath("//select[@placeholder='select']"));
		Select select1 = new Select(promotype);
		select1.selectByVisibleText(ht.get("Package Quantity Type1"));
		CommonMethod.entertextintoinputbox(Promotion_Name, ht.get("Package Quantity Promotion Name"));
		WebElement promo_Subtype = driver.findElement(By.xpath("//select[@id='subType']"));
		Select select2 = new Select(promo_Subtype);
		select2.selectByVisibleText(ht.get("Package Quantity Promotion Sub type1"));
		CommonMethod.entertextintoinputbox(Promotion_Code, ht.get("Package Quantity Promotion Code"));
		CommonMethod.entertextintoinputbox(Promotion_Description, ht.get("Package Quantity Description"));
		CommonMethod.entertextintoinputbox(Promotion_Discount_value, ht.get("Package Quantity Discount Value"));
		WebElement element = driver.findElement(
				By.xpath("//span[@type='button']//span[@class='p-button-label'][normalize-space()='Next']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		
		// Now try clicking the element
	
		
		CommonMethod.entertextintoinputbox(Qualified_Quantity_Trigger_Quantity, ht.get("Package Quatity Trigger Quantiy"));
		//CommonMethod.clickonWebElement(Qualified_Quantity_Trigger_Quantity, "Trigger Quantity");
//		WebElement coupon = driver.findElement(By.xpath("//input[@id='coupon']"));
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", coupon);
		Thread.sleep(3000);
		WebElement nextButton = driver
				.findElement(By.xpath("//li[@class='next float-end list-inline-item']//button[@aria-label='Next']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextButton);
		Thread.sleep(3000);
		nextButton.click();
		CommonMethod.clickonWebElement(Simpleline_Custom_Stores_Check_Box, "Custom Stores Check Box");
		CommonMethod.bootstrapdropdownselection(clickonselectstoreoption, "clickonparticulastore",
				ht.get("Package Quantity StoreName1"));
		CommonMethod.clickonWebElement(clicko_on_outside, "clicked on outside");
		CommonMethod.bootstrapdropdownselection(clickonselectstoreoption, "clickonparticulastore",
				ht.get("Package Quantity StoreName2"));
		CommonMethod.clickonWebElement(clicko_on_outside, "clicked on outside");
		
		CommonMethod.clickonWebElement(Promotion_Create_Button, "Create Button");
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement toastMessage = wait2
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div/p")));

		if (toastMessage.isDisplayed()) {
			String Actual_Pagetitle = toastMessage.getText();

			softassert.assertEquals(Actual_Pagetitle, ht.get("Package Quantity  Promotion successful Message"));
			System.out.println("Page title is verified and Title is: " + Actual_Pagetitle);
			test.pass("The Pop-UP successful messge is verified and the Pup-UP Message   is: " + Actual_Pagetitle);
			CommonMethod.takescreenshot();
		} else {
			System.out.println("Toast message is not visible.");
		}
		Thread.sleep(3000);
		String rowdata = driver.findElement(By.xpath("//tbody/tr[1]")).getText();
		test.pass("The Latest Created Promotion details are " + rowdata);
		softassert.assertAll();
		return new MasterPromotion_Pages();
	}
//====================================================================================================================
	
	public MasterPromotion_Pages create_Package_Quantity_promo_systembased_Custom_Store_Custom_Products(Hashtable<String, String> ht)
			throws InterruptedException { 
		test.pass("TC-040 is loading ");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.inputCalenderDate(Promotion_Start_Date, ht.get("Package Quantity Start Date Format"));
		CommonMethod.inputCalenderDate(Promotion_End_Date, ht.get("Package Quantity End Date Format"));
		WebElement promotype = driver.findElement(By.xpath("//select[@placeholder='select']"));
		Select select1 = new Select(promotype);
		select1.selectByVisibleText(ht.get("Package Quantity Type1"));
		CommonMethod.entertextintoinputbox(Promotion_Name, ht.get("Package Quantity Promotion Name"));
		WebElement promo_Subtype = driver.findElement(By.xpath("//select[@id='subType']"));
		Select select2 = new Select(promo_Subtype);
		select2.selectByVisibleText(ht.get("Package Quantity Promotion Sub type1"));
		CommonMethod.entertextintoinputbox(Promotion_Code, ht.get("Package Quantity Promotion Code"));
		CommonMethod.entertextintoinputbox(Promotion_Description, ht.get("Package Quantity Description"));
		CommonMethod.entertextintoinputbox(Promotion_Discount_value, ht.get("Package Quantity Discount Value"));
		
		WebElement element = driver.findElement(
				By.xpath("//span[@type='button']//span[@class='p-button-label'][normalize-space()='Next']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		
		CommonMethod.entertextintoinputbox(Qualified_Quantity_Trigger_Quantity, ht.get("Package Quatity Trigger Quantiy"));
		//CommonMethod.clickonWebElement(Qualified_Quantity_Trigger_Quantity, "Trigger Quantity");
//		WebElement coupon = driver.findElement(By.xpath("//input[@id='coupon']"));
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", coupon);
		Thread.sleep(3000);
		WebElement nextButton = driver
				.findElement(By.xpath("//li[@class='next float-end list-inline-item']//button[@aria-label='Next']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextButton);
		Thread.sleep(3000);
		nextButton.click();
		CommonMethod.clickonWebElement(Simpleline_Custom_Stores_Check_Box, "Custom Stores Check Box");
		CommonMethod.bootstrapdropdownselection(clickonselectstoreoption, "clickonparticulastore",
				ht.get("Package Quantity StoreName1"));
		CommonMethod.clickonWebElement(clicko_on_outside, "clicked on outside");
		CommonMethod.bootstrapdropdownselection(clickonselectstoreoption, "clickonparticulastore",
				ht.get("Package Quantity StoreName2"));
		CommonMethod.clickonWebElement(clicko_on_outside, "clicked on outside");
		
		
		CommonMethod.clickonWebElement(Simpleline_Custom_Products_Check_Box, "Custom Products Check Box");
		driver.findElement(By.xpath("//button[contains(text(),'Import')]")).click();
		// driver.findElement(By.xpath("//div[@id='customSaleSetModal']//input[@id='fileProduct']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='customSaleSetModal']//input[@id='fileProduct']"))
				.sendKeys("C:\\Users\\sunil\\Test File Format\\Package_Quantity_System_Based_Product_File.csv");
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

			softassert.assertEquals(Actual_Pagetitle, ht.get("Package Quantity  Promotion successful Message"));
			System.out.println("Page title is verified and Title is: " + Actual_Pagetitle);
			test.pass("The Pop-UP successful messge is verified and the Pup-UP Message   is: " + Actual_Pagetitle);
			CommonMethod.takescreenshot();
		} else {
			System.out.println("Toast message is not visible.");
		}
		Thread.sleep(3000);
		String rowdata = driver.findElement(By.xpath("//tbody/tr[1]")).getText();
		test.pass("The Latest Created Promotion details are " + rowdata);
		softassert.assertAll();
		return new MasterPromotion_Pages();
	}
//=======================================================================================================================
	
	public MasterPromotion_Pages create_Package_Quantity_promo_systembased_All_Store_Custom_Products(Hashtable<String, String> ht)
			throws InterruptedException {
		test.pass("TC-039 is loading ");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.inputCalenderDate(Promotion_Start_Date, ht.get("Package Quantity Start Date Format"));
		CommonMethod.inputCalenderDate(Promotion_End_Date, ht.get("Package Quantity End Date Format"));
		WebElement promotype = driver.findElement(By.xpath("//select[@placeholder='select']"));
		Select select1 = new Select(promotype);
		select1.selectByVisibleText(ht.get("Package Quantity Type1"));
		CommonMethod.entertextintoinputbox(Promotion_Name, ht.get("Package Quantity Promotion Name"));
		WebElement promo_Subtype = driver.findElement(By.xpath("//select[@id='subType']"));
		Select select2 = new Select(promo_Subtype);
		select2.selectByVisibleText(ht.get("Package Quantity Promotion Sub type1"));
		CommonMethod.entertextintoinputbox(Promotion_Code, ht.get("Package Quantity Promotion Code"));
		CommonMethod.entertextintoinputbox(Promotion_Description, ht.get("Package Quantity Description"));
		CommonMethod.entertextintoinputbox(Promotion_Discount_value, ht.get("Package Quantity Discount Value"));
		WebElement element = driver.findElement(
				By.xpath("//span[@type='button']//span[@class='p-button-label'][normalize-space()='Next']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		
		CommonMethod.entertextintoinputbox(Qualified_Quantity_Trigger_Quantity, ht.get("Package Quatity Trigger Quantiy"));
		//CommonMethod.clickonWebElement(Qualified_Quantity_Trigger_Quantity, "Trigger Quantity");
//		WebElement coupon = driver.findElement(By.xpath("//input[@id='coupon']"));
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", coupon);
		Thread.sleep(3000);
		WebElement nextButton = driver
				.findElement(By.xpath("//li[@class='next float-end list-inline-item']//button[@aria-label='Next']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextButton);
		Thread.sleep(3000);
		nextButton.click();
		
		
		CommonMethod.clickonWebElement(Simpleline_Custom_Products_Check_Box, "Custom Products Check Box");
		driver.findElement(By.xpath("//button[contains(text(),'Import')]")).click();
		// driver.findElement(By.xpath("//div[@id='customSaleSetModal']//input[@id='fileProduct']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='customSaleSetModal']//input[@id='fileProduct']"))
				.sendKeys("C:\\Users\\sunil\\Test File Format\\Package_Quantity_System_Based_Product_File.csv");
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

			softassert.assertEquals(Actual_Pagetitle, ht.get("Package Quantity  Promotion successful Message"));
			System.out.println("Page title is verified and Title is: " + Actual_Pagetitle);
			test.pass("The Pop-UP successful messge is verified and the Pup-UP Message   is: " + Actual_Pagetitle);
			CommonMethod.takescreenshot();
		} else {
			System.out.println("Toast message is not visible.");
		}
		Thread.sleep(3000);
		String rowdata = driver.findElement(By.xpath("//tbody/tr[1]")).getText();
		test.pass("The Latest Created Promotion details are " + rowdata);
		softassert.assertAll();
		return new MasterPromotion_Pages();
	}
//=======================================================================================================================
	
	public MasterPromotion_Pages create_Package_Quantity_promo_couponbased_Custom_Store(Hashtable<String, String> ht)
			throws InterruptedException {
		test.pass("TC-042 is loading");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.inputCalenderDate(Promotion_Start_Date, ht.get("Package Quantity Start Date Format"));
		CommonMethod.inputCalenderDate(Promotion_End_Date, ht.get("Package Quantity End Date Format"));
		WebElement promotype = driver.findElement(By.xpath("//select[@placeholder='select']"));
		Select select1 = new Select(promotype);
		select1.selectByVisibleText(ht.get("Package Quantity Type1"));
		CommonMethod.entertextintoinputbox(Promotion_Name, ht.get("Package Quantity Promotion Name"));
		WebElement promo_Subtype = driver.findElement(By.xpath("//select[@id='subType']"));
		Select select2 = new Select(promo_Subtype);
		select2.selectByVisibleText(ht.get("Package Quantity Promotion Sub type1"));
		CommonMethod.entertextintoinputbox(Promotion_Code, ht.get("Package Quantity Promotion Code"));
		CommonMethod.entertextintoinputbox(Promotion_Description, ht.get("Package Quantity Description"));
		CommonMethod.entertextintoinputbox(Promotion_Discount_value, ht.get("Package Quantity Discount Value"));
		WebElement element = driver.findElement(
				By.xpath("//span[@type='button']//span[@class='p-button-label'][normalize-space()='Next']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		
		CommonMethod.entertextintoinputbox(Qualified_Quantity_Trigger_Quantity, ht.get("Package Quatity Trigger Quantiy"));
		WebElement coupon = driver.findElement(By.xpath("//input[@id='coupon']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", coupon);
		Thread.sleep(3000);
		coupon.click();
		CommonMethod.entertextintoinputbox(Package_Quantity_coupon_field, ht.get("Package Quantity Pool Coupon Field"));
		CommonMethod.takescreenshot();
		//CommonMethod.clickonWebElement(Qualified_Quantity_Trigger_Quantity, "Trigger Quantity");
//		WebElement coupon = driver.findElement(By.xpath("//input[@id='coupon']"));
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", coupon);
		Thread.sleep(3000);
		WebElement nextButton = driver
				.findElement(By.xpath("//li[@class='next float-end list-inline-item']//button[@aria-label='Next']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextButton);
		Thread.sleep(3000);
		nextButton.click();
		
		CommonMethod.clickonWebElement(Simpleline_Custom_Stores_Check_Box, "Custom Stores Check Box");
		CommonMethod.bootstrapdropdownselection(clickonselectstoreoption, "clickonparticulastore",
				ht.get("Package Quantity StoreName1"));
		CommonMethod.clickonWebElement(clicko_on_outside, "clicked on outside");
		CommonMethod.bootstrapdropdownselection(clickonselectstoreoption, "clickonparticulastore",
				ht.get("Package Quantity StoreName2"));
		CommonMethod.clickonWebElement(clicko_on_outside, "clicked on outside");

		
		CommonMethod.clickonWebElement(Promotion_Create_Button, "Create Button");
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement toastMessage = wait2
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div/p")));

		if (toastMessage.isDisplayed()) {
			String Actual_Pagetitle = toastMessage.getText();

			softassert.assertEquals(Actual_Pagetitle, ht.get("Package Quantity  Promotion successful Message"));
			System.out.println("Page title is verified and Title is: " + Actual_Pagetitle);
			test.pass("The Pop-UP successful messge is verified and the Pup-UP Message   is: " + Actual_Pagetitle);
			CommonMethod.takescreenshot();
		} else {
			System.out.println("Toast message is not visible.");
		}
		Thread.sleep(3000);
		String rowdata = driver.findElement(By.xpath("//tbody/tr[1]")).getText();
		test.pass("The Latest Created Promotion details are " + rowdata);
		test.pass("Coupon based Package Quantity Promotion Created successfully  " );
		softassert.assertAll();
		return new MasterPromotion_Pages();
	}
//========================================================================================================================
	
	public MasterPromotion_Pages create_Package_Quantity_promo_couponbased_Custom_Store_Custom_Product(Hashtable<String, String> ht)
			throws InterruptedException {
		test.pass("TC-043 is loading");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.inputCalenderDate(Promotion_Start_Date, ht.get("Package Quantity Start Date Format"));
		CommonMethod.inputCalenderDate(Promotion_End_Date, ht.get("Package Quantity End Date Format"));
		WebElement promotype = driver.findElement(By.xpath("//select[@placeholder='select']"));
		Select select1 = new Select(promotype);
		select1.selectByVisibleText(ht.get("Package Quantity Type1"));
		CommonMethod.entertextintoinputbox(Promotion_Name, ht.get("Package Quantity Promotion Name"));
		WebElement promo_Subtype = driver.findElement(By.xpath("//select[@id='subType']"));
		Select select2 = new Select(promo_Subtype);
		select2.selectByVisibleText(ht.get("Package Quantity Promotion Sub type1"));
		CommonMethod.entertextintoinputbox(Promotion_Code, ht.get("Package Quantity Promotion Code"));
		CommonMethod.entertextintoinputbox(Promotion_Description, ht.get("Package Quantity Description"));
		CommonMethod.entertextintoinputbox(Promotion_Discount_value, ht.get("Package Quantity Discount Value"));
		
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//WebElement nextButton1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@type='button']//button[@aria-label='Next']")));

		WebElement element = driver.findElement(
				By.xpath("//span[@type='button']//span[@class='p-button-label'][normalize-space()='Next']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

		Thread.sleep(3000);
		
		//CommonMethod.clickonWebElement(Promotion_Next_Button, "Next");
		CommonMethod.entertextintoinputbox(Qualified_Quantity_Trigger_Quantity, ht.get("Package Quatity Trigger Quantiy"));
		WebElement coupon = driver.findElement(By.xpath("//input[@id='coupon']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", coupon);
		Thread.sleep(3000);
		coupon.click();
		CommonMethod.entertextintoinputbox(Package_Quantity_coupon_field, ht.get("Package Quantity Pool Coupon Field"));
		CommonMethod.takescreenshot();
		//CommonMethod.clickonWebElement(Qualified_Quantity_Trigger_Quantity, "Trigger Quantity");
//		WebElement coupon = driver.findElement(By.xpath("//input[@id='coupon']"));
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", coupon);
		Thread.sleep(3000);
		WebElement nextButton = driver
				.findElement(By.xpath("//li[@class='next float-end list-inline-item']//button[@aria-label='Next']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextButton);
		Thread.sleep(3000);
		nextButton.click();
		
		CommonMethod.clickonWebElement(Simpleline_Custom_Stores_Check_Box, "Custom Stores Check Box");
		CommonMethod.bootstrapdropdownselection(clickonselectstoreoption, "clickonparticulastore",
				ht.get("Package Quantity StoreName1"));
		CommonMethod.clickonWebElement(clicko_on_outside, "clicked on outside");
		CommonMethod.bootstrapdropdownselection(clickonselectstoreoption, "clickonparticulastore",
				ht.get("Package Quantity StoreName2"));
		CommonMethod.clickonWebElement(clicko_on_outside, "clicked on outside");
		
		CommonMethod.clickonWebElement(Simpleline_Custom_Products_Check_Box, "Custom Products Check Box");
		driver.findElement(By.xpath("//button[contains(text(),'Import')]")).click();
		// driver.findElement(By.xpath("//div[@id='customSaleSetModal']//input[@id='fileProduct']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='customSaleSetModal']//input[@id='fileProduct']"))
				.sendKeys("C:\\Users\\sunil\\Test File Format\\Package_Quantity_Coupon_Based_Product_File.csv");
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

			softassert.assertEquals(Actual_Pagetitle, ht.get("Package Quantity  Promotion successful Message"));
			System.out.println("Page title is verified and Title is: " + Actual_Pagetitle);
			test.pass("The Pop-UP successful messge is verified and the Pup-UP Message   is: " + Actual_Pagetitle);
			CommonMethod.takescreenshot();
		} else {
			System.out.println("Toast message is not visible.");
		}
		Thread.sleep(3000);
		String rowdata = driver.findElement(By.xpath("//tbody/tr[1]")).getText();
		test.pass("The Latest Created Promotion details are " + rowdata);
		test.pass("Coupon based Package Quantity Promotion Created successfully  " );
		softassert.assertAll();
		return new MasterPromotion_Pages();
	}
}
