package tests.global.footer;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import test_flows.global.FooterTestFlow;

public class TestOrder {
    @Test (dependsOnMethods = {"testA"})
    public void testB(){
        System.out.println("Test B");

    }
    @Test (priority = 1)
    public void testA(){
        System.out.println("Test A");

    }

}
