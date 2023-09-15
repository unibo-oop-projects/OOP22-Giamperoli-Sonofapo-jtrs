package it.unibo.jtrs.view.api;

import javax.swing.JPanel;

import it.unibo.jtrs.controller.api.Controller;

public abstract class SubPanel extends JPanel {

	protected Controller controller;

	public SubPanel(Controller controller) {
		this.controller = controller;
	}

	public abstract void update();
}
