package pages;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.proenx.rdep.myproject.TestBase;

import utility.CommonMethod;
import utility.DatabaseCustomerTable;
import utility.DatabaseUtils;

public class Customers_Page extends TestBase {
	public Customers_Page() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[normalize-space()='Customers']")
	private static WebElement customer_Menu;

	@FindBy(xpath = "//span[normalize-space()='All Customers List']")
	private static WebElement All_customer_List_Sub_Menu;

	@FindBy(xpath = "//span[@class='p-button-icon ri-upload-2-fill ri-xl']")
	private static WebElement customer_Import;

	@FindBy(xpath = "//span[@class='p-button-icon ri-download-2-fill ri-xl']")
	private static WebElement customer_filter_for_Download;

	@FindBy(xpath = "//span[contains(text(),'Download')]")
	private static WebElement customer_Download_Button;

	@FindBy(xpath = "//span[contains(text(),'Download')]")
	private static WebElement customer_Import_csv_Download_button;

	@FindBy(xpath = "//span[contains(text(),'Filter')]")
	private static WebElement customer_Filter;

	@FindBy(xpath = "//div[@class='col-12 col-lg-4 mb-1']//div[@class='multiselect__tags']")
	private static WebElement customer_Import_Select_Store;

	@FindBy(xpath = "//input[@id='file']")
	private static WebElement customer_Import_Choose_File;

	@FindBy(xpath = "//span[contains(text(),'Upload')]")
	private static WebElement customer_Import_Upload_Button;

	@FindBy(xpath = "//div[@class='col-4 mb-4 align-self-end text-end gap-2']//button[@aria-label='Close']")
	private static WebElement customer_Import_Close_Button;

	@FindBy(xpath = "//a[@class='file-format-link']")
	private static WebElement customer_Import_File_Format_Link;

	@FindBy(xpath = "//span[contains(text(),'Yes')]")
	private static WebElement customer_Import_Upload_Yes;

	@FindBy(xpath = "//div[@class='d-flex mt-2']//span[@class='p-button-label'][normalize-space()='Close']")
	private static WebElement customer_Import_Upload_Close;

	@FindBy(xpath = "//span[@class='bh-mr-2']")
	private static WebElement Scroll_Down;

	@FindBy(xpath = "//input[@placeholder='Search...']")
	private static WebElement customer_Global_Search_field;

	@FindBy(xpath = "//button[@type='submit']")
	private static WebElement customer_Global_Search_Submit_button;

	@FindBy(xpath = "//span[@class='multiselect__single']")
	private static WebElement customer_filter_Select_Store;

	@FindBy(xpath = "//span[@class='multiselect__single']")
	private static WebElement customer_filter_Apply_button;

	@FindBy(xpath = "//span[@class='bh-mr-2']")
	private static WebElement customer_table_pagination_Message;

	@FindBy(xpath = "//span[normalize-space()='Manage']")
	private static WebElement Manage_Menu;

	@FindBy(xpath = "//span[normalize-space()='Data Jobs']")
	private static WebElement DataJobs_SubMenu;

	@FindBy(xpath = "//span[normalize-space()='Data Jobs']")
	private static WebElement Global_Search_Key_Remove_Button;

	public Customers_Page import_Customer_File(Hashtable<String, String> ht)
			throws InterruptedException, TimeoutException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.clickonWebElement(customer_Import, "Import button to upload a curstomer details csv file");

		WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id=\"view\"]/div[2]/div/div/div[2]/div/div/div/div/div/div/div[3]")));
		System.out.println("Modal is visible: " + modal.isDisplayed());
		Thread.sleep(3000);
		CommonMethod.bootstrapdropdownselection(customer_Import_Select_Store, "customer_Import_Select_Store",
				ht.get("Select Store for adding new customer"));

		driver.findElement(By.xpath("//input[@id='file']"))
				.sendKeys("C:\\Users\\sunil\\Test File Format\\customer.csv");
		CommonMethod.clickonWebElement(customer_Import_File_Format_Link, "file format link to download file format");
		CommonMethod.clickonWebElement(customer_Import_Upload_Button, "upload button to upload new customers");

		Thread.sleep(3000);
		CommonMethod.handleModalAndClickButton(
				"//*[@id=\"view\"]/div[2]/div/div/div[2]/div/div/div/div/div/div/div[3]/div/div/div[2]/div/div/div/div/div",
				"//span[contains(text(),'Yes')]", "yes");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		boolean found = false;
		List<String> matchedData = new ArrayList<>();
		List<String> matchedRowData = new ArrayList<>();

		while (true) {
			// Locate rows and columns in the current table
			List<WebElement> rows = wait
					.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//tbody/tr")));
			List<WebElement> columns = driver.findElements(By.xpath("//table/thead/tr/th/div"));

			int rowCount = rows.size();
			int columnCount = columns.size();

			// Check if the table is empty
			if (rowCount == 0 || columnCount == 0) {
				System.out.println("Table is empty on this page.");
				test.fail("Table is empty on this page.");
				break;
			}

			// Iterate over rows and columns
			outerLoop: for (int i = 1; i <= rowCount; i++) {
				for (int j = 1; j <= columnCount; j++) {
					try {
						WebElement cellElement = wait.until(ExpectedConditions
								.presenceOfElementLocated(By.xpath("//tbody/tr[" + i + "]/td[" + j + "]")));

						String cellText = cellElement.getText();

						if (cellText.equals(ht.get("required data in the table"))) {
							found = true;

							WebElement rowElement = wait.until(
									ExpectedConditions.presenceOfElementLocated(By.xpath("//tbody/tr[" + i + "]")));
							String rowData = rowElement.getText();

							matchedData.add("Row: " + i + ", Column: " + j + ", Data: " + cellText);
							matchedRowData.add("Row Data: " + rowData);

							test.pass("Match found at Row " + i + ", Column " + j);
							test.pass("Row Data: " + rowData);
							CommonMethod.takescreenshot();
							test.pass("Match found at Row " + i + ", Column " + j + ". Data: " + cellText
									+ ". Row Data: " + rowData);

							String query = "select * from customer c  where first_name = '" + cellText + "'";
							boolean isValid = DatabaseCustomerTable.validateTestCaseData(query, cellText);

							Assert.assertTrue(isValid, "Test case data NOT found in the database.");

							if (isValid) {
								test.pass("Test case data found in the database.");
							} else {
								test.pass("Test case data NOT found in the database.");
							}

							break outerLoop; // Exit loops if match is found
						}
					} catch (StaleElementReferenceException e) {
						test.pass("Stale Element at Row " + i + ", Column " + j + ": Retrying...");
						rows = driver.findElements(By.xpath("//tbody/tr"));
						columns = driver.findElements(By.xpath("//table/thead/tr/th/div"));
						break;
					}
				}
			}

			if (found) {
				break;
			}

			// Handle pagination (Next button click)
			try {
				WebElement nextButton = driver.findElement(By.xpath("//button[@class='bh-page-item next-page']"));

				if (nextButton.isDisplayed() && nextButton.isEnabled()) {
					test.pass("Clicking the Next button...");
					CommonMethod.takescreenshot();
					// Scroll into view and click using JavaScript
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextButton);
					((JavascriptExecutor) driver).executeScript("arguments[0].click();", nextButton);

					wait.until(ExpectedConditions.presenceOfElementLocated(By.className("spinner-wrapper")));
					wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));

					// Wait for table rows to refresh
					wait.until(ExpectedConditions.or(
							ExpectedConditions
									.not(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//tbody/tr"))), // Rows
																														// disappear
																														// temporarily
							ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//tbody/tr")) // New rows appear
					));
				} else {
					test.pass("No more pages to check.");
					break;
				}
			} catch (NoSuchElementException e) {
				test.pass("No 'Next' button found. Ending pagination.");
				break;
			}
		}

		// If no matches found
		if (!found) {
			String errorMessage = ht.get("required data in the table") + " is not present in any page.";
			test.pass(errorMessage);
			test.fail(errorMessage);
			Assert.fail(errorMessage);
		} else {
			test.pass("All Matches Found:");
			for (int index = 0; index < matchedData.size(); index++) {
				test.pass(matchedData.get(index));
				test.pass(matchedRowData.get(index));
			}
			test.pass("All matches verified. Total matches: " + matchedData.size());
			CommonMethod.takescreenshot();
		}

		return this;
	}

	public Customers_Page validation_of_global_search_key(Hashtable<String, String> ht) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		CommonMethod.entertextintoinputbox(customer_Global_Search_field, ht.get("Global Search Key Unique Data"));
		CommonMethod.clickonWebElement(customer_Global_Search_Submit_button,
				"global search key button to search any particular data ");
		WebElement cellElement = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tbody/tr[1]/td[3]")));

		String cellText = cellElement.getText();
		Assert.assertEquals(cellText, ht.get("Global Search Key Unique Data"));
		test.pass(" Data Searching through Global Search key for Customer List table  present in the table");
		test.pass("Data which is present in the table is " + cellText);

		return this;
	}

	public Customers_Page Global_SerchKey_with_filter_download(Hashtable<String, String> ht)
			throws InterruptedException {

		CommonMethod.entertextintoinputbox(customer_Global_Search_field, ht.get("Global Search Key Unique Data"));
		CommonMethod.clickonWebElement(customer_Global_Search_Submit_button,
				"global search key button to search any particular data ");

		CommonMethod.clickonWebElement(customer_filter_for_Download, "filter  Button to download any csv files");
		CommonMethod.clickonWebElement(customer_Download_Button,
				"Download button to download data search through Global Search Key");

		CommonMethod.clickonWebElement(Manage_Menu, "Manage Menu");
		Thread.sleep(3000);
		CommonMethod.clickonWebElement(DataJobs_SubMenu, "Data Jobs SubMenu");

		int maxAttempts = 5; // Set maximum retry attempts
		int attempt = 0;
		boolean isDownloadSuccessful = false;

		while (attempt < maxAttempts) {
			// Step 1: Get pagination data
			String pagination = customer_table_pagination_Message.getText();
			int pages = Integer
					.parseInt(pagination.substring(pagination.indexOf("of") + 3, pagination.indexOf("items")).trim());

			String pagesStr = String.valueOf(pages);
			test.pass("Attempt: " + (attempt + 1) + ", Expected Items to be downloaded is : " + pagesStr);

			CommonMethod.clickonWebElement(Manage_Menu, "Manage Menu");
			CommonMethod.clickonWebElement(DataJobs_SubMenu, "Data Jobs SubMenu");

			String dataJobsStatus = driver.findElement(By.xpath("//tbody/tr[1]/td[10]")).getText().trim();
			String dataJobsRecord = driver.findElement(By.xpath("//tbody/tr[1]/td[6]")).getText().trim();

			// Step 4: Check if download is successful
			if (dataJobsStatus.equals("COMPLETED") && dataJobsRecord.equals(pagesStr)) {
				test.pass("Global Search Key has downloaded data successfully");
				isDownloadSuccessful = true;
				break; // Exit loop if successful
			} else {
				test.pass("Download not completed, retrying...");

				// Step 5: Retry Download Process
				CommonMethod.clickonWebElement(customer_Menu, "Customer Menu");
				CommonMethod.clickonWebElement(All_customer_List_Sub_Menu, "Customer List Sub Menu");
				CommonMethod.entertextintoinputbox(customer_Global_Search_field,
						ht.get("Global Search Key Unique Data"));
				CommonMethod.clickonWebElement(customer_Global_Search_Submit_button, "Global Search Key Submit Button");

				CommonMethod.clickonWebElement(customer_filter_for_Download, "Filter Button to Download CSV");
				CommonMethod.clickonWebElement(customer_Download_Button, "Download Button for Global Search Key Data");
			}

			attempt++;
			Thread.sleep(5000); // Wait for 5 seconds before retrying
		}

		// If download was unsuccessful after all attempts, mark as fail
		if (!isDownloadSuccessful) {
			test.fail("File is not downloading through data jobs after " + maxAttempts + " attempts.");
		}

		CommonMethod.clickonWebElement(customer_Menu, "Customer Menu");
		CommonMethod.clickonWebElement(All_customer_List_Sub_Menu, "Customer List Sub Menu");

		return this;
	}

	public Customers_Page Global_SerchKey_Operation(Hashtable<String, String> ht) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		// valid data validation
		CommonMethod.entertextintoinputbox(customer_Global_Search_field, ht.get("Global Search Key Unique Data"));
		CommonMethod.clickonWebElement(customer_Global_Search_Submit_button,
				"global search key button to search any particular data ");

		String pagination = customer_table_pagination_Message.getText();
		int pages = Integer
				.parseInt(pagination.substring(pagination.indexOf("of") + 3, pagination.indexOf("items")).trim());

		String pagesStr = String.valueOf(pages);
		test.pass("The total item present in the table for above keyward is " + pagesStr);

		// invalid data validation
		customer_Global_Search_field.clear();
		CommonMethod.entertextintoinputbox(customer_Global_Search_field, ht.get("Global Search Key Invalid Data"));
		CommonMethod.clickonWebElement(customer_Global_Search_Submit_button,
				"global search key button to search any particular data ");
		String no_data = driver.findElement(By.xpath("//td[normalize-space()='No data available']")).getText();

		WebElement toastMessage = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@class='v-toast__text']")));

		if (toastMessage.isDisplayed()) {
			String Actual_Pagetitle = toastMessage.getText();
			String Error_Messag = "No data found for selected search key " + ht.get("Global Search Key Invalid Data")
					+ ".";
			Assert.assertEquals(Actual_Pagetitle, Error_Messag);
			test.pass("");
		}

		Assert.assertEquals(no_data, "No data available");
		test.pass("No data Availble in the Customer Table for this invalid Data searchrd by Globa Search Key ");

		driver.navigate().refresh();

		// invalid column data validation

		return this;

	}

	public Customers_Page pos_consolle_all_api_response_check(Hashtable<String, String> ht)
			throws InterruptedException, IOException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		List<WebElement> alist = driver.findElements(By.tagName("a"));
		test.pass("Total APIs present on POS ConSole: " + alist.size());
		for (WebElement aElement : alist) {
			String url = aElement.getDomAttribute("href");
			String url2 = "https://px.uat.rdep.io" + url;
			test.pass(aElement.getDomAttribute("href"));
			CommonMethod.checkBrokenLink(url2);

		}

		return this;
	}

}
