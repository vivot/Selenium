package test_flows.computer;

import models.order.CheapComputerComponent;
import models.order.ComputerEssentialComponent;
import models.pages.ComputerItemDetailPage;
import org.openqa.selenium.WebDriver;

public class OrderComputerFlow <T extends ComputerEssentialComponent> {
    private final WebDriver driver;
    private final Class<T> computerEssentialCompClass;

    public OrderComputerFlow(WebDriver driver, Class<T> computerEssentialCompClass ) {
       this.computerEssentialCompClass=computerEssentialCompClass;
        this.driver = driver;
    }

    public void buildCompSpecAndAddToCard() {
        //Other steps

        ComputerEssentialComponent computerEssentialComp =new ComputerItemDetailPage(driver).computerComp(computerEssentialCompClass);


        computerEssentialComp.selectProcessorType("processor");
        computerEssentialComp.selectRAMType("RAM");
        // The rest steps
    }
}
