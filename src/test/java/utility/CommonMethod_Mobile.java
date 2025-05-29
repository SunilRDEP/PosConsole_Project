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
import com.proenx.rdep.myproject.TestBase_Mobile;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class CommonMethod_Mobile extends TestBase_Mobile { 
	
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

	
	
	
	public static void scrollAndClickByPartialDesc(AndroidDriver driver, String partialDesc1, String partialDesc2) {
	    try {
	        // Scroll into view using first part
	    	
	    	List<WebElement> all = driver.findElements(By.xpath("//*[contains(@content-desc, '" + partialDesc1 + "')]"));
	    	for (WebElement el : all) {
	    	    System.out.println("📋 Found: " + el.getAttribute("content-desc"));
	    	}

	    	
	    	
	        driver.findElement(AppiumBy.androidUIAutomator(
	            "new UiScrollable(new UiSelector().scrollable(true))" +
	            ".scrollIntoView(new UiSelector().descriptionContains(\"" + partialDesc1 + "\"))"
	        ));

	        // Use a more relaxed XPath targeting any element with both substrings in content-desc
	        By dynamicLocator = By.xpath("//*[contains(@content-desc, '" + partialDesc1 + "') and contains(@content-desc, '" + partialDesc2 + "')]");

	        // Wait and click
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(dynamicLocator));
	        element.click();

	        System.out.println("✅ Clicked on element with content-desc parts: " + partialDesc1 + " | " + partialDesc2);
	    } catch (Exception e) {
	        System.out.println("❌ Failed to click on element with description: " + partialDesc1 + ", " + partialDesc2);
	        e.printStackTrace();
	        throw new RuntimeException("Element not found or not clickable.");
	    }
	}

	
	

}