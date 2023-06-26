package logic.modelstructure.entity.item;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import logic.gamelogic.collisionlogic.ItemCollisionHandler;
import logic.modelstructure.entity.Entity;

public abstract class Item extends Entity {
    @JsonIgnore
    private boolean isLock;
    @JsonIgnore
    private ItemCollisionHandler itemCollisionHandler;
    public Item() {
        isLock = true;
        setOnTopOfBlock(true);
        itemCollisionHandler = new ItemCollisionHandler(this);
    }

    public boolean isLock() {
        return isLock;
    }

    public void setLock(boolean lock) {
        isLock = lock;
    }

    public ItemCollisionHandler getItemCollisionHandler() {
        return itemCollisionHandler;
    }

    public void setItemCollisionHandler(ItemCollisionHandler itemCollisionHandler) {
        this.itemCollisionHandler = itemCollisionHandler;
    }
}
