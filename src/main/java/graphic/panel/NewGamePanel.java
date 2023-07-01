package graphic.panel;

import graphic.guigamestructure.GuiGameCreator;
import logic.gamestrucure.Game;
import logic.gamestrucure.GameState;
import logic.requsethandler.UserRequestHandler;
import logic.userstructure.User;
import util.Constant;
import util.Loop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewGamePanel extends MarioPanel {
    private PanelsManagerCard cardPanel;
//    User user;
    ButtonGroup bg = new ButtonGroup();
    JButton back = new JButton("<-");
    JButton ok =new  JButton("ok");
    JButton delete =new  JButton("delete");

    JRadioButton[] lastGamesList = new JRadioButton[3];
    NewGamePanel(PanelsManagerCard cardPanel) {
        this.cardPanel = cardPanel;
        setDependencies();
        loadConfig();
    }
    @Override
    public void setDependencies() {

    }
    // TODO: you can change and use config

    @Override
    public void loadConfig() {
        setLayout(null);
        setBackground(Color.red);
        setButtons();
    }
    private void setButtons(){
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardPanel.getCardLayout().show(cardPanel,"mainMenu");
                cardPanel.getMainMenu().requestFocus();
            }
        });
        back.setBounds(0,0,50,50);
        add(back);
        /////todo
        ok.setBounds(Constant.PANEL_WIDTH/2 - 25,550,50,50);
        delete.setBounds(Constant.PANEL_WIDTH/2 + 30,550,70,50);
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                for (int i = 0;i<lastGamesList.length;i++) {
//                    if (lastGamesList[i] != null && lastGamesList[i].isSelected()) {
//                        user.userManager.newGameRequest(lastGamesList[i].getText(), "newGame   ");
//                        lastGamesList[i].setSelected(false);
//                        setLastGamesOptions();
//                        saveInfo();
//                        card.cardLayout.show(card,"mainMenu");
//                        break;
//                    }
//                }
            }
        });
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String gameName = "";
                for (JRadioButton button : lastGamesList){
                    if (button != null && button.isSelected()){
                        gameName = button.getText();
                        break;
                    }
                }
                if (gameName.equals("")){
                    System.out.println("select a game!");
                    return;
                }
                UserRequestHandler userRequestHandler = cardPanel.getFrame().getGraphicManager().getLogicManager().getUser().getUserRequestHandler();
                //todo : do every thing
                //  pass this s to user request handler
                // this process is like a request response process
                GameState gameState = userRequestHandler.newGameRequest(gameName);
                cardPanel.getCardLayout().show(cardPanel,"gamePanel");
                cardPanel.getGamePanel().requestFocus();
//
//                for (int i = 0 ; i<lastGamesList.length;i++) {
//                    if (lastGamesList[i] != null && lastGamesList[i].isSelected()){
//                        user.userManager.newGameRequest(lastGamesList[i].getText(),newGameMassage.getText());
//                        setLastGamesOptions();
//                        GameLoop gameLoop = new GameLoop(card.gM.lM, card.gM);
//                        user.currentGameState.setLoop(gameLoop);
//
//                        gameLoop.start();
//                        saveInfo();
//                        break;
//                    }
//                }

            }
        });
        add(delete);
        add(ok);
    }
    public void setUserClearedDependencies(User user) {
        int x = 200;
        for (int i = 0;i < user.getGames().length; i++){
            if(lastGamesList[i] != null){
                this.remove(lastGamesList[i]);
            }
            JRadioButton gameButton = new JRadioButton();
            lastGamesList[i] = gameButton;
            gameButton.setText(user.getGames()[i].getName());
            gameButton.setBounds(x,500,250,30);
            bg.add(gameButton);
            this.add(gameButton);
            x += 300;
        }
    }

    // TODO: change save and load paradime

    private void saveInfo() {
//        File file = new File(user.getUserName() + ".json");
//        FileWriter fileWriter = null;
//        try {
//            fileWriter = new FileWriter(file);
//            user.userManager.objectMapper.writeValue(fileWriter, user);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }
}
