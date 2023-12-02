package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GettingAttributeValue {
    private static final String TARGET_URL = "https://the-internet.herokuapp.com/login";

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.getWebDriver();
        driver.get( TARGET_URL );

        try {
            By powerByPartialLinkTextSel = By.partialLinkText( "Selenium" );


            WebElement powerByPartialLinkTextEl = driver.findElement( powerByPartialLinkTextSel );
            System.out.println( powerByPartialLinkTextEl.getAttribute( "target" ) );
            try {
                Thread.sleep( 2000 );
            } catch (Exception ignored) {

            }

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            driver.quit();
        }
    }
}
