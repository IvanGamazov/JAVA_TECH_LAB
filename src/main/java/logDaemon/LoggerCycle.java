package logDaemon;

import logDaemon.loggers.abstracts.SystemLogger;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Main cycle. Iterates through loggers
 */
public class LoggerCycle {
    private String host;
    private int port;

    public LoggerCycle(String host, int port) {
        this.host = host;
        this.port = port;
    }

    private List<SystemLogger> list = new ArrayList<>();

    public void add(SystemLogger logger) {
        list.add(logger);
    }

    public void start() {
        while (true) {
            for (SystemLogger logger : list) {
                sendToLogStash(logger.collect());
            }
            try {
                TimeUnit.SECONDS.sleep(20);
            } catch (Exception ignore) {
            }
        }
    }

    private void sendToLogStash(Map<String, String> params) {
        try (DatagramSocket socket = new DatagramSocket()) {
            StringBuilder log = new StringBuilder();
            for (Map.Entry<String, String> entry : params.entrySet()) {
                if (entry.getValue() != null) {
                    if (!entry.getValue().equals("")) {
                        log.append(entry.getKey());
                        log.append("=");
                        log.append(entry.getValue());
                        log.append(" ");
                    }
                }
            }
            byte[] data = log.toString().getBytes();
            InetAddress address;
            if (host.equals("localhost")) {
                address = InetAddress.getLocalHost();
            } else {
                address = InetAddress.getByName(host);
            }
            socket.send(new DatagramPacket(data, data.length, address, port));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
