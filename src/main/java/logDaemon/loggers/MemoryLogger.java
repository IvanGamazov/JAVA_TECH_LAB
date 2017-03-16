package logDaemon.loggers;

import logDaemon.loggers.abstracts.AbstractLogger;
import org.jutils.jhardware.HardwareInfo;
import org.jutils.jhardware.model.MemoryInfo;

public class MemoryLogger extends AbstractLogger {
    public MemoryLogger(int port) {
        super(port);
    }

    @Override
    public void collect() {
        MemoryInfo info = HardwareInfo.getMemoryInfo();
        sendToLogStash(info.getFullInfo());
    }
}
