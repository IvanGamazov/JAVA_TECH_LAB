package logDaemon.loggers;

import logDaemon.loggers.abstracts.AbstractLogger;
import oshi.SystemInfo;
import oshi.hardware.Sensors;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SensorLogger extends AbstractLogger {
    public SensorLogger(int port) {
        super(port);
    }

    @Override
    public void collect() {
        Sensors sens = new SystemInfo().getHardware().getSensors();
        Map<String, String> params = new HashMap<>();
        params.put("CpuTemperature",sens.getCpuTemperature()+"");
        params.put("CpuVoltage",sens.getCpuVoltage()+"");
        params.put("FanSpeeds", Arrays.toString(sens.getFanSpeeds()));
        sendToLogStash(params);
    }
}
