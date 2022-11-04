package tryouts;

import logging.Logger;
import util.StartStopMessages;

import java.util.StringJoiner;

public class StringJoining implements Runnable {

    private String stringJoin() {
        StringJoiner sj = new StringJoiner(",");

        sj.add("Hello there!");
        sj.add("This is number 2");
        sj.add("3");
        sj.add("4");
        sj.add("5");
        sj.add("6");

        return sj.toString();
    }
    private String stringJoinWithStringBuilder() {
        StringBuilder sb = new StringBuilder();

        sb.append("Hello there!,");
        sb.append("This is number 2,");
        sb.append("3,");
        sb.append("4,");
        sb.append("5,");
        sb.append("6");
        return sb.toString();
    }

    @Override
    public void run() {
        StartStopMessages.start(StringJoining.class.getName());
        String stringJoiner = stringJoin();
        String stringJoinerWithBuilder = stringJoinWithStringBuilder();
        Logger.log("-- With StringJoiner --");
        Logger.log(stringJoiner);
        Logger.log("-- With StringBuilder --");
        Logger.log(stringJoinerWithBuilder);
        StartStopMessages.stop(StringJoining.class.getName());
    }
}
