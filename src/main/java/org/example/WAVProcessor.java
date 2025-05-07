package org.example;

public class WAVProcessor implements AudioFormat {
    @Override
    public byte[] processAudio(byte[] rawData) {
        return rawData;
    }

    @Override
    public boolean isCompatible(byte[] data) {
        String fileName = new String(data);
        return fileName.startsWith("WAV");
    }

    @Override
    public String getFormatName() {
        return "WAV";
    }
}
