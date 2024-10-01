package pages;

import java.util.Hashtable;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.proenx.rdep.myproject.TestBase;

import utility.CommonMethod;

public class CartsPage extends TestBase{
	public CartsPage() {
		PageFactory.initElements(driver, this);
	}
@FindBy(xpath="//span[normalize-space()='Carts']")
private static WebElement carts;
@FindBy(xpath="//span[normalize-space()='All Carts']")
private static WebElement AllCarts;

public CartsPage cart_Table(Hashtable<String, String> ht) {
	//CommonMethod.clickonWebElement(carts, "carts Menu");
	CommonMethod.clickonWebElement(AllCarts,"All Carts SubMenu");
	CommonMethod.getRowColNumber("3999");
	return this;
	
}


}
