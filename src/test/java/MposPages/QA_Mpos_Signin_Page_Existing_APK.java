package MposPages;

import java.sql.SQLException;
import java.time.Duration;
import java.util.Hashtable;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.google.common.collect.ImmutableMap;
import com.proenx.rdep.myproject.TestBase;
import com.proenx.rdep.myproject.TestBase_Mobile;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
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

	@FindBy(xpath = "//android.widget.Button[@content-desc=\"Done\"]")
	private WebElement Payment_Done_Button;

	@FindBy(xpath = "//android.widget.Button[@content-desc=\"More Tab 5 of 5\"]")
	private WebElement Three_Dots;

	@FindBy(xpath = "//android.view.View[@content-desc=\"Exchange\"]")
	private WebElement Exchnge_Tab;

	@FindBy(xpath = "//android.widget.Button[@content-desc=\"Phone\"]")
	private WebElement Phone_Exchange_Button;

	@FindBy(xpath = "//android.widget.EditText[@text='Enter phone number']" + "")
	private WebElement Enter_Phone_Number_Field;

	@FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[2]")
	private WebElement Enter_Barcode_of_SKU_Field_To_Return;

	@FindBy(xpath = "//android.widget.Button[@content-desc=\"Validate\"]")
	private WebElement Phone_Validate_Button;

	@FindBy(xpath = "//android.view.View[@content-desc=\"Show Order Items\"]")
	private WebElement Show_Order_Item_Button;

	@FindBy(xpath = "//android.view.View[@content-desc=\"Hide Order Items\"]")
	private WebElement Hide_Order_Item_Button;

	@FindBy(xpath = "//android.widget.Button[@content-desc=\"Continue\"]")
	private WebElement Continue_to_Exchange_Button;

	@FindBy(xpath = "//android.widget.Button[@content-desc=\"Cancel\"]")
	private WebElement Cancel_Exchange_Button;

	@FindBy(xpath = "//android.widget.Button[@content-desc=\"Select the reason\"]")
	private WebElement Select_Reason_For_Exchange_Button;

	@FindBy(xpath = "//android.widget.Button[@content-desc=\"Exchange\"]")
	private WebElement Exchange_After_Reason_Button;

	@FindBy(xpath = "//android.widget.Button[@content-desc=\"Add Manually\"]")
	private WebElement Add_Manually_Exchange_Button;

	@FindBy(xpath = "//android.widget.EditText")
	private WebElement Enter_Bar_Code_For_Exchange_Field;

	@FindBy(xpath = "//android.widget.Button[@content-desc=\"Submit\"]")
	private WebElement Submit_Exchange_Button;

	@FindBy(xpath = "//android.widget.Button[@content-desc=\"Checkout\"]")
	private WebElement Check_Out_For_Exchange_Button;

	public QA_Mpos_Signin_Page_Existing_APK MposLogin_without_otp(Hashtable<String, String> ht)
			throws InterruptedException, SQLException, TimeoutException {
		Thread.sleep(3000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(70));

		try {

			// Wait for and enter username
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[1]")));
			Username_Field.click();
			driver.hideKeyboard();
			Username_Field.sendKeys("admin0265");

			// Wait for and enter password
			wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("//android.view.View[2]//android.widget.EditText[2]")));
			Password_Field.click();
			driver.hideKeyboard();
			Password_Field.sendKeys("admin0265");

			test.pass("Username and Password entered successfully");

		} catch (NoSuchElementException e) {
			test.fail("Login fields not found: " + e.getMessage());
			throw e;
		} catch (Exception e) {
			test.fail("Timeout while waiting for login fields: " + e.getMessage());
			throw e;

		}
		Login_Button.click();
		Thread.sleep(3000);

		return this;
	}

	public QA_Mpos_Signin_Page_Existing_APK Exchange_With_Valid_Transaction_For_High_Price(Hashtable<String, String> ht)
			throws InterruptedException, SQLException, TimeoutException {
		Thread.sleep(3000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(70));

		test.pass("Catalogue logo is collrectly visible on screen");

		List<WebElement> buttons = driver.findElements(By.className("android.widget.Button"));
		for (WebElement btn : buttons) {
			System.out.println("Text: " + btn.getText() + ", Desc: " + btn.getAttribute("content-desc"));
		}
		TouchAction<?> action = new TouchAction<>(driver);
		action.tap(PointOption.point(864, 2130)) // 🔁 Replace with actual X,Y
				.perform();

		test.pass("Clicked on three dots button successfully");

		Exchnge_Tab.click();
		test.pass("Exchange Tab clicked successfully");
		Thread.sleep(3000);
		Phone_Exchange_Button.click();
		test.pass("Phone Exchange Button clicked successfully");
		Thread.sleep(3000);
		List<WebElement> editTexts = driver.findElements(By.className("android.widget.EditText"));
		editTexts.get(0).click();
		editTexts.get(0).sendKeys("7975331947");
		test.pass("Phone number entered successfully");
		Thread.sleep(3000);
		Enter_Barcode_of_SKU_Field_To_Return.click();

		Enter_Barcode_of_SKU_Field_To_Return.sendKeys("1555678");
		test.pass("Barcode of SKU entered successfully");
		Thread.sleep(3000);
		Phone_Validate_Button.click();
		test.pass("Phone Validate Button clicked successfully");
		Thread.sleep(3000);

		String targetBillNumber = configue.getProperty("ExpectedBillId");

		WebElement billElement = driver.findElement(
				AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))"
						+ ".scrollIntoView(new UiSelector().descriptionContains(\"" + targetBillNumber + "\"))"));

		billElement.click();
		test.pass("Clicked on bill number: " + targetBillNumber);
		

		Show_Order_Item_Button.click();
		test.pass("Show Order Item Button clicked successfully");
		Thread.sleep(3000);
		Continue_to_Exchange_Button.click();
		test.pass("Continue to Exchange Button clicked successfully");
		Thread.sleep(3000);
		Select_Reason_For_Exchange_Button.click();
		test.pass("Select Reason For Exchange Button clicked successfully");
		Thread.sleep(3000);
		String targetReason = "Barcode Issue";
		WebElement element = driver.findElement(
				AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))"
						+ ".scrollIntoView(new UiSelector().descriptionContains(\"" + targetReason + "\"))"));

		element.click();
		test.pass("Selected reason for exchange: " + targetReason);

		WebElement Contniue = driver
				.findElement(AppiumBy.androidUIAutomator("new UiSelector().description(\"Continue\")"));

		TouchAction<?> action2 = new TouchAction<>(driver);
		action2.tap(ElementOption.element(Contniue)).perform();

		Thread.sleep(3000);
		Exchange_After_Reason_Button.click();
		test.pass("Exchange After Reason Button clicked successfully");
		Thread.sleep(3000);
		

		WebElement el =  driver.findElement(AppiumBy.androidUIAutomator(
			    "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(" +
			    "new UiSelector().description(\"Add Manually\"))"
			));
			el.click();
		
		test.pass("Add Manually Exchange Button clicked successfully");
		Thread.sleep(3000);
		WebElement barcodeField = wait.until(
			    ExpectedConditions.elementToBeClickable(By.className("android.widget.EditText"))
			);
			barcodeField.click();
		// hide keyboard if it appears
		try {
			driver.hideKeyboard();
		} catch (Exception e) {
			test.fail("Keyboard not present or already hidden.");
		}


		
		test.pass("Barcode for exchange entered successfully");
		Thread.sleep(3000);
		Submit_Exchange_Button.click();
		test.pass("Submit Exchange Button clicked successfully");
		Thread.sleep(3000);
		Check_Out_For_Exchange_Button.click();
		test.pass("Check Out For Exchange Button clicked successfully");
		Thread.sleep(3000);
		// Handle the payment done button
		try {
			Payment_Done_Button.click();
			test.pass("Payment Done button clicked successfully.");
		} catch (NoSuchElementException e) {
			test.fail("Payment Done button not found or could not be clicked: " + e.getMessage());
			throw new TimeoutException("Payment Done button not found or could not be clicked.");
		} catch (Exception e) {
			test.fail("An error occurred while clicking the Payment Done button: " + e.getMessage());
			throw new RuntimeException("An error occurred while clicking the Payment Done button.", e);
		}

		// use a throw for the next element

//		Thread.sleep(3000);
//		Enter_Bar_Code_For_Exchange_Field.click();
//		
//		//hide keyboard if it appears
//		try {
//			driver.hideKeyboard();
//		} catch (Exception e) {
//			System.out.println("Keyboard not present or already hidden.");
//		}
//		Enter_Bar_Code_For_Exchange_Field.sendKeys("3456712002");
//		
//		
//		

		return this;

	}

	public QA_Mpos_Signin_Page_Existing_APK Transaction_with_Existing_APK(Hashtable<String, String> ht)
			throws InterruptedException, SQLException, TimeoutException {
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//android.view.View[@content-desc=\"Catalogue\"]")));

		WebElement catalogueElement = driver.findElement(By.xpath("//android.view.View[@content-desc='Catalogue']"));
		String catalogueText = catalogueElement.getAttribute("content-desc");
		System.out.println("Catalogue value: " + catalogueText);

		test.pass("Catalogue logo is collrectly visible on screen");
		String storeCode = ht.get("StoreCode_DB_Validation"); // 0265
		String sku = ht.get("SKU_DB_Validation");// 1555678

		// Call utility method
		Inventory_Table_Util_Available_Status.InventoryData dbInventory = Inventory_Table_Util_Available_Status
				.getInventoryDataByStoreAndSku(storeCode, sku, test);

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
		WebElement phoneField = driver.findElement(
				AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(0)"));
		phoneField.sendKeys(ht.get("Mobile Number for Customer Details"));

		try {
			WebElement submitButton = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc='Submit']")));
			submitButton.click();
			test.pass("Customer Details Submit Button clicked successfully.");
		} catch (Exception e) {
			test.fail("Submit button not clickable or not found in time: " + e.getMessage());
			throw e;
		}

		try {
			WebElement submitButton = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc='Submit']")));
			submitButton.click();
			test.pass("Customer Details Submit Button clicked successfully.");
		} catch (Exception e) {
			test.fail("Submit button not clickable or not found in time: " + e.getMessage());
			throw e;
		}

		Thread.sleep(3000);
		CONFIRM_PAYMENT.click();

		Thread.sleep(3000);
		// Handle the payment done button
		try {
			Payment_Done_Button.click();
			test.pass("Payment Done button clicked successfully.");
		} catch (NoSuchElementException e) {
			test.fail("Payment Done button not found or could not be clicked: " + e.getMessage());
			throw new TimeoutException("Payment Done button not found or could not be clicked.");
		} catch (Exception e) {
			test.fail("An error occurred while clicking the Payment Done button: " + e.getMessage());
			throw new RuntimeException("An error occurred while clicking the Payment Done button.", e);
		}

		ExpectedBillId = OrderTable_Mpos_Bill_ID.expectedBillId(test);
		CommonMethod_Mobile.updateConfigProperty("ExpectedBillId", ExpectedBillId);
		test.pass("Expected bill id for above transaction is " + ExpectedBillId);
		// obile_configue.setProperty(storeCode, sku);

//	WebElement store_name = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("Rdep Meta Limited Pune")));
//	store_name.click();;
		// driver.findElement(AppiumBy.accessibilityId("Rdep Meta Limited
		// Pune")).click();

		Inventory_Table_Util_Available_Status.InventoryData dbInventory2 = Inventory_Table_Util_Available_Status
				.getInventoryDataByStoreAndSku(storeCode, sku, test);
		test.pass("Available on Hand in Database after transaction is " + dbInventory2.availableOnHand);
		test.pass("Available to order  in Database after transaction is " + dbInventory2.availableToOrder);
		Thread.sleep(3000);

		return this;

	}

}
