package hello14.日志;

import org.apache.log4j.Logger;

public class T08 {
    public static void main(String[] args) {
        Logger logger=Logger.getLogger(T08.class);//类名+class
        logger.error("这是错误信息的记录");
    }
}
