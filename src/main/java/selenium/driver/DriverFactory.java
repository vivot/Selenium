package selenium.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DriverFactory {
    // support method class

    public static WebDriver getWebDriver() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait( Duration.ofSeconds( 15L ));
        return driver;
    }
}
