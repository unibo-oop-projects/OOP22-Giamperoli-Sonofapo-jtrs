package it.unibo.jtrs.view.impl;

import javax.swing.JLabel;

import it.unibo.jtrs.controller.impl.ScoreController;
import it.unibo.jtrs.utils.Pair;
import it.unibo.jtrs.view.api.SubPanel;

public class ScorePanel extends SubPanel {

	private final JLabel score;
	private final JLabel level;

	public ScorePanel(ScoreController controller) {
		super(controller);
		this.level = new JLabel("Livello: 0");
		this.score = new JLabel("Punteggio: 0");
		this.add(this.level);
		this.add(this.score);
	}

	@Override
	public void update() {
		Pair<Integer, Integer> res = this.controller.getStatus();
		this.level.setText("Livello: " + res.getX());
		this.score.setText("Punteggio: " + res.getY());
	}
	
}
