package element;

import driver.SeleniumDrivers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebElementUtils extends SeleniumDrivers {

    public static WebElement findElement(final By by){
        WebElement webElement=null;
        try {
            webElement=new WebDriverWait(driver,10).until(new ExpectedCondition<WebElement>() {
                public WebElement apply(WebDriver driver) {
                    return driver.findElement(by);
                }
            });
        }catch (Exception e){
            System.out.print("元素"+by+"没找着");
            e.printStackTrace();
        }
        return webElement;
    }
}
