import graphic.GraphicManager;
import graphic.guigamestructure.Camera;
import graphic.guigamestructure.GuiGameCreator;
import graphic.panel.Frame;
import logic.gamestrucure.GameState;
import logic.levelstructure.Section;
import logic.modelstructure.entity.player.Mario;
import logic.modelstructure.worldtiles.BackgroundMap;


public class TestMain {
    public static void main(String[] args) {
        GameState gameState =  GameState.getGameState();
        BackgroundMap backgroundMap = new BackgroundMap(1,1,26* 4,15);
        gameState.setPlayer(new Mario(0,0));
        gameState.setCurrentSection(new Section());
        gameState.getCurrentSection().setBackgroundMap(backgroundMap);
//        System.out.println("here");
        GuiGameCreator guiGameCreator = new GuiGameCreator();
        Camera.getCamera().setGuiGameState(guiGameCreator.createGameState(gameState));
        Frame frame = new Frame(new GraphicManager());
        Camera.getCamera().setGamePanel(frame.getPanelsManagerCard().getGamePanel());
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }



    }

}
