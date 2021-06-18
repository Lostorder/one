package com.dogshop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Texttwo {

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

    //@Test
    public void login() throws InterruptedException {

        driver.get("http://192.168.159.134:8080/DagShop06/");
        WebElement element01 = driver.findElement(By.xpath("/html/body/div/div[1]/div[3]/ol/li[2]/a"));
        element01.click();

        Thread.sleep(3000);

        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("admin");
        WebElement inputPassword3 = driver.findElement(By.id("inputPassword3"));
        inputPassword3.sendKeys("123");
        WebElement confirmpwd = driver.findElement(By.id("confirmpwd"));
        confirmpwd.sendKeys("123");
        WebElement element = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/form/div[9]/div/input"));

        Thread.sleep(2000);

        element.click();

        Thread.sleep(2000);

        boolean isExist_reg = false;
        try{
            driver.findElement(By.xpath("//*[contains(.,'" + "恭喜你,注册成功,请登录邮箱完成激活!" + "')]"));
            isExist_reg = true;
        }catch (Exception e){
            isExist_reg = false;
        }

        Assert.assertEquals(isExist_reg,true);

    }

    //@Test
    public void login01() throws InterruptedException {

        driver.get("http://192.168.159.134:8080/DagShop06/");
        WebElement element01 = driver.findElement(By.xpath("/html/body/div/div[1]/div[3]/ol/li[2]/a"));
        element01.click();

        Thread.sleep(3000);

        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("admin");
        WebElement inputPassword3 = driver.findElement(By.id("inputPassword3"));
        inputPassword3.sendKeys("123");
        WebElement confirmpwd = driver.findElement(By.id("confirmpwd"));
        confirmpwd.sendKeys("123");
        WebElement element = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/form/div[9]/div/input"));

        Thread.sleep(2000);

        element.click();

        Thread.sleep(2000);

        String text = driver.findElement(By.xpath("/html/body/div[1]/div[3]/h3")).getText();
        Assert.assertEquals(text,"恭喜你,注册成功,请登录邮箱完成激活!");

    }

   // @Test
    public void login02() throws InterruptedException {

        driver.get("http://192.168.159.134:8080/DagShop06/");
        WebElement element01 = driver.findElement(By.xpath("/html/body/div/div[1]/div[3]/ol/li[2]/a"));
        element01.click();

        Thread.sleep(3000);

        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("admin");
        WebElement inputPassword3 = driver.findElement(By.id("inputPassword3"));
        inputPassword3.sendKeys("123");
        WebElement confirmpwd = driver.findElement(By.id("confirmpwd"));
        confirmpwd.sendKeys("123");
        WebElement element = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/form/div[9]/div/input"));

        Thread.sleep(2000);

        element.click();

        Thread.sleep(2000);

        boolean displayed = driver.findElement(By.xpath("/html/body/div[1]/div[3]/h3")).isDisplayed();
        System.out.println(displayed);
        Assert.assertEquals(displayed,true);

    }
}
