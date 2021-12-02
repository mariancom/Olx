package starter;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"starter.utils.CucumberScreenshotListener"},
        features = "src/test/resources/features"
)
public class CucumberTestSuite {}
