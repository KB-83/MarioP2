package graphic.panel;

import util.Config;

import javax.swing.*;
import java.awt.*;

public abstract class MarioPanel extends JPanel {
    public abstract void setDependencies();
    public abstract void loadConfig();
    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }
    public Config getClassConfig(Class c) {
        return  Config.getConfig(c.getSimpleName());
    }

}
