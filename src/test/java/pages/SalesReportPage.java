package pages;

import java.sql.SQLException;
import java.time.Duration;
import java.util.Hashtable;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.proenx.rdep.myproject.TestBase;

import MposPages.QA_Mpos_Signin_Page;
import MposPages.QA_Mpos_Signin_Page_Existing_APK;
import utility.CommonMethod;
import utility.OrderTable_Mpos_Bill_ID;

public class SalesReportPage extends TestBase {

	public SalesReportPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h6[normalize-space()='Sales Report']")
	private static WebElement SalesReporttext;

	@FindBy(xpath = "//span[@class='p-button-icon ri-download-2-fill ri-xl']")
	private static WebElement SalesReportdownloadbutton;

	@FindBy(xpath = "//i[@class='ri-filter-2-fill ps-1 pe-1']")
	private static WebElement SalesReportFilterbutton;

	@FindBy(xpath = "//a[normalize-space()='10031110334']")
	private static WebElement SalesReportBillIDHyperlink;

	@FindBy(xpath = "//a[@class='p-menuitem-link']//span[contains(text(),'Orders')]")
	private static WebElement SalesReportORDERBredcrunch;

	@FindBy(xpath = "//span[normalize-space()='Home']")
	private static WebElement SalesReportHOMEBredcrunch;

	@FindBy(xpath = "//span[normalize-space()='Apply']")
	private static WebElement SalesReportAPPLYButtoninfilter;

	@FindBy(xpath = "//button[@aria-label='Close']")
	private static WebElement SalesReportCLOSEButtoninfilter;

	@FindBy(xpath = "//i[@class='ri-restart-line ri-1x']")
	private static WebElement SalesReportRESETButtoninfilter;

	@FindBy(xpath = "//div[@class='text']")
	private static WebElement SalesReportRDEPnameandLOGO;

	@FindBy(xpath = "//button[@class='mx-btn mx-btn-text mx-btn-current-year']")
	private static WebElement currentYear;

	@FindBy(xpath = "//button[@class='mx-btn mx-btn-text mx-btn-current-month']")
	private static WebElement currentmonth;

	@FindBy(xpath = "//i[@class='mx-icon-double-right']")
	private static WebElement clickonnextyear;

	@FindBy(xpath = "//i[@class='mx-icon-double-left']")
	private static WebElement clickedonpreviousyear;

	@FindBy(xpath = "//i[@class='mx-icon-right']")
	private static WebElement clickonnextmonth;

	@FindBy(xpath = "//i[@class='mx-icon-left']")
	private static WebElement clickonpreviousmonth;

	@FindBy(xpath = "//div[@class='px-1 py-2']//div[@class='col-12']//input[@placeholder='Select Date']")
	private static WebElement clickedonstartdatecalenderfield;

	@FindBy(xpath = "//div[@class='col-12 mt-2']//input[@placeholder='Select Date']")
	private static WebElement clickedon_end_date_calenderfield;

	@FindBy(xpath = "//div[normalize-space()='25']")
	private static WebElement ClickedonPastcalenderday;

	@FindBy(xpath = "//span[contains(text(),'Select Store')]")
	private static WebElement clickonselectstoreoption;

	@FindBy(xpath = "//*[@id=\"offcanvasRight\"]/div[2]/div/div[4]/div/div[3]//ul//span//span")
	private static WebElement clickonparticulastore;

	@FindBy(xpath = "//span[contains(text(),'Select Status')]")
	private static WebElement clickonselectstatus;

	@FindBy(xpath = "//*[@id=\"offcanvasRight\"]/div[2]/div/div[7]/div/div[3]//ul//span//span\r\n" + "")
	private static WebElement clickonparticularStatus;

	@FindBy(xpath = "//span[contains(text(),'Select Delivery Status')]")
	private static WebElement clickonselectDeliverystatus;

	@FindBy(xpath = "//span[@class='multiselect__option--highlight multiselect__option']//input[@value='Canceled']")
	private static WebElement clickonparticularDelveryStatus1;

	@FindBy(xpath = "//span[normalize-space()='Close']")
	private static WebElement closebutton;

	@FindBy(xpath = "//button[@title='Reset']")
	private static WebElement resetbutton;

	@FindBy(xpath = "//button[@title='CSV']")
	private static WebElement Download;

	@FindBy(xpath = "//p[@class='v-toast__text']")
	private static WebElement ActualSalesreportpopupmessage;

	@FindBy(xpath = "//span[contains(text(),'Download')]")
	private static WebElement Download_Button;

	@FindBy(xpath = "//span[@class='bh-mr-2']")
	private static WebElement SalesReport_table_pagination_Message;

	@FindBy(xpath = "//span[normalize-space()='Manage']")
	private static WebElement Manage_Menu;

	@FindBy(xpath = "//span[normalize-space()='Data Jobs']")
	private static WebElement DataJobs_SubMenu;

	@FindBy(xpath = "//span[normalize-space()='Orders']")
	private static WebElement Order_Menu;

	@FindBy(xpath = "//div[@class='submenu__container show-submenu']//li[2]")
	private static WebElement Sales_Report_SubMenu;

	@FindBy(xpath = "//div[@class='submenu__container show-submenu']//li[2]")
	private static WebElement Clicked_on_Element_to_avoid_Element;

	@FindBy(xpath = "//button[@class='btn-close text-reset']")
	private static WebElement BillID_Hyperlink_Close_Button;

	@FindBy(xpath = "//button[normalize-space()='Create Delivery']")
	private static WebElement Create_Delivery_Button;

	@FindBy(xpath = "//*[@id=\"SalesReportBillIdCanvas\"]/div[2]/div/div[1]/div/div/div/div[3]/div/div/div[2]/form/div[1]/div[9]/table/tbody/tr/td[1]/input")
	private static WebElement Delivery_Items;

	@FindBy(xpath = "//span[normalize-space()='Create']")
	private static WebElement Delivery_Items_Create;

	@FindBy(xpath = "//label[normalize-space()='Store']")
	private static WebElement outsideclick;

	@FindBy(xpath = "//label[normalize-space()='Store']")
	private static WebElement Global_Search_Key;

	public SalesReportPage Sales_Filter_with_validdata(Hashtable<String, String> ht) throws InterruptedException {
		// goto startdate-> enddate-> select store-> select source->select
		// status->select delivery status->apply
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));

		CommonMethod.clickonWebElement(SalesReportFilterbutton, "filter button");
		CommonMethod.clickonWebElement(resetbutton, "Reset button");
		CommonMethod.inputCalenderDate(clickedonstartdatecalenderfield, ht.get("Sales Report Start Date Format"));
		CommonMethod.clickonWebElement("outsideclick", "clicked on outside");
		// store selection data will come from prop file (please keep in mind )
		CommonMethod.bootstrapdropdownselection(clickonselectstoreoption, "clickon_Particular_Sales_Store",
				ht.get("StoreName1"));
		CommonMethod.clickonWebElement(outsideclick, "clicked on outside");

		CommonMethod.clickonWebElement(SalesReportAPPLYButtoninfilter, "Apply Button");

		return this;
	}

	public SalesReportPage Sales_Report_Download_Conformation_Test(Hashtable<String, String> ht)
			throws InterruptedException {
		// Download button-> filter Button-> Apply -> reset->close
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		Thread.sleep(3000);
		CommonMethod.clickonWebElement(SalesReportFilterbutton, "filter button");
		CommonMethod.clickonWebElement(SalesReportRESETButtoninfilter, "Reset Button to reset old data");

		CommonMethod.inputCalenderDate(clickedonstartdatecalenderfield, ht.get("Sales Report Start Date Format"));
		CommonMethod.clickonWebElement("outsideclick", "clicked on outside");
		CommonMethod.clickonWebElement(SalesReportAPPLYButtoninfilter, "Apply Button");

		CommonMethod.clickonWebElement(Download, "Download Filter");
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Download_Button);
		CommonMethod.clickonWebElement(Download_Button, "Download button");

		int maxAttempts = 3; // Set maximum retry attempts
		int attempt = 0;
		boolean isDownloadSuccessful = false;

		while (attempt < maxAttempts) {
			// Step 1: Get pagination data
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
					SalesReport_table_pagination_Message);
			String pagination = SalesReport_table_pagination_Message.getText();
			System.out.println(pagination);
			int pages = Integer
					.parseInt(pagination.substring(pagination.indexOf("of") + 3, pagination.indexOf("items")).trim());
			System.out.println(pages);
			String pagesStr = String.valueOf(pages);
			test.pass("Attempt: " + (attempt + 1) + ", Expected Items to be downloaded is : " + pagesStr);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Manage_Menu);

			CommonMethod.clickonWebElement(Manage_Menu, "Manage Menu");
			CommonMethod.clickonWebElement(DataJobs_SubMenu, "Data Jobs SubMenu");

			Thread.sleep(3000);

			WebElement DS = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tbody/tr[1]/td[10]")));

			String dataJobsStatus = driver.findElement(By.xpath("//tbody/tr[1]/td[10]")).getText().trim();
			String dataJobsRecord = driver.findElement(By.xpath("//tbody/tr[1]/td[6]")).getText().trim();

			// Step 4: Check if download is successful
			if (dataJobsStatus.equals("COMPLETED") && dataJobsRecord.equals(pagesStr)) {
				test.pass("Sales Report data Downloaded Successfully through Data Jobs");
				isDownloadSuccessful = true;
				break; // Exit loop if successful
			} else {
				test.pass("Download not completed, retrying...");

				// Step 5: Retry Download Process
				CommonMethod.clickonWebElement(Order_Menu, "Order Menu");
				CommonMethod.clickonWebElement(Sales_Report_SubMenu, "Sales Report Sub Menu");
				Thread.sleep(3000);
				CommonMethod.clickonWebElement(SalesReportFilterbutton, "filter button");

				CommonMethod.inputCalenderDate(clickedonstartdatecalenderfield,
						ht.get("Sales Report Start Date Format"));
				CommonMethod.clickonWebElement("outsideclick", "clicked on outside");
				CommonMethod.clickonWebElement(SalesReportAPPLYButtoninfilter, "Apply Button");
				CommonMethod.clickonWebElement(Download, "Download Filter");
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Download_Button);
				Thread.sleep(3000);
				CommonMethod.clickonWebElement(Download_Button, "Download button");
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
			}

			attempt++;
			Thread.sleep(5000); // Wait for 5 seconds before retrying
		}

		// If download was unsuccessful after all attempts, mark as fail
		if (!isDownloadSuccessful) {
			test.fail("File is not downloading through data jobs after " + maxAttempts + " attempts.");
		}
		CommonMethod.clickonWebElement(Order_Menu, "Order Menu");
		CommonMethod.clickonWebElement(Sales_Report_SubMenu, "Sales Report Sub Menu");

		// CommonMethod.getRowColNumber(ht.get("Table Data For Validation"));

		return this;
	}

	public SalesReportPage Sales_Report_All_Button(Hashtable<String, String> ht) throws InterruptedException {
		// Download button-> filter Button-> Apply -> reset->close
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));

		CommonMethod.clickonWebElement(SalesReportFilterbutton, "filter button");

		CommonMethod.clickonWebElement("outsideclick", "clicked on outside");
		CommonMethod.clickonWebElement(resetbutton, "Reset button");
		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", closebutton);
		CommonMethod.clickonWebElement(closebutton, "close button");
		CommonMethod.clickonWebElement(SalesReportFilterbutton, "filter button");
		CommonMethod.inputCalenderDate(clickedonstartdatecalenderfield, ht.get("Sales Report Start Date Format"));
		CommonMethod.clickonWebElement(SalesReportAPPLYButtoninfilter, "Apply Button");
//		CommonMethod.clickonWebElement(Download, "Download Filter");
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Download_Button);
//		//CommonMethod.clickonWebElement(Download_Button, "Download button");

		// CommonMethod.getRowColNumber(ht.get("Table Data For Validation"));

		return this;
	}

	public SalesReportPage Sales_Report_Toast_Message_Validation(Hashtable<String, String> ht)
			throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		Thread.sleep(3000);

		CommonMethod.clickonWebElement(SalesReportFilterbutton, "filter button");
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				SalesReportRESETButtoninfilter);
		CommonMethod.clickonWebElement(SalesReportRESETButtoninfilter, "Reset button");
		CommonMethod.inputCalenderDate(clickedonstartdatecalenderfield,
				ht.get("Sales Report Start Date Format for negative scenario"));
		// CommonMethod.entertextintoinputbox(clickedonstartdatecalenderfield, );
		CommonMethod.clickonWebElement("outsideclick", "clicked on outside");
		Thread.sleep(4000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				SalesReportAPPLYButtoninfilter);

		CommonMethod.clickonWebElement(SalesReportAPPLYButtoninfilter, "Apply Button");

		WebElement toastMessage = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@class='v-toast__text']")));

		if (toastMessage.isDisplayed()) {
			String Actual_Pagetitle = toastMessage.getText();

			Assert.assertEquals(Actual_Pagetitle, "No data found for selected filter.");

			test.pass(
					"The POP-UP error message displayed after validation, in case no data is present in the Sales Report table, is:"
							+ Actual_Pagetitle);
			CommonMethod.takescreenshot();
		} else {
			System.out.println("POP-UP Error Message is not Present on the UI screen ");
		}
		CommonMethod.clickonWebElement(SalesReportFilterbutton, "filter button");
		CommonMethod.inputCalenderDate(clickedonstartdatecalenderfield, ht.get("Sales Report Start Date Format"));
		CommonMethod.clickonWebElement(SalesReportAPPLYButtoninfilter, "Apply Button");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.clickonWebElement(Download, "Download Filter");
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Download_Button);
		CommonMethod.clickonWebElement(Download_Button, "Download button");

		WebElement toastMessage2 = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@class='v-toast__text']")));

		if (toastMessage2.isDisplayed()) {
			String Actual_Pagetitle2 = toastMessage2.getText();
			String[] actualLines = Actual_Pagetitle2.split("\r?\n"); // Split by newline
			String expectedMessage = "Request received to export.";

			Assert.assertTrue(Actual_Pagetitle2.contains(expectedMessage),
					"Expected message not found in the response. Actual: " + Actual_Pagetitle2);

			test.pass(
					"The POP-UP error message displayed after validation, in case no data is present in the Sales Report table, is:"
							+ Actual_Pagetitle2);
			CommonMethod.takescreenshot();
		} else {
			System.out.println("POP-UP Error Message is not Present on the UI screen ");
		}

//		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
//		WebElement toastMessage = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='v-toast__text']")));
//		String actualMessage = toastMessage.getText();
//		Assert.assertEquals(actualMessage, "Orders List not found");
//		

		return this;

	}

	public SalesReportPage Sales_Report_BillID_Hyperlink(Hashtable<String, String> ht) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.clickonWebElement(SalesReportFilterbutton, "filter button");
		CommonMethod.inputCalenderDate(clickedonstartdatecalenderfield, ht.get("Sales Report Start Date Format"));
		CommonMethod.clickonWebElement(SalesReportAPPLYButtoninfilter, "Apply Button");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		// CommonMethod.clickonWebElement(Download, "Download and csv file has been
		// downloaded");
		// CommonMethod.getRowColNumber(ht.get("BillID Hyperlink"));
		Thread.sleep(3000);
		CommonMethod.Hyperlink_Click(ht.get("BillID Hyperlink"));
		CommonMethod.takescreenshot();
		String Bill_ID = driver.findElement(By.xpath("//*[contains(text(), 'Bill ID')]")).getText();
		String Order_Date = driver.findElement(By.xpath("//*[contains(text(), 'Order Date')]")).getText();
		String Customer_Name = driver.findElement(By.xpath("//*[contains(text(), 'Customer Name')]")).getText();
		String Order_Status = driver.findElement(By.xpath("//*[contains(text(), 'Order Status')]")).getText();
		String Mobile_Number = driver.findElement(By.xpath("//*[contains(text(), 'Mobile Number')]")).getText();
		String Discount_Amount = driver.findElement(By.xpath("//*[contains(text(), 'Discount Amount')]")).getText();
		String Tax_Amount = driver.findElement(By.xpath("//*[contains(text(), 'Tax Amount')]")).getText();
		// String Tax_Amount=driver.findElement(By.xpath("//*[contains(text(), 'Tax
		// Amount')]")).getText();
		String Gross_Total = driver.findElement(By.xpath("//*[contains(text(), 'Gross Total')]")).getText();

		Assert.assertFalse(Bill_ID.contains("NA"), "The Bill_ID contains 'NA', but it shouldn't!");
		Assert.assertFalse(Order_Date.contains("NA"), "The Order_Date contains 'NA', but it shouldn't!");
		Assert.assertFalse(Customer_Name.contains("NA"), "The Customer_Name contains 'NA', but it shouldn't!");
		Assert.assertFalse(Order_Status.contains("NA"), "The Order_Status contains 'NA', but it shouldn't!");
		Assert.assertFalse(Mobile_Number.contains("NA"), "The Mobile_Number contains 'NA', but it shouldn't!");
		Assert.assertFalse(Discount_Amount.contains("NA"), "The Discount_Amount contains 'NA', but it shouldn't!");
		Assert.assertFalse(Tax_Amount.contains("NA"), "The Tax_Amount contains 'NA', but it shouldn't!");
		Assert.assertFalse(Gross_Total.contains("NA"), "The Gross_Total contains 'NA', but it shouldn't!");

		test.pass("Bill id is not having NA ");
		CommonMethod.takescreenshot();
		test.pass("Order Date is not having NA ");
		CommonMethod.takescreenshot();
		test.pass("Customer Name is not having NA ");
		CommonMethod.takescreenshot();
		test.pass("Order Status is not having NA ");
		CommonMethod.takescreenshot();

		test.pass("Mobile Number is not having NA ");
		CommonMethod.takescreenshot();
		test.pass("Discount Amount is not having NA ");
		CommonMethod.takescreenshot();
		test.pass("Tax_Amount is not having NA ");
		CommonMethod.takescreenshot();
		test.pass("Gross_Total is not having NA ");
		boolean isClickable = false;
		while (!isClickable) {
			try {

				CommonMethod.clickonWebElement(Create_Delivery_Button, "Clicked On Create Delivery button");
				Thread.sleep(3000);
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
				}

				// Locate all checkboxes inside the table
				List<WebElement> checkboxes = driver.findElements(
						By.xpath("//td[@class='tableData text-center py-2 px-0']//input[@type='checkbox']"));

				// Click each checkbox
				for (WebElement checkbox : checkboxes) {
					if (!checkbox.isSelected()) { // Avoid clicking if already checked
						checkbox.click();
					}
				}

				// Verify checkboxes are clicked (Optional)
				for (WebElement checkbox : checkboxes) {
					System.out.println("Checkbox selected: " + checkbox.isSelected());
				}

				CommonMethod.clickonWebElement(Delivery_Items_Create, "Create Button for Every Single Items");
				test.pass("Create Delivery option  found for this transaction and clicked on Create Delivery Button.");
				isClickable = true;
			} catch (Exception e) {
				test.pass("Create Delivery option  is not available for this transaction.");
			}
		}
		Thread.sleep(3000);
		CommonMethod.clickonWebElement(BillID_Hyperlink_Close_Button, "Close Button to close Bill id Hyper Link page");

		return this;

	}

	public SalesReportPage verify_total_numberof_items_in_sales_table(Hashtable<String, String> ht)
			throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.clickonWebElement(SalesReportFilterbutton, "filter button");

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", resetbutton);

		CommonMethod.clickonWebElement(resetbutton, "filter button");
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				clickedonstartdatecalenderfield);
		CommonMethod.inputCalenderDate(clickedonstartdatecalenderfield, ht.get("Sales Report Start Date Format"));
		CommonMethod.clickonWebElement("outsideclick", "clicked on outside");
		// store selection data will come from prop file (please keep in mind )
		CommonMethod.bootstrapdropdownselection(clickonselectstoreoption, "clickon_Particular_Sales_Store",
				ht.get("StoreName1"));
		CommonMethod.clickonWebElement("outsideclick", "clicked on outside");

		CommonMethod.clickonWebElement(SalesReportAPPLYButtoninfilter, "Apply Button");

		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//span[@class='bh-mr-2']"), "items"));
		WebElement text = driver.findElement(By.xpath("//span[@class='bh-mr-2']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", text);

		String s1 = driver.findElement(By.xpath("//span[@class='bh-mr-2']")).getText();
		System.out.println(s1);
		test.pass(s1);
		int ofIndex = s1.indexOf("of") + 3;
		int itemsIndex = s1.indexOf("items");
		int pages = Integer.parseInt(s1.substring(ofIndex, itemsIndex).trim());
		System.out.println("Items found: " + pages);
		test.pass("The number of items present in the table is " + pages);

		// Determine total pages based on whether count is even or odd
		int total_pages;
		if (pages > 1 && pages % 2 != 0) {
			total_pages = pages / 10 + 1;
		} else {
			total_pages = pages / 10;
		}

		test.pass("Total Pagepresent here in Sales Report Pagination is " + total_pages);
		CommonMethod.takescreenshot();

		// Wait object declaration
		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		for (int i = 1; i < total_pages; i++) {
			try {
				// Scroll to pagination area
				WebElement scroll = driver.findElement(By.xpath("//span[@class='bh-mr-2']"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scroll);

				// Find the pagination button again in each iteration
				WebElement pagination = driver.findElement(By.xpath("//button[@class='bh-page-item next-page']"));

				// Wait until pagination button is clickable (to avoid clicking too soon)

				wait.until(ExpectedConditions.elementToBeClickable(pagination));

				// Click using JavaScript Executor
				((JavascriptExecutor) driver)
						.executeScript("arguments[0].dispatchEvent(new Event('click', {bubbles: true}))", pagination);

				// Wait for page to load before next iteration
				Thread.sleep(3000);

			} catch (NoSuchElementException e) {
				System.out.println("Pagination button not found. Exiting loop.");
				break; // Exit loop if pagination button disappears (end of pages)
			}
		}
		driver.navigate().refresh();

		return this;
	}

	public SalesReportPage verify_Sales_Report_Table_Column_With_Filter(Hashtable<String, String> ht)
			throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		Thread.sleep(3000);

		CommonMethod.clickonWebElement(SalesReportFilterbutton, "filter button");
		CommonMethod.clickonWebElement(resetbutton, "filter button");

		CommonMethod.inputCalenderDate(clickedonstartdatecalenderfield, ht.get("Sales Report Start Date Format"));
		CommonMethod.clickonWebElement("outsideclick", "clicked on outside");
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				SalesReportAPPLYButtoninfilter);
		CommonMethod.clickonWebElement(SalesReportAPPLYButtoninfilter, "Apply Button");
		WebElement salesReportSection = driver.findElement(By.xpath("//div[contains(@class, 'container-fluid mt-1')]"));
		List<WebElement> elementsInsideSection = salesReportSection.findElements(By.xpath(".//*"));
		System.out.println("Total elements inside Sales Report section: " + elementsInsideSection.size());

		WebElement toastMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tbody/tr/td")));

		String Store_Code = driver.findElement(By.xpath("//tbody/tr[1]/td[1]")).getText();
		String User_Name = driver.findElement(By.xpath("//tbody/tr[1]/td[2]")).getText();
		String Device = driver.findElement(By.xpath("//tbody/tr[1]/td[3]")).getText();
		String Bill_ID = driver.findElement(By.xpath("//tbody/tr[1]/td[4]")).getText();
		String Created_Date = driver.findElement(By.xpath("//tbody/tr[1]/td[6]")).getText();
		String Manual_Bill = driver.findElement(By.xpath("//tbody/tr[1]/td[8]")).getText();
		String Transaction_Date = driver.findElement(By.xpath("//tbody/tr[1]/td[9]")).getText();
		String Gross_Total = driver.findElement(By.xpath("//tbody/tr[1]/td[10]")).getText();
		String Order_Status = driver.findElement(By.xpath("//tbody/tr[1]/td[14]/span[1]")).getText();
		String Sales_Agent = driver.findElement(By.xpath("//tbody/tr[1]/td[7]")).getText();

		System.out.println("sales gent name is " + Sales_Agent);
		Assert.assertNotEquals(Store_Code, "NA", "Store Code is showing NA");
		Assert.assertNotEquals(User_Name, "NA", "UserName is showing NA");
		Assert.assertNotEquals(Device, "NA", "Device is showing NA");
		Assert.assertNotEquals(Bill_ID, "NA", "Bill_ID is showing NA");
		Assert.assertNotEquals(Created_Date, "NA", "Created_Date is showing NA");
		Assert.assertNotEquals(Manual_Bill, "NA", "Manual_Bill is showing NA");
		Assert.assertNotEquals(Transaction_Date, "NA", "Transaction_Date is showing NA");
		Assert.assertNotEquals(Gross_Total, "NA", "Gross_Total is showing NA");
		Assert.assertNotEquals(Order_Status, "NA", "Order_Status is showing NA");

		return this;
	}

	public SalesReportPage verify_Sales_Report_With_Mpos_Transaction(Hashtable<String, String> ht) throws SQLException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(35));
		
		
		Actions actions = new Actions(driver);
		
		// Step 1: Hover over the magnifying glass icon
		WebElement searchIcon = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//i[@class='xe ri-search-line btn btn-primary']")));
		actions.moveToElement(searchIcon).perform();

		// Step 2: Wait for the input box to appear
		WebElement searchBox = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//input[@placeholder='Bill ID, Mobile Number']")));

		String ExpectedBillId = OrderTable_Mpos_Bill_ID.expectedBillId(test);

		System.out.println(ExpectedBillId);
		// Step 3: Send keys before it disappears
		searchBox.sendKeys(ExpectedBillId); // Enter your Bill ID or other search term

		searchIcon.click();

		WebElement UI_BillID = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody//tr//td[4]")));

		String billID = UI_BillID.getText();

		Assert.assertEquals(billID, ExpectedBillId, "Bill ID does not match the expected value.");
		test.pass("Bill ID matches the expected value: " + ExpectedBillId);

		CommonMethod.takescreenshot();

		return this;

	}
}