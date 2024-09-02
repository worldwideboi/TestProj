package stepdefinisions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.booking.HomePage;

public class BookingStepDefs {
    HomePage homePage = new HomePage();

    @Given("User open Booking")
    public void user_open_booking() {
        homePage.openHomePage();
    }

    @When("User search for apartments in {string} with checkIn  {string} from current date and checkOut date {string} from checkIn for {int} adults")
    public void userSearchForApartmentsInWithCheckInFromCurrentDateAndCheckOutDateFromCheckInForAdults(String destinationPlace, String checkInDate, String checkOutDate, int travelersCount) {
        homePage.selectDestination(destinationPlace);
        homePage.selectCheckInDate(checkInDate);
        homePage.selectCheckOutDate(checkOutDate);
        homePage.selectTravelers(travelersCount);
        homePage.submitSearch();
    }

    @Then("User able to see the result page")
    public void userAbleToSeeTheResultPage() {
        homePage.isAvailableOptionsDisplayed();
    }
}
