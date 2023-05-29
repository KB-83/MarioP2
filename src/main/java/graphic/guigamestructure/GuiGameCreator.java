package graphic.guigamestructure;

import graphic.guibackgroundobject.guiblock.GuiBlock;
import graphic.guibackgroundobject.guipipe.GuiPipe;
import graphic.guibackgroundobject.guiworldtiles.GuiBackgroundMap;
import graphic.guientity.guienemy.GuiEnemy;
import graphic.guientity.guiplayer.GuiPlayer;
import graphic.guilevelstructure.GuiLevel;
import graphic.guilevelstructure.GuiSection;
import logic.gamestrucure.GameState;
import logic.levelstructure.Level;
import logic.levelstructure.Section;
import logic.modelstructure.backgroundobject.block.Block;
import logic.modelstructure.backgroundobject.pipe.Pipe;
import logic.modelstructure.entity.enemy.Enemy;
import logic.modelstructure.entity.player.Player;
import logic.modelstructure.worldtiles.BackgroundMap;

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
//        guiGameState.setCurrentGuiLevel(createGuiLevel(gameState.getCurrentLevel()));
        guiGameState.setCurrentGuiSection(createGuiSection(gameState.getCurrentSection()));
        guiGameState.setGuiplayer(createGuiPlayer(gameState.getPlayer()));
        return guiGameState;
    }
    private static GuiPlayer createGuiPlayer(Player player){
        return null;
    }
    private static GuiLevel createGuiLevel(Level level){
        GuiLevel guiLevel = new GuiLevel();
        GuiSection[] guiSection = new GuiSection[level.getSections().length];
        int i = 0;
        for (Section section : level.getSections()){
            guiSection[i] = createGuiSection(section);
            i++;
        }
        guiLevel.setGuiSections(guiSection);
        return guiLevel;
    }
    private static GuiSection createGuiSection(Section section){
        GuiSection guiSection = new GuiSection();
//        guiSection.setTime(section.getTime());
//        guiSection.setLength(section.getLength());
//        guiSection.setGuiEnemies(createGuiEnemies(section.getEnemies()));
//        guiSection.setGuiBlocks(createGuiBlocks(section.getBlocks()));
//        guiSection.setGuiPipes(createGuiPipes(section.getPipes()));
        guiSection.setGuiBackgroundMap(createGuiBackgroundMap(section.getBackgroundMap()));// todo : maybe it has to be diffrent in gui part
        return guiSection;
    }
    private static GuiBlock[] createGuiBlocks(Block[] blocks){
        return null;
    }
    private static GuiEnemy[] createGuiEnemies(Enemy[] enemies){
        return null;
    }
    private static GuiPipe[] createGuiPipes(Pipe[] pipes){
        return null;
    }
    private static GuiBackgroundMap createGuiBackgroundMap(BackgroundMap backgroundMap){
        GuiBackgroundMap guiBackgroundMap = new GuiBackgroundMap();
        guiBackgroundMap.setBackGroundTiles(backgroundMap.getBackGroundTiles());
        return guiBackgroundMap;
    }
}
