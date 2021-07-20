package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.c24_POM;

public class c24_Steps {

    c24_POM c24_pom=new c24_POM();

    @Given("User navigates to {string}")
    public void userNavigatesTo(String url) {
        c24_pom.navigateToHomePage(url);

    }

    @Then("The user should be able to go to the Mobilfunk page by clicking the button.")
    public void theUserShouldBeAbleToGoToTheMobilfunkPageByClickingTheButton() {
        c24_pom.goToHandyPage();

    }

    @When("tariff features are selected, the user should be able to see the tariffs.")
    public void tariffFeaturesAreSelectedTheUserShouldBeAbleToSeeTheTariffs() {
        c24_pom.selectTariffFeatures();

    }

    @Then("the user should be able to add a mobile phone to the plan.")
    public void theUserShouldBeAbleToAddAMobilePhoneToThePlan() {
        c24_pom.addAMobilePhone();
    }




    @And("the user should  be able to choose a tariff.")
    public void theUserShouldBeAbleToChooseATariff() {
        c24_pom.checkTheTariffs();
    }
}
