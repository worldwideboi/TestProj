package stepdefinisions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.google.GooglePage;
import pages.google.PostCodeSearchPage;

public class SearchForPostCodeStepDefinition {
    GooglePage google = new GooglePage();
    PostCodeSearchPage postCodeSearchPage = new PostCodeSearchPage();
    @Given("User open Google")
    public void user_open_google() {
        google.openGoogle();
    }

    @When("User enter {string} in the Google search field")
    public void user_enter_in_the_google_search_field(String arg0) {
        google.searchForGoogleQuery(arg0);
    }

    @Given("User open first link on the page")
    public void user_open_first_link_on_the_page() {
        google.clickOnSearchPostCodeLink();
        postCodeSearchPage.acceptCookie();
    }

    @When("User enter {string} in the postcode search field")
    public void userEnterInThePostcodeSearchField(String country) {
        postCodeSearchPage.searchForPostCodeQuery(country);
    }

    @Then("User able to see the list of results")
    public void user_able_to_see_the_list_of_results(){
        postCodeSearchPage.isFirstIndexDisplayed();
    }
}
