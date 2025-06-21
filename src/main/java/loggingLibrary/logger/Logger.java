package loggingLibrary.logger;

import loggingLibrary.appender.Appender;

import java.util.*;

public class Logger{

    LoggerLevel level;
    String name;
    List<Appender> appenders = new ArrayList<>();

    public Logger(LoggerLevel level, String name) {
        this.level = level;
        this.name= name;
    }

   public void logMessage(LoggerLevel level, String message) {
        if(this.level.ordinal()<= level.ordinal()) {
            for(Appender appender: appenders) {
                appender.append(formatMessage(message, level));
            }
        }
   }

    public void debug(String message) {
        logMessage(LoggerLevel.DEBUG, message);
    }

    public void info(String message) {
        logMessage(LoggerLevel.INFO, message);
    }

    public void warn(String message) {
        logMessage(LoggerLevel.WARN, message);
    }

    public void error(String message) {
        logMessage(LoggerLevel.ERROR, message);
    }
    public void fatal(String message) {
        logMessage(LoggerLevel.FATAL, message);
    }

    public String formatMessage(String message, LoggerLevel level) {
        return String.format("[%s] [%s] [%s] %s",
                new java.util.Date(), level, Thread.currentThread().getName(), message);
    }

    public void addAppender(Appender appender) {
        appenders.add(appender);
    }

}
