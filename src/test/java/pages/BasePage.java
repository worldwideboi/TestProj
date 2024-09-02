package pages;

import driver.Driver;
import helpers.GetDataForTest;
import helpers.StringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class BasePage {

    protected static WebDriver driver = Driver.getInstance();
    private static final Duration DURATION_OF_SECONDS = Duration.ofSeconds(15);
    protected static Actions actions = new Actions(driver);
    protected static WebDriverWait wait = new WebDriverWait(driver, DURATION_OF_SECONDS);

    public void goTo(String url){
        driver.get(url);
    }

    public void click(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void sendKeys(WebElement element, String inputValue){
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.sendKeys(inputValue);
    }
    public boolean isElementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            return false;
        }
    }

    public boolean areElementsDisplayed(List<WebElement> elements) {
        try {
            for (WebElement element : elements) {
                if (!element.isDisplayed()) {
                    return false;
                }
            }
            return true;
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            return false;
        }
    }

    public void cleanField(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, DURATION_OF_SECONDS);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
        element.clear();
    }
}
