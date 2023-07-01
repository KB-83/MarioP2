package graphic.panel;

import graphic.GraphicManager;
import util.Config;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    private GraphicManager graphicManager;
    private PanelsManagerCard panelsManagerCard;
    private CheckPointFrame checkPointFrame;
    private PauseFrame pauseFrame;
    public Frame(GraphicManager gM){
        setDependencies(gM);
        loadConfig(this.getClass().getSimpleName());
    }
    private void setDependencies(GraphicManager graphicManager){
        this.graphicManager = graphicManager;
        this.panelsManagerCard = new PanelsManagerCard(this);
        checkPointFrame = new CheckPointFrame(this);
        pauseFrame = new PauseFrame(this);
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

    public GraphicManager getGraphicManager() {
        return graphicManager;
    }

    public CheckPointFrame getCheckPointFrame() {
        return checkPointFrame;
    }

    public void setCheckPointFrame(CheckPointFrame checkPointFrame) {
        this.checkPointFrame = checkPointFrame;
    }

    public PauseFrame getPauseFrame() {
        return pauseFrame;
    }

    public void setPauseFrame(PauseFrame pauseFrame) {
        this.pauseFrame = pauseFrame;
    }
}
