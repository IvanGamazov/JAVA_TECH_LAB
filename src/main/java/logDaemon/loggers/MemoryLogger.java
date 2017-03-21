package logDaemon.loggers;

import logDaemon.loggers.abstracts.AbstractLogger;
import oshi.SystemInfo;
import oshi.hardware.GlobalMemory;

import java.util.HashMap;
import java.util.Map;

public class MemoryLogger extends AbstractLogger {
    public MemoryLogger(String host, int port) {
        super(host, port);
    }

    @Override
    public void collect() {
        SystemInfo si = new SystemInfo();
        Map<String, String> temporary = new HashMap<>();
        GlobalMemory mem = si.getHardware().getMemory();

        temporary.put("type","Memory");
        temporary.put("Total_Memory", mem.getTotal() + "");
        temporary.put("Available_Memory", mem.getAvailable() + "");
        temporary.put("Swap_total", mem.getSwapTotal() + "");
        temporary.put("Swap_Used", mem.getSwapUsed() + "");

        sendToLogStash(temporary);
    }
}
