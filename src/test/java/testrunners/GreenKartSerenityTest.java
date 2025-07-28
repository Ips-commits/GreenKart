package testrunners;

import net.serenitybdd.cucumber.CucumberWithSerenity;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features = {"src/test/resources/features/ViewFullCart.feature"},
    glue = {"StepsFolder","AppHooks"},
    plugin = {"pretty"}
)
public class GreenKartSerenityTest {
}

