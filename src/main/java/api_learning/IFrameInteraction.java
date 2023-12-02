package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IFrameInteraction {
    private static final String TARGET_URL = "https://the-internet.herokuapp.com/iframe";
    private static final By IFRAME_SEL = By.cssSelector("iframe[id^='mce']");

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getWebDriver();
        driver.get( TARGET_URL );

        try {
            WebElement iframeEle = driver.findElement( IFRAME_SEL );
            //switch to target frame
            driver.switchTo().frame( iframeEle );
            // interact with iframe
            WebElement inputField = driver.findElement( By.id( "tinymce" ) );
            inputField.click();
            inputField.clear();
            inputField.sendKeys( "Tui ten la Teo" );
            Thread.sleep( 2000 );
            //switch back to the main frame
            driver.switchTo().defaultContent();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
