package test_flows.global;

import models.components.global.footer.*;
import models.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FooterTestFlow {
    private final WebDriver driver;

    public FooterTestFlow(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyFooterComponent() {
        BasePage basePage = new BasePage( this.driver );
        InformationColumnComponent informationColumnComp = basePage.footerComp().informationColumnComp();
        CustomerServiceColumnComponent customerServiceColumnComp = basePage.footerComp().customerServiceColumnComp();
        MyAccountColumnComponent myAccountColumnComp = basePage.footerComp().myAccountColumnComponent();
        FollowUsColumnComponent followUsColumnComp = basePage.footerComp().followUsColumnComponent();
        verifyInformationColumn( informationColumnComp );
//        verifyCustomerServiceColumn( customerServiceColumnComp );
//        verifyMyAccountColumn( myAccountColumnComp );
//        verifyFollowColumn( followUsColumnComp );
    }

    private void verifyInformationColumn(FooterColumnComponent informationColumComp) {
        List<String> expectedLinkTexts = Arrays.asList( "Sitemap", "Shipping & Returns", "Privacy Notice", "Conditions of Use", "About us", "Contact us" );
        List<String> expectedHrefs = Arrays.asList( "/sitemap", "/shipping-returns", "/privacy-policy", "/conditions-of-use", "/about-us", "/contactus" );
        testFooterColumn( informationColumComp, expectedLinkTexts, expectedHrefs );
    }

    private void verifyCustomerServiceColumn(FooterColumnComponent customerServiceColumnComp) {
        List<String> expectedLinkTexts = new ArrayList<>();
        List<String> expectedHrefs = new ArrayList<>();
        testFooterColumn( customerServiceColumnComp, expectedLinkTexts, expectedHrefs );

    }

    private void verifyMyAccountColumn(FooterColumnComponent myAccountColumnComp) {
        List<String> expectedLinkTexts = new ArrayList<>();
        List<String> expectedHrefs = new ArrayList<>();
        testFooterColumn( myAccountColumnComp, expectedLinkTexts, expectedHrefs );

    }

    private void verifyFollowColumn(FooterColumnComponent followColumnComp) {
        List<String> expectedLinkTexts = new ArrayList<>();
        List<String> expectedHrefs = new ArrayList<>();
        testFooterColumn( followColumnComp, expectedLinkTexts, expectedHrefs );


    }

    private void testFooterColumn(FooterColumnComponent footerColumnComp, List<String> expectedLinkTexts, List<String> expectedHrefs) {
        List<String> actualLinkTexts = new ArrayList<>();
        List<String> actualHrefs = new ArrayList<>();
        expectedHrefs.replaceAll( originalHref -> "https://demowebshop.tricentis.com" + originalHref );

        footerColumnComp.linkEle().forEach( columnItem -> {
            actualLinkTexts.add( columnItem.getText() );
            actualHrefs.add( columnItem.getAttribute( "href" ) );
        } );
        if (actualLinkTexts.isEmpty() || actualHrefs.isEmpty()) {
            Assert.fail( "Footer column texts or Links is empty" );
        }
        Assert.assertEquals( expectedLinkTexts, actualLinkTexts, "[ERR] Footer column link text are different" );
        Assert.assertEquals( expectedHrefs, actualHrefs, "[ERR] Footer column href are different" );

    }

}