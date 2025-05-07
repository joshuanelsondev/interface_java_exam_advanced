package org.example;

public class MP3Processor implements AudioFormat {
    @Override
    public byte[] processAudio(byte[] rawData) {
        String decodedString = "DECODED_" + new String(rawData);
        return decodedString.getBytes();
    }

    @Override
    public boolean isCompatible(byte[] data) {
        String fileName = new String(data);
        return fileName.startsWith("MP3");
    }

    @Override
    public String getFormatName() {
        return "MP3";
    }
}
