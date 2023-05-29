package graphic.panel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends MarioPanel {

    private PanelsManagerCard cardPanel;
    //    User user;
    private JButton startNewGame = new JButton("start new game");
    private JButton continueLastGames = new JButton("continue last games");
    private JButton shop = new JButton("shop");
    private JButton profile = new JButton("profile");
    private JButton logout = new JButton("logout");

    MainMenu(PanelsManagerCard cardPanel) {

        this.cardPanel = cardPanel;
        setDependencies();
        loadConfig();
    }

    @Override
    public void setDependencies() {
    }

    @Override
    public void loadConfig() {
        setLayout(null);
        setFocusable(false);
        setBackground(Color.RED);
        setButtonsBounds();
        setButtonsListeners();

        add(startNewGame);
        add(continueLastGames);
        add(shop);
        add(profile);
        add(logout);
        revalidate();
    }


    private void setButtonsBounds() {


        startNewGame.setBounds(26 * 48/2 -75,300,150,40);
        continueLastGames.setBounds(26 * 48/2 - 75,300 +50,150,40);
        shop.setBounds(26 * 48/2 - 75,300 +100,150,40);
        profile.setBounds(26 * 48/2 - 75,300 + 150,150,40);
        logout.setBounds(26 * 48/2 - 75,300 +200,150,40);

        startNewGame.setFocusable(false);
        continueLastGames.setFocusable(false);
        shop.setFocusable(false);
        profile.setFocusable(false);
        logout.setFocusable(false);

    }
    private void setButtonsListeners(){
        startNewGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                card.gM.lM.userManager.newGameRequest();
                cardPanel.getCardLayout().show(cardPanel,"newGamePanel");
                cardPanel.getNewGamePanel().requestFocus();
//                card.gM.lM.userManager.newGameRequest(" from main menu");
//                    card.gamePanel.setKeyListener(card.gM.lM.userManager.currentUser.getSelectedPlayer().getPlayerListener());
//                    GameLoop gameLoop = new GameLoop(card.gM.lM, card.gM);
//                    gameLoop.start();
//                    card.cardLayout.show(card,"gamePanel");
//                    card.gamePanel.requestFocus();
            }
        });

        continueLastGames.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardPanel.getCardLayout().show(cardPanel,"lastGamesPanel");
                cardPanel.getLastGamesPanel().requestFocus();
            }
        });
        profile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardPanel.getCardLayout().show(cardPanel,"profilePanel");
                cardPanel.getProfilePanel().requestFocus();
            }
        });
        shop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardPanel.getCardLayout().show(cardPanel,"shopPanel");
                cardPanel.getShopPanel().requestFocus();
            }
        });
//
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Todo : send save info request
//                saveInfo();
//                card.gM.lM.userManager.currentUser = null;
                cardPanel.getCardLayout().show(cardPanel,"startPanel");
                cardPanel.getStartPanel().requestFocus();
            }
        });
//    }
//    public void setUser() {
//        this.user = this.card.gM.lM.userManager.currentUser;
//        this.repaint();
//    }
//    private void saveInfo(){
//        File file = new File(user.getUserName() + ".json");
//        FileWriter fileWriter = null;
//        try {
//            fileWriter = new FileWriter(file);
//            user.userManager.objectMapper.writeValue(fileWriter,user);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }

}
