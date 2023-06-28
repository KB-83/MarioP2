package logic.modelstructure.backgroundobject.pipe;

import com.fasterxml.jackson.annotation.JsonIgnore;
import logic.levelstructure.Section;
import logic.levelstructure.TeleSection;
import logic.modelstructure.entity.enemy.Plant;

public class TelePlantPipe extends Pipe{
    @JsonIgnore
    private TeleSection teleSection;
    private Plant plant;

    public TelePlantPipe() {
    }

    public TeleSection getTeleSection() {
        return teleSection;
    }

    public void setTeleSection(TeleSection teleSection) {
        this.teleSection = teleSection;
    }


    public Plant getPlant() {
        return plant;
    }

    public void setPlant(Plant plant) {
        this.plant = plant;
    }
}
