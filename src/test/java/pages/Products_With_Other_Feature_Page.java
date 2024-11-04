package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.proenx.rdep.myproject.TestBase;

public class Products_With_Other_Feature_Page  extends TestBase{
	public Products_With_Other_Feature_Page() {
		PageFactory.initElements(driver, this);
	} 
	
	
	@FindBy(xpath="")
	private static WebElement Products_Upload_images;
	
	@FindBy(xpath="//span[@class='m-1 me-1']//button[@type='button']")
	private static WebElement Products_Imports;
	
	@FindBy(xpath="//input[@id='defaultCatalog']")
	private static WebElement Products_Import_Default_Catalog_CheckBox;
	
	@FindBy(xpath="//input[@id='storeCatalog']")
	private static WebElement Products_Import_Store_Catalog_CheckBox;
	
	@FindBy(xpath="//span[normalize-space()='Store Group']")
	private static WebElement Products_Import_Select_Store_Group;
	
	@FindBy(xpath="//body//div[@id='app']//div[@class='row']//div[@class='row']//div[2]//div[1]//div[2]")
	private static WebElement Products_Import_Select_Store;
	
	@FindBy(xpath="//div[@class='col-12 col-lg-6']//input[@id='fileProduct']")
	private static WebElement Products_Imports_Select_File;
	
	@FindBy(xpath="//div[@class='d-flex justify-content-end']//button[@aria-label='Upload']")
	private static WebElement Products_Imports_File_Size_Instruction;
	
	@FindBy(xpath="//div[@class='d-flex align-items-center justify-content-between']//div//div//span[contains(text(),'Click here for File format')]")
	private static WebElement Products_Imports_Select_File_File_Format_Download;
	
	
	@FindBy(xpath="//div[@class='d-flex justify-content-end']//button[@aria-label='Upload']")
	private static WebElement Products_Imports_Upload;

	@FindBy(xpath="//div[@class='d-flex justify-content-end']//span[@class='p-button-label'][normalize-space()='Close']")
	private static WebElement Products_Imports_Close;
	
	
	
	
	
	@FindBy(xpath="")
	private static WebElement Products_Download;
	
	@FindBy(xpath="")
	private static WebElement Products_Filters;
	
	@FindBy(xpath="")
	private static WebElement Products_Enable_Disable;
	
	

}
