package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.NoSuchElementException;

public class MouseHoverAndNarrowDownSearchingScope {
    private static final String TARGET_URL = "https://the-internet.herokuapp.com/hovers";
    private static final By FIGURE_SEL = By.cssSelector( ".figure" );
    private static final By PROFILE_NAME_SEL = By.cssSelector( ".figcaption h5" );
    private static final By PROFILE_LINK_SEL = By.cssSelector( ".figcaption a" );

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getWebDriver();
        driver.get( TARGET_URL );

        try {
            List<WebElement> figureEles = driver.findElements( FIGURE_SEL );
            if (figureEles.isEmpty()) {
                throw new NoSuchElementException( "No figure element on page" );
            }
            Actions action = new Actions( driver );
            for (WebElement figureEle : figureEles) {
                // find child element
                WebElement profileNameEl = figureEle.findElement( PROFILE_NAME_SEL );
                WebElement profileLinkEl = figureEle.findElement( PROFILE_LINK_SEL );

                boolean isProfileNameDisplay = profileNameEl.isDisplayed();
                boolean isProfileLinkDisplay = profileNameEl.isDisplayed();
                System.out.println( "BEFORE: Profile name is " + isProfileNameDisplay );
                System.out.println( "BEFORE: Profile link is " + isProfileLinkDisplay );

                action.moveToElement( figureEle ).perform();

                isProfileNameDisplay = profileNameEl.isDisplayed();
                isProfileLinkDisplay = profileNameEl.isDisplayed();


                System.out.println( profileNameEl.getText() );
                System.out.println( profileLinkEl.getAttribute( "href" ) );
                System.out.println( "AFTER: Profile name is " + isProfileNameDisplay );
                System.out.println( "AFTER: Profile link is " + isProfileLinkDisplay );
                Thread.sleep( 3000 );
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
