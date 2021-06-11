package action;

import element.WebElementUtils;
import logger.LoggerControler;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Action {

    final static LoggerControler log= LoggerControler.getLogger(Action.class);
    public static void click(By by, String text){
        WebElementUtils.findElement(by).click();
        log.info("点击："+by);
    }
    public static void sendkey(By by,String text){
        WebElementUtils.findElement(by).sendKeys(text);
        log.info("在"+by+"输入"+text);
    }
    public static String getText(By by){
        String text= WebElementUtils.findElement(by).getText();
        return text;
    }
//    public static ArrayList getTexts(By by){
//        ArrayList arryList=new ArrayList();
//        List<WebElement> webElement=WebElementUtils.findElements(by);
//        for(int j=0;j<webElement.size();j++){
//            String text=webElement.get(j).getText();
//            arryList.add(text);
//
//        }
//        return arryList;
//    }


}
