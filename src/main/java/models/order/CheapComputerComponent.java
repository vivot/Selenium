package models.order;

import models.components.ComponentCSSSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
@ComponentCSSSelector(".product-essential")
public class CheapComputerComponent extends ComputerEssentialComponent {
    public CheapComputerComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    @Override
    public String selectProcessorType(String type) {
        System.out.println("select Processor Type CHEAP");
        return null;
    }

    @Override
    public String selectRAMType(String type) {
        System.out.println("select  RAM");
        return null;
    }
}
