package stepdefinisions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.airbnb.HomePage;

public class SearchForApartmentsStepDefinitions {
    HomePage homePage = new HomePage();
    @Given("User open Airbnb")
    public void user_open_airbnb(){
      homePage.openHomePage();
    }

    @When("User search for apartments in {string} with checkIn date {string} from current date and checkOut date {string} from checkIn for {int} adults")
    public void userSearchForApartmentsInWithCheckInDateFromCurrentDateAndCheckOutDateFromCheckInForAdults(String destinationPlace, String checkIn, String checkOut, Integer travelersCount) {
        homePage.searchDestination(destinationPlace);
        homePage.selectCheckInDate(checkIn);
        homePage.selectCheckOutDate(checkOut);
        homePage.selectTravelers(travelersCount);
        homePage.submitSearch();
    }

    @Then("User see the results")
    public void userSeeTheResults() {
        homePage.isResultsDisplayed();
        homePage.isMoreThan1000Places();
    }
}
