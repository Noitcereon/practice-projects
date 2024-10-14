import logging.Logger;
import tryouts.RightShiftOperator;
import tryouts.StringJoining;
import tryouts.SystemVariablesOutput;

public class Main {
    public static void main(String[] args) {
        Logger.log("Hello, World!");
        SystemVariablesOutput systemVariables = new SystemVariablesOutput();
        systemVariables.run();
        RightShiftOperator rso = new RightShiftOperator();
        rso.run();
        StringJoining stringJoining = new StringJoining();
        stringJoining.run();

    }
}