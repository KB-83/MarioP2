package logic.modelstructure.backgroundobject.pipe;

import logic.levelstructure.Section;
import logic.modelstructure.entity.enemy.Plant;

public class TelePlantPipe extends Pipe{
    private Section section;
    private Plant plant;

    public TelePlantPipe() {
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public Plant getPlant() {
        return plant;
    }

    public void setPlant(Plant plant) {
        this.plant = plant;
    }
}
