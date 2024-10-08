package rough;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.proenx.rdep.myproject.TestBase;

import utility.CommonMethod;

public class MainLogic extends TestBase {

	@Test
	public void loginPage() throws InterruptedException {
		String pagetitile = driver.getTitle();
		CommonMethod.takescreenshot();

		System.out.println("My page title is" + pagetitile);
		CommonMethod.entertextintoinputbox("Usernamexpath", "username");
		// CommonMethod.takescreenshot();
		// CommonMethod.entertextintoinputbox("Passwardxpath", "passward");
		// CommonMethod.clickonWebElement("clickbuttonxpath", "message");
		CommonMethod.entertextintoinputbox("Usernamexpath", "username2");
		// CommonMethod.takescreenshot();
		CommonMethod.entertextintoinputbox("Passwardxpath", "passward");
		CommonMethod.clickonWebElement("clickbuttonxpath", "message");
		// CommonMethod.verifycolor("uniquecutomerlogo", "rgb(114, 124,
		// 245)","cssvalueblue");
		// sales report screen automation details
		CommonMethod.clickonWebElement("clickonxorderxpath", "OrderMenu");
		CommonMethod.clickonWebElement("clickonsalesreport", "Sales Report");
		CommonMethod.clickonWebElement("clickonfilter", "Filter");
		// Thread.sleep(3000);
		CommonMethod.clickonWebElement("clickedoncalenderfield", "Calender Field Successfully");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PROP.getProperty("calendertable"))));

		while (true) {

			// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PROP.getProperty("currentYear"))));

			WebElement displayedYear = driver.findElement(By.xpath(PROP.getProperty("currentYear")));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PROP.getProperty("currentYear"))));
			String yearText = displayedYear.getText();
			if (yearText.equals("2027")) {
				break;
			} else {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PROP.getProperty("currentYear"))));
				WebElement nextYearButton = driver.findElement(By.xpath(PROP.getProperty("clickonnextyear")));
				nextYearButton.click();

				Thread.sleep(1000);
			}
		}
		CommonMethod.clickonWebElement("clickonstoreselection", "Store Selection Dropdown");
		CommonMethod.clickonWebElement("clickonparticulastore", "Particular store");
		// CommonMethod.clickonWebElement("clickonapplybutton", "Apply Button");

	}

}
