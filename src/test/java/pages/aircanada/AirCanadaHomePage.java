package pages.aircanada;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AirCanadaHomePage extends BasePage {
    private static final String URL = "http://www.aircanada.com";
    public AirCanadaHomePage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "flightsOriginLocationbkmgLocationContainer")
    private WebElement departingButton;
    @FindBy(id = "flightsOriginDestinationbkmgLocationContainer")
    private WebElement arrivingButton;
    @FindBy(id = "flightsOriginLocation")
    private WebElement departingInput;
    @FindBy(id = "flightsOriginDestination")
    private WebElement arrivingInput;
    @FindBy(id = "bkmg-desktop_travelDates-formfield-1")
    private WebElement departureDateInput;
    @FindBy(id = "bkmg-desktop_travelDates-formfield-2")
    private WebElement returnDateInput;
    @FindBy(id = "bkmg-desktop_selectTravelers")
    private WebElement selectTravelersButton;
    @FindBy(id = "bkmg-desktop_selectTravelers_confirmTravelers")
    private WebElement closeTravelersButton;
    @FindBy(id = "bkmg-desktop_selectTravelers_travelerCount_ADT")
    private WebElement adultInput;
    @FindBy(id = "bkmg-desktop_findButton")
    private WebElement searchButton;
    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement acceptCookieButton;
    @FindBy(id = "flightsOriginDestinationSearchResult1")
    private WebElement firstOptionOfResult;
    @FindBy(id = "selectTravelersPanel")
    private WebElement travelersPanel;
    @FindBy(id = "bkmg-desktop_travelDates_1_confirmDates")
    private WebElement confirmDatesButton;
    @FindBy(xpath = "(//caption)[2]")
    private WebElement leftTable;
    @FindBy(id = "bkmg-desktop_travelDates_nextMonth")
    private WebElement nextMonthButton;




    public void openHomePage() {
        goTo(URL);
        click(acceptCookieButton);
    }

    public void isHomePageOpen() {
        Assertions.assertThat(driver.getCurrentUrl().contains("home")).isTrue();
    }

    public void selectDepartingPlace(String city) {
        click(departingButton);
        sendKeys(departingInput, city);
    }

    public void selectArrivingPlace(String city) {
        click(arrivingButton);
        sendKeys(arrivingInput, city);
    }

    public void selectTravelers(String amountOfTravelers){
        click(selectTravelersButton);
        cleanField(adultInput);
        sendKeys(adultInput, amountOfTravelers);
        click(closeTravelersButton);
        wait.until(ExpectedConditions.invisibilityOf(travelersPanel));
    }

    public void selectDate(String date) {
        click(departureDateInput);
        String[] dateParts = date.split(" ");
        String day = dateParts[1].replace(",", " ");
        String month = dateParts[0];
        String year = dateParts[2];
        String[] dateInDatePicker = leftTable.getText().split(" ");

        while(!dateInDatePicker[1].equalsIgnoreCase(year) && !dateInDatePicker[0].equalsIgnoreCase(month)) {
            click(nextMonthButton);
        }

        WebElement targetDay = driver.findElement(By.xpath("(//table)[2]//div[contains(text(), '" + day + "')]"));
        click(targetDay);
    }

    public void selectDepartureDate(long departurePlusDate) {
        click(departureDateInput);
        LocalDate todayDate = LocalDate.now();
        LocalDate targetDepartureDate = todayDate.plusDays(departurePlusDate);
        String formattedDepartureDate = targetDepartureDate.format(DateTimeFormatter.ofPattern("d MMMM yyyy"));
        String[] targetDateParts = formattedDepartureDate.split(" ");
        String[] dateInDatePicker = leftTable.getText().split(" ");
        while (!dateInDatePicker[1].equalsIgnoreCase(targetDateParts[2]) && !dateInDatePicker[0].equalsIgnoreCase(targetDateParts[1])) {
            click(nextMonthButton);
        }
        WebElement departureDay = driver.findElement(By.xpath("(//table)[2]//div[contains(text(), '" + targetDateParts[0] + "')]"));
        click(departureDay);
    }

    public void selectReturnDate(long returnPlusDay) {
        click(returnDateInput);
        LocalDate todayDate = LocalDate.now();
        LocalDate targetReturnDate = todayDate.plusDays(returnPlusDay);
        String formattedReturnDate = targetReturnDate.format(DateTimeFormatter.ofPattern("d MMMM yyyy"));
        String[] targetDateParts = formattedReturnDate.split(" ");
        String[] dateInDatePicker = leftTable.getText().split(" ");
        while (!targetDateParts[2].equalsIgnoreCase(dateInDatePicker[1]) && !targetDateParts[1].equalsIgnoreCase(dateInDatePicker[0])){
            click(nextMonthButton);
        }
        WebElement returnDay = driver.findElement(By.xpath("(//table)[2]//div[contains(text(), '" + targetDateParts[0] + "')]"));
        click(returnDay);
    }

    public void selectDepartureDate1(long departurePlusMonth, long departurePlusWeeks) {
        LocalDate today = LocalDate.now();
        LocalDate targetDepartureDate = today.plusMonths(departurePlusMonth).plusWeeks(departurePlusWeeks);
        String formattedDepartureDate = targetDepartureDate.format(DateTimeFormatter.ofPattern("d MMMM yyyy"));
        String[] targetDateParts = formattedDepartureDate.split(" ");
        String[] dateInDatePicker = leftTable.getText().split(" ");
        while (!targetDateParts[2].equalsIgnoreCase(dateInDatePicker[1]) && !targetDateParts[1].equalsIgnoreCase(dateInDatePicker[0])) {
            click(nextMonthButton);
        }
        WebElement departureDate = driver.findElement(By.xpath("(//table)[2]//div[contains(text(), '" + targetDateParts[0] + "')]"));
        click(departureDate);
    }

    public void selectReturnDate1(long departurePlusMonth, long departurePlusWeeks) {
        LocalDate today = LocalDate.now();
        LocalDate targetReturnDate = today.plusMonths(departurePlusMonth).plusWeeks(departurePlusWeeks);
        String formattedReturnDate = targetReturnDate.format(DateTimeFormatter.ofPattern("d MMMM yyyy"));
        String[] targetDateParts = formattedReturnDate.split(" ");
        String[] dateInDatePicker = leftTable.getText().split(" ");
        while (!targetDateParts[2].equalsIgnoreCase(dateInDatePicker[1]) && !targetDateParts[1].equalsIgnoreCase(dateInDatePicker[0])) {
            click(nextMonthButton);
        }
        WebElement returnDate = driver.findElement(By.xpath("(//table)[2]//div[contains(text(), '" + targetDateParts[0] + "')]"));
        click(returnDate);
    }

        public void submitSearch() {
        actions.scrollToElement(searchButton).click(searchButton).perform();
    }

}
