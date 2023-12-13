package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.ui.ExplicitWaitForEnable;

import java.time.Duration;

public class ExplicitWait {
    private static final String TARGET_URL = "https://the-internet.herokuapp.com/login";
    private static final By USERNAME_SEL = By.id( "username" );


    public static void main(String[] args) {

        WebDriver driver = DriverFactory.getWebDriver();
        driver.get( TARGET_URL );

        try {
            /*
             ImplicitWait - Applied globally for the whole session when finding elements -
             limit driver instance by interval time 500 miliseconds
             ExplicitWait - Applied locally wait for a specific element that takes longer time to visible
*/

            WebDriverWait webDriverWait = new WebDriverWait( driver, Duration.ofSeconds( 5 ) );

            //    This one return Timeout Exception if condition is not matched
            // webDriverWait.until( ExpectedConditions.visibilityOfElementLocated( By.id( "taolao" ) ) );

            // Trigger and verify element disappear
//            try{
//                //    This one return No Such Exception if condition is not matched
//
//                webDriverWait.until( ExpectedConditions.invisibilityOfElementLocated( By.id( "taolao" ) ) );
//            }
//            catch (TimeoutException timeoutException)
//            {
//                Assert.fail("This element should be not displayed");
//            }

//            webDriverWait.until( ExpectedConditions.visibilityOf(driver.findElement(By.id( "taolao" ) )));
            webDriverWait.until( new ExplicitWaitForEnable( By.cssSelector( "#something" ) ) );

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            driver.quit();
        }
    }
}
