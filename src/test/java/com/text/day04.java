package com.fengzhuang;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//数据驱动
public class day04 {

    //{chrome, www.baidu.com}
    //{ff    , www.baidu.com}
    //{edge  , www.baidu.com}

    //准备数据源
    //数据提供者
    @DataProvider(name="test01")
    public Object[][] data(){
        return new Object[][] {
                {"chrome", "www.baidu.com"},
                {"ff"    , "www.baidu.com"},
                {"edge"  , "www.baidu.com"}
        };

    }

    //测试用例脚本
    @Test(dataProvider = "test01")
    public void testData(String serach_name,String url){
        System.out.println(serach_name +","+url);
    }

}
