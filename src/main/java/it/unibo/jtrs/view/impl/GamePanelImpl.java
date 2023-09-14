package it.unibo.jtrs.view.impl;

import java.awt.Dimension;
import javax.swing.JPanel;
import it.unibo.jtrs.view.api.GamePanel;

public class GamePanelImpl extends JPanel implements GamePanel {

    public GamePanelImpl(final int width, final int height) {
        setPreferredSize(new Dimension(width, height));
    }

    @Override
    public void redraw() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'redraw'");
    }
    
}
