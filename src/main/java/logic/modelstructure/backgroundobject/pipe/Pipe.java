package logic.modelstructure.backgroundobject.pipe;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import logic.modelstructure.entity.enemy.*;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Goomba.class, name = "SIMPLE"),
        @JsonSubTypes.Type(value = Koopa.class, name = "PIRANHA_TRAP"),
        @JsonSubTypes.Type(value = Spiny.class, name = "TELE_SIMPLE"),
        @JsonSubTypes.Type(value = NukeBird.class, name ="TELE_PIRANHA"),
        @JsonSubTypes.Type(value = Bowser.class, name = "DECEIT"),
        ////

})
public abstract class Pipe {
    private int x;
    private int y;

    public Pipe() {
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
