package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Driver {

    public static WebDriver driver;

    public static WebDriver getInstance() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            options.addArguments("--disable-search-engine-choice-screen");
            options.addArguments("--disable-popup-blocking");
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
        }
        return driver;
    }

    public static void quit() {
        if (driver != null) {
            driver.close();
            driver.quit();
            driver = null;
        }
    }
}
