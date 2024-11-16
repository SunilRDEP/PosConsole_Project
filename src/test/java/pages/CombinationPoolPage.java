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
				.sendKeys("C:\\Users\\sunil\\Downloads\\SunilCombination.csv");
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
				.sendKeys("C:\\Users\\sunil\\Test File Format\\Combination File Set.csv");
		Thread.sleep(3000);
		CommonMethod.entertextintoinputbox(Combination_Pool_Qualified_Quantity,
				ht.get("Combination Pool Qualified Quantiy"));
		CommonMethod.clickonWebElement(Combination_Pool_Qualified_Product_Upload, "Upload");
		CommonMethod.clickonWebElement(CombinationPool_Products_import_OK_Button, "OK");
		CommonMethod.clickonWebElement(CombinationPool_Products_Add_More, "Add More ");
		driver.findElement(By.xpath("//tbody/tr[2]/td[1]/input[1]"))
				.sendKeys("C:\\Users\\sunil\\Test File Format\\Combination File Set.csv");
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
				.sendKeys("C:\\Users\\sunil\\Test File Format\\Combination File Set.csv");
		CommonMethod.entertextintoinputbox(Combination_Pool_Qualified_Quantity,
				ht.get("Combination Pool Qualified Quantiy"));
		CommonMethod.clickonWebElement(Combination_Pool_Qualified_Product_Upload, "Upload");
		CommonMethod.clickonWebElement(CombinationPool_Products_import_OK_Button, "OK");

		CommonMethod.clickonWebElement(CombinationPool_Products_Add_More, "Add More ");

		driver.findElement(By.xpath("//tbody/tr[2]/td[1]/input[1]"))
				.sendKeys("C:\\Users\\sunil\\Test File Format\\Combination File Set.csv");

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
}
