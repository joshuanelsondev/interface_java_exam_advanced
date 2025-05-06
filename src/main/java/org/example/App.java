package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // Create a music player
        MusicPlayer player = new MusicPlayer();

        // Create audio sources
        AudioSource streamingService = new StreamingService("Spotify");
        AudioSource localFiles = new LocalFileSystem("/music");
        AudioSource externalDevice = new ExternalDevice("iPod");

        // Create audio outputs
        AudioOutput speakers = new Speakers();
        AudioOutput headphones = new Headphones();
        AudioOutput bluetoothSpeaker = new BluetoothDevice("JBL Speaker");

        // Create audio formats
        AudioFormat mp3Processor = new MP3Processor();
        AudioFormat wavProcessor = new WAVProcessor();
        AudioFormat flacProcessor = new FLACProcessor();

        // Demo 1: Stream music to speakers
        System.out.println("\n=== Demo 1: Streaming to Speakers ===");
        player.setAudioSource(streamingService);
        player.setAudioOutput(speakers);
        player.setAudioFormat(mp3Processor);
        System.out.println(player.getCurrentConfiguration());
        player.playTrack("song1.mp3");
        player.stop();

        // Demo 2: Play local file to Bluetooth speaker
        System.out.println("\n=== Demo 2: Local File to Bluetooth ===");
        player.setAudioSource(localFiles);
        player.setAudioOutput(bluetoothSpeaker);
        player.setAudioFormat(flacProcessor);
        System.out.println(player.getCurrentConfiguration());
        player.playTrack("high_quality.flac");
        player.stop();

        // Demo 3: Play from external device to headphones
        System.out.println("\n=== Demo 3: External Device to Headphones ===");
        player.setAudioSource(externalDevice);
        player.setAudioOutput(headphones);
        player.setAudioFormat(wavProcessor);
        System.out.println(player.getCurrentConfiguration());
        player.playTrack("recording.wav");
        player.stop();

        // Demo 4: Switch output device mid-playback
        System.out.println("\n=== Demo 4: Switching Output During Playback ===");
        player.setAudioSource(streamingService);
        player.setAudioOutput(headphones);
        player.setAudioFormat(mp3Processor);
        System.out.println(player.getCurrentConfiguration());
        player.playTrack("song2.mp3");

        // Switch to speakers
        System.out.println("\nSwitching output to speakers...");
        player.setAudioOutput(speakers);
        System.out.println(player.getCurrentConfiguration());
        player.playTrack("song2.mp3");
        player.stop();

        // Clean up
        System.out.println("\n=== Cleaning Up ===");
        player.setAudioSource(null);


    }
}
