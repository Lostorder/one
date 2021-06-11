package com.fengzhuang;

import driver.SeleniumDrivers;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class day {
    @Test
    public void test(){
        WebDriver driver = SeleniumDrivers.openBrower("chrome");
    }
}
