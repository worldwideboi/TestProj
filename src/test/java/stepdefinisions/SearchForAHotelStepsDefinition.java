package stepdefinisions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.airbnb.HomePage;
import pages.airbnb.ResultPage;

public class SearchForAHotelStepsDefinition {
    HomePage homePage = new HomePage();
    ResultPage resultPage = new ResultPage();

    @Given("^User open AirBnb$")
    public void user_open_airbnb(){
        homePage.openHomePage();
    }

    @When("User search for a hotel in {string}")
    public void userSearchForAHotelIn(String destination) {
        homePage.selectDestination(destination);
        homePage.selectCheckInDate();
        homePage.selectCheckOutDate();
        homePage.selectTravelers();
        homePage.submitSearch();
    }

    @Then("User see the result page with results")
    public void user_see_the_result_page_with_results() {
        resultPage.isMoreThan1000Results();
    }
}
