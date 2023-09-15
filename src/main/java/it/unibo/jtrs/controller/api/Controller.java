package it.unibo.jtrs.controller.api;

import it.unibo.jtrs.view.api.SubPanel;

public interface Controller<X> {
	
	public X update(X data);

	public SubPanel<X> getView();
}
