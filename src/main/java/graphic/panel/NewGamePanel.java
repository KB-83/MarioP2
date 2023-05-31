package graphic.panel;

import logic.gamestrucure.Game;
import logic.requsethandler.UserRequestHandler;
import util.Constant;

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
    JTextArea newGameMassage = new JTextArea("newGameMassage");

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
        ButtonGroup buttonGroup = new ButtonGroup();
        JRadioButton hard = new JRadioButton("hard");
        JRadioButton mid = new JRadioButton("mid");
        JRadioButton low = new JRadioButton("low");
        hard.setBounds(20+100,250,60,30);
        mid.setBounds(120+100,250,100,30);
        low.setBounds(220+100,250,100,30);
        buttonGroup.add(hard);
        buttonGroup.add(mid);
        buttonGroup.add(low);
        add(mid);
        add(low);
        add(hard);
        newGameMassage.setForeground(Color.gray);
        newGameMassage.setBounds(Constant.PANEL_WIDTH/2-350 ,550,250,50);
        add(newGameMassage);
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
                UserRequestHandler userRequestHandler = new UserRequestHandler(cardPanel.getFrame().getGraphicManager().getLogicManager());
                //todo : do every thing
                userRequestHandler.newGameRequest("default");
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
        setLastGamesOptions();
    }
    public void setLastGamesOptions(){
//        int x = 200;
//        for (int i = 0;i < user.gameStatesList.size() ; i++){
//            if(lastGamesList[i] != null){
//                this.remove(lastGamesList[i]);
//            }
//            JRadioButton gameButton = new JRadioButton();
//            lastGamesList[i] = gameButton;
//            gameButton.setText(user.gameStatesList.get(i).massage);
//            gameButton.setBounds(x,500,250,30);
//            bg.add(gameButton);
//            this.add(gameButton);
//            x += 300;
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
