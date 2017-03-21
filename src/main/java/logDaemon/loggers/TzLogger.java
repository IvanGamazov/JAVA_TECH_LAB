package logDaemon.loggers;

import logDaemon.loggers.abstracts.AbstractLogger;
import oshi.SystemInfo;
import oshi.hardware.GlobalMemory;

import java.util.HashMap;
import java.util.Map;

public class TzLogger extends AbstractLogger {
    public TzLogger(String host, int port) {
        super(host, port);
    }

    @Override
    public void collect() {
        SystemInfo si = new SystemInfo();
        Map<String, String> params = new HashMap<>();
        params.put("SystemCpuLoad", si.getHardware().getProcessor().getSystemCpuLoad() + "");
        GlobalMemory memory=si.getHardware().getMemory();
        params.put("Memory_Load", memory.getAvailable()*1.0/memory.getTotal() + "");
        params.put("PC_NAME", System.getProperty("user.name"));
        sendToLogStash(params);
    }
}
