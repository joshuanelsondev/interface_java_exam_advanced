package org.example;

public class StreamingService implements AudioSource {
    private final String serviceName;
    private boolean connected;

    public StreamingService(String serviceName) {
        if (serviceName == null) throw new IllegalArgumentException("Service name can not be empty");
        this.serviceName = serviceName;
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
        String audioData = "STREAMING_DATA_" + trackId;
      return audioData.getBytes();
    }

    @Override
    public String getSourceName() {
        return this.serviceName;
    }
}