package logic.modelstructure.entity.item;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import logic.modelstructure.entity.Entity;

public abstract class Item extends Entity {
    public Item() {
    }
}
