
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.proenx.rdep.myproject.TestBase;

import utility.CommonMethod;

public class MainLogic extends TestBase {

	@Test
	public void loginPage() {
		String pagetitile=driver.getTitle();
		CommonMethod.takescreenshot();
		
		System.out.println("My page title is" +pagetitile);
		CommonMethod.entertextintoinputbox("Usernamexpath", "username");
		//CommonMethod.takescreenshot();
		CommonMethod.entertextintoinputbox("Passwardxpath", "passward");
		CommonMethod.clickonWebElement("clickbuttonxpath", "message");
		CommonMethod.entertextintoinputbox("Usernamexpath", "username2");
		//CommonMethod.takescreenshot();
		CommonMethod.entertextintoinputbox("Passwardxpath", "passward");
		CommonMethod.clickonWebElement("clickbuttonxpath", "message");
		//CommonMethod.verifyPageTitle("expected_Pagetitle");
		CommonMethod.clickonWebElement(pagetitile, pagetitile);
		
	}
	
	
}
