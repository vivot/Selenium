package models.pages;

import models.components.Component;
import models.components.global.footer.FooterComponent;
import models.components.global.header.TopMenuComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage extends Component {
    protected final WebDriver driver;

    public BasePage(WebDriver driver) {
        super(driver, driver.findElement(By.tagName("html")));
        this.driver = driver;
    }

    // SELECTORS
    // METHODS
    // SERVICE METHOD - RETURN NEW FOOTER COMPONENT
    public FooterComponent footerComp() {

        return findComponent(FooterComponent.class);
    }

    public TopMenuComponent topMenuComp() {
        return findComponent(TopMenuComponent.class);
    }
}

