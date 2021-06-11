package tools;

import logger.LoggerControler;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.lang.reflect.Array;

import static org.testng.internal.EclipseInterface.*;


public class MyAssert {

    static final LoggerControler logger = LoggerControler.getLogger(MyAssert.class);
    //断言字符串是否以某个字符开头,待断言的字符串sj,预期结果yq，断言错误信息cw
    public static void asserts(String sj,String yq,String cw){
        if (cw!=null){
            logger.info(cw);
        }
        if (sj.startsWith(yq)){
            logger.info("前缀匹配，调用成功");
        }else {
            logger.severe("前缀匹配失败！");
            ScreenShot.screenShots();
        }
    }


    //预期结果和实际结果是否相同
    public static void assertEquals(Object actual,Object expected,String message){
        //判断数组和字符串
        if (expected!=null&&expected.getClass().isArray()){
            assertArrayEquals(actual,expected,message);
            return;
        }
        assertEqualsStringObject(actual,expected,message);
    }
    public static void assertArrayEquals(Object actual,Object expected,String message){
        if (actual==expected){
            return;
        }
        if (actual==null){
            fault(message);
        }
        if (expected==null){
            fault(message);
        }
        if (actual.getClass().isArray()){
            int expectedLength = Array.getLength(expected);
            if (expectedLength==Array.getLength(actual)){
                for (int i = 0; i < expectedLength; i++) {
                    Object a_item = Array.get(actual,i);
                    Object e_item = Array.get(expected,i);
                    try {
                        assertEquals(actual,expected,message);
                    }catch(AssertionError e){
                        faultNullEquals(actual,expected,message);
                    }
                }
            }else {
                faultNullEquals(actual,expected,message);
            }
        }
        faultNullEquals(actual,expected,message);
    }

    //判断实际结果和预期结果是字符串
    public static void assertEqualsStringObject(Object actual,Object expected,String message){
        if ((actual==null)&&(expected==null)){
            return;
        }
        if (actual==null^expected==null){
            faultNullEquals(actual,expected,message);
        }
        if (actual==expected) {
            return;
        }
        faultNullEquals(actual,expected,message);
    }


    public static void faultNullEquals(Object actual,Object expected,String message){
        String me = format(actual,expected,message);
        fault(me);
    }

    //格式化错误信息
    public static String format(Object actual,Object expected,String message){
        //[actual but found expected]
        String foundtitd = "";

        if (message!=null){
            foundtitd=message+" ";
        }
        return foundtitd+ASSERT_LEFT+expected+ASSERT_MIDDLE+ASSERT_RIGHT;
    }

    public static void fault(String message){
        ScreenShot.screenShots();
        throw new AssertionError(message);
    }

}
