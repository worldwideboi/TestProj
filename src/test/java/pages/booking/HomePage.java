package pages.booking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pages.BasePage;

public class HomePage extends BasePage {

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = ":rh:")
    private WebElement destinationInput;
    @FindBy(xpath = "//button[@data-testid='date-display-field-start']")
    private WebElement calendarCallButton;
    @FindBy(xpath = "//button[@aria-label='Next month']")
    private WebElement nextMonthButton;
    @FindBy(xpath = "(//h3[@aria-live='polite'])[1]")
    private WebElement leftTableMonth;
    @FindBy(xpath = "(//h3[@aria-live='polite'])[2]")
    private WebElement rightTableMonth;
    @FindBy(xpath = "//span[@data-testid='occupancy-config']")
    private WebElement travelersDropDown;
    @FindBy(xpath = "(//div[@class='f71ad9bb14'])[2]/button[2]")
    private WebElement increaseChildrenButton;
    @FindBy(id = ":r5q:")
    private WebElement childrenAgeDropDownButton;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    public void selectDate(String date) {
        String[] month = date.split(" ");
        while (!month[2].equalsIgnoreCase(leftTableMonth.getText()) || !month[2].equalsIgnoreCase(rightTableMonth.getText())){
            click(nextMonthButton);
        }
        WebElement requiredDate = driver.findElement(By.xpath("//span[@aria-label='" + date + "']"));
        click(requiredDate);
    }

    public void selectChildTravelers(String childrenAmount, String childrenAge){
        for (int i = 0; i < Integer.parseInt(childrenAmount); i++) {
            click(increaseChildrenButton);
        }
        Select select = new Select(childrenAgeDropDownButton);
        select.selectByValue(childrenAge);
    }

    public void submitSearch() {
        click(submitButton);
    }
}
