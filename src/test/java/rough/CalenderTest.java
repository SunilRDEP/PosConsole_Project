package rough;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.proenx.rdep.myproject.TestBase;

import utility.CommonMethod;

public class CalenderTest extends TestBase {
	@Test
	public void loginPage() throws InterruptedException {
		String pagetitile = driver.getTitle();
		CommonMethod.takescreenshot();

		//\\//\\//\\LOGIN DETAILS//\\//\\//\\
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
		// ______________________________________________________________________________________________________

		//\\//\\//\\SALES REPORT FEATURE//\\//\\//\\

		CommonMethod.clickonWebElement("clickonxorderxpath", "OrderMenu");
		CommonMethod.clickonWebElement("clickonsalesreport", "Sales Report");
		CommonMethod.clickonWebElement("clickonfilter", "Filter");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		// ______________________________________________________________________________________________________

		//\\//\\//\\Future Start Date Field//\\//\\//\\

		CommonMethod.clickonWebElement("clickedoncalenderfield", "Calender Field Successfully");
		CommonMethod.calender("cuurentmonth", "clickedonnextmonth", "Sep");
		CommonMethod.calender("currentYear", "clickonnextyear", "2024");
		CommonMethod.clickonWebElement("Clickonstartdatecalenderday", "21th of May 2030");
		// CommonMethod.clickonWebElement(pagetitile, pagetitile);
		CommonMethod.clickonWebElement("outsideclick", "clicked on outside");

		// ______________________________________________________________________________________________________

		//\\//\\//\\_Past End Date Field//\\//\\//\\

		CommonMethod.clickonWebElement("clickedonenddatecalenderfield", "End Date Calender Field Successfully");
		CommonMethod.calender("cuurentmonth", "clickedonpreviousmonth", "Sep");
		CommonMethod.calender("currentYear", "clickedonpreviousyear", "2024");
		CommonMethod.clickonWebElement("ClickedonPastcalenderday", "15th of May 2023");
		// CommonMethod.clickonWebElement(pagetitile, pagetitile);
		CommonMethod.clickonWebElement("outsideclick", "clicked on outside");
		// ______________________________________________________________________________________________________

		//\\//\\//\\SELECT ALL DROPDOWN//\\//\\//\\
		CommonMethod.clickonWebElement("clickonstoreselection", "Store Selection Dropdown");
		
		CommonMethod.scrollAndClick("clickonparticulastore1","selected store");
		CommonMethod.scrollAndClick("clickonparticulastore2", "selected store");
		CommonMethod.clickonWebElement("outsideclick", "clicked on outside");
		CommonMethod.clickonWebElement("clickonapplybutton", "Apply Button");
		CommonMethod.getRowColNumber("1799.1");
	

	}
	

}