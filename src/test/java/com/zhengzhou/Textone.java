package com.zhengzhou;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Textone {

    WebDriver driver;

    @BeforeMethod
    public void onpen(){
        System.setProperty("webdriver.chrome.driver","D:\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @AfterMethod
    public void close() throws Exception {
        Thread.sleep(3000);
        driver.quit();
    }
    @Test
    public void register() throws InterruptedException {
        //登录页面
        driver.get("http://localhost:81/general/ERP/LOGIN/");

        driver.findElement(By.id("username")).sendKeys("admin");

        driver.findElement(By.xpath("//*[@id=\"loginForm\"]/table/tbody/tr/td[3]/table[4]/tbody/tr[1]/td[1]/input")).click();

        Thread.sleep(1500);
        //左侧导航栏
        WebElement element = driver.findElement(By.xpath("//*[@id=\"frame2\"]/frame[2]"));
        driver.switchTo().frame(element);

        WebElement element1 = driver.findElement(By.xpath("//*[@id=\"frame1\"]/frame[2]"));
        driver.switchTo().frame(element1);

        driver.findElement(By.xpath("/html/body/table[7]/tbody/tr/td[3]/a")).click();

        driver.findElement(By.xpath("//*[@id=\"MENU_66d\"]/tbody/tr/td/table[1]/tbody/tr/td[4]/a")).click();

        driver.switchTo().defaultContent();

        Thread.sleep(1500);
        //右侧面板
        WebElement element4 = driver.findElement(By.xpath("//*[@id=\"frame2\"]/frame[5]"));
        driver.switchTo().frame(element4);

        WebElement element5 = driver.findElement(By.xpath("//*[@id=\"table_main\"]"));
        driver.switchTo().frame(element5);

        driver.findElement(By.xpath("//*[@id=\"table\"]/thead[1]/tr/td/table/thead/tr/td[1]/input[1]")).click();

        Thread.sleep(1500);

        driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr[4]/td[2]/input")).sendKeys("\u5706\u901A");
        //下拉列表
        WebElement ele2 = driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr[5]/td[2]/select"));

        Thread.sleep(500);
        Select select = new Select(ele2);
        select.selectByValue("9");

        driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr[6]/td[2]/p/input[1]")).click();

        driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr[7]/td[2]/input")).sendKeys("深圳");

        driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr[8]/td[2]/input")).sendKeys("123123");

        driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr[9]/td[2]/input")).sendKeys("233333");

        driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr[10]/td[2]/input")).sendKeys("123321");

        driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr[11]/td[2]/input")).sendKeys("www.aa.com");

        driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr[12]/td[2]/input")).sendKeys("工商");

        driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr[13]/td[2]/input")).sendKeys("10086");

        driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr[14]/td[2]/a[1]")).click();
        //二级页面选择
        String windowHandle = driver.getWindowHandle();
        driver.switchTo().window(windowHandle);
        Thread.sleep(1000);

        for (String handles : driver.getWindowHandles()){
            if (handles.equals(windowHandle)){
                continue;
            }
            driver.switchTo().window(handles);
        }

        WebElement ele12 = driver.findElement(By.xpath("//*[@id=\"bottom\"]/frameset/frame[2]"));
        driver.switchTo().frame(ele12);

        driver.findElement(By.xpath("//*[@id=\"admin\"]")).click();
        //返回一级页面
        driver.switchTo().window(windowHandle);
        //
        WebElement element14 = driver.findElement(By.xpath("//*[@id=\"frame2\"]/frame[5]"));
        driver.switchTo().frame(element14);

        WebElement element15 = driver.findElement(By.xpath("//*[@id=\"table_main\"]"));
        driver.switchTo().frame(element15);

        driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr[15]/td[2]/textarea")).sendKeys("呵呵");

        driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr[16]/td[2]/input")).sendKeys("全国");

        driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr[17]/td/div/input[1]")).click();
        //校验
        /*//第一种
        Thread.sleep(2000);
        boolean isExist_reg = false;
        try{
            driver.findElement(By.xpath("//*[contains(.,'" + "圆通" + "')]"));
            isExist_reg = true;
        }catch (Exception e){
            isExist_reg = false;
        }
        Assert.assertEquals(isExist_reg,true);*/

        /*//第二种
        Thread.sleep(2000);
        String text = driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr[1]/td[2]")).getText();
        Assert.assertEquals(text,"圆通");*/

        //第三种
        Thread.sleep(2000);
        boolean displayed = driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr[1]/td[2]")).isDisplayed();
        System.out.println(displayed);
        Assert.assertEquals(displayed,true);

    }
}
