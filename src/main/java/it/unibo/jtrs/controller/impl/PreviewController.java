package it.unibo.jtrs.controller.impl;

import it.unibo.jtrs.controller.api.Controller;
import it.unibo.jtrs.model.api.Tetromino;
import it.unibo.jtrs.model.impl.PreviewModel;
import it.unibo.jtrs.view.api.SubPanel;
import it.unibo.jtrs.view.impl.PreviewPanel;

public class PreviewController extends Controller {

	private final PreviewModel model;
	private final SubPanel view;

	public PreviewController() {
		this.model = new PreviewModel();
		this.view = new PreviewPanel(this);
	}

	@Override
	public SubPanel getView() {
		return this.view;
	}

	@Override
	@SuppressWarnings("unchecked")
	public Tetromino getStatus() {
		return this.model.next();
	}
	
}
