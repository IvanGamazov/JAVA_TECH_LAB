package logDaemon;

import logDaemon.loggers.*;

public class Solution {
    public static void main(String[] args) {
        LoggerCycle loggerCycle =new LoggerCycle();

        String host=args[0].toLowerCase();
        int port=Integer.parseInt(args[1]);

        /*
        Add here your new Loggers ( ProcessorLogger, MemoryLogger, HddLogger etc.)
         */
        /*
        loggerCycle.add(new ProcessorLogger(port));
        loggerCycle.add(new MemoryLogger(port));
        loggerCycle.add(new SensorLogger(port));
        loggerCycle.add(new DiskStoresLogger(port));
        loggerCycle.add(new OsLogger(port));
        loggerCycle.add(new NetworkLogger(port));
        loggerCycle.add(new PowerSourcesLogger(port));
        loggerCycle.add(new NetworkInterfacesLogger(port));

        */

        loggerCycle.add(new TzLogger(host, port));

        loggerCycle.start();
    }
}
