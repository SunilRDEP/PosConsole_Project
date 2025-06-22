package com.proenx.rdep.myproject.listner;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.google.common.io.Files;
import com.proenx.rdep.myproject.TestBase_Mobile;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomListners2_Mobile extends TestBase_Mobile implements ITestListener {
	   @Override
	    public void onTestStart(ITestResult result) {
	        test = report.createTest(result.getMethod().getMethodName());
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	        test.log(Status.PASS, "Test passed: " + result.getMethod().getMethodName());
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {
	        test.log(Status.FAIL, "Test failed: " + result.getMethod().getMethodName());
	        test.log(Status.FAIL, result.getThrowable());

	        String screenshotPath = takeScreenshot(result.getMethod().getMethodName());
	        if (screenshotPath != null) {
	            try {
	                test.fail("Screenshot of failure",
	                        MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	            } catch (Exception e) {
	                test.fail("Failed to attach screenshot: " + e.getMessage());
	            }
	        }
	    }

	    @Override
	    public void onTestSkipped(ITestResult result) {
	        test.log(Status.SKIP, "Test skipped: " + result.getMethod().getMethodName());
	    }

	    @Override
	    public void onStart(ITestContext context) {
	        // Optional
	    }

	    @Override
	    public void onFinish(ITestContext context) {
	        if (report != null) {
	            report.flush();
	        }
	    }

	    // Utility method to take screenshot
	    private String takeScreenshot(String methodName) {
	        if (driver == null) return null;
	        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	        String screenshotPath = System.getProperty("user.dir") + "/screenshots/" + methodName + "_" + timeStamp + ".png";
	        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        File destFile = new File(screenshotPath);
	        try {
	            Files.createParentDirs(destFile);
	            Files.copy(srcFile, destFile);
	            return screenshotPath;
	        } catch (IOException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }

 
	
	}

	
	

