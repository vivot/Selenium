package test_flows.global;

import models.components.global.footer.*;
import models.components.global.header.CategoryItemComponent;
import models.pages.BasePage;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
//        verifyFollowColumn( followUsColumnComp );
    }

    public void verifyProductCatFooterComponent() {
        //Randomly pick up MainItem from TopComponent
        BasePage basePage = new BasePage(this.driver);

        List<CategoryItemComponent> categoryItemComps = basePage.catItemComp();
        Assert.assertFalse(categoryItemComps.isEmpty(), "[ERR] There is no item on top menu");
        int randomCategoryComponentIndex=new SecureRandom().nextInt(categoryItemComps.size());

        CategoryItemComponent randomCategoryItem = categoryItemComps.get(new SecureRandom().nextInt(categoryItemComps.size()));
        String randomCatHref = randomCategoryItem.catItemLink().getAttribute("href");

        // Get sublist (if any) then click on random sub-item / MainItem (If has no sublist)
        List<WebElement> sublistItems = randomCategoryItem.subListItems();
        if (sublistItems.isEmpty()) {
            randomCategoryItem.catItemLink().click();
        } else {
            int randomSubItemIndex = new SecureRandom().nextInt(sublistItems.size());
            WebElement randomSubItemComp = sublistItems.get(randomSubItemIndex);
            randomCatHref=randomSubItemComp.getAttribute("href");
            randomSubItemComp.click();

        }
        // Make sure we are on the right page / wait until navigation done
        try {
            WebDriverWait wait = randomCategoryItem.componentWait();
            wait.until(ExpectedConditions.urlContains(randomCatHref));
        } catch (TimeoutException ignored) {
            Assert.fail("[ERR] Target page does not match");
        }

        // Randomly pickup MainItem from TopMenuComponent
        verifyFooterComponent();
    }

    private void verifyInformationColumn(FooterColumnComponent informationColumComp) {
        List<String> expectedLinkTexts = Arrays.asList("Sitemap", "Shipping & Returns", "Privacy Notice", "Conditions of Use", "About us", "Contact us");
        List<String> expectedHrefs = Arrays.asList("/sitemap", "/shipping-returns", "/privacy-policy", "/conditions-of-use", "/about-us", "/contactus");
        testFooterColumn(informationColumComp, expectedLinkTexts, expectedHrefs);
    }

    private void verifyCustomerServiceColumn(FooterColumnComponent customerServiceColumnComp) {
        List<String> expectedLinkTexts = Arrays.asList("Search", "News", "Blog", "Recently viewed products", "Compare products list", "New products");
        List<String> expectedHrefs = Arrays.asList("/search", "/news", "/blog", "/recentlyviewedproducts", "/compareproducts", "/newproducts");
        testFooterColumn(customerServiceColumnComp, expectedLinkTexts, expectedHrefs);

    }

    private void verifyMyAccountColumn(FooterColumnComponent myAccountColumnComp) {
        List<String> expectedLinkTexts = Arrays.asList("My account", "Orders", "Addresses", "Shopping cart", "Wishlist");

        List<String> expectedHrefs = Arrays.asList("/customer/info", "/customer/orders", "/customer/addresses", "/cart", "/wishlist");
        testFooterColumn(myAccountColumnComp, expectedLinkTexts, expectedHrefs);

    }

    private void verifyFollowColumn(FooterColumnComponent followColumnComp) {
        List<String> expectedLinkTexts = Arrays.asList("Facebook", "Twitter", "RSS", "YouTube", "Google+");
        List<String> expectedHrefs = Arrays.asList("http://www.facebook.com/nopCommerce", "https://twitter.com/nopCommerchttps://plus.google.com/+nopcommercee", "https://demowebshop.tricentis.com/news/rss/1", "http://www.youtube.com/user/nopCommerce", "https://plus.google.com/+nopcommerce");
        testFooterColumn(followColumnComp, expectedLinkTexts, expectedHrefs);

    }

    private void testFooterColumn(FooterColumnComponent footerColumnComp, List<String> expectedLinkTexts, List<String> expectedHrefs) {
        List<String> actualLinkTexts = new ArrayList<>();
        List<String> actualHrefs = new ArrayList<>();
        expectedHrefs.replaceAll(originalHref -> "https://demowebshop.tricentis.com" + originalHref);

        footerColumnComp.linkEle().forEach(columnItem -> {
            actualLinkTexts.add(columnItem.getText());
            actualHrefs.add(columnItem.getAttribute("href"));
        });
        if (actualLinkTexts.isEmpty() || actualHrefs.isEmpty()) {
            Assert.fail("Footer column texts or Links is empty");
        }
        Assert.assertEquals(expectedLinkTexts, actualLinkTexts, "[ERR] Footer column link text are different");
        Assert.assertEquals(expectedHrefs, actualHrefs, "[ERR] Footer column href are different");

    }

}