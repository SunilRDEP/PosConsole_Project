package com.proenx.rdep.myproject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Hashtable;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utility.DataCollection;
import utility.ExcelReader;

public class TestBase { // heart or engine of my framework
	// global variable declaration for property file declaration
	public static WebDriver driver;
	public static Properties configue;
	public static Properties PROP;
	// global variable declaration for extent report declaration
	public static ExtentSparkReporter spark;
	public static ExtentReports report;
	public static ExtentTest test;
	public static ExcelReader excel; 
	public static String testCaseName;
	public static Hashtable<String, String> run_mode = new Hashtable<>();
 
	@BeforeSuite  

	public void loadPropfile() throws IOException {
		System.out.println("Reading Configue file ");
		FileInputStream fis = new FileInputStream("C:\\Users\\sunil\\eclipse-workspace\\Regression_Pos_project\\"
				+ "src\\test\\resources\\Properties\\Configue.properties");
		configue = new Properties();
		configue.load(fis);
		System.out.println("configue file is loaded ");
		System.out.println("Reading PROP file ");
		FileInputStream fis1 = new FileInputStream("C:\\Users\\sunil\\eclipse-workspace\\Regression_Pos_project\\"
				+ "src\\test\\resources\\Properties\\PROP.properties");
		PROP = new Properties();
		PROP.load(fis1);
		System.out.println("PROP file is loaded ");
		System.out.println("Reading PROP file ");
		String timestamp = new SimpleDateFormat("YYYY_MM_dd_hh_ss").format(new Date());
		report = new ExtentReports();
		spark = new ExtentSparkReporter("C:\\Users\\sunil\\eclipse-workspace\\Regression_Pos_project\\"
				+ "src\\test\\resources\\executionReports\\inventory Feature _" + timestamp + ".html");
		report.attachReporter(spark);
		excel = new ExcelReader(
				System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\Test_Data_Sheet.xlsx");
		readRunMode();
	}

	@BeforeMethod
	public void launchBrowser() {
		test = report.createTest(testCaseName);
		
		if (configue.getProperty("Browser").equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
			System.out.println("Chrome Driver is launched");
			test.info("Chrome Driver is launched");

		} else if (configue.getProperty("Browser").equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
			System.out.println("Firefox Driver is launched");
			test.pass("Firefox Driver is launched");
		} else {
			driver = new EdgeDriver();
			test.pass("Edge Driver is launched");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		if (configue.getProperty("Environment").equalsIgnoreCase("QA")) {
			driver.get(configue.getProperty("qaurl"));
			test.pass("User navigate to required QA url");
		} else if (configue.getProperty("Environment").equalsIgnoreCase("uat")) {
			driver.get(configue.getProperty("UATurl"));
			test.pass("User navigate to required UAT url");
		} else {
			driver.get(configue.getProperty("ProductionURL"));
			test.pass("User navigate to required production url");
		}

	}

	@AfterMethod(alwaysRun = true)
	public void teardown() throws InterruptedException {
		Thread.sleep(5000);
		if(driver!=null)
		driver.quit();
	}

	@AfterSuite
	public void generateReport() {
		report.flush();
		

	}

	@DataProvider
	public Object[][] data_Collection() {
		DataCollection dc = new DataCollection(excel, "Test Sunil", testCaseName);
		return dc.dataArray();
	}

	public void readRunMode() {
		int rows = excel.getRowCount("Test Cases");
		for (int i = 2; i <= rows; i++) {
			String key = excel.getCellData("Test Cases", "Test_Case_Name", i);
			String value = excel.getCellData("Test Cases", "Run Mode", i);
			run_mode.put(key, value);
		}
		System.out.println("HasTable Run Mode :" + run_mode);
	}

}
