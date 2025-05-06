package org.example;

public interface AudioFormat {
  
    byte[] processAudio(byte[] rawData);

    boolean isCompatible(byte[] data);

    String getFormatName();
}
