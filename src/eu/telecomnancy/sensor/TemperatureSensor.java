package eu.telecomnancy.sensor;

import java.util.Random;

public class TemperatureSensor implements ISensor {
    boolean state;
    double value = 0;
    private LegacyTemperatureSensor legacyTempSensor = new LegacyTemperatureSensor();

    @Override
    public void on() {
    	legacyTempSensor.onOff();
        state = true;
    }

    @Override
    public void off() {
    	legacyTempSensor.onOff();
        state = false;
    }

    @Override
    public boolean getStatus() {
    	state = legacyTempSensor.getStatus();
        return state;
    }

    @Override
    public void update() throws SensorNotActivatedException {
        if (state)
            value = legacyTempSensor.getTemperature();
        else throw new SensorNotActivatedException("Sensor must be activated before acquiring new values.");
    }

    @Override
    public double getValue() throws SensorNotActivatedException {
        if (state)
            return value;
        else throw new SensorNotActivatedException("Sensor must be activated to get its value.");
    }

}
