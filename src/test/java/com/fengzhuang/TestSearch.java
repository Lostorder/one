package com.fengzhuang;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class TestSearch {

    @DataProvider(name="test02")
    public Object[][] data(){
        return new Object[][]{
                {"http://192.168.0.151:8889","chrome"},
                {"http://192.168.0.151:8889","firefox"}
        };
    }

    //@Test(dataProvider = "test02")
    public void testData(String url,String brower) throws InterruptedException, MalformedURLException {

        DesiredCapabilities dc;

//        DesiredCapabilities dc = DesiredCapabilities.chrome(); 操作谷歌浏览器
//        DesiredCapabilities dc = DesiredCapabilities.firefox(); 操作火狐浏览器
//        DesiredCapabilities dc = DesiredCapabilities.edge();

        if("chrome".equals(brower)){
            dc = DesiredCapabilities.chrome();
        }else if("firefox".equals(brower)){
            dc = DesiredCapabilities.firefox();
            Thread.sleep(3000);
        }else{
            System.out.println("不认识的浏览器");
            dc = null;
        }

        WebDriver driver = new RemoteWebDriver(new URL(url+"/wd/hub"),dc);
        Thread.sleep(3000);
        driver.get("http://www.baidu.com");
        Thread.sleep(3000);
        driver.quit();

    }

}
