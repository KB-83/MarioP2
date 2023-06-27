package logic.modelstructure.backgroundobject.pipe;

import logic.levelstructure.Section;

public class SimpleSpawnPipe extends Pipe{
    private Section section;
    public SimpleSpawnPipe() {
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }
}
