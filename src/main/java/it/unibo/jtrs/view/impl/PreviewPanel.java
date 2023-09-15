package it.unibo.jtrs.view.impl;

import static it.unibo.jtrs.utils.Constants.PREVIEW_ROWS;
import static it.unibo.jtrs.utils.Constants.PREVIEW_COLS;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JLabel;

import it.unibo.jtrs.controller.api.Controller;
import it.unibo.jtrs.model.api.Tetromino;
import it.unibo.jtrs.utils.Pair;
import it.unibo.jtrs.view.api.SubPanel;

public class PreviewPanel extends SubPanel<Tetromino> {

	Map<Pair<Integer, Integer>, JLabel> cells = new HashMap<>();

	public PreviewPanel(Controller<Tetromino> controller) {
		super(controller);

		this.setLayout(new GridLayout(PREVIEW_ROWS, PREVIEW_COLS));
		this.initalize();
		this.update();
		this.setVisible(true);
	}

	@Override
	public void update() {
		Tetromino t = this.controller.update(null);
		Color color = Color.decode(t.getColor());
		this.cells.forEach((k, v) -> {
			v.setBackground(t.getComponents().contains(k) ? color : Color.GRAY);
		});
	}

	private void initalize() {
		for (int x = 0; x < PREVIEW_ROWS; x++) {
			for (int y = 0; y < PREVIEW_COLS; y++) {
				var lbl = new JLabel();
				lbl.setOpaque(true);
				this.add(lbl);
				this.cells.put(new Pair<>(y, x), lbl);
			}
		}
	}
	
}
