package tests;

import driver.DriverFactory;
import models.pages.LoginPageModel03;
import org.openqa.selenium.WebDriver;

public class POMModel03Tests {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getWebDriver();
        LoginPageModel03 loginPage = new LoginPageModel03( driver );
        // chaining method
        loginPage
                .inputUsername( "username" )
                .inputPassword( "password" )
                .clickLoginBtn();


    }
}
