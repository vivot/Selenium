package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkTextInteraction {
    public static final String TARGET_URL = "https://the-internet.herokuapp.com/login";

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getWebDriver();
        driver.get( TARGET_URL );

        try {
          //  By powerByLinkTextSel = By.linkText( "Elemental Selenium" );
          //  By powerByPartialLinkTextSel=By.partialLinkText( "Selenium" );
              By cssLinkTextSel =By.cssSelector("a[href^='http://elementalselenium.com/']");
              WebElement cssLinkTextEl=driver.findElement( cssLinkTextSel );

          //  WebElement powerByLinkTextEle = driver.findElement( powerByLinkTextSel );
         //   WebElement powerByPartialLinkTextEl=driver.findElement( powerByPartialLinkTextSel );
            //powerByLinkTextEle.click();
         //   powerByPartialLinkTextEl.click();
            cssLinkTextEl.click();
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
