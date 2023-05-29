package graphic.panel;

import graphic.guigamestructure.Camera;
import graphic.requestlistener.PlayerListener;
import logic.gamestrucure.GameState;
import logic.levelstructure.Level;
import logic.levelstructure.Section;
import logic.modelstructure.entity.enemy.Enemy;

import logic.modelstructure.entity.enemy.Goomba;
import logic.requsethandler.PlayerRequestHandler;

import java.awt.*;


public class GamePanel extends MarioPanel {
    private PanelsManagerCard cardPanel;
    private Graphics2D g2;

    public GamePanel(PanelsManagerCard cardPanel) {

        this.cardPanel = cardPanel;
        // todo they are all test from 24 - 32
        addKeyListener(new PlayerListener(new PlayerRequestHandler()));
        setFocusable(true);
//        GameState gameState = new GameState();
//        gameState.setCurrentLevel(new Level());
//        gameState.setCurrentSection(new Section());
//        Enemy[] enemies = {new Goomba()};
//        gameState.getCurrentSection().setEnemies(enemies);
//        Camera.getCamera().setGameState(gameState);
//        repaint();
//        camera.paintCamera(g2);

    }

    @Override
    public void setDependencies() {

    }

    @Override
    public void loadConfig() {

    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g2 = (Graphics2D) g;
        System.out.println("here repainting game panel 51");
        Camera.getCamera().paintCamera(g2);
}

}
