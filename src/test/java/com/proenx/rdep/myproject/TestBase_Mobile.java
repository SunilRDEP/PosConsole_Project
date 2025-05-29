package com.proenx.rdep.myproject;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Hashtable;
import java.util.Properties;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import utility.DataCollection;
import utility.ExcelReader;

public class TestBase_Mobile {
	 protected AndroidDriver driver;
	 protected  ExtentTest test;
	 
	 public static Properties mobile_configue;
		public static Properties mobile_Prop;
	//=======================================================================================================================

		// global variable declaration for extent report declaration, test case nma e,
		// hash table declaration
		public static ExtentSparkReporter spark;
		public static ExtentReports report;
		public static Properties configue;
		public static ExcelReader excel;
		public static String testCaseName;
		public static Hashtable<String, String> run_mode = new Hashtable<>();
		public void readRunMode() {
			int rows = excel.getRowCount("Test Cases");
			for (int i = 2; i <= rows; i++) {
				String key = excel.getCellData("Test Cases", "Test_Case_Name", i);
				String value = excel.getCellData("Test Cases", "Run Mode", i);
				run_mode.put(key, value);
			}
			System.out.println("HasTable Run Mode :" + run_mode);
		}

		
		@BeforeSuite

		public void loadPropfile() throws IOException {
	//property file setup and it will be available for execution before every suite

			FileInputStream fis = new FileInputStream("C:\\Users\\sunil\\eclipse-workspace\\Regression_Pos_project\\"
					+ "src\\test\\resources\\Properties\\Configue.properties");
			configue = new Properties();
			configue.load(fis);
			
			
			System.out.println("Reading Configue file ");
			FileInputStream fis4 = new FileInputStream("C:\\Users\\sunil\\eclipse-workspace\\Regression_Pos_project\\"
					+ "src\\test\\resources\\Properties\\mobile_configue.properties");
			mobile_configue = new Properties();
			mobile_configue.load(fis);
			System.out.println("configue file is loaded ");
			System.out.println("Reading PROP file ");
			FileInputStream fis1 = new FileInputStream("C:\\Users\\sunil\\eclipse-workspace\\Regression_Pos_project\\"
					+ "src\\test\\resources\\Properties\\mobile_Prop.properties");
			mobile_Prop = new Properties();
			mobile_Prop.load(fis1);
			System.out.println("PROP file is loaded ");
			System.out.println("Reading PROP file ");
	//======================================================================================================================
	//this setup is for creating and getting execution report  for every test cases 
			String timestamp = new SimpleDateFormat("YYYY_MM_dd_hh_ss").format(new Date());
			report = new ExtentReports();
			spark = new ExtentSparkReporter("C:\\Users\\sunil\\eclipse-workspace\\Regression_Pos_project\\"
					+ "src\\test\\resources\\executionReports\\RDEP_TEST_EXECUTION_REPORT _" + timestamp + ".html");
			report.attachReporter(spark);
	//=======================================================================================================================
	//This will read the excel sheet by using the path of the excel sheet 
			excel = new ExcelReader(
					System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\Test_Data_Sheet.xlsx");
			readRunMode();
		}
		
		
		@AfterSuite
		public void generateReport() {
			report.flush();

		}

	// this will decide the excel sheet name, test case name from which the data will provide to the test case 
		@DataProvider
		public Object[][] data_Collection() {
			DataCollection dc = new DataCollection(excel, "Test Sunil", testCaseName);
			return dc.dataArray();
		}
	// this will read the the data from particular cell of particular row from the excel sheet 


		
	 
		@BeforeClass
		public void setUp() throws MalformedURLException {
		    boolean installApp =  Boolean.parseBoolean(mobile_configue.getProperty("installApp")); // Set to true if you want to install the APK

		    UiAutomator2Options options = new UiAutomator2Options();
		    options.setDeviceName(mobile_configue.getProperty("Device_Name"));
		    options.setPlatformName("Android");
		    options.setAutomationName("UiAutomator2");
		    options.setNewCommandTimeout(Duration.ofSeconds(300));

		    if (installApp) {
		        configureForApkInstall(options);
		    } else {
		        configureForExistingApp(options);
		    }

		    URL appiumServerURL = new URL("http://127.0.0.1:4723/wd/hub");
		    driver = new AndroidDriver(appiumServerURL, options);
		}

		private void configureForApkInstall(UiAutomator2Options options) {
		    options.setApp(mobile_configue.getProperty("Apk_Path"));
		    options.setFullReset(true);     // Optional: clean install
		    options.setNoReset(false);
		}

		private void configureForExistingApp(UiAutomator2Options options) {
		    options.setAppPackage("com.rdep.mpos");
		    options.setAppActivity("com.rdep.mpos.MainActivity");
		    options.setNoReset(true);       // Don’t clear app data
		    options.setFullReset(false);    // Don’t reinstall the app
		}

	  @AfterClass
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	

	   
}
