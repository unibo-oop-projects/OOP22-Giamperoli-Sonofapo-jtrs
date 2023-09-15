package it.unibo.jtrs.controller.impl;

import it.unibo.jtrs.controller.api.Controller;
import it.unibo.jtrs.model.api.Model;
import it.unibo.jtrs.model.api.Tetromino;
import it.unibo.jtrs.model.impl.PreviewModel;
import it.unibo.jtrs.view.api.SubPanel;
import it.unibo.jtrs.view.impl.PreviewPanel;

public class PreviewController implements Controller<Tetromino> {

	private final Model<Tetromino> model;
	private final SubPanel<Tetromino> view;

	public PreviewController() {
		this.model = new PreviewModel();
		this.view = new PreviewPanel(this);
	}

	@Override
	public Tetromino update(Tetromino data) {
		return model.get();
	}

	@Override
	public SubPanel<Tetromino> getView() {
		return this.view;
	}
	
}
