package stepdefinisions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.aircanada.HomePage;

public class MyStepdefs {
    HomePage homePage = new HomePage();
    @Given("User open AirCanada")
    public void user_open_airCanada() {
        homePage.openHomePage();
    }

    @When("User select round trip for {int} adults from {string} to {string} with departure date {string} from current date and arrival date {string} from departure date")
    public void userSelectRoundTripForAdultsFromToWithDepartureDateFromCurrentDateAndArrivalDateFromDepartureDate(int adultsCount, String departurePlace, String arrivalPlace, String departureDate, String arrivalDate) {
        homePage.selectTravelers(adultsCount);
        homePage.selectDepartingPlace(departurePlace);
        homePage.selectArrivalPlace(arrivalPlace);
        homePage.selectDepartureDate(departureDate);
        homePage.selectArrivalDate(arrivalDate);
        homePage.submitSearch();
    }

    @Then("User see the result")
    public void userSeeTheResult() {
        System.out.println("aaaaa");
    }
}
