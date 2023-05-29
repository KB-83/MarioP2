package graphic.guigamestructure;

import graphic.guientity.guiplayer.GuiPlayer;
import graphic.guilevelstructure.GuiLevel;
import graphic.guilevelstructure.GuiSection;
import logic.gamestrucure.GameState;
import logic.levelstructure.Level;
import logic.levelstructure.Section;
import logic.modelstructure.entity.player.Player;

public class GuiGameCreator {
    public static GuiGameState CreateGameState (GameState gameState) {
        GuiGameState guiGameState = new GuiGameState();
        guiGameState.setCoins(gameState.getCoins());
        guiGameState.setPaused(gameState.isPaused());
        guiGameState.setLevelNumber(gameState.getLevelNumber());
        guiGameState.setSectionNumber(gameState.getSectionNumber());
        guiGameState.setScore(gameState.getScore());
        guiGameState.setRemainingHeart(gameState.getRemainingHeart());
        guiGameState.setRemainingTime(gameState.getRemainingTime());
        guiGameState.setCurrentGuiLevel(createGuiLevel(gameState.getCurrentLevel()));
        guiGameState.setCurrentGuiSection(createGuiSection(gameState.getCurrentSection()));
        guiGameState.setGuiplayer(createGuiPlayer(gameState.getPlayer()));
        return guiGameState;
    }
    private static GuiPlayer createGuiPlayer(Player player){
        return null;
    }
    private static GuiLevel createGuiLevel(Level level){
        return null;
    }
    private static GuiSection createGuiSection(Section section){
        return null;
    }
}
