package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
	
	public class DriverFactory {

	    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	    public WebDriver init_driver(String browser) {
	        String cleanBrowser = browser.trim().replaceAll(";", "");
	        if (cleanBrowser.equalsIgnoreCase("chrome")) {
	            WebDriverManager.chromedriver().setup();
	            tlDriver.set(new ChromeDriver());
	        } else if (cleanBrowser.equalsIgnoreCase("firefox")) {
	            WebDriverManager.firefoxdriver().setup();
	            tlDriver.set(new FirefoxDriver());
	        } else if (cleanBrowser.equalsIgnoreCase("safari")) {
	            tlDriver.set(new SafariDriver());
	        } else {
	            throw new IllegalArgumentException("Please pass the correct browser value: " + browser);
	        }

	        if (getDriver() != null) {
	            getDriver().manage().deleteAllCookies();
	            getDriver().manage().window().maximize();
	        } else {
	            throw new RuntimeException("WebDriver initialization failed for browser: " + browser);
	        }
	        return getDriver();
	    }

	    public static synchronized WebDriver getDriver() {
	        return tlDriver.get();
	    }
}


