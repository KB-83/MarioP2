package logic.gamelogic.itemlogic;

import logic.gamestrucure.GameState;
import logic.modelstructure.backgroundobject.block.Block;
import logic.modelstructure.backgroundobject.block.CoinBlock;
import logic.modelstructure.backgroundobject.block.EmptyBlock;
import logic.modelstructure.backgroundobject.block.FullCoinBlock;
import logic.modelstructure.entity.item.Coin;
import logic.modelstructure.entity.item.Mushroom;
import logic.modelstructure.entity.item.Star;
import logic.sound.Sound;
import util.Constant;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BlockUnlocker {
    private Timer starTimer;
    private Star star;
    private Timer mushroomTimer;
    private Mushroom mushroom;
    private Timer flowerTimer;
    private long lastBreakTime;
    private Sound sound;
    public BlockUnlocker() {
        setTimers();
        sound = new Sound("BREAK_BLOCK");
    }
    private void setTimers(){
        starTimer = new Timer(3000, new ActionListener() {
            int i = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                i++;
                if (i >= 1) {
                    starTimer.stop();
                    star.setVX(200);
                    star.startJumping();
                }
            }
        });
        mushroomTimer = new Timer(3000, new ActionListener() {
            int i = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                i++;
                if (i>= 1){
                    mushroomTimer.stop();
                    mushroom.setVX(200);
                }

            }
        });
    }
    public void unlock(GameState gameState,Block block, Block[] blocks, int i){
        if (block.getClass() == FullCoinBlock.class){
            unlockFullCoin(gameState,blocks,block,i);
            return;
//            if (System.currentTimeMillis() - lastBreakTime < 500) {
//                return;
//            }
//            lastBreakTime = System.currentTimeMillis();
//            sound.setSound("BREAK_BLOCK");
//            sound.play();
//            gameState.setCoins(gameState.getCoins()+1);
//            ((FullCoinBlock) block).setNumOfCoins(((FullCoinBlock) block).getNumOfCoins() - 1);
//            if (((FullCoinBlock) block).getNumOfCoins() >= 1) {
//                unlockFullCoin(block);
//                return;
//            }
//            else {
//                Block newBlock = new EmptyBlock();
//                newBlock.setRow(block.getRow());
//                newBlock.setCol(block.getCol());
//                blocks[i] = newBlock;
//                return;
//            }
        }
        sound.setSound("BREAK_BLOCK");
        sound.play();
        block.getItem().setLock(false);
        block.getItem().setWorldY((block.getRow() - 1) * Constant.BACKGROUND_TILE_SIZE);
        String s = block.getItem().getClass().getSimpleName();
        switch (s){
            case "Star":
                unlockStar(block);
                break;
            case "Mushroom":
                unlockMushroom(block);
                break;
            case "Flower":
                unlockFlower(block);
                break;
            case "Coin":
                unlockCoin(block);
                break;
        }
//        block.getItem().setVX(200);
        int col = block.getCol();
        int row = block.getRow();
//        block = new SimpleBlock();
//        block.setCol(col);
//        block.setRow(row);
        block.setItem(null);
        Block newBlock = new EmptyBlock();
        newBlock.setRow(row);
        newBlock.setCol(col);
        blocks[i] = newBlock;
    }
    private void unlockStar(Block block) {
        star = (Star) block.getItem();
        starTimer.start();
    }
    private void unlockMushroom(Block block) {
        mushroom = (Mushroom) block.getItem();
        mushroomTimer.start();
    }
    private void unlockFlower(Block block) {}
    private void unlockCoin(Block block) {}
    private void unlockFullCoin(GameState gameState,Block[] blocks,Block block,int i) {
        if (System.currentTimeMillis() - lastBreakTime < 500) {
            return;
        }
        lastBreakTime = System.currentTimeMillis();
        sound.setSound("COIN");
        sound.play();
        gameState.setCoins(gameState.getCoins()+1);
        ((FullCoinBlock) block).setNumOfCoins(((FullCoinBlock) block).getNumOfCoins() - 1);
        if (!(((FullCoinBlock) block).getNumOfCoins() >= 1)) {
            Block newBlock = new EmptyBlock();
            newBlock.setRow(block.getRow());
            newBlock.setCol(block.getCol());
            blocks[i] = newBlock;
            sound.setSound("BREAK_BLOCK");
            sound.play();
        }
    }
}
