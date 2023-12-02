package api_learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import driver.DriverFactory;

public class FormInteraction {
    private static final String TARGET_URL = "https://the-internet.herokuapp.com/login";
    private static final By USERNAME_SEL = By.id( "username" );
    private static final By PASSWORD_SEL = By.cssSelector( "#password" );
    private static final By LOGIN_BTN = By.cssSelector( "#login [type='submit']" );
    private static final String USERNAME_STR = "tomsmith";
    private static final String PASSWORD_STR = "SuperSecretPassword!";

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.getWebDriver();
        driver.get( TARGET_URL );

        try {
            WebElement userNameEl = driver.findElement( USERNAME_SEL );
            WebElement passWordEl = driver.findElement( PASSWORD_SEL );
            WebElement loginBtnEl = driver.findElement( LOGIN_BTN );

            // Refresh page (need to refresh element for Stale stack exception
            driver.navigate().refresh();
            userNameEl = driver.findElement( USERNAME_SEL );
            passWordEl = driver.findElement( PASSWORD_SEL );
            loginBtnEl = driver.findElement( LOGIN_BTN );

            userNameEl.sendKeys( USERNAME_STR );
            passWordEl.sendKeys( PASSWORD_STR );
            loginBtnEl.click();

            driver.navigate().back();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            driver.quit();
        }

    }
}
