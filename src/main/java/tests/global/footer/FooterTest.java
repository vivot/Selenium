package tests.global.footer;

import org.testng.annotations.Test;
import test_flows.global.FooterTestFlow;
import tests.BaseTest;

public class FooterTest extends BaseTest {

    // @Test
//    public void testHomepageFooter() {
//        driver.get("https://demowebshop.tricentis.com/");
//        FooterTestFlow footerTestFlow = new FooterTestFlow(driver);
//        footerTestFlow.verifyFooterComponent();


    //}
    @Test
    public void testCategoryPageFooter() {
        driver.get("https://demowebshop.tricentis.com/");
        FooterTestFlow footerTestFlow = new FooterTestFlow(driver);
        footerTestFlow.verifyProductCatFooterComponent();
    }

}
