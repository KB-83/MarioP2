package logic.modelstructure.entity.enemy;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import logic.modelstructure.entity.Entity;


@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Goomba.class, name = "GOOMBA"),
        @JsonSubTypes.Type(value = Koopa.class, name = "KOOPA"),
        @JsonSubTypes.Type(value = Spiny.class, name = "SPINY"),
        @JsonSubTypes.Type(value = NukeBird.class, name ="NUKEBIRD"),
        @JsonSubTypes.Type(value = Bowser.class, name = "BOWSER"),

})

public abstract class Enemy extends Entity {
    private int x;
    private int y;
    public Enemy() {
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
}
