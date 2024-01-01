package support.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.List;

public class ExpectedConditionEx {
    public static ExpectedCondition<List<WebElement>> presenceofalllelementslocatedby(final WebElement parentComponent, final By locator) {
        return new ExpectedCondition<List<WebElement>>() {
            @Override
            public List<WebElement> apply(WebDriver driver) {
                List<WebElement> elements = driver.findElements(locator);
                return elements.size() > 0 ? elements : null;
            }

            public String toString() {
                return "presence of any elements located by" + locator;
            }
        };

        }

}
