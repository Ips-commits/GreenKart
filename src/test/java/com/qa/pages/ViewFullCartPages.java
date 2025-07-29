package com.qa.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ViewFullCartPages {
	
	private WebDriver driver;
	private static By FullCart=By.xpath("//a[@class='cart-icon']");
	private static By itemsCucumber=By.xpath("(//p[@class='product-name'][normalize-space()='Cucumber - 1 Kg'])[1]");
	private static By itemsMuskMelon=By.xpath("(//p[@class='product-name'][normalize-space()='Musk Melon - 1 Kg'])[1]");
	private static By Checkout=By.xpath("(//button[normalize-space()='PROCEED TO CHECKOUT'])[1]");
	
	
	public ViewFullCartPages(WebDriver driver) 
	{
		this.driver = driver;
	}
	public void clickoncart()
	{
		driver.findElement(FullCart).click();
	}
	public List<String> validateCartItems()
	{
		
		ArrayList<String> items=new ArrayList<>();
		items.add(driver.findElement(itemsCucumber).getText());
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(itemsMuskMelon));
		items.add(driver.findElement(itemsMuskMelon).getText());
	
		return items;
	}
	public void clickoncheckout()
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(Checkout));
				
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element=driver.findElement(Checkout);
		js.executeScript("arguments[0].click();", element);
	}

}
