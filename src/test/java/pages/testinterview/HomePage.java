package pages.testinterview;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

public class HomePage extends BasePage {
    private static final String BASE_URL = "";

    public HomePage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "")
    private WebElement name1;
    @FindBy(id = "")
    private WebElement name2;
    @FindBy(id = "")
    private WebElement name3;
    @FindBy(id = "")
    private WebElement name4;
    @FindBy(id = "")
    private WebElement name5;
    @FindBy(id = "")
    private WebElement name6;
    @FindBy(id = "")
    private WebElement name7;
    @FindBy(id = "")
    private WebElement name8;

    public void openHomePage(){
        goTo(BASE_URL);
    }
}
