package com.qa.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;


public class AddToCartPages 
{
	private WebDriver driver;
	private static By Cucumber=By.xpath("(//button[@type='button'][normalize-space()='ADD TO CART'])[3]");
	private static By MuskMelon=By.xpath("(//button[@type='button'][normalize-space()='ADD TO CART'])[18]");
	private static By CartNo=By.xpath("//strong[normalize-space()='2']");
	
	public AddToCartPages(WebDriver driver) 
	{
		this.driver = driver;
	}	
	public void clickonaddtocart() 
	{
		
		driver.findElement(Cucumber).click();		
	}
	public void ClickMultipleItems() throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(MuskMelon));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element=driver.findElement(MuskMelon);
		js.executeScript("arguments[0].scrollIntoView();", element);
		js.executeScript("arguments[0].click();", element);
	}
	public String CheckCartNo() throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(CartNo));
		String cart=driver.findElement(CartNo).getText();
		return cart;
		
	}
}
