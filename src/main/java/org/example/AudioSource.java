package org.example;

public interface AudioSource {
 
    boolean connect();

    void disconnect();

    byte[] getAudioData(String trackId);
 
    String getSourceName();
}
