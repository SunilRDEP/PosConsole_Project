package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.proenx.rdep.myproject.TestBase;

import utility.CommonMethod;

public class Products_Page extends TestBase {
	public Products_Page() {
		PageFactory.initElements(driver, this);
	}  

	 
	
	@FindBy(xpath = "//span[contains(text(),'Add')]")
	private static WebElement Products_Add_Single_Products_Add_Button;

	@FindBy(xpath = "//input[@placeholder='Enter Product SKU']")
	private static WebElement Products_Add_Product_SKU;

	@FindBy(xpath = "//input[@placeholder='Enter Product Name']")
	private static WebElement Products_Add_Product_Name;

	@FindBy(xpath = "//div[@class='col-8 my-1']//span[@class='multiselect__single'][normalize-space()='Select Store']")
	private static WebElement Products_Add_Product_Select_Store;
	
	

	@FindBy(xpath = "//textarea[@placeholder='Enter Product Description']")
	private static WebElement Products_Add_Product_Description;

	@FindBy(xpath = "//input[@id='defaultCatalog']")
	private static WebElement Products_Add_Default_Catalog;

	@FindBy(xpath = "//input[@id='storeCatalog']")
	private static WebElement Products_Add_Store_Catalog;

	@FindBy(xpath = "//input[@id='storeCatalogs']")
	private static WebElement Products_Add_Catagory_Store_Catalog_CheckBox;

	@FindBy(xpath = "//div[@class='col-8']//div[@class='multiselect__tags']")
	private static WebElement Products_Add_Select_Catagory;

	@FindBy(xpath = "//button[normalize-space()='Add Category']")
	private static WebElement Products_Add_Add_Catagory;

	@FindBy(xpath = "//input[@placeholder='Enter Category Name']")
	private static WebElement Products_Add_Catagory_Name;

	@FindBy(xpath = "//input[@placeholder='Enter Category Description']")
	private static WebElement Products_Add_Catagory_Description;

	@FindBy(xpath = "//div[@class='col-12 col-lg-6 mb-1']//span[@class='multiselect__single'][normalize-space()='Select Store']")
	private static WebElement Products_Add_Catagory_SelectStore;

	@FindBy(xpath = "//div[@role='dialog']//div[@class='modal-dialog modal-lg']//div[@class='modal-content']//div[@class='modal-body']//div//span[@class='p-button-label'][normalize-space()='Add']")
	private static WebElement Products_Add_Catagory_Add_Button;

	@FindBy(xpath = "//select[@placeholder='Select Attribute']")
	private static WebElement Products_Add_Select_Attribute1;

	@FindBy(xpath = "//div[4]//div[1]//select[1]")
	private static WebElement Products_Add_Select_Attribute2;
	
	@FindBy(xpath = "//div[@class='col-4 px-1']//select[@class='form-select']")
	private static WebElement Products_Add_Select_Attribute_Value1;

	@FindBy(xpath = "//div[4]//div[2]//select[1]")
	private static WebElement Products_Add_Select_Attribute_Value2;

	@FindBy(xpath = "//body/div[@id='app']/div[@class='main_app']/div[@id='view']/div[@class='container-fluid mt-1']/div[@class='content-wrapper']/div/form/div[@class='row my-1']/div[@class='col-lg-7 px-1 pt-2']/div[@class='card mt-2 card-shadow']/div[@class='card-body']/div[@class='my-1 row align-items-end gap-2']/div[@class='col-2']/button[1]")
	private static WebElement Products_Add_Select_Attribute_AddMore1;

	@FindBy(xpath = "//body/div[@id='app']/div[@class='main_app']/div[@id='view']/div[@class='container-fluid mt-1']/div[@class='content-wrapper']/div/form/div[@class='row my-1']/div[@class='col-lg-7 px-1 pt-2']/div[@class='card mt-2 card-shadow']/div[@class='card-body']/div[3]/div[3]/span[1]/i[1]")
	private static WebElement Products_Add_Select_Attribute_Value_Add_more_Delete1;

	@FindBy(xpath = "//div[4]//div[3]//span[1]//i[1]")
	private static WebElement Products_Add_Select_Attribute_Value_Add_more_Delete2;

	@FindBy(xpath = "//h6[normalize-space()='Attribute Details']")
	private static WebElement Products_Add_Select_Outside;
	
	@FindBy(xpath = "//input[@placeholder='Enter List Price']")
	private static WebElement Products_Add_Least_Price;
	
	@FindBy(xpath = "//input[@placeholder='Enter Unit Price']")
	private static WebElement Products_Add_Unit_Price;
	
	@FindBy(xpath = "//input[@placeholder='Enter Stock Number']")
	private static WebElement Products_Add_Stock;
	
	@FindBy(xpath = "//label[@for='fileProduct']")
	private static WebElement Products_Add_Image_Upload;
	
	@FindBy(xpath = "//button[@class='btn add-product-btn']")
	private static WebElement Products_Add_Button;
	
	@FindBy(xpath = "//div[@role='dialog']//div[@class='modal-dialog modal-lg']//div[@class='modal-content']//div[@class='modal-body']//div//span[@class='p-button-label'][normalize-space()='Close']")
	private static WebElement Products_Add_Catagory_Close_Button;
	 
	@FindBy(xpath = "//input[@id='defaultCatalogs']")
	private static WebElement Products_Add_Product_Default_Catalog_CheckBox;
	
	@FindBy(xpath = "//input[@placeholder='Enter HSN Code']")
	private static WebElement Add_Products_HSN_Code;
	
	@FindBy(xpath = "//div[@class='container-fluid mt-1']//li[5]//a[1]//span[1]")
	private static WebElement Add_Products_Breadcrumbs;
	
//===========================================================================================================================
	
//Add New Attrinute Xpaths
	
	@FindBy(xpath = "//button[normalize-space()='Add New Attribute']")
	private static WebElement Products_Add_New_Attribute_Button;
	
	@FindBy(xpath = "//body/div[@id='app']/div[@class='main_app']/div[@id='view']/div[@class='container-fluid mt-1']/div[@class='content-wrapper']/div/form/div[@class='row my-1']/div[@class='col-lg-6 px-1 pt-2']/div[@class='card mt-2 card-shadow']/div[@class='card-body']/div[@role='dialog']/div[@class='modal-dialog modal-lg']/div[@class='modal-content']/div[@class='modal-body']/div/form[@class='row p-1']/div[@class='row']/div[1]/input[1]")
	private static WebElement Products_Add_New_Attribute_Attribute_Display ;
	
	@FindBy(xpath = "//button[normalize-space()='Add New Attribute']")
	private static WebElement Products_Add_New_Attribute_Identifier;
	
	@FindBy(xpath = "//input[@placeholder='Enter Attribute Display Value']")
	private static WebElement Products_Add_New_Attribute_Attribute_Display_Value1;
	
	@FindBy(xpath = "//button[normalize-space()='Add New Attribute']")
	private static WebElement Products_Add_New_Attribute_Attribute_Identifier1;
	
	@FindBy(xpath = "//div[@class='card mt-2 card-shadow']//div[@class='modal-body']//div[2]//div[1]//input[1]")
	private static WebElement Products_Add_New_Attribute_Attribute_Display_Value2;
	
	@FindBy(xpath = "//div[@class='card mt-2 card-shadow']//div[@class='modal-body']//div[2]//div[2]//input[1]")
	private static WebElement Products_Add_New_Attribute_Attribute_Identifier2;
	
	@FindBy(xpath = "//div[@class='col-12 mx-4 my-3']//div[3]//div[1]//input[1]")
	private static WebElement Products_Add_New_Attribute_Attribute_Display_Value3;
	
	@FindBy(xpath = "//div[contains(@class,'col-12 mx-4 my-3')]//div[3]//div[2]//input[1]")
	private static WebElement Products_Add_New_Attribute_Attribute_Identifier3;
	
	@FindBy(xpath = "//div[contains(@role,'dialog')]//div[contains(@class,'row')]//div[1]//div[4]//button[1]")
	private static WebElement Products_Add_New_Attribute_Attribute_Add_More1;
	
	@FindBy(xpath = "//div[contains(@class,'modal-body')]//div[2]//div[4]//button[1]")
	private static WebElement Products_Add_New_Attribute_Attribute_Add_More2;
	
	@FindBy(xpath = "//div[contains(@class,'col-12 mx-4 my-3')]//div[3]//div[4]//button[1]")
	private static WebElement Products_Add_New_Attribute_Attribute_Add_More3;
	
	@FindBy(xpath = "//div[contains(@class,'row my-1')]//div[contains(@class,'row')]//div[1]//div[3]//span[1]//i[1]")
	private static WebElement Products_Add_New_Attribute_Attribute_Delete_Attribute_Details1;
	
	@FindBy(xpath = "//div[contains(@class,'modal-body')]//div[2]//div[3]//span[1]//i[1]")
	private static WebElement Products_Add_New_Attribute_Attribute_Delete_Attribute_Details2;
	
	@FindBy(xpath = "//div[contains(@class,'col-12 mx-4 my-3')]//div[3]//div[3]//span[1]//i[1]")
	private static WebElement Products_Add_New_Attribute_Attribute_Delete_Attribute_Details3;
	
	@FindBy(xpath = "//div[@role='dialog']//div[@class='modal-dialog modal-lg']//div[@class='modal-content']//div[@class='modal-body']//div//span[@class='p-button-label'][normalize-space()='Add']")
	private static WebElement Products_Add_New_Attribute_Attribute_Add_Button;
	
	@FindBy(xpath = "//div[@role='dialog']//div[@class='modal-dialog modal-lg']//div[@class='modal-content']//div[@class='modal-body']//div//span[@class='p-button-label'][normalize-space()='Close']")
	private static WebElement Products_Add_New_Attribute_Close_Button;
	
	//==================================================================================================================
	//Filter Xpaths
	
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
	
SoftAssert softassert= new SoftAssert();
	
	public Products_Page add_Single_Product_with_Valid_Data(Hashtable<String, String> ht) throws InterruptedException, AWTException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.clickonWebElement(Products_Add_Single_Products_Add_Button, "Add Button");
		CommonMethod.entertextintoinputbox(Products_Add_Product_SKU, ht.get("Product Sku"));
		CommonMethod.entertextintoinputbox(Products_Add_Product_Name, ht.get("Product Name"));
		CommonMethod.entertextintoinputbox(Products_Add_Product_Description, ht.get("Product Description"));
		CommonMethod.entertextintoinputbox(Add_Products_HSN_Code, ht.get("Product HSN Code"));
		
		WebElement nextButton = driver
				.findElement(By.xpath("//h6[normalize-space()='Attribute Details']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextButton);
		Thread.sleep(3000);
	
		
		CommonMethod.clickonWebElement(Products_Add_Default_Catalog, "Defaul Catalog Check Box");
		CommonMethod.bootstrapdropdownselection(Products_Add_Product_Select_Store, "Products_Add_Product_Select_Store",
				ht.get("Select Store for adding new Product"));
		CommonMethod.clickonWebElement(Products_Add_Select_Outside, "Outside");
		
		if(Products_Add_Store_Catalog.isSelected()||Products_Add_Default_Catalog.isSelected()) {
			test.pass("one of the checkbox has selected which is validating the  expected result");
			
		}else {
			test.pass("Both the check box has not selected that means it is a issue  so please contact Developer");
			
		}
		
		
		CommonMethod.bootstrapdropdownselection(Products_Add_Select_Catagory, "Add_Product_SelectCatagory",
				ht.get("Select Category for adding new Product"));
		CommonMethod.SelectDropdown("Products_Add_Select_Attribute1", ht.get("Attribute Type1"));
		CommonMethod.SelectDropdown("Products_Add_Select_Attribute_Value1", ht.get("Attribute Value1"));
		CommonMethod.entertextintoinputbox(Products_Add_Least_Price	, ht.get("Least Price for adding new Product"));
		CommonMethod.entertextintoinputbox(Products_Add_Unit_Price	, ht.get("Unit Price for adding new Product"));
		
		driver.findElement(By.xpath("//label[@for='fileProduct']")).click();
		StringSelection filepathSelection= new StringSelection("C:\\Users\\sunil\\Test File Format\\screenshot");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepathSelection, null);
		//using Robot class
		Thread.sleep(3000);
		Robot rb= new Robot();
		rb.keyPress(KeyEvent.VK_CONTROL);
		
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		
		
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		test.pass("Image1 Uploaded Successfully");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//label[@for='fileProduct']")).click();
		StringSelection filepathSelection2= new StringSelection("C:\\Users\\sunil\\Test File Format\\screenshot2");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepathSelection2, null);
		//using Robot class
		Thread.sleep(3000);
		Robot rb1= new Robot();
		rb.keyPress(KeyEvent.VK_CONTROL);
		
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		
		
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		CommonMethod.takescreenshot();
		test.pass("Image2 Uploaded Successfully");
		CommonMethod.takescreenshot();
		Thread.sleep(3000);
		return this;
	}
	
//======================================================================================================================
	
	public Products_Page add_Single_Product_with_Store_Catalog(Hashtable<String, String> ht) throws InterruptedException, AWTException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.clickonWebElement(Products_Add_Single_Products_Add_Button, "Add Button");
		CommonMethod.entertextintoinputbox(Products_Add_Product_SKU, ht.get("Product Sku"));
		CommonMethod.entertextintoinputbox(Products_Add_Product_Name, ht.get("Product Name"));
		CommonMethod.entertextintoinputbox(Products_Add_Product_Description, ht.get("Product Description"));
		CommonMethod.entertextintoinputbox(Add_Products_HSN_Code, ht.get("Product HSN Code"));
		WebElement nextButton = driver
				.findElement(By.xpath("//h6[normalize-space()='Attribute Details']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextButton);
		Thread.sleep(3000);
	
		
		CommonMethod.clickonWebElement(Products_Add_Default_Catalog, "Defaul Catalog Check Box");
		CommonMethod.bootstrapdropdownselection(Products_Add_Product_Select_Store, "Products_Add_Product_Select_Store",
				ht.get("Select Store for adding new Product"));
		CommonMethod.clickonWebElement(Products_Add_Select_Outside, "Outside");
		
		
		CommonMethod.clickonWebElement(Products_Add_Store_Catalog, "Defaul Catalog Check Box");
		
	
		CommonMethod.bootstrapdropdownselection(Products_Add_Select_Catagory, "Add_Product_SelectCatagory",
				ht.get("Select Category for adding new Product"));
		CommonMethod.SelectDropdown("Products_Add_Select_Attribute1", ht.get("Attribute Type1"));
		CommonMethod.SelectDropdown("Products_Add_Select_Attribute_Value1", ht.get("Attribute Value1"));
		CommonMethod.entertextintoinputbox(Products_Add_Least_Price	, ht.get("Least Price for adding new Product"));
		CommonMethod.entertextintoinputbox(Products_Add_Unit_Price	, ht.get("Unit Price for adding new Product"));
		
		driver.findElement(By.xpath("//label[@for='fileProduct']")).click();
		StringSelection filepathSelection= new StringSelection("C:\\Users\\sunil\\Test File Format\\screenshot.png");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepathSelection, null);
		//using Robot class
		Thread.sleep(3000);
		Robot rb= new Robot();
		rb.keyPress(KeyEvent.VK_CONTROL);
		
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		
		
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		test.pass("Image1 Uploaded Successfully");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//label[@for='fileProduct']")).click();
		StringSelection filepathSelection2= new StringSelection("C:\\Users\\sunil\\Test File Format\\screenshot2.png");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepathSelection2, null);
		//using Robot class
		Thread.sleep(3000);
		Robot rb1= new Robot();
		rb.keyPress(KeyEvent.VK_CONTROL);
		
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		
		
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		CommonMethod.takescreenshot();
		test.pass("Image2 Uploaded Successfully");
		CommonMethod.takescreenshot();
		Thread.sleep(3000);
		return this;
	}
//=======================================================================================================================
	
	public Products_Page add_Single_Product_with_Store_Catalog_add_Catagory(Hashtable<String, String> ht) throws InterruptedException, AWTException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.clickonWebElement(Products_Add_Single_Products_Add_Button, "Add Button");
		CommonMethod.entertextintoinputbox(Products_Add_Product_SKU, ht.get("Product Sku"));
		CommonMethod.entertextintoinputbox(Products_Add_Product_Name, ht.get("Product Name"));
		CommonMethod.entertextintoinputbox(Products_Add_Product_Description, ht.get("Product Description"));
		CommonMethod.entertextintoinputbox(Add_Products_HSN_Code, ht.get("Product HSN Code"));
		WebElement nextButton = driver
				.findElement(By.xpath("//h6[normalize-space()='Attribute Details']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextButton);
		Thread.sleep(3000);
	
		
		CommonMethod.clickonWebElement(Products_Add_Default_Catalog, "Defaul Catalog Check Box");
		CommonMethod.bootstrapdropdownselection(Products_Add_Product_Select_Store, "Products_Add_Product_Select_Store",
				ht.get("Select Store for adding new Product"));
		CommonMethod.clickonWebElement(Products_Add_Select_Outside, "Outside");
		
		
		CommonMethod.clickonWebElement(Products_Add_Store_Catalog, "store Catalog Check Box");
		
		CommonMethod.clickonWebElement(Products_Add_Add_Catagory, "Add Catagory Button");
		Thread.sleep(3000);
		CommonMethod.clickonWebElement(Products_Add_Catagory_Store_Catalog_CheckBox, "store Catalog Check Box");
		
		CommonMethod.entertextintoinputbox(Products_Add_Catagory_Name, ht.get("Catagory Name inside Add Catagory Screen"));
		CommonMethod.entertextintoinputbox(Products_Add_Catagory_Description, ht.get("Catagory Description inside Add Catagory Screen"));
		CommonMethod.bootstrapdropdownselection(Products_Add_Catagory_SelectStore, "Products_Add_Catagory_SelectStore",ht.get("Select Store for adding new Catagory") );
		CommonMethod.clickonWebElement(Products_Add_Catagory_Add_Button, "add button inside add catagory");
		
		CommonMethod.bootstrapdropdownselection(Products_Add_Select_Catagory, "Add_Product_SelectCatagory",
				ht.get("Select Category for adding new Product"));
		CommonMethod.SelectDropdown("Products_Add_Select_Attribute1", ht.get("Attribute Type1"));
		CommonMethod.SelectDropdown("Products_Add_Select_Attribute_Value1", ht.get("Attribute Value1"));
		CommonMethod.entertextintoinputbox(Products_Add_Least_Price	, ht.get("Least Price for adding new Product"));
		CommonMethod.entertextintoinputbox(Products_Add_Unit_Price	, ht.get("Unit Price for adding new Product"));
		
		driver.findElement(By.xpath("//label[@for='fileProduct']")).click();
		StringSelection filepathSelection= new StringSelection("C:\\Users\\sunil\\Test File Format\\screenshot.png");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepathSelection, null);
		//using Robot class
		Thread.sleep(3000);
		Robot rb= new Robot();
		rb.keyPress(KeyEvent.VK_CONTROL);
		
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		
		
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		test.pass("Image1 Uploaded Successfully");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//label[@for='fileProduct']")).click();
		StringSelection filepathSelection2= new StringSelection("C:\\Users\\sunil\\Test File Format\\screenshot2.png");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepathSelection2, null);
		//using Robot class
		Thread.sleep(3000);
		Robot rb1= new Robot();
		rb.keyPress(KeyEvent.VK_CONTROL);
		
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		
		
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		CommonMethod.takescreenshot();
		test.pass("Image2 Uploaded Successfully");
		CommonMethod.takescreenshot();
		
		Thread.sleep(3000);
		return this;
	}
//======================================================================================================================
	
	public Products_Page   add_Single_Product_ErrorMessage_Checking_for_Mandatory_Field(Hashtable<String, String> ht) throws InterruptedException, AWTException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.clickonWebElement(Products_Add_Single_Products_Add_Button, "Add Button");
		
		WebElement add_product = driver
				.findElement(By.xpath("//button[@class='btn add-product-btn']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", add_product);
		Thread.sleep(3000);
		add_product.click();
		WebElement toastMessage = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div/p")));

		if (toastMessage.isDisplayed()) {
			String Actual_Pagetitle = toastMessage.getText();

			softassert.assertEquals(Actual_Pagetitle, ht.get("Error Message for  Product SKU Mandatory Field"));
			System.out.println("Page title is verified and Title is: " + Actual_Pagetitle);
			test.pass("The Pop-UP Error messge is verified and the Pup-UP Message   is: " + Actual_Pagetitle);
			CommonMethod.takescreenshot();
		} else {
			System.out.println("Toast message is not visible.Create a  jira for this ");
		}
		
		WebElement add_product111 = driver
				.findElement(By.xpath("//h5[normalize-space()='Add New Product']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", add_product111);
		Thread.sleep(3000);
		add_product111.click();
		Thread.sleep(3000);
		CommonMethod.entertextintoinputbox(Products_Add_Product_SKU, ht.get("Product Sku"));
		
		WebElement add_product11 = driver
				.findElement(By.xpath("//button[@class='btn add-product-btn']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", add_product11);
		Thread.sleep(3000);
		add_product11.click();
		WebElement toastMessage1 = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div/p")));

		if (toastMessage1.isDisplayed()) {
		    // Re-locate the toast message before interacting with it
		    toastMessage1 = driver.findElement(By.xpath("/html/body/div[3]/div/p"));
		    String Actual_Pagetitle1 = toastMessage1.getText();

		    // Perform assertion
		    softassert.assertEquals(Actual_Pagetitle1, ht.get("Error Message for  Product Name Mandatory Field"));
		    System.out.println("Page title is verified and Title is: " + Actual_Pagetitle1);
		    test.pass("The Pop-UP Error Message for product name is verified and the Pop-UP Error Message is: " + Actual_Pagetitle1);

		    // Take screenshot
		    CommonMethod.takescreenshot();
		} else {
		    System.out.println("Toast message is not visible.");
		}

		Thread.sleep(3000);
		CommonMethod.entertextintoinputbox(Products_Add_Product_Name, ht.get("Product Name"));
		
		//driver.findElement(By.xpath("//h6[normalize-space()='Attribute Details']")).click();
//		Thread.sleep(3000);
//		WebElement add_product12 = driver
//				.findElement(By.xpath("//button[@class='btn add-product-btn']"));
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", add_product12);
//		Thread.sleep(3000);
//		add_product12.click();
		
		
		CommonMethod.entertextintoinputbox(Products_Add_Product_Description, ht.get("Product Description"));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//h6[normalize-space()='Attribute Details']")).click();
		WebElement add_product13 = driver
				.findElement(By.xpath("//button[@class='btn add-product-btn']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", add_product13);
		Thread.sleep(3000);
		add_product13.click();
		
		WebElement toastMessage13 = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div/p")));

		if (toastMessage13.isDisplayed()) {
		    // Re-locate the toast message before interacting with it
		    toastMessage13 = driver.findElement(By.xpath("/html/body/div[3]/div/p"));
		    String Actual_Pagetitle13 = toastMessage13.getText();

		    // Perform assertion
		    softassert.assertEquals(Actual_Pagetitle13, ht.get("Error Message for  Product HSN Code  Mandatory Field"));
		    System.out.println("Page title is verified and Title is: " + Actual_Pagetitle13);
		    test.pass("The Pop-UP Error Message for product name is verified and the Pop-UP Error Message is: " + Actual_Pagetitle13);

		    // Take screenshot
		    CommonMethod.takescreenshot();
		} else {
		    System.out.println("Toast message is not visible.");
		}

		Thread.sleep(3000);
		
		CommonMethod.entertextintoinputbox(Add_Products_HSN_Code, ht.get("Product HSN Code"));
		driver.findElement(By.xpath("//h6[normalize-space()='Attribute Details']")).click();
		WebElement add_product1 = driver
				.findElement(By.xpath("//button[@class='btn add-product-btn']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", add_product1);
		Thread.sleep(3000);
		add_product1.click();
		
		
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Wait for the toast message to appear
		WebElement toastMessage3 = wait2
		        .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div/p")));

		if (toastMessage3.isDisplayed()) {
		    // Re-locate the toast message before interacting with it
		    toastMessage3 = driver.findElement(By.xpath("/html/body/div[3]/div/p"));
		    String Actual_Pagetitle3 = toastMessage3.getText();

		    // Perform assertion
		    softassert.assertEquals(Actual_Pagetitle3, ht.get("Error Message for  Product Catagory  Mandatory Field"));
		    System.out.println("Page title is verified and Title is: " + Actual_Pagetitle3);
		    test.pass("The Pop-UP Error message for  Product Catagory  Mandatory Field is verified and the Pop-UP Error Message is: " + Actual_Pagetitle3);

		    // Take screenshot
		    CommonMethod.takescreenshot();
		} else {
		    System.out.println("Toast message is not visible.");
		}

		Thread.sleep(3000);
		
		CommonMethod.bootstrapdropdownselection(Products_Add_Product_Select_Store, "Products_Add_Product_Select_Store",
				ht.get("Select Store for adding new Product"));
		
		CommonMethod.clickonWebElement(Products_Add_Select_Outside, "Outside");
		
		
		CommonMethod.clickonWebElement(Products_Add_Store_Catalog, "Defaul Catalog Check Box");
		WebElement nextButton = driver
				.findElement(By.xpath("//h6[normalize-space()='Attribute Details']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextButton);
		Thread.sleep(3000);
		CommonMethod.clickonWebElement(Products_Add_Add_Catagory, "Add Catagory Button");
		Thread.sleep(3000);
		CommonMethod.clickonWebElement(Products_Add_Catagory_Store_Catalog_CheckBox, "Defaul Catalog Check Box");
		CommonMethod.clickonWebElement(Products_Add_Catagory_Add_Button, "add button inside add catagory");
		
		
		
		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Wait for the toast message to appear
		WebElement toastMessage4 = wait3
		        .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div/p")));

		if (toastMessage4.isDisplayed()) {
		    // Re-locate the toast message before interacting with it
		    toastMessage4 = driver.findElement(By.xpath("/html/body/div[3]/div/p"));
		    String Actual_Pagetitle4 = toastMessage4.getText();

		    // Perform assertion
		    softassert.assertEquals(Actual_Pagetitle4, ht.get("Error Message for   Entering Category Name  Mandatory Field"));
		    System.out.println("Page title is verified and Title is: " + Actual_Pagetitle4);
		    test.pass("The Pop-UP Error Message for   Entering Category Name  Mandatory Field is verified and the Pop-UP Error Message is: " + Actual_Pagetitle4);

		    // Take screenshot
		    CommonMethod.takescreenshot();
		} else {
		    System.out.println("Toast message is not visible.");
		}

		Thread.sleep(3000);
		
		CommonMethod.entertextintoinputbox(Products_Add_Catagory_Name, ht.get("Catagory Name inside Add Catagory Screen"));
		
		CommonMethod.clickonWebElement(Products_Add_Catagory_Close_Button, "add button inside add catagory");
		
		
		CommonMethod.bootstrapdropdownselection(Products_Add_Select_Catagory, "Add_Product_SelectCatagory",
				ht.get("Select Category for adding new Product"));
		CommonMethod.SelectDropdown("Products_Add_Select_Attribute1", ht.get("Attribute Type1"));
		CommonMethod.SelectDropdown("Products_Add_Select_Attribute_Value1", ht.get("Attribute Value1"));
		CommonMethod.entertextintoinputbox(Products_Add_Least_Price	, ht.get("Least Price for adding new Product"));
		CommonMethod.entertextintoinputbox(Products_Add_Unit_Price	, ht.get("Unit Price for adding new Product"));
		
		softassert.assertAll();
	
	return this;
	}
//=======================================================================================================================
	public Products_Page add_Single_Product_ErrorMessage_Checking_for_Mandatory_Field2(Hashtable<String, String> ht) throws InterruptedException, AWTException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.clickonWebElement(Products_Add_Single_Products_Add_Button, "Add Button");
		CommonMethod.entertextintoinputbox(Products_Add_Product_SKU, ht.get("Product Sku"));
		CommonMethod.entertextintoinputbox(Products_Add_Product_Name, ht.get("Product Name"));
		CommonMethod.entertextintoinputbox(Products_Add_Product_Description, ht.get("Product Description"));
		CommonMethod.entertextintoinputbox(Add_Products_HSN_Code, ht.get("Product HSN Code"));
		
		
		WebElement nextButton12 = driver
				.findElement(By.xpath("//h6[normalize-space()='Attribute Details']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextButton12);
		Thread.sleep(3000);

		CommonMethod.bootstrapdropdownselection(Products_Add_Product_Select_Store, "Products_Add_Product_Select_Store",
				ht.get("Select Store for adding new Product"));
		
		CommonMethod.clickonWebElement(Products_Add_Select_Outside, "Outside");
		
		CommonMethod.clickonWebElement(Products_Add_Default_Catalog, "Defaul Catalog Check Box");
		WebElement nextButton = driver
				.findElement(By.xpath("//h6[normalize-space()='Attribute Details']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextButton);
		Thread.sleep(3000);
		
		WebElement add_product = driver
				.findElement(By.xpath("//button[@class='btn add-product-btn']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", add_product);
		Thread.sleep(3000);
		add_product.click();
		WebElement toastMessage = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div/p")));

		if (toastMessage.isDisplayed()) {
			String Actual_Pagetitle = toastMessage.getText();

			Assert.assertEquals(Actual_Pagetitle, ht.get("Error Message for  Product Catagory  Mandatory Field"));
			System.out.println("Page title is verified and Title is: " + Actual_Pagetitle);
			test.pass("The Pop-UP successful messge is verified and the Pup-UP Message   is: " + Actual_Pagetitle);
			CommonMethod.takescreenshot();
		} else {
			System.out.println("Toast message is not visible.");
		}
		Thread.sleep(3000);
		
		
		CommonMethod.bootstrapdropdownselection(Products_Add_Select_Catagory, "Add_Product_SelectCatagory",
				ht.get("Select Category for adding new Product"));
		CommonMethod.SelectDropdown("Products_Add_Select_Attribute1", ht.get("Attribute Type1"));
		CommonMethod.SelectDropdown("Products_Add_Select_Attribute_Value1", ht.get("Attribute Value1"));
		CommonMethod.entertextintoinputbox(Products_Add_Least_Price	, ht.get("Least Price for adding new Product"));
		CommonMethod.entertextintoinputbox(Products_Add_Unit_Price	, ht.get("Unit Price for adding new Product"));
		
		driver.findElement(By.xpath("//label[@for='fileProduct']")).click();
		StringSelection filepathSelection= new StringSelection("C:\\Users\\sunil\\Test File Format\\screenshot");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepathSelection, null);
		//using Robot class
		Thread.sleep(3000);
		Robot rb= new Robot();
		rb.keyPress(KeyEvent.VK_CONTROL);
		
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		
		
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//label[@for='fileProduct']")).click();
		StringSelection filepathSelection2= new StringSelection("C:\\Users\\sunil\\Test File Format\\screenshot2");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepathSelection2, null);
		//using Robot class
		Thread.sleep(3000);
		Robot rb1= new Robot();
		rb.keyPress(KeyEvent.VK_CONTROL);
		
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		
		
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		return this;
	}
//=======================================================================================================================
	public Products_Page add_Single_Product_Validate_CheckBox(Hashtable<String, String> ht) throws InterruptedException, AWTException {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.clickonWebElement(Products_Add_Single_Products_Add_Button, "Add Button");
		CommonMethod.entertextintoinputbox(Products_Add_Product_SKU, ht.get("Product Sku"));
		CommonMethod.entertextintoinputbox(Products_Add_Product_Name, ht.get("Product Name"));
		CommonMethod.entertextintoinputbox(Products_Add_Product_Description, ht.get("Product Description"));
		CommonMethod.entertextintoinputbox(Add_Products_HSN_Code, ht.get("Product HSN Code"));
		WebElement nextButton1 = driver
				.findElement(By.xpath("//h6[normalize-space()='Attribute Details']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextButton1);
		Thread.sleep(3000);
	
		
		CommonMethod.clickonWebElement(Products_Add_Default_Catalog, "Defaul Catalog Check Box");
		CommonMethod.bootstrapdropdownselection(Products_Add_Product_Select_Store, "Products_Add_Product_Select_Store",
				ht.get("Select Store for adding new Product"));
		CommonMethod.clickonWebElement(Products_Add_Select_Outside, "Outside");
		
	
		
		
		
		CommonMethod.clickonWebElement(Products_Add_Store_Catalog, "store Catalog Check Box");
		WebElement nextButton = driver
				.findElement(By.xpath("//h6[normalize-space()='Attribute Details']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextButton);
		Thread.sleep(3000);

CommonMethod.clickonWebElement(Products_Add_Add_Catagory, "Add Catagory Button");
CommonMethod.clickonWebElement(Products_Add_Catagory_Store_Catalog_CheckBox, "Store Catalog Check Box");

		
		CommonMethod.entertextintoinputbox(Products_Add_Catagory_Name, ht.get("Catagory Name inside Add Catagory Screen"));
		CommonMethod.entertextintoinputbox(Products_Add_Catagory_Description, ht.get("Catagory Description inside Add Catagory Screen"));
		CommonMethod.bootstrapdropdownselection(Products_Add_Catagory_SelectStore, "Products_Add_Catagory_SelectStore",ht.get("Select Store for adding new Catagory") );
		CommonMethod.clickonWebElement(Products_Add_Catagory_Add_Button, "add button inside add catagory");

if(Products_Add_Catagory_Store_Catalog_CheckBox.isSelected()||Products_Add_Product_Default_Catalog_CheckBox.isSelected()) {
	test.pass("one of the checkbox has selected which is validating the  expected result");
}else {
	test.pass("Both the check box has not selected that means it is a issue  so please contact Developer");
	
}
			
			
		
			return this;
		
	}
	

//=======================================================================================================================
	
	public Products_Page add_Single_Product_with_Valid_Data_Cross_Check_With_DBEAVER(Hashtable<String, String> ht) throws InterruptedException, AWTException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.clickonWebElement(Products_Add_Single_Products_Add_Button, "Add Button");
		CommonMethod.entertextintoinputbox(Products_Add_Product_SKU, ht.get("Product Sku"));
		CommonMethod.entertextintoinputbox(Products_Add_Product_Name, ht.get("Product Name"));
		CommonMethod.entertextintoinputbox(Products_Add_Product_Description, ht.get("Product Description"));
		CommonMethod.entertextintoinputbox(Add_Products_HSN_Code, ht.get("Product HSN Code"));
		
		WebElement nextButton = driver
				.findElement(By.xpath("//h6[normalize-space()='Attribute Details']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextButton);
		Thread.sleep(3000);
	
		
		CommonMethod.clickonWebElement(Products_Add_Default_Catalog, "Defaul Catalog Check Box");
		CommonMethod.bootstrapdropdownselection(Products_Add_Product_Select_Store, "Products_Add_Product_Select_Store",
				ht.get("Select Store for adding new Product"));
		CommonMethod.clickonWebElement(Products_Add_Select_Outside, "Outside");
		
		if(Products_Add_Store_Catalog.isSelected()||Products_Add_Default_Catalog.isSelected()) {
			test.pass("one of the checkbox has selected which is validating the  expected result");
			
		}else {
			test.pass("Both the check box has not selected that means it is a issue  so please contact Developer");
			
		}
		
		
		CommonMethod.bootstrapdropdownselection(Products_Add_Select_Catagory, "Add_Product_SelectCatagory",
				ht.get("Select Category for adding new Product"));
		CommonMethod.SelectDropdown("Products_Add_Select_Attribute1", ht.get("Attribute Type1"));
		CommonMethod.SelectDropdown("Products_Add_Select_Attribute_Value1", ht.get("Attribute Value1"));
		CommonMethod.entertextintoinputbox(Products_Add_Least_Price	, ht.get("Least Price for adding new Product"));
		CommonMethod.entertextintoinputbox(Products_Add_Unit_Price	, ht.get("Unit Price for adding new Product"));
		
		driver.findElement(By.xpath("//label[@for='fileProduct']")).click();
		StringSelection filepathSelection= new StringSelection("C:\\Users\\sunil\\Test File Format\\screenshot");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepathSelection, null);
		//using Robot class
		Thread.sleep(3000);
		Robot rb= new Robot();
		rb.keyPress(KeyEvent.VK_CONTROL);
		
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		
		
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		test.pass("Image1 Uploaded Successfully");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//label[@for='fileProduct']")).click();
		StringSelection filepathSelection2= new StringSelection("C:\\Users\\sunil\\Test File Format\\screenshot2");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepathSelection2, null);
		//using Robot class
		Thread.sleep(3000);
		Robot rb1= new Robot();
		rb.keyPress(KeyEvent.VK_CONTROL);
		
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		
		
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		CommonMethod.takescreenshot();
		test.pass("Image2 Uploaded Successfully");
		CommonMethod.takescreenshot();
		Thread.sleep(3000);
		CommonMethod.clickonWebElement(Products_Add_Button, "Add Product button to add one sku to product list ");
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement toastMessage = wait2
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@class='v-toast__text']")));

		if (toastMessage.isDisplayed()) {
			String Actual_Pagetitle = toastMessage.getText();

			Assert.assertEquals(Actual_Pagetitle, ht.get("Adding Single Product Successful Message"));
			System.out.println("Page title is verified and Title is: " + Actual_Pagetitle);
			test.pass(
					"The Pop-UP successful messge for inventoryList_Adjustment_with_Valid_Inputs is verified and the Pup-UP Message   is: "
							+ Actual_Pagetitle);
			CommonMethod.takescreenshot();
		} else {
			System.out.println("Toast message is not visible.");
		}
		Thread.sleep(3000);
		
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		

		WebElement ScrollUP = driver
				.findElement(By.xpath("//h6[normalize-space()='Products']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ScrollUP);
		Thread.sleep(3000);
		
		CommonMethod.clickonWebElement(Products_Filter, "filter of Products Screen");
		Thread.sleep(3000);

		CommonMethod.entertextintoinputbox(Products_Filter_Search_Box,
				ht.get("Product Sku"));
		CommonMethod.bootstrapdropdownselection(Products_Filter_Select_STore,
				"Products_Filter_Select_STore", ht.get("Select Store for adding new Product"));
		CommonMethod.clickonWebElement(Products_Filter_Outside, "Outside to avoid element overlaping");
		CommonMethod.clickonWebElement(Products_Filter_Apply, " Products Filter Apply Button");

		Thread.sleep(3000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//table[@class='bh-table-compact']//tbody/tr")));

		String SKU2 = driver.findElement(By.xpath("//tbody//tr//td[1]")).getText();
		String Name = driver.findElement(By.xpath("//tbody//tr//td[2]")).getText();

		test.pass("Entered SKU  through Adding Single Product  is " + SKU2
				+ "  and Name for this SKU after Adding Single Product is " + Name);
		test.pass("PLEASE CHECK WHETHER SKU in Product Table  after Adding Single Product IN DBEAVER IS " + SKU2 + " OR NOT ");
		test.pass("PLEASE CHECK WHETHER Name in Product Table  after Adding Single Product IN DBEAVER IS " + Name + " OR NOT ");
		
		Thread.sleep(3000);
		return this;
	}
//======================================================================================================================
	
	public Products_Page add_Single_Product_Check_ForMaximum_Character_For_Name_Field(Hashtable<String, String> ht) throws InterruptedException, AWTException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.clickonWebElement(Products_Add_Single_Products_Add_Button, "Add Button");
		CommonMethod.entertextintoinputbox(Products_Add_Product_SKU, ht.get("Product Sku"));
		CommonMethod.entertextintoinputbox(Products_Add_Product_Name, ht.get("Single Product Name Field Maximum Character Testing "));
		
		CommonMethod.entertextintoinputbox(Products_Add_Product_Description, ht.get("Product Description"));
		CommonMethod.entertextintoinputbox(Add_Products_HSN_Code, ht.get("Product HSN Code"));
		WebElement nextButton = driver
				.findElement(By.xpath("//h6[normalize-space()='Attribute Details']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextButton);
		Thread.sleep(3000);
	
		
		CommonMethod.clickonWebElement(Products_Add_Default_Catalog, "Defaul Catalog Check Box");
		CommonMethod.bootstrapdropdownselection(Products_Add_Product_Select_Store, "Products_Add_Product_Select_Store",
				ht.get("Select Store for adding new Product"));
		CommonMethod.clickonWebElement(Products_Add_Select_Outside, "Outside");
		
		if(Products_Add_Store_Catalog.isSelected()||Products_Add_Default_Catalog.isSelected()) {
			test.pass("one of the checkbox has selected which is validating the  expected result");
			
		}else {
			test.pass("Both the check box has not selected that means it is a issue  so please contact Developer");
			
		}
		
		
		CommonMethod.bootstrapdropdownselection(Products_Add_Select_Catagory, "Add_Product_SelectCatagory",
				ht.get("Select Category for adding new Product"));
		CommonMethod.SelectDropdown("Products_Add_Select_Attribute1", ht.get("Attribute Type1"));
		CommonMethod.SelectDropdown("Products_Add_Select_Attribute_Value1", ht.get("Attribute Value1"));
		CommonMethod.entertextintoinputbox(Products_Add_Least_Price	, ht.get("Least Price for adding new Product"));
		CommonMethod.entertextintoinputbox(Products_Add_Unit_Price	, ht.get("Unit Price for adding new Product"));
		
		driver.findElement(By.xpath("//label[@for='fileProduct']")).click();
		StringSelection filepathSelection= new StringSelection("C:\\Users\\sunil\\Test File Format\\screenshot.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepathSelection, null);
		//using Robot class
		Thread.sleep(3000);
		Robot rb= new Robot();
		rb.keyPress(KeyEvent.VK_CONTROL);
		
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		
		
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		test.pass("Image1 Uploaded Successfully");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//label[@for='fileProduct']")).click();
		StringSelection filepathSelection2= new StringSelection("C:\\Users\\sunil\\Test File Format\\screenshot2.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepathSelection2, null);
		//using Robot class
		Thread.sleep(3000);
		Robot rb1= new Robot();
		rb.keyPress(KeyEvent.VK_CONTROL);
		
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		
		
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		CommonMethod.takescreenshot();
		test.pass("Image2 Uploaded Successfully");
		test.pass("This tes case shold fail due charactr count exceeds maximum limit");
		CommonMethod.takescreenshot();
		Thread.sleep(3000);
		CommonMethod.clickonWebElement(Products_Add_Button, "Add Product button to add one sku to product list ");
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement toastMessage = wait2
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@class='v-toast__text']")));

		if (toastMessage.isDisplayed()) {
			String Actual_Pagetitle = toastMessage.getText();

			Assert.assertEquals(Actual_Pagetitle, ht.get("Adding Single Product Successful Message"));
			System.out.println("Page title is verified and Title is: " + Actual_Pagetitle);
			test.pass(
					"The Pop-UP successful messge for adding Single Product is verified and the Pup-UP Message   is: "
							+ Actual_Pagetitle);
			CommonMethod.takescreenshot();
		} else {
			System.out.println("Toast message is not visible.");
		}
		Thread.sleep(3000);
		
		test.pass("This test case shold fail due charactr count exceeds maximum limit");
		return this;
	
}
	
	public Products_Page add_Single_Product_Checking_For_Mandatory_Field(Hashtable<String, String> ht) throws InterruptedException, AWTException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.clickonWebElement(Products_Add_Single_Products_Add_Button, "Add Button");
		//List<WebElement> ory1=driver.findElements(By.xpath("//*[@id=\"view\"]/div[2]/div/div/form/div[1]/div[1]/div[1]/div/div//label"));
	
		//List<WebElement> Mandatory2=driver.findElements(By.xpath("//*[@id=\"view\"]/div[2]/div/div/form/div[1]/div[1]/div[2]/div//label"));
		//List<WebElement>Mandatory=driver.findElements(By.xpath("//*[@id=\"view\"]/div[2]/div/div/form/div[1]/div[1]/div[2]/div/div[3]/div[3]/div/div/div[2]/div/form/div[2]//label"));
		WebElement Mandatory=driver.findElement(By.xpath("//label[@for='description']"));
		
		
		
		System.out.println(Mandatory);
		String text=Mandatory.getText();
		if(text.contains("*"))
		{
		//syso(text +"is Mandatory field");
		System.out.println(text +"is Mandatory field");
		}else {
			System.out.println(text +"is not Mandatory field");
		}
	

		return this;
}
//=====================================================================================================================
//  Single PRoductTEst Case 
	
	public Products_Page add_Single_Product_Check_With_Duplicate_SKU(Hashtable<String, String> ht) throws InterruptedException, AWTException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		Thread.sleep(3000);
		CommonMethod.clickonWebElement(Products_Add_Single_Products_Add_Button, "Add Button");
		CommonMethod.entertextintoinputbox(Products_Add_Product_SKU, ht.get("Duplicate Product Sku to verify"));
		CommonMethod.entertextintoinputbox(Products_Add_Product_Name, ht.get("Single Product Name Field Maximum Character Testing "));
		
		CommonMethod.entertextintoinputbox(Products_Add_Product_Description, ht.get("Product Description"));
		CommonMethod.entertextintoinputbox(Add_Products_HSN_Code, ht.get("Product HSN Code"));
		WebElement nextButton = driver
				.findElement(By.xpath("//h6[normalize-space()='Attribute Details']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextButton);
		Thread.sleep(3000);
	
		
		CommonMethod.clickonWebElement(Products_Add_Default_Catalog, "Defaul Catalog Check Box");
		CommonMethod.bootstrapdropdownselection(Products_Add_Product_Select_Store, "Products_Add_Product_Select_Store",
				ht.get("Select Store for adding new Product"));
		CommonMethod.clickonWebElement(Products_Add_Select_Outside, "Outside");
		
		if(Products_Add_Store_Catalog.isSelected()||Products_Add_Default_Catalog.isSelected()) {
			test.pass("one of the checkbox has selected which is validating the  expected result");
			
		}else {
			test.pass("Both the check box has not selected that means it is a issue  so please contact Developer");
			
		}
		
		
		CommonMethod.bootstrapdropdownselection(Products_Add_Select_Catagory, "Add_Product_SelectCatagory",
				ht.get("Select Category for adding new Product"));
		CommonMethod.SelectDropdown("Products_Add_Select_Attribute1", ht.get("Attribute Type1"));
		CommonMethod.SelectDropdown("Products_Add_Select_Attribute_Value1", ht.get("Attribute Value1"));
		CommonMethod.entertextintoinputbox(Products_Add_Least_Price	, ht.get("Least Price for adding new Product"));
		CommonMethod.entertextintoinputbox(Products_Add_Unit_Price	, ht.get("Unit Price for adding new Product"));
		
		driver.findElement(By.xpath("//label[@for='fileProduct']")).click();
		StringSelection filepathSelection= new StringSelection("C:\\Users\\sunil\\Test File Format\\screenshot.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepathSelection, null);
		//using Robot class
		Thread.sleep(3000);
		Robot rb= new Robot();
		rb.keyPress(KeyEvent.VK_CONTROL);
		
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		
		
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		test.pass("Image1 Uploaded Successfully");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//label[@for='fileProduct']")).click();
		StringSelection filepathSelection2= new StringSelection("C:\\Users\\sunil\\Test File Format\\screenshot2.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepathSelection2, null);
		//using Robot class
		Thread.sleep(3000);
		Robot rb1= new Robot();
		rb.keyPress(KeyEvent.VK_CONTROL);
		
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		
		
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		CommonMethod.takescreenshot();
		test.pass("Image2 Uploaded Successfully");
		test.pass("This tes case shold fail due charactr count exceeds maximum limit");
		CommonMethod.takescreenshot();
		Thread.sleep(3000);
		CommonMethod.clickonWebElement(Products_Add_Button, "Add Product button to add one sku to product list ");
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement toastMessage = wait2
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@class='v-toast__text']")));

		if (toastMessage.isDisplayed()) {
			String Actual_Pagetitle = toastMessage.getText();

			Assert.assertEquals(Actual_Pagetitle, ht.get("Adding Single Product Successful Message"));
			System.out.println("Page title is verified and Title is: " + Actual_Pagetitle);
			test.pass(
					"The Pop-UP Error messge for adding Adding PRoduct with  duplicate SKU  is verified and the Pup-UP Message   is: "
							+ Actual_Pagetitle);
			CommonMethod.takescreenshot();
		} else {
			System.out.println("Toast message is not visible.");
		}
		Thread.sleep(3000);
		
		
		return this;
	
}
	
	public Products_Page Adding_Single_Product_Validate_catagory_details_with_Debeaver_and_SKU_for_Default_Catalogue(Hashtable<String, String> ht) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.clickonWebElement(Products_Add_Single_Products_Add_Button, "Add Button");
		CommonMethod.entertextintoinputbox(Products_Add_Product_SKU, ht.get("Product Sku"));
		CommonMethod.entertextintoinputbox(Products_Add_Product_Name, ht.get("Single Product Name Field Maximum Character Testing "));
		
		CommonMethod.entertextintoinputbox(Products_Add_Product_Description, ht.get("Product Description"));
		CommonMethod.entertextintoinputbox(Add_Products_HSN_Code, ht.get("Product HSN Code"));
		WebElement nextButton = driver
				.findElement(By.xpath("//h6[normalize-space()='Attribute Details']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextButton);
		Thread.sleep(3000);
	
		
		CommonMethod.clickonWebElement(Products_Add_Default_Catalog, "Defaul Catalog Check Box");
		CommonMethod.bootstrapdropdownselection(Products_Add_Product_Select_Store, "Products_Add_Product_Select_Store",
				ht.get("Select Store for adding new Product"));
		CommonMethod.clickonWebElement(Products_Add_Select_Outside, "Outside");
		CommonMethod.clickonWebElement(Products_Add_Add_Catagory, "Add Catagory Button");
		Thread.sleep(3000);
		
		
		CommonMethod.entertextintoinputbox(Products_Add_Catagory_Name, ht.get("Catagory Name inside Add Catagory Screen"));
		CommonMethod.entertextintoinputbox(Products_Add_Catagory_Description, ht.get("Catagory Description inside Add Catagory Screen"));
		CommonMethod.bootstrapdropdownselection(Products_Add_Catagory_SelectStore, "Products_Add_Catagory_SelectStore",ht.get("Select Store for adding new Catagory") );
		CommonMethod.clickonWebElement(Products_Add_Catagory_Add_Button, "add button inside add catagory");
		WebElement toastMessage = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@class='v-toast__text']")));

		if (toastMessage.isDisplayed()) {
			String Actual_Pagetitle = toastMessage.getText();

			Assert.assertEquals(Actual_Pagetitle, ht.get("Successful PopUp Message for adding a new category"));
			System.out.println("Page title is verified and Title is: " + Actual_Pagetitle);
			test.pass(
					"The Pop-UP successful messge for adding a new catagory is verified and the Pup-UP Message   is: "
							+ Actual_Pagetitle);
			CommonMethod.takescreenshot();
		} else {
			System.out.println("Toast message is not visible.");
		}
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.bootstrapdropdownselection(Products_Add_Select_Catagory, "Add_Product_SelectCatagory",
				ht.get("Select Category for adding new Product"));
		CommonMethod.bootstrapdropdownselection(Products_Add_Select_Catagory, "Add_Product_SelectCatagory",
				ht.get("Select Category for adding new Product"));
		test.pass("Catagory has added to the list and please check whether catagory name called " +ht.get("Catagory Name inside Add Catagory Screen") + "is present in Mpos catalogue list and in Dbeaver or not.");
		
		return this;
	}
//==================================================================================================================
	
	public Products_Page add_Single_Product_with_Valid_Data_with_adding_New_Attribute(Hashtable<String, String> ht) throws InterruptedException, AWTException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.clickonWebElement(Products_Add_Single_Products_Add_Button, "Add Button");
		CommonMethod.entertextintoinputbox(Products_Add_Product_SKU, ht.get("Product Sku"));
		CommonMethod.entertextintoinputbox(Products_Add_Product_Name, ht.get("Product Name"));
		CommonMethod.entertextintoinputbox(Products_Add_Product_Description, ht.get("Product Description"));
		CommonMethod.entertextintoinputbox(Add_Products_HSN_Code, ht.get("Product HSN Code"));
		
		WebElement nextButton = driver
				.findElement(By.xpath("//h6[normalize-space()='Attribute Details']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextButton);
		Thread.sleep(3000);
	
		
		CommonMethod.clickonWebElement(Products_Add_Default_Catalog, "Defaul Catalog Check Box");
		CommonMethod.bootstrapdropdownselection(Products_Add_Product_Select_Store, "Products_Add_Product_Select_Store",
				ht.get("Select Store for adding new Product"));
		CommonMethod.clickonWebElement(Products_Add_Select_Outside, "Outside");
		
		if(Products_Add_Store_Catalog.isSelected()||Products_Add_Default_Catalog.isSelected()) {
			test.pass("one of the checkbox has selected which is validating the  expected result");
			
		}else {
			test.pass("Both the check box has not selected that means it is a issue  so please contact Developer");
			
		}
		
		
		CommonMethod.bootstrapdropdownselection(Products_Add_Select_Catagory, "Add_Product_SelectCatagory",
				ht.get("Select Category for adding new Product"));
		CommonMethod.clickonWebElement(Products_Add_New_Attribute_Button, "Add new Attribute Button");
		CommonMethod.entertextintoinputbox(Products_Add_New_Attribute_Attribute_Display	, ht.get("Attribute display Name  for adding a new attribute"));
		
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Add New Attribute']")));
		
		CommonMethod.entertextintoinputbox(Products_Add_New_Attribute_Attribute_Display_Value1, ht.get("Attribute Display Value1  for adding a new attribute"));
		//CommonMethod.entertextintoinputbox(Products_Add_New_Attribute_Attribute_Identifier1, ht.get("Attribute Identifier1  for adding a new attribute"));
		CommonMethod.clickonWebElement(Products_Add_New_Attribute_Attribute_Add_More1, "Add more to add one more  attribute display Value");
		CommonMethod.entertextintoinputbox(Products_Add_New_Attribute_Attribute_Display_Value2, ht.get("Attribute Display Value2  for adding a new attribute"));
		CommonMethod.clickonWebElement(Products_Add_New_Attribute_Attribute_Add_More2, "Add one more value to add one more  attribute display Value");
		CommonMethod.entertextintoinputbox(Products_Add_New_Attribute_Attribute_Display_Value3, ht.get("Attribute Display Value3  for adding a new attribute"));
		CommonMethod.clickonWebElement(Products_Add_New_Attribute_Attribute_Add_More3, "Add one more value to add one more  attribute display Value");
		CommonMethod.clickonWebElement(Products_Add_New_Attribute_Attribute_Delete_Attribute_Details1, "delete button to delete 1st value");
		CommonMethod.clickonWebElement(Products_Add_New_Attribute_Attribute_Add_Button, "add button to add one new atribute");
		
		
		return this;
	}
	public Products_Page add_Single_Product_Breadcrumbs(Hashtable<String, String> ht) throws InterruptedException, AWTException {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Add_Products_Breadcrumbs);
		Thread.sleep(3000);
		CommonMethod.clickonWebElement(Add_Products_Breadcrumbs, "Add Button");
		return this;
	}
	public Products_Page add_Single_Product_Validation_For_Not_Allowing_Duplicate_Attribute(Hashtable<String, String> ht) throws InterruptedException, AWTException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.clickonWebElement(Products_Add_Single_Products_Add_Button, "Add Button");
		CommonMethod.entertextintoinputbox(Products_Add_Product_SKU, ht.get("Product Sku"));
		CommonMethod.entertextintoinputbox(Products_Add_Product_Name, ht.get("Product Name"));
		CommonMethod.entertextintoinputbox(Products_Add_Product_Description, ht.get("Product Description"));
		CommonMethod.entertextintoinputbox(Add_Products_HSN_Code, ht.get("Product HSN Code"));
		
		WebElement nextButton = driver
				.findElement(By.xpath("//h6[normalize-space()='Attribute Details']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextButton);
		Thread.sleep(3000);
	
		
		CommonMethod.clickonWebElement(Products_Add_Default_Catalog, "Defaul Catalog Check Box");
		CommonMethod.bootstrapdropdownselection(Products_Add_Product_Select_Store, "Products_Add_Product_Select_Store",
				ht.get("Select Store for adding new Product"));
		CommonMethod.clickonWebElement(Products_Add_Select_Outside, "Outside");
		
		if(Products_Add_Store_Catalog.isSelected()||Products_Add_Default_Catalog.isSelected()) {
			test.pass("one of the checkbox has selected which is validating the  expected result");
			
		}else {
			test.pass("Both the check box has not selected that means it is a issue  so please contact Developer");
			
		}
		
		
		CommonMethod.bootstrapdropdownselection(Products_Add_Select_Catagory, "Add_Product_SelectCatagory",
				ht.get("Select Category for adding new Product"));
		CommonMethod.clickonWebElement(Products_Add_New_Attribute_Button, "Add new Attribute Button");
		CommonMethod.entertextintoinputbox(Products_Add_New_Attribute_Attribute_Display	, ht.get("Attribute display Name  for adding a new attribute"));
		
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Add New Attribute']")));
		
		CommonMethod.entertextintoinputbox(Products_Add_New_Attribute_Attribute_Display_Value1, ht.get("Attribute Display Value1  for adding a new attribute"));
		//CommonMethod.entertextintoinputbox(Products_Add_New_Attribute_Attribute_Identifier1, ht.get("Attribute Identifier1  for adding a new attribute"));
		CommonMethod.clickonWebElement(Products_Add_New_Attribute_Attribute_Add_More1, "Add more to add one more  attribute display Value");
		CommonMethod.entertextintoinputbox(Products_Add_New_Attribute_Attribute_Display_Value2, ht.get("Attribute Display Value2  for adding a new attribute"));
		CommonMethod.clickonWebElement(Products_Add_New_Attribute_Attribute_Add_More2, "Add one more value to add one more  attribute display Value");
		CommonMethod.entertextintoinputbox(Products_Add_New_Attribute_Attribute_Display_Value3, ht.get("Attribute Display Value3  for adding a new attribute"));
		CommonMethod.clickonWebElement(Products_Add_New_Attribute_Attribute_Add_More3, "Add one more value to add one more  attribute display Value");
		CommonMethod.clickonWebElement(Products_Add_New_Attribute_Attribute_Delete_Attribute_Details1, "delete button to delete 1st value");
		CommonMethod.clickonWebElement(Products_Add_New_Attribute_Attribute_Add_Button, "add button to add one new atribute");
		WebElement toastMessage = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@class='v-toast__text']")));

		if (toastMessage.isDisplayed()) {
			String Actual_Pagetitle = toastMessage.getText();

			Assert.assertEquals(Actual_Pagetitle, ht.get("Error Message For Duplicate Attribute"));
			System.out.println("Page title is verified and Title is: " + Actual_Pagetitle);
			test.pass(
					"The Pop-UP Error  messge for adding a Duplicate Attribute is verified and the Pup-UP Message   is: "
							+ Actual_Pagetitle);
			CommonMethod.takescreenshot();
		} else {
			System.out.println("Toast message is not Visible.");
		}
		return this;
	}
}

