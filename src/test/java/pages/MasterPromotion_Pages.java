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

public class MasterPromotion_Pages extends TestBase {

	public MasterPromotion_Pages() {
		PageFactory.initElements(driver, this);
	} 
	
	@FindBy(xpath = "//span[@class='p-button-icon ri-download-2-fill ri-xl']")
	private static WebElement MasterPromotion_Download;
	
	@FindBy(xpath = "//span[contains(text(),'Create')]")
	private static WebElement MasterPromotion_Create;
	
	@FindBy(xpath = "//span[contains(text(),'Filter')]")
	private static WebElement MasterPromotion_Filter;
	
	@FindBy(xpath = "//span[@class='bh-mr-2']")
	private static WebElement MasterPromotion_tableitems;
	
	@FindBy(xpath = "//span[normalize-space()='Home']")
	private static WebElement MasterPromotion_Home_bredcrump;
	
	@FindBy(xpath = "//h6[normalize-space()='Master Promotions']")
	private static WebElement MasterPromotions_Text;
	
	@FindBy(xpath = "//div[@class='px-1 py-2']//div[@class='col-12']//input[@placeholder='Select Date']")
	private static WebElement clickedonstartdatecalenderfield;
	
	@FindBy(xpath = "//div[@class='col-12 mt-2']//input[@placeholder='Select Date']")
	private static WebElement clickedon_end_date_calenderfield;
	
	@FindBy(xpath = "//div[@class='multiselect__tags']")
	private static WebElement Select_Active_Dropdown;
	
	@FindBy(xpath = "//*[@id=\"offcanvasRight\"]/div[2]/div/div[4]/div/div[3]//ul//span//span")
	private static WebElement Select_True_False;
	
	@FindBy(xpath = "//span[contains(text(),'Apply')]")
	private static WebElement Promotion_Apply_Button;
	
	@FindBy(xpath = "//span[text()='Close']")
	private static WebElement Promotion_Close_Button;
	
	@FindBy(xpath = "//span[text()='Reset']")
	private static WebElement Promotion_Reset_Button;
	
	@FindBy(xpath = "//span[text()='Home']")
	private static WebElement Promotion_Home_Bredcrump_Button;
	
	@FindBy(xpath = "//span[text()='Create']")
	private static WebElement Promotion_Create_Button;
	
	
	public MasterPromotion_Pages clickOnDownload_Filter(Hashtable<String, String> ht) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));


		//CommonMethod.clickonWebElement(MasterPromotion_Download, "download button and file got downloaded");
	
		CommonMethod.clickonWebElement(MasterPromotion_Filter, "filter button");
				
		return this;

	}
	public MasterPromotion_Pages filterOperation(Hashtable<String, String> ht) throws InterruptedException {
		
		//CommonMethod.clickonWebElement(MasterPromotion_Filter, "filter button");
		CommonMethod.inputCalenderDate(clickedonstartdatecalenderfield, ht.get("Master Promotion Start Date Format"));
		CommonMethod.clickonWebElement("outsideclick", "clicked on outside");
		CommonMethod.inputCalenderDate(clickedon_end_date_calenderfield, ht.get("Master Promotion End Date Format"));	
		CommonMethod.clickonWebElement("outsideclick", "clicked on outside");
		CommonMethod.bootstrapdropdownselection(Select_Active_Dropdown, "Select_Active_Dropdown", ht.get("Active Status1"));
		CommonMethod.bootstrapdropdownselection(Select_Active_Dropdown, "Select_Active_Dropdown", ht.get("Active Status2"));
		CommonMethod.clickonWebElement("outsideclick", "clicked on outside");
		CommonMethod.clickonWebElement(Promotion_Apply_Button, "Apply Button");
		//CommonMethod.getRowColNumber("Buy 1 Top & Bottom get 15% OFF");
//		String s1=driver.findElement(By.xpath("//span[@class='bh-mr-2']")).getText();
//		System.out.println(s1);
		
		WebElement tableitem =driver.findElement(By.xpath("//span[@class='bh-mr-2']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tableitem);
		Thread.sleep(3000);
		String s1=tableitem.getText();
		System.out.println(s1);
		
		int pages=Integer.parseInt(s1.substring(s1.indexOf("of")+3, s1.indexOf("items")).trim());
		System.out.println(pages);
		String promotion=driver.findElement(By.xpath("//tbody/tr[1]")).getText();
		//int pagescount=pages/10;
		
		int pagescount = pages / 10;

		if (pages % 10 == 0) {
		    System.out.println("The pages count is "+ pagescount);
		    test.pass("The pages count is "+ pagescount);
		} else {
			int pagecount=pagescount+1;
		    System.out.println("The pages count is" + pagecount );
		    test.pass("The pages count is "+ pagecount);
		}

		
		System.out.println(pagescount);
		test.pass("Total Item present in the table is " + pages + "and the latest promotion is  " + promotion );
		
//		WebElement scrollup =driver.findElement(By.xpath("//h6[normalize-space()='Master Promotions']"));
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scrollup);
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='d-flex justify-content-end mb-1 mt-3']")));
//		scrollup.click();
		return this;

	}
	public MasterPromotion_Pages MasterPromo_filter_all_button(Hashtable<String, String> ht) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));


		//CommonMethod.clickonWebElement(MasterPromotion_Download, "download button and file got downloaded");
	
		CommonMethod.clickonWebElement(MasterPromotion_Filter, "filter button");
		CommonMethod.inputCalenderDate(clickedonstartdatecalenderfield, ht.get("Master Promotion Start Date Format"));
		CommonMethod.clickonWebElement("outsideclick", "clicked on outside");
		CommonMethod.inputCalenderDate(clickedon_end_date_calenderfield, ht.get("Master Promotion End Date Format"));	
		CommonMethod.clickonWebElement("outsideclick", "clicked on outside");
		CommonMethod.bootstrapdropdownselection(Select_Active_Dropdown, "Select_Active_Dropdown", ht.get("Active Status1"));
		CommonMethod.bootstrapdropdownselection(Select_Active_Dropdown, "Select_Active_Dropdown", ht.get("Active Status2"));
		CommonMethod.clickonWebElement("outsideclick", "clicked on outside");
		CommonMethod.clickonWebElement(Promotion_Apply_Button, "Apply Button");

		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));

		CommonMethod.clickonWebElement(MasterPromotion_Filter, "filter button");
		CommonMethod.clickonWebElement(Promotion_Reset_Button, "reset button");
		CommonMethod.clickonWebElement(Promotion_Close_Button, "Close button");
		
		
		
		return this;
	}
	
	public CreatePromotion_Page   create_Promotion(Hashtable<String, String> ht) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.clickonWebElement(Promotion_Create_Button, "create button");
		return new CreatePromotion_Page();
		
	}
	public CombinationPoolPage   create_Combination_Pool_Promotion(Hashtable<String, String> ht) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.clickonWebElement(Promotion_Create_Button, "create button");
		return new CombinationPoolPage();
		
	}
	
	public Package_Quantity_Page   create_Package_Quantity_Promotion(Hashtable<String, String> ht) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.clickonWebElement(Promotion_Create_Button, "create button");
		return new Package_Quantity_Page();
		
	}
}
