package it.unibo.jtrs.controller.api;

import it.unibo.jtrs.view.api.SubPanel;

public abstract class Controller {

	protected SubPanel view;
	
	public abstract <X> X getStatus();

	public SubPanel getView() {
		return this.view;
	}
}
