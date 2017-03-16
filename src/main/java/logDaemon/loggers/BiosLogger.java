package logDaemon.loggers;

import logDaemon.loggers.abstracts.AbstractLogger;
import org.jutils.jhardware.HardwareInfo;
import org.jutils.jhardware.model.BiosInfo;

public class BiosLogger extends AbstractLogger {
    public BiosLogger(int port) {
        super(port);
    }

    @Override
    public void collect() {
        BiosInfo info = HardwareInfo.getBiosInfo();
        sendToLogStash(info.getFullInfo());
    }
}
