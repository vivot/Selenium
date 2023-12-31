package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import selenium.driver.DriverFactory;

public class BaseTest {
    //class variable, share variable, should not use static
    protected static WebDriver driver;
    @BeforeTest
    protected void initBrowserSession()
    {
        driver = DriverFactory.getWebDriver();
    }
    @AfterTest(alwaysRun = true)
        public void closeBrowserSession(){
        if (driver!=null)
        {
            driver.quit();
        }

        }

}
