package StepsFolder;

import org.testng.Assert;

import com.qa.factory.DriverFactory;
import com.qa.pages.ViewFullCartPages;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

public class ViewFullCartSteps {
	
	private ViewFullCartPages FullCartPage=new ViewFullCartPages(DriverFactory.getDriver());
	
	
	@Then("Customer clicks on cart logo")
	public void customer_clicks_on_cart_logo()
	{
		FullCartPage.clickoncart();
		
	}
	@And("Validate all items in the cart")
	public void validate_all_items_in_the_cart()
	{
		Assert.assertEquals("Cucumber - 1 Kg", FullCartPage.ValidateCartItems(), "Please recheck the cart value. Expected [2] but found [" + FullCartPage.ValidateCartItems() + "]");
	}

}
