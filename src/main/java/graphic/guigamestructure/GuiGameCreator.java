package graphic.guigamestructure;

import graphic.guibackgroundobject.guiblock.*;
import graphic.guibackgroundobject.guipipe.*;
import graphic.guibackgroundobject.guiworldtiles.GuiBackgroundMap;
import graphic.guientity.guienemy.*;
import graphic.guientity.guiplayer.GuiMario;
import graphic.guientity.guiplayer.GuiPlayer;
import graphic.guilevelstructure.GuiLevel;
import graphic.guilevelstructure.GuiSection;
import logic.gamestrucure.GameState;
import logic.levelstructure.Level;
import logic.levelstructure.Section;
import logic.modelstructure.backgroundobject.block.Block;
import logic.modelstructure.backgroundobject.block.SimpleBlock;
import logic.modelstructure.backgroundobject.pipe.Pipe;
import logic.modelstructure.backgroundobject.pipe.SimplePipe;
import logic.modelstructure.entity.enemy.Enemy;
import logic.modelstructure.entity.enemy.Goomba;
import logic.modelstructure.entity.player.Player;
import logic.modelstructure.worldtiles.BackgroundMap;


public class GuiGameCreator {
    private GuiGameCreator(){}
    public static GuiGameState createGameState (GameState gameState,GuiGameState guiGameState) {
        if (guiGameState == null) {
            guiGameState = new GuiGameState();
        }
        guiGameState.setCoins(gameState.getCoins());
        guiGameState.setPaused(gameState.isPaused());
        guiGameState.setLevelNumber(gameState.getLevelNumber());
        guiGameState.setSectionNumber(gameState.getSectionNumber());
        guiGameState.setScore(gameState.getScore());
        guiGameState.setRemainingHeart(gameState.getRemainingHeart());
        guiGameState.setRemainingTime(gameState.getRemainingTime());
//        guiGameState.setCurrentGuiLevel(createGuiLevel(gameState.getCurrentLevel()));
        guiGameState.setCurrentGuiSection(createGuiSection(gameState.getCurrentSection(),
                guiGameState.getCurrentGuiSection()));
        guiGameState.setGuiPlayer(createGuiPlayer(gameState.getPlayer(),guiGameState.getGuiPlayer()));

        return guiGameState;
    }
    public void updateGuiGameState(GameState gameState) {
    }
    private static GuiPlayer createGuiPlayer(Player player,GuiPlayer guiPlayer){
        if (guiPlayer == null) {
            guiPlayer = new GuiMario();// todo : let player to be mario luigi or etc...
        }
        guiPlayer.setCurrentImage((((GuiMario) guiPlayer).getImageByItsAddress(player.getImageAddress())));
        guiPlayer.setCameraX(player.getCameraX());
        guiPlayer.setCameraY(player.getCameraY());
        guiPlayer.setWorldX(player.getWorldX());
        guiPlayer.setWorldY(player.getWorldY());
        return guiPlayer;
    }
    private static GuiLevel createGuiLevel(Level level,GuiLevel guiLevel,GuiSection guiSection[]){
        if (guiLevel == null) {
            guiLevel = new GuiLevel();
        }
        if (guiSection == null) {
            guiSection = new GuiSection[level.getSections().length];
        }
        int i = 0;
//        for (Section section : level.getSections()){
//            guiSection[i] = createGuiSection(section);
//            i++;
//        }
        guiLevel.setGuiSections(guiSection);
        return guiLevel;
    }
    private static GuiSection createGuiSection(Section section,GuiSection guiSection){
        if (guiSection == null) {
            guiSection = new GuiSection();
        }
//        guiSection.setTime(section.getTime());
//        guiSection.setLength(section.getLength());
        guiSection.setGuiEnemies(createGuiEnemies(section.getEnemies()));
        guiSection.setGuiBlocks(createGuiBlocks(section.getBlocks()));
        guiSection.setGuiPipes(createGuiPipes(section.getPipes()));
        guiSection.setGuiBackgroundMap(createGuiBackgroundMap(section.getBackgroundMap()));// todo : maybe it has to be diffrent in gui part
        return guiSection;
    }

//    public static GuiGameState updateGameState(GameState gameState, GuiGameState guiGameState){
//        //todo : what things do have to be updated here? ==> player, section,level enemies blocks
//        // todo : ok what is the diffrence with GuiGameCreator? it doesnt initialize a new object 60 time per second
//        // todo : oh it is a huge diffrence but wouldnt it make duplicated code?
//        // // todo :yes you can handel it there with a null
//        return guiGameState;
//    }
    private static GuiBlock[] createGuiBlocks(Block[] blocks){
        GuiBlock[] guiBlocks = new GuiBlock[blocks.length];
        int index = 0;
        for (Block block: blocks){
            String s = block.getClass().getSimpleName().toUpperCase();
            GuiBlock guiBlock = null;
            switch (s){
                case "SIMPLEBLOCK":
                    guiBlock = new GuiSimpleBlock();
                    break;
                case "COINBLOCK":
                    guiBlock = new GuiCoinBlock();
                    break;
                case "FULLCOINBLOCK":
                    guiBlock = new GuiFullCoinBlock();
                    break;
                case "EMPTYBLOCK":
                    guiBlock = new GuiEmptyBlock();
                    break;
                case "QUESTIONBLOCK":
                    guiBlock = new GuiQuestionBlock();
                    break;
                case "SLIMEBLOCK":
                    guiBlock = new GuiSlimeBlock();
                    break;
                    //todo: make it alright
                case "FIREBARBLOCK":
                    guiBlock = new GuiCoinBlock();
                    break;
            }
            guiBlock.setCurrentImage(guiBlock.getImageByItsAddress("Block"));
            guiBlock.setWorldX(block.getX());
            guiBlock.setWorldY(block.getY());
            guiBlocks[index] = guiBlock;
            index++;

        }
        return guiBlocks;
    }
    private static GuiEnemy[] createGuiEnemies(Enemy[] enemies){
        GuiEnemy[] guiEnemies = new GuiEnemy[enemies.length];
        int index= 0;
        for (Enemy enemy: enemies) {
            String s = enemy.getClass().getSimpleName().toUpperCase();
            GuiEnemy guiEnemy = null;
            switch (s){
                case"GOOMBA" :
                    guiEnemy = new GuiGoomba();
                    break;
                case"KOOPA" :
                    guiEnemy = new GuiKoopa();
                    break;
                case"PLANT" :
                    guiEnemy = new GuiPlant();
                    break;
                case"NUKEBIRD" :
                    guiEnemy = new GuiNukeBird();
                    break;
                case"SPINY" :
                    guiEnemy = new GuiSpiny();
                    break;
                case"BOWSER" :
                    guiEnemy = new GuiBowser();
                    break;
            }
            guiEnemy.setCurrentImage(guiEnemy.getImageByItsAddress("Right"));
            guiEnemy.setWorldX(enemy.getX());
            guiEnemy.setWorldY(enemy.getY());
            guiEnemies[index] = guiEnemy;
            index++;
        }
        return guiEnemies;
    }
    private static GuiPipe[] createGuiPipes(Pipe[] pipes){
        GuiPipe[] guiPipes = new GuiPipe[pipes.length];
        int index = 0;
        for (Pipe pipe: pipes){
            String s = pipe.getClass().getSimpleName().toUpperCase();
            GuiPipe guiPipe = null;
            switch (s){
                case "SIMPLEPIPE":
                    guiPipe = new GuiSimplePipe();
                    break;
                case "SIMPLEPLANTPIPE":
                    guiPipe = new GuiSimplePlantPipe();
                    break;
                case "SIMPLETELEPIPE":
                    guiPipe = new GuiSimpleTelePipe();
                    break;
                case "TELEPLANTPIPE":
                    guiPipe = new GuiTelePlantPipe();
                    break;
                case "DECEITPIPE":
                    guiPipe = new GuiDeceitPipe();
                    break;

            }
            guiPipe.setCurrentImage(guiPipe.getImageByItsAddress("PipeB"));
            guiPipe.setWorldX(pipe.getX());
            guiPipe.setWorldY(pipe.getY());
            guiPipes[index] = guiPipe;
            index++;

        }
        return guiPipes;
    }
    private static GuiBackgroundMap createGuiBackgroundMap(BackgroundMap backgroundMap){
        GuiBackgroundMap guiBackgroundMap = new GuiBackgroundMap();
        guiBackgroundMap.setBackGroundTiles(backgroundMap.getBackGroundTiles());
        return guiBackgroundMap;
    }

}
