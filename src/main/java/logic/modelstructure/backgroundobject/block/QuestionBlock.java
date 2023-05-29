package logic.modelstructure.backgroundobject.block;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import logic.modelstructure.entity.item.Coin;
import logic.modelstructure.entity.item.Item;

public class QuestionBlock extends Block{
//    @JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "item")
//    @JsonSubTypes({
//            @JsonSubTypes.Type(value = Coin.class, name = "STAR"),
//            // other subtypes
//    })
    private Item item;

    public QuestionBlock() {

    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
