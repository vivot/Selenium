package tests;

import driver.DriverFactory;
import models.components.global.footer.CustomerServiceColumnComponent;
import models.components.global.footer.FooterColumnComponent;
import models.components.global.footer.FooterComponent;
import models.components.global.footer.InformationColumnComponent;
import models.components.product.ProductItemComponent;
import models.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductComponentTest {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getWebDriver();
        driver.get( "https://demowebshop.tricentis.com/" );
        try {
            HomePage homePage = new HomePage( driver );
            homePage.productItemComponentList().forEach(productItemComponent -> {
                System.out.println(productItemComponent.ProductTitleEle().getText());
            });


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();

        }
    }


}
