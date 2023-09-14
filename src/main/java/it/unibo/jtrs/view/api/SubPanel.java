package it.unibo.jtrs.view.api;

import javax.swing.JPanel;

import it.unibo.jtrs.controller.api.Controller;

public abstract class SubPanel<X> extends JPanel {

	protected Controller<X> controller;

	public SubPanel(Controller<X> controller) {
		this.controller = controller;
	}

	public abstract void update();
}
