package logic.modelstructure.backgroundobject.block;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import logic.modelstructure.entity.item.*;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = CoinBlock.class, name = "COIN"),
        @JsonSubTypes.Type(value = EmptyBlock.class, name = "EMPTY"),
        @JsonSubTypes.Type(value = FullCoinBlock.class, name = "COINS"),
        @JsonSubTypes.Type(value = QuestionBlock.class, name = "QUESTION"),
        @JsonSubTypes.Type(value = SimpleBlock.class, name = "SIMPLE"),
        @JsonSubTypes.Type(value = SlimeBlock.class, name = "SLIME"),
        //FIREBAR

})

public abstract class Block {
    private int x;
    private int y;
    private Item item;

//    میتونید تو سوپرکلس بذارید و یه مقدار دیفالت یا نال بدید و اگه تو ساب کلس مقدارش داده شد تو کانستراکتور، تغییر داده بشه
//    یا میتونید کانستراکتور های متفاوتی داشته باشید

    public Block() {
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
