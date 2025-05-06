package org.example;

public class MusicPlayer {
    private AudioSource source;
    private AudioOutput output;
    private AudioFormat format;
    private boolean isPlaying;


    public MusicPlayer() {
      
    }


    public void setAudioSource(AudioSource source) {
     
    }


    public void setAudioOutput(AudioOutput output) {
    
    }


    public void setAudioFormat(AudioFormat format) {
    
    }


    public void playTrack(String trackId) {
  
    }


    public void stop() {
      
    }

    public String getCurrentConfiguration() {
        return "MusicPlayer Configuration:" +
                "\n- Source: " + (source != null ? source.getSourceName() : "none") +
                "\n- Output: " + (output != null ? output.getDeviceName() : "none") +
                "\n- Format: " + (format != null ? format.getFormatName() : "none");
    }
}

