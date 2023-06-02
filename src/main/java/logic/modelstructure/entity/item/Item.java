package logic.modelstructure.entity.item;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import logic.modelstructure.entity.Entity;

//@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.WRAPPER_ARRAY)
//@JsonSubTypes({
//        @JsonSubTypes.Type(value = Bullet.class, name = "BULLET"),
//        @JsonSubTypes.Type(value = Coin.class, name = "COIN"),
//        @JsonSubTypes.Type(value = Flower.class, name = "FLOWER"),
//        @JsonSubTypes.Type(value = Mushroom.class, name ="MUSHROOM"),
//        @JsonSubTypes.Type(value = Star.class, name = "STAR"),
//        @JsonSubTypes.Type(value = Sward.class, name = "SWARD")
//        ///
//})
public abstract class Item extends Entity {
    public Item() {
    }
}
