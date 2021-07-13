package Unrelated;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerTutorial {
    private static Logger logger = LogManager.getLogger("HelloLog4j");

    public static void main(String[] args) {
        String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        System.out.println(path);
        LoggerTutorial loggerTutorial = new LoggerTutorial();

        logger.entry();
        loggerTutorial.doIt();
        logger.info("Hello, World!");
        logger.trace("trace");
        logger.error("Hello, World!");
        logger.exit();
    }

    private void doIt() {
        System.out.println("woshizhu");
    }

}
