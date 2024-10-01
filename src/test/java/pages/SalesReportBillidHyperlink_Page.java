package pages;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.proenx.rdep.myproject.TestBase;

public class SalesReportBillidHyperlink_Page extends TestBase {
	public SalesReportBillidHyperlink_Page() {
		PageFactory.initElements(driver, this);
	}
	public void Hyperlink(Hashtable<String, String> ht) {
		int row = driver.findElements(By.xpath("//*[@id=\"view\"]//tbody/tr\r\n"
				+ "")).size(); // row count
		int column = driver.findElements(By.xpath("//*[@id=\"view\"]//td\r\n"
				+ "")).size(); // column count
		System.out.println("row count is" + row + "column count is " + column);
		
	}
		
		
	}
		


