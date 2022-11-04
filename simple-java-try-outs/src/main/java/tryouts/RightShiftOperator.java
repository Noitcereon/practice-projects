package tryouts;

import logging.Logger;
import util.StartStopMessages;

public class RightShiftOperator implements Runnable {
    public void run() {
        StartStopMessages.start(RightShiftOperator.class.getName());
        int i = 4;
        Logger.log(i); // expected 4
        Logger.log(i >> 1); // expected: 2
        Logger.log(i >> 2); // expected: 1
        i += 4;
        Logger.log(i >> 3); // expected: 1
        StartStopMessages.stop(RightShiftOperator.class.getName());
    }
}
