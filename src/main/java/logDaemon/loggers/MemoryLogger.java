package logDaemon.loggers;

import logDaemon.loggers.abstracts.AbstractLogger;
import org.jutils.jhardware.HardwareInfo;
import org.jutils.jhardware.model.MemoryInfo;
import oshi.SystemInfo;
import oshi.hardware.GlobalMemory;

import java.util.HashMap;
import java.util.Map;

public class MemoryLogger extends AbstractLogger {
    public MemoryLogger(int port) {
        super(port);
    }

    @Override
    public void collect() {
        SystemInfo si = new SystemInfo();
        Map<String, String> params = new HashMap<>();
        GlobalMemory mem = si.getHardware().getMemory();
        params.put("Total_Memory",mem.getTotal()+"");
        params.put("Available_Memory",mem.getAvailable()+"");
        params.put("Swap_total",mem.getSwapTotal()+"");
        params.put("Swap_Used",mem.getSwapUsed()+"");
        sendToLogStash(params);


    }
}
