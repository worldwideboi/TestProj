package pages.aircanada;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

public class DepartingFlightPage extends BasePage {
    public DepartingFlightPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@class = 'button-cell-container cabin-fare-0-Y']")
    private WebElement economyButton;
    @FindBy(xpath = "//button[@data-analytics-val='fare selection>economy>basic>select']")
    private WebElement economyBasicFare;
    @FindBy(xpath = "//button[@aria-label='Keep BASIC fare']")
    private WebElement keepChoseOptionButton;

    public void selectLowestEconomyBasicFare() {
        click(economyButton);
        click(economyBasicFare);
        click(keepChoseOptionButton);
    }
}
