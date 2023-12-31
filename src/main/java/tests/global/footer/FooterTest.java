package tests.global.footer;

import org.testng.Assert;
import org.testng.annotations.Test;
import test_flows.global.FooterTestFlow;
import tests.BaseTest;

public class FooterTest extends BaseTest {

    @Test
    public void testHomepageFooter() {
        driver.get( "https://demowebshop.tricentis.com/" );
        FooterTestFlow footerTestFlow = new FooterTestFlow( driver );
        footerTestFlow.verifyFooterComponent();


    }

}
