package logDaemon.loggers.abstracts;

import java.util.Map;

/**
 * Interface containing main logger functions
 */
public interface SystemLogger {
    void collect();

    void sendToLogStash(Map<String, String> params);
}
