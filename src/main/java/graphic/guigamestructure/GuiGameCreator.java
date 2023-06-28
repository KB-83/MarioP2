package graphic.guigamestructure;

import graphic.guibackgroundobject.GuiCheckPoint;
import graphic.guibackgroundobject.guiblock.*;
import graphic.guibackgroundobject.guipipe.*;
import graphic.guibackgroundobject.guiworldtiles.GuiBackgroundMap;
import graphic.guibackgroundobject.guiworldtiles.GuiBackgroundTile;
import graphic.guientity.guienemy.*;
import graphic.guientity.guiitem.*;
import graphic.guientity.guiplayer.GuiMario;
import graphic.guientity.guiplayer.GuiPlayer;
import graphic.guilevelstructure.GuiLevel;
import graphic.guilevelstructure.GuiSection;
import logic.gamestrucure.GameState;
import logic.levelstructure.Level;
import logic.levelstructure.Section;
import logic.modelstructure.backgroundobject.CheckPoint;
import logic.modelstructure.backgroundobject.block.Block;
import logic.modelstructure.backgroundobject.pipe.*;
import logic.modelstructure.entity.enemy.Enemy;
import logic.modelstructure.entity.item.Item;
import logic.modelstructure.entity.player.Player;
import logic.modelstructure.worldtiles.BackgroundMap;
import util.Constant;


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
        //todo : do that for render
    }
    private static GuiCheckPoint createCheckPoint(CheckPoint checkPoint) {
        if (checkPoint == null){
            return  null;
        }
        GuiCheckPoint guiCheckPoint = new GuiCheckPoint();
        guiCheckPoint.setWorldX(checkPoint.getCol() * Constant.BACKGROUND_TILE_SIZE);
        guiCheckPoint.setWorldY(checkPoint.getRow() * Constant.BACKGROUND_TILE_SIZE);
        guiCheckPoint.setWidth(Constant.BACKGROUND_TILE_SIZE);
        guiCheckPoint.setHeight(Constant.BACKGROUND_TILE_SIZE);
        guiCheckPoint.setCurrentImage(guiCheckPoint.getImageByItsAddress("checkPoint"));
        return guiCheckPoint;
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
        guiPlayer.setWidth(player.getWidth());
        guiPlayer.setHeight(player.getHeight());
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
        //todo : isnt it better to change theme if nessesary?
//        System.out.println("99 gui game creator" + section.getCheckPoint().getCol());
        guiSection.setLength(section.getLength());
        guiSection.setGuiCheckPoint(createCheckPoint(section.getCheckPoint()));
        guiSection.setGuiEnemies(createGuiEnemies(section.getEnemies()));
        guiSection.setGuiBlocks(createGuiBlocks(section.getBlocks()));
        guiSection.setGuiPipes(createGuiPipes(section.getPipes()));
        guiSection.setGuiItems(createGuiItems(section.getItems()));
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
            guiBlock.setWorldX(block.getCol());
            guiBlock.setWorldY(block.getRow());
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
            guiEnemy.setWorldX(enemy.getWorldX());
            guiEnemy.setWorldY(enemy.getWorldY());
            guiEnemies[index] = guiEnemy;
            index++;
        }
        return guiEnemies;
    }
        private static GuiItem[] createGuiItems(Item[] items){
        if (items == null){
            return null;
        }
        int guiItemsSize = 0;
        for (Item item : items) {
            if (item.isLock()){
                continue;
            }
            guiItemsSize++;
        }
        if (guiItemsSize == 0) {
            return null;
        }
        GuiItem[] guiItems = new GuiItem[guiItemsSize];
        int index = 0;
        for (Item item: items){
            if (item.isLock()){
                continue;
            }
            String s = item.getClass().getSimpleName().toUpperCase();
            GuiItem guiItem = null;
            switch (s) {
                case "STAR":
                    guiItem = new GuiStar();
                    break;

                case "COIN":
                    guiItem = new GuiCoin();
                    break;

                case "MUSHROOM":
                    guiItem = new GuiMushroom();
                    break;
                case "FLOWER":
                    guiItem = new GuiFlower();
                    break;
            }
            guiItem.setCurrentImage(guiItem.getImageByItsAddress("1"));
            guiItem.setWorldX(item.getWorldX());
            guiItem.setWorldY(item.getWorldY());
            guiItems[index] = guiItem;
            index++;

        }
        return guiItems;
    }
    private static GuiPipe[] createGuiPipes(Pipe[] pipes){
        if (pipes == null){
            return null;
        }
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
                    GuiPlant guiPlant = new GuiPlant();
                    guiPlant.setWorldX(((SimplePlantPipe)pipe).getPlant().getWorldX());
                    guiPlant.setWorldY(((SimplePlantPipe)pipe).getPlant().getWorldY());
                    guiPlant.setCurrentImage(guiPlant.getImageByItsAddress("Plant"));
                    ((GuiSimplePlantPipe) guiPipe).setGuiPlant(guiPlant);

                    break;
                case "SIMPLETELEPIPE":
                    guiPipe = new GuiSimpleTelePipe();
                    break;
                case "TELEPLANTPIPE":
                    guiPipe = new GuiTelePlantPipe();
                    guiPlant = new GuiPlant();
                    guiPlant.setWorldX(((TelePlantPipe)pipe).getPlant().getWorldX());
                    guiPlant.setWorldY(((TelePlantPipe)pipe).getPlant().getWorldY());
                    guiPlant.setCurrentImage(guiPlant.getImageByItsAddress("Plant"));
                    ((GuiTelePlantPipe)guiPipe).setGuiPlant(guiPlant);
                    break;
                case "DECEITPIPE":
                    guiPipe = new GuiDeceitPipe();
                    break;
                case "SIMPLESPAWNPIPE":
                    guiPipe = new GuiSpawnPipe();
                    break;
                case "SPAWNPLANTPIPE" :
                    guiPipe = new GuiSpawnPlantPipe();
                    guiPlant = new GuiPlant();
                    guiPlant.setWorldX(((SpawnPlantPipe)pipe).getPlant().getWorldX());
                    guiPlant.setWorldY(((SpawnPlantPipe)pipe).getPlant().getWorldY());
                    guiPlant.setCurrentImage(guiPlant.getImageByItsAddress("Plant"));
                    ((GuiSpawnPlantPipe)guiPipe).setGuiPlant(guiPlant);
                    break;

            }
            guiPipe.setCurrentImage(guiPipe.getImageByItsAddress("PipeB"));
            guiPipe.setWorldX(pipe.getCol());
            guiPipe.setWorldY(pipe.getRow());
            guiPipes[index] = guiPipe;
            index++;

        }
        return guiPipes;
    }
    private static GuiBackgroundMap createGuiBackgroundMap(BackgroundMap backgroundMap){
        //todo : why is it updating all the time?
        GuiBackgroundMap guiBackgroundMap = new GuiBackgroundMap();
        GuiBackgroundTile[][] guiBackgroundTiles = new GuiBackgroundTile[backgroundMap.getBackGroundTiles().length]
                [backgroundMap.getBackGroundTiles()[0].length];
        for (int i = 0;i < backgroundMap.getBackGroundTiles().length; i++) {
            for (int j = 0; j < backgroundMap.getBackGroundTiles()[i].length;j++) {
                GuiBackgroundTile guiBackgroundTile = new GuiBackgroundTile(i,j,backgroundMap.getBackGroundTiles()[i][j].getNum());
                guiBackgroundTiles[i][j] = guiBackgroundTile;
            }
        }
        guiBackgroundMap.setGuiBackGroundTiles(guiBackgroundTiles);
        return guiBackgroundMap;
    }

}
