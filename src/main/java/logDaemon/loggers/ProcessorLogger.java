package logDaemon.loggers;

import logDaemon.loggers.abstracts.AbstractLogger;
import org.jutils.jhardware.HardwareInfo;
import org.jutils.jhardware.model.ProcessorInfo;

/**
 * Class for collection Processor logs
 */
public class ProcessorLogger extends AbstractLogger {
    public void collect() {
        ProcessorInfo info = HardwareInfo.getProcessorInfo();
        sendToLogStash(info.getFullInfo(), 4445);
    }
}
