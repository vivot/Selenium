package test_flows.global;

import models.components.global.footer.*;
import models.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FooterTestFlow {
    private final WebDriver driver;

    public FooterTestFlow(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyFooterComponent() {
        BasePage basePage = new BasePage(this.driver);
        InformationColumnComponent informationColumnComp = basePage.footerComp().informationColumnComp();
        CustomerServiceColumnComponent customerServiceColumnComp = basePage.footerComp().customerServiceColumnComp();
        MyAccountColumnComponent myAccountColumnComp = basePage.footerComp().myAccountColumnComponent();
        FollowUsColumnComponent followUsColumnComp = basePage.footerComp().followUsColumnComponent();
        verifyInformationColumn(informationColumnComp);
        verifyCustomerServiceColumn(customerServiceColumnComp);
        verifyMyAccountColumn(myAccountColumnComp);
        verifyFollowColumn(followUsColumnComp);
    }

    private void verifyInformationColumn(FooterColumnComponent informationColumComp) {
        testFooterColumn(informationColumComp);
    }

    private void verifyCustomerServiceColumn(FooterColumnComponent customerServiceColumnComp) {
        testFooterColumn(customerServiceColumnComp);

    }

    private void verifyMyAccountColumn(FooterColumnComponent myAccountColumnComp) {
        testFooterColumn(myAccountColumnComp);

    }

    private void verifyFollowColumn(FooterColumnComponent followColumnComp) {
        testFooterColumn(followColumnComp);

    }

    private void testFooterColumn(FooterColumnComponent footerColumnComponent) {
        System.out.println(footerColumnComponent.headerEle().getText());
        for (WebElement linkEle : footerColumnComponent.linkEle()) {

            System.out.println(linkEle.getText() + ": " + linkEle.getAttribute("href"));
            System.out.println("======");
        }
    }
}