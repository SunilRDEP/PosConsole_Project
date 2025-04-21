package pages;

import java.time.Duration;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.proenx.rdep.myproject.TestBase;

import utility.CommonMethod;

public class Delivery_Report extends TestBase {
	public Delivery_Report() {
		PageFactory.initElements( driver,this);
		
	}
	@FindBy(xpath = "//h6[normalize-space()='Sales Report']")
	private static WebElement SalesReporttext;

	@FindBy(xpath = "//span[@class='p-button-icon ri-download-2-fill ri-xl']")
	private static WebElement SalesReportdownloadbutton;

	@FindBy(xpath = "//span[contains(text(),'Filter')]")
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

	@FindBy(xpath = "//i[@class='ri-restart-line ri-1x']")
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

	@FindBy(xpath = "//span[normalize-space()='Delivery Report']")
	private static WebElement Delivery_Report_SubMenu;

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
	
	
	public Delivery_Report Sales_Report_Download_Conformation_Test(Hashtable<String, String> ht)
			throws InterruptedException {
		// Download button-> filter Button-> Apply -> reset->close
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		Thread.sleep(3000);
		CommonMethod.clickonWebElement(SalesReportFilterbutton, "filter button");
		CommonMethod.clickonWebElement(SalesReportRESETButtoninfilter, "Reset Button to reset old data");

		CommonMethod.inputCalenderDate(clickedonstartdatecalenderfield, ht.get("Delivery Report Start Date Format"));
		CommonMethod.clickonWebElement(outsideclick, "clicked on outside");
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
				CommonMethod.clickonWebElement(Delivery_Report_SubMenu, "Delivery Report Sub-Menu");
				Thread.sleep(3000);
				CommonMethod.clickonWebElement(SalesReportFilterbutton, "filter button");

				CommonMethod.inputCalenderDate(clickedonstartdatecalenderfield,
						ht.get("Delivery Report Start Date Format"));
				CommonMethod.clickonWebElement(outsideclick, "clicked on outside");
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
		CommonMethod.clickonWebElement(Delivery_Report_SubMenu, "Delivry Report Sub Menu");

		// CommonMethod.getRowColNumber(ht.get("Table Data For Validation"));

		return this;
	}
}
