package pages;

import java.time.Duration;
import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.proenx.rdep.myproject.TestBase;

import utility.CommonMethod;

public class InventoryList_Page extends TestBase {
 	public InventoryList_Page() {
		PageFactory.initElements(driver, this);
	} 

	@FindBy(xpath = "//span[@class='p-button-icon ri-sound-module-line ri-xl']")
	private static WebElement Inventory_List_Adjustment;

	@FindBy(xpath = "//div[@class='col-12 col-lg-4 pt-4 d-flex justify-content-end']//span[@class='p-button-label'][normalize-space()='Close']")
	private static WebElement Inventory_List_Adjustment_Close_Button;

	@FindBy(xpath = "//div[@class='col-12 col-lg-4 mb-1']//div[@class='multiselect__tags']")
	private static WebElement Inventory_List_Adjustment_Select_Store;

	@FindBy(xpath = "//input[@id='file']")
	private static WebElement Inventory_List_Adjustment_Select_File;

	@FindBy(xpath = "//span[normalize-space()='Click here for File format']")
	private static WebElement Inventory_List_Adjustment_File_Format_Download;

	@FindBy(xpath = "//span[contains(text(),'Upload')]")
	private static WebElement Inventory_List_Adjustment_Upload_Button;

	@FindBy(xpath = "//button[@aria-label='Yes']")
	private static WebElement Inventory_List_Adjustment_OK_Button;
	// -------------------------------------------------------------------------------------------------------------

	@FindBy(xpath = "//span[@class='m-1 me-2']//button[@type='button']")
	private static WebElement Inventory_Import;

	@FindBy(xpath = "//input[@id='fileReset']")
	private static WebElement Inventory_Import_fileReset;

	@FindBy(xpath = "//input[@id='update']")
	private static WebElement Inventory_Import_update;

	@FindBy(xpath = "//input[@id='resetAll']")
	private static WebElement Inventory_Import_resetAll;

	@FindBy(xpath = "//span[@title='To update/add the inventory.']")
	private static WebElement Inventory_Import_update_info_message;

	@FindBy(xpath = "//span[@title='To reset the inventory for all SKUs.']")
	private static WebElement Inventory_Import_resetAll_info_message;

	@FindBy(xpath = "//span[@title='To reset the inventory for specific products.']")
	private static WebElement Inventory_Import_filereset_info_message;

	@FindBy(xpath = "//input[@id='file']")
	private static WebElement Inventory_Import_Select_File;

	@FindBy(xpath = "//div[@class='col-12 col-lg-4 mb-1']//div[@class='multiselect__tags']")
	private static WebElement Inventory_Import_Select_Store;

	@FindBy(xpath = "//button[normalize-space()='Upload']")
	private static WebElement Inventory_Import_upload_button;

	@FindBy(xpath = "//div[@class='col-12 col-lg-4 d-flex align-items-end justify-content-end gap-2 mb-3']//button[@type='button'][normalize-space()='Cancel']")
	private static WebElement Inventory_Import_cancel_button;

	@FindBy(xpath = "//h5[@id='adjustMentModal']")
	private static WebElement Inventory_Import_text;

	@FindBy(xpath = "//button[@aria-label='Yes']")
	private static WebElement Inventory_List_Import_OK_Button;
//=======================================================================================================================
	
	public InventoryList_Page inventoryList_Adjustment_with_Valid_Inputs(Hashtable<String, String> ht)
			throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.clickonWebElement(Inventory_List_Adjustment, "Adjustment Button");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.bootstrapdropdownselection(Inventory_List_Adjustment_Select_Store, "inventory_select_Store",
				ht.get("Inventory List Store Name1"));

		driver.findElement(By.xpath("//input[@id='file']"))
				.sendKeys("C:\\Users\\sunil\\Test File Format\\Valid_INVENTORY_ADJUSTMENTS (1).csv");
		CommonMethod.clickonWebElement(Inventory_List_Adjustment_Upload_Button, "upload button");
		CommonMethod.clickonWebElement(Inventory_List_Import_OK_Button, "OK button");

		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement toastMessage = wait2
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@class='v-toast__text']")));

		if (toastMessage.isDisplayed()) {
			String Actual_Pagetitle = toastMessage.getText();

			Assert.assertEquals(Actual_Pagetitle, ht.get("Inventory Adjustment Successful Message"));
			System.out.println("Page title is verified and Title is: " + Actual_Pagetitle);
			test.pass(
					"The Pop-UP successful messge for inventoryList_Adjustment_with_Valid_Inputs is verified and the Pup-UP Message   is: "
							+ Actual_Pagetitle);
			CommonMethod.takescreenshot();
		} else {
			System.out.println("Toast message is not visible.");
		}

		Thread.sleep(3000);

		return this;
	}
//=========================================================================================================================
	public InventoryList_Page inventoryList_Adjustment_with_InValid_Inputs(Hashtable<String, String> ht)
			throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.clickonWebElement(Inventory_List_Adjustment, "Adjustment Button");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.bootstrapdropdownselection(Inventory_List_Adjustment_Select_Store, "inventory_select_Store",
				ht.get("Inventory List Store Name1"));

		driver.findElement(By.xpath("//input[@id='file']"))
				.sendKeys("C:\\Users\\sunil\\Test File Format\\Invalid_INVENTORY_ADJUSTMENTS (1).csv");
		CommonMethod.clickonWebElement(Inventory_List_Adjustment_Upload_Button, "upload button");
		CommonMethod.clickonWebElement(Inventory_List_Adjustment_OK_Button, "OK button");

		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement toastMessage = wait2
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@class='v-toast__text']")));

		if (toastMessage.isDisplayed()) {
			String Actual_Pagetitle = toastMessage.getText();

			Assert.assertEquals(Actual_Pagetitle, ht.get("Inventory Adjustment Unsuccessful Message"));
			System.out.println("Page title is verified and Title is: " + Actual_Pagetitle);
			test.pass(
					"The Pop-UP  messge for inventoryList_Adjustment_with_InValid_Inputs is verified and the Pup-UP error Message   is: "
							+ Actual_Pagetitle);
			CommonMethod.takescreenshot();
		} else {
			System.out.println("Toast message is not visible.");
		}

		Thread.sleep(3000);

		CommonMethod.clickonWebElement(Inventory_List_Adjustment_Close_Button, "Close button");

		return this;
	}
//========================================================================================================================
	
	public InventoryList_Page inventoryList_Adjustment_Error_Message_Without_Store(Hashtable<String, String> ht)
			throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.clickonWebElement(Inventory_List_Adjustment, "Adjustment Button");
		Thread.sleep(5000);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.clickonWebElement(Inventory_List_Adjustment_Upload_Button, "upload button");
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement toastMessage = wait2
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@class='v-toast__text']")));

		if (toastMessage.isDisplayed()) {
			String Actual_Pagetitle = toastMessage.getText();

			Assert.assertEquals(Actual_Pagetitle, ht.get("Inventory Adjustment Error Message for not selecting Store"));
			System.out.println("Page title is verified and Title is: " + Actual_Pagetitle);
			test.pass(
					"The Pop-UP  messge for  inventoryList_Adjustment_Error_Message_Without_Store is verified and the Pup-UP error Message   is: "
							+ Actual_Pagetitle);
			CommonMethod.takescreenshot();
		} else {
			System.out.println("Toast message is not visible.");
		}

		Thread.sleep(3000);

		CommonMethod.clickonWebElement(Inventory_List_Adjustment_Close_Button, "Close button");

		return this;
	}
//========================================================================================================================
	
	public InventoryList_Page inventoryList_Adjustment_Error_Message_Without_File(Hashtable<String, String> ht)
			throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.clickonWebElement(Inventory_List_Adjustment, "Adjustment Button");
		Thread.sleep(3000);
		CommonMethod.bootstrapdropdownselection(Inventory_List_Adjustment_Select_Store, "inventory_select_Store",
				ht.get("Inventory List Store Name1"));
		CommonMethod.clickonWebElement(Inventory_List_Adjustment_Upload_Button, "upload button");
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement toastMessage = wait2
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@class='v-toast__text']")));

		if (toastMessage.isDisplayed()) {
			String Actual_Pagetitle = toastMessage.getText();

			Assert.assertEquals(Actual_Pagetitle, ht.get("Inventory Adjustment Error Message for not selecting file"));
			System.out.println("Page title is verified and Title is: " + Actual_Pagetitle);
			test.pass(
					"The Pop-UP  messge for inventoryList_Adjustment_Error_Message_Without_File is verified and the Pup-UP error Message   is: "
							+ Actual_Pagetitle);
			CommonMethod.takescreenshot();
		} else {
			System.out.println("Toast message is not visible.");
		}

		Thread.sleep(3000);

		CommonMethod.clickonWebElement(Inventory_List_Adjustment_Close_Button, "Close button");

		return this;
	}
//======================================================================================================================
	// UPDATE TEST CASE-1

	public InventoryList_Page inventoryList_Import_Update_with_One_Valid_SKU_(Hashtable<String, String> ht)
			throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		String SKU = driver
				.findElement(By.xpath("//tbody/tr[1]/td[2]"))
				.getText();
		String Available_On_Hand = driver
				.findElement(By.xpath("//tbody/tr[1]/td[6]"))
				.getText();
		CommonMethod.clickonWebElement(Inventory_Import, "Import Button");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.clickonWebElement(Inventory_Import_update, "Import Update Button");

		Thread.sleep(3000);
		CommonMethod.bootstrapdropdownselection(Inventory_Import_Select_Store, "inventory_Import_SelectStore",
				ht.get("Inventory Import Store"));

		driver.findElement(By.xpath("//input[@id='file']"))
				.sendKeys("C:\\Users\\sunil\\Test File Format\\UAT_Valid_INVENTORY_Import__Update_1SKU.csv");
		CommonMethod.clickonWebElement(Inventory_Import_upload_button, "upload button");
		CommonMethod.clickonWebElement(Inventory_List_Adjustment_OK_Button, "OK button");
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement toastMessage = wait2
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@class='v-toast__text']")));

		if (toastMessage.isDisplayed()) {
			String Actual_Pagetitle = toastMessage.getText();

			Assert.assertEquals(Actual_Pagetitle, ht.get("Inventory Import Successful Message"));
			System.out.println("Page title is verified and Title is: " + Actual_Pagetitle);
			test.pass(
					"The Pop-UP Successful  messge for inventoryList_Import_Update_with_Valid_Data is verified and the Pup-UP Message   is: "
							+ Actual_Pagetitle);
			CommonMethod.takescreenshot();
		} else {
			System.out.println("Toast message is not visible.");
		}

		Thread.sleep(3000);
		CommonMethod.clickonWebElement(Inventory_List_Filter, "inventory List Filter");
		CommonMethod.clickonWebElement(Inventory_List_Filter_Reset, "inventory List Filter reset button");
		CommonMethod.entertextintoinputbox(Inventory_List_Filter_Search_Box,
				ht.get("Inventory List Search Data forUpdate with Single SKU file"));
		CommonMethod.bootstrapdropdownselection(Inventory_List_Filter_Select_STore,
				"Inventory_List_Filter_Select_STore", ht.get("Inventory List Filter Select Store1"));
		CommonMethod.clickonWebElement(Inventory_List_Filter_Outside, "Outside to avoid element overlaping");
		CommonMethod.clickonWebElement(Inventory_List_Filter_Apply, "Inventory List Filter Apply Button");
		
		Thread.sleep(3000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//table[@class='bh-table-compact']//tbody/tr")));
		
		String SKU1 = driver
				.findElement(By.xpath("//tbody/tr[1]/td[2]"))
				.getText();
		String Available_On_Hand1 = driver
				.findElement(By.xpath("//tbody/tr[1]/td[6]"))
				.getText();
		System.out.println(SKU1);
		test.pass("Entered SKU for before import through update is " + SKU
				+ "  and Available on Hand quantity for this SKU before update is " + Available_On_Hand);
		test.pass("PLEASE CHECK WHETHER AVAILABLE ON HAND QUANTITY IN DBEAVER BEFORE IMPORT THROUGH SKU IS "
				+ Available_On_Hand + " OR NOT ");

		test.pass("Entered SKU for import through update is " + SKU1
				+ "  and Available on Hand quantity for this SKU after update is " + Available_On_Hand1);
		test.pass("PLEASE CHECK WHETHER AVAILABLE ON HAND QUANTITY IN DBEAVER IS " + Available_On_Hand1 + " OR NOT ");

		return this;
	}
//======================================================================================================================
	// UPDATE TEST CASE-2

	public InventoryList_Page inventoryList_Import_Update_ErrorMessage_Without_Store(Hashtable<String, String> ht)
			throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.clickonWebElement(Inventory_Import, "Import Button");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.clickonWebElement(Inventory_Import_update, "Import Update Button");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//input[@id='file']"))
				.sendKeys("C:\\Users\\sunil\\Test File Format\\UAT_Valid_INVENTORY_Import__Update_1SKU.csv");
		CommonMethod.clickonWebElement(Inventory_Import_upload_button, "upload button");

		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement toastMessage = wait2
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@class='v-toast__text']")));

		if (toastMessage.isDisplayed()) {
			String Actual_Pagetitle = toastMessage.getText();

			Assert.assertEquals(Actual_Pagetitle, ht.get("Inventory Import Error Message for not selecting Store"));
			System.out.println("Page title is verified and Title is: " + Actual_Pagetitle);
			test.pass(
					"The Pop-UP  messge for inventoryList_Import_Update_ErrorMessage_with_Without_Store is verified and the Pup-UP error Message   is: "
							+ Actual_Pagetitle);
			CommonMethod.takescreenshot();
		} else {
			System.out.println("Toast message is not visible.");
		}

		Thread.sleep(3000);

		CommonMethod.clickonWebElement(Inventory_Import_cancel_button, "cancel button");

		return this;
	}
//======================================================================================================================
	// UPDATE TEST CASE-3

	public InventoryList_Page inventoryList_Import_Update_ErrorMessage_with_Without_File(Hashtable<String, String> ht)
			throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.clickonWebElement(Inventory_Import, "Import Button");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.clickonWebElement(Inventory_Import_update, "Import Update Button");
		CommonMethod.bootstrapdropdownselection(Inventory_Import_Select_Store, "inventory_Import_SelectStore",
				ht.get("Inventory Import Store"));
		Thread.sleep(3000);

		CommonMethod.clickonWebElement(Inventory_Import_upload_button, "upload button");

		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement toastMessage = wait2
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@class='v-toast__text']")));

		if (toastMessage.isDisplayed()) {
			String Actual_Pagetitle = toastMessage.getText();

			Assert.assertEquals(Actual_Pagetitle, ht.get("Inventory Import Error Message for not selecting file"));

			test.pass(
					"The Pop-UP  messge for inventoryList_Import_Update_ErrorMessage_with_Without_File is verified and the Pup-UP error Message   is: "
							+ Actual_Pagetitle);
			CommonMethod.takescreenshot();
		} else {
			System.out.println("Toast message is not visible.");
		}

		Thread.sleep(3000);

		CommonMethod.clickonWebElement(Inventory_Import_cancel_button, "cancel button");

		return this;
	}
//===================================================================================================================
	// UPDATE TEST CASE-4

	public InventoryList_Page inventoryList_Import_Update_with_InValid_Data_(Hashtable<String, String> ht)
			throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.clickonWebElement(Inventory_Import, "Import Button");
		CommonMethod.clickonWebElement(Inventory_Import_update, "Import Update Button");

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.bootstrapdropdownselection(Inventory_Import_Select_Store, "inventory_Import_SelectStore",
				ht.get("Inventory Import Store"));

		driver.findElement(By.xpath("//input[@id='file']"))
				.sendKeys("C:\\Users\\sunil\\Test File Format\\UAT_InValid_INVENTORY_Import__Update_1SKU.csv");
		CommonMethod.clickonWebElement(Inventory_Import_upload_button, "upload button");
		CommonMethod.clickonWebElement(Inventory_List_Adjustment_OK_Button, "OK button");
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement toastMessage = wait2
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@class='v-toast__text']")));

		if (toastMessage.isDisplayed()) {
			String Actual_Pagetitle = toastMessage.getText();

			Assert.assertEquals(Actual_Pagetitle, ht.get("Inventory Import Unsuccessful Message"));
			System.out.println("Page title is verified and Title is: " + Actual_Pagetitle);
			test.pass(
					"The Unsuccessful Pop-UP  messge for inventoryList_Import_Update_with_InValid_Data is verified and the Pup-UP error Message   is: "
							+ Actual_Pagetitle);
			CommonMethod.takescreenshot();
		} else {
			System.out.println("Toast message is not visible.");
		}

		Thread.sleep(3000);

		CommonMethod.clickonWebElement(Inventory_Import_cancel_button, "cancel button");

		return this;
	}

	// ======================================================================================================================
	// UPDATE TEST CASE-5

	public InventoryList_Page inventoryList_Import_Update_with_Three_Valid_SKU_(Hashtable<String, String> ht)
			throws InterruptedException {
		test.pass(" Test Case Name is InventoryList_Import_Update_with_Three_Valid_SKU_ Test Case");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		String SKU = driver
				.findElement(By.xpath("//tbody/tr[1]/td[2]"))
				.getText();
		String Available_On_Hand = driver
				.findElement(By.xpath("//tbody/tr[1]/td[6]"))
				.getText();
		CommonMethod.clickonWebElement(Inventory_Import, "Import Button");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.clickonWebElement(Inventory_Import_update, "Import Update Button");

		Thread.sleep(3000);
		CommonMethod.bootstrapdropdownselection(Inventory_Import_Select_Store, "inventory_Import_SelectStore",
				ht.get("Inventory Import Store"));

		driver.findElement(By.xpath("//input[@id='file']"))
				.sendKeys("C:\\Users\\sunil\\Test File Format\\UAT_INVENTORY_FORMAT_3_Vaild_SKU_Update.csv");
		CommonMethod.clickonWebElement(Inventory_Import_upload_button, "upload button");
		CommonMethod.clickonWebElement(Inventory_List_Adjustment_OK_Button, "OK button");
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement toastMessage = wait2
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@class='v-toast__text']")));

		if (toastMessage.isDisplayed()) {
			String Actual_Pagetitle = toastMessage.getText();

			Assert.assertEquals(Actual_Pagetitle, ht.get("Inventory Import Successful Message"));
			System.out.println("Page title is verified and Title is: " + Actual_Pagetitle);
			test.pass(
					"The Pop-UP Successful  messge for inventoryList_Import_Update_with_Valid_Data is verified and the Pup-UP Message   is: "
							+ Actual_Pagetitle);
			CommonMethod.takescreenshot();
		} else {
			System.out.println("Toast message is not visible.");
		}

		Thread.sleep(3000);

		Thread.sleep(3000);
		CommonMethod.clickonWebElement(Inventory_List_Filter, "inventory List Filter");
		CommonMethod.entertextintoinputbox(Inventory_List_Filter_Search_Box,
				ht.get("Inventory List Search Data for Update for three sku1"));
		CommonMethod.bootstrapdropdownselection(Inventory_List_Filter_Select_STore,
				"Inventory_List_Filter_Select_STore", ht.get("Inventory List Filter Select Store1"));
		CommonMethod.clickonWebElement(Inventory_List_Filter_Outside, "Outside to avoid element overlaping");
		CommonMethod.clickonWebElement(Inventory_List_Filter_Apply, "Inventory List Filter Apply Button");
		String SKU1 = driver
				.findElement(By.xpath("//tbody/tr[1]/td[2]"))
				.getText();
		String Available_On_Hand1 = driver
				.findElement(By.xpath("//tbody/tr[1]/td[6]"))
				.getText();
		System.out.println(SKU1);
		test.pass("Entered SKU for before import through update is " + SKU
				+ "  and Available on Hand quantity for this SKU before update is " + Available_On_Hand);
		test.pass("PLEASE CHECK WHETHER AVAILABLE ON HAND QUANTITY IN DBEAVER BEFORE IMPORT THROUGH SKU IS "
				+ Available_On_Hand + " OR NOT ");

		test.pass("Entered SKU for import through update is " + SKU1
				+ "  and Available on Hand quantity for this SKU after update is " + Available_On_Hand1);
		test.pass("PLEASE CHECK WHETHER AVAILABLE ON HAND QUANTITY IN DBEAVER IS " + Available_On_Hand1 + " OR NOT ");
		Thread.sleep(3000);
		CommonMethod.clickonWebElement(Inventory_List_Filter, "inventory List Filter");
		Thread.sleep(3000);
		CommonMethod.clickonWebElement(Inventory_List_Filter_Reset, "reset button");

		Thread.sleep(3000);

		CommonMethod.entertextintoinputbox(Inventory_List_Filter_Search_Box,
				ht.get("Inventory List Search Data for Update for three sku2"));
		CommonMethod.bootstrapdropdownselection(Inventory_List_Filter_Select_STore,
				"Inventory_List_Filter_Select_STore", ht.get("Inventory List Filter Select Store1"));
		CommonMethod.clickonWebElement(Inventory_List_Filter_Outside, "Outside to avoid element overlaping");
		CommonMethod.clickonWebElement(Inventory_List_Filter_Apply, "Inventory List Filter Apply Button");

		Thread.sleep(3000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//table[@class='bh-table-compact']//tbody/tr")));

		String SKU2 = driver.findElement(By.xpath("//tbody//tr//td[2]")).getText();
		String Available_On_Hand2 = driver.findElement(By.xpath("//tbody//tr//td[6]")).getText();

		test.pass("Entered SKU for import through update is " + SKU2
				+ "  and Available on Hand quantity for this SKU after update is " + Available_On_Hand2);
		test.pass("PLEASE CHECK WHETHER AVAILABLE ON HAND QUANTITY IN DBEAVER IS " + Available_On_Hand2 + " OR NOT ");
		Thread.sleep(3000);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.clickonWebElement(Inventory_List_Filter, "inventory List Filter");
		Thread.sleep(3000);
		CommonMethod.clickonWebElement(Inventory_List_Filter_Reset, "reset button");

		Thread.sleep(3000);

		CommonMethod.entertextintoinputbox(Inventory_List_Filter_Search_Box,
				ht.get("Inventory List Search Data for Update for three sku3"));
		CommonMethod.bootstrapdropdownselection(Inventory_List_Filter_Select_STore,
				"Inventory_List_Filter_Select_STore", ht.get("Inventory List Filter Select Store1"));
		CommonMethod.clickonWebElement(Inventory_List_Filter_Outside, "Outside to avoid element overlaping");
		CommonMethod.clickonWebElement(Inventory_List_Filter_Apply, "Inventory List Filter Apply Button");

		Thread.sleep(3000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//table[@class='bh-table-compact']//tbody/tr")));

		String SKU3 = driver.findElement(By.xpath("//tbody//tr//td[2]")).getText();
		String Available_On_Hand3 = driver.findElement(By.xpath("//tbody//tr//td[6]")).getText();

		test.pass("Entered SKU for import through update is " + SKU3
				+ "  and Available on Hand quantity for this SKU after update is " + Available_On_Hand3);
		test.pass("PLEASE CHECK WHETHER AVAILABLE ON HAND QUANTITY IN DBEAVER IS " + Available_On_Hand3 + " OR NOT ");
		Thread.sleep(3000);

		return this;
	}

//======================================================================================================================
// Filter Related Xpath

	@FindBy(xpath = "//span[contains(text(),'Filter')]")
	private static WebElement Inventory_List_Filter;

	@FindBy(xpath = "//input[@placeholder='Search']")
	private static WebElement Inventory_List_Filter_Search_Box;

	@FindBy(xpath = "//span[contains(text(),'Select Store')]")
	private static WebElement Inventory_List_Filter_Select_STore;

	@FindBy(xpath = "//span[contains(text(),'Apply')]")
	private static WebElement Inventory_List_Filter_Apply;

	@FindBy(xpath = "//span[@class='p-button-icon p-button-icon-left ri-restart-line ri-xl me-1']")
	private static WebElement Inventory_List_Filter_Reset;

	@FindBy(xpath = "//h4[@id='offcanvasRightLabel']")
	private static WebElement Inventory_List_Filter_Outside;

	@FindBy(xpath = "//span[contains(text(),'Close')]")
	private static WebElement Inventory_List_Filter_Close;
	
//======================================================================================================================
// FILE RESET TEST CASE-1

	public InventoryList_Page inventoryList_Import_File_Reset_with_One_Valid_SKU_(Hashtable<String, String> ht)
			throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.clickonWebElement(Inventory_Import, "Import Button");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.clickonWebElement(Inventory_Import_fileReset, "File Reset Button");
		Thread.sleep(3000);
		CommonMethod.bootstrapdropdownselection(Inventory_Import_Select_Store, "inventory_Import_SelectStore",
				ht.get("Inventory Import Store"));

		driver.findElement(By.xpath("//input[@id='file']"))
				.sendKeys("C:\\Users\\sunil\\Test File Format\\UAT_Valid_INVENTORY_Import_File_Reset_1SKU.csv");
		CommonMethod.clickonWebElement(Inventory_Import_upload_button, "upload button");
		CommonMethod.clickonWebElement(Inventory_List_Adjustment_OK_Button, "OK button");
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement toastMessage = wait2
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@class='v-toast__text']")));

		if (toastMessage.isDisplayed()) {
			String Actual_Pagetitle = toastMessage.getText();

			Assert.assertEquals(Actual_Pagetitle, ht.get("Inventory Import Successful Message"));
			System.out.println("Page title is verified and Title is: " + Actual_Pagetitle);
			test.pass(
					"The Pop-UP Successful  messge for inventoryList_Import_File_Reset_with_Valid_Data is verified and the Pup-UP Message   is: "
							+ Actual_Pagetitle);
			CommonMethod.takescreenshot();
		} else {
			System.out.println("Toast message is not visible.");
		}

		Thread.sleep(3000);
		CommonMethod.clickonWebElement(Inventory_List_Filter, "inventory List Filter");
		CommonMethod.entertextintoinputbox(Inventory_List_Filter_Search_Box,
				ht.get("Inventory List Search Data for File Reset with Single SKU file"));
		CommonMethod.bootstrapdropdownselection(Inventory_List_Filter_Select_STore,
				"Inventory_List_Filter_Select_STore", ht.get("Inventory List Filter Select Store1"));
		CommonMethod.clickonWebElement(Inventory_List_Filter_Outside, "Outside to avoid element overlaping");
		CommonMethod.clickonWebElement(Inventory_List_Filter_Apply, "Inventory List Filter Apply Button");

		return this;
	} 
// ==================================================================================================================
// FILE RESET TEST CASE-2

	public InventoryList_Page inventoryList_Import_FileReset_ErrorMessage_Without_Store(Hashtable<String, String> ht)
			throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		
		CommonMethod.clickonWebElement(Inventory_Import, "Import Button");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.clickonWebElement(Inventory_Import_fileReset, "Import Update Button");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//input[@id='file']"))
				.sendKeys("C:\\Users\\sunil\\Test File Format\\UAT_Valid_INVENTORY_Import_File_Reset_1SKU.csv");
		CommonMethod.clickonWebElement(Inventory_Import_upload_button, "upload button");

		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement toastMessage = wait2
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@class='v-toast__text']")));

		if (toastMessage.isDisplayed()) {
			String Actual_Pagetitle = toastMessage.getText();

			Assert.assertEquals(Actual_Pagetitle, ht.get("Inventory Import Error Message for not selecting Store"));
			System.out.println("Page title is verified and Title is: " + Actual_Pagetitle);
			test.pass(
					"The Pop-UP  messge for inventoryList_Import_Update_ErrorMessage_with_Without_Store is verified and the Pup-UP error Message   is: "
							+ Actual_Pagetitle);
			CommonMethod.takescreenshot();
		} else {
			System.out.println("Toast message is not visible.");
		}

		Thread.sleep(3000);

		CommonMethod.clickonWebElement(Inventory_Import_cancel_button, "cancel button");

		return this;
	}

	// ==================================================================================================================
	// FILE RESET TEST CASE-3

	public InventoryList_Page inventoryList_Import_FileReset_ErrorMessage_Without_File(Hashtable<String, String> ht)
			throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.clickonWebElement(Inventory_Import, "Import Button");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.clickonWebElement(Inventory_Import_fileReset, "Import Update Button");
		CommonMethod.bootstrapdropdownselection(Inventory_Import_Select_Store, "inventory_Import_SelectStore",
				ht.get("Inventory Import Store"));
		Thread.sleep(3000);

		CommonMethod.clickonWebElement(Inventory_Import_upload_button, "upload button");

		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement toastMessage = wait2
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@class='v-toast__text']")));

		if (toastMessage.isDisplayed()) {
			String Actual_Pagetitle = toastMessage.getText();

			Assert.assertEquals(Actual_Pagetitle, ht.get("Inventory Import Error Message for not selecting file"));

			test.pass(
					"The Pop-UP  messge for inventoryList_Import_Update_ErrorMessage_with_Without_File is verified and the Pup-UP error Message   is: "
							+ Actual_Pagetitle);
			CommonMethod.takescreenshot();
		} else {
			System.out.println("Toast message is not visible.");
		}

		Thread.sleep(3000);

		CommonMethod.clickonWebElement(Inventory_Import_cancel_button, "cancel button");

		return this;
	}

	// ==================================================================================================================
	// FILE RESET TEST CASE-4

	public InventoryList_Page inventoryList_Import_FileReset_with_InValid_Data_(Hashtable<String, String> ht)
			throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.clickonWebElement(Inventory_Import, "Import Button");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		Thread.sleep(3000);
		CommonMethod.clickonWebElement(Inventory_Import_fileReset, "Import reset Button");

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.bootstrapdropdownselection(Inventory_Import_Select_Store, "inventory_Import_SelectStore",
				ht.get("Inventory Import Store"));

		driver.findElement(By.xpath("//input[@id='file']"))
				.sendKeys("C:\\Users\\sunil\\Test File Format\\UAT_InValid_INVENTORY_File_Reset_1SKU.csv");
		CommonMethod.clickonWebElement(Inventory_Import_upload_button, "upload button");
		CommonMethod.clickonWebElement(Inventory_List_Adjustment_OK_Button, "OK button");
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement toastMessage = wait2
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@class='v-toast__text']")));

		if (toastMessage.isDisplayed()) {
			String Actual_Pagetitle = toastMessage.getText();

			Assert.assertEquals(Actual_Pagetitle, ht.get("Inventory Import Unsuccessful Message"));
			System.out.println("Page title is verified and Title is: " + Actual_Pagetitle);
			test.pass(
					"The Unsuccessful Pop-UP  messge for inventoryList_Import_Update_with_InValid_Data is verified and the Pup-UP error Message   is: "
							+ Actual_Pagetitle);
			CommonMethod.takescreenshot();
		} else {
			System.out.println("Toast message is not visible.");
		}

		Thread.sleep(3000);

		CommonMethod.clickonWebElement(Inventory_Import_cancel_button, "cancel button");

		return this;
	}
//======================================================================================================================
//File Reset Test Case-5
	public InventoryList_Page inventoryList_Import_File_Reset_with_Three_Valid_SKU_(Hashtable<String, String> ht)
			throws InterruptedException {
		test.pass(" Test Case Name is InventoryList_Import_File_Reset_with_Three_Valid_SKU_ Test Case");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		
		
		CommonMethod.clickonWebElement(Inventory_Import, "Import Button");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.clickonWebElement(Inventory_Import_fileReset, "Import reset Button");

		Thread.sleep(3000);
		CommonMethod.bootstrapdropdownselection(Inventory_Import_Select_Store, "inventory_Import_SelectStore",
				ht.get("Inventory Import Store"));

		driver.findElement(By.xpath("//input[@id='file']"))
				.sendKeys("C:\\Users\\sunil\\Test File Format\\UAT_INVENTORY_3_Vaild_SKU_File_Reset.csv");
		CommonMethod.clickonWebElement(Inventory_Import_upload_button, "upload button");
		CommonMethod.clickonWebElement(Inventory_List_Adjustment_OK_Button, "OK button");
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement toastMessage = wait2
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@class='v-toast__text']")));

		if (toastMessage.isDisplayed()) {
			String Actual_Pagetitle = toastMessage.getText();

			Assert.assertEquals(Actual_Pagetitle, ht.get("Inventory Import Successful Message"));
			System.out.println("Page title is verified and Title is: " + Actual_Pagetitle);
			test.pass(
					"The Pop-UP Successful  messge for inventoryList_Import_Update_with_Valid_Data is verified and the Pup-UP Message   is: "
							+ Actual_Pagetitle);
			CommonMethod.takescreenshot();
		} else {
			System.out.println("Toast message is not visible.");
		}

		Thread.sleep(3000);

		Thread.sleep(3000);
		CommonMethod.clickonWebElement(Inventory_List_Filter, "inventory List Filter");
		CommonMethod.clickonWebElement(Inventory_List_Filter_Reset, "reset button");
		CommonMethod.entertextintoinputbox(Inventory_List_Filter_Search_Box,
				ht.get("Inventory List Search Data for File Reset for three sku1"));
		CommonMethod.bootstrapdropdownselection(Inventory_List_Filter_Select_STore,
				"Inventory_List_Filter_Select_STore", ht.get("Inventory List Filter Select Store1"));
		CommonMethod.clickonWebElement(Inventory_List_Filter_Outside, "Outside to avoid element overlaping");
		CommonMethod.clickonWebElement(Inventory_List_Filter_Apply, "Inventory List Filter Apply Button");
		
		Thread.sleep(3000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//table[@class='bh-table-compact']//tbody/tr")));
		
		String SKU1 = driver
				.findElement(By.xpath("//tbody/tr[1]/td[2]"))
				.getText();
		String Available_On_Hand1 = driver
				.findElement(By.xpath("//tbody/tr[1]/td[6]"))
				.getText();
		System.out.println(SKU1);
		

		test.pass("Entered SKU for import through update is " + SKU1
				+ "  and Available on Hand quantity for this SKU after update is " + Available_On_Hand1);
		test.pass("PLEASE CHECK WHETHER AVAILABLE ON HAND QUANTITY IN DBEAVER IS " + Available_On_Hand1 + " OR NOT ");
		
		CommonMethod.clickonWebElement(Inventory_List_Filter, "inventory List Filter");
		
		CommonMethod.clickonWebElement(Inventory_List_Filter_Reset, "reset button");
		
		CommonMethod.entertextintoinputbox(Inventory_List_Filter_Search_Box,
				ht.get("Inventory List Search Data for File Reset for three sku2"));
		CommonMethod.bootstrapdropdownselection(Inventory_List_Filter_Select_STore,
				"Inventory_List_Filter_Select_STore", ht.get("Inventory List Filter Select Store1"));
		CommonMethod.clickonWebElement(Inventory_List_Filter_Outside, "Outside to avoid element overlaping");
		CommonMethod.clickonWebElement(Inventory_List_Filter_Apply, "Inventory List Filter Apply Button");
		
		Thread.sleep(3000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//table[@class='bh-table-compact']//tbody/tr")));
		
		String SKU2 = driver
				.findElement(By.xpath("//tbody/tr[1]/td[2]"))
				.getText();
		String Available_On_Hand2 = driver
				.findElement(By.xpath("//tbody/tr[1]/td[6]"))
				.getText();
		System.out.println(SKU2);
		

		test.pass("Entered SKU for import through update is " + SKU2
				+ "  and Available on Hand quantity for this SKU after update is " + Available_On_Hand2);
		test.pass("PLEASE CHECK WHETHER AVAILABLE ON HAND QUANTITY IN DBEAVER IS " + Available_On_Hand2 + " OR NOT ");
		CommonMethod.clickonWebElement(Inventory_List_Filter, "inventory List Filter");
		Thread.sleep(3000);
		CommonMethod.clickonWebElement(Inventory_List_Filter_Reset, "reset button");
		CommonMethod.entertextintoinputbox(Inventory_List_Filter_Search_Box,
				ht.get("Inventory List Search Data for File Reset for three sku3"));
		CommonMethod.bootstrapdropdownselection(Inventory_List_Filter_Select_STore,
				"Inventory_List_Filter_Select_STore", ht.get("Inventory List Filter Select Store1"));
		CommonMethod.clickonWebElement(Inventory_List_Filter_Outside, "Outside to avoid element overlaping");
		CommonMethod.clickonWebElement(Inventory_List_Filter_Apply, "Inventory List Filter Apply Button");
		
		Thread.sleep(3000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//table[@class='bh-table-compact']//tbody/tr")));
		
		String SKU3 = driver
				.findElement(By.xpath("//tbody/tr[1]/td[2]"))
				.getText();
		String Available_On_Hand3 = driver
				.findElement(By.xpath("//tbody/tr[1]/td[6]"))
				.getText();
		
		

		test.pass("Entered SKU for import through update is " + SKU3
				+ "  and Available on Hand quantity for this SKU after update is " + Available_On_Hand3);
		test.pass("PLEASE CHECK WHETHER AVAILABLE ON HAND QUANTITY IN DBEAVER IS " + Available_On_Hand3 + " OR NOT ");
	
		return this;
	}
//======================================================================================================================
	// these xpaths are for edit inventory screen

	@FindBy(xpath = "//tbody/tr[1]/td[14]/i[1]")
	private static WebElement Inventory_List_Edit;

	@FindBy(xpath = "//tbody/tr[1]/td[14]/i[1]")
	private static WebElement Inventory_List_Available_On_Hand;

	@FindBy(xpath = "//input[@id='safetyBuffer']")
	private static WebElement Inventory_List_safetyBuffer;

	@FindBy(xpath = "//input[@id='reorderThresold']")
	private static WebElement Inventory_List_reorderThresold;

	@FindBy(xpath = "//textarea[@id='message']")
	private static WebElement Inventory_List_message;

	@FindBy(xpath = "//button[@aria-label='Update']")
	private static WebElement Inventory_List_Update;

	@FindBy(xpath = "//button[@aria-label='Cancel']")
	private static WebElement Inventory_List_Cancel;

	public InventoryList_Page inventoryList_Edit_Inventory(Hashtable<String, String> ht) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.clickonWebElement(Inventory_List_Edit, "Edit");
		Inventory_List_reorderThresold.sendKeys(Keys.BACK_SPACE);
		CommonMethod.entertextintoinputbox(Inventory_List_reorderThresold,
				ht.get("Edit Inventory Reorder Threshold Value"));
		CommonMethod.entertextintoinputbox(Inventory_List_message, ht.get("Edit Inventory Inventory Update Reason"));
		CommonMethod.clickonWebElement(Inventory_List_Update, "Update");
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement toastMessage = wait2
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@class='v-toast__text']")));

		if (toastMessage.isDisplayed()) {
			String Actual_Pagetitle = toastMessage.getText();

			Assert.assertEquals(Actual_Pagetitle, ht.get("Edit Inventory Successful Message "));

			test.pass("The Pop-UP  messge for successful Edit Inventory    is: " + Actual_Pagetitle);
			CommonMethod.takescreenshot();
		} else {
			System.out.println("Toast message is not visible.");
		}

		return this;
	}

	public InventoryList_Page inventoryList_Edit_Inventory_For_PartiCular_SKU(Hashtable<String, String> ht)
			throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.clickonWebElement(Inventory_List_Filter, "inventory List Filter");
		CommonMethod.entertextintoinputbox(Inventory_List_Filter_Search_Box,
				ht.get("Inventory List Search SKU for Edit Inventory"));
		CommonMethod.bootstrapdropdownselection(Inventory_List_Filter_Select_STore,
				"Inventory_List_Filter_Select_STore", ht.get("Inventory List Filter Select Store1"));
		CommonMethod.clickonWebElement(Inventory_List_Filter_Outside, "Outside to avoid element overlaping");
		CommonMethod.clickonWebElement(Inventory_List_Filter_Apply, "Inventory List Filter Apply Button");
Thread.sleep(3000);
		CommonMethod.clickonWebElement(Inventory_List_Edit, "Edit");
		driver.findElement(By.xpath("//input[@id='reorderThresold']")).sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.xpath("//input[@id='reorderThresold']")).sendKeys(Keys.BACK_SPACE);
		CommonMethod.entertextintoinputbox(Inventory_List_reorderThresold,
				ht.get("Edit Inventory Reorder Threshold Value"));
		CommonMethod.entertextintoinputbox(Inventory_List_message, ht.get("Edit Inventory Inventory Update Reason"));
		CommonMethod.entertextintoinputbox(Inventory_List_message, ht.get("Edit Inventory Inventory Update Reason"));
		
		CommonMethod.clickonWebElement(Inventory_List_Update, "Update");
		return this;
	}

	public InventoryList_Page inventoryList_filter_Operation(Hashtable<String, String> ht) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		
		CommonMethod.clickonWebElement(Inventory_List_Filter, "inventory List Filter");
		CommonMethod.clickonWebElement(Inventory_List_Filter_Reset, "inventory List Filter reset button");
		CommonMethod.entertextintoinputbox(Inventory_List_Filter_Search_Box,
				ht.get("Inventory List Search SKU for Edit Inventory"));
		CommonMethod.bootstrapdropdownselection(Inventory_List_Filter_Select_STore,
				"Inventory_List_Filter_Select_STore", ht.get("Inventory List Filter Select Store1"));
		CommonMethod.clickonWebElement(Inventory_List_Filter_Outside, "Outside to avoid element overlaping");
		CommonMethod.clickonWebElement(Inventory_List_Filter_Apply, "Inventory List Filter Apply Button");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.clickonWebElement(Inventory_List_Filter, "inventory List Filter");
		CommonMethod.clickonWebElement(Inventory_List_Filter_Reset, "inventory List Filter");
		CommonMethod.clickonWebElement(Inventory_List_Filter_Close, "inventory List Filter");
		return this;
	}

	public InventoryList_Page inventoryList_Table_Validation(Hashtable<String, String> ht) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		List<WebElement> row = driver
				.findElements(By.xpath("//*[@id=\"view\"]/div[2]/div/div/div[3]/div[1]/div[1]/table/tbody/tr")); // row
																													// count
		List<WebElement> column = driver.findElements(By.xpath("//th[@class='bh-select-none bh-z-[1]']")); // column
		test.pass(
				"row count for the table is " + row.size() + "Header count for the Inventory list is" + column.size()); // count
		System.out.println(row.size());
		System.out.println(column.size());
		Assert.assertEquals(column.size(), 14, "column count is not same");
		boolean status = false;
		for (WebElement ele : column) {
			String header = ele.getText();
			test.pass(header);

		}

		return this;
	}
//=======================================================================================================================
//

}