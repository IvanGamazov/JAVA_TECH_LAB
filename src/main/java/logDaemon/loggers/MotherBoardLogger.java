package logDaemon.loggers;

import logDaemon.loggers.abstracts.AbstractLogger;
import org.jutils.jhardware.HardwareInfo;
import org.jutils.jhardware.model.MotherboardInfo;

public class MotherBoardLogger extends AbstractLogger {
    public MotherBoardLogger(int port) {
        super(port);
    }

    @Override
    public void collect() {
        MotherboardInfo info = HardwareInfo.getMotherboardInfo();
        sendToLogStash(info.getFullInfo());
    }
}
