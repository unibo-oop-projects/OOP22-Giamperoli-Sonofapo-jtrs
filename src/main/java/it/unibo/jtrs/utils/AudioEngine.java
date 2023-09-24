package it.unibo.jtrs.utils;

import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * A simple audio engine that make possible to load a track from a file, pause
 * and resume as needed.
 */
public final class AudioEngine {

    private static final float LOW_VOL_DB = -10.0f;

    private static Clip clip;

    private AudioEngine() { }

    /**
     * Load a file into the engine and start playing it.
     *
     * @param file the file to load
     */
    public static void load(final String file) throws IOException {

        try {
            final var stream = AudioSystem.getAudioInputStream(ResourceLoader.loadAsUrl(file));

            clip = AudioSystem.getClip();
            clip.open(stream);

            // normalize volume
            ((FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN)).setValue(LOW_VOL_DB);

            AudioEngine.resume();

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            throw new IOException("Can not open " + file + " " + e.getMessage(), e);
        }
    }

    /**
     * Terminate the playing track and close its file.
     */
    public static void stop() {
        clip.stop();
        clip.close();
    }

    /**
     * Pause the current playing track.
     */
    public static void pause() {
        clip.stop();
    }

    /**
     * Resume the current playing track.
     */
    public static void resume() {
        clip.start();
        clip.loop(Clip.LOOP_CONTINUOUSLY);
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
