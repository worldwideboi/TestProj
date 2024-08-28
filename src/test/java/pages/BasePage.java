package pages;

import driver.Driver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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

    public void cleanField(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, DURATION_OF_SECONDS);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
        element.clear();
    }
}
