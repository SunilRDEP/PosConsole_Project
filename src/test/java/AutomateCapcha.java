
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

import com.google.common.io.Files;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class AutomateCapcha {
	public static WebDriver driver;
	public static String browser= "Chrome";
	public static void main(String[] args) throws InterruptedException, TesseractException, IOException {
		// TODO Auto-generated method stub
		
		
		if(browser.equalsIgnoreCase("Chrome")) {
		driver =new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("Firefox")) {
			driver= new FirefoxDriver();
			
		}
		else {
			driver = new EdgeDriver();
		}
	
		driver.manage().window().maximize();
		driver.get("https://www.irctc.co.in/nget/train-search");
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[1]/app-header[1]/div[1]/div[2]/a[1]")).click();
		driver.findElement(By.xpath("//button[@class='search_btn']")).click();
		Thread.sleep(3000);
		WebElement img= driver.findElement(By.xpath("//img[@class='captcha-img']"));
		//String timestamp= new SimpleDateFormat("YYYY_MM_dd_HH_mm_ss").format(new Date());
		File scr =img.getScreenshotAs(OutputType.FILE);
		String path="C:\\Users\\sunil\\eclipse-workspace\\Regression_Pos_project\\"
				+ "src\\test\\resources\\ScreenShots\\imagecaptcha_.png";
		FileHandler.copy(scr, new File(path));
		//---------------------
		
		ITesseract image= new Tesseract();
		try {
			
		
		String str= image.doOCR(new File(path));
			System.out.println("image ocr done");	
			System.out.println(str);
		}catch(TesseractException e) {
            System.err.println("Error during OCR: " + e.getMessage());
        }
			
		}
		
		}


