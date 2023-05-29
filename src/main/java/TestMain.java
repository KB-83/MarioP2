import graphic.GraphicManager;
import graphic.guigamestructure.Camera;
import graphic.panel.Frame;


public class TestMain {
    public static void main(String[] args) {
//        GameState gameState = new GameState();
//        gameState.setPlayer(new Mario(0,0));
////        System.out.println("here");
//        Camera.getCamera().setGameState(gameState);
        Frame frame = new Frame(new GraphicManager());
        Camera.getCamera().setGamePanel(frame.getPanelsManagerCard().getGamePanel());
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }



    }

}
