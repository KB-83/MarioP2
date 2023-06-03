package logic.modelstructure.backgroundobject.pipe;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import logic.modelstructure.entity.enemy.*;

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
