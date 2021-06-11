package com.dogshop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class zhuce {
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
    public void login() throws InterruptedException {

        driver.get("http://192.168.159.134:8080/DagShop06/");
        driver.findElement(By.xpath("/html/body/div/div[1]/div[3]/ol/li[1]/a")).click();

        String[] username = {"admin","bb","cc","dd","ee","ff","gg","hh","ii","jj","kk","ll","mm","nn","oo","pp","qq","rr","ss","tt","uu","vv","ww","xx","yy"};
        String[] password = {"123","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25"};

        for (int i = 0; i < 1; i++) {
            Thread.sleep(1000);

            driver.findElement(By.id("username")).sendKeys(username[i]);
            driver.findElement(By.id("inputPassword3")).sendKeys(password[i]);
            driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/form[1]/div[5]/div/input")).click();
            //第二种
            Thread.sleep(2000);
            String text = driver.findElement(By.xpath("/html/body/div/div[1]/div[3]/ol/text()")).getText();
            Assert.assertEquals(text,"你好");


            driver.findElement(By.xpath("/html/body/div/div[1]/div[3]/ol/li[2]/a")).click();
            driver.findElement(By.xpath("/html/body/div/div[1]/div[3]/ol/li[1]/a")).click();
        }

    }
}
