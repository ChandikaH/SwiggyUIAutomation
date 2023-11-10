package org.swiggy.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.swiggy.baseUtils.TestBase;
import org.swiggy.pages.HomePage;
import org.swiggy.pages.SearchPage;

public class SwiggyStepDef extends TestBase {

    @Given("User is on Swiggy Home Page")
    public void userIsOnSwiggyHomePage() {
        TestBase.setup();
        homePage.verifyHomePageLoaded();
    }

    @And("User navigate to search page")
    public void userNavigateToSearchPage() {
        homePage.navigateToSearchPage();
    }

    @When("User searches for {string}")
    public void userSearches(String searchText) {
        searchPage.searchRestaurantsAndFood(searchText);
    }

    @Then("Search results for {string} are displayed")
    public void searchResultsDisplayed(String searchText) {
        searchPage.verifySearchResults();
    }
}
