package com.proenx.rdep.myproject.listner;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.google.common.io.Files;
import com.proenx.rdep.myproject.TestBase;

public class CustomListners extends TestBase implements ITestListener {

 
	@Override
	public void onTestStart(ITestResult result) {
	
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		test.pass("Admin UI Automation Test Script has passed");
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
	
			
			test.fail(result.getThrowable().getMessage());
			
			String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
			
			File dest = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\ScreenShots\\screenshot_" 
					+ timeStamp+ ".png");
			
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			// Now you can do whatever you need to do with it, for example copy somewhere
			try {
				Files.copy(scrFile, dest);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			test.fail(result.getMethod().getMethodName() +" is failed", 
					MediaEntityBuilder.createScreenCaptureFromPath(dest.toString()).build());
			
		}


	@Override
	public void onTestSkipped(ITestResult result) {
	
	}

	
	

}