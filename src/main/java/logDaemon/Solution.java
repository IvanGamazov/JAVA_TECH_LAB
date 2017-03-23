package logDaemon;

import logDaemon.loggers.*;

public class Solution {
    public static void main(String[] args) {
        String host = args[0].toLowerCase();
        int port = Integer.parseInt(args[1]);

        LoggerCycle loggerCycle = new LoggerCycle(host, port);
        loggerCycle.add(new TzLogger());
        loggerCycle.start();
    }
}
