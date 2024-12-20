package pages;

import java.awt.AWTException;
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

public class StockRequest_Inward_Page extends TestBase {
	public StockRequest_Inward_Page() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@class='p-button p-component p-button-icon-only p-button-primary p-button-raised p-button-text custom-border-primary custom-rounded bg-white p-button-small']")
	private static WebElement Inventory_Stock_Request_Inward_CSV_Download;

	@FindBy(xpath = "//span[contains(text(),'Filter')]")
	private static WebElement Inventory_Stock_Request_Inward_Filter;

	@FindBy(xpath = "//button[@aria-label='Create']")
	private static WebElement Inventory_Stock_Request_Inward_Create;

	@FindBy(xpath = "//button[@aria-label='Apply']")
	private static WebElement Inventory_Stock_Request_Inward_Filter_Apply_Button;

	@FindBy(xpath = "//span[contains(text(),'Close')]")
	private static WebElement Inventory_Stock_Request_Inward_Filter_Close_Button;

	@FindBy(xpath = "//button[@aria-label='Reset']")
	private static WebElement Inventory_Stock_Request_Inward_Filter_Reset_Button;

	@FindBy(xpath = "//input[@placeholder='Search']")
	private static WebElement Inventory_Stock_Request_Inward_Filter_Search_Box;

	@FindBy(xpath = "//span[contains(text(),'Select Store')]")
	private static WebElement Inventory_Stock_Request_Inward_Filter_Select_STore;

	@FindBy(xpath = "//h4[@id='offcanvasRightLabel']")
	private static WebElement Inventory_Filter_Outside;

	@FindBy(xpath = "//input[@id='requestDate']")
	private static WebElement Inventory_Request_Date;
	
	@FindBy(xpath = "//input[@id='expectedDeliveryDate']")
	private static WebElement Inventory_Delivery_Date;
	
	@FindBy(xpath = "//button[contains(text(),'Upload')]")
	private static WebElement Inventory_Inward_Upload_Button;
	
	@FindBy(xpath = "//input[@id='file']")
	private static WebElement Inventory_Inward_Select_File;
	
	@FindBy(xpath = "//span[contains(text(),'Upload')]")
	private static WebElement Inventory_Inward_Select_File_Upload_Button;

	@FindBy(xpath = "//button[@id='approvedBtn']")
	private static WebElement Inventory_Inward_Approve;
	
	@FindBy(xpath = "//i[@class='ri-edit-2-fill view-icon']")
	private static WebElement Inventory_Inward_Action_Edit;
	
	@FindBy(xpath = "//button[@id='submitFulfill']")
	private static WebElement Inventory_Inward_Fulfilment;
	
	@FindBy(xpath = "//tbody/tr[1]/td[12]/div[1]/a[1]/i[1]")
	private static WebElement Inventory_Inward_Action;
	
	@FindBy(xpath = "//span[@class='p-button-label']")
	private static WebElement Inventory_Inward_Mark_As_Received;
	
	@FindBy(xpath = "//span[normalize-space()='Stock Request']")
	private static WebElement Inventory_Inward_Stock_Request_Bredcrump;
	
	@FindBy(xpath = "//button[@aria-label='Close']")
	private static WebElement Inventory_Inward_Select_File_close;
	

	@FindBy(xpath = "//button[normalize-space()='Add Row']")
	private static WebElement Inventory_Inward_Add_Row;
	
	@FindBy(xpath = "//tbody/tr[1]/td[1]/input[1]")
	private static WebElement Inventory_Inward_SKU_Field1;
	
	@FindBy(xpath = "//tbody/tr[2]/td[1]/input[1]")
	private static WebElement Inventory_Inward_SKU_Field2;
	
	@FindBy(xpath = "//tbody/tr[1]/td[5]/input[1]")
	private static WebElement Inventory_Inward_Quantity1_Field;
	
	@FindBy(xpath = "//tbody/tr[2]/td[5]/input[1]")
	private static WebElement Inventory_Inward_Quantity2_Field;
	
	@FindBy(xpath = "//tbody/tr[1]/td[6]/i[1]")
	private static WebElement Inventory_Inward_Delete1;
	
	@FindBy(xpath = "//tbody/tr[2]/td[6]/i[1]")
	private static WebElement Inventory_Inward_Delete2;
	
	@FindBy(xpath = "//tbody/tr[1]/td[4]")
	private static WebElement Inventory_Inward_RequestID1;
	
	@FindBy(xpath = "//tbody/tr[1]/td[11]")
	private static WebElement Inventory_Inward_Table_Status;
	
	@FindBy(xpath = "//tbody/tr[1]/td[1]")
	private static WebElement Inventory_Inward_SKU1_from_Item_Details_Table;
	
	@FindBy(xpath = "//tbody/tr[2]/td[1]")
	private static WebElement Inventory_Inward_SKU2_from_Item_Details_Table;
	
	@FindBy(xpath = "//tbody/tr[3]/td[1]")
	private static WebElement Inventory_Inward_SKU3_from_Item_Details_Table;
	
	@FindBy(xpath = "//tbody/tr[1]/td[12]/div[1]/a[1]/i[1]")
	private static WebElement Inventory_Inward_ItemDetails;
	
	@FindBy(xpath = "//tbody/tr[1]/td[1]")
	private static WebElement Inventory_Inward_ItemDetails_SKU1;
	
	@FindBy(xpath = "//tbody/tr[2]/td[1]")
	private static WebElement Inventory_Inward_ItemDetails_SKU2;
	
	@FindBy(xpath = "//span[normalize-space()='Stock Request(Inward)']")
	private static WebElement Inventory_Inward_Table;
	
	@FindBy(xpath = "//div[@class='text-white']//span[@class='nav__label'][normalize-space()='Dashboard']")
	private static WebElement Return_to_DashBoard;
	
	
	
	public StockRequest_Inward_Page stock_request_inward_filter_operation(Hashtable<String, String> ht) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.clickonWebElement(Inventory_Stock_Request_Inward_Filter, "filter Button");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.entertextintoinputbox(Inventory_Stock_Request_Inward_Filter_Search_Box,
				ht.get("Inventory inward Search Data Through RequestID"));
//		CommonMethod.bootstrapdropdownselection(Inventory_Stock_Request_Inward_Filter_Select_STore,
//				"Inventory_Stock_Request_Inward_Filter_Select_STore", ht.get("Inventory inward Filter Select Store1"));
//		CommonMethod.clickonWebElement(Inventory_Filter_Outside, "Outside to avoid element overlaping");
		CommonMethod.clickonWebElement(Inventory_Stock_Request_Inward_Filter_Apply_Button,
				"Inventory List Filter Apply Button");
		
		String search_Request_ID = driver.findElement(By.xpath("//tbody/tr[1]/td[4]")).getText();
		Assert.assertEquals(search_Request_ID, ht.get("Inventory inward Search Data Through RequestID"));
		test.pass("filter is working fine for requestID");
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.clickonWebElement(Inventory_Stock_Request_Inward_Filter, "filter Button");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.clickonWebElement(Inventory_Stock_Request_Inward_Filter_Reset_Button, "Reset Button");
		CommonMethod.entertextintoinputbox(Inventory_Stock_Request_Inward_Filter_Search_Box,
				ht.get("Inventory inward Search Data Through Status"));
//		CommonMethod.bootstrapdropdownselection(Inventory_Stock_Request_Inward_Filter_Select_STore,
//				"Inventory_Stock_Request_Inward_Filter_Select_STore", ht.get("Inventory inward Filter Select Store1"));
//		CommonMethod.clickonWebElement(Inventory_Filter_Outside, "Outside to avoid element overlaping");
		CommonMethod.clickonWebElement(Inventory_Stock_Request_Inward_Filter_Apply_Button,
				"Inventory List Filter Apply Button");
		
		String search_Status = driver.findElement(By.xpath("//tbody/tr[1]/td[11]")).getText();
		Assert.assertEquals(search_Status, ht.get("Inventory inward Search Data Through Status"));
		test.pass("filter is working fine for Status");
		
		return this;
	}

	
	
	public StockRequest_Inward_Page stock_request_Create_Valid_Inward_With_Manual_entry_of_SKU(Hashtable<String, String> ht) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));

		CommonMethod.clickonWebElement(Inventory_Stock_Request_Inward_Create, "create Button");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));

		WebElement promotype = driver.findElement(By.xpath("//select[@id='deliverTo']"));
		Select select1 = new Select(promotype);
		select1.selectByVisibleText(ht.get("Inventory Inward  Delivery To Store"));
		CommonMethod.inputCalenderDate(Inventory_Request_Date, ht.get("Inward Request Date"));
		CommonMethod.inputCalenderDate(Inventory_Delivery_Date, ht.get("Inward Delivery Date"));
//		
//		WebElement element = driver.findElement(
//				By.xpath("//button[contains(text(),'Upload')]"));
//		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
//		
		
		WebElement Add_Row1 = driver.findElement(By.xpath("//button[normalize-space()='Add Row']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Add_Row1);
		Thread.sleep(3000);
		//Add_Row1.click();
		CommonMethod.clickonWebElement(Add_Row1, "create Button");
		

		WebElement Add_Row2 = driver.findElement(By.xpath("//button[normalize-space()='Add Row']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Add_Row2);
		Thread.sleep(3000);
		Add_Row2.click();	
		
		CommonMethod.inputCalenderDate(Inventory_Inward_SKU_Field1, ht.get("SKU1 to enter manually to inward"));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.inputCalenderDate(Inventory_Inward_SKU_Field2, ht.get("SKU2 to enter manually to inward"));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));

		CommonMethod.inputCalenderDate(Inventory_Inward_Quantity1_Field, ht.get("Quantity1 to enter manually to inward"));
		CommonMethod.inputCalenderDate(Inventory_Inward_Quantity2_Field, ht.get("Quantity2 to enter manually to inward"));
		
		//CommonMethod.clickonWebElement(Inventory_Inward_Delete1, "delete button1");
	
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Inventory_Inward_Approve);
		Thread.sleep(3000);
		CommonMethod.clickonWebElement(Inventory_Inward_Approve, "Inventory_Inward_Approve Button");
		
		
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Inventory_Inward_Action_Edit);
		Thread.sleep(3000);
		
		CommonMethod.clickonWebElement(Inventory_Inward_Action_Edit, "Inventory_Inward_Action_Edit Button");
		
//			((JavascriptExecutor) driver).executeScript("arguments[0].click();", Inventory_Inward_Action_Edit);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Inventory_Inward_Fulfilment);
		Thread.sleep(3000);
		
		CommonMethod.clickonWebElement(Inventory_Inward_Fulfilment, "Inventory_Inward_Fulfilment Button");
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Inventory_Inward_Action);
		Thread.sleep(3000);
		
		CommonMethod.clickonWebElement(Inventory_Inward_Action, "Inventory_Inward_Action Button");
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Inventory_Inward_Mark_As_Received);
		Thread.sleep(3000);
		
		CommonMethod.clickonWebElement(Inventory_Inward_Mark_As_Received, "Inventory_Inward_Mark_As_Received Button");
		
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Inventory_Inward_Stock_Request_Bredcrump);
//		Thread.sleep(3000);
//		Inventory_Inward_Stock_Request_Bredcrump.click();
		
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Inventory_Inward_Table);
		Thread.sleep(3000);
		
		CommonMethod.clickonWebElement(Inventory_Inward_Table, "Inventory_Inward SubMenu Button");
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				Inventory_Inward_ItemDetails);
		Thread.sleep(3000);
		
		CommonMethod.clickonWebElement(Inventory_Inward_ItemDetails, "Inventory_Inward_ItemDetails Button");

		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				Inventory_Inward_SKU1_from_Item_Details_Table);
		CommonMethod.clickonWebElement(Inventory_Inward_SKU1_from_Item_Details_Table, "Inventory_Inward_SKU1_from_Item_Details_Table Button");
		String SKU1_ItemDetails_Table = Inventory_Inward_SKU1_from_Item_Details_Table.getText();
		System.out.println(SKU1_ItemDetails_Table);
		Thread.sleep(3000);
		String SKU2_ItemDetails_Table = Inventory_Inward_SKU2_from_Item_Details_Table.getText();
		System.out.println(SKU2_ItemDetails_Table);
		

		test.pass("Outward Request successfully created for " + SKU1_ItemDetails_Table);
		test.pass("Outward Request successfully created for " + SKU2_ItemDetails_Table);

		
		
			return this;
		
	}
	public StockRequest_Inward_Page stock_request_Create_Valid_Inward_using_Product_File(Hashtable<String, String> ht) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));

		CommonMethod.clickonWebElement(Inventory_Stock_Request_Inward_Create, "create Button");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));

		WebElement promotype = driver.findElement(By.xpath("//select[@id='deliverTo']"));
		Select select1 = new Select(promotype);
		select1.selectByVisibleText(ht.get("Inventory Inward  Delivery To Store"));
		CommonMethod.inputCalenderDate(Inventory_Request_Date, ht.get("Inward Request Date"));
		CommonMethod.inputCalenderDate(Inventory_Delivery_Date, ht.get("Inward Delivery Date"));
//		
//		WebElement element = driver.findElement(
//				By.xpath("//button[contains(text(),'Upload')]"));
//		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
//		
		
		WebElement Upload = driver.findElement(By.xpath("//button[contains(text(),'Upload')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Upload);
		Thread.sleep(3000);
		Upload.click();
		
		driver.findElement(By.xpath("//input[@id='file']"))
		.sendKeys("C:\\Users\\sunil\\Test File Format\\Inward_STOCK_REQUEST_FORMAT.csv");
		CommonMethod.clickonWebElement(Inventory_Inward_Select_File_Upload_Button, "Upload Button to upload the selected file");
		Thread.sleep(3000);
	CommonMethod.clickonWebElement(Inventory_Inward_Select_File_close, "Upload Button to upload the selected file");
	
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Inventory_Inward_Approve);
	Thread.sleep(3000);
	CommonMethod.clickonWebElement(Inventory_Inward_Approve, "Inventory_Inward_Approve Button");
	
	
	
	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));

	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Inventory_Inward_Action_Edit);
	Thread.sleep(3000);
	
	CommonMethod.clickonWebElement(Inventory_Inward_Action_Edit, "Inventory_Inward_Action_Edit Button");
	
//		((JavascriptExecutor) driver).executeScript("arguments[0].click();", Inventory_Inward_Action_Edit);
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Inventory_Inward_Fulfilment);
	Thread.sleep(3000);
	
	CommonMethod.clickonWebElement(Inventory_Inward_Fulfilment, "Inventory_Inward_Fulfilment Button");
	
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Inventory_Inward_Action);
	Thread.sleep(3000);
	
	CommonMethod.clickonWebElement(Inventory_Inward_Action, "Inventory_Inward_Action Button");
	
	
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Inventory_Inward_Mark_As_Received);
	Thread.sleep(3000);
	Thread.sleep(3000);
	CommonMethod.clickonWebElement(Inventory_Inward_Mark_As_Received, "Inventory_Inward_Mark_As_Received Button");
	
//	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Inventory_Inward_Stock_Request_Bredcrump);
//	Thread.sleep(3000);
//	Inventory_Inward_Stock_Request_Bredcrump.click();
	
	
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Inventory_Inward_Table);
	Thread.sleep(3000);
	
	CommonMethod.clickonWebElement(Inventory_Inward_Table, "Inventory_Inward SubMenu Button");
	
	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));

	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
			Inventory_Inward_ItemDetails);
	Thread.sleep(3000);
	
	CommonMethod.clickonWebElement(Inventory_Inward_ItemDetails, "Inventory_Inward_ItemDetails Button");

	Thread.sleep(3000);
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
			Inventory_Inward_SKU1_from_Item_Details_Table);
	CommonMethod.clickonWebElement(Inventory_Inward_SKU1_from_Item_Details_Table, "Inventory_Inward_SKU1_from_Item_Details_Table Button");
	String SKU1_ItemDetails_Table = Inventory_Inward_SKU1_from_Item_Details_Table.getText();
	System.out.println(SKU1_ItemDetails_Table);
	Thread.sleep(3000);
	String SKU2_ItemDetails_Table = Inventory_Inward_SKU2_from_Item_Details_Table.getText();
	System.out.println(SKU2_ItemDetails_Table);
	

	test.pass("Outward Request successfully created for " + SKU1_ItemDetails_Table);
	test.pass("Outward Request successfully created for " + SKU2_ItemDetails_Table);

	
	
		return this;
	}
	
	public StockRequest_Inward_Page stock_request_Inward_Error_Message_Validation(Hashtable<String, String> ht) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));

		CommonMethod.clickonWebElement(Inventory_Stock_Request_Inward_Create, "create Button");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Inventory_Inward_Approve);
		Thread.sleep(3000);
		
		CommonMethod.clickonWebElement(Inventory_Inward_Approve, "Inventory_Inward_Approve Button");
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement toastMessage = wait2
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div/p")));

		if (toastMessage.isDisplayed()) {
			String Actual_Pagetitle = toastMessage.getText();

			Assert.assertEquals(Actual_Pagetitle, ht.get("Error Message for Inventory Inward  Delivery To Store"));
			System.out.println("Page title is verified and Title is: " + Actual_Pagetitle);
			test.pass("The Pop-UP successful messge is verified and the Pup-UP Message   is: " + Actual_Pagetitle);
			CommonMethod.takescreenshot();
		} else {
			System.out.println("Toast message is not visible.");
		}
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Inventory_Request_Date);
		Thread.sleep(3000);
		WebElement promotype = driver.findElement(By.xpath("//select[@id='deliverTo']"));
		Select select1 = new Select(promotype);
		select1.selectByVisibleText(ht.get("Inventory Inward  Delivery To Store"));
		
		
		
		
		CommonMethod.inputCalenderDate(Inventory_Request_Date, ht.get("Inward Request Date"));
		CommonMethod.inputCalenderDate(Inventory_Delivery_Date, ht.get("Inward Delivery Date"));
//		
//		WebElement element = driver.findElement(
//				By.xpath("//button[contains(text(),'Upload')]"));
//		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Inventory_Inward_Approve);
		
		
		
		
		WebElement Add_Row1 = driver.findElement(By.xpath("//button[normalize-space()='Add Row']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Add_Row1);
		Thread.sleep(3000);
		//Add_Row1.click();
		CommonMethod.clickonWebElement(Add_Row1, "add row Button");
		
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Inventory_Inward_Approve);
		Thread.sleep(3000);
		
		CommonMethod.clickonWebElement(Inventory_Inward_Approve, "Inventory_Inward_Approve Button");
		
		WebElement toastMessage4 = wait2
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div/p")));

		if (toastMessage4.isDisplayed()) {
			String Actual_Pagetitle4 = toastMessage4.getText();

			Assert.assertEquals(Actual_Pagetitle4, ht.get("Error Message for approval without adding items"));
			System.out.println("Page title is verified and Title is: " + Actual_Pagetitle4);
			test.pass("The Pop-UP successful messge is verified and the Pup-UP Message   is: " + Actual_Pagetitle4);
			CommonMethod.takescreenshot();
		} else {
			System.out.println("Toast message is not visible.");
		}
		

		WebElement Add_Row2 = driver.findElement(By.xpath("//button[normalize-space()='Add Row']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Add_Row2);
		Thread.sleep(3000);
		Add_Row2.click();	
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Inventory_Inward_Approve);
		Thread.sleep(3000);
		
		CommonMethod.clickonWebElement(Inventory_Inward_Approve, "Inventory_Inward_Approve Button");
		
		WebElement toastMessage3 = wait2
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div/p")));

		if (toastMessage3.isDisplayed()) {
			String Actual_Pagetitle3 = toastMessage3.getText();

			Assert.assertEquals(Actual_Pagetitle3, ht.get("Error Message for approval without adding items"));
			System.out.println("Page title is verified and Title is: " + Actual_Pagetitle3);
			test.pass("The Pop-UP successful messge is verified and the Pup-UP Message   is: " + Actual_Pagetitle3);
			CommonMethod.takescreenshot();
		} else {
			System.out.println("Toast message is not visible.");
		}
		
		CommonMethod.inputCalenderDate(Inventory_Inward_SKU_Field1, ht.get("SKU1 to enter manually to inward"));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.inputCalenderDate(Inventory_Inward_SKU_Field2, ht.get("SKU2 to enter manually to inward"));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));

		CommonMethod.inputCalenderDate(Inventory_Inward_Quantity1_Field, ht.get("Quantity1 to enter manually to inward"));
		CommonMethod.inputCalenderDate(Inventory_Inward_Quantity2_Field, ht.get("Quantity2 to enter manually to inward"));
		
		//CommonMethod.clickonWebElement(Inventory_Inward_Delete1, "delete button1");
	
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Inventory_Inward_Approve);
		Thread.sleep(3000);
		CommonMethod.clickonWebElement(Inventory_Inward_Approve, "Inventory_Inward_Approve Button");
		
		
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Inventory_Inward_Action_Edit);
		Thread.sleep(3000);
		
		CommonMethod.clickonWebElement(Inventory_Inward_Action_Edit, "Inventory_Inward_Action_Edit Button");
		
//			((JavascriptExecutor) driver).executeScript("arguments[0].click();", Inventory_Inward_Action_Edit);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Inventory_Inward_Fulfilment);
		Thread.sleep(3000);
		
		CommonMethod.clickonWebElement(Inventory_Inward_Fulfilment, "Inventory_Inward_Fulfilment Button");
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Inventory_Inward_Action);
		Thread.sleep(3000);
		
		CommonMethod.clickonWebElement(Inventory_Inward_Action, "Inventory_Inward_Action Button");
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Inventory_Inward_Mark_As_Received);
		Thread.sleep(3000);
		
		CommonMethod.clickonWebElement(Inventory_Inward_Mark_As_Received, "Inventory_Inward_Mark_As_Received Button");
		
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Inventory_Inward_Stock_Request_Bredcrump);
//		Thread.sleep(3000);
//		Inventory_Inward_Stock_Request_Bredcrump.click();
		
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Inventory_Inward_Table);
		Thread.sleep(3000);
		
		CommonMethod.clickonWebElement(Inventory_Inward_Table, "Inventory_Inward SubMenu Button");
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				Inventory_Inward_ItemDetails);
		Thread.sleep(3000);
		
		CommonMethod.clickonWebElement(Inventory_Inward_ItemDetails, "Inventory_Inward_ItemDetails Button");

		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				Inventory_Inward_SKU1_from_Item_Details_Table);
		CommonMethod.clickonWebElement(Inventory_Inward_SKU1_from_Item_Details_Table, "Inventory_Inward_SKU1_from_Item_Details_Table Button");
		String SKU1_ItemDetails_Table = Inventory_Inward_SKU1_from_Item_Details_Table.getText();
		System.out.println(SKU1_ItemDetails_Table);
		Thread.sleep(3000);
		String SKU2_ItemDetails_Table = Inventory_Inward_SKU2_from_Item_Details_Table.getText();
		System.out.println(SKU2_ItemDetails_Table);
		

		test.pass("Outward Request successfully created for " + SKU1_ItemDetails_Table);
		test.pass("Outward Request successfully created for " + SKU2_ItemDetails_Table);

		
		
			return this;
		
	}
	public DashBoardPages Return_to_Dashboard_Page(Hashtable<String, String> ht) throws InterruptedException, AWTException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
	CommonMethod.clickonWebElement(Return_to_DashBoard, "DashBoard to return homepage");
		return new DashBoardPages();
		
}
	
	public DashBoardPages Breadcrump(Hashtable<String, String> ht) throws InterruptedException, AWTException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Inventory_Inward_Stock_Request_Bredcrump);
	Thread.sleep(3000);
	Inventory_Inward_Stock_Request_Bredcrump.click();

		return new DashBoardPages();
		
}
}
