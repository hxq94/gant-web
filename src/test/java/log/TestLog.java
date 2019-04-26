package log;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TestLog {

    private final Logger logger = LoggerFactory.getLogger(TestLog.class);

    private final Logger slowLogger = LoggerFactory.getLogger("slow-request-log");
    private final Logger responseLogger = LoggerFactory.getLogger("response-data-log");


    @Test
    public void TestLog() {

        logger.info("普通日志");
        logger.debug("task日志");
        logger.error("错误日志");
        logger.warn("警告日志");
        slowLogger.info("慢请求日志");
        responseLogger.debug("请求返回日志");


    }
}
