package StepsFolder;



import org.testng.Assert;

import com.qa.factory.DriverFactory;
import com.qa.pages.AddToCartPages;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AddToCartSteps 
{	
	
	
	private AddToCartPages AddToCartPage = new AddToCartPages(DriverFactory.getDriver());
	
	@Given("Customer navigates to GreenKart Application")
	public void customer_navigates_to_green_kart_application() 
	{
		DriverFactory.getDriver().get("https://rahulshettyacademy.com/seleniumPractise/#/");
		//AddToCartPage.clickonsite();   
	}

	@And("Customer clicks on Add To Cart")
	public void customer_clicks_on_add_to_cart() 
	{
		AddToCartPage.clickonaddtocart();
	    
	}

	@Then("Cart logo is updated by one")
	public void cart_logo_is_updated_by_one() {
		System.out.println("Yet to Automate");
	   
	}
	
	@And("Customer adds Cucumber and MuskMelon")
	public void customer_adds_multiple_items() throws InterruptedException
	{
		AddToCartPage.clickonaddtocart();
		
		AddToCartPage.ClickMultipleItems();
	}
	
	@Then("Cart logo in updated by two")
	public void cart_updated_by_two() throws InterruptedException {
	    Assert.assertEquals("2", AddToCartPage.CheckCartNo(), "Please recheck the cart value. Expected [2] but found [" + AddToCartPage.CheckCartNo() + "]");
	}
}