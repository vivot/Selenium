package tests;

import models.pages.BasePage;
import org.openqa.selenium.WebDriver;
import selenium.driver.DriverFactory;

public class POMModel04Tests {


    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getWebDriver();
        BasePage homePage = new BasePage( driver );
        // homePage.footerComponent().doSomething();
    }
}
