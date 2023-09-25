package it.unibo.jtrs.view.impl;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JLabel;

import it.unibo.jtrs.view.api.GenericPanel;
import it.unibo.jtrs.view.custom.Constants;
import it.unibo.jtrs.view.custom.Label;

/**
 * A class modelling a message panel. This panel consists of a title
 * and a subtitle, both centered vertically and offsetted from the top
 * border.
 */
public class MessagePanel extends GenericPanel {

    public static final long serialVersionUID = 4328743;

    /**
     * Constructor.
     *
     * @param t1 title
     * @param t2 subtitle
     * @param offset the top offset
     */
    public MessagePanel(final String t1, final String t2, final int offset) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(Box.createVerticalStrut(offset));
        this.setOpaque(false);

        final JLabel l1 = new Label(t1, Constants.MessagePanel.TITLE_SIZE);
        l1.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        this.add(l1);
        this.add(Box.createVerticalStrut(Constants.MessagePanel.INTERLINE));

        final JLabel l2 = new Label(t2, Constants.MessagePanel.SUBTITLE_SIZE);
        l2.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        this.add(l2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void redraw() { }

}
