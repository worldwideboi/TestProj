package pages.booking;

import helpers.DataStorage;
import helpers.GetDataForTest;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

import java.util.List;

public class HomePage extends BasePage {
    private static final String BASE_URL = "https://www.booking.com/";
    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="onetrust-accept-btn-handler")
    private WebElement acceptCookieButton;
    @FindBy(id=":rh:")
    private WebElement destinationInput;
    @FindBy(xpath = "//div[@data-testid='searchbox-dates-container']")
    private WebElement datePickerButton;
    @FindBy(xpath = "(//h3[@aria-live='polite'])[1]")
    private WebElement monthYearInDatePicker;
    @FindBy(xpath = "//button[@aria-label='Next month']")
    private WebElement nextMonthButton;
    @FindBy(xpath = "//button[@data-testid='occupancy-config']")
    private WebElement travelersButton;
    @FindBy(xpath = "(//span[@class='fb7047f72a'])[1]")
    private WebElement adultsAmount;
    @FindBy(xpath = "(//div[@class='f71ad9bb14'])[1]//button[1]")
    private WebElement decreaseAdultsButton;
    @FindBy(xpath = "(//div[@class='f71ad9bb14'])[1]//button[2]")
    private WebElement increaseAdultsButton;
    @FindBy(xpath = "(//div[@data-testid='occupancy-popup']//button)[7]")
    private WebElement closeTravelersPanelButton;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitSearchButton;
    @FindBy(xpath = "//div[@data-testid='property-card']")
    private List<WebElement> availableOptions;

    public void openHomePage() {
        goTo(BASE_URL);
        click(acceptCookieButton);
    }

    public void selectDestination(String destinationPlace) {
        sendKeys(destinationInput, destinationPlace);
    }
    public void selectCheckInDate(String dateRange) {
        click(datePickerButton);
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
        WebElement day = driver.findElement(By.xpath("//span[@aria-label='" + targetDate + "']"));
        actions.moveToElement(day).click(day).perform();
    }
    public void selectCheckOutDate(String dateRange) {
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
        WebElement day = driver.findElement(By.xpath("//span[@aria-label='" + targetDate + "']"));
        actions.moveToElement(day).click(day).perform();
    }
    public void selectTravelers(int travelersCount) {
        click(travelersButton);
        int currentAdultsAmount = Integer.parseInt(adultsAmount.getText());
        if (currentAdultsAmount > travelersCount){
            while (!(currentAdultsAmount == travelersCount)) {
                click(decreaseAdultsButton);
                currentAdultsAmount = Integer.parseInt(adultsAmount.getText());
            }
            click(closeTravelersPanelButton);
        }else if (currentAdultsAmount < travelersCount) {
            while (!(currentAdultsAmount == travelersCount)){
                click(increaseAdultsButton);
                currentAdultsAmount = Integer.parseInt(adultsAmount.getText());
            }
            click(closeTravelersPanelButton);
        }else {

            click(closeTravelersPanelButton);
        }
    }
    public void submitSearch() {
        click(submitSearchButton);
    }
    public void isAvailableOptionsDisplayed() {
        wait.until(ExpectedConditions.urlContains("searchresults"));
        Assertions.assertThat(areElementsDisplayed(availableOptions)).isTrue();
    }
}
