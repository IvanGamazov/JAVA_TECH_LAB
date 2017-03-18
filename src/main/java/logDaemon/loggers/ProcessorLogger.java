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
        CentralProcessor cp = si.getHardware().getProcessor();
        Map<String, String> stable = new HashMap<>();
        Map<String, String> temporary = new HashMap<>();

        stable.put("type", "Processor");
        stable.put("Name", cp.getName());
        stable.put("Family", cp.getFamily());
        stable.put("Stepping", cp.getStepping());
        stable.put("Vendor", cp.getVendor());
        stable.put("LogicalProcessorCount", cp.getLogicalProcessorCount() + "");
        stable.put("PhysicalProcessorCount", cp.getPhysicalProcessorCount() + "");
        stable.put("Vendor", cp.getSystemUptime() + "");

        temporary.put("type", "Processor_temporary");
        temporary.put("SystemCpuLoad", cp.getSystemCpuLoad() + "");
        temporary.put("SystemCpuLoadBetweenTicks", cp.getSystemCpuLoadBetweenTicks() + "");
        temporary.put("SystemLoadAverage", cp.getSystemLoadAverage() + "");

        sendToLogStash(stable);
        sendToLogStash(temporary);
    }
}
