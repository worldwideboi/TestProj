package stepdefinisions;

import driver.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Hooks {
    @Before
    public void setUp(){
        Driver.getInstance().manage().deleteAllCookies();
        Driver.getInstance().manage().window().maximize();
        Driver.getInstance().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Driver.getInstance().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(300));
    }
    @After
    public void tearDown(){
        Driver.quit();
    }
}
