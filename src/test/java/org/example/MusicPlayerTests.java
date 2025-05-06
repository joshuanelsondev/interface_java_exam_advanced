package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MusicPlayerTests {
    // Test objects
    private AudioSource streamingService;
    private AudioSource localFiles;
    private AudioOutput speakers;
    private AudioOutput bluetoothDevice;
    private AudioFormat mp3Processor;
    private AudioFormat wavProcessor;
    private MusicPlayer player;

    @BeforeEach
    void setUp() {
        // Initialize test objects
        streamingService = new StreamingService("TestStreaming");
        localFiles = new LocalFileSystem("/test/music");
        speakers = new Speakers();
        bluetoothDevice = new BluetoothDevice("TestSpeaker");
        mp3Processor = new MP3Processor();
        wavProcessor = new WAVProcessor();
        player = new MusicPlayer();
    }

    // ===== AUDIO SOURCE TESTS =====

    @Test
    void testStreamingServiceConnect() {
        assertTrue(streamingService.connect());
        assertEquals("TestStreaming", streamingService.getSourceName());
    }

    @Test
    void testLocalFilesConnect() {
        assertTrue(localFiles.connect());
        assertEquals("Local Files (/test/music)", localFiles.getSourceName());
    }

    @Test
    void testAudioSourceGetData() {
        streamingService.connect();
        byte[] data = streamingService.getAudioData("testTrack.mp3");
        assertNotNull(data);
        String dataString = new String(data);
        assertTrue(dataString.contains("STREAMING_DATA_testTrack.mp3"));
    }

    // ===== AUDIO OUTPUT TESTS =====

    @Test
    void testSpeakersInitialize() {
        assertTrue(speakers.initialize());
        assertEquals("Computer Speakers", speakers.getDeviceName());
    }

    @Test
    void testBluetoothDeviceInitialize() {
        assertTrue(bluetoothDevice.initialize());
        assertEquals("Bluetooth: TestSpeaker", bluetoothDevice.getDeviceName());
    }

    // ===== AUDIO FORMAT TESTS =====

    @Test
    void testMP3FormatCompatibility() {
        byte[] mp3Data = "MP3_TEST_DATA".getBytes();
        assertTrue(mp3Processor.isCompatible(mp3Data));
        assertEquals("MP3", mp3Processor.getFormatName());
    }

    @Test
    void testWAVFormatCompatibility() {
        byte[] wavData = "WAV_TEST_DATA".getBytes();
        assertTrue(wavProcessor.isCompatible(wavData));
        assertEquals("WAV", wavProcessor.getFormatName());
    }

    @Test
    void testWrongFormatIncompatibility() {
        byte[] mp3Data = "MP3_TEST_DATA".getBytes();
        assertFalse(wavProcessor.isCompatible(mp3Data));
    }

    @Test
    void testAudioProcessing() {
        byte[] rawData = "MP3_TEST_DATA".getBytes();
        byte[] processedData = mp3Processor.processAudio(rawData);
        String result = new String(processedData);
        assertTrue(result.contains("DECODED_MP3_"));
        assertTrue(result.contains("MP3_TEST_DATA"));
    }

    // ===== MUSIC PLAYER TESTS =====

    @Test
    void testMusicPlayerConfiguration() {
        // Initial state should have no components
        String config = player.getCurrentConfiguration();
        assertTrue(config.contains("Source: none"));
        assertTrue(config.contains("Output: none"));
        assertTrue(config.contains("Format: none"));

        // Set components
        player.setAudioSource(streamingService);
        player.setAudioOutput(speakers);
        player.setAudioFormat(mp3Processor);

        // Check updated configuration
        config = player.getCurrentConfiguration();
        assertTrue(config.contains("Source: TestStreaming"));
        assertTrue(config.contains("Output: Computer Speakers"));
        assertTrue(config.contains("Format: MP3"));
    }

    @Test
    void testSwappingComponents() {
        // Start with one configuration
        player.setAudioSource(streamingService);
        player.setAudioOutput(speakers);
        player.setAudioFormat(mp3Processor);

        // Change to a different configuration
        player.setAudioSource(localFiles);
        player.setAudioOutput(bluetoothDevice);
        player.setAudioFormat(wavProcessor);

        // Check final configuration
        String config = player.getCurrentConfiguration();
        assertTrue(config.contains("Source: Local Files"));
        assertTrue(config.contains("Output: Bluetooth: TestSpeaker"));
        assertTrue(config.contains("Format: WAV"));
    }

    // ===== INTEGRATION TESTS =====

    @Test
    void testCompletePlaybackScenario() {
        // Configure the player
        player.setAudioSource(streamingService);
        player.setAudioOutput(speakers);
        player.setAudioFormat(mp3Processor);

        // This should work without exceptions
        player.playTrack("validTrack.mp3");
        player.stop();

        // Switch components mid-playback
        player.playTrack("anotherTrack.mp3");
        player.setAudioOutput(bluetoothDevice);
        player.playTrack("anotherTrack.mp3");
        player.stop();
    }
}
