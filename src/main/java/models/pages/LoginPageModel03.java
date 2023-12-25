package models.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageModel03 {
    private final WebDriver driver;
    private static final By USERNAME_SEL = By.id( "Email" );
    private static final By PASSWORD_SEL = By.id( "Password" );
    private static final By LOGIN_BTN_SEL = By.cssSelector( "submit" );

    public LoginPageModel03(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPageModel03 inputUsername(String username) {
        driver.findElement( USERNAME_SEL ).sendKeys( "Teo@sth.com" );
        return this;
    }

    public LoginPageModel03 inputPassword(String password) {
        driver.findElement( PASSWORD_SEL ).sendKeys( "12345678" );
        return this;

    }

    public void  clickLoginBtn() {
        driver.findElement( LOGIN_BTN_SEL ).click();


    }

}
