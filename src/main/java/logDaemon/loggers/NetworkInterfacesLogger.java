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
        Map<String, String> stable = new HashMap<>();
        Map<String, String> temporary = new HashMap<>();
        for (NetworkIF netInf : si.getHardware().getNetworkIFs()) {
            stable.put("type","NetworkInterface");
            stable.put("Name", netInf.getName());
            stable.put("MacAddress", netInf.getMacaddr());


            temporary.put("type","NetworkInterface_temporary");
            temporary.put("Name", netInf.getName());
            temporary.put("BytesReceived", netInf.getBytesRecv() + "");
            temporary.put("BytesSent", netInf.getBytesSent() + "");
            temporary.put("PacketsRecv", netInf.getPacketsRecv() + "");
            temporary.put("PacketsSent", netInf.getPacketsSent() + "");
            temporary.put("Speed", netInf.getSpeed() + "");

            sendToLogStash(stable);
            sendToLogStash(temporary);
        }
    }
}
