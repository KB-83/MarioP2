package util;

import graphic.GraphicManager;
import graphic.guigamestructure.GuiGameCreator;
import graphic.panel.GamePanel;
import logic.LogicManager;
import logic.gamestrucure.GameState;

public class Loop implements Runnable{
    private GameState gameState;// to update
    private GamePanel gamePanel;// to repaint
    private Thread gameThread;
    private int FPS;
    private boolean running;
    private boolean isPaused;
//    this int is to test app rendering
    private int tryFps;

    public Loop(GameState gameState,GamePanel gamePanel,int FPS) {
        this.gamePanel = gamePanel;
        this.gameState = gameState;
        this.FPS = FPS;
    }

    public void start(){
        if(gameThread == null) {
            gameThread = new Thread(this);
        }
        running = true;
        gameThread.start();
    }

    public void kill() {
        running = false;
        gameThread = null;
    }
    public void pause() {
        isPaused = true;
    }
    public void resume() {
        isPaused = false;
    }

    public void run() {
        final long drawInterval = 1000000000/FPS;
        long lastTime = System.nanoTime();
        long startfPS = System.nanoTime();
        long delta = 0;
        long currentTime;
        while (running){
            // sorry but it is the best i can design fo pause mechanisem :(
            while (gameState.isPaused()){}
            currentTime = System.nanoTime();
            delta = (currentTime - lastTime) / drawInterval ;
            if(delta >= 1){
                tryFps++;
//                gameState.update
                gamePanel.setGuiGameState(GuiGameCreator.createGameState(gameState,gamePanel.getGuiGameState()));
                System.out.println(gamePanel.getGuiGameState()+"-----loop59");
                gamePanel.repaint();
                lastTime = System.nanoTime();
            }
            if (System.nanoTime()-startfPS >= 1000000000){
                startfPS = System.nanoTime();
                tryFps = 0;
            }
        }
    }
}
