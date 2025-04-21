package pages;

import java.time.Duration;
import java.util.Hashtable;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.proenx.rdep.myproject.TestBase;

import utility.CommonMethod;

public class Article_Report extends TestBase {

	public Article_Report() {
		PageFactory.initElements( driver,this);
		
	}
	@FindBy(xpath = "//span[contains(text(),'Filter')]")
	private static WebElement ArticleReportFilterbutton;
	
	@FindBy(xpath = "//div[@class='px-1 py-2']//div[@class='col-12']//input[@placeholder='Select Date']")
	private static WebElement clickedonstartdatecalenderfield;
	
	@FindBy(xpath = "//span[contains(text(),'Select Store')]")
	private static WebElement clickonselectstoreoption;
	
	@FindBy(xpath = "//button[@aria-label='Apply']")
	private static WebElement Article_Report_APPLY_Buttoninfilter;
	
	@FindBy(xpath = "//button[@title='Reset']")
	private static WebElement SalesReportRESETButtoninfilter;
	
	@FindBy(xpath = "//i[@class='ri-file-download-line ri-xl']")
	private static WebElement Download;
	
	@FindBy(xpath = "//span[contains(text(),'Download')]")
	private static WebElement Download_Button;
	
	@FindBy(xpath = "//span[@class='bh-mr-2']")
	private static WebElement ArticleReport_table_pagination_Message;
	
	@FindBy(xpath = "//span[normalize-space()='Manage']")
	private static WebElement Manage_Menu;

	@FindBy(xpath = "//span[normalize-space()='Data Jobs']")
	private static WebElement DataJobs_SubMenu;
	
	@FindBy(xpath = "//span[normalize-space()='Orders']")
	private static WebElement Order_Menu;
	
	@FindBy(xpath = "//span[@class='nav__label'][normalize-space()='Article Report']")
	private static WebElement Article_Report_SubMenu;
	
	@FindBy(xpath = "//div[@class='submenu__container show-submenu']//li[2]")
	private static WebElement Clicked_on_Element_to_avoid_Element;
	
	@FindBy(xpath = "//span[contains(text(),'Filter')]")
	private static WebElement SalesReportFilterbutton;
	
	@FindBy(xpath = "//span[normalize-space()='Apply']")
	private static WebElement SalesReportAPPLYButtoninfilter;
	
	@FindBy(xpath = "//label[normalize-space()='Store']")
	private static WebElement outsideclick;
	
	@FindBy(xpath = "//button[@aria-label='Close']")
	private static WebElement BillID_Hyperlink_Close_Button;
	
	
	public Article_Report Article_Report_BillID_Hyperlink(Hashtable<String, String> ht) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.clickonWebElement(SalesReportFilterbutton, "filter button");
		CommonMethod.inputCalenderDate(clickedonstartdatecalenderfield, ht.get("Article Report Start Date Format"));
		CommonMethod.clickonWebElement(outsideclick, "clicked on outside");
		CommonMethod.clickonWebElement(SalesReportAPPLYButtoninfilter, "Apply Button");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		// CommonMethod.clickonWebElement(Download, "Download and csv file has been
		// downloaded");
		// CommonMethod.getRowColNumber(ht.get("BillID Hyperlink"));
		CommonMethod.Hyperlink_Click(ht.get("BillID Hyperlink"));
		CommonMethod.takescreenshot();
		String Bill_ID=driver.findElement(By.xpath("//*[contains(text(), 'Bill ID')]")).getText();
		String	Order_Date=driver.findElement(By.xpath("//*[contains(text(), 'Order Date')]")).getText();
		String	Customer_Name=driver.findElement(By.xpath("//*[contains(text(), 'Customer Name')]")).getText();
		String Order_Status=driver.findElement(By.xpath("//*[contains(text(), 'Order Status')]")).getText();
		String Mobile_Number=driver.findElement(By.xpath("//*[contains(text(), 'Mobile Number')]")).getText();
		String Discount_Amount=driver.findElement(By.xpath("//*[contains(text(), 'Discount Amount')]")).getText();
		String  Tax_Amount=driver.findElement(By.xpath("//*[contains(text(), 'Tax Amount')]")).getText();
		//String  Tax_Amount=driver.findElement(By.xpath("//*[contains(text(), 'Tax Amount')]")).getText();
		String Gross_Total=driver.findElement(By.xpath("//*[contains(text(), 'Gross Total')]")).getText();
		
		
		
		
		
		Assert.assertFalse(Bill_ID.contains("NA"), "The Bill_ID contains 'NA', but it shouldn't!");
		 Assert.assertFalse(Order_Date.contains("NA"), "The Order_Date contains 'NA', but it shouldn't!");
		 Assert.assertFalse(Customer_Name.contains("NA"), "The Customer_Name contains 'NA', but it shouldn't!");
		 Assert.assertFalse(Order_Status.contains("NA"), "The Order_Status contains 'NA', but it shouldn't!");
		 Assert.assertFalse(Mobile_Number.contains("NA"), "The Mobile_Number contains 'NA', but it shouldn't!");
		 Assert.assertFalse(Discount_Amount.contains("NA"), "The Discount_Amount contains 'NA', but it shouldn't!");
		 Assert.assertFalse(Tax_Amount.contains("NA"), "The Tax_Amount contains 'NA', but it shouldn't!");
		 Assert.assertFalse(Gross_Total.contains("NA"), "The Gross_Total contains 'NA', but it shouldn't!");
			
		 	
		 
		  test.pass("Bill id is not having NA " );
		  CommonMethod.takescreenshot();
		  test.pass("Order Date is not having NA " );
		  CommonMethod.takescreenshot();
		  test.pass("Customer Name is not having NA " );
		  CommonMethod.takescreenshot();
		  test.pass("Order Status is not having NA " );
		  CommonMethod.takescreenshot();
		  
		  test.pass("Mobile Number is not having NA " );
		  CommonMethod.takescreenshot();
		  test.pass("Discount Amount is not having NA " );
		  CommonMethod.takescreenshot();
		  test.pass("Tax_Amount is not having NA " );
		  CommonMethod.takescreenshot();
		  test.pass("Gross_Total is not having NA " );
		  driver.navigate().refresh();
		Thread.sleep(3000);
		  
		return this;

	}
	
	public Article_Report Article_Filter_with_validdata(Hashtable<String, String> ht) throws InterruptedException {
		// goto startdate-> enddate-> select store-> select source->select
		// status->select delivery status->apply
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		
		CommonMethod.clickonWebElement(ArticleReportFilterbutton, "filter button");
		CommonMethod.inputCalenderDate(clickedonstartdatecalenderfield, ht.get("Article Report Start Date Format"));
		CommonMethod.clickonWebElement("outsideclick", "clicked on outside");
		// store selection data will come from prop file (please keep in mind )
		CommonMethod.bootstrapdropdownselection(clickonselectstoreoption, "clickon_Particular_Sales_Store",
				ht.get("StoreName1"));
		CommonMethod.clickonWebElement(outsideclick, "clicked on outside");
		CommonMethod.clickonWebElement(SalesReportAPPLYButtoninfilter, "Apply Button");
		Thread.sleep(3000);
		CommonMethod.takescreenshot();
	return this;
	}
	
	public Article_Report Article_Report_Download_Conformation_Test(Hashtable<String, String> ht) throws InterruptedException {
		// Download button-> filter Button-> Apply -> reset->close
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		Thread.sleep(3000);
		CommonMethod.clickonWebElement(ArticleReportFilterbutton, "filter button");
		CommonMethod.clickonWebElement(SalesReportRESETButtoninfilter, "Reset Button to reset old data");

		CommonMethod.inputCalenderDate(clickedonstartdatecalenderfield, ht.get("Article Report Start Date Format"));
		CommonMethod.clickonWebElement(outsideclick, "clicked on outside");
		CommonMethod.clickonWebElement(SalesReportAPPLYButtoninfilter, "Apply Button");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.clickonWebElement(Download, "Download Filter");
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Download_Button);
		CommonMethod.clickonWebElement(Download_Button, "Download button");
		
		
		int maxAttempts = 3; // Set maximum retry attempts
		int attempt = 0;
		boolean isDownloadSuccessful = false;

		while (attempt < maxAttempts) {
			// Step 1: Get pagination data
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ArticleReport_table_pagination_Message);
			String pagination = ArticleReport_table_pagination_Message.getText();
			System.out.println(pagination);
			int pages = Integer
					.parseInt(pagination.substring(pagination.indexOf("of") + 3, pagination.indexOf("items")).trim());
			System.out.println(pages);
			String pagesStr = String.valueOf(pages);
			test.pass("Attempt: " + (attempt + 1) + ", Expected Items to be downloaded is : " + pagesStr);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Manage_Menu);
			
			CommonMethod.clickonWebElement(Manage_Menu, "Manage Menu");
			CommonMethod.clickonWebElement(DataJobs_SubMenu, "Data Jobs SubMenu");
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
			
			CommonMethod.takescreenshot();
			
			String dataJobsStatus = driver.findElement(By.xpath("//tbody/tr[1]/td[10]")).getText().trim();
			String dataJobsRecord = driver.findElement(By.xpath("//tbody/tr[1]/td[6]")).getText().trim();

			// Step 4: Check if download is successful
			if (dataJobsStatus.equals("COMPLETED") && dataJobsRecord.equals(pagesStr)) {
				test.pass("User  has downloaded data successfully");
				isDownloadSuccessful = true;
				break; // Exit loop if successful
			} else {
				test.pass("Download not completed, retrying...");

				// Step 5: Retry Download Process
				CommonMethod.clickonWebElement(Order_Menu, "Order Menu");
				CommonMethod.clickonWebElement(Article_Report_SubMenu, "Sales Report Sub Menu");
				Thread.sleep(3000);
				CommonMethod.clickonWebElement(SalesReportFilterbutton, "filter button");

				CommonMethod.inputCalenderDate(clickedonstartdatecalenderfield, ht.get("Article Report Start Date Format"));
				CommonMethod.clickonWebElement("outsideclick", "clicked on outside");
				CommonMethod.clickonWebElement(SalesReportAPPLYButtoninfilter, "Apply Button");
				CommonMethod.clickonWebElement(Download, "Download Filter");
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Download_Button);
				CommonMethod.clickonWebElement(Download_Button, "Download button");
			}

			attempt++;
			Thread.sleep(5000); // Wait for 5 seconds before retrying
		}

		// If download was unsuccessful after all attempts, mark as fail
		if (!isDownloadSuccessful) {
			test.fail("File is not downloading through data jobs after " + maxAttempts + " attempts.");
		}
		CommonMethod.clickonWebElement(Order_Menu, "Order Menu");
		CommonMethod.clickonWebElement(Article_Report_SubMenu, "Article Report Sub Menu");
		
		
		
		
		
		

		return this;
	}
	
	public Article_Report verify_total_numberof_items_in_article_table(Hashtable<String, String> ht)
			throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.clickonWebElement(SalesReportFilterbutton, "filter button");
		CommonMethod.clickonWebElement(SalesReportRESETButtoninfilter, "filter button");
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				clickedonstartdatecalenderfield);
		CommonMethod.inputCalenderDate(clickedonstartdatecalenderfield, ht.get("Article Report Start Date Format"));
		CommonMethod.clickonWebElement(outsideclick, "clicked on outside");
		// store selection data will come from prop file (please keep in mind )
		CommonMethod.bootstrapdropdownselection(clickonselectstoreoption, "clickon_Particular_Sales_Store",
				ht.get("StoreName1"));
		CommonMethod.clickonWebElement("outsideclick", "clicked on outside");

		CommonMethod.clickonWebElement(SalesReportAPPLYButtoninfilter, "Apply Button");

		String s1 = driver.findElement(By.xpath("//span[@class='bh-mr-2']")).getText();
		System.out.println(s1);
		test.pass(s1);
		int pages = Integer.parseInt(s1.substring(s1.indexOf("of") + 3, s1.indexOf("items")).trim());
		System.out.println(pages);

		test.pass("The number of items present in the table are " + pages);
		int total_pages = pages / 10 + 1;
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
				WebElement pagination = driver.findElement(By.xpath(
						"//button[@class='bh-page-item next-page']"));

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

		return this;
	}

}
