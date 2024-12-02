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
	
	
	
	public StockRequest_Inward_Page stock_request_inward_filter_operation(Hashtable<String, String> ht) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.clickonWebElement(Inventory_Stock_Request_Inward_Filter, "filter Button");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.entertextintoinputbox(Inventory_Stock_Request_Inward_Filter_Search_Box,
				ht.get("Inventory inward Search Data for File Reset with Single SKU file"));
		CommonMethod.bootstrapdropdownselection(Inventory_Stock_Request_Inward_Filter_Select_STore,
				"Inventory_Stock_Request_Inward_Filter_Select_STore", ht.get("Inventory inward Filter Select Store1"));
		CommonMethod.clickonWebElement(Inventory_Filter_Outside, "Outside to avoid element overlaping");
		CommonMethod.clickonWebElement(Inventory_Stock_Request_Inward_Filter_Apply_Button,
				"Inventory List Filter Apply Button");
		//String search_data = driver.findElement(By.xpath("//tbody/tr[1]/td[4]")).getText();
		//Assert.assertEquals(search_data, ht.get("Inventory inward Search Data for File Reset with Single SKU file"));
		//test.pass("filter is working fine");
		return this;
	}

	public StockRequest_Inward_Page stock_request_Create_Valid_Inward(Hashtable<String, String> ht) throws InterruptedException {
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
		.sendKeys("C:\\Users\\sunil\\Downloads\\1692009864871_STOCK_REQUEST_FORMAT (2).csv");
		CommonMethod.clickonWebElement(Inventory_Inward_Select_File_Upload_Button, "Upload Button to upload the selected file");
		Thread.sleep(3000);
	CommonMethod.clickonWebElement(Inventory_Inward_Select_File_close, "Upload Button to upload the selected file");
	
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Inventory_Inward_Approve);
	Thread.sleep(3000);
	Inventory_Inward_Approve.click();
	
	
	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));

	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Inventory_Inward_Action_Edit);
	Thread.sleep(3000);
	Inventory_Inward_Action_Edit.click();
//		((JavascriptExecutor) driver).executeScript("arguments[0].click();", Inventory_Inward_Action_Edit);
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Inventory_Inward_Fulfilment);
	Thread.sleep(3000);
	Inventory_Inward_Fulfilment.click();
	
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Inventory_Inward_Action);
	Thread.sleep(3000);
	Inventory_Inward_Action.click();
	
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Inventory_Inward_Mark_As_Received);
	Thread.sleep(3000);
	Inventory_Inward_Mark_As_Received.click();
	
	
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Inventory_Inward_Stock_Request_Bredcrump);
	Thread.sleep(3000);
	Inventory_Inward_Stock_Request_Bredcrump.click();
	
		return this;
	}

}
