package pages.airbnb;

import helpers.DataStorage;
import helpers.GetDataForTest;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class HomePage extends BasePage {
    DataStorage dataStorage = new DataStorage();
    public HomePage() {
        PageFactory.initElements(driver, this);
    }
    private static final String BASE_URL = "https://www.airbnb.ca/";

    @FindBy(xpath = "(//div[@data-testid='main-cookies-banner-container']//button)[2]")
    private WebElement acceptCookieButton;
    @FindBy(id="bigsearch-query-location-input")
    private WebElement destinationInput;
    @FindBy(xpath = "//div[@data-testid='structured-search-input-field-split-dates-0']")
    private WebElement checkInButton;
    @FindBy(xpath = "//div[@data-testid='structured-search-input-field-split-dates-1']")
    private WebElement checkOutButton;
    @FindBy(xpath = "//div[@data-testid='structured-search-input-field-guests-button']")
    private WebElement travelersButton;
    @FindBy(xpath = "(//div[@data-visible='true'])[1]//h2")
    private WebElement monthYearInDatePicker;
    @FindBy(xpath = "//div[@class='_qz9x4fc']//button")
    private WebElement nextMonthButton;
    @FindBy(xpath = "//button[@data-testid='structured-search-input-search-button']")
    private WebElement searchButton;
    @FindBy(xpath = "//span[@data-testid='stepper-adults-value']")
    private WebElement adultsValue;
    @FindBy(xpath = "//button[@data-testid='stepper-adults-increase-button']")
    private WebElement increaseAdultsButton;
    @FindBy(id="site-content")
    private WebElement resultPageContent;
    @FindBy(xpath = "(//h1/span)[1]")
    private WebElement resultPageHeading;

    public void openHomePage() {
        goTo(BASE_URL);
        click(acceptCookieButton);
    }

    public void searchDestination(String destination) {
        click(destinationInput);
        sendKeys(destinationInput, destination);
    }

    public void selectCheckInDate(String dateRange) {
        click(checkInButton);
        GetDataForTest.setDate(dateRange, GetDataForTest.getCurrentDate());
        String targetDate = DataStorage.getValue("targetDate");
        String[] targetDateParts = targetDate.split(" ");
        String[] dateInDatePicker = monthYearInDatePicker.getText().split(" ");
        while (!targetDateParts[2].equalsIgnoreCase(dateInDatePicker[1])){
            click(nextMonthButton);
            dateInDatePicker = monthYearInDatePicker.getText().split(" ");
        }
        while (!targetDateParts[1].equalsIgnoreCase(dateInDatePicker[0])){
            click(nextMonthButton);
            dateInDatePicker = monthYearInDatePicker.getText().split(" ");
        }
        WebElement day = driver.findElement(By.xpath("//td[contains(@aria-label, '"+ targetDateParts[1] +"')]//div[(text() = '"+ targetDateParts[0] +"')]"));
        actions.moveToElement(day).click(day).perform();
    }

    public void selectCheckOutDate(String dateRange) {
        GetDataForTest.setDate(dateRange, GetDataForTest.getFirstDate());
        String targetDate = DataStorage.getValue("targetDate");
        String[] targetDateParts = targetDate.split(" ");
        String[] dateInDatePicker = monthYearInDatePicker.getText().split(" ");
        while (!targetDateParts[2].equalsIgnoreCase(dateInDatePicker[1])){
            click(nextMonthButton);
            dateInDatePicker = monthYearInDatePicker.getText().split(" ");
        }
        while (!targetDateParts[1].equalsIgnoreCase(dateInDatePicker[0])){
            click(nextMonthButton);
            dateInDatePicker = monthYearInDatePicker.getText().split(" ");
        }
        WebElement day = driver.findElement(By.xpath("//td[contains(@aria-label, '"+ targetDateParts[1] +"')]//div[(text() = '"+ targetDateParts[0] +"')]"));
        actions.moveToElement(day).click(day).perform();
    }
    public void selectCheckInDate1(String date) {
        click(checkInButton);
        DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("MMMM d, yyyy");
        DateTimeFormatter outPutFormat = DateTimeFormatter.ofPattern("d MMMM yyyy");

        LocalDate date1 = LocalDate.parse(date, inputFormat);
        String targetDate = date1.format(outPutFormat);

        String[] targetDateParts = targetDate.split(" ");
        String[] dateInDatePicker = monthYearInDatePicker.getText().split( " ");
        while (!targetDateParts[2].equalsIgnoreCase(dateInDatePicker[1])){
            click(nextMonthButton);
            dateInDatePicker = monthYearInDatePicker.getText().split(" ");
        }
        while (!targetDateParts[1].equalsIgnoreCase(dateInDatePicker[0])){
            click(nextMonthButton);
            dateInDatePicker = monthYearInDatePicker.getText().split(" ");
        }
        WebElement day = driver.findElement(By.xpath("//td[contains(@aria-label, '"+ targetDateParts[1] +"')]//div[(text() = '"+ targetDateParts[0] +"')]"));
        actions.moveToElement(day).click(day).perform();
    }

    public void selectCheckOutDate1(String date) {
        DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("MMMM d, yyyy");
        DateTimeFormatter outPutFormat = DateTimeFormatter.ofPattern("d MMMM yyyy");

        LocalDate date1 = LocalDate.parse(date, inputFormat);
        String targetDate = date1.format(outPutFormat);

        String[] targetDateParts = targetDate.split(" ");
        String[] dateInDatePicker = monthYearInDatePicker.getText().split( " ");
        while (!targetDateParts[2].equalsIgnoreCase(dateInDatePicker[1])){
            click(nextMonthButton);
            dateInDatePicker = monthYearInDatePicker.getText().split(" ");
        }
        while (!targetDateParts[1].equalsIgnoreCase(dateInDatePicker[0])){
            click(nextMonthButton);
            dateInDatePicker = monthYearInDatePicker.getText().split(" ");
        }
        WebElement day = driver.findElement(By.xpath("//td[contains(@aria-label, '"+ targetDateParts[1] +"')]//div[(text() = '"+ targetDateParts[0] +"')]"));
        actions.moveToElement(day).click(day).perform();
    }
    public void selectTravelers(int travelersCount) {
        click(travelersButton);
        while(!(travelersCount == Integer.parseInt(adultsValue.getText()))){
            click(increaseAdultsButton);
        }
    }
    public void submitSearch() {
        click(searchButton);
    }
    public void isResultsDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(resultPageContent));
        Assertions.assertThat(isElementDisplayed(resultPageContent)).isTrue();
    }
    public void isMoreThan1000Places(){
        wait.until(ExpectedConditions.visibilityOf(resultPageHeading));
        String headingText = resultPageHeading.getText();
        Assertions.assertThat(headingText).contains("Over 1,000");
    }
}
