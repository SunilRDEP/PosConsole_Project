package pages;

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

public class Customers_Page extends TestBase {
	public Customers_Page() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@class='p-button-icon ri-upload-2-fill ri-xl']")
	private static WebElement customer_Import;

	@FindBy(xpath = "//div[@class='d-flex justify-content-between align-items-center gap-1']//span[2]//button[1]")
	private static WebElement customer_Import_csv_Download;

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

}
