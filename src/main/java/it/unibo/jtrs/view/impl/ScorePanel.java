package it.unibo.jtrs.view.impl;

import javax.swing.JLabel;

import it.unibo.jtrs.controller.api.Controller;
import it.unibo.jtrs.view.api.SubPanel;

public class ScorePanel extends SubPanel<Integer> {

	JLabel score;

	public ScorePanel(Controller<Integer> controller) {
		super(controller);
		this.score = new JLabel("Punteggio: 0");
	}

	@Override
	public void update() {
		var res = this.controller.update();
		this.score.setText("Punteggio: " + res);
	}
	
}
