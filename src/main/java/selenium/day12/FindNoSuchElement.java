package selenium.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import selenium.driver.DriverFactory;

import java.util.List;

public class FindNoSuchElement {
    private static final String TARGET_URL = "https://the-internet.herokuapp.com/login";
    private static final By USERNAME_SEL = By.id( "username#" );
    private static final By PASSWORD_SEL = By.cssSelector( "#password" );
    private static final By LOGIN_BTN = By.cssSelector( "#login [type='submit']" );
    private static final String USERNAME_STR = "tomsmith";
    private static final String PASSWORD_STR = "SuperSecretPassword!";

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.getWebDriver();
        List<WebElement> usernameEles = driver.findElements( USERNAME_SEL );

        if (usernameEles.isEmpty()) {
            //Assert.fail( "The element ABC is on the page" ); This line got error and cannot run
        }
    }
}

