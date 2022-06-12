package LoggerService;

public class LoggerMain {

    public static void main(String[] args) {
        AbstractLogger logger = getChainOfLogger();

        logger.logMessage(AbstractLogger.INFO, "This is just Info Message");
        logger.logMessage(AbstractLogger.DEBUG, "This is Debug Message");
        logger.logMessage(AbstractLogger.ERROR, "This is Error Message");

    }

    public static AbstractLogger getChainOfLogger() {
        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
        AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);

        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);
        return errorLogger;
    }
}
