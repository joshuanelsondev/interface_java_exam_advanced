# Music Player System - Interface Exercise

## Overview

This exercise is designed to test and enhance your understanding of interfaces in object-oriented programming. You'll build a digital music system that demonstrates polymorphism, loose coupling, and dependency injection through interfaces.

## Requirements

### System Components

Your music player system should include:

1. **Audio Sources**: Different ways to get music (e.g., streaming services, local files, external devices)
2. **Audio Outputs**: Different ways to play music (e.g., speakers, headphones, Bluetooth devices)
3. **Audio Formats**: Different file types with different processing needs (e.g., MP3, WAV, FLAC)
4. **Music Player**: The main class that orchestrates the entire system

### Interface Design

Create at least these interfaces:
- `AudioSource` interface
- `AudioOutput` interface
- `AudioFormat` interface

For each interface, implement at least 2-3 concrete classes that provide different functionality while adhering to the same interface.

### Functional Requirements

Your `MusicPlayer` class should:
1. Allow connecting to any audio source
2. Allow outputting to any audio device
3. Support any audio format
4. Be able to swap components at runtime
5. Play tracks from a source through an output using a specific format

### Implementation Guidelines

1. Focus on behavior in your interfaces, not implementation details
2. Make the `MusicPlayer` depend on interfaces, not concrete implementations
3. Use dependency injection to provide components to the `MusicPlayer`
4. Ensure different implementations are truly interchangeable
5. Create a demo that shows different component combinations

## Project Structure

```
src/
├── main/
│   └── java/
│       └── org/
│           └── example/
│               ├── interfaces/
│               │   ├── AudioSource.java
│               │   ├── AudioOutput.java
│               │   └── AudioFormat.java
│               ├── sources/
│               │   ├── StreamingService.java
│               │   ├── LocalFileSystem.java
│               │   └── [Other source implementations]
│               ├── outputs/
│               │   ├── Speakers.java
│               │   ├── Headphones.java
│               │   └── [Other output implementations]
│               ├── formats/
│               │   ├── MP3Processor.java
│               │   ├── WAVProcessor.java
│               │   └── [Other format implementations]
│               ├── MusicPlayer.java
│               └── Demo.java
└── test/
    └── java/
        └── org/
            └── example/
                └── MusicPlayerTests.java
```

## Testing Your Implementation

Write tests that verify:
1. Each component works correctly in isolation
2. The `MusicPlayer` can use different combinations of components
3. Components can be swapped during runtime
4. The system correctly handles play/stop operations

## Success Criteria

Your solution demonstrates mastery of interfaces if:
1. Components can be replaced without changing `MusicPlayer` code
2. New components can be added without changing existing code
3. The system is loosely coupled with clear separation of concerns
4. Test cases validate the correct functioning with different combinations

## Getting Started

1. Set up a new Maven project using the provided pom.xml
2. Create the interfaces first
3. Implement a few concrete classes for each interface
4. Create the `MusicPlayer` class
5. Write a demo application
6. Write unit tests

## Extensions (Optional)

After completing the basic implementation, consider adding:
1. Volume control capability
2. Playlist management
3. Music library with search
4. Metadata handling for tracks
5. Different audio quality settings

Good luck!