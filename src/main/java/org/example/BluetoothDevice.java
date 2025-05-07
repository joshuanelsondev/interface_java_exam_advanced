package org.example;

public class BluetoothDevice implements AudioOutput {
    private final String deviceName;
    private boolean initialized;

    public BluetoothDevice(String deviceName) {
         this.deviceName = deviceName;
    }

    @Override
    public boolean initialize() {
        initialized = true;
        return true;
    }

    @Override
    public void playAudio(byte[] audioData) {
 
    }

    @Override
    public void stop() {
       
    }

    @Override
    public String getDeviceName() {
        return "Bluetooth: " + this.deviceName;
    }
}
