package pages;

import java.util.Hashtable;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.proenx.rdep.myproject.TestBase;

import utility.CommonMethod;

public class DashBoardPages extends TestBase {
	public DashBoardPages() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[normalize-space()='Carts']")
	private static WebElement clickonCarts;
	
	@FindBy(xpath = "//span[normalize-space()='Orders']")
	private static WebElement clickonorderxpath;

	@FindBy(xpath = "//div[@class='submenu__container show-submenu']//li[2]")
	public static WebElement clickonsalesreport;

	@FindBy(xpath = "//span[normalize-space()='Returns']")
	public static WebElement clickonReturnrs;

	@FindBy(xpath = "//div[@class='text-white']//span[@class='nav__label'][normalize-space()='Products']")
	public static WebElement clickonProducts;
	
	@FindBy(xpath = "//span[normalize-space()='Promotion']")
	public static WebElement clickonPromotion;
	
	@FindBy(xpath = "//span[normalize-space()='Inventory']")
	public static WebElement clickonInventory;
	
	@FindBy(xpath = "//span[normalize-space()='Customers']")
	public static WebElement clickonCustomer;
	
	@FindBy(xpath = "//span[normalize-space()='Manage']")
	public static WebElement clickonManage;
	
	@FindBy(xpath = "//span[normalize-space()='Content']")
	public static WebElement clickonContent;
	
	@FindBy(xpath="//span[normalize-space()='Carts']")
	private static WebElement carts;
	@FindBy(xpath="//span[normalize-space()='All Carts']")
	private static WebElement AllCarts;
//	public void verifyDashBoardPagetitle() {
//		CommonMethod.verifyPageTitle("Dashboard | RDEP");
//	}

	public DashBoardPages clickOnAllMenunDashBoard() {
		CommonMethod.clickonWebElement(clickonorderxpath, "Orders Menu");
		CommonMethod.clickonWebElement(clickonProducts, "Products  Menu");
		CommonMethod.clickonWebElement(clickonPromotion, "Promotion  Menu");
		CommonMethod.clickonWebElement(clickonInventory, "Inventory  Menu");
		CommonMethod.takescreenshot();
		CommonMethod.clickonWebElement(clickonCustomer, "Customer  Menu");
		CommonMethod.clickonWebElement(clickonManage, "Manage  Menu");
		CommonMethod.clickonWebElement(clickonContent, "Inventory  Menu");
		
		return this;

	}
	public DashBoardPages clickOnOrdersSubMenu(Hashtable<String, String> ht) throws InterruptedException {
		Thread.sleep(3000);
		CommonMethod.clickonWebElement(clickonorderxpath, "Orders Menu");
		CommonMethod.clickonWebElement(clickonsalesreport, "Sales Report Sub Menu");
		CommonMethod.clickonWebElement(clickonReturnrs, "Return Report Sub Menu");
		

		return this;
		
		
	}
	public SalesReportPage clickOnSalesReportSubMenu(Hashtable<String, String> ht) throws InterruptedException {
		Thread.sleep(3000);
		CommonMethod.clickonWebElement(clickonorderxpath, "Orders Menu");
		CommonMethod.clickonWebElement(clickonsalesreport, "Sales Report Sub Menu");
		

		return new SalesReportPage();
		
		
	}
	
	

	public SalesReportPage clickonSalesReport() {
		CommonMethod.clickonWebElement(clickonsalesreport, "Sales Report Sub Menu");
		return new SalesReportPage();
	}
	public CartsPage clickonAllcarts() {
		CommonMethod.clickonWebElement(carts, "carts Menu");
		//CommonMethod.clickonWebElement(AllCarts, "Allcarts Sub Menu");
		return new CartsPage();
	}
}