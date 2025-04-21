package com.proenx.rdep.promotion.listner;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Mobile_App {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		
		
		 UiAutomator2Options options = new UiAutomator2Options();
	     options.setDeviceName("Rdep_Phone");
	     options.setPlatformName("Android");
	     options.setAutomationName("UiAutomator2");
	     options.setPlatformVersion("15");  // Double-check if this is correct; Android 15 is still very rare!
	     options.setApp("C:\\Users\\sunil\\Downloads\\instore_app_release_2.6.26_QA.apk");

	     URL url = URI.create("http://127.0.0.1:4723/wd/hub").toURL();
	     AndroidDriver driver = new AndroidDriver(url, options);
	     System.out.println("successfully installed");
	     // TODO: Add test steps

	     driver.quit();

	}

}
