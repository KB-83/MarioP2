package logic.gamelogic.itemlogic;

import logic.modelstructure.backgroundobject.block.Block;
import logic.modelstructure.backgroundobject.block.EmptyBlock;
import logic.modelstructure.backgroundobject.block.SimpleBlock;
import logic.modelstructure.entity.item.Item;
import util.Constant;

public class ItemUnlocker {
    public void unlock(Block block,Block[] blocks, int i){
        block.getItem().setLock(false);
        block.getItem().setWorldY((block.getRow() - 1) * Constant.BACKGROUND_TILE_SIZE);
        block.getItem().setVX(400);
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
        System.out.println("5 itemunlocker trying to unlock");
    }
}
