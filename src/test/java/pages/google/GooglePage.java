package pages.google;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

public class GooglePage extends BasePage {
    private static final String url = "https://www.google.com/";
    public GooglePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "APjFqb")
    private WebElement inputField;
    @FindBy(id = "L2AGLb")
    private WebElement acceptGoogleCookiesButton;
    @FindBy(xpath = "//a[@href='https://www.royalmail.com/find-a-postcode']")
    private WebElement postCodeFinderButton;

    public void openGoogle(){
        goTo(url);
        click(acceptGoogleCookiesButton);
    }

    public void searchForGoogleQuery(String inputValue){
        click(inputField);
        sendKeys(inputField, inputValue);
        inputField.sendKeys(Keys.ENTER);
    }

    public void clickOnSearchPostCodeLink(){
        click(postCodeFinderButton);
    }
}
