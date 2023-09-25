package it.unibo.jtrs.view.custom;

import java.awt.Color;

/**
 * Graphic's constants.
 */
public final class Constants {

    private Constants() { }

    /**
     * Label contants.
     */
    public static class Label {

        /**
         * Default text color.
         */
        public static final Color TEXT_COLOR = Color.WHITE;

        /**
         * Default text font.
         */
        public static final String FONT = "Tetris.ttf";
    }

    /**
     * Grid panel constants.
     */
    public static class GridPanel {

        /**
         * Default cell color.
         */
        public static final Color DEFAULT_COLOR = Color.decode("#999999");

        /**
         * Default cell size.
         */
        public static final int CELL_SIZE = 32;

        /**
         * Blink animation time in milliseconds.
         */
        public static final int BLINK_TIME = 7;
    }

    /**
     * Application panel constants.
     */
    public static class ApplicationPanel {

        /**
         * Default padding.
         */
        public static final int PADDING = 20;

        /**
         * Offset to center game over text.
         */
        public static final float HEIGHT_OFFSET = 0.4f;
    }

    /**
     * Message panel constants.
     */
    public static class MessagePanel {

        /**
         * Default interline.
         */
        public static final int INTERLINE = 20;

        /**
         * Game over font size.
         */
        public static final float TITLE_SIZE = 70f;

        /**
         * Exit text font size.
         */
        public static final float SUBTITLE_SIZE = 20f;

    }

    /**
     * Preview panel constants.
     */
    public static class PreviewPanel {

        /**
         * Preview grid columns.
         */
        public static final int GRID_COLS = 5;

        /**
         * Preview grid rows.
         */
        public static final int GRID_ROWS = 4;

        /**
         * Default top padding.
         */
        public static final int PADDING = 100;

        /**
         * Default interline.
         */
        public static final int INTERLINE = 20;

        /**
         * Default font size.
         */
        public static final float FONT_SIZE = 30f;
    }

    /**
     * Score panel constants.
     */
    public static class ScorePanel {

        /**
         * Large font size.
         */
        public static final float FONT_SIZE_L = 40f;

        /**
         * Small font size.
         */
        public static final float FONT_SIZE_S = 20f;

        /**
         * Default interline.
         */
        public static final int INTERLINE = 20;
    }
}
