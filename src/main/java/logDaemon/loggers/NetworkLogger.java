package logDaemon.loggers;

import logDaemon.loggers.abstracts.AbstractLogger;
import oshi.SystemInfo;
import oshi.software.os.NetworkParams;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NetworkLogger extends AbstractLogger {
    public NetworkLogger(String host, int port) {
        super(host, port);
    }

    @Override
    public void collect() {
        SystemInfo si = new SystemInfo();
        Map<String, String> stable = new HashMap<>();
        NetworkParams net = si.getOperatingSystem().getNetworkParams();

        stable.put("type","Network");
        stable.put("Host_name", net.getHostName());
        stable.put("Domain_name", net.getDomainName());
        stable.put("Ipv4DefaultGateway", net.getIpv4DefaultGateway());
        stable.put("Ipv6DefaultGateway", net.getIpv6DefaultGateway());
        stable.put("DNS_Servers", Arrays.toString(net.getDnsServers()));

        sendToLogStash(stable);
    }
}

