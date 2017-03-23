package logDaemon.loggers.abstracts;

import java.util.Map;

/**
 * Interface containing main logger functions
 */
public interface SystemLogger {
    Map<String,String> collect();
}
