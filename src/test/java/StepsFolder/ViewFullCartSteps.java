package StepsFolder;

import java.util.Arrays;
import java.util.List;

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
	public void validate_all_items_in_the_cart() {
	    List<String> actualItems = FullCartPage.validateCartItems();
	    List<String> expectedItems = Arrays.asList("Cucumber - 1 Kg", "Musk Melon - 1 Kg");

	    Assert.assertEquals(actualItems, expectedItems, 
	        "Please recheck the cart value. Expected " + expectedItems + " but found " + actualItems);
	}


}
