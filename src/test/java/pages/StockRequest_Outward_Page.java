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

public class StockRequest_Outward_Page extends TestBase {
	public StockRequest_Outward_Page() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@class='p-button p-component p-button-icon-only p-button-primary p-button-raised p-button-text custom-border-primary custom-rounded bg-white p-button-small']")
	private static WebElement Inventory_Stock_Request_OutWard_CSV_Download;

	@FindBy(xpath = "//span[contains(text(),'Filter')]")
	private static WebElement Inventory_Stock_Request_Inward_Filter;

	@FindBy(xpath = "//button[@class='p-button p-component p-button-icon-only p-button-primary p-button-raised p-button-text custom-border-primary custom-rounded bg-white p-button-small']")
	private static WebElement Inventory_Stock_Request_Inward_CSV_Download;

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

	@FindBy(xpath = "//span[normalize-space()='Stock Transfer(outward)']")
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

	@FindBy(xpath = "//tbody/tr[1]/td[11]/div[1]/a[1]/i[1]")
	private static WebElement Inventory_Outward_ItemDetails;

	@FindBy(xpath = "//tbody/tr[1]/td[1]")
	private static WebElement Inventory_Outward_ItemDetails_SKU1;

	@FindBy(xpath = "//tbody/tr[2]/td[1]")
	private static WebElement Inventory_Outward_ItemDetails_SKU2;

	@FindBy(xpath = "//tbody/tr[3]/td[1]")
	private static WebElement Inventory_Outward_ItemDetails_SKU3;
	
	@FindBy(xpath = "//input[@placeholder='Search...']")
	private static WebElement Inventory_Inward_Global_Search_Field;

	@FindBy(xpath = "//i[@class='ri-search-2-line']")
	private static WebElement Inventory_Inward_Global_Search_Button;

	@FindBy(xpath = "//button[@id='cancelStockBtn']")
	private static WebElement Inventory_Inward_Cancel_Request_Button;

	@FindBy(xpath = "//button[normalize-space()='Download']")
	private static WebElement Inventory_Inward_Download_Create_Request_Button;
	
	@FindBy(xpath = "//span[contains(text(),'Download')]")
	private static WebElement Inward_table_data_download;
	

	SoftAssert softassert = new SoftAssert();

	public StockRequest_Outward_Page stock_request_Outward_Filter_Operation(Hashtable<String, String> ht) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	 	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.entertextintoinputbox(Inventory_Inward_Global_Search_Field,
				ht.get("Inventory Outward Search Data Through RequestID"));

//		CommonMethod.bootstrapdropdownselection(Inventory_Stock_Request_Inward_Filter_Select_STore,
//				"Inventory_Stock_Request_Inward_Filter_Select_STore", ht.get("Inventory inward Filter Select Store1"));
//		CommonMethod.clickonWebElement(Inventory_Filter_Outside, "Outside to avoid element overlaping");
		CommonMethod.clickonWebElement(Inventory_Inward_Global_Search_Button, "Global Search Key Button");
		
		CommonMethod.clickonWebElement(Inventory_Stock_Request_Inward_CSV_Download, "Download Filter Button");
		
		CommonMethod.clickonWebElement(Inward_table_data_download, "Download Button inside filter");
		
//	CommonMethod.bootstrapdropdownselection(Inventory_Stock_Request_Inward_Filter_Select_STore,
//			"Inventory_Stock_Request_Inward_Filter_Select_STore", ht.get("Inventory inward Filter Select Store1"));
//	CommonMethod.clickonWebElement(Inventory_Filter_Outside, "Outside to avoid element overlaping");
		
		String search_Request_ID = driver.findElement(By.xpath("//tbody/tr[1]/td[4]")).getText();
		softassert.assertEquals(search_Request_ID, ht.get("Inventory Outward Search Data Through RequestID"));
		test.pass("filter is working fine for requestID");

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));


		String delivery_to = driver.findElement(By.xpath("//tbody/tr[1]/td[7]")).getText();
		softassert.assertNotEquals(delivery_to, "NA","Delivery to Column is shoing NA");
		test.pass("filter and Global Search Key are working fine ");
		
		String Store_Code = driver.findElement(By.xpath("//tbody/tr[1]/td[1]")).getText();
		softassert.assertNotEquals(Store_Code, "NA","Store Code Column is showing NA");
		test.pass("filter and Global Search Key are working fine for store code column ");
		

		CommonMethod.clickonWebElement(Inventory_Stock_Request_Inward_Filter, "filter Button");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.clickonWebElement(Inventory_Stock_Request_Inward_Filter_Reset_Button, "Reset Button");
		;
CommonMethod.bootstrapdropdownselection(Inventory_Stock_Request_Inward_Filter_Select_STore,
		"Inventory_Stock_Request_Inward_Filter_Select_STore", ht.get("Inventory outward Filter Select Store1"));
	CommonMethod.clickonWebElement(Inventory_Filter_Outside, "Outside to avoid element overlaping");
		CommonMethod.clickonWebElement(Inventory_Stock_Request_Inward_Filter_Apply_Button,
				"Inventory List Filter Apply Button");
		
		softassert.assertAll();
		return this;
	}

	public StockRequest_Outward_Page stock_request_Create_Valid_Outward_using_Product_File(Hashtable<String, String> ht)
			throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));

		CommonMethod.clickonWebElement(Inventory_Stock_Request_Inward_Create, "create Button");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));

		WebElement Transfer_From = driver.findElement(
				By.xpath("//body//div[@id='app']//div[@class='row']//div[@class='row']//div[1]//div[1]//select[1]"));
		Select select1 = new Select(Transfer_From);
		select1.selectByVisibleText(ht.get("Inventory Outward  Transfer From Store"));

		WebElement Transfer_To = driver
				.findElement(By.xpath("//div[@class='card-body']//div[1]//div[2]//div[1]//select[1]"));
		Select select2 = new Select(Transfer_To);
		select2.selectByVisibleText(ht.get("Inventory Outward  Transfer To Store"));

		CommonMethod.inputCalenderDate(Inventory_Request_Date, ht.get("Outward Request Date"));
 
//	
//	WebElement element = driver.findElement(
//			By.xpath("//button[contains(text(),'Upload')]"));
//	((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
//	

		WebElement Upload = driver.findElement(By.xpath("//button[contains(text(),'Upload')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Upload);
		Thread.sleep(3000);
		Upload.click();

		driver.findElement(By.xpath("//input[@id='file']"))
				.sendKeys("C:\\Users\\sunil\\Test File Format\\Outward_STOCK_REQUEST_FORMAT.csv");
		CommonMethod.clickonWebElement(Inventory_Inward_Select_File_Upload_Button,
				"Upload Button to upload the selected file");
		Thread.sleep(3000);
		CommonMethod.clickonWebElement(Inventory_Inward_Select_File_close, "Upload Button to upload the selected file");

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Inventory_Inward_Approve);
		Thread.sleep(3000);
		Inventory_Inward_Approve.click();

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				Inventory_Outward_ItemDetails);
		Thread.sleep(3000);
		Inventory_Outward_ItemDetails.click();

		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				Inventory_Inward_SKU1_from_Item_Details_Table);

		String SKU1_ItemDetails_Table = Inventory_Inward_SKU1_from_Item_Details_Table.getText();
		System.out.println(SKU1_ItemDetails_Table);
		Thread.sleep(3000);
		String SKU2_ItemDetails_Table = Inventory_Inward_SKU2_from_Item_Details_Table.getText();
		System.out.println(SKU2_ItemDetails_Table);
		
		test.pass("Outward Request successfully created for " + SKU1_ItemDetails_Table);
		test.pass("Outward Request successfully created for " + SKU2_ItemDetails_Table);

		return this;
	}

	public StockRequest_Outward_Page stock_request_Create_Valid_Outward_With_Manual_entry_of_SKU(
			Hashtable<String, String> ht) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));

		CommonMethod.clickonWebElement(Inventory_Stock_Request_Inward_Create, "create Button");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));

		WebElement Transfer_From = driver.findElement(
				By.xpath("//body//div[@id='app']//div[@class='row']//div[@class='row']//div[1]//div[1]//select[1]"));
		Select select1 = new Select(Transfer_From);
		select1.selectByVisibleText(ht.get("Inventory Outward  Transfer From Store"));

		WebElement Transfer_To = driver
				.findElement(By.xpath("//div[@class='card-body']//div[1]//div[2]//div[1]//select[1]"));
		Select select2 = new Select(Transfer_To);
		select2.selectByVisibleText(ht.get("Inventory Outward  Transfer To Store"));

		CommonMethod.inputCalenderDate(Inventory_Request_Date, ht.get("Outward Request Date"));

//	
//	WebElement element = driver.findElement(
//			By.xpath("//button[contains(text(),'Upload')]"));
//	((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
//	

		WebElement Add_Row1 = driver.findElement(By.xpath("//button[normalize-space()='Add Row']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Add_Row1);
		Thread.sleep(3000);
		Add_Row1.click(); 

		WebElement Add_Row2 = driver.findElement(By.xpath("//button[normalize-space()='Add Row']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Add_Row2);
		Thread.sleep(3000);
		Add_Row2.click();

		CommonMethod.inputCalenderDate(Inventory_Inward_SKU_Field1, ht.get("Product Sku1 for outward with Manual Entry"));
		CommonMethod.clickonWebElement(Inventory_Inward_SKU_Field2, "outside");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		Thread.sleep(3000);
		CommonMethod.inputCalenderDate(Inventory_Inward_SKU_Field2, ht.get("Product Sku2 for outward with Manual Entry"));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));

		CommonMethod.inputCalenderDate(Inventory_Inward_Quantity1_Field,
				ht.get("Quantity1 to enter manually to Outward"));
		CommonMethod.inputCalenderDate(Inventory_Inward_Quantity2_Field,
				ht.get("Quantity2 to enter manually to Outward"));

		//CommonMethod.clickonWebElement(Inventory_Inward_Delete1, "delete button1");

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Inventory_Inward_Approve);
		Thread.sleep(3000);
		Inventory_Inward_Approve.click();

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				Inventory_Outward_ItemDetails);
		Thread.sleep(3000);
		Inventory_Outward_ItemDetails.click();

		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				Inventory_Inward_SKU1_from_Item_Details_Table);

		String SKU1_ItemDetails_Table = Inventory_Inward_SKU1_from_Item_Details_Table.getText();
		System.out.println(SKU1_ItemDetails_Table);
		Thread.sleep(3000);
		String SKU2_ItemDetails_Table = Inventory_Inward_SKU2_from_Item_Details_Table.getText();
		System.out.println(SKU2_ItemDetails_Table);
		
		test.pass("Outward Request successfully created for " + SKU1_ItemDetails_Table);
		test.pass("Outward Request successfully created for " + SKU2_ItemDetails_Table);

		return this;
	}



}