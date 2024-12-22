package pages;

import java.time.Duration;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.proenx.rdep.myproject.TestBase;

import utility.CommonMethod;

public class CombinationPoolPage extends TestBase {
	public CombinationPoolPage() {
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

	@FindBy(xpath = "//td[@class='custom-width-400']//input[@id='triggerQuantity']")
	private static WebElement Combination_Pool_Qualified_Quantity;

	@FindBy(xpath = "//tbody/tr[2]/td[2]/input[1]")
	private static WebElement Combination_Pool_Qualified_Quantity2;

	@FindBy(xpath = "//span[contains(text(),'Upload')]")
	private static WebElement Combination_Pool_Qualified_Product_Upload;

	@FindBy(xpath = "//span[@class='p-button-label'][normalize-space()='Upload']")
	private static WebElement Combination_Pool_Qualified_Product_Upload2;

	@FindBy(xpath = "//button[@aria-label='OK']")
	private static WebElement CombinationPool_Products_import_OK_Button;

	@FindBy(xpath = "//tbody/tr[2]/td[3]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/span[1]/button[1]")
	private static WebElement CombinationPool_Products_import_OK_Button2;

	@FindBy(xpath = "//span[contains(text(),'Add more...')]")
	private static WebElement CombinationPool_Products_Add_More;
	
	@FindBy(xpath = "//body/div[@id='app']/div[@class='main_app']/div[@id='view']/div[@class='container-fluid mt-1']/div[@class='content-wrapper']/div/div[@class='col-12']/div[@class='row']/div[@class='col-12']/div[@class='card']/div[@class='p-5']/div[@class='ms-3']/form/div[1]/div[1]/div[2]/div[1]/label[1]")
	private static WebElement CombinationPool_Outside_for_enddate;
	
	@FindBy(xpath = "//ul[@class='pager wizard mb-0 mt-4 list-inline']//button[@aria-label='Previous']")
	private static WebElement CombinationPool_Previous_Button;
	
	
	//==========================================================================================
//Edit field Xpath
	
	@FindBy(xpath = "//tbody/tr[1]/td[13]/i[1]")
	private static WebElement CombinationPool_Edit_All_Field;
	
	
	
	
//=========================================================================================================================

	public MasterPromotion_Pages create_CombinationPool_promo_systembased(Hashtable<String, String> ht)
			throws InterruptedException {
		test.pass("TC-031 is loading"); 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.inputCalenderDate(Promotion_Start_Date, ht.get("CombinationPool Start Date Format"));
		CommonMethod.inputCalenderDate(Promotion_End_Date, ht.get("CombinationPool End Date Format"));
		WebElement promotype = driver.findElement(By.xpath("//select[@placeholder='select']"));
		Select select1 = new Select(promotype);
		select1.selectByVisibleText(ht.get("combination Pool Type1"));
		CommonMethod.entertextintoinputbox(Promotion_Name, ht.get("Combination Pool Promotion Name"));
		WebElement promo_Subtype = driver.findElement(By.xpath("//select[@id='subType']"));
		Select select2 = new Select(promo_Subtype);
		select2.selectByVisibleText(ht.get("Combination Pool Promotion Sub type1"));
		CommonMethod.entertextintoinputbox(Promotion_Code, ht.get("Combination Pool Promotion Code"));
		CommonMethod.entertextintoinputbox(Promotion_Description, ht.get("Combination Pool Description"));
		CommonMethod.entertextintoinputbox(Promotion_Discount_value, ht.get("Combination Pool Discount Value"));
		WebElement element = driver.findElement(
				By.xpath("//span[@type='button']//span[@class='p-button-label'][normalize-space()='Next']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

		WebElement coupon = driver.findElement(By.xpath("//input[@id='coupon']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", coupon);
		Thread.sleep(3000);
		WebElement nextButton = driver
				.findElement(By.xpath("//li[@class='next float-end list-inline-item']//button[@aria-label='Next']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextButton);
		Thread.sleep(3000);
		nextButton.click();

		driver.findElement(By.xpath("//input[@id='uploadFile']"))
				.sendKeys("C:\\Users\\sunil\\Test File Format\\Combination_Pool_Cord_Set1.csv");
				
		Thread.sleep(3000);
		CommonMethod.entertextintoinputbox(Combination_Pool_Qualified_Quantity,
				ht.get("Combination Pool Qualified Quantiy"));
		CommonMethod.clickonWebElement(Combination_Pool_Qualified_Product_Upload, "Upload");
		CommonMethod.clickonWebElement(CombinationPool_Products_import_OK_Button, "OK");

		CommonMethod.clickonWebElement(Promotion_Create_Button, "Create Button");
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement toastMessage = wait2
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div/p")));

		if (toastMessage.isDisplayed()) {
			String Actual_Pagetitle = toastMessage.getText();

			Assert.assertEquals(Actual_Pagetitle, ht.get("Combination Pool Promotion successful Message"));
			System.out.println("Page title is verified and Title is: " + Actual_Pagetitle);
			test.pass("The Pop-UP successful messge is verified and the Pup-UP Message   is: " + Actual_Pagetitle);
			CommonMethod.takescreenshot();
		} else {
			System.out.println("Toast message is not visible.");
		}
		Thread.sleep(3000);
		String rowdata = driver.findElement(By.xpath("//tbody/tr[1]")).getText();
		test.pass("TThe Latest Created Promotion details are " + rowdata);

		return new MasterPromotion_Pages();
	}
//========================================================================================================================

	public MasterPromotion_Pages create_CombinationPool_promo_couponbased(Hashtable<String, String> ht)
			throws InterruptedException { 
		test.pass("TC-032 is loading");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.inputCalenderDate(Promotion_Start_Date, ht.get("CombinationPool Start Date Format"));
		CommonMethod.inputCalenderDate(Promotion_End_Date, ht.get("CombinationPool End Date Format"));
		WebElement promotype = driver.findElement(By.xpath("//select[@placeholder='select']"));
		Select select1 = new Select(promotype);
		select1.selectByVisibleText(ht.get("combination Pool Type1"));
		CommonMethod.entertextintoinputbox(Promotion_Name, ht.get("Combination Pool Promotion Name"));
		WebElement promo_Subtype = driver.findElement(By.xpath("//select[@id='subType']"));
		Select select2 = new Select(promo_Subtype);
		select2.selectByVisibleText(ht.get("Combination Pool Promotion Sub type1"));
		CommonMethod.entertextintoinputbox(Promotion_Code, ht.get("Combination Pool Promotion Code"));
		CommonMethod.entertextintoinputbox(Promotion_Description, ht.get("Combination Pool Description"));
		CommonMethod.entertextintoinputbox(Promotion_Discount_value, ht.get("Combination Pool Discount Value"));
		WebElement element = driver.findElement(
				By.xpath("//span[@type='button']//span[@class='p-button-label'][normalize-space()='Next']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

		WebElement coupon = driver.findElement(By.xpath("//input[@id='coupon']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", coupon);
		Thread.sleep(3000);
		coupon.click();
		CommonMethod.entertextintoinputbox(Simpleline_coupon_field, ht.get("Combination Pool Coupon Field"));
		WebElement nextButton = driver
				.findElement(By.xpath("//li[@class='next float-end list-inline-item']//button[@aria-label='Next']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextButton);
		Thread.sleep(3000);
		nextButton.click();
		driver.findElement(By.xpath("//input[@id='uploadFile']"))
				.sendKeys("C:\\Users\\sunil\\Test File Format\\Combination_Pool_Cord_Set1.csv");
		CommonMethod.entertextintoinputbox(Combination_Pool_Qualified_Quantity,
				ht.get("Combination Pool Qualified Quantiy"));
		CommonMethod.clickonWebElement(Combination_Pool_Qualified_Product_Upload, "Upload");
		CommonMethod.clickonWebElement(CombinationPool_Products_import_OK_Button, "OK");

		CommonMethod.clickonWebElement(Promotion_Create_Button, "Create Button");
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement toastMessage = wait2
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div/p")));

		if (toastMessage.isDisplayed()) {
			String Actual_Pagetitle = toastMessage.getText();

			Assert.assertEquals(Actual_Pagetitle, ht.get("Combination Pool Promotion successful Message"));
			System.out.println("Page title is verified and Title is: " + Actual_Pagetitle);
			test.pass("The Pop-UP successful messge is verified and the Pup-UP Message   is: " + Actual_Pagetitle);
			CommonMethod.takescreenshot();
		} else {
			System.out.println("Toast message is not visible.");
		}
		Thread.sleep(3000);
		String rowdata = driver.findElement(By.xpath("//tbody/tr[1]")).getText();
		String Header = driver.findElement(By.xpath("//table//thead//tr")).getText();

		test.pass("TThe Latest Created Promotion details are " + "\n" + rowdata + "\n" + Header);

		return new MasterPromotion_Pages();
	}
//========================================================================================================================

	public MasterPromotion_Pages create_CombinationPool_promo_systembased_Custom_Store(Hashtable<String, String> ht)
			throws InterruptedException {
		test.pass("TC-033 is loading");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.inputCalenderDate(Promotion_Start_Date, ht.get("CombinationPool Start Date Format"));
		CommonMethod.inputCalenderDate(Promotion_End_Date, ht.get("CombinationPool End Date Format"));
		WebElement promotype = driver.findElement(By.xpath("//select[@placeholder='select']"));
		Select select1 = new Select(promotype);
		select1.selectByVisibleText(ht.get("combination Pool Type1"));
		CommonMethod.entertextintoinputbox(Promotion_Name, ht.get("Combination Pool Promotion Name"));
		WebElement promo_Subtype = driver.findElement(By.xpath("//select[@id='subType']"));
		Select select2 = new Select(promo_Subtype);
		select2.selectByVisibleText(ht.get("Combination Pool Promotion Sub type1"));
		CommonMethod.entertextintoinputbox(Promotion_Code, ht.get("Combination Pool Promotion Code"));
		CommonMethod.entertextintoinputbox(Promotion_Description, ht.get("Combination Pool Description"));
		CommonMethod.entertextintoinputbox(Promotion_Discount_value, ht.get("Combination Pool Discount Value"));
		WebElement element = driver.findElement(
				By.xpath("//span[@type='button']//span[@class='p-button-label'][normalize-space()='Next']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

		WebElement coupon = driver.findElement(By.xpath("//input[@id='coupon']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", coupon);
		Thread.sleep(3000);
		WebElement nextButton = driver
				.findElement(By.xpath("//li[@class='next float-end list-inline-item']//button[@aria-label='Next']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextButton);
		Thread.sleep(3000);
		nextButton.click();

		CommonMethod.clickonWebElement(Simpleline_Custom_Stores_Check_Box, "Custom Stores Check Box");
		CommonMethod.bootstrapdropdownselection(clickonselectstoreoption, "combination_clickonparticulastore",
				ht.get("Combination Pool StoreName1"));

		driver.findElement(By.xpath("//input[@id='uploadFile']"))
				.sendKeys("C:\\Users\\sunil\\Test File Format\\Combination File Set.csv");
		Thread.sleep(3000);
		CommonMethod.entertextintoinputbox(Combination_Pool_Qualified_Quantity,
				ht.get("Combination Pool Qualified Quantiy"));
		CommonMethod.clickonWebElement(Combination_Pool_Qualified_Product_Upload, "Upload");
		CommonMethod.clickonWebElement(CombinationPool_Products_import_OK_Button, "OK");

		CommonMethod.clickonWebElement(Promotion_Create_Button, "Create Button");
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement toastMessage = wait2
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div/p")));

		if (toastMessage.isDisplayed()) {
			String Actual_Pagetitle = toastMessage.getText();

			Assert.assertEquals(Actual_Pagetitle, ht.get("Combination Pool Promotion successful Message"));
			System.out.println("Page title is verified and Title is: " + Actual_Pagetitle);
			test.pass("The Pop-UP successful messge is verified and the Pup-UP Message   is: " + Actual_Pagetitle);
			CommonMethod.takescreenshot();
		} else {
			System.out.println("Toast message is not visible.");
		}
		Thread.sleep(3000);
		String rowdata = driver.findElement(By.xpath("//tbody/tr[1]")).getText();
		test.pass("The Latest Created Promotion details are " + rowdata);

		return new MasterPromotion_Pages();

	}
//=======================================================================================================================

	public MasterPromotion_Pages create_CombinationPool_promo_couponbased_Custom_Store(Hashtable<String, String> ht)
			throws InterruptedException {
		test.pass("TC-034 is loading");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.inputCalenderDate(Promotion_Start_Date, ht.get("CombinationPool Start Date Format"));
		CommonMethod.inputCalenderDate(Promotion_End_Date, ht.get("CombinationPool End Date Format"));
		WebElement promotype = driver.findElement(By.xpath("//select[@placeholder='select']"));
		Select select1 = new Select(promotype);
		select1.selectByVisibleText(ht.get("combination Pool Type1"));
		CommonMethod.entertextintoinputbox(Promotion_Name, ht.get("Combination Pool Promotion Name"));
		WebElement promo_Subtype = driver.findElement(By.xpath("//select[@id='subType']"));
		Select select2 = new Select(promo_Subtype);
		select2.selectByVisibleText(ht.get("Combination Pool Promotion Sub type1"));
		CommonMethod.entertextintoinputbox(Promotion_Code, ht.get("Combination Pool Promotion Code"));
		CommonMethod.entertextintoinputbox(Promotion_Description, ht.get("Combination Pool Description"));
		CommonMethod.entertextintoinputbox(Promotion_Discount_value, ht.get("Combination Pool Discount Value"));
		WebElement element = driver.findElement(
				By.xpath("//span[@type='button']//span[@class='p-button-label'][normalize-space()='Next']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

		WebElement coupon = driver.findElement(By.xpath("//input[@id='coupon']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", coupon);
		Thread.sleep(3000);
		coupon.click();
		CommonMethod.entertextintoinputbox(Simpleline_coupon_field, ht.get("Combination Pool Coupon Field"));
		WebElement nextButton = driver
				.findElement(By.xpath("//li[@class='next float-end list-inline-item']//button[@aria-label='Next']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextButton);
		Thread.sleep(3000);
		nextButton.click();

		CommonMethod.clickonWebElement(Simpleline_Custom_Stores_Check_Box, "Custom Stores Check Box");
		CommonMethod.bootstrapdropdownselection(clickonselectstoreoption, "combination_clickonparticulastore",
				ht.get("Combination Pool StoreName1"));
		driver.findElement(By.xpath("//input[@id='uploadFile']"))
				.sendKeys("C:\\Users\\sunil\\Test File Format\\Combination File Set.csv");
		CommonMethod.entertextintoinputbox(Combination_Pool_Qualified_Quantity,
				ht.get("Combination Pool Qualified Quantiy"));
		CommonMethod.clickonWebElement(Combination_Pool_Qualified_Product_Upload, "Upload");
		CommonMethod.clickonWebElement(CombinationPool_Products_import_OK_Button, "OK");

		CommonMethod.clickonWebElement(Promotion_Create_Button, "Create Button");
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement toastMessage = wait2
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div/p")));

		if (toastMessage.isDisplayed()) {
			String Actual_Pagetitle = toastMessage.getText();

			Assert.assertEquals(Actual_Pagetitle, ht.get("Promotion successful Message"));
			System.out.println("Page title is verified and Title is: " + Actual_Pagetitle);
			test.pass("The Pop-UP successful messge is verified and the Pup-UP Message   is: " + Actual_Pagetitle);
			CommonMethod.takescreenshot();
		} else {
			System.out.println("Toast message is not visible.");
		}
		Thread.sleep(3000);
		String rowdata = driver.findElement(By.xpath("//tbody/tr[1]")).getText();
		test.pass("TThe Latest Created Promotion details are " + rowdata);

		return new MasterPromotion_Pages();
	}
//========================================================================================================================

	public MasterPromotion_Pages create_CombinationPool_promo_systembased_Custom_Store_Twoset_Productfile(
			Hashtable<String, String> ht) throws InterruptedException {
		test.pass("TC-035 is loading");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.inputCalenderDate(Promotion_Start_Date, ht.get("CombinationPool Start Date Format"));
		CommonMethod.inputCalenderDate(Promotion_End_Date, ht.get("CombinationPool End Date Format"));
		WebElement promotype = driver.findElement(By.xpath("//select[@placeholder='select']"));
		Select select1 = new Select(promotype);
		select1.selectByVisibleText(ht.get("combination Pool Type1"));
		CommonMethod.entertextintoinputbox(Promotion_Name, ht.get("Combination Pool Promotion Name"));
		WebElement promo_Subtype = driver.findElement(By.xpath("//select[@id='subType']"));
		Select select2 = new Select(promo_Subtype);
		select2.selectByVisibleText(ht.get("Combination Pool Promotion Sub type1"));
		CommonMethod.entertextintoinputbox(Promotion_Code, ht.get("Combination Pool Promotion Code"));
		CommonMethod.entertextintoinputbox(Promotion_Description, ht.get("Combination Pool Description"));
		CommonMethod.entertextintoinputbox(Promotion_Discount_value, ht.get("Combination Pool Discount Value"));
		WebElement element = driver.findElement(
				By.xpath("//span[@type='button']//span[@class='p-button-label'][normalize-space()='Next']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

		WebElement coupon = driver.findElement(By.xpath("//input[@id='coupon']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", coupon);
		Thread.sleep(3000);
		WebElement nextButton = driver
				.findElement(By.xpath("//li[@class='next float-end list-inline-item']//button[@aria-label='Next']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextButton);
		Thread.sleep(3000);
		nextButton.click();

		CommonMethod.clickonWebElement(Simpleline_Custom_Stores_Check_Box, "Custom Stores Check Box");
		CommonMethod.bootstrapdropdownselection(clickonselectstoreoption, "combination_clickonparticulastore",
				ht.get("Combination Pool StoreName1"));

		driver.findElement(By.xpath("//input[@id='uploadFile']"))
				.sendKeys("C:\\Users\\sunil\\Test File Format\\Combination_Pool_Cord_Set1.csv");
		Thread.sleep(3000);
		CommonMethod.entertextintoinputbox(Combination_Pool_Qualified_Quantity,
				ht.get("Combination Pool Qualified Quantiy"));
		CommonMethod.clickonWebElement(Combination_Pool_Qualified_Product_Upload, "Upload");
		CommonMethod.clickonWebElement(CombinationPool_Products_import_OK_Button, "OK");
		CommonMethod.clickonWebElement(CombinationPool_Products_Add_More, "Add More ");
		driver.findElement(By.xpath("//tbody/tr[2]/td[1]/input[1]"))
				.sendKeys("C:\\Users\\sunil\\Test File Format\\Combination_Pool_Cord_Set2.csv");
		Thread.sleep(3000);
		CommonMethod.entertextintoinputbox(Combination_Pool_Qualified_Quantity2,
				ht.get("Combination Pool Qualified Quantiy"));
		CommonMethod.clickonWebElement(Combination_Pool_Qualified_Product_Upload2, "Upload");
		CommonMethod.clickonWebElement(CombinationPool_Products_import_OK_Button2, "OK");

		CommonMethod.clickonWebElement(Promotion_Create_Button, "Create Button");
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement toastMessage = wait2
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div/p")));

		if (toastMessage.isDisplayed()) {
			String Actual_Pagetitle = toastMessage.getText();

			Assert.assertEquals(Actual_Pagetitle, ht.get("Combination Pool Promotion successful Message"));
			System.out.println("Page title is verified and Title is: " + Actual_Pagetitle);
			test.pass("The Pop-UP successful messge is verified and the Pup-UP Message   is: " + Actual_Pagetitle);
			CommonMethod.takescreenshot();
		} else {
			System.out.println("Toast message is not visible.");
		}
		Thread.sleep(3000);
		String rowdata = driver.findElement(By.xpath("//tbody/tr[1]")).getText();
		test.pass("TThe Latest Created Promotion details are " + rowdata);

		return new MasterPromotion_Pages();

	}
//=======================================================================================================================

	public MasterPromotion_Pages create_CombinationPool_promo_couponbased_Custom_Store_Twoset_Productfile(
			Hashtable<String, String> ht) throws InterruptedException {
		test.pass("TC-036 is loading");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.inputCalenderDate(Promotion_Start_Date, ht.get("CombinationPool Start Date Format"));
		CommonMethod.inputCalenderDate(Promotion_End_Date, ht.get("CombinationPool End Date Format"));
		WebElement promotype = driver.findElement(By.xpath("//select[@placeholder='select']"));
		Select select1 = new Select(promotype);
		select1.selectByVisibleText(ht.get("combination Pool Type1"));
		CommonMethod.entertextintoinputbox(Promotion_Name, ht.get("Combination Pool Promotion Name"));
		WebElement promo_Subtype = driver.findElement(By.xpath("//select[@id='subType']"));
		Select select2 = new Select(promo_Subtype);
		select2.selectByVisibleText(ht.get("Combination Pool Promotion Sub type1"));
		CommonMethod.entertextintoinputbox(Promotion_Code, ht.get("Combination Pool Promotion Code"));
		CommonMethod.entertextintoinputbox(Promotion_Description, ht.get("Combination Pool Description"));
		CommonMethod.entertextintoinputbox(Promotion_Discount_value, ht.get("Combination Pool Discount Value"));
		WebElement element = driver.findElement(
				By.xpath("//span[@type='button']//span[@class='p-button-label'][normalize-space()='Next']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

		WebElement coupon = driver.findElement(By.xpath("//input[@id='coupon']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", coupon);
		Thread.sleep(3000);
		coupon.click();
		CommonMethod.entertextintoinputbox(Simpleline_coupon_field, ht.get("Combination Pool Coupon Field"));
		WebElement nextButton = driver
				.findElement(By.xpath("//li[@class='next float-end list-inline-item']//button[@aria-label='Next']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextButton);
		Thread.sleep(3000);
		nextButton.click();

		CommonMethod.clickonWebElement(Simpleline_Custom_Stores_Check_Box, "Custom Stores Check Box");
		CommonMethod.bootstrapdropdownselection(clickonselectstoreoption, "combination_clickonparticulastore",
				ht.get("Combination Pool StoreName1"));
		driver.findElement(By.xpath("//input[@id='uploadFile']"))
				.sendKeys("C:\\Users\\sunil\\Test File Format\\Combination_Pool_Cord_Set1.csv");
		CommonMethod.entertextintoinputbox(Combination_Pool_Qualified_Quantity,
				ht.get("Combination Pool Qualified Quantiy"));
		CommonMethod.clickonWebElement(Combination_Pool_Qualified_Product_Upload, "Upload");
		CommonMethod.clickonWebElement(CombinationPool_Products_import_OK_Button, "OK");

		CommonMethod.clickonWebElement(CombinationPool_Products_Add_More, "Add More ");

		driver.findElement(By.xpath("//tbody/tr[2]/td[1]/input[1]"))
				.sendKeys("C:\\Users\\sunil\\Test File Format\\Combination_Pool_Cord_Set2.csv");

		Thread.sleep(3000);
		CommonMethod.entertextintoinputbox(Combination_Pool_Qualified_Quantity2,
				ht.get("Combination Pool Qualified Quantiy"));
		CommonMethod.clickonWebElement(Combination_Pool_Qualified_Product_Upload2, "Upload");
		CommonMethod.clickonWebElement(CombinationPool_Products_import_OK_Button2, "OK");

		CommonMethod.clickonWebElement(Promotion_Create_Button, "Create Button");
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement toastMessage = wait2
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div/p")));

		if (toastMessage.isDisplayed()) {
			String Actual_Pagetitle = toastMessage.getText();

			Assert.assertEquals(Actual_Pagetitle, ht.get("Promotion successful Message"));
			System.out.println("Page title is verified and Title is: " + Actual_Pagetitle);
			test.pass("The Pop-UP successful messge is verified and the Pup-UP Message   is: " + Actual_Pagetitle);
			CommonMethod.takescreenshot();
		} else {
			System.out.println("Toast message is not visible.");
		}
		Thread.sleep(3000);
		String rowdata = driver.findElement(By.xpath("//tbody/tr[1]")).getText();
		test.pass("TThe Latest Created Promotion details are " + rowdata);
		System.out.println("Page title is verified and Title is: ");
		return new MasterPromotion_Pages();
	}
	
	public CombinationPoolPage error_message_validation(
			Hashtable<String, String> ht) throws InterruptedException {
		test.pass("TC-036 is loading");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
	
		CommonMethod.inputCalenderDate(Promotion_Start_Date, ht.get("CombinationPool Start Date Format"));
		CommonMethod.inputCalenderDate(Promotion_End_Date, ht.get("CombinationPool End Date Format"));
		CommonMethod.clickonWebElement(CombinationPool_Outside_for_enddate, "out side to avoide overlapping");
		
		
		WebElement nextButton = driver
				.findElement(By.xpath("//span[@type='button']//span[@class='p-button-label'][normalize-space()='Next']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextButton);
		Thread.sleep(3000);
		nextButton.click();
	
		
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement toastMessage = wait2
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div/p")));

		if (toastMessage.isDisplayed()) {
			String Actual_Pagetitle = toastMessage.getText();

			Assert.assertEquals(Actual_Pagetitle, ht.get("Error Message for Select Promotion Type Mandatory Field"));
			System.out.println("Page title is verified and Title is: " + Actual_Pagetitle);
			test.pass("The Pop-UP successful messge is verified and the Pup-UP Message   is: " + Actual_Pagetitle);
			CommonMethod.takescreenshot();
		} else {
			System.out.println("Toast message is not visible.");
		}
		
		WebElement promotype = driver.findElement(By.xpath("//select[@placeholder='select']"));
		Select select1 = new Select(promotype);
		select1.selectByVisibleText(ht.get("combination Pool Type1"));
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextButton);
		Thread.sleep(3000);
		nextButton.click();
	
		
	
		WebElement toastMessage2 = wait2
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div/p")));

		if (toastMessage2.isDisplayed()) {
			String Actual_Pagetitle2 = toastMessage2.getText();

			Assert.assertEquals(Actual_Pagetitle2, ht.get("Error Message for Select Promotion Name Mandatory Field"));
			System.out.println("Page title is verified and Title is: " + Actual_Pagetitle2);
			test.pass("The Pop-UP successful messge is verified and the Pup-UP Message   is: " + Actual_Pagetitle2);
			CommonMethod.takescreenshot();
		} else {
			System.out.println("Toast message is not visible.");
		}
		
		
		
		CommonMethod.entertextintoinputbox(Promotion_Name, ht.get("Combination Pool Promotion Name"));
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextButton);
		Thread.sleep(3000);
		nextButton.click();
	
		
	
		WebElement toastMessage3 = wait2
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div/p")));

		if (toastMessage3.isDisplayed()) {
			String Actual_Pagetitle3 = toastMessage3.getText();

			Assert.assertEquals(Actual_Pagetitle3, ht.get("Error Message for Select Promotion Sub Type Mandatory Field"));
			System.out.println("Page title is verified and Title is: " + Actual_Pagetitle3);
			test.pass("The Pop-UP successful messge is verified and the Pup-UP Message   is: " + Actual_Pagetitle3);
			CommonMethod.takescreenshot();
		} else {
			System.out.println("Toast message is not visible.");
		}
		
		
		 
		
		WebElement promo_Subtype = driver.findElement(By.xpath("//select[@id='subType']"));
		Select select2 = new Select(promo_Subtype);
		select2.selectByVisibleText(ht.get("Combination Pool Promotion Sub type1"));
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextButton);
		Thread.sleep(3000);
		nextButton.click();
	
		
	
		try {
		    
		    WebElement toastMessage4 = wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div/p")));
		    
		    // Re-locate the element before interacting with it
		    if (toastMessage4 != null && toastMessage4.isDisplayed()) {
		        // Fetch the updated toast message
		        String actualPageTitle4 = toastMessage4.getText();
		        
		        // Compare with the expected message
		        Assert.assertEquals(actualPageTitle4, ht.get("Error Message for Select Promotion Promocode Mandatory Field"));
		        System.out.println("Page title is verified and Title is: " + actualPageTitle4);
		        
		        // Log success and take a screenshot
		        test.pass("The Pop-UP success message is verified and the Pop-UP Message is: " + actualPageTitle4);
		        CommonMethod.takescreenshot();
		    } else {
		        System.out.println("Toast message is not visible.");
		    }
		} catch (StaleElementReferenceException e) {
		    System.out.println("StaleElementReferenceException caught. Re-locating the toast message.");
		    WebElement toastMessage4Retry = wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div/p")));
		    
		    if (toastMessage4Retry != null && toastMessage4Retry.isDisplayed()) {
		        String actualPageTitle4Retry = toastMessage4Retry.getText();
		        Assert.assertEquals(actualPageTitle4Retry, ht.get("Error Message for Select Promotion Promocode Mandatory Field"));
		        System.out.println("Page title is verified (after retry) and Title is: " + actualPageTitle4Retry);
		        test.pass("The Pop-UP success message is verified (after retry) and the Pop-UP Message is: " + actualPageTitle4Retry);
		        CommonMethod.takescreenshot();
		    }
		}

		CommonMethod.entertextintoinputbox(Promotion_Code, ht.get("Combination Pool Promotion Code"));
		
		
		
		CommonMethod.entertextintoinputbox(Promotion_Description, ht.get("Combination Pool Description"));
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextButton);
		Thread.sleep(3000);
		nextButton.click();
	
		
	
		WebElement toastMessage5 = wait2
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div/p")));

		if (toastMessage5.isDisplayed()) {
			String Actual_Pagetitle5 = toastMessage5.getText();

			Assert.assertEquals(Actual_Pagetitle5, ht.get("Error Message for Select Promotion Discount Value Mandatory Field"));
			System.out.println("Page title is verified and Title is: " + Actual_Pagetitle5);
			test.pass("The Pop-UP successful messge is verified and the Pup-UP Message   is: " + Actual_Pagetitle5);
			CommonMethod.takescreenshot();
		} else {
			System.out.println("Toast message is not visible.");
		}
		
		CommonMethod.entertextintoinputbox(Promotion_Discount_value, ht.get("Combination Pool Discount Value"));
	
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextButton);
		Thread.sleep(3000);
		nextButton.click();
		
		WebElement coupon = driver.findElement(By.xpath("//input[@id='coupon']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", coupon);
		Thread.sleep(3000);
		coupon.click();
	
		WebElement nextButton2 = driver
				.findElement(By.xpath("//li[@class='next float-end list-inline-item']//button[@aria-label='Next']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextButton2);
		Thread.sleep(3000);
		nextButton2.click();
		
		CommonMethod.clickonWebElement(Promotion_Create_Button, "Create Button");
		
		WebElement toastMessage6 = wait2
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div/p")));

		if (toastMessage6.isDisplayed()) {
			String Actual_Pagetitle6 = toastMessage6.getText();

			Assert.assertEquals(Actual_Pagetitle6, ht.get("Error Message for creating promo without promocode"));
			System.out.println("Page title is verified and Title is: " + Actual_Pagetitle6);
			test.pass("The Pop-UP successful messge is verified and the Pup-UP Message   is: " + Actual_Pagetitle6);
			CommonMethod.takescreenshot();
		} else {
			System.out.println("Toast message is not visible.");
		}
		
		CommonMethod.clickonWebElement(CombinationPool_Previous_Button, "Previous button");
		CommonMethod.entertextintoinputbox(Simpleline_coupon_field, ht.get("Combination Pool Coupon Field"));
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextButton2);
		Thread.sleep(3000);
		nextButton2.click();
	
		CommonMethod.clickonWebElement(Promotion_Create_Button, "Create Button");
		
		WebElement toastMessage7 = wait2
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div/p")));

		if (toastMessage7.isDisplayed()) {
			String Actual_Pagetitle7 = toastMessage7.getText();

			Assert.assertEquals(Actual_Pagetitle7, ht.get("Error Message for creating promo without Product File Set "));
			System.out.println("Page title is verified and Title is: " + Actual_Pagetitle7);
			test.pass("The Pop-UP successful messge is verified and the Pup-UP Message   is: " + Actual_Pagetitle7);
			CommonMethod.takescreenshot();
		} else {
			System.out.println("Toast message is not visible.");
		}
		
		
		
		return new CombinationPoolPage();
}
}
