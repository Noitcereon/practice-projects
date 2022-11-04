package logging;

@SuppressWarnings("java:S106")
public class Logger {

    private Logger(){}

    private static final String INFO = "[INFO]: ";
    private static final String WARN = "[WARN]: ";
    private static final String ERROR = "[ERROR]: ";

    /**
     * Logs a message to the console (does not use a logging framework).
     */

    public static void log(String message){
        System.out.println(message);
    }
    /**
     * Logs a message to the console (does not use a logging framework).
     */
    public static void log(int message){
        System.out.println(message);
    }


    public static void logWarn(String message){
        System.out.println(WARN + message);
    }
    public static void logError(String message){
        System.out.println(ERROR + message);
    }
    public static void logInfo(String message) {
        System.out.println(INFO + message);
    }
}
