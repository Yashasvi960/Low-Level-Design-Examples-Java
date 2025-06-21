package loggingLibrary;

public class LoggerManager {
    private static LoggerManager instance;

    public static synchronized  LoggerManager getInstance() {
        if(instance==null) {
            instance = new LoggerManager();
        }

        return instance;
    }
}
