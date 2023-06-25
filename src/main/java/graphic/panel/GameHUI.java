package graphic.panel;

import graphic.guigamestructure.GuiGameState;

import java.awt.*;

public class GameHUI {
    private GuiGameState guiGameState;

    public GameHUI() {
    }
    public void paintHui(Graphics2D g2) {
        int yMargin2 = 60;
        int yMargin1 = 30;
        g2.setFont(new Font("monospaced", Font.BOLD, 30));
        g2.drawString("TIME",10,yMargin1);
        g2.drawString(String.valueOf(guiGameState.getRemainingTime()),10,yMargin2);//time
        g2.drawString("COINS",150,yMargin1);
        g2.drawString(String.valueOf(guiGameState.getCoins()),150,yMargin2);//coin
        g2.drawString("WORLD",300,yMargin1);
        g2.drawString(String.valueOf(guiGameState.getLevelNumber()+" - "+guiGameState.getSectionNumber()),300,yMargin2);//level and section number
        g2.drawString("SCORE",450,yMargin1);
        g2.drawString(String.valueOf(guiGameState.getScore()),450,yMargin2);//score
        g2.drawString("LIVES",600,yMargin1);
        g2.drawString(String.valueOf(guiGameState.getRemainingHeart()),600,yMargin2);//hearts
    }

    public GuiGameState getGuiGameState() {
        return guiGameState;
    }

    public void setGuiGameState(GuiGameState guiGameState) {
        this.guiGameState = guiGameState;
    }
}
