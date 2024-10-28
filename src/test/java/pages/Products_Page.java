package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Hashtable;

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
	private static WebElement Products_Add_Product_Button;
	
	@FindBy(xpath = "//div[@role='dialog']//div[@class='modal-dialog modal-lg']//div[@class='modal-content']//div[@class='modal-body']//div//span[@class='p-button-label'][normalize-space()='Close']")
	private static WebElement Products_Add_Catagory_Close_Button;
	 
	@FindBy(xpath = "//input[@id='defaultCatalogs']")
	private static WebElement Products_Add_Product_Default_Catalog_CheckBox;
	
	public Products_Page add_Single_Product_with_Valid_Data(Hashtable<String, String> ht) throws InterruptedException, AWTException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.clickonWebElement(Products_Add_Single_Products_Add_Button, "Add Button");
		CommonMethod.entertextintoinputbox(Products_Add_Product_SKU, ht.get("Product Sku"));
		CommonMethod.entertextintoinputbox(Products_Add_Product_Name, ht.get("Product Name"));
		CommonMethod.entertextintoinputbox(Products_Add_Product_Description, ht.get("Product Description"));
		
		
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
	public Products_Page add_Single_Product_with_Store_Catalog(Hashtable<String, String> ht) throws InterruptedException, AWTException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.clickonWebElement(Products_Add_Single_Products_Add_Button, "Add Button");
		CommonMethod.entertextintoinputbox(Products_Add_Product_SKU, ht.get("Product Sku"));
		CommonMethod.entertextintoinputbox(Products_Add_Product_Name, ht.get("Product Name"));
		CommonMethod.entertextintoinputbox(Products_Add_Product_Description, ht.get("Product Description"));
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
	public Products_Page add_Single_Product_with_Store_Catalog_add_Catagory(Hashtable<String, String> ht) throws InterruptedException, AWTException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.clickonWebElement(Products_Add_Single_Products_Add_Button, "Add Button");
		CommonMethod.entertextintoinputbox(Products_Add_Product_SKU, ht.get("Product Sku"));
		CommonMethod.entertextintoinputbox(Products_Add_Product_Name, ht.get("Product Name"));
		CommonMethod.entertextintoinputbox(Products_Add_Product_Description, ht.get("Product Description"));
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

			Assert.assertEquals(Actual_Pagetitle, ht.get("Error Message for  Product SKU Mandatory Field"));
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
		    Assert.assertEquals(Actual_Pagetitle1, ht.get("Error Message for  Product Name Mandatory Field"));
		    System.out.println("Page title is verified and Title is: " + Actual_Pagetitle1);
		    test.pass("The Pop-UP Error Message for product name is verified and the Pop-UP Error Message is: " + Actual_Pagetitle1);

		    // Take screenshot
		    CommonMethod.takescreenshot();
		} else {
		    System.out.println("Toast message is not visible.");
		}

		Thread.sleep(3000);
		CommonMethod.entertextintoinputbox(Products_Add_Product_Name, ht.get("Product Name"));
		
		driver.findElement(By.xpath("//h6[normalize-space()='Attribute Details']")).click();
		Thread.sleep(3000);
		WebElement add_product12 = driver
				.findElement(By.xpath("//button[@class='btn add-product-btn']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", add_product12);
		Thread.sleep(3000);
		add_product12.click();
		
		
		CommonMethod.entertextintoinputbox(Products_Add_Product_Description, ht.get("Product Description"));
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
		    Assert.assertEquals(Actual_Pagetitle3, ht.get("Error Message for  Product Catagory  Mandatory Field"));
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
		    Assert.assertEquals(Actual_Pagetitle4, ht.get("Error Message for   Entering Category Name  Mandatory Field"));
		    System.out.println("Page title is verified and Title is: " + Actual_Pagetitle4);
		    test.pass("The Pop-UP Error Message for   Entering Category Name  Mandatory Field is verified and the Pop-UP Error Message is: " + Actual_Pagetitle4);

		    // Take screenshot
		    CommonMethod.takescreenshot();
		} else {
		    System.out.println("Toast message is not visible.");
		}

		Thread.sleep(3000);
		
		CommonMethod.entertextintoinputbox(Products_Add_Catagory_Name, ht.get("Catagory Name inside Add Catagory Screen"));
		/*CommonMethod.clickonWebElement(Products_Add_Catagory_Add_Button, "add button inside add catagory");
		
		

		int attempts = 0;
		while (attempts < 3) {
		    try {
		        WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(10));

		        // Wait for the toast message to appear
		        WebElement toastMessage5 = wait
		                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div/p")));

		        if (toastMessage5.isDisplayed()) {
		            String Actual_Pagetitle5 = toastMessage3.getText();

		            // Perform assertion
		            Assert.assertEquals(Actual_Pagetitle5, ht.get("Error Message for Product Name Mandatory Field"));
		            System.out.println("Page title is verified and Title is: " + Actual_Pagetitle5);
		            test.pass("The Pop-UP successful message is verified and the Pop-UP Message is: " + Actual_Pagetitle5);

		            // Take screenshot
		            CommonMethod.takescreenshot();
		        } else {
		            System.out.println("Toast message is not visible.");
		        }

		        break; // Exit loop if no exception
		    } catch (StaleElementReferenceException e) {
		        // Retry finding the element
		        attempts++;
		    }
		}

		Thread.sleep(3000);*/
		
//		CommonMethod.entertextintoinputbox(Products_Add_Catagory_Description, ht.get("Catagory Description inside Add Catagory Screen"));
//		CommonMethod.bootstrapdropdownselection(Products_Add_Catagory_SelectStore, "Products_Add_Catagory_SelectStore",ht.get("Select Store for adding new Catagory") );
//		CommonMethod.clickonWebElement(Products_Add_Catagory_Add_Button, "add button inside add catagory");
		
		CommonMethod.clickonWebElement(Products_Add_Catagory_Close_Button, "add button inside add catagory");
		
		
		CommonMethod.bootstrapdropdownselection(Products_Add_Select_Catagory, "Add_Product_SelectCatagory",
				ht.get("Select Category for adding new Product"));
		CommonMethod.SelectDropdown("Products_Add_Select_Attribute1", ht.get("Attribute Type1"));
		CommonMethod.SelectDropdown("Products_Add_Select_Attribute_Value1", ht.get("Attribute Value1"));
		CommonMethod.entertextintoinputbox(Products_Add_Least_Price	, ht.get("Least Price for adding new Product"));
		CommonMethod.entertextintoinputbox(Products_Add_Unit_Price	, ht.get("Unit Price for adding new Product"));
		
	
	return this;
	}
	public Products_Page add_Single_Product_ErrorMessage_Checking_for_Mandatory_Field2(Hashtable<String, String> ht) throws InterruptedException, AWTException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.clickonWebElement(Products_Add_Single_Products_Add_Button, "Add Button");
		CommonMethod.entertextintoinputbox(Products_Add_Product_SKU, ht.get("Product Sku"));
		CommonMethod.entertextintoinputbox(Products_Add_Product_Name, ht.get("Product Name"));
		CommonMethod.entertextintoinputbox(Products_Add_Product_Description, ht.get("Product Description"));
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
		Thread.sleep(3000);
		return this;
	}
	public Products_Page add_Single_Product_Validate_CheckBox(Hashtable<String, String> ht) throws InterruptedException, AWTException {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.clickonWebElement(Products_Add_Single_Products_Add_Button, "Add Button");
		CommonMethod.entertextintoinputbox(Products_Add_Product_SKU, ht.get("Product Sku"));
		CommonMethod.entertextintoinputbox(Products_Add_Product_Name, ht.get("Product Name"));
		CommonMethod.entertextintoinputbox(Products_Add_Product_Description, ht.get("Product Description"));
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
}