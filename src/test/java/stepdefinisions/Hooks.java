package stepdefinisions;

import driver.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    @Before
    public void setUp(){
        Driver.getInstance();
    }
    @After
    public void tearDown(){
//        Driver.quit();
    }
}
