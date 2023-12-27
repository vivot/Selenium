package models.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.Constructor;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Component {
    protected WebDriver driver;
    protected WebElement component;
    protected WebDriverWait wait;

    public Component(WebDriver driver, WebElement component) {
        this.driver = driver;
        this.component = component;
        this.wait =new WebDriverWait( this.driver, Duration.ofSeconds( 15 ) );
    }
    // Narrow down searching
    public WebElement findElement(By by) {
        return this.component.findElement( by );
    }
    public List<WebElement> findElements(By by)
    {
        return this.component.findElements(by);
    }
    public <T extends Component> T findComponent(Class<T> componentClass){
        return this.findComponents(componentClass).get(0);
    }
    public <T extends Component> List<T> findComponents(Class<T> componentClass)
    {
        By componentSelector;
        try{
        componentSelector=this.getComponentSelector( componentClass );
        }catch (Exception e)
        {
            throw new IllegalArgumentException("[ERR] The component must have annotation for: CSSSelector, ID...");
        }
        List<WebElement> results=wait.until( ExpectedConditions.presenceOfAllElementsLocatedBy(componentSelector ));
        //Define Component Constructor
        Class<?>[] params=new Class[]{WebDriverWait.class, WebElement.class};
        Constructor<T>constructor;
        try{
            constructor =componentClass.getConstructor( params );
        }catch (Exception e){
            throw new IllegalArgumentException("[ERR] The component MUST have a constructor with param: "+ Arrays.toString( params ) );
        }
        // Convert List WebElement into List Component
        List<T> components=results.stream().map(webElement -> {
           try {
               return constructor.newInstance( driver,webElement );
           }catch (Exception e) {
               e.printStackTrace();
           }
            return null;
        }).collect( Collectors.toList() );
        return components;
    }
    private By getComponentSelector(Class<? extends Component> componentClass){
        if(componentClass.isAnnotationPresent( ComponentCSSSelector.class )){
            return By.cssSelector( componentClass.getAnnotation( ComponentCSSSelector.class ).value() );
        }
        else if(componentClass.isAnnotationPresent( ComponentIDSelector.class )){
            return By.id( componentClass.getAnnotation(ComponentIDSelector.class).value());

        }else {
            throw new IllegalArgumentException("Component class"+componentClass+"must have annotation!");
        }
    }

}
