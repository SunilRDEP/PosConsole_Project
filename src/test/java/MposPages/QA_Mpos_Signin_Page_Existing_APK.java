package MposPages;

import java.sql.SQLException;
import java.time.Duration;
import java.util.Hashtable;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.proenx.rdep.myproject.TestBase;
import com.proenx.rdep.myproject.TestBase_Mobile;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import utility.CommonMethod;
import utility.CommonMethod_Mobile;
import utility.DatabaseOTP_Table;
import utility.Inventory_Table_Util_Available_Status;
import utility.OrderTable_Mpos_Bill_ID;

public class QA_Mpos_Signin_Page_Existing_APK extends TestBase_Mobile {

	AndroidDriver driver;
	ExtentTest test;
	public static String ExpectedBillId;
	public QA_Mpos_Signin_Page_Existing_APK(AndroidDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//android.widget.EditText")
	private WebElement mobile_number_field;

	@FindBy(xpath = "(//android.widget.Button)[1]")
	private WebElement Activate_Button;

	@FindBy(xpath = "(//android.widget.Button[@content-desc=\"WEB catalog\"]")
	private WebElement Store_Selection;

	@FindBy(xpath = "//android.widget.Button[@content-desc=\"Submit\"]")
	private WebElement Submit_Button;

	@FindBy(xpath = "//android.widget.EditText")
	private WebElement OTP_Field;

	@FindBy(xpath = "//android.widget.Button[@content-desc=\"Submit\"]")
	private WebElement OTP_Field_Submit;

	@FindBy(xpath = "//android.widget.EditText[1]")
	private WebElement Username_Field;

	@FindBy(xpath = "//android.view.View[2]//android.widget.EditText[2]")
	private WebElement Password_Field;

	@FindBy(xpath = "//android.widget.Button[@content-desc=\"Login\"]")
	private WebElement Login_Button;

	@FindBy(xpath = "//android.widget.Button[@content-desc=\"Submit\"]")
	private WebElement Select_Device_Submit_Button;

	@FindBy(xpath = "//android.widget.EditText")
	private WebElement Search_Product_Field;

	@FindBy(xpath = "//android.view.View[@content-desc=\"Accessories\"]")
	private WebElement Catalogue_Selection;

	@FindBy(xpath = "//android.widget.Button[@content-desc=\"Add to Cart\"]")
	private WebElement Add_TO_CART;

	@FindBy(xpath = "//android.widget.Button[@content-desc=\"Buy Now\"]")
	private WebElement Buy_Now;

	@FindBy(xpath = "//android.widget.Button[@content-desc=\"Back\"]")
	private WebElement Catalogue_Back_Button;

	@FindBy(xpath = "//android.widget.Button[@content-desc=\"1 Cart Tab 4 of 5\"]")
	private WebElement CART_Button;

	@FindBy(xpath = "	\r\n" + "//android.widget.Button[@content-desc=\"Checkout\"]")
	private WebElement Check_Out_Button;

	@FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText\r\n"
			+ "")
	private WebElement Customer_Mobile_Number;

	@FindBy(xpath = "	\r\n" + "//android.widget.Button[@content-desc=\"Submit\"]")
	private WebElement Customer_Details_Submit_Button;

	@FindBy(xpath = "//android.widget.Button[@content-desc=\"Confirm Payment\"]")
	private WebElement CONFIRM_PAYMENT;

	@FindBy(xpath = "//android.widget.Button[@content-desc=\"Go to Cart\"]")
	private WebElement Go_TO_CART_POPUP;

	@FindBy(xpath = "//android.widget.Button[@content-desc=\"Go to Cart\"]")
	private WebElement Go_TO_CART_CLOSE_POPUP;
	
	

	public QA_Mpos_Signin_Page_Existing_APK signin_with_Existing_APK(Hashtable<String, String> ht)
			throws InterruptedException, SQLException {
		Thread.sleep(3000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(70));

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[1]")));

		Username_Field.click();

		driver.hideKeyboard();
		Username_Field.sendKeys("admin0265");
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//android.view.View[2]//android.widget.EditText[2]")));

		Password_Field.click();
		driver.hideKeyboard();
		Password_Field.sendKeys("admin0265");

		Login_Button.click();
		Thread.sleep(3000);

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//android.view.View[@content-desc=\"Catalogue\"]")));

		WebElement catalogueElement = driver.findElement(By.xpath("//android.view.View[@content-desc='Catalogue']"));
		String catalogueText = catalogueElement.getAttribute("content-desc");
		System.out.println("Catalogue value: " + catalogueText);

		test.pass("Catalogue logo is collrectly visible on screen");
		  String storeCode = ht.get("StoreCode_DB_Validation"); //0265
	        String sku = ht.get("SKU_DB_Validation");//1555678

	        // Call utility method
	        Inventory_Table_Util_Available_Status.InventoryData dbInventory = 
	        	    Inventory_Table_Util_Available_Status.getInventoryDataByStoreAndSku(storeCode, sku, test);

		 test.pass(dbInventory.availableOnHand);
		
		
		System.out.println("Catalogue value: " + catalogueText);

		test.pass("Catalogue logo is collrectly visible on screen");
		Catalogue_Selection.click();
		
		Thread.sleep(3000);
		
		
		// Scroll into view using part of the content-desc
		CommonMethod_Mobile.scrollAndClickByPartialDesc(driver, "Brown Hat", "₹500.00");
		Add_TO_CART.click();

		try {
			WebElement popupClose = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
					"//android.view.View[contains(@content-desc, 'added to the cart!')]/android.widget.Button[@index='1']")));
			popupClose.click();

			// Wait until the popup is gone from the DOM
			wait.until(ExpectedConditions.invisibilityOfElementLocated(
					By.xpath("//android.view.View[contains(@content-desc, 'added to the cart!')]")));
		} catch (Exception e) {
			System.out.println("Popup not present, continuing.");
		}

		Catalogue_Back_Button.click();
		Thread.sleep(3000);

		List<WebElement> buttons = driver.findElements(By.className("android.widget.Button"));
		System.out.println("----- Button List -----");
		for (WebElement btn : buttons) {
			System.out.println("content-desc: " + btn.getAttribute("content-desc"));
		}

		By cartTabLocator = By.xpath(
				"//android.widget.Button[contains(@content-desc, 'Cart') and contains(@content-desc, 'Tab 4 of 5')]");
		WebElement cartTab = wait.until(ExpectedConditions.elementToBeClickable(cartTabLocator));
		cartTab.click();
		Thread.sleep(3000);
		// Go_TO_CART_POPUP.click();

		Check_Out_Button.click();
		Thread.sleep(2000);
		Customer_Mobile_Number.click();
		
		
		Thread.sleep(3000);
	WebElement phoneField = driver.findElement(			    AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(0)")			);
			phoneField.sendKeys(ht.get("Mobile Number for Customer Details"));

		Customer_Details_Submit_Button.click();
		Thread.sleep(3000);
		Customer_Details_Submit_Button.click();
		
		Thread.sleep(3000);
		CONFIRM_PAYMENT.click();
		
		  ExpectedBillId=OrderTable_Mpos_Bill_ID.expectedBillId(test);
		 test.pass("Expected bill id for above transaction is " + ExpectedBillId);
		 mobile_configue.setProperty(storeCode, sku);


		
	
//	WebElement store_name = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("Rdep Meta Limited Pune")));
//	store_name.click();;
	//driver.findElement(AppiumBy.accessibilityId("Rdep Meta Limited Pune")).click();
		 
		  Inventory_Table_Util_Available_Status.InventoryData dbInventory2 = 
	        	    Inventory_Table_Util_Available_Status.getInventoryDataByStoreAndSku(storeCode, sku, test);
		  test.pass("Available on Hand in Database after transaction is " +dbInventory2.availableOnHand);
		  test.pass("Available to order  in Database after transaction is " +dbInventory2.availableToOrder);
	Thread.sleep(3000);


		return this;

	}

	public QA_Mpos_Signin_Page_Existing_APK Catalogue(Hashtable<String, String> ht)
			throws InterruptedException, SQLException {
		Thread.sleep(3000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[1]")));

		Username_Field.click();

		driver.hideKeyboard();
		Username_Field.sendKeys(mobile_configue.getProperty("USERNAME"));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//android.view.View[2]//android.widget.EditText[2]")));

		Password_Field.click();
		driver.hideKeyboard();
		Password_Field.sendKeys(mobile_configue.getProperty("PASSWORD"));

		Login_Button.click();
		Thread.sleep(3000);

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//android.view.View[@content-desc=\"Catalogue\"]")));

		WebElement catalogueElement = driver.findElement(By.xpath("//android.view.View[@content-desc='Catalogue']"));
		String catalogueText = catalogueElement.getAttribute("content-desc");
		System.out.println("Catalogue value: " + catalogueText);

		test.pass("Catalogue logo is collrectly visible on screen");
		Catalogue_Selection.click();
		
		Thread.sleep(3000);
		
		
		// Scroll into view using part of the content-desc
		CommonMethod_Mobile.scrollAndClickByPartialDesc(driver, "Brown Hat", "₹500.00");
		Add_TO_CART.click();

		try {
			WebElement popupClose = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
					"//android.view.View[contains(@content-desc, 'added to the cart!')]/android.widget.Button[@index='1']")));
			popupClose.click();

			// Wait until the popup is gone from the DOM
			wait.until(ExpectedConditions.invisibilityOfElementLocated(
					By.xpath("//android.view.View[contains(@content-desc, 'added to the cart!')]")));
		} catch (Exception e) {
			System.out.println("Popup not present, continuing.");
		}

		Catalogue_Back_Button.click();
		Thread.sleep(3000);

		List<WebElement> buttons = driver.findElements(By.className("android.widget.Button"));
		System.out.println("----- Button List -----");
		for (WebElement btn : buttons) {
			System.out.println("content-desc: " + btn.getAttribute("content-desc"));
		}

		By cartTabLocator = By.xpath(
				"//android.widget.Button[contains(@content-desc, 'Cart') and contains(@content-desc, 'Tab 4 of 5')]");
		WebElement cartTab = wait.until(ExpectedConditions.elementToBeClickable(cartTabLocator));
		cartTab.click();
		Thread.sleep(3000);
		// Go_TO_CART_POPUP.click();

		Check_Out_Button.click();
		Thread.sleep(2000);
		Customer_Mobile_Number.click();
		
		Thread.sleep(3000);
	WebElement phoneField = driver.findElement(			    AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(0)")			);
			phoneField.sendKeys("7975331947");

		Customer_Details_Submit_Button.click();
		Thread.sleep(3000);
		Customer_Details_Submit_Button.click();
		
		Thread.sleep(3000);
		CONFIRM_PAYMENT.click();

		return this;

	}
}
