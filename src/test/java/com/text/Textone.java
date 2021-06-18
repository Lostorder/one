package com.dogshop;


import org.testng.Assert;
import org.testng.annotations.*;

public class Textone {


    @Test
    public void testa(){
        System.out.println("登录");
        String content = "j";
        Assert.assertEquals(content,"j");
    }

    @Test
    public void testb(){
        System.out.println("注册");
    }

    @BeforeMethod
    public void teste(){
        System.out.println("打开浏览器");
    }

    @AfterMethod
    public void testf(){
        System.out.println("关闭浏览器");
    }

    @BeforeTest
    public void testc(){
        System.out.println("开始前准备");
    }

    @AfterTest
    public void testd(){
        System.out.println("结束后准备");
    }

}
