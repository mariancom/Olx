package starter.keywords;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.steps.OLX_Steps;


public class OLX_Keywords {

    @Steps
    OLX_Steps olx_steps;

    @Given("the user navigates to OLX")
    public void theUserNavigatesToOLX() {
        olx_steps.olx_navigation();

    }

    @When("the user searches for apartments")
    public void theUserSearchesForApartments() {
        olx_steps.olx_searchingApartments();

    }

    @Then("the user will get a list of apartments")
    public void theUserWillGetAListOfApartments() {
        olx_steps.olx_printing_list();

    }
}
