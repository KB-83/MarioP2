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

public class ProfilePanel extends MarioPanel {
    private PanelsManagerCard cardPanel;
    // TODO: try not to be dependent on user

    //    User user;
    private List<JRadioButton> playersOption = new ArrayList<>();
    private JButton ok , back = new JButton("<-");
    ProfilePanel(PanelsManagerCard cardPanel) {

        this.cardPanel = cardPanel;
        setDependencies();
        loadConfig();
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.red);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.black);
        g2.setFont(new Font("monospaced", Font.BOLD, 30));
        FontMetrics fm = g2.getFontMetrics();
//        int textX = (this.getSize().width / 2) - (fm.stringWidth(user.getUserName()) / 2);
//        g2.drawString(user.getUserName(), textX,140);
//        textX = (this.getSize().width / 2) - (fm.stringWidth("Highest Score:"+String.valueOf(user.getHighScore())) / 2);
//        g2.drawString("Highest Score:"+String.valueOf(user.getHighScore()), textX,200);

//        textX = (this.getSize().width / 2) - (fm.stringWidth("selected player: "+user.getSelectedPlayer()) / 2);
//        g2.drawString("selected player: "+user.getSelectedPlayer(), textX,260);

    }
    public void setPlayersOption(){
        int x = 100;
        this.removeAll();
        playersOption = new ArrayList<>();
        ButtonGroup bg=new ButtonGroup();
//        for (String player:user.getOwnedPlayers()){
//            JRadioButton jRadioButton=new JRadioButton(player);
//            System.out.println(player+" prfile panel setting text");
//            jRadioButton.setBounds(x,500,100,30);
//            playersOption.add(jRadioButton);
//            bg.add(jRadioButton);
//            this.add(jRadioButton);
//            x+=100;
//        }
        ok = new JButton("ok");
        ok.setBounds(100,550,50,30);
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (JRadioButton jRadioButton:playersOption){
                    if (jRadioButton.isSelected()){
                        String name=jRadioButton.getText();
//                        card.gM.lM.userManager.currentUser.changeSelectedPlayer(name);
                        repaint();
//                        saveInfo();
                        break;
                    }
                }

            }
        });
        this.add(ok);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardPanel.getCardLayout().show(cardPanel,"mainMenu");
                cardPanel.getMainMenu().requestFocus();
            }
        });
        back.setBounds(0,0,50,50);
        this.add(back);
    }
    // TODO: try not to be dependent on user

    public void setUser() {
//        this.user = this.card.gM.lM.userManager.currentUser;
//        setPlayersOption();
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

    @Override
    public void setDependencies() {

    }

    @Override
    public void loadConfig() {
        setLayout(null);
        setBackground(Color.red);
        setPlayersOption();
    }

}
