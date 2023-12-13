package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.ui.ExplicitWaitForEnable;

import java.time.Duration;

public class DynamicControl {
    private static final String TARGET_URL = "https://the-internet.herokuapp.com/dynamic_controls";
    private static final By CHECKBOX_FORM_SEL = By.id( "checkbox-example" );
    private static final By INPUT_FORM_SEL = By.id( "input-example" );
    // private static final By CHECK_INPUT_ELE_SEL =By.tagName( "input" );
    private static final By CHECK_INPUT_ELE_SEL = By.cssSelector( "#checkbox-example input" );
    // private static final By INPUT_ELE_SEL =By.tagName( "input" );
    private static final By INPUT_ELE_SEL = By.cssSelector( "#input-example input" );
    private static final By BTN_ELE_SEL = By.tagName( "button" );


    public static void main(String[] args) {

        WebDriver driver = DriverFactory.getWebDriver();
        driver.get( TARGET_URL );
        WebDriverWait wait = new WebDriverWait( driver, Duration.ofSeconds( 10 ) );

        try {
            // locate 2 parents
            WebElement checkboxFormEl = driver.findElement( CHECKBOX_FORM_SEL );
            WebElement inputFormEl = driver.findElement( INPUT_FORM_SEL );
            // checkbox form interaction
            WebElement checkboxInputEl = checkboxFormEl.findElement( CHECK_INPUT_ELE_SEL );
            WebElement removeBtnEl = checkboxFormEl.findElement( BTN_ELE_SEL );
            System.out.println( "BEFORE | is element selected:" + checkboxInputEl.isSelected() );
            checkboxInputEl.click();
            System.out.println( "AFTER | is element selected:" + checkboxInputEl.isSelected() );
            removeBtnEl.click();
            // web driver wait will break narrow down searching
            wait.until( ExpectedConditions.invisibilityOfElementLocated( CHECK_INPUT_ELE_SEL ) );

            // input form interaction
            WebElement enableBtn = inputFormEl.findElement( BTN_ELE_SEL );
            WebElement inputFieldEl = inputFormEl.findElement( INPUT_ELE_SEL );
            System.out.println( "\n \n BEFORE | is element enable:" + inputFieldEl.isEnabled() );

            enableBtn.click();
            wait.until( new ExplicitWaitForEnable( INPUT_ELE_SEL ) );

            System.out.println( "\n \n AFTER | is element enable:" + inputFieldEl.isEnabled() );

            inputFieldEl.sendKeys( "Something...." );
            Thread.sleep( 2000 );


        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            driver.quit();
        }
    }
}
