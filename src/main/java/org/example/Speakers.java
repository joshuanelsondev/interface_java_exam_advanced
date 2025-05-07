package org.example;

public class Speakers implements AudioOutput {
    private boolean initialized;

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
        return "Computer Speakers";
    }
}
