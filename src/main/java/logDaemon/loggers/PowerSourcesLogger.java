package logDaemon.loggers;

import logDaemon.loggers.abstracts.AbstractLogger;
import oshi.SystemInfo;
import oshi.hardware.PowerSource;

import java.util.HashMap;
import java.util.Map;

public class PowerSourcesLogger extends AbstractLogger {
    public PowerSourcesLogger(int port) {
        super(port);
    }

    @Override
    public void collect() {
        SystemInfo si = new SystemInfo();
        Map<String, String> temporary = new HashMap<>();

        for (PowerSource pow : si.getHardware().getPowerSources()) {
            temporary.put("Name", pow.getName());
            temporary.put("RemainingCapacity", pow.getRemainingCapacity() + "");
            temporary.put("TimeRemaining", pow.getTimeRemaining() + "");

            sendToLogStash(temporary);
        }
    }
}
