package rough;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.proenx.rdep.myproject.TestBase;

import utility.CommonMethod;

public class TestPractice3 extends TestBase {
	@Test
	public void SalesReportvaliddata() throws InterruptedException {
		String pagetitile = driver.getTitle();
		CommonMethod.takescreenshot();

		// \\//\\//\\LOGIN DETAILS//\\//\\//\\

		System.out.println("My page title is" + pagetitile);
		CommonMethod.enterdatafromexcel("Usernamexpath", excel.getCellData("Test Cases", "Username", 2));
		CommonMethod.enterdatafromexcel("Passwardxpath", excel.getCellData("Test Cases", "Password", 2));
		
		CommonMethod.clickonWebElement("clickbuttonxpath", "login button");
		CommonMethod.clickonWebElement("clickonpromotion", "Promotion");
		CommonMethod.clickonWebElement("clickonMasterPromotion", "Master Promotion");
		CommonMethod.clickonWebElement("createpromotion", "Create Master Promotion");
		driver.findElement(By.xpath(PROP.getProperty("Startdatexpath"))).click();
		for(int i=0;i<20;i++) {
			driver.findElement(By.xpath(PROP.getProperty("Startdatexpath"))).sendKeys(Keys.BACK_SPACE);
			
		}
		CommonMethod.entertextintoinputbox("Startdatexpath", "Promotionstartdate");
		driver.findElement(By.xpath(PROP.getProperty("Enddatexpath"))).click();
		for(int i=0;i<20;i++) {
			driver.findElement(By.xpath(PROP.getProperty("Enddatexpath"))).sendKeys(Keys.BACK_SPACE);
			
		}
		CommonMethod.entertextintoinputbox("Enddatexpath", "Promotionenddate");
		CommonMethod.SelectDropdown("SelectPromotionTypeDropdownxpath",excel.getCellData("Test Sunil", "Promotion Type", 2));
	    CommonMethod.enterdatafromexcel("PromotionNameDropdownXpath",excel.getCellData("Test Sunil", "Promotion Name", 2));
	    CommonMethod.SelectDropdown("SelectPromotionSubTypeDropdownxpath", excel.getCellData("Test Sunil", "Promotion SubType", 2));
	    CommonMethod.enterdatafromexcel("PromotionCodexpath",excel.getCellData("Test Sunil", "Promotion Code", 2));
	    CommonMethod.enterdatafromexcel("PromotionDescriptionxpath",excel.getCellData("Test Sunil", "Description", 2));
	    CommonMethod.enterdatafromexcel("DiscountValueXpath",excel.getCellData("Test Sunil", "Discount Value", 2));
	
	}
}