package util;

import graphic.GraphicManager;
import logic.LogicManager;

public class Loop implements Runnable{
    private LogicManager lM;
    private GraphicManager gM;
    private Thread gameThread;
    private int FPS;
    private boolean running;
    private boolean isPaused;
//    this int is to test app rendering
    private int tryFps;

    public Loop(LogicManager lM, GraphicManager gM,int FPS) {
        this.lM = lM;
        this.gM = gM;
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
            while (isPaused){}
            currentTime = System.nanoTime();
            delta = (currentTime - lastTime) / drawInterval ;
            if(delta >= 1){
                tryFps++;
//                lM.updateAll();
//                gM.paintAll();
                lastTime = System.nanoTime();
            }
            if (System.nanoTime()-startfPS >= 1000000000){
                startfPS = System.nanoTime();
                tryFps = 0;
            }
        }
    }
}
