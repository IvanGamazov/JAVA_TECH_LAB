package logDaemon;

import logDaemon.loggers.abstracts.SystemLogger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Main cycle. Iterates through loggers
 */
public class LoggerCycle {
    private List<SystemLogger> list=new ArrayList<>();

    public void add(SystemLogger logger){
        list.add(logger);
    }

    public void start() {
        while (true) {
            for (SystemLogger logger : list) {
                logger.collect();
            }
            try {
                TimeUnit.SECONDS.sleep(20);
            }catch (Exception ignore){}
        }
    }
}
