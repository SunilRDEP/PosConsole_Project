package pages;

import java.time.Duration;
import java.util.Hashtable;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
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

public class E_Receipt_Page extends TestBase {
	public E_Receipt_Page() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@class='nav__label'][normalize-space()='Reports']")
	private static WebElement E_Receipt_Reports;

	@FindBy(xpath = "//span[normalize-space()='Digital Receipt Report']")
	private static WebElement E_Receipt_Digital_Receipt_Report_Sub_Menu;

	@FindBy(xpath = "//h4[@id='offcanvasRightLabel']")
	private static WebElement DR_Filter_Filter_Outside;

	@FindBy(xpath = "//div[@class='px-1 py-2']//div[@class='col-12']//input[@placeholder='Select Date']")
	private static WebElement DR_Filter_Start_Date;

	@FindBy(xpath = "//button[@aria-label='Apply']")
	private static WebElement DR_Filter_Apply_Button;

	@FindBy(xpath = "//span[contains(text(),'Close')]")
	private static WebElement DR_Filter_Close_Button;

	@FindBy(xpath = "//button[@aria-label='Reset']")
	private static WebElement DR_Filter_Reset_Button;

	@FindBy(xpath = "//span[contains(text(),'Filter')]")
	private static WebElement DR_Filter;

	@FindBy(xpath = "//button[@class='bh-page-item next-page']")
	private static WebElement DR_Next_Page;
	
	@FindBy(xpath = "//div[@class='col-12 mt-2']//input[@placeholder='Select Date']")
	private static WebElement DR_Filter_End_Date;
	
	@FindBy(xpath = "//span[normalize-space()='Select State']")
	private static WebElement DR_Filter_Select_State;
	
	

	public E_Receipt_Page digital_Receipt_Table_Data_Verification(Hashtable<String, String> ht) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		CommonMethod.clickonWebElement(E_Receipt_Reports, "Reports Menu");
		CommonMethod.clickonWebElement(E_Receipt_Digital_Receipt_Report_Sub_Menu, " DR Report SubMenu");

		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(text(),'Filter')]")).click();
		CommonMethod.inputCalenderDate(DR_Filter_Start_Date, ht.get("Inward History Filter Start date"));
		CommonMethod.clickonWebElement(DR_Filter_Filter_Outside, "outside");

		CommonMethod.clickonWebElement(DR_Filter_Apply_Button, "Inventory List Filter Apply Button");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		int result = 0;
		WebElement Istring=driver.findElement(By.xpath("//span[@class='bh-mr-2']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Istring);
		String inputString = driver.findElement(By.xpath("//span[@class='bh-mr-2']")).getText();

		// Define the regex pattern
		String regex = "\\bof (\\d+)";

		// Compile the pattern and create a matcher
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(inputString);

		// Extract the number after 'of'
		if (matcher.find()) {
			result = Integer.parseInt(matcher.group(1));
			System.out.println("Extracted number: " + result);
			test.info("Total number of items present in the table are " + result);
		} else {
			System.out.println("No match found.");
			test.info("No match found.");
		} 
		
//	CommonMethod.bootstrapdropdownselection(Inventory_Stock_Request_Inward_Filter_Select_STore,
//			"Inventory_Stock_Request_Inward_Filter_Select_STore", ht.get("Inventory inward Filter Select Store1"));
//	CommonMethod.clickonWebElement(Inventory_Filter_Outside, "Outside to avoid element overlaping");

		// Get row and column counts
		// Define explicit wait
		int currentPage = 1;
		int totalPages = result / 10; // Assuming there are 4 pages
		if(result%10!=0) {
			totalPages=totalPages+1;
		}

		outerLoop: while (currentPage <= totalPages) {
			// Fetch rows and columns for the current page
			List<WebElement> rows = wait
					.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//tbody/tr")));
			List<WebElement> columns = wait
					.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//table/thead/tr/th/div")));

			int rowCount = rows.size();
			int columnCount = columns.size();

			// Check if the table is empty
			if (rowCount == 0 || columnCount == 0) {
				System.out.println("Table is empty on page " + currentPage + ".");
				test.fail("Table is empty on page " + currentPage + ".");
				Assert.fail("Table is empty on page " + currentPage + ".");
			}

			boolean found = false;

			// Iterate over rows and columns
			for (int i = 1; i <= rowCount; i++) {
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

								System.out.println(
										"Data found at Row " + i + ", Column " + j + " on page " + currentPage);
								System.out.println("Row Data: " + rowData);

								test.pass("Data verified. Found at Row " + i + ", Column " + j + " on page "
										+ currentPage + ". Data: " + cellText + ". Row Data: " + rowData);
								break outerLoop; // Exit all loops
							} else {
								System.out.println("Element is not clickable at Row " + i + ", Column " + j);
								test.fail("Element is not clickable at Row " + i + ", Column " + j);
							}
						}
					} catch (StaleElementReferenceException e) {
						System.out.println("Stale Element Reference at Row " + i + ", Column " + j + ": Retrying...");
						rows = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//tbody/tr")));
					} catch (NoSuchElementException e) {
						System.out.println("No Such Element at Row " + i + ", Column " + j + ": " + e.getMessage());
					} catch (Exception e) {
						System.out
								.println("Unexpected exception at Row " + i + ", Column " + j + ": " + e.getMessage());
					}
				}
			}

			// If data not found on the current page, go to the next page
			if (!found && currentPage < totalPages) {
				try {

					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", DR_Next_Page);
					Thread.sleep(3000);
					DR_Next_Page.click();

					currentPage++;
					System.out.println("Navigated to page " + currentPage);
				} catch (Exception e) {
					System.out.println("Failed to navigate to page " + (currentPage + 1) + ": " + e.getMessage());
					break; // Exit the loop if navigation fails
				}
			} else if (!found && currentPage == totalPages) {
				System.out.println("Data not found after checking all pages.");
				String errorMessage = ht.get("required data in the table") + " is not present in the table.";
				test.fail(errorMessage);
				Assert.fail(errorMessage);
				break;
			}
		}

		return this;
 
	}
	
	public E_Receipt_Page digital_Receipt_Filter_Operation(Hashtable<String, String> ht) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("spinner-wrapper")));
		CommonMethod.clickonWebElement(E_Receipt_Reports, "Reports Menu");
		CommonMethod.clickonWebElement(E_Receipt_Digital_Receipt_Report_Sub_Menu, " DR Report SubMenu");

		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(text(),'Filter')]")).click();
		CommonMethod.inputCalenderDate(DR_Filter_Start_Date, ht.get("Inward History Filter Start date"));
		CommonMethod.clickonWebElement(DR_Filter_Filter_Outside, "outside");

		CommonMethod.clickonWebElement(DR_Filter_Apply_Button, "Inventory List Filter Apply Button");
return this;
	}
}
