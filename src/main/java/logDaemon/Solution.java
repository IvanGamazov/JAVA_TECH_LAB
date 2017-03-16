package logDaemon;

import logDaemon.loggers.ProcessorLogger;

public class Solution {
    public static void main(String[] args) {
        LoggerCycle loggerCycle =new LoggerCycle();

        /*
        Add here your new Loggers ( ProcessorLogger, MemoryLogger, HddLogger etc.)
         */
        loggerCycle.add(new ProcessorLogger());





        loggerCycle.start();
    }
}
