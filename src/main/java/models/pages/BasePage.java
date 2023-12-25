package models.pages;

import models.components.FooterComponent;
import org.openqa.selenium.WebDriver;

public class BasePage {
    private final WebDriver driver;

    public BasePage(WebDriver driver)
    {
        this.driver=driver;
    }
    // SELECTORS
    // METHODS
    // SERVICE METHOD - RETURN NEW FOOTER COMPONENT
    public FooterComponent footerComponent()
    {
        return new FooterComponent(this.driver);
    }
}
