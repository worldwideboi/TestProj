package pages.aircanada;

import helpers.DataStorage;
import helpers.GetDataForTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

public class HomePage extends BasePage {
    private static final String BASE_URL = "https://www.aircanada.com/";
    public HomePage() {
        PageFactory.initElements(driver, this);
    }


    @FindBy(id="onetrust-accept-btn-handler")
    public WebElement acceptCookieButton;
    @FindBy(id="bkmg-desktop_selectTravelers")
    public WebElement selectTravelersButton;
    @FindBy(id="selectTravelersPanel")
    public WebElement travelersPanel;
    @FindBy(id="bkmg-desktop_selectTravelers_travelerCount_ADT")
    public WebElement adultsCountInput;
    @FindBy(id="bkmg-desktop_selectTravelers_confirmTravelers")
    public WebElement closeTravelersPanelButton;
    @FindBy(id="flightsOriginLocationbkmgLocationContainer")
    public WebElement departureButton;
    @FindBy(id="flightsOriginLocation")
    public WebElement departureInput;
    @FindBy(id="flightsOriginDestinationbkmgLocationContainer")
    public WebElement arrivalButton;
    @FindBy(id="flightsOriginDestination")
    public WebElement arrivalInput;
    @FindBy(id="bkmg-desktop_travelDates-formfield-1")
    public WebElement departureDateButton;
    @FindBy(xpath = "(//table)[2]//caption")
    public WebElement monthYearInDatePicker;
    @FindBy(id="bkmg-desktop_travelDates_1_confirmDates")
    public WebElement confirmDateButton;
    @FindBy(id="bkmg-desktop_travelDates_nextMonth")
    public WebElement nextMonthButton;
    @FindBy(id="bkmg-desktop_findButton")
    public WebElement submitSearchButton;


    public void openHomePage() {
        goTo(BASE_URL);
        click(acceptCookieButton);
    }

    public void selectTravelers(int travelersCount) {
        click(selectTravelersButton);
        cleanField(adultsCountInput);
        sendKeys(adultsCountInput, String.valueOf(travelersCount));
        click(closeTravelersPanelButton);
        wait.until(ExpectedConditions.invisibilityOf(travelersPanel));
    }

    public void selectDepartingPlace(String departingPlace) {
        click(departureButton);
        sendKeys(departureInput, departingPlace);
    }
    public void selectArrivalPlace(String arrivalPlace) {
        click(arrivalButton);
        sendKeys(arrivalInput, arrivalPlace);
    }
    public void selectDepartureDate(String dateRange) {
        click(departureDateButton);
        GetDataForTest.setDate(dateRange, GetDataForTest.getCurrentDate());
        String targetDate = DataStorage.getValue("targetDate");
        String[] targetDateParts = targetDate.split(" ");
        String[] dateInDatePicker = monthYearInDatePicker.getText().split(" ");
        while (!targetDateParts[2].equalsIgnoreCase(dateInDatePicker[1])) {
            click(nextMonthButton);
            dateInDatePicker = monthYearInDatePicker.getText().split(" ");
        }
        while (!targetDateParts[1].equalsIgnoreCase(dateInDatePicker[0])) {
            click(nextMonthButton);
            dateInDatePicker = monthYearInDatePicker.getText().split(" ");
        }
        WebElement day = driver.findElement(By.xpath("(//table)[2]//div[(text() = '" + targetDateParts[0] + "')]"));
        actions.moveToElement(day).click(day).perform();
    }

    public void selectArrivalDate(String dateRange) {
        GetDataForTest.setDate(dateRange, GetDataForTest.getFirstDate());
        String targetDate = DataStorage.getValue("targetDate");
        String[] targetDateParts = targetDate.split(" ");
        String[] dateInDatePicker = monthYearInDatePicker.getText().split(" ");
        while (!targetDateParts[2].equalsIgnoreCase(dateInDatePicker[1])) {
            click(nextMonthButton);
            dateInDatePicker = monthYearInDatePicker.getText().split(" ");
        }
        while (!targetDateParts[1].equalsIgnoreCase(dateInDatePicker[0])) {
            click(nextMonthButton);
            dateInDatePicker = monthYearInDatePicker.getText().split(" ");
        }
        WebElement day = driver.findElement(By.xpath("(//table)[2]//div[(text() = '" + targetDateParts[0] + "')]"));
        actions.moveToElement(day).click(day).moveToElement(confirmDateButton).click(confirmDateButton).perform();
    }
    public void submitSearch(){
        click(submitSearchButton);
    }
}
