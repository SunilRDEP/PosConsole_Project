package pages;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

	@FindBy(xpath = "//span[normalize-space()='Carts']")
	private static WebElement carts;
	@FindBy(xpath = "//span[normalize-space()='All Carts']")
	private static WebElement AllCarts;

	@FindBy(xpath = "//span[normalize-space()='Master Promotions']")
	private static WebElement MasterPromotion;

	@FindBy(xpath = "//span[normalize-space()='Inventory']")
	private static WebElement Inventory;

	@FindBy(xpath = "//span[normalize-space()='Inventory List']")
	private static WebElement Inventory_List;

	@FindBy(xpath = "//div[@class='text-white']//span[@class='nav__label'][normalize-space()='Products']")
	private static WebElement Product;

	@FindBy(xpath = "//a[@class='submenu__link text-align-center']//span[@class='nav__label'][normalize-space()='Products']")
	private static WebElement Product_Products;

	@FindBy(xpath = "//span[normalize-space()='Stock Request(Inward)']")
	private static WebElement Inventory_Stock_Request_Inward_Submenu;

	@FindBy(xpath = "//span[normalize-space()='Stock Transfer(Outward)']")
	private static WebElement Inventory_Stock_Request_Outward_Submenu;

	@FindBy(xpath = "//div[@class='submenu__container show-submenu']//li[4]")
	private static WebElement Inventory_Inward_Request_Submenu;
	
	@FindBy(xpath = "//a[@class='user-menu-link d-flex align-items-center gap-3 mx-3 h-100 px-4']")
	private static WebElement TENANT_Menu;
	
	@FindBy(xpath = "//a[@href='/rdep-receipt/dashboard']")
	private static WebElement E_Receipt;
	
	@FindBy(xpath = "//span[@class='nav__label'][normalize-space()='Customers']")
	private static WebElement Customer_Menu;
	
	@FindBy(xpath = "//span[normalize-space()='All Customers List']")
	private static WebElement Customer_SubMenu;
	

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
		CommonMethod.clickonWebElement(AllCarts, "Allcarts Sub Menu");
		return new CartsPage();
	}

	public MasterPromotion_Pages MasterPromotion(Hashtable<String, String> ht) throws InterruptedException {
//		WebElement Promotion = clickonPromotion;
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Promotion);
//		Promotion.click();

		Thread.sleep(3000);
		CommonMethod.clickonWebElement(clickonPromotion, "Promotion Menu");

		CommonMethod.clickonWebElement(MasterPromotion, "MasterPromotion Sub Menu");
		return new MasterPromotion_Pages();
	}

	public InventoryList_Page inventory_List(Hashtable<String, String> ht) throws InterruptedException {

		Thread.sleep(3000);
		CommonMethod.clickonWebElement(Inventory, "Inventory Menu");

		CommonMethod.clickonWebElement(Inventory_List, "Inventory List Sub Menu");
		return new InventoryList_Page();
	}

	public StockRequest_Inward_Page Stock_request_Inward_SubMenu(Hashtable<String, String> ht)
			throws InterruptedException {

		Thread.sleep(3000);
		CommonMethod.clickonWebElement(Inventory, "Inventory Menu");

		CommonMethod.clickonWebElement(Inventory_Stock_Request_Inward_Submenu, "Stock Request Inward Sub Menu");
		return new StockRequest_Inward_Page();
	}

	public StockRequest_Outward_Page Stock_request_Outward_SubMenu(Hashtable<String, String> ht)
			throws InterruptedException {

		Thread.sleep(3000);
		CommonMethod.clickonWebElement(Inventory, "Inventory Menu");

		CommonMethod.clickonWebElement(Inventory_Stock_Request_Outward_Submenu, "Stock Request Inward Sub Menu");
		return new StockRequest_Outward_Page();
	}

	public Products_Page Products_SubMenu(Hashtable<String, String> ht) throws InterruptedException {
		Thread.sleep(3000);
		CommonMethod.clickonWebElement(Product, "Product Menu");

		CommonMethod.clickonWebElement(Product_Products, "Products Sub Menu");
		return new Products_Page();
	}

	public Products_With_Other_Feature_Page Products_SubMenu_for_Other_Feature(Hashtable<String, String> ht)
			throws InterruptedException {
		Thread.sleep(3000);
		CommonMethod.clickonWebElement(Product, "Product Menu");

		CommonMethod.clickonWebElement(Product_Products, "Products Sub Menu");
		return new Products_With_Other_Feature_Page();
	}

	public Inward_History_Page Inward_History_SubMenu(Hashtable<String, String> ht) throws InterruptedException {
		Thread.sleep(3000);
		CommonMethod.clickonWebElement(Inventory, "Inventory Menu");

		CommonMethod.clickonWebElement(Inventory_Inward_Request_Submenu, "Inward History Sub Menu");
		return new Inward_History_Page();
	}
	
	public E_Receipt_Page E_Receipt(Hashtable<String, String> ht) throws InterruptedException {
		Thread.sleep(3000);
		CommonMethod.clickonWebElement(TENANT_Menu, "TENANT Menu");

		CommonMethod.clickonWebElement(E_Receipt, "E-Receiot option ");
		return new E_Receipt_Page();
	}
	
	public Customers_Page customer_List_SubMenu(Hashtable<String, String> ht) throws InterruptedException {
		Thread.sleep(3000);
		CommonMethod.clickonWebElement(Customer_Menu, "Customer Menu");

		CommonMethod.clickonWebElement(Customer_SubMenu, "Customer Sub Menu  ");
		return new Customers_Page();
	}
}
