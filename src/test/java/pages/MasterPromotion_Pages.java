package pages;

import java.time.Duration;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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

	@FindBy(xpath = "//tbody/tr[1]/td[13]/i[1]")
	private static WebElement Edit_Promotion;

	@FindBy(xpath = "//select[@id='active']")
	private static WebElement Edit_Promotion_Active_Status;

	@FindBy(xpath = "//select[@id='overrideSystemPromotion']")
	private static WebElement Edit_Promotion_Promotion_Override;

	@FindBy(xpath = "//select[@id='overrideSystemPromotion']")
	private static WebElement Edit_Promotion_Select_Store;

	@FindBy(xpath = "//input[@id='customProduct']")
	private static WebElement Edit_Promotion_Product_File_Upload_Checkbox;

	@FindBy(xpath = "//button[@class='p-button p-component p-button-secondary p-button-raised p-button-medium']")
	private static WebElement Edit_Promotion_Product_File_Import;

	@FindBy(xpath = "//input[@id='fileProduct']")
	private static WebElement Edit_Promotion_Select_File;

	@FindBy(xpath = "//button[@class='p-button p-component p-button-primary p-button-raised p-button-medium']//span[@class='p-button-label'][normalize-space()='Import']")
	private static WebElement Edit_Promotion_Select_File_Import;

	@FindBy(xpath = "//div[@class='d-flex justify-content-end col-6 pt-1 align-self-center text-right']//span[@class='p-button-label'][normalize-space()='Close']")
	private static WebElement Edit_Promotion_Select_File_Close;

	@FindBy(xpath = "//span[normalize-space()='Click here for File format']")
	private static WebElement Edit_Promotion_Download_File_Format;

	@FindBy(xpath = "//button[@aria-label='OK']")
	private static WebElement Edit_Promotion_File_Import_OK;

	@FindBy(xpath = "//div[@class='d-flex']//button[@aria-label='Close']")
	private static WebElement Edit_Promotion_File_Import_Close;

	@FindBy(xpath = "//button[@aria-label='Update']")
	private static WebElement Edit_Promotion_Update;

	@FindBy(xpath = "//button[@data-bs-dismiss='modal']")
	private static WebElement Edit_Promotion_Cancel;

	@FindBy(xpath = "//span[contains(text(),'Yes')]")
	private static WebElement Edit_Promotion_Update_Yes;

	@FindBy(xpath = "//span[contains(text(),'Cancel')]")
	private static WebElement Edit_Promotion_Update_Cancel;

	@FindBy(xpath = "//*[@id=\"view\"]/div[2]/div/div/div[4]/div/div/div/div[2]/div/div[1]/div/div[1]/div[1]/div[15]/div/div[2]/span[1]")
	private static WebElement Edit_Promotion_Edit_Store;

	@FindBy(xpath = "//label[normalize-space()='Run On Days:']")
	private static WebElement Edit_Promotion_Edit_Click_OutSide;

	@FindBy(xpath = "//tbody/tr[1]/td[1]/input[1]")
	private static WebElement Edit_Promotion_Combination_Pool_Choosse_File_1;

	@FindBy(xpath = "//tbody/tr[2]/td[1]/input[1]")
	private static WebElement Edit_Promotion_Combination_Pool_Choosse_File_2;

	@FindBy(xpath = "//tbody/tr[1]/td[3]/div[1]/span[1]/button[1]/span[1]")
	private static WebElement Edit_Promotion_Combination_Pool_Upload_File_1;

	@FindBy(xpath = "//tbody/tr[2]/td[3]/div[1]/span[1]/button[1]")
	private static WebElement Edit_Promotion_Combination_Pool_Upload_File_2;

	@FindBy(xpath = "//span[contains(text(),'Add more')]")
	private static WebElement Edit_Promotion_Combination_Pool_Add_More;

	@FindBy(xpath = "//tbody/tr[3]/td[4]/i[1]")
	private static WebElement Edit_Promotion_Combination_Pool_Delete_Row_3;

	@FindBy(xpath = "//tbody/tr[3]/td[3]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/span[1]/button[1]/span[1]")
	private static WebElement Edit_Promotion_Combination_Pool_Upload_File_1_OK_button;

	@FindBy(xpath = "//*[@id=\"view\"]/div[2]/div/div/div[4]/div/div/div/div[2]/div/div[1]/div/div[1]/div[3]/table/tbody/tr[3]/td[3]/div[2]/div/div/div/div[3]/div/span[2]/button/span")
	private static WebElement Edit_Promotion_Combination_Pool_Upload_File_1_Close_button;

	@FindBy(xpath = "//tbody/tr[3]/td[3]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/span[1]/button[1]/span[1]")
	private static WebElement Edit_Promotion_Combination_Pool_Upload_File_2_OK_button;

	@FindBy(xpath = "//tbody/tr[3]/td[3]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/span[2]/button[1]/span[1]")
	private static WebElement Edit_Promotion_Combination_Pool_Upload_File_2_Close_button;

	@FindBy(xpath = "//tbody/tr[1]/td[5]/span[1]/span[1]/button[1]/span[1]")
	private static WebElement Edit_Promotion_Combination_Pool_Upload_File_1_Download_Button;

	@FindBy(xpath = "//tbody/tr[2]/td[5]/span[1]/span[1]/button[1]")
	private static WebElement Edit_Promotion_Combination_Pool_Upload_File_2_Download_Button;

	@FindBy(xpath = "//tbody/tr[2]/td[5]/span[1]/span[1]/button[1]")
	private static WebElement Edit_Promotion_Combination_Pool_Update_Button;

	@FindBy(xpath = "//span[contains(text(),'Yes')]")
	private static WebElement Edit_Promotion_Combination_Pool_Update_Yes_Button;

	@FindBy(xpath = "//span[contains(text(),'Cancel')]")
	private static WebElement Edit_Promotion_Combination_Pool_Update_Cancel_Button;

	@FindBy(xpath = "//input[@id='customProduct']")
	private static WebElement Edit_Promotion_Add_Custom_Products_Checkbox;

	@FindBy(xpath = "//button[@class='p-button p-component p-button-secondary p-button-raised p-button-medium']")
	private static WebElement Edit_Promotion_Add_Custom_Products_Import;

	@FindBy(xpath = "//input[@id='fileProduct']")
	private static WebElement Edit_Promotion_Add_Custom_Products_SelectFile;

	@FindBy(xpath = "//button[@class='p-button p-component p-button-primary p-button-raised p-button-medium']//span[@class='p-button-label'][normalize-space()='Import']")
	private static WebElement Edit_Promotion_Add_Custom_Products_SelectFile_Import;

	@FindBy(xpath = "//div[@class='d-flex justify-content-end col-6 pt-1 align-self-center text-right']//span[@class='p-button-label'][normalize-space()='Close']")
	private static WebElement Edit_Promotion_Add_Custom_Products_SelectFile_Close;

//===============================================================================================================

	public MasterPromotion_Pages edit_Promotion_from_Promotion_Table(Hashtable<String, String> ht)
			throws InterruptedException {
		test.pass("Master-001 test case is loading ");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));

		String Promotion_Type = driver.findElement(By.xpath("//tbody/tr[1]/td[4]")).getText();

		if (Promotion_Type.equalsIgnoreCase("Combination Pool")) {

			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Edit_Promotion);
			Thread.sleep(3000);
			Edit_Promotion.click();

			WebElement active_status = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='active']")));

			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", active_status);

			if (active_status.isDisplayed() && active_status.isEnabled()) {

				Select select2 = new Select(active_status);
				select2.selectByValue(ht.get("Active status through Edit Promotion"));
				test.pass("Active status selected successfully");
			} else {
				test.pass("Active status dropdown is not interactable.");
			}

			CommonMethod.bootstrapdropdownselection(Edit_Promotion_Edit_Store, "Edit_Promotion_Edit_Store",
					ht.get("Store Selection for Edit store"));
			CommonMethod.clickonWebElement(Edit_Promotion_Edit_Click_OutSide, "Outside to avoide overlapping");
			Edit_Promotion_Combination_Pool_Choosse_File_1
					.sendKeys("C:\\Users\\sunil\\Test File Format\\Edit_Combination_Pool_Cord_Set1.csv");
			Edit_Promotion_Combination_Pool_Choosse_File_2
					.sendKeys("C:\\Users\\sunil\\Test File Format\\Edit_Combination_Pool_Cord_Set2.csv");

			CommonMethod.clickonWebElement(Edit_Promotion_Combination_Pool_Upload_File_1, "Upload Button for file-1");
			Thread.sleep(3000);

			try {
				// Just keep in mind that this is a modal window operation so it will not work
				// as a normal window
				WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//div[contains(@class, 'modal') and contains(@class, 'show')]")));

				// Ensure the modal is active
				test.pass("Modal is visible: " + modal.isDisplayed());

				// Wait for the "OK" button to be clickable

				WebElement skudetails = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
						"//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[2]/td[3]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[1]")));

				String SKU_1 = skudetails.getText();
				test.pass("SKU1 which is uploading through edit for cord set1 is " + SKU_1);

				WebElement skudetails2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
						"//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[2]/td[3]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[2]/td[1]")));

				String SKU_2 = skudetails2.getText();
				test.pass("SKU2 which is uploading through edit for cord set1 is " + SKU_2);

				WebElement closeButton1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
						"//*[@id=\"view\"]/div[2]/div/div/div[4]/div/div/div/div[2]/div/div[1]/div/div[1]/div[3]/table/tbody/tr[2]/td[3]/div[2]/div/div/div/div[3]/div/span[2]/button")));

				// Click the "OK" button
				closeButton1.click();
				test.pass("Clicked on the 'Close' button.");
			} catch (Exception e) {
				System.out.println("Error while handling the modal: " + e.getMessage());

				// Optional: Use JavaScript executor as a fallback to click the button
				try {
					WebElement closeButton1 = driver.findElement(
							By.xpath("//button[@aria-label='OK' and contains(@class, 'p-button-primary')]"));
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].click();", closeButton1);
					test.pass("Clicked on the 'Close' button using JavaScript.");
					CommonMethod.takescreenshot();
				} catch (Exception jsException) {
					System.out.println("JavaScript click failed: " + jsException.getMessage());
				}
			}

			CommonMethod.clickonWebElement(Edit_Promotion_Combination_Pool_Upload_File_1, "Upload Button for file-2");

			try {
				// Just keep in mind that this is a modal window operation so it will not work
				// as a normal window
				WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//div[contains(@class, 'modal') and contains(@class, 'show')]")));

				// Ensure the modal is active
				test.pass("Modal is visible: " + modal.isDisplayed());

				WebElement okButton1 = wait.until(ExpectedConditions.elementToBeClickable(
						By.xpath("//button[@aria-label='OK' and contains(@class, 'p-button-primary')]")));

				// Click the "OK" button
				okButton1.click();
				test.pass("Clicked on the 'OK' button.");
			} catch (Exception e) {
				System.out.println("Error while handling the modal: " + e.getMessage());

				// Optional: Use JavaScript executor as a fallback to click the button
				try {
					WebElement okButton1 = driver.findElement(
							By.xpath("//button[@aria-label='OK' and contains(@class, 'p-button-primary')]"));
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].click();", okButton1);
					test.pass("Clicked on the 'OK' button using JavaScript.");
				} catch (Exception jsException) {
					test.pass("JavaScript click failed: " + jsException.getMessage());
				}
			}

			CommonMethod.clickonWebElement(Edit_Promotion_Combination_Pool_Upload_File_2, "Upload Button for file-2");
			Thread.sleep(3000);

			try {
				// Just keep in mind that this is a modal window operation so it will not work
				// as a normal window
				WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//div[contains(@class, 'modal') and contains(@class, 'show')]")));

				// Ensure the modal is active
				test.pass("Modal is visible: " + modal.isDisplayed());

				// Wait for the "OK" button to be clickable
				WebElement closeButton1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
						"//*[@id=\"view\"]/div[2]/div/div/div[4]/div/div/div/div[2]/div/div[1]/div/div[1]/div[3]/table/tbody/tr[2]/td[3]/div[2]/div/div/div/div[3]/div/span[2]/button")));

				// Click the "OK" button
				closeButton1.click();
				test.pass("Clicked on the 'Close' button.");
			} catch (Exception e) {
				test.pass("Error while handling the modal: " + e.getMessage());

				// Optional: Use JavaScript executor as a fallback to click the button
				try {
					WebElement closeButton1 = driver.findElement(
							By.xpath("//button[@aria-label='OK' and contains(@class, 'p-button-primary')]"));
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].click();", closeButton1);
					test.pass("Clicked on the 'Close' button using JavaScript.");
				} catch (Exception jsException) {
					test.pass("JavaScript click failed: " + jsException.getMessage());
				}
			}

			CommonMethod.clickonWebElement(Edit_Promotion_Combination_Pool_Upload_File_2, "Upload Button for file-1");
			CommonMethod.handleModalAndClickButton("//div[contains(@class, 'modal') and contains(@class, 'show')]",
					"//button[@aria-label='OK' and contains(@class, 'p-button-primary')]", "Ok Button");
			

			CommonMethod.clickonWebElement(Edit_Promotion_Combination_Pool_Add_More,
					"Add more button to add one more file");
			CommonMethod.clickonWebElement(Edit_Promotion_Combination_Pool_Delete_Row_3,
					"Delete button to delete one extra row ");
			CommonMethod.clickonWebElement(Edit_Promotion_Combination_Pool_Upload_File_1_Download_Button,
					"Download button to download  file 1 ");
			CommonMethod.clickonWebElement(Edit_Promotion_Combination_Pool_Upload_File_2_Download_Button,
					"Download button to download  file 2");
			CommonMethod.handleModalAndClickButton("//div[contains(@class, 'modal') and contains(@class, 'show')]",
					"//button[@aria-label='Update']", "Clicked on Updatebutton ");

			CommonMethod.handleModalAndClickButton("//div[contains(@class, 'modal') and contains(@class, 'show')]",
					"//span[contains(text(),'Yes')]", "clicked on Yes button");
		}
		
		else {

			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Edit_Promotion);
			Thread.sleep(3000);
			Edit_Promotion.click();

			WebElement active_status = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='active']")));

			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", active_status);

			if (active_status.isDisplayed() && active_status.isEnabled()) {

				Select select2 = new Select(active_status);
				select2.selectByValue(ht.get("Active status through Edit Promotion"));
				test.pass("Active status selected successfully");
			} else {
				test.pass("Active status dropdown is not interactable.");
			}

			CommonMethod.bootstrapdropdownselection(Edit_Promotion_Edit_Store, "Edit_Promotion_Edit_Store",
					ht.get("Store Selection for Edit store all type of promotion apart from combination pool"));
			CommonMethod.clickonWebElement(Edit_Promotion_Add_Custom_Products_Checkbox, "Add Custom Product CheckBox");
			CommonMethod.clickonWebElement(Edit_Promotion_Add_Custom_Products_Import, "Import button to upload a new file");
			Edit_Promotion_Add_Custom_Products_SelectFile.sendKeys("C:\\Users\\sunil\\Test File Format\\Edit_All_Promotion.csv");
			CommonMethod.clickonWebElement(Edit_Promotion_Add_Custom_Products_SelectFile_Import, "import buuton");
			
			
			WebElement skudetails = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
					"//*[@id=\"customSaleSetModal\"]/div/div/div[2]/form/div[3]/div/div/div/div[2]/div/table/tbody/tr[1]/td[1]")));

			String SKU_1 = skudetails.getText();
			test.pass("SKU1 which is uploading through edit for cord set1 is " + SKU_1);

			WebElement skudetails2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
					"//*[@id=\"customSaleSetModal\"]/div/div/div[2]/form/div[3]/div/div/div/div[2]/div/table/tbody/tr[2]/td[1]")));

			String SKU_2 = skudetails2.getText();
			test.pass("SKU2 which is uploading through edit for cord set1 is " + SKU_2);
			CommonMethod.clickonWebElement(Edit_Promotion_File_Import_Close, "Close Button");
			Edit_Promotion_Add_Custom_Products_SelectFile.sendKeys("C:\\Users\\sunil\\Test File Format\\Edit_All_Promotion.csv");
			
			CommonMethod.clickonWebElement(Edit_Promotion_Add_Custom_Products_SelectFile_Import, "import buuton");
			
			
			
			CommonMethod.clickonWebElement(Edit_Promotion_File_Import_OK, "Ok Button to import sales file set");
			CommonMethod.clickonWebElement(Edit_Promotion_Update, "Update Button to update all the changes information");
			CommonMethod.clickonWebElement(Edit_Promotion_Update_Yes, "Yes button to one final time submission of all the changes ");
			
			
			test.pass("Test Case Is Passed and all the feature are working fine");
		}
		test.pass("Test Case Is Passed and all the feature are working fine");

		return this;

	}

	public MasterPromotion_Pages clickOnDownload_Filter(Hashtable<String, String> ht) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));

		Thread.sleep(3000);
		WebElement scroll = driver.findElement(By.xpath("//div[@class='container-fluid mt-1']//li[3]//a[1]//span[1]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scroll);

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", MasterPromotion_Download);
		test.pass("Download button is working fine and csv file has downloaded successfully");
		
		

		

		return this;

	}

	public MasterPromotion_Pages filterOperation(Hashtable<String, String> ht) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
	
Thread.sleep(3000);
WebElement scroll = driver.findElement(By.xpath("//div[@class='container-fluid mt-1']//li[3]//a[1]//span[1]"));
((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scroll);

((JavascriptExecutor) driver).executeScript("arguments[0].click();", MasterPromotion_Filter);

		//CommonMethod.clickonWebElement(MasterPromotion_Filter, "filter button");
		CommonMethod.clickonWebElement(Promotion_Reset_Button, "reset button");
		CommonMethod.inputCalenderDate(clickedonstartdatecalenderfield, ht.get("Master Promotion Start Date Format"));
		CommonMethod.clickonWebElement("outsideclick", "clicked on outside");
		CommonMethod.inputCalenderDate(clickedon_end_date_calenderfield, ht.get("Master Promotion End Date Format"));
		CommonMethod.clickonWebElement("outsideclick", "clicked on outside");
		CommonMethod.bootstrapdropdownselection(Select_Active_Dropdown, "Select_Active_Dropdown",
				ht.get("Active Status1"));
		CommonMethod.bootstrapdropdownselection(Select_Active_Dropdown, "Select_Active_Dropdown",
				ht.get("Active Status2"));
		CommonMethod.clickonWebElement("outsideclick", "clicked on outside");
		CommonMethod.clickonWebElement(Promotion_Apply_Button, "Apply Button");
		// CommonMethod.getRowColNumber("Buy 1 Top & Bottom get 15% OFF");
//		String s1=driver.findElement(By.xpath("//span[@class='bh-mr-2']")).getText();
//		System.out.println(s1);

		WebElement tableitem = driver.findElement(By.xpath("//span[@class='bh-mr-2']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tableitem);
		Thread.sleep(3000);
		String s1 = tableitem.getText();
		System.out.println(s1);

		int pages = Integer.parseInt(s1.substring(s1.indexOf("of") + 3, s1.indexOf("items")).trim());
		System.out.println(pages);
		String promotion = driver.findElement(By.xpath("//tbody/tr[1]")).getText();
		// int pagescount=pages/10;

		int pagescount = pages / 10;

		if (pages % 10 == 0) {
			System.out.println("The pages count is " + pagescount);
			test.pass("The pages count is " + pagescount);
		} else {
			int pagecount = pagescount + 1;
			System.out.println("The pages count is" + pagecount);
			test.pass("The pages count is " + pagecount);
		}

		System.out.println(pagescount);
		test.pass("Total Item present in the table is " + pages + "and the latest promotion is  " + promotion);

//		WebElement scrollup =driver.findElement(By.xpath("//h6[normalize-space()='Master Promotions']"));
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scrollup);
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='d-flex justify-content-end mb-1 mt-3']")));
//		scrollup.click();
		return this;

	}

	public MasterPromotion_Pages MasterPromo_filter_all_button(Hashtable<String, String> ht) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));

		// CommonMethod.clickonWebElement(MasterPromotion_Download, "download button and
		// file got downloaded");

		CommonMethod.clickonWebElement(MasterPromotion_Filter, "filter button");
		CommonMethod.inputCalenderDate(clickedonstartdatecalenderfield, ht.get("Master Promotion Start Date Format"));
		CommonMethod.clickonWebElement("outsideclick", "clicked on outside");
		CommonMethod.inputCalenderDate(clickedon_end_date_calenderfield, ht.get("Master Promotion End Date Format"));
		CommonMethod.clickonWebElement("outsideclick", "clicked on outside");
		CommonMethod.bootstrapdropdownselection(Select_Active_Dropdown, "Select_Active_Dropdown",
				ht.get("Active Status1"));
		CommonMethod.bootstrapdropdownselection(Select_Active_Dropdown, "Select_Active_Dropdown",
				ht.get("Active Status2"));
		CommonMethod.clickonWebElement("outsideclick", "clicked on outside");
		CommonMethod.clickonWebElement(Promotion_Apply_Button, "Apply Button");

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));

		CommonMethod.clickonWebElement(MasterPromotion_Filter, "filter button");
		CommonMethod.clickonWebElement(Promotion_Reset_Button, "reset button");
		CommonMethod.clickonWebElement(Promotion_Close_Button, "Close button");

		return this;
	}

	public CreatePromotion_Page create_Promotion(Hashtable<String, String> ht) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.clickonWebElement(Promotion_Create_Button, "create button");
		return new CreatePromotion_Page();

	}

	public CombinationPoolPage create_Combination_Pool_Promotion(Hashtable<String, String> ht) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.clickonWebElement(Promotion_Create_Button, "create button");
		return new CombinationPoolPage();

	}

	public Package_Quantity_Page create_Package_Quantity_Promotion(Hashtable<String, String> ht) {
		test.pass("TC-037 is loading");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.clickonWebElement(Promotion_Create_Button, "create button");
		return new Package_Quantity_Page();

	}

	public Simple_Total_Page create_Simple_Total_Promotion(Hashtable<String, String> ht) {
		test.pass("TC- is loading");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.clickonWebElement(Promotion_Create_Button, "create button");
		return new Simple_Total_Page();

	}
}
