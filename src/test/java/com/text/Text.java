package com.text;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URL;

public class Text {
    @DataProvider(name = "test01")
    public Object[][] data(){
        return new Object[][]{
                {"chrome","www.baidu.com"},
                {"ff"    ,"www.baidu.com"},
                {"edge"  ,"www.baidu.com"}
        };
    }

    @Test(dataProvider = "test01")
    public void testData(String serach_name,String url){
        System.out.println(serach_name + "," + url);
    }

    //------------------------------------------------------------------------------------------------------------------------

    @DataProvider(name = "test02")
    public Object[][] date(){
        return new Object[][]{
                {"http://192.168.220.1:8887","firefox"},
                {"http://192.168.220.1:8887","chrome"}
        };
    }

    @Test(dataProvider = "test02")
    public void date(String url,String browser) throws Exception {
        DesiredCapabilities desiredCapabilities;
        if (browser.equals("chrome")){
            desiredCapabilities = new DesiredCapabilities().chrome();
        }else if (browser.equals("firefox")){
            desiredCapabilities = new DesiredCapabilities().firefox();
        }else {
            System.out.println("错误");
            desiredCapabilities = null;
        }
        WebDriver driver = new RemoteWebDriver(new URL(url+"/wd/hub"),desiredCapabilities);
        Thread.sleep(2000);
        driver.get("http://www.baidu.com");
        Thread.sleep(2000);
        driver.quit();
    }

    //----------------------------------------------------------------------------------------------------------------------


    WebDriver driver;

    @BeforeMethod
    public void onpenfirefox() throws IOException {
        System.setProperty("webdriver.gecko.driver","D:\\driver\\geckodriver.exe");
        driver = new FirefoxDriver();
    }
    @AfterMethod
    public void close() throws Exception {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void text(){
        driver.get("www.baidu.com");
    }

}
