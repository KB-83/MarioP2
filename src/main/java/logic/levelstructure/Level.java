package logic.levelstructure;

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
