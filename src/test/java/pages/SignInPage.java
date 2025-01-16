package pages;

import java.util.Hashtable;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.proenx.rdep.myproject.TestBase;

import utility.CommonMethod;

public class SignInPage extends TestBase {
	public SignInPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id='username']")
	private static WebElement Usernamexpath;

	@FindBy(xpath = "//*[@type='password']")
	private static WebElement Passwardxpath;

	@FindBy(xpath = "//button[@type='submit']")
	private static WebElement clickbuttonxpath;

	@FindBy(xpath = "//i[@class='ri-eye-line']")
	private static WebElement viewpassword_icon;

	@FindBy(xpath = "//a[normalize-space()='Forgot your password?']")
	private static WebElement forgotpassword_icon;

	@FindBy(xpath = "//div[@class='loginFooter text-muted text-center fw-normal']")
	private static WebElement LoginPageText2;
	@FindBy(xpath = "//p[@class='text-center text-muted mt-4 fw-bold']")
	private static WebElement LoginPageText1;

	@FindBy(xpath = "//a[text()=' Forgot your password?']")
	private static WebElement LoginPageText3;

	@FindBy(xpath = "//label[normalize-space()='Username']")
	private static WebElement LoginPageText4;

	@FindBy(xpath = "//label[normalize-space()='Password']")
	private static WebElement LoginPageText5;

	@FindBy(xpath = "//h5[normalize-space()='Sign In']")
	private static WebElement LoginPageText6;
	@FindBy(xpath = "//button[normalize-space()='Log In']")
	private static WebElement LoginPageText7;

	public DashBoardPages signin(Hashtable<String, String> ht) {
		CommonMethod.enterdatafromexcel(Usernamexpath,configue.getProperty("username"), "USERNAME");
		CommonMethod.enterdatafromexcel(Passwardxpath, configue.getProperty("passward"),"PASSWORD");
		CommonMethod.clickonWebElement(clickbuttonxpath, "login button");
		return new DashBoardPages(); 

	}

	public DashBoardPages signinWithviewPasswordicon(Hashtable<String, String> ht) {
		CommonMethod.enterdatafromexcel(Usernamexpath, configue.getProperty("username"),"USERNAME");
		CommonMethod.enterdatafromexcel(Passwardxpath,configue.getProperty("passward"),"PASSWORD");
		CommonMethod.clickonWebElement(viewpassword_icon, "Enable ViewPassword Icon");
		CommonMethod.clickonWebElement(clickbuttonxpath, "login button");
		return new DashBoardPages();
	}

	public SignInPage verifysigninpagetext(Hashtable<String, String> ht) {
		CommonMethod.verifyTextOnThePage(LoginPageText2, ht.get("LoginPageText2"));
		CommonMethod.verifyTextOnThePage(LoginPageText1, ht.get("LoginPageText1"));
		CommonMethod.verifyTextOnThePage(LoginPageText3, ht.get("LoginPageText3"));
		CommonMethod.verifyTextOnThePage(LoginPageText4, ht.get("LoginPageText4"));
		CommonMethod.verifyTextOnThePage(LoginPageText5, ht.get("LoginPageText5"));
		CommonMethod.verifyTextOnThePage(LoginPageText6, ht.get("LoginPageText6"));
		CommonMethod.verifyTextOnThePage(LoginPageText7, ht.get("LoginPageText7"));
		return this;
		
	}
	public SignInPage signinwithwrongdata(Hashtable<String, String> ht) {
		CommonMethod.enterdatafromexcel(Usernamexpath, ht.get("Wrong UserName"),"Wrong USERNAME");
		CommonMethod.enterdatafromexcel(Passwardxpath, ht.get("Wrong Password"),"Wrong Password PASSWORD");
		CommonMethod.clickonWebElement(clickbuttonxpath, "login button");
		CommonMethod.verifyTextOnThePage(LoginPageText7, ht.get("LoginPageText7"));
		return this;
		
		 
	}

}
