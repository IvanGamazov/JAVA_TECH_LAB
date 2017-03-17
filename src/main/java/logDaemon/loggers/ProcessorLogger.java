package logDaemon.loggers;

import logDaemon.loggers.abstracts.AbstractLogger;

import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;

import java.util.HashMap;
import java.util.Map;

/**
 * Class for collection Processor logs
 */
public class ProcessorLogger extends AbstractLogger {
    public ProcessorLogger(int port) {
        super(port);
    }

    public void collect() {
        SystemInfo si = new SystemInfo();
        Map<String, String> params = new HashMap<>();
        CentralProcessor cp = si.getHardware().getProcessor();
        params.put("Name",cp.getName());
        params.put("Family",cp.getFamily());
        params.put("Stepping",cp.getStepping());
        params.put("Vendor",cp.getVendor());
        params.put("LogicalProcessorCount",cp.getLogicalProcessorCount()+"");
        params.put("PhysicalProcessorCount",cp.getPhysicalProcessorCount()+"");
        params.put("SystemCpuLoad",cp.getSystemCpuLoad()+"");
        params.put("SystemCpuLoadBetweenTicks",cp.getSystemCpuLoadBetweenTicks()+"");
        params.put("SystemLoadAverage",cp.getSystemLoadAverage()+"");
        params.put("Vendor",cp.getSystemUptime()+"");
        sendToLogStash(params);
    }
}
