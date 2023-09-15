package it.unibo.jtrs.controller.api;

public interface Application {

    public void update();

    public void redraw();

    public Controller getScoreController();

    public Controller getPreviewController();

    public Controller getGameController();
}
