package models.components;

import org.openqa.selenium.WebDriver;

@ComponentCSSSelector(value = ".footer")
public class FooterComponent {
    // SELECTOR
    // METHOD
    private final WebDriver driver;

    public FooterComponent(WebDriver driver) {
        this.driver = driver;
    }

    public void doSomething() {
    }
}
