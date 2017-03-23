package logDaemon.loggers;

import logDaemon.loggers.abstracts.SystemLogger;
import oshi.SystemInfo;
import oshi.hardware.GlobalMemory;

import java.util.HashMap;
import java.util.Map;

public class TzLogger implements SystemLogger {

    @Override
    public Map<String, String> collect() {
        SystemInfo si = new SystemInfo();
        Map<String, String> params = new HashMap<>();
        GlobalMemory memory = si.getHardware().getMemory();

        params.put("CpuLoad", si.getHardware().getProcessor().getSystemCpuLoad() + "");
        params.put("MemoryLoad", memory.getAvailable() * 1.0 / memory.getTotal() + "");
        params.put("PcNAME", System.getProperty("user.name"));
        return params;
    }
}
