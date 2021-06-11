package com.fengzhuang;

import org.openqa.selenium.By;

public class SearchPage {
    //PO思想实现，当页面元素id或者位置发生变化时，只改这一个地方即可。别的地方调用直接是LoginPage.loginName即可
    public static By loginName=By.id("kw");
    public static By loginBtn= By.id("su");
}
