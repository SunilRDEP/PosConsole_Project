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
		CommonMethod.clickonWebElement(Promotion_Next_Button, "Next");
		// CommonMethod.clickonWebElement(Promotion_Next_Button, "Next");
		// CommonMethod.clickonWebElement(Promotion_Create_Button, "Next");
		WebElement nextButton = driver
				.findElement(By.xpath("//li[@class='next float-end list-inline-item']//button[@aria-label='Next']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextButton);
		Thread.sleep(3000);
		nextButton.click();
		CommonMethod.clickonWebElement(Promotion_Create_Button, "Create Button");
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement toastMessage = wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div/p")));

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
		String rowdata=driver.findElement(By.xpath("//tbody/tr[1]")).getText();
		 test.pass("TThe Latest Created Promotion details are " + rowdata);
		 
		return new MasterPromotion_Pages();
	}
	
	public CreatePromotion_Page promotion_Details_error_Message_Validtion(Hashtable<String, String> ht) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.inputCalenderDate(Promotion_Start_Date, ht.get("Master Promotion Start Date Format"));
		CommonMethod.inputCalenderDate(Promotion_End_Date, ht.get("Master Promotion End Date Format"));
		WebElement promotype = driver.findElement(By.xpath("//select[@placeholder='select']"));
		Select select1 = new Select(promotype);
		//select1.selectByVisibleText(ht.get("Promotion Type1"));
		CommonMethod.entertextintoinputbox(Promotion_Name, ht.get("Promotion Name"));
		WebElement promo_Subtype = driver.findElement(By.xpath("//select[@id='subType']"));
		Select select2 = new Select(promo_Subtype);
		select2.selectByVisibleText(ht.get("Promotion Sub type1"));
		CommonMethod.entertextintoinputbox(Promotion_Code, ht.get("Promotion Code"));
		CommonMethod.entertextintoinputbox(Promotion_Description, ht.get("Description"));
		CommonMethod.entertextintoinputbox(Promotion_Discount_value, ht.get("Discount Value"));
		CommonMethod.clickonWebElement(Promotion_Next_Button, "Next");
		
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement toastMessage = wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//p[@class='v-toast__text'])[1]")));

		if (toastMessage.isDisplayed()) {
		    String Actual_Pagetitle = toastMessage.getText();
		    
		    Assert.assertEquals(Actual_Pagetitle, ht.get("Promotion Details Error PopUp"));
		    System.out.println("Page title is verified and Title is: " + Actual_Pagetitle);
		    test.pass("The Pop-UP error  messge is verified and the Pup-UP Message   is: " + Actual_Pagetitle);
		   CommonMethod.takescreenshot();
		} else {
		    System.out.println("Toast message is not visible.");
		}
		return this;
		
	}
	
	public CreatePromotion_Page  clickon_MasterPromotion_Bredcrunch_Create() {
		CommonMethod.clickonWebElement(Master_Promotion_Bredcrunch, "Master Promotion BredCrunch");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
	
		CommonMethod.clickonWebElement(Master_Promotion_Create, "Master Promotion Create");
		return this;
	}
	public MasterPromotion_Pages   simpleLine_with_coupon_Based_All_Store(Hashtable<String, String> ht) throws InterruptedException {
		
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
		CommonMethod.clickonWebElement(Promotion_Next_Button, "Next");
		WebElement coupon = driver
				.findElement(By.xpath("//input[@id='coupon']"));
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
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement toastMessage = wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div/p")));

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
		String rowdata=driver.findElement(By.xpath("//tbody/tr[1]")).getText();
		 test.pass("TThe Latest Created Promotion details are " + rowdata);
		 
		return new MasterPromotion_Pages();
	
		
		
	}
	public void  simpleLine_with_coupon_Based_Custome_Store(Hashtable<String, String> ht) throws InterruptedException {
	
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
	CommonMethod.clickonWebElement(Promotion_Next_Button, "Next");
	WebElement coupon = driver
			.findElement(By.xpath("//input[@id='coupon']"));
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", coupon);
	Thread.sleep(3000);
	coupon.click();
	CommonMethod.entertextintoinputbox(Simpleline_coupon_field, ht.get("Coupon Field"));
	WebElement nextButton = driver
			.findElement(By.xpath("//li[@class='next float-end list-inline-item']//button[@aria-label='Next']"));
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextButton);
	Thread.sleep(3000);
	nextButton.click();
}
}
