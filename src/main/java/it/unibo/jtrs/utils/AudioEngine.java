package it.unibo.jtrs.utils;

import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * A simple audio engine that make possible to load a track from a file, pause
 * and resume as needed.
 */
public final class AudioEngine {

    private static Clip clip;

    private AudioEngine() { }

    /**
     * Load a file into the engine and start playing it.
     *
     * @param file the file to load
     */
    public static void load(final String file) {

        try {
            final var stream = AudioSystem.getAudioInputStream(ResourceLoader.load(file));

            clip = AudioSystem.getClip();
            clip.open(stream);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            clip = null;
        }
    }

    /**
     * Terminate the playing track and close its file.
     */
    public static void stop() {
        if (clip != null) {
            clip.stop();
            clip.close();
        }
    }

    /**
     * Pause the current playing track.
     */
    public static void pause() {
        if (clip != null) {
            clip.stop();
        }
    }

    /**
     * Resume the current playing track.
     */
    public static void resume() {
        if (clip != null) {
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
    }

    /**
     * Toggle between pause and resume of the current playing track.
     */
    public static void toggle() {
        if (clip.isRunning()) {
            AudioEngine.pause();
        } else {
            AudioEngine.resume();
        }
    }

}
