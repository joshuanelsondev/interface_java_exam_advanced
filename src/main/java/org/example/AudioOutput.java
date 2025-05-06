package org.example;

public interface AudioOutput {

    boolean initialize();

    void playAudio(byte[] audioData);

    void stop();

    String getDeviceName();
}
