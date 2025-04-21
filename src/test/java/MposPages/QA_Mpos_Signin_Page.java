package MposPages;

import java.sql.SQLException;
import java.time.Duration;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.proenx.rdep.myproject.TestBase;
import com.proenx.rdep.myproject.TestBase_Mobile;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import utility.CommonMethod;
import utility.DatabaseOTP_Table;



public class QA_Mpos_Signin_Page extends TestBase_Mobile {

	 AndroidDriver driver;
	    ExtentTest test;

	
	
	
	  public QA_Mpos_Signin_Page(AndroidDriver driver, ExtentTest test) {
	        this.driver = driver;
	        this.test = test;
	        PageFactory.initElements(driver, this);
	    }

	  @FindBy(xpath = "//android.widget.EditText")
	  private WebElement mobile_number_field;
	  
	  @FindBy(xpath = "(//android.widget.Button)[1]")
	  private WebElement Activate_Button;
	  
	  @FindBy(xpath = "(//android.widget.Button[@content-desc=\"WEB catalog\"]")
	  private WebElement Store_Selection;
	  
	  @FindBy(xpath ="//android.widget.Button[@content-desc=\"Submit\"]")
	  private WebElement Submit_Button;
	  
	  
	  @FindBy(xpath = "//android.widget.EditText")
	  private WebElement OTP_Field;
	  
	  @FindBy(xpath = "//android.widget.Button[@content-desc=\"Submit\"]")
	  private WebElement OTP_Field_Submit;
	  
	  @FindBy(xpath = "//android.widget.EditText[1]")
	  private WebElement Username_Field;
	  
	  @FindBy(xpath = "//android.view.View[2]//android.widget.EditText[2]")
	  private WebElement Password_Field;
	  
	  
	  @FindBy(xpath = "//android.widget.Button[@content-desc=\"Login\"]")
	  private WebElement Login_Button;
	  

	public QA_Mpos_Signin_Page signinwithwrongdata(Hashtable<String, String> ht) throws InterruptedException, SQLException {
		Thread.sleep(3000);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement phoneInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText")));

		phoneInput.click();
		Thread.sleep(3000);
		
		driver.hideKeyboard();
		mobile_number_field.sendKeys("7975331947");
		Activate_Button.click();
		test.pass("Mobile number has been Entered ");
		
		WebElement dropdown = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("WEB catalog")));
		dropdown.click();
		test.pass("User clicked on Select Store Dropdown");
		
		WebElement element = driver.findElement(AppiumBy.androidUIAutomator(
			    "new UiScrollable(new UiSelector().scrollable(true))" +
			    ".scrollIntoView(new UiSelector().description(\"RDEP HSR\"))"
			));
			element.click();
			
			Submit_Button.click();
			
			
			 String otp = DatabaseOTP_Table.fetchOTPFromDatabase("7975331947");
			 System.out.println(otp);
			 Thread.sleep(3000);
			 
			 WebElement otpInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.EditText")));
			 otpInput.click();
			 driver.hideKeyboard();
			 otpInput.sendKeys(otp);
			 
	 		 OTP_Field_Submit.click();
	 		 
	 		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[1]")));

	 		 
	 		 Username_Field.click();
	 		 
	 		driver.hideKeyboard();
	 		Username_Field.sendKeys("admin0265");
	 		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[2]//android.widget.EditText[2]")));
	 		
	 		
	 		Password_Field.click();
	 		driver.hideKeyboard();
	 		Password_Field.sendKeys("admin0265");
	 		
	 		Login_Button.click();
	 		Thread.sleep(3000);
	 		
	 		
		
//		WebElement store_name = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("Rdep Meta Limited Pune")));
//		store_name.click();;
		//driver.findElement(AppiumBy.accessibilityId("Rdep Meta Limited Pune")).click();
		
		Thread.sleep(3000);
		
		return this;
		
		 
	}

}
