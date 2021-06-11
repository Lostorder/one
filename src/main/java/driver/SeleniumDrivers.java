package driver;

import logger.LoggerControler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumDrivers {

    public static WebDriver driver;
    final static LoggerControler log= LoggerControler.getLogger(SeleniumDrivers.class);

    public static WebDriver openBrower(String browser){
        if (browser.equals("chrome")){
            System.setProperty("webdriver.chrome.driver","D:\\driver\\chromedriver.exe");
            driver = new ChromeDriver();
            log.info("你打开了"+browser+"浏览器");
        }else if (browser.equals("firefox")){
            //System.setProperty("webdriver.firefox.bin","C:\\Program Files\\Mozilla Firefox\\firefox.exe");
            System.setProperty("webdriver.gecko.driver","D:\\driver\\geckodriver.exe");
            driver = new FirefoxDriver();
            log.info("你打开了"+browser+"浏览器");
        }else {
            log.severe("你输入的"+browser+"浏览器不支持打开");
        }
        return driver;
    }
    public static void close() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }



}
