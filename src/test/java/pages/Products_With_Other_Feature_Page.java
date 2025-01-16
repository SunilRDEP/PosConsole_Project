package pages;

import java.awt.AWTException;
import java.time.Duration;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.proenx.rdep.myproject.TestBase;

import utility.CommonMethod;

public class Products_With_Other_Feature_Page  extends TestBase{
	public Products_With_Other_Feature_Page() {
		PageFactory.initElements(driver, this);
	} 
	
	
	@FindBy(xpath="")
	private static WebElement Products_Upload_images;
	
	@FindBy(xpath="//span[@class='m-1 me-1']//button[@type='button']")
	private static WebElement Products_Imports;
	
	@FindBy(xpath="//input[@id='defaultCatalog']")
	private static WebElement Products_Import_Default_Catalog_CheckBox;
	
	@FindBy(xpath="//input[@id='storeCatalog']")
	private static WebElement Products_Import_Store_Catalog_CheckBox;
	
	@FindBy(xpath="//span[normalize-space()='Store Group']")
	private static WebElement Products_Import_Select_Store_Group;
	
	@FindBy(xpath="//body//div[@id='app']//div[@class='row']//div[@class='row']//div[2]//div[1]//div[2]")
	private static WebElement Products_Import_Select_Store;
	
	@FindBy(xpath="//div[@class='col-12 col-lg-6']//input[@id='fileProduct']")
	private static WebElement Products_Imports_Select_File;
	
	@FindBy(xpath="//div[@class='d-flex justify-content-end']//button[@aria-label='Upload']")
	private static WebElement Products_Imports_File_Size_Instruction;
	
	@FindBy(xpath="//div[@class='d-flex align-items-center justify-content-between']//div//div//span[contains(text(),'Click here for File format')]")
	private static WebElement Products_Imports_Select_File_File_Format_Download;
	
	
	@FindBy(xpath="//div[@class='d-flex justify-content-end']//button[@aria-label='Upload']")
	private static WebElement Products_Imports_Upload;

	@FindBy(xpath="//div[@class='d-flex justify-content-end']//span[@class='p-button-label'][normalize-space()='Close']")
	private static WebElement Products_Imports_Close;
	
	

	@FindBy(xpath = "//button[@aria-label='Reset']")
	private static WebElement Inventory_Stock_Request_Inward_Filter_Reset_Button;

	
	@FindBy(xpath = "//span[contains(text(),'Filter')]")
	private static WebElement Products_Filter;

	@FindBy(xpath = "//input[@placeholder='Search']")
	private static WebElement Products_Filter_Search_Box;

	@FindBy(xpath = "//span[contains(text(),'Select Store')]")
	private static WebElement Products_Filter_Select_STore;

	@FindBy(xpath = "//span[contains(text(),'Apply')]")
	private static WebElement Products_Filter_Apply;

	@FindBy(xpath = "//span[@class='p-button-icon p-button-icon-left ri-restart-line ri-xl me-1']")
	private static WebElement Products_Filter_Reset;

	@FindBy(xpath = "//h4[@id='offcanvasRightLabel']")
	private static WebElement Products_Filter_Outside;

	@FindBy(xpath = "//span[contains(text(),'Close')]")
	private static WebElement ProductsFilter_Close;
	
	@FindBy(xpath = "//div[@class='text-white']//span[@class='nav__label'][normalize-space()='Dashboard']")
	private static WebElement Return_to_DashBoard;
	
	
	
	public Products_With_Other_Feature_Page SKU_Verification_For_InVentory_Inward_Request_with_File_Upload(Hashtable<String, String> ht) throws InterruptedException, AWTException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
	CommonMethod.clickonWebElement(Products_Filter, "Filter Button");
	CommonMethod.entertextintoinputbox(Products_Filter_Search_Box,
			ht.get("Product Sku1 for Inward with file upload"));
	CommonMethod.bootstrapdropdownselection(Products_Filter_Select_STore,
			"Products_Filter_Select_STore", ht.get("Select Store in product filter for file upload"));
	CommonMethod.clickonWebElement(Products_Filter_Outside, "Outside to avoid element overlaping");
	CommonMethod.clickonWebElement(Products_Filter_Apply, " Products Filter Apply Button");

	Thread.sleep(3000);
	wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.xpath("//table[@class='bh-table-compact']//tbody/tr")));

	String SKU1 = driver.findElement(By.xpath("//tbody//tr//td[1]")).getText();
	String Name = driver.findElement(By.xpath("//tbody//tr//td[2]")).getText();
Assert.assertEquals(SKU1, ht.get("Product Sku1 for Inward with file upload"));
test.pass("test is pass and the " + SKU1 +"is present in the table ");
//	test.pass("Entered SKU  through Adding Single Product  is " + SKU1
//			+ "  and Name for this SKU after Adding Single Product is " + Name);
//	test.pass("PLEASE CHECK WHETHER SKU in Product Table  after Adding Single Product IN DBEAVER IS " + SKU1 + " OR NOT ");
//	test.pass("PLEASE CHECK WHETHER Name in Product Table  after Adding Single Product IN DBEAVER IS " + Name + " OR NOT ");
//	
	Thread.sleep(3000);
	CommonMethod.clickonWebElement(Products_Filter, "Filter Button");
	CommonMethod.clickonWebElement(Inventory_Stock_Request_Inward_Filter_Reset_Button, "Reset Button");
	CommonMethod.entertextintoinputbox(Products_Filter_Search_Box,
			ht.get("Product Sku2 for Inward with file upload"));
	CommonMethod.bootstrapdropdownselection(Products_Filter_Select_STore,
			"Products_Filter_Select_STore", ht.get("Select Store in product filter for file upload"));
	CommonMethod.clickonWebElement(Products_Filter_Outside, "Outside to avoid element overlaping");
	CommonMethod.clickonWebElement(Products_Filter_Apply, " Products Filter Apply Button");

	Thread.sleep(3000);
	wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.xpath("//table[@class='bh-table-compact']//tbody/tr")));

	String SKU2 = driver.findElement(By.xpath("//tbody//tr//td[1]")).getText();
	String Name2 = driver.findElement(By.xpath("//tbody//tr//td[2]")).getText();
Assert.assertEquals(SKU2, ht.get("Product Sku2 for Inward with file upload"));
test.pass("test is pass and the " + SKU2 +"is present in the table and the name of the SKU is " +Name2);
//	test.pass("Entered SKU  through Adding Single Product  is " + SKU1
//			+ "  and Name for this SKU after Adding Single Product is " + Name);
//	test.pass("PLEASE CHECK WHETHER SKU in Product Table  after Adding Single Product IN DBEAVER IS " + SKU1 + " OR NOT ");
//	test.pass("PLEASE CHECK WHETHER Name in Product Table  after Adding Single Product IN DBEAVER IS " + Name + " OR NOT ");
//	
	Thread.sleep(3000);

	
	
return this;
}
	public DashBoardPages Return_to_Dashboard_Page(Hashtable<String, String> ht) throws InterruptedException, AWTException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
	CommonMethod.clickonWebElement(Return_to_DashBoard, "DashBoard to return homepage");
		return new DashBoardPages();
		
}

	public Products_With_Other_Feature_Page SKU_Verification_For_InVentory_Outward_Request_with_File_Upload(Hashtable<String, String> ht) throws InterruptedException, AWTException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
	CommonMethod.clickonWebElement(Products_Filter, "Filter Button");
	CommonMethod.entertextintoinputbox(Products_Filter_Search_Box,
			ht.get("Product Sku1 for outward with file upload"));
	CommonMethod.bootstrapdropdownselection(Products_Filter_Select_STore,
			"Products_Filter_Select_STore", ht.get("Select Store in product filter for file upload"));
	CommonMethod.clickonWebElement(Products_Filter_Outside, "Outside to avoid element overlaping");
	CommonMethod.clickonWebElement(Products_Filter_Apply, " Products Filter Apply Button");

	Thread.sleep(3000);
	wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.xpath("//table[@class='bh-table-compact']//tbody/tr")));

	String SKU1 = driver.findElement(By.xpath("//tbody//tr//td[1]")).getText();
	String Name = driver.findElement(By.xpath("//tbody//tr//td[2]")).getText();
Assert.assertEquals(SKU1, ht.get("Product Sku1 for outward with file upload"));
test.pass("test is pass and the " + SKU1 +"is present in the table ");
//	test.pass("Entered SKU  through Adding Single Product  is " + SKU1
//			+ "  and Name for this SKU after Adding Single Product is " + Name);
//	test.pass("PLEASE CHECK WHETHER SKU in Product Table  after Adding Single Product IN DBEAVER IS " + SKU1 + " OR NOT ");
//	test.pass("PLEASE CHECK WHETHER Name in Product Table  after Adding Single Product IN DBEAVER IS " + Name + " OR NOT ");
//	
	Thread.sleep(3000);
	CommonMethod.clickonWebElement(Products_Filter, "Filter Button");
	CommonMethod.clickonWebElement(Inventory_Stock_Request_Inward_Filter_Reset_Button, "Reset Button");
	CommonMethod.entertextintoinputbox(Products_Filter_Search_Box,
			ht.get("Product Sku2 for outward with file upload"));
	CommonMethod.bootstrapdropdownselection(Products_Filter_Select_STore,
			"Products_Filter_Select_STore", ht.get("Select Store in product filter for file upload"));
	CommonMethod.clickonWebElement(Products_Filter_Outside, "Outside to avoid element overlaping");
	CommonMethod.clickonWebElement(Products_Filter_Apply, " Products Filter Apply Button");

	Thread.sleep(3000);
	wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.xpath("//table[@class='bh-table-compact']//tbody/tr")));

	String SKU2 = driver.findElement(By.xpath("//tbody//tr//td[1]")).getText();
	String Name2 = driver.findElement(By.xpath("//tbody//tr//td[2]")).getText();
Assert.assertEquals(SKU1, ht.get("Product Sku1 for outward with file upload"));
test.pass("test is pass and the " + SKU2 +"is present in the table and the name of the SKU is " +Name2);
//	test.pass("Entered SKU  through Adding Single Product  is " + SKU1
//			+ "  and Name for this SKU after Adding Single Product is " + Name);
//	test.pass("PLEASE CHECK WHETHER SKU in Product Table  after Adding Single Product IN DBEAVER IS " + SKU1 + " OR NOT ");
//	test.pass("PLEASE CHECK WHETHER Name in Product Table  after Adding Single Product IN DBEAVER IS " + Name + " OR NOT ");
//	
	Thread.sleep(3000);

	
	
return this;
}
	public Products_With_Other_Feature_Page SKU_Verification_For_Outward_Request_with_Manual_SKU_Entry(Hashtable<String, String> ht) throws InterruptedException, AWTException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
	CommonMethod.clickonWebElement(Products_Filter, "Filter Button");
	CommonMethod.entertextintoinputbox(Products_Filter_Search_Box,
			ht.get("Product Sku1 for outward with Manual Entry"));
	CommonMethod.bootstrapdropdownselection(Products_Filter_Select_STore,
			"Products_Filter_Select_STore", ht.get("Select Store in product filter for Manual Entry"));
	CommonMethod.clickonWebElement(Products_Filter_Outside, "Outside to avoid element overlaping");
	CommonMethod.clickonWebElement(Products_Filter_Apply, " Products Filter Apply Button");

	Thread.sleep(3000);
	wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.xpath("//table[@class='bh-table-compact']//tbody/tr")));

	String SKU1 = driver.findElement(By.xpath("//tbody//tr//td[1]")).getText();
	String Name1 = driver.findElement(By.xpath("//tbody//tr//td[2]")).getText();
Assert.assertEquals(SKU1, ht.get("Product Sku1 for outward with Manual Entry"));
test.pass("test is pass and the " + SKU1 +"is present in the table and the name of the SKU is  " +Name1);
//	test.pass("Entered SKU  through Adding Single Product  is " + SKU1
//			+ "  and Name for this SKU after Adding Single Product is " + Name);
//	test.pass("PLEASE CHECK WHETHER SKU in Product Table  after Adding Single Product IN DBEAVER IS " + SKU1 + " OR NOT ");
//	test.pass("PLEASE CHECK WHETHER Name in Product Table  after Adding Single Product IN DBEAVER IS " + Name + " OR NOT ");
//	
	Thread.sleep(3000);
	
	CommonMethod.clickonWebElement(Products_Filter, "Filter Button");
	CommonMethod.clickonWebElement(Inventory_Stock_Request_Inward_Filter_Reset_Button, "Reset Button");
	CommonMethod.entertextintoinputbox(Products_Filter_Search_Box,
			ht.get("Product Sku2 for outward with Manual Entry"));
	CommonMethod.bootstrapdropdownselection(Products_Filter_Select_STore,
			"Products_Filter_Select_STore", ht.get("Select Store in product filter for Manual Entry"));
	CommonMethod.clickonWebElement(Products_Filter_Outside, "Outside to avoid element overlaping");
	CommonMethod.clickonWebElement(Products_Filter_Apply, " Products Filter Apply Button");

	Thread.sleep(3000);
	wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.xpath("//table[@class='bh-table-compact']//tbody/tr")));

	String SKU2 = driver.findElement(By.xpath("//tbody//tr//td[1]")).getText();
	String Name2 = driver.findElement(By.xpath("//tbody//tr//td[2]")).getText();
Assert.assertEquals(SKU2, ht.get("Product Sku2 for outward with Manual Entry"));
test.pass("test is pass and the " + SKU1 +"is present in the table and the name of the SKU is  " +Name2);
//	test.pass("Entered SKU  through Adding Single Product  is " + SKU1
//			+ "  and Name for this SKU after Adding Single Product is " + Name);
//	test.pass("PLEASE CHECK WHETHER SKU in Product Table  after Adding Single Product IN DBEAVER IS " + SKU1 + " OR NOT ");
//	test.pass("PLEASE CHECK WHETHER Name in Product Table  after Adding Single Product IN DBEAVER IS " + Name + " OR NOT ");
//	
	Thread.sleep(3000);

	
	
return this;
}
	public Products_With_Other_Feature_Page SKU_Verification_For_InVentory_Inward_Request_with_Manual_SKU_Entry(Hashtable<String, String> ht) throws InterruptedException, AWTException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
	CommonMethod.clickonWebElement(Products_Filter, "Filter Button");
	CommonMethod.entertextintoinputbox(Products_Filter_Search_Box,
			ht.get("SKU1 to enter manually to inward"));
	CommonMethod.bootstrapdropdownselection(Products_Filter_Select_STore,
			"Products_Filter_Select_STore", ht.get("Select Store in product filter for file upload"));
	CommonMethod.clickonWebElement(Products_Filter_Outside, "Outside to avoid element overlaping");
	CommonMethod.clickonWebElement(Products_Filter_Apply, " Products Filter Apply Button");

	Thread.sleep(3000);
	wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.xpath("//table[@class='bh-table-compact']//tbody/tr")));

	String SKU1 = driver.findElement(By.xpath("//tbody//tr//td[1]")).getText();
	String Name = driver.findElement(By.xpath("//tbody//tr//td[2]")).getText();
Assert.assertEquals(SKU1, ht.get("SKU1 to enter manually to inward"));
test.pass("test is pass and the " + SKU1 +"is present in the table ");
//	test.pass("Entered SKU  through Adding Single Product  is " + SKU1
//			+ "  and Name for this SKU after Adding Single Product is " + Name);
//	test.pass("PLEASE CHECK WHETHER SKU in Product Table  after Adding Single Product IN DBEAVER IS " + SKU1 + " OR NOT ");
//	test.pass("PLEASE CHECK WHETHER Name in Product Table  after Adding Single Product IN DBEAVER IS " + Name + " OR NOT ");
//	
	Thread.sleep(3000);
	CommonMethod.clickonWebElement(Products_Filter, "Filter Button");
	CommonMethod.clickonWebElement(Inventory_Stock_Request_Inward_Filter_Reset_Button, "Reset Button");
	CommonMethod.entertextintoinputbox(Products_Filter_Search_Box,
			ht.get("SKU2 to enter manually to inward"));
	CommonMethod.bootstrapdropdownselection(Products_Filter_Select_STore,
			"Products_Filter_Select_STore", ht.get("Select Store in product filter for file upload"));
	CommonMethod.clickonWebElement(Products_Filter_Outside, "Outside to avoid element overlaping");
	CommonMethod.clickonWebElement(Products_Filter_Apply, " Products Filter Apply Button");

	Thread.sleep(3000);
	wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.xpath("//table[@class='bh-table-compact']//tbody/tr")));

	String SKU2 = driver.findElement(By.xpath("//tbody//tr//td[1]")).getText();
	String Name2 = driver.findElement(By.xpath("//tbody//tr//td[2]")).getText();
Assert.assertEquals(SKU2, ht.get("SKU2 to enter manually to inward"));
test.pass("test is pass and the " + SKU2 +"is present in the table and the name of the SKU is " +Name2);
//	test.pass("Entered SKU  through Adding Single Product  is " + SKU1
//			+ "  and Name for this SKU after Adding Single Product is " + Name);
//	test.pass("PLEASE CHECK WHETHER SKU in Product Table  after Adding Single Product IN DBEAVER IS " + SKU1 + " OR NOT ");
//	test.pass("PLEASE CHECK WHETHER Name in Product Table  after Adding Single Product IN DBEAVER IS " + Name + " OR NOT ");
//	
	Thread.sleep(3000);

	
	
return this;
}
	
	
}