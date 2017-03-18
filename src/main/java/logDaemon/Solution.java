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
        loggerCycle.add(new SensorLogger(port++));
        loggerCycle.add(new DiskStoresLogger(port++));
        loggerCycle.add(new OsLogger(port++));
        loggerCycle.add(new NetworkLogger(port++));
        loggerCycle.add(new PowerSourcesLogger(port++));
        loggerCycle.add(new NetworkInterfacesLogger(port++));

        loggerCycle.start();
    }
}
