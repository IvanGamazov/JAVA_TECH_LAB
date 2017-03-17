package logDaemon.loggers;

import logDaemon.loggers.abstracts.AbstractLogger;
import oshi.SystemInfo;
import oshi.hardware.NetworkIF;

import java.util.HashMap;
import java.util.Map;

public class NetworkInterfacesLogger extends AbstractLogger {
    public NetworkInterfacesLogger(int port) {
        super(port);
    }

    @Override
    public void collect() {
        SystemInfo si = new SystemInfo();
        Map<String, String> params = new HashMap<>();
        for (NetworkIF netInf : si.getHardware().getNetworkIFs()) {
            params.put("Name", netInf.getName());
            params.put("MacAddress", netInf.getMacaddr());
            params.put("Speed", netInf.getSpeed() + "");
            params.put("BytesReceived", netInf.getBytesRecv() + "");
            params.put("BytesSent", netInf.getBytesSent() + "");
            params.put("PacketsRecv", netInf.getPacketsRecv() + "");
            params.put("PacketsSent", netInf.getPacketsSent() + "");
            sendToLogStash(params);
        }
    }
}
