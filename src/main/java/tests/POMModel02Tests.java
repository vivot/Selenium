package tests;

import driver.DriverFactory;
import models.pages.LoginPageModel02;
import org.openqa.selenium.WebDriver;

public class POMModel02Tests {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getWebDriver();
        LoginPageModel02 loginPage = new LoginPageModel02( driver );
        loginPage.inputUsername( "username" );
        loginPage.inputPassword( "password" );
        loginPage.clickLoginBtn();


    }
}
