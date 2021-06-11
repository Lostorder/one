package com.yongli;

import action.Action;
import com.goudan.logpaje;
import driver.SeleniumDrivers;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tools.ScreenShot;

public class Textdenglu {
    @DataProvider(name = "driver")
    public Object[][] data(){
            return new Object[][]{
            {"chrome"},{"firefox"}
        };
    }
    //等一个登录脚本
    @Test(dataProvider = "driver")
    public void longText(String dr) throws Exception {
        WebDriver driver = SeleniumDrivers.openBrower(dr);
        driver.get("http://192.168.159.134:8080/DagShop06/user?method=loginUI");
        Action.sendkey(logpaje.username,"admin");
        Action.sendkey(logpaje.password,"123");
        Action.click(logpaje.submit,"登录");
        SeleniumDrivers.close();
    }
}
