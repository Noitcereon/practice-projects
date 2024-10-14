package tryouts;

import logging.Logger;
import util.StartStopMessages;

import java.io.File;

public class SystemVariablesOutput implements Runnable {
    private static final String CONF_PATH = File.separator + "log4j2-dkvies.xml";
    private static final String USER_DIR = System.getProperty("user.dir");

    @Override
    public void run() {
        StartStopMessages.start(SystemVariablesOutput.class.getName());
        Logger.log(USER_DIR);
        Logger.log(CONF_PATH);
        Logger.log(USER_DIR + CONF_PATH);

        StartStopMessages.stop(SystemVariablesOutput.class.getName());
    }
}
