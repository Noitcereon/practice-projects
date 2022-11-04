package util;

import logging.Logger;

public class StartStopMessages {

    private StartStopMessages(){}

    public static void start(String tryoutClassName){
        Logger.logInfo("Starting " + tryoutClassName);
    }
    public static void stop(String tryoutClassName){
        Logger.logInfo("End of " + tryoutClassName);
    }
}
