package models.pages;

import models.components.Component;
import models.order.ComputerEssentialComponent;
import org.openqa.selenium.WebDriver;

public class ComputerItemDetailPage extends BasePage {
    public ComputerItemDetailPage(WebDriver driver) {
        super(driver);


    }

    public <T extends ComputerEssentialComponent>T computerComp(Class<T> compEssentialCompClass){
        return findComponent(compEssentialCompClass);
    }


}
