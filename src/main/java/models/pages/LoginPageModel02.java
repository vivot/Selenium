package models.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageModel02 {
    private final WebDriver driver;
    private static final By USERNAME_SEL = By.id( "Email" );
    private static final By PASSWORD_SEL = By.id( "Password" );
    private static final By LOGIN_BTN_SEL = By.cssSelector( "submit" );

    public LoginPageModel02(WebDriver driver) {
        this.driver = driver;
    }

    public void inputUsername(String username) {
        driver.findElement( USERNAME_SEL ).sendKeys( "Teo@sth.com" );
    }

    public void inputPassword(String password) {
        driver.findElement( PASSWORD_SEL ).sendKeys( "12345678" );
    }

    public void clickLoginBtn() {
        driver.findElement( LOGIN_BTN_SEL ).click();
    }


}
