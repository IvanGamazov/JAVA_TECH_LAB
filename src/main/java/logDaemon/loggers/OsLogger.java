package logDaemon.loggers;

import logDaemon.loggers.abstracts.AbstractLogger;
import oshi.SystemInfo;
import oshi.software.os.OperatingSystem;

import java.util.HashMap;
import java.util.Map;

public class OsLogger extends AbstractLogger {
    public OsLogger(String host, int port) {
        super(host, port);
    }

    @Override
    public void collect() {
        SystemInfo si = new SystemInfo();
        Map<String, String> params = new HashMap<>();
        OperatingSystem os = si.getOperatingSystem();

        params.put("type","OS");
        params.put("Family", os.getFamily());
        params.put("Manufacturer", os.getManufacturer());
        params.put("Build_Number", os.getVersion().getBuildNumber());
        params.put("Version", os.getVersion().getVersion());

        sendToLogStash(params);
    }
}
