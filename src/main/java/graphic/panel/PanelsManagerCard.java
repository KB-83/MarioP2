package graphic.panel;

import util.Config;

import javax.swing.*;
import java.awt.*;

public class PanelsManagerCard extends MarioPanel {
    private Frame frame;
//    private MarioPanel currentPanel;
    // panels
    private GamePanel gamePanel;
    private StartPanel startPanel;
    private MainMenu mainMenu;
    private ProfilePanel profilePanel;
    private ShopPanel shopPanel;
    private NewGamePanel newGamePanel;
    private LastGamesPanel lastGamesPanel;
    //layout
    private CardLayout cardLayout;
    public PanelsManagerCard(Frame frame){
        this.frame = frame;
        setDependencies();
        loadConfig();
        // panel settings
        // dont forget packing
    }

    @Override
    public void setDependencies() {
        // other panels going to be added here
        gamePanel = new GamePanel(this);
        startPanel = new StartPanel(this);
        mainMenu = new MainMenu(this);
        shopPanel = new ShopPanel(this);
        profilePanel = new ProfilePanel(this);
        newGamePanel = new NewGamePanel(this);
        lastGamesPanel = new LastGamesPanel(this);
        cardLayout = new CardLayout();

    }

    @Override
    public void loadConfig() {
        Config config = getClassConfig(this.getClass());
        setLayout(cardLayout);

        setFocusable(config.getPropertyAsBoolean("Focusable"));
        setPreferredSize(new Dimension(config.getPropertyAsInt("Width"), config.getPropertyAsInt("Height")));


        //adding panels order is important
        add(startPanel , "startPanel");
        add(gamePanel, "gamePanel");
        add(newGamePanel,"newGamePanel");
        add(lastGamesPanel,"lastGamesPanel");
        add(mainMenu,"mainMenu");
        add(profilePanel,"profilePanel");
        add(shopPanel,"shopPanel");


        revalidate();

    }

    // panels will be added later
    //info

    public void paintComponent(Graphics g) {
        gamePanel.repaint();
        shopPanel.repaint();
        profilePanel.repaint();
        newGamePanel.repaint();
        lastGamesPanel.repaint();
    }
//    public void setCurrentUser(User user){
//        mainMenu.setUser();
//        shopPanel.setUser();
//        profilePanel.setUser();
//        newGamePanel.setUser();
//        lastGamesPanel.setUser();
//        gamePanel.setCurrentUser(user);
//    }

    public Frame getFrame() {
        return frame;
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    public StartPanel getStartPanel() {
        return startPanel;
    }

    public MainMenu getMainMenu() {
        return mainMenu;
    }

    public ProfilePanel getProfilePanel() {
        return profilePanel;
    }

    public ShopPanel getShopPanel() {
        return shopPanel;
    }

    public NewGamePanel getNewGamePanel() {
        return newGamePanel;
    }

    public LastGamesPanel getLastGamesPanel() {
        return lastGamesPanel;
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }
}
