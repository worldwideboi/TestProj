package pages.google;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

public class PostCodeSearchPage extends BasePage {
    public PostCodeSearchPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "consent_prompt_submit")
    private WebElement acceptCookiesButton;
    @FindBy(id = "edit-rml-postcode-finder-postal-code")
    private WebElement inputPostCodeField;
    @FindBy(xpath = "(//div[@class = 'pca pcalist'])[1]")
    private WebElement optionsList;
    @FindBy(xpath = "(//div[@class = 'pca pcalist']/div)[1]")
    private WebElement firstIndex;

    public void acceptCookie(){
        click(acceptCookiesButton);
    }
    public void searchForPostCodeQuery(String inputValue){
        click(inputPostCodeField);
        sendKeys(inputPostCodeField, inputValue);
    }
    public void isFirstIndexDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(optionsList));
        Assertions.assertThat(isElementDisplayed(firstIndex)).isTrue();
    }

}
