package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddToCartPages 
{
	private WebDriver driver;
	private static By addtocart=By.xpath("(//button[@type='button'][normalize-space()='ADD TO CART'])[3]");
	
	public AddToCartPages(WebDriver driver) 
	{
		this.driver = driver;
	}	
	public void clickonaddtocart() 
	{
		
		driver.findElement(addtocart).click();		
	}
	/*public void clickonsite()
	{
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	}*/
}
