package logic.modelstructure.backgroundobject.pipe;

import logic.modelstructure.entity.enemy.Plant;

public class SimplePlantPipe extends Pipe{
    private Plant plant;

    public SimplePlantPipe() {
    }

    public Plant getPlant() {
        return plant;
    }

    public void setPlant(Plant plant) {
        this.plant = plant;
    }
}
