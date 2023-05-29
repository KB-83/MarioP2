package graphic.panel;

import graphic.GraphicManager;
import util.Config;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    private GraphicManager gM;
    private PanelsManagerCard panelsManagerCard;
    public Frame(GraphicManager gM){
        setDependencies(gM);
        loadConfig(this.getClass().getSimpleName());
    }
    private void setDependencies(GraphicManager gM){
        this.gM = gM;
        this.panelsManagerCard = new PanelsManagerCard(this);
    }
    private void loadConfig(String name) {
        Config config = Config.getConfig(name);

        setFocusable(config.getPropertyAsBoolean("Focusable"));
        setDefaultCloseOperation(config.getPropertyAsInt("CloseOperation"));
//        setSize(new Dimension(config.getPropertyAsInt("Width"),config.getPropertyAsInt("Height")));

        setResizable(config.getPropertyAsBoolean("Resizable"));


        add(panelsManagerCard);
        pack();// check
        setLocationRelativeTo(null);
        revalidate();
        setVisible(true);
    }
    public void paintAll(){
        this.panelsManagerCard.repaint();
    }
    //test


    public PanelsManagerCard getPanelsManagerCard() {
        return panelsManagerCard;
    }

    public void setPanelsManagerCard(PanelsManagerCard panelsManagerCard) {
        this.panelsManagerCard = panelsManagerCard;
    }
}
