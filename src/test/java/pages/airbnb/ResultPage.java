package pages.airbnb;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

public class ResultPage extends BasePage {
    public ResultPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//h1/span)[1]")
    private WebElement pageHeadingDescription;

    public void isMoreThan1000Results(){
        wait.until(ExpectedConditions.visibilityOf(pageHeadingDescription));
        Assertions.assertThat(pageHeadingDescription.getText().contains("Over 1,000")).isTrue();
    }
}
