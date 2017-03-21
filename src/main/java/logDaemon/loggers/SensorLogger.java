package logDaemon.loggers;

import logDaemon.loggers.abstracts.AbstractLogger;
import oshi.SystemInfo;
import oshi.hardware.Sensors;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SensorLogger extends AbstractLogger {
    public SensorLogger(String host, int port) {
        super(host, port);
    }

    @Override
    public void collect() {
        Sensors sens = new SystemInfo().getHardware().getSensors();
        Map<String, String> temporary = new HashMap<>();

        temporary.put("type","Sensor");
        temporary.put("CpuTemperature",sens.getCpuTemperature()+"");
        temporary.put("CpuVoltage",sens.getCpuVoltage()+"");
        temporary.put("FanSpeeds", Arrays.toString(sens.getFanSpeeds()));

        sendToLogStash(temporary);
    }
}
