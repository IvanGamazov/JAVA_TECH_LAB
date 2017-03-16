package logDaemon;

import logDaemon.loggers.*;

public class Solution {
    public static void main(String[] args) {
        LoggerCycle loggerCycle =new LoggerCycle();

        /*
        Add here your new Loggers ( ProcessorLogger, MemoryLogger, HddLogger etc.)
         */
        int port=4445;
        loggerCycle.add(new ProcessorLogger(port++));
        loggerCycle.add(new MemoryLogger(port++));
        loggerCycle.add(new BiosLogger(port++));
        loggerCycle.add(new MotherBoardLogger(port++));
        loggerCycle.add(new OsLogger(port++));



        loggerCycle.start();
    }
}
