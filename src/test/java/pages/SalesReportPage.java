package pages;

import java.time.Duration;
import java.util.Hashtable;

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

public class SalesReportPage extends TestBase {

	public SalesReportPage() {
		PageFactory.initElements(driver, this);
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

	@FindBy(xpath = "//button[@aria-label='Apply']")
	private static WebElement SalesReportAPPLYButtoninfilter;

	@FindBy(xpath = "//button[@aria-label='Close']")
	private static WebElement SalesReportCLOSEButtoninfilter;

	@FindBy(xpath = "//button[@aria-label='Apply']")
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

	@FindBy(xpath = "//div[@id='offcanvasRight']//div[4]//div[1]//div[2]")
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

	@FindBy(xpath = "//button[@aria-label='Close']")
	private static WebElement closebutton;

	@FindBy(xpath = "//button[@aria-label='Reset']")
	private static WebElement resetbutton;

	@FindBy(xpath = "//button[@class='p-button p-component p-button-icon-only p-button-primary p-button-raised p-button-text p-button-small']")
	private static WebElement Download;

	@FindBy(xpath = "//p[@class='v-toast__text']")
	private static WebElement ActualSalesreportpopupmessage;

	public SalesReportPage Sales_Filter_with_validdata(Hashtable<String, String> ht) throws InterruptedException {
		// goto startdate-> enddate-> select store-> select source->select
		// status->select delivery status->apply
		Thread.sleep(3000);
		CommonMethod.clickonWebElement(SalesReportFilterbutton, "filter button");
		CommonMethod.inputCalenderDate(clickedonstartdatecalenderfield, ht.get("Sales Report Start Date Format"));
		CommonMethod.clickonWebElement("outsideclick", "clicked on outside");
		// store selection data will come from prop file (please keep in mind )
		CommonMethod.bootstrapdropdownselection(clickonselectstoreoption, "clickon_Particular_Sales_Store", ht.get("StoreName1"));
		CommonMethod.clickonWebElement("outsideclick", "clicked on outside");
		//CommonMethod.bootstrapdropdownselection(clickonselectstoreoption, "clickonparticulastore", ht.get("StoreName2"));
		// CommonMethod.scrollAndClick("clickonsourceselection", "source");
		//Thread.sleep(3000);
		//CommonMethod.clickonWebElement("outsideclick", "clicked on outside");
		CommonMethod.bootstrapdropdownselection(clickonselectstatus, "Selectstatus", ht.get("StatusName"));
		CommonMethod.clickonWebElement("outsideclick", "clicked on outside");
		CommonMethod.bootstrapdropdownselection(clickonselectDeliverystatus, "clickonparticularDelveryStatus",
				ht.get("DeliveryStatusName"));

		CommonMethod.clickonWebElement("outsideclick", "clicked on outside");
		CommonMethod.clickonWebElement(SalesReportAPPLYButtoninfilter, "Apply Button");

		return this;
	}

	public SalesReportPage Sales_Report_All_Button(Hashtable<String, String> ht) {
		// Download button-> filter Button-> Apply -> reset->close
		CommonMethod.clickonWebElement(SalesReportFilterbutton, "filter button");

		// CommonMethod.entertextintoinputbox(clickedonstartdatecalenderfield, );
		CommonMethod.clickonWebElement("outsideclick", "clicked on outside");
		CommonMethod.clickonWebElement(resetbutton, "Reset button");
		CommonMethod.clickonWebElement(closebutton, "close button");
		CommonMethod.clickonWebElement(SalesReportFilterbutton, "filter button");
		CommonMethod.inputCalenderDate(clickedonstartdatecalenderfield, ht.get("Sales Report Start Date Format"));
		CommonMethod.clickonWebElement(SalesReportAPPLYButtoninfilter, "Apply Button");
		CommonMethod.clickonWebElement(Download, "Download and csv file has been downloaded");
		CommonMethod.getRowColNumber(ht.get("Table Data For Validation"));

		return this;
	}

	public SalesReportPage Sales_Report_Toast_Message_Validation(Hashtable<String, String> ht)
			throws InterruptedException {
		CommonMethod.clickonWebElement(SalesReportFilterbutton, "filter button");
		CommonMethod.inputCalenderDate(clickedonstartdatecalenderfield,
				ht.get("Sales Report Start Date Format for negative scenario"));
		// CommonMethod.entertextintoinputbox(clickedonstartdatecalenderfield, );
		CommonMethod.clickonWebElement("outsideclick", "clicked on outside");
		Thread.sleep(4000);
		CommonMethod.clickonWebElement(SalesReportAPPLYButtoninfilter, "Apply Button");
		
//		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
//		WebElement toastMessage = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='v-toast__text']")));
//		String actualMessage = toastMessage.getText();
//		Assert.assertEquals(actualMessage, "Orders List not found");
//		
		
		
		CommonMethod.verifyTextOnThePage("ActualSalesreportpopupmessage",
				ht.get("POP Message For No Data in the Table"));
		return this;

	}
public SalesReportBillidHyperlink_Page Sales_Report_BillID_Hyperlink(Hashtable<String, String> ht) {
	
	CommonMethod.clickonWebElement(SalesReportFilterbutton, "filter button");
	CommonMethod.inputCalenderDate(clickedonstartdatecalenderfield, ht.get("Sales Report Start Date Format"));
	CommonMethod.clickonWebElement(SalesReportAPPLYButtoninfilter, "Apply Button");
	//CommonMethod.clickonWebElement(Download, "Download and csv file has been downloaded");
	//CommonMethod.getRowColNumber(ht.get("BillID Hyperlink"));
	CommonMethod.Hyperlink_Click(ht.get("BillID Hyperlink"));
	return new SalesReportBillidHyperlink_Page();
	

}

public SalesReportPage verify_total_numberof_items_in_sales_table(Hashtable<String, String> ht) throws InterruptedException {
	Thread.sleep(3000);
	CommonMethod.clickonWebElement(SalesReportFilterbutton, "filter button");
	CommonMethod.clickonWebElement(resetbutton, "filter button");
	
	CommonMethod.inputCalenderDate(clickedonstartdatecalenderfield, ht.get("Sales Report Start Date Format"));
	CommonMethod.clickonWebElement("outsideclick", "clicked on outside");
	// store selection data will come from prop file (please keep in mind )
	CommonMethod.bootstrapdropdownselection(clickonselectstoreoption, "clickon_Particular_Sales_Store", ht.get("StoreName1"));
	CommonMethod.clickonWebElement("outsideclick", "clicked on outside");
	
	CommonMethod.clickonWebElement(SalesReportAPPLYButtoninfilter, "Apply Button");
	
	String s1=driver.findElement(By.xpath("//span[@class='bh-mr-2']")).getText();
	System.out.println(s1);
	test.pass(s1);
	int pages=Integer.parseInt(s1.substring(s1.indexOf("of")+3, s1.indexOf("items")).trim());
	System.out.println(pages);
	test.pass("The date  and store entered to verify the items in the table are '2024-05-10 04:51 pm and Rdep Meta Limited Pune - 1765 and the expected items should be  " + pages );
	
	test.pass("The number of items present in the table is " + pages);
	return this;
}

}
