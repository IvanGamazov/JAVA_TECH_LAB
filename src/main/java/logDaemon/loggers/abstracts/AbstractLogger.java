package logDaemon.loggers.abstracts;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Map;

public abstract class AbstractLogger implements SystemLogger {
    private String host;
    private int port;

    public AbstractLogger(String host, int port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public void sendToLogStash(Map<String, String> params) {
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
