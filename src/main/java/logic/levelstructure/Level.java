package logic.levelstructure;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import logic.datahandler.CustomLevelLoader;

@JsonDeserialize(using = CustomLevelLoader.class)
public class Level {
    private Section[] sections;

    public Level() {
    }

    public Level(Section[] sections) {
        this.sections = sections;
    }

    public Section[] getSections() {
        return sections;
    }

    public void setSections(Section[] sections) {
        this.sections = sections;
    }
}
