package graphic.panel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LastGamesPanel extends MarioPanel {
    private PanelsManagerCard cardPanel;
//    User user;
    private ButtonGroup bg = new ButtonGroup();
    private JButton back = new JButton("<-");
    private JButton ok =new  JButton("ok");

    private JRadioButton[] lastGamesList = new JRadioButton[3];
    LastGamesPanel(PanelsManagerCard cardPanel) {
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
        setBackground(Color.red);
        setInitialButtons();
    }
    public void setUser() {
//        this.user = this.card.gM.lM.userManager.currentUser;
    }
    private void setInitialButtons(){
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardPanel.getCardLayout().show(cardPanel,"mainMenu");
                cardPanel.getMainMenu().requestFocus();
            }
        });
        back.setBounds(0,0,50,50);
        add(back);
    }
    public void setLastGamesButtons(){
        ok.setBounds(this.getWidth()/2 - 25,550,50,50);
//        ok.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                for (JRadioButton button:lastGamesList){
//                    if(button != null && button.isSelected() ) {
//                        if (!button.getText().equals("newGame   ")) {
//                            user.userManager.lastGamesRequest(button.getText());
//                            setLastGamesOptions();
//                            GameLoop gameLoop = new GameLoop(card.gM.lM, card.gM);
//                            user.currentGameState.setLoop(gameLoop);
//
//                            gameLoop.start();
//                            long nano = 1000000000;
//                            user.currentGameState.setLastStopThreadTime(System.nanoTime() - (user.currentGameState.getPassedTime() * nano));
//                            saveInfo();
//                            card.cardLayout.show(card, "gamePanel");
//                            card.gamePanel.requestFocus();
//                        }
//                        break;
//                    }
//                }
//            }
//        });
        add(ok);
        setLastGamesOptions();

    }
    private void setLastGamesOptions() {
        int x = 200;
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
//        }
    }
    private void saveInfo(){
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
