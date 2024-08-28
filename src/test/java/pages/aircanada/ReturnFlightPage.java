package pages.aircanada;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

public class ReturnFlightPage extends BasePage {
    public ReturnFlightPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@class='button-cell-container cabin-fare-1-Y']")
    private WebElement economyButton;
    @FindBy(xpath = "//button[@data-analytics-val='fare selection>economy>basic>select']")
    private WebElement economyBasicFare;

    public void selectLowestEconomyBasicFareReturnFlight() {
        wait.until(ExpectedConditions.urlContains("inbound"));
        actions.scrollToElement(economyButton).click(economyButton).perform();
        click(economyBasicFare);
    }
}
