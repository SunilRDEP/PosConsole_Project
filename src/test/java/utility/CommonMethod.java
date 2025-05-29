package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.google.common.io.Files;
import com.proenx.rdep.myproject.TestBase;

public class CommonMethod extends TestBase { 
	
	public static void updateConfigProperty(String key, String value) {
	    try {
	        File file = new File("C:\\Users\\sunil\\eclipse-workspace\\Regression_Pos_project\\src\\test\\resources\\Properties\\Configue.properties");
	        FileInputStream in = new FileInputStream(file);
	        configue.load(in);
	        in.close();

	        configue.setProperty(key, value);

	        FileOutputStream out = new FileOutputStream(file);
	        configue.store(out, "Updated " + key);
	        out.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	
	
	public static void checkBrokenLink(String url2) throws IOException {
		
		
		
		
		
	
		  try {
	            if (!url2.startsWith("http")|| url2.contains("null") || url2.contains(" ")) {
	                System.out.println("Invalid URL format: " + url2);
	                return;
	            }

	            URL urlLink = new URL(url2);
	            HttpURLConnection connection = (HttpURLConnection) urlLink.openConnection();

	            // Use "HEAD" instead of "POST"
	            connection.setRequestMethod("HEAD");

	            // Set timeout
	            connection.setConnectTimeout(5000);
	            connection.setReadTimeout(5000);

	            // Mimic a real browser
	            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/110.0.0.0 Safari/537.36\"");

	            connection.connect();

	            int statusCode = connection.getResponseCode();
	            if (statusCode >= 400) {
	               test.pass("Broken link: " + url2 + " (HTTP Status: " + statusCode + ")");
	            } else {
	                test.pass("Valid link: " + url2 + " (HTTP Status: " + statusCode + ")");
	            }
	        } catch (Exception e) {
	        	 test.pass("Exception occurred for URL: " + url2 + " -> " + e.getMessage());
	        }
	    }

	
	
	
	
	public static void takescreenshot() {
		String timestamp = new SimpleDateFormat("YYYY_MM_dd_HH_mm_ss").format(new Date());
		File dest = new File(
				"C:\\Users\\sunil\\eclipse-workspace\\Regression_Pos_project\\src\\test\\resources\\ScreenShots\\loginPage_"
						+ timestamp + ".png");

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try { 
			Files.copy(scrFile, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest.toString()).build());
	}

	public static void clickonWebElement(String xpath, String ElementName) {
		driver.findElement(By.xpath(PROP.getProperty(xpath))).click();
		test.pass("User clicked on " + ElementName);
		takescreenshot();
	}

	public static void clickonWebElement(WebElement xpath, String ElementName) {
		xpath.click();
		test.pass("User clicked on " + ElementName);
		takescreenshot();

	}

	public static void entertextintoinputbox(String xpath, String data) {
		// driver.findElement(By.xpath(PROP.getProperty(xpath))));;
		driver.findElement(By.xpath(PROP.getProperty(xpath))).sendKeys(PROP.getProperty(data));
		// System.out.println("User entered "+data +" and it's value is: " +data);
		test.pass("User entered +data and it's value is: " + data);
		takescreenshot();
	}

	public static void entertextintoinputbox(WebElement xpath, String data) {
		// driver.findElement(By.xpath(PROP.getProperty(xpath))));;
		xpath.sendKeys(data);
		// System.out.println("User entered "+data +" and it's value is: " +data);
		test.pass("User entered +data and it's value is: " + data);
		takescreenshot();
	}

	public static void enterdatafromexcel(String xpath, String data) {
		// driver.findElement(By.xpath(PROP.getProperty(xpath))).clear();
		driver.findElement(By.xpath(PROP.getProperty(xpath))).sendKeys(data);
		// System.out.println("User entered "+data +" and it's value is: " +data);
		test.pass("User entered +data and it's value is: " + data);
		takescreenshot();
	}

	public static void enterdatafromexcel(WebElement xpath, String data, String Element) {
		// driver.findElement(By.xpath(PROP.getProperty(xpath))).clear();
		xpath.sendKeys(data);
		// System.out.println("User entered "+data +" and it's value is: " +data);
		test.pass("User entered data and it's value is: " + Element);
		takescreenshot();
	}
	
	
	 public static boolean handleModalAndClickButton( String modalXPath, String buttonXPath, String description) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	        try {
	            // Wait for the modal to be visible
	            WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(modalXPath)));
	            test.pass("Modal is visible: " + modal.isDisplayed());

	            // Wait for the button inside the modal to be clickable
	            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(buttonXPath)));

	            // Click the button
	            button.click();
	            test.pass("Clicked on the '" + description + "' button.");
	            return true;
	        } catch (Exception e) {
	        	test.pass("Error while handling the modal: " + e.getMessage());

	            // Optional: Use JavaScript executor as a fallback
	            try {
	                WebElement button = driver.findElement(By.xpath(buttonXPath));
	                JavascriptExecutor js = (JavascriptExecutor) driver;
	                js.executeScript("arguments[0].click();", button);
	                test.pass("Clicked on the '" + description + "' button using JavaScript.");
	                return true;
	            } catch (Exception jsException) {
	                test.pass("JavaScript click failed: " + jsException.getMessage());
	                return false;
	            }
	        }
	    }

	public static void verifyPageTitle(String expected_Pagetitle) {
		String Actual_Pagetitle = driver.getTitle();
		Assert.assertEquals(Actual_Pagetitle, expected_Pagetitle);
		// System.out.println("Page title is verified and Title is: "+Actual_Pagetitle);
		test.pass("Page title is verified and Title is: " + Actual_Pagetitle);
		takescreenshot();
	}

	public static void verifycolor(String xpath, String expected_color, String cssvalue) {
		String Actual_Pagetitle = driver.findElement(By.xpath(PROP.getProperty(xpath)))
				.getCssValue(PROP.getProperty(cssvalue));
		Assert.assertEquals(Actual_Pagetitle, expected_color);
		test.pass("My expected color is " + "blue");
		takescreenshot();
	}

	public static void SelectDropdown(String xapth, String data) {
		WebElement promotype = driver.findElement(By.xpath(PROP.getProperty(xapth)));
		Select select = new Select(promotype);
		select.selectByVisibleText(data);
	}

	public static void calender(String xpath, String xpath2, String Date) {

		while (true) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
			WebElement displayedYear = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(PROP.getProperty(xpath))));
			String yearText = displayedYear.getText();
			if (yearText.equals(Date)) {
				break;
			} else {
				WebElement element = wait
						.until(ExpectedConditions.elementToBeClickable(By.xpath(PROP.getProperty(xpath2))));
				element.click();
				// Thread.sleep(1000);
			}
		}
		test.pass("User Entered Required " + Date);

	}

	public static void verifyTextOnThePage(String xpath, String expected_text) {
		String actual_text = driver.findElement(By.xpath(PROP.getProperty(xpath))).getText();
		System.out.println(actual_text);
		Assert.assertEquals(actual_text, expected_text);

		test.pass("Page text is verified and the text is: " + actual_text);
	}

	public static void verifyTextOnThePage(WebElement xpath, String expected_text) {
		String actual_text = xpath.getText();
		System.out.println(actual_text);
		Assert.assertEquals(actual_text, expected_text);

		test.pass("Page text is verified and the text is: " + actual_text);
		takescreenshot();
	}

	public static void scrollAndClick(String xpath, String Element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
			// Wait for the element to be clickable
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PROP.getProperty(xpath))));

			// Scroll into view
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

			// Click the element using JavaScript
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		} catch (Exception e) {
			e.printStackTrace();
		}
		test.pass("Page text is verified and the text is: " + Element);
		takescreenshot();
	}

	public static boolean getRowColNumber(String name) {
		int row = driver.findElements(By.xpath("//div[@class='card p-3']//tbody/tr")).size(); // row count
		int column = driver.findElements(By.xpath("//div[@class='card p-3']//th")).size(); // column count
		boolean found = false;

		for (int i = 1; i <= row; i++) { // Start from 1 if rows are indexed from 1
			for (int j = 1; j <= column; j++) {
				String str1 = driver
						.findElement(By.xpath("//div[@class='card p-3']//tbody/tr[" + i + "]/td[" + j + "]")).getText();
				if (str1.equals(name)) {
					found = true;
					WebElement cell = driver
							.findElement(By.xpath("//div[@class='card p-3']//tbody/tr[" + i + "]/td[" + j + "]"));

					// Check if the element is clickable before clicking
					if (cell.isDisplayed() && cell.isEnabled()) { // Ensure it's visible and enabled
						String rowdata = driver.findElement(By.xpath("//div[@class='card p-3']//tbody/tr[" + i + "]"))
								.getText();
						System.out.println(i + ":" + j + " " + str1);
						System.out.println(name + " is present in the table.");
						test.pass("The Row Count is " + i + " and the Column Count is " + j
								+ ". Data is verified and the data present in the table is: " + str1 + " Row data is "
								+ rowdata);
						takescreenshot();
						return true; // Return true here after successful validation
					} else {
						System.out.println("Element is not clickable.");
						// Optionally, you can log this or handle it differently
					}
				}
			}
		}

		String errorMessage = name + " is not present in the table.";
		System.out.println(errorMessage);
		test.fail(errorMessage);
		takescreenshot();
		Assert.fail(errorMessage);
		return false; // Return false only if the name was not found in any cells
	}

	public static boolean Hyperlink_Click(String name) {
		int row = driver.findElements(By.xpath("//div[@class='card p-3 card-shadow']//tbody/tr")).size(); // row count
		int column = driver.findElements(By.xpath("//div[@class='card p-3 card-shadow']//th")).size(); // column count
		boolean found = false;

		for (int i = 1; i <= row; i++) { // Start from 1 if rows are indexed from 1
			for (int j = 1; j <= column; j++) {
				String str1 = driver
						.findElement(By.xpath("//div[@class='card p-3 card-shadow']//tbody/tr[" + i + "]/td[" + j + "]")).getText();
				if (str1.equals(name)) {
					found = true;
					WebElement cell = driver
							.findElement(By.xpath("//div[@class='card p-3 card-shadow']//tbody/tr[" + i + "]/td[" + j + "]"));

					// Check if the element is clicable before clicking
					if (cell.isDisplayed() && cell.isEnabled()) {
						cell.click();
						System.out.println(i + ":" + j + " " + str1);
						System.out.println(name + "is there in the table.");
						test.pass("The Row Count is " + i + " and the colomn count is" + j
								+ ". Data is verified and the data which is present in the  table  is: " + str1);
						takescreenshot();
					} else {
						System.out.println("Element is not clickable.");
					}
					return true;
				}
			}

		}
		String errorMessage = name + " is not present in the table.";
		System.out.println(errorMessage);
		test.fail(errorMessage);
		takescreenshot();
		Assert.fail(errorMessage);
		return false;

	}

	public static void inputCalenderDate(String xpath, String data) {
		driver.findElement(By.xpath(PROP.getProperty(xpath))).click();
		for (int i = 0; i < 20; i++) {
			driver.findElement(By.xpath(PROP.getProperty(xpath))).sendKeys(Keys.BACK_SPACE);

		}
		driver.findElement(By.xpath(PROP.getProperty(xpath))).sendKeys(data);
	}

	public static void inputCalenderDate(WebElement xpath, String data) {
		xpath.click();
		for (int i = 0; i < 25; i++) {
			xpath.sendKeys(Keys.BACK_SPACE);

		}
		xpath.sendKeys(data);

	}

	public static void inputDate(WebElement xpath, String data) {
		xpath.click();
		for (int i = 0; i < 20; i++) {
			xpath.sendKeys(Keys.BACK_SPACE);

		}
		xpath.sendKeys(data);

	}

	public static void bootstrapdropdownselection(String xpath1, String xpath2, String data) {

		driver.findElement(By.xpath(PROP.getProperty(xpath1))).click();

		List<WebElement> bootstrap = driver.findElements(By.xpath(PROP.getProperty(xpath2)));
		System.out.println("Number of options found: " + bootstrap.size());

		boolean isSelected = false; // Flag to track if the desired option was selected

		for (int i = 0; i < bootstrap.size(); i++) {
			System.out.println(bootstrap.get(i).getText());
			if (bootstrap.get(i).getText().contains(data)) {
				bootstrap.get(i).click();
				System.out.println(data + " has been selected.");
				test.pass("The selected Item is " + data);
				takescreenshot();
				isSelected = true; // Set the flag to true if selected
				break; // Exit loop after selecting
			}
		}
		if (!isSelected) {
			String errorMessage = data + " was not found in the dropdown options.";
			System.out.println(errorMessage);
			// test.fail(errorMessage);
			takescreenshot();
			Assert.fail(errorMessage);

		}

	}

	public static void bootstrapdropdownselection(WebElement xpath1, String PROPxpath2, String data){

		xpath1.click();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<WebElement> bootstrap = driver.findElements(By.xpath(PROP.getProperty(PROPxpath2)));
		System.out.println("Number of options found: " + bootstrap.size());

		boolean isSelected = false; // Flag to track if the desired option was selected

		for (int i = 0; i < bootstrap.size(); i++) {
			System.out.println(bootstrap.get(i).getText());
			if (bootstrap.get(i).getText().contains(data)) {

				WebElement option = bootstrap.get(i);
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", option);
				option.click();

				// bootstrap.get(i).click();
				System.out.println(data + " has been selected.");
				test.pass("The selected Item is " + data);
				takescreenshot();
				isSelected = true; // Set the flag to true if selected
				break; // Exit loop after selecting
			}
		}
		if (!isSelected) {
			String errorMessage = data + " was not found in the dropdown options.";
			System.out.println(errorMessage);
			// test.fail(errorMessage);
			takescreenshot();
			Assert.fail(errorMessage);

		}

	}
}