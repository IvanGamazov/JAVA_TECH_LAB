package logDaemon.loggers;

import logDaemon.loggers.abstracts.AbstractLogger;
import org.jutils.jhardware.HardwareInfo;
import org.jutils.jhardware.model.NetworkInfo;
import org.jutils.jhardware.model.NetworkInterfaceInfo;
import oshi.SystemInfo;
import oshi.software.os.NetworkParams;
import oshi.software.os.OperatingSystem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NetworkLogger extends AbstractLogger {
    public NetworkLogger(int port) {
        super(port);
    }

    @Override
    public void collect() {
        SystemInfo si = new SystemInfo();
        Map<String, String> params = new HashMap<>();
        NetworkParams net = si.getOperatingSystem().getNetworkParams();
        params.put("Host_name", net.getHostName());
        params.put("Domain_name", net.getDomainName());
        params.put("Ipv4DefaultGateway", net.getIpv4DefaultGateway());
        params.put("Ipv6DefaultGateway", net.getIpv6DefaultGateway());
        params.put("DNS_Servers", Arrays.toString(net.getDnsServers()));
        sendToLogStash(params);
    }
}

