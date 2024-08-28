package pages.airbnb;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

public class HomePage extends BasePage {

    public HomePage(){
        PageFactory.initElements(driver, this);
    }

    private static final String URL = "https://www.airbnb.com";

    @FindBy(id = "bigsearch-query-location-input")
    private WebElement destinationInput;
    @FindBy(xpath = "//div[@data-testid='structured-search-input-field-split-dates-0']")
    private WebElement checkInDateButton;
    @FindBy(xpath = "//div[@data-testid='structured-search-input-field-split-dates-1']")
    private WebElement checkOutDateButton;
    @FindBy(xpath = "//div[@class='_5nf23wc notranslate'][contains(text(), '25')]")
    private WebElement checkInDate;
    @FindBy(xpath = "//div[@class='_1xnkk5ra notranslate'][contains(text(), '21')]")
    private WebElement checkOutDate;
    @FindBy(xpath = "//div[@data-testid='structured-search-input-field-guests-button']")
    private WebElement selectTravelersButton;
    @FindBy(xpath = "//button[@data-testid='stepper-adults-increase-button']")
    private WebElement increaseAdultsAmount;
    @FindBy(xpath = "//button[@data-testid='structured-search-input-search-button']")
    private WebElement searchButton;
    @FindBy(xpath = "//div[@data-testid='structured-search-input-field-guests-panel']")
    private WebElement travelersTable;


    public void openHomePage(){
        goTo(URL);
    }

    public void selectDestination(String destination) {
        sendKeys(destinationInput, destination);
    }

    public void selectCheckInDate() {
        click(checkInDateButton);
        click(checkInDate);
    }

    public void selectCheckOutDate() {
        click(checkOutDateButton);
        click(checkOutDate);
    }

    public void selectTravelers() {
        click(selectTravelersButton);
        wait.until(ExpectedConditions.visibilityOf(travelersTable));
        for (int i = 0; i < 2; i++) {
            click(increaseAdultsAmount);
        }
    }

    public void submitSearch() {
        click(searchButton);
    }
}
