package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.NoSuchElementException;

public class FormInteractionMultipleMatching {
    private static final String TARGET_URL = "https://the-internet.herokuapp.com/login";
    private static final By LOGIN_INPUT_FIELDS_SEL = By.tagName( "input__" );

    private static final By LOGIN_BTN = By.cssSelector( "#login [type='submit']" );


    public static void main(String[] args) {

        WebDriver driver = DriverFactory.getWebDriver();
        driver.get( TARGET_URL );


        try {
            List<WebElement> loginFieldsEles = driver.findElements( LOGIN_INPUT_FIELDS_SEL );
            if (!loginFieldsEles.isEmpty()) {
                final int USERNAME_INDEX=0;
                final int PASSWORD_INDEX=1;
                loginFieldsEles.get( USERNAME_INDEX ).sendKeys( "tomsmith" );
                loginFieldsEles.get( PASSWORD_INDEX ).sendKeys( "tomsmith" );

            } else {
                throw new NoSuchElementException( "No login field found" );
            }
            driver.findElement( LOGIN_BTN ).click();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            driver.quit();
        }


    }

}
