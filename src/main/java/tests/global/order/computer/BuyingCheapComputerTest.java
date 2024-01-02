package tests.global.order.computer;

import models.order.CheapComputerComponent;
import org.testng.annotations.Test;
import test_flows.computer.OrderComputerFlow;
import tests.BaseTest;

public class BuyingCheapComputerTest extends BaseTest {
    @Test
    public void testCheapComputerBuying() {
        driver.get("https://demowebshop.tricentis.com/build-your-cheap-own-computer");
        OrderComputerFlow orderComputerFlow = new OrderComputerFlow(driver, CheapComputerComponent.class);
        orderComputerFlow.buildCompSpecAndAddToCard();
    }
}
