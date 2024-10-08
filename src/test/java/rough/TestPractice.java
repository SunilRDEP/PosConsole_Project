package rough;

import java.time.Duration;
import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.proenx.rdep.myproject.TestBase;

import utility.CommonMethod;
import utility.DataCollection;

public class TestPractice extends TestBase {
	@Test(dataProvider = "data_Collection")
	public void SalesReportvaliddata(Hashtable<String, String> ht) throws InterruptedException {
		String pagetitile = driver.getTitle();
		CommonMethod.takescreenshot();

		// \\//\\//\\LOGIN DETAILS//\\//\\//\\
		System.out.println("My page title is" + pagetitile);
		CommonMethod.enterdatafromexcel("Usernamexpath", ht.get("UserName"));
		CommonMethod.enterdatafromexcel("Passwardxpath", ht.get("Password"));
		CommonMethod.clickonWebElement("viewpassword_icon", "login button");
		CommonMethod.clickonWebElement("clickbuttonxpath", "login button");
		// CommonMethod.verifycolor("uniquecutomerlogo", "rgb(114, 124,
		// 245)","cssvalueblue");
		// ______________________________________________________________________________________________________
		// \\//\\//\\SALES REPORT FEATURE//\\//\\//\\

		CommonMethod.clickonWebElement("clickonxorderxpath", "OrderMenu");
		CommonMethod.clickonWebElement("clickonsalesreport", "Sales Report");
		CommonMethod.clickonWebElement("clickonfilter", "Filter");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		// ______________________________________________________________________________________________________

		// \\//\\//\\Past Start Date Field//\\//\\//\\

		// CommonMethod.clickonWebElement(pagetitile, pagetitile);

//		CommonMethod.inputCalenderDate("clickedoncalenderfield","Promotionstartdate");
//		//CommonMethod.entertextintoinputbox("clickedoncalenderfield", "Promotionstartdate");
//		CommonMethod.clickonWebElement("outsideclick", "clicked on outside");

		
		CommonMethod.inputCalenderDate("clickedonenddatecalenderfield","Promotionenddate");
		//CommonMethod.entertextintoinputbox("clickedonenddatecalenderfield", "Promotionenddate");
		

		CommonMethod.clickonWebElement("outsideclick", "clicked on outside");
		// ______________________________________________________________________________________________________
		
		CommonMethod.bootstrapdropdownselection("clickonselectstatus","Selectstatus", "VOID");
		CommonMethod.bootstrapdropdownselection("clickonselectstatus","Selectstatus", "Success");
		CommonMethod.clickonWebElement("outsideclick", "clicked on outside");
		CommonMethod.clickonWebElement("applybutton", "applied");
		String s1=driver.findElement(By.xpath("//p[@class='v-toast__text']")).getText();
		System.out.println(s1);
		CommonMethod.verifyTextOnThePage("ActualSalesreportpopupmessage", "Orders List not found");
//}
//		CommonMethod.scrollAndClick("clickonparticulastore1", "selected store");
//		CommonMethod.scrollAndClick("clickonparticulastore2", "selected store");
//		CommonMethod.clickonWebElement("outsideclick", "clicked on outside");
//		CommonMethod.clickonWebElement("clickonapplybutton", "Apply Button");
//		// CommonMethod.getRowColNumber("179.1");
////			  JavascriptExecutor js = (JavascriptExecutor) driver;
////		       // js.executeScript("window.scrollBy(1000, 0);");
////		        WebElement element = driver.findElement(By.xpath("//div[normalize-space()='Download']"));
////		        js.executeScript("arguments[0].scrollIntoView();", element);
//		// CommonMethod.clickonWebElement("SalesReportBillIDHyperlink", "BillID");
//		Thread.sleep(5000);
//		CommonMethod.getRowColNumber("1799.1");
//		// CommonMethod.getRowColNumber("1799.1");
//		/*
//		 * String
//		 * exp=driver.findElement(By.xpath("//button[@aria-label='Close']")).getCssValue
//		 * ("background"); System.out.println(exp); Color color=Color.fromString(exp);
//		 * String act= color.asHex(); System.out.println(act); String
//		 * expcolor="#ef4444"; Assert.assertEquals(act,expcolor);
//		 */
//		// String str=driver.findElement(By.xpath("//div[@class='card
//		// p-3']")).getText();
//		// System.out.println(str);
//		/*
//		 * int row=driver.findElements(By.xpath("//div[@class='card p-3']//tr")).size();
//		 * int
//		 * column=driver.findElements(By.xpath("//div[@class='card p-3']//th")).size();
//		 * 
//		 * 
//		 * 
//		 * 
//		 * 
//		 * //CommonMethod.scrollAndClick("", pagetitile); //div[@class='card p-3']//tr
//		 * /* Thread.sleep(3000);
//		 * CommonMethod.clickonWebElement("clickonsourceselection",
//		 * "Source Selection Dropdown");
//		 * CommonMethod.clickonWebElement("clickonparticularsource1",
//		 * "Particular source called Self_CheckOut");
//		 * CommonMethod.clickonWebElement("clickonparticularsource2",
//		 * "Particular source Called Mpos ");
//		 * CommonMethod.clickonWebElement("outsideclick", "clicked on outside");
//		 * CommonMethod.clickonWebElement("clickonapplybutton", "Apply Button");
//		 */
//
//		// validatilng the data table
//
//		// CommonMethod.verifyTextOnThePage("ActualSalesreportpopupmessage","Orders List
//		// not found");
//		// CommonMethod.verifyTextOnThePage("Actual_total-no_of_data","Showing 1 to 10
//		// of 77 items");

	}

	@DataProvider
	public Object[][] data_Collection() {
		DataCollection dc = new DataCollection(excel, "Test Sunil", "TestPractice2");
		return dc.dataArray();
	}
}