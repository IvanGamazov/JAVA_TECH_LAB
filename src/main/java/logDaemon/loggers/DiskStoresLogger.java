package logDaemon.loggers;

import logDaemon.loggers.abstracts.AbstractLogger;
import oshi.SystemInfo;
import oshi.hardware.HWDiskStore;

import java.util.HashMap;
import java.util.Map;

public class DiskStoresLogger extends AbstractLogger {
    public DiskStoresLogger(String host, int port) {
        super(host, port);
    }

    @Override
    public void collect() {
        SystemInfo si = new SystemInfo();
        Map<String, String> stable = new HashMap<>();
        Map<String, String> temporary = new HashMap<>();
        for (HWDiskStore disk : si.getHardware().getDiskStores()) {

            stable.put("type","HardDisk");
            stable.put("Name", disk.getName());
            stable.put("Model", disk.getModel());
            stable.put("Serial", disk.getSerial());
            stable.put("Size", disk.getSize() + "");


            temporary.put("type","HardDisk_temporary");
            temporary.put("Name", disk.getName());
            temporary.put("Reads", disk.getReads() + "");
            temporary.put("ReadBytes", disk.getReadBytes() + "");
            temporary.put("Writes", disk.getWrites() + "");
            temporary.put("WriteBytes", disk.getWriteBytes() + "");

            sendToLogStash(stable);
            sendToLogStash(temporary);
        }
    }
}
