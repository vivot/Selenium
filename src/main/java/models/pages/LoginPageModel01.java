package models.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageModel01 {
    private final WebDriver driver;
    private static final By USERNAME_SEL = By.id( "Email" );
    private static final By PASSWORD_SEL = By.id( "Password" );
    private static final By LOGIN_BTN_SEL = By.cssSelector( "submit" );

    public LoginPageModel01(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement username() {
        return driver.findElement( USERNAME_SEL );
    }

    public WebElement password() {
        return driver.findElement( PASSWORD_SEL );
    }

    public WebElement loginBtn() {
        return driver.findElement( LOGIN_BTN_SEL );
    }


}
