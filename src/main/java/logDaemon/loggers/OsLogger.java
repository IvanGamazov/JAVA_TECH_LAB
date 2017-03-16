package logDaemon.loggers;

import logDaemon.loggers.abstracts.AbstractLogger;
import org.jutils.jhardware.HardwareInfo;
import org.jutils.jhardware.model.DisplayInfo;
import org.jutils.jhardware.model.GraphicsCardInfo;
import org.jutils.jhardware.model.NetworkInfo;
import org.jutils.jhardware.model.OSInfo;

public class OsLogger extends AbstractLogger {
    public OsLogger(int port) {
        super(port);
    }

    @Override
    public void collect() {
        OSInfo info = HardwareInfo.getOSInfo();
        sendToLogStash(info.getFullInfo());
    }
}
