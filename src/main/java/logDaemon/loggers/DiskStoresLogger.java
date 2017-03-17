package logDaemon.loggers;

import logDaemon.loggers.abstracts.AbstractLogger;
import oshi.SystemInfo;
import oshi.hardware.HWDiskStore;

import java.util.HashMap;
import java.util.Map;

public class DiskStoresLogger extends AbstractLogger {
    public DiskStoresLogger(int port) {
        super(port);
    }

    @Override
    public void collect() {
        SystemInfo si = new SystemInfo();
        Map<String, String> params = new HashMap<>();
        for (HWDiskStore disk : si.getHardware().getDiskStores()) {
            params.put("Name", disk.getName());
            params.put("Model", disk.getModel());
            params.put("Serial", disk.getSerial());
            params.put("Size", disk.getSize() + "");
            params.put("Reads", disk.getReads() + "");
            params.put("Writes", disk.getWrites() + "");
            sendToLogStash(params);
        }
    }
}
