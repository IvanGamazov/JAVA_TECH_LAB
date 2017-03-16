package logDaemon.loggers.abstracts;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Map;

public abstract class AbstractLogger implements SystemLogger {
    @Override
    public void sendToLogStash(Map<String, String> params, int port) {
        try (DatagramSocket socket = new DatagramSocket()) {
            StringBuilder log = new StringBuilder();
            for (Map.Entry<String, String> entry : params.entrySet()) {
                log.append(entry.getKey());
                log.append("=");
                log.append(entry.getValue().equals("") ? "null" : entry.getValue()  );
                log.append(" ");
            }
            byte[] data = log.toString().getBytes();
            InetAddress address = InetAddress.getLocalHost();
            socket.send(new DatagramPacket(data, data.length, address, port));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
