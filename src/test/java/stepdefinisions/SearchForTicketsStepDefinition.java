package stepdefinisions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.aircanada.AirCanadaHomePage;
import pages.aircanada.DepartingFlightPage;
import pages.aircanada.ReturnFlightPage;
import pages.aircanada.TripReviewPage;

public class SearchForTicketsStepDefinition {
    AirCanadaHomePage homePage = new AirCanadaHomePage();
    DepartingFlightPage departingFlightPage = new DepartingFlightPage();
    ReturnFlightPage returnFlightPage = new ReturnFlightPage();
    TripReviewPage tripReviewPage = new TripReviewPage();

    @Given("User open Aircanada")
    public void userOpenAircanada() {
        homePage.openHomePage();
    }

    @Then("User on the main page")
    public void userOnTheMainPage() {
        homePage.isHomePageOpen();
    }

    @Given("Airbnb website is opened")
    public void airbnbWebsiteIsOpened() {

    }

    @When("User select a round trip for {string} Adults from {string} to {string} with departure date and return date")
    public void userSelectARoundTripForAdultsFromToWithDepartureDateAndReturnDate(String travelers, String departurePlace, String arrivalPlace){
        homePage.selectTravelers(travelers);
        homePage.selectDepartingPlace(departurePlace);
        homePage.selectArrivingPlace(arrivalPlace);
        homePage.selectDepartureDate(9);
        homePage.selectReturnDate(15);
        homePage.submitSearch();
    }

    @And("User select lowest Economy Basic fare on Departing Page Flight page")
    public void userSelectLowestEconomyBasicFareOnDepartingPageFlightPage() {
        departingFlightPage.selectLowestEconomyBasicFare();
    }

    @And("User select lowest Economy Basic fare on Return Page Flight page")
    public void userSelectLowestEconomyBasicFareOnReturnPageFlightPage() {
        returnFlightPage.selectLowestEconomyBasicFareReturnFlight();
    }

    @Then("User see Trip review page with a timer and selected Flights")
    public void userSeeTripReviewPageWithATimerAndSelectedFlights() {
        tripReviewPage.isTimerDisplayed();
        tripReviewPage.isTicketsDisplayed();
    }

}
