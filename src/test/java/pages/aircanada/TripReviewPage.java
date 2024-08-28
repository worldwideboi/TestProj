package pages.aircanada;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

public class TripReviewPage extends BasePage {
    public TripReviewPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='ac-card']")
    private WebElement ticketBoard;
    @FindBy(xpath = "//span[@class='time-remaining']")
    private WebElement timer;

    public void isTimerDisplayed(){
        wait.until(ExpectedConditions.urlContains("review-trip"));
        Assertions.assertThat(isElementDisplayed(timer)).isTrue();
    }
    public void isTicketsDisplayed(){
        wait.until(ExpectedConditions.urlContains("review-trip"));
        Assertions.assertThat(isElementDisplayed(ticketBoard)).isTrue();
    }
}
