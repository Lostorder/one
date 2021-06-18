package com.text;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class two {
    WebDriver driver;

    @BeforeMethod
    public void open(){
        System.setProperty("webdriver.chrome.driver","D:\\driver\\chromedriver.exe");

        driver = new ChromeDriver();
    }

    @AfterMethod
    public void close() throws Exception {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void select() throws InterruptedException {
        driver.get("https://www.baidu.com");
        WebElement element01 = driver.findElement(By.xpath("//*[@id='kw']"));
        element01.sendKeys("零一");
        WebElement element02 = driver.findElement(By.id("su"));
        element02.click();

        Thread.sleep(3000);

        /*WebElement element03 = driver.findElement(By.xpath("//*[@id='1']/h3/a"));
        element03.click();

        Thread.sleep(3000);*/

        String title = driver.getTitle();
        Assert.assertEquals(title,"零一_百度搜索");


    }
}
