package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.proenx.rdep.myproject.TestBase;

import utility.CommonMethod;

public class Inward_History_Page extends TestBase {
	public Inward_History_Page() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@class='p-button p-component p-button-icon-only p-button-primary p-button-raised p-button-text custom-border-primary custom-rounded bg-white p-button-small']")
	private static WebElement Inventory_Stock_Request_Inward_CSV_Download;

	@FindBy(xpath = "//span[contains(text(),'Filter')]")
	private static WebElement Inventory_Stock_Request_Inward_Filter;

	@FindBy(xpath = "//button[@aria-label='Create']")
	private static WebElement Inventory_Stock_Request_Inward_Create;

	@FindBy(xpath = "//button[@aria-label='Apply']")
	private static WebElement Inventory_Stock_Request_Inward_Filter_Apply_Button;

	@FindBy(xpath = "//span[contains(text(),'Close')]")
	private static WebElement Inventory_Stock_Request_Inward_Filter_Close_Button;

	@FindBy(xpath = "//button[@aria-label='Reset']")
	private static WebElement Inventory_Stock_Request_Inward_Filter_Reset_Button;

	@FindBy(xpath = "//input[@placeholder='Search']")
	private static WebElement Inventory_Stock_Request_Inward_Filter_Search_Box;

	@FindBy(xpath = "//span[contains(text(),'Select Store')]")
	private static WebElement Inventory_Stock_Request_Inward_Filter_Select_STore;

	@FindBy(xpath = "//h4[@id='offcanvasRightLabel']")
	private static WebElement Inventory_Filter_Outside;

	@FindBy(xpath = "//div[@class='px-1 py-2']//div[@class='col-12']//input[@placeholder='Select Date']")
	private static WebElement Inventory_Filter_Start_Date;

	public Inward_History_Page stock_request_inward_filter_operation(Hashtable<String, String> ht) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));

		CommonMethod.clickonWebElement(Inventory_Stock_Request_Inward_Filter, "filter Button");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.entertextintoinputbox(Inventory_Stock_Request_Inward_Filter_Search_Box,
				ht.get("required data in the table"));
		CommonMethod.inputCalenderDate(Inventory_Filter_Start_Date, ht.get("Inward History Filter Start date"));
		CommonMethod.clickonWebElement(Inventory_Filter_Outside, "outside");
//	CommonMethod.bootstrapdropdownselection(Inventory_Stock_Request_Inward_Filter_Select_STore,
//			"Inventory_Stock_Request_Inward_Filter_Select_STore", ht.get("Inventory inward Filter Select Store1"));
//	CommonMethod.clickonWebElement(Inventory_Filter_Outside, "Outside to avoid element overlaping");
		CommonMethod.clickonWebElement(Inventory_Stock_Request_Inward_Filter_Apply_Button,
				"Inventory List Filter Apply Button");
		// Get row and column counts
		// Define explicit wait

		List<WebElement> rows = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//tbody/tr")));
		List<WebElement> columns = wait
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//table/thead/tr/th/div")));

		int rowCount = rows.size();
		int columnCount = columns.size();

		// Check if the table is empty
		if (rowCount == 0 || columnCount == 0) {
			System.out.println("Table is empty.");
			test.fail("Table is empty.");
			Assert.fail("Table is empty.");
		}

		boolean found = false;

		// Iterate over rows and columns
		outerLoop: for (int i = 1; i <= rowCount; i++) {
			for (int j = 1; j <= columnCount; j++) {
				try {
					// Wait for the cell element to be present
					WebElement cellElement = wait.until(ExpectedConditions
							.presenceOfElementLocated(By.xpath("//tbody/tr[" + i + "]/td[" + j + "]")));

					// Get cell text
					String cellText = cellElement.getText();

					// Check if cell matches required data
					if (cellText.equals(ht.get("required data in the table"))) {
						found = true;

						// Wait for the cell to be clickable
						WebElement clickableCell = wait.until(ExpectedConditions
								.elementToBeClickable(By.xpath("//tbody/tr[" + i + "]/td[" + j + "]")));

						if (clickableCell.isDisplayed() && clickableCell.isEnabled()) {
							// Re-fetch row to avoid stale reference
							WebElement rowElement = wait.until(
									ExpectedConditions.presenceOfElementLocated(By.xpath("//tbody/tr[" + i + "]")));
							String rowData = rowElement.getText(); // Get full row data dynamically

							System.out.println("Data found at Row " + i + ", Column " + j);
							System.out.println("Row Data: " + rowData);

							test.pass("Data verified. Found at Row " + i + ", Column " + j + ". Data: " + cellText
									+ ". Row Data: " + rowData);
							break outerLoop; // Exit both loops
						} else {
							System.out.println("Element is not clickable at Row " + i + ", Column " + j);
							test.fail("Element is not clickable at Row " + i + ", Column " + j);
						}
					}
				} catch (StaleElementReferenceException e) {
					System.out.println("Stale Element Reference at Row " + i + ", Column " + j + ": Retrying...");
					// Re-fetch the row and continue
					rows = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//tbody/tr")));
				} catch (NoSuchElementException e) {
					System.out.println("No Such Element at Row " + i + ", Column " + j + ": " + e.getMessage());
					// Log and continue checking
				} catch (Exception e) {
					System.out.println("Unexpected exception at Row " + i + ", Column " + j + ": " + e.getMessage());
					// Handle unexpected errors
				}
			}
		}

		// If the data was not found
		if (!found) {
			String errorMessage = ht.get("required data in the table1") + " is not present in the table.";
			System.out.println(errorMessage);
			test.fail(errorMessage);
			Assert.fail(errorMessage);
		}

		return this;

	}

	public Inward_History_Page stock_request_inward_filter_operation2(Hashtable<String, String> ht)
			throws TimeoutException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));

		CommonMethod.clickonWebElement(Inventory_Stock_Request_Inward_Filter, "filter Button");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
//		CommonMethod.entertextintoinputbox(Inventory_Stock_Request_Inward_Filter_Search_Box,
//				ht.get("required data in the table"));
		CommonMethod.inputCalenderDate(Inventory_Filter_Start_Date, ht.get("Inward History Filter Start date"));
		CommonMethod.clickonWebElement(Inventory_Filter_Outside, "outside");
//	CommonMethod.bootstrapdropdownselection(Inventory_Stock_Request_Inward_Filter_Select_STore,
//			"Inventory_Stock_Request_Inward_Filter_Select_STore", ht.get("Inventory inward Filter Select Store1"));
//	CommonMethod.clickonWebElement(Inventory_Filter_Outside, "Outside to avoid element overlaping");
		CommonMethod.clickonWebElement(Inventory_Stock_Request_Inward_Filter_Apply_Button,
				"Inventory List Filter Apply Button");
		// Get row and column counts
		// Define explicit wait

		// Define explicit wait

		// Define explicit wait

		List<WebElement> rows = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//tbody/tr")));


		List<WebElement> columns = driver.findElements(By.xpath("//table/thead/tr/th/div"));

		int rowCount = rows.size();
		System.out.println(rowCount);
		int columnCount = columns.size();

		// Check if the table is empty
		if (rowCount == 0 || columnCount == 0) {
			System.out.println("Table is empty.");
			test.fail("Table is empty.");
			Assert.fail("Table is empty.");
		}

		List<String> matchedData = new ArrayList<>();
		List<String> matchedRowData = new ArrayList<>();
		boolean found = false;

		// Explicit wait
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Iterate over rows and columns
		outerLoop: for (int i = 1; i <= rowCount; i++) {
			for (int j = 1; j <= columnCount; j++) {
				try {
					// Wait for cell element to be present
					WebElement cellElement = wait.until(ExpectedConditions
							.presenceOfElementLocated(By.xpath("//tbody/tr[" + i + "]/td[" + j + "]")));

					// Get cell text
					String cellText = cellElement.getText();

					// Check if the cell matches required data
					if (cellText.equals(ht.get("required data in the table"))) {
						found = true;

						// Re-fetch row to get full data
						WebElement rowElement = wait
								.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tbody/tr[" + i + "]")));
						String rowData = rowElement.getText();

						// Store matched data and row data
						matchedData.add("Row: " + i + ", Column: " + j + ", Data: " + cellText);
						matchedRowData.add("Row Data: " + rowData);

						System.out.println("Match found at Row " + i + ", Column " + j);
						System.out.println("Row Data: " + rowData);

						test.pass("Match found at Row " + i + ", Column " + j + ". Data: " + cellText + ". Row Data: "
								+ rowData);
					}
				} catch (StaleElementReferenceException e) {
					System.out.println("Stale Element at Row " + i + ", Column " + j + ": Retrying...");
					// Refresh rows and columns to avoid stale references
					rows = driver.findElements(By.xpath("//tbody/tr"));
					columns = driver.findElements(By.xpath("//table/thead/tr/th/div"));
					break; // Break the inner loop to retry the row
				}
			}
		}

		// If no matches found
		if (!found) {
			String errorMessage = ht.get("required data in the table") + " is not present in the table.";
			System.out.println(errorMessage);
			test.fail(errorMessage);
			Assert.fail(errorMessage);
		} else {
			// Log all matched data
			test.pass("All Matches Found:");
			for (int index = 0; index < matchedData.size(); index++) {
				System.out.println(matchedData.get(index));
				System.out.println(matchedRowData.get(index));
			}
			test.pass("All matches verified. Total matches: " + matchedData.size());
		}

		return this;

	}
}