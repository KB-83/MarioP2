package graphic.panel;

import graphic.guigamestructure.Camera;
import graphic.guigamestructure.GuiGameState;
import graphic.requestlistener.PlayerListener;
import logic.gamestrucure.GameState;
import logic.requsethandler.PlayerRequestHandler;
import util.Loop;

import java.awt.*;


public class GamePanel extends MarioPanel {
    private PanelsManagerCard cardPanel;
    private Graphics2D g2;
    private GuiGameState guiGameState;
    private Camera camera;
    private GameHUI gameHUI;
    private Loop gameloop;

    public GamePanel(PanelsManagerCard cardPanel) {

        this.cardPanel = cardPanel;
        this.camera = new Camera();
        this.gameHUI = new GameHUI();
        setFocusable(true);
    }

    @Override
    public void setDependencies() {

    }

    @Override
    public void loadConfig() {

    }

    public GuiGameState getGuiGameState() {
        return guiGameState;
    }

    public void setGuiGameState(GuiGameState guiGameState) {
        this.guiGameState = guiGameState;
        camera.setGuiGameState(guiGameState);
        gameHUI.setGuiGameState(guiGameState);
    }

    public Camera getCamera() {
        return camera;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }
    public void setKeyListener(GameState gameState) {
        addKeyListener(new PlayerListener(new PlayerRequestHandler(gameState)));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g2 = (Graphics2D) g;
        if (camera.getGuiGameState() != null) {
            camera.paintCamera(g2);
            gameHUI.paintHui(g2);
        }
    }

}
