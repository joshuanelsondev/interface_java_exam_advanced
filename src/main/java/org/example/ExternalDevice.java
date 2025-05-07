package org.example;

public class ExternalDevice implements AudioSource {
    private final String deviceName;
    private boolean connected;

    public ExternalDevice(String deviceName) {
        this.deviceName = deviceName;
    }

    @Override
    public boolean connect() {
        connected = true;
        return true;
    }

    @Override
    public void disconnect() {
        connected = false;
    }

    @Override
    public byte[] getAudioData(String trackId) {
        return trackId.getBytes();
    }

    @Override
    public String getSourceName() {
        return "External Device: " + this.deviceName;
    }
}
