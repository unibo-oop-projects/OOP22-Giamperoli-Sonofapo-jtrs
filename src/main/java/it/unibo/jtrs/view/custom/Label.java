package it.unibo.jtrs.view.custom;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;

import javax.swing.JLabel;

import it.unibo.jtrs.utils.ResourceLoader;

/**
 * Class that model a custom JLabel. This label can have a custom font
 * and foreground color.
 */
public class Label extends JLabel {

    public static final long serialVersionUID = 4328743;

    /**
     * Constructor.
     *
     * @param value the text for this label
     * @param font the label's font
     * @param size the font size
     * @param foreground the foreground color of the text
     */
    public Label(final String value, final String font, final float size, final Color foreground) {
        super(value);

        this.setFont(this.loadFont(font, size));
        this.setForeground(foreground);
    }

    private Font loadFont(final String name, final float size) {
        try {
            return Font
                .createFont(Font.TRUETYPE_FONT, ResourceLoader.load(name))
                .deriveFont(size);
        } catch (FontFormatException | IOException e) {
            return super.getFont();
        }
    }

}
