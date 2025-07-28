package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ViewFullCartPages {
	
	private WebDriver driver;
	private static By FullCart=By.xpath("//a[@class='cart-icon']");
	private static By items=By.xpath("(//p[@class='product-name'][normalize-space()='Cucumber - 1 Kg'])[1]");
	
	public ViewFullCartPages(WebDriver driver) 
	{
		this.driver = driver;
	}
	public void clickoncart()
	{
		driver.findElement(FullCart).click();
	}
	public String ValidateCartItems()
	{
		String itemsNo=driver.findElement(items).getText();
		return itemsNo;
	}

}
