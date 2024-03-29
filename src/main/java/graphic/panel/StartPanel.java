package graphic.panel;

import graphic.requestlistener.PlayerListener;
import logic.requsethandler.UserRequestHandler;
import util.Config;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartPanel extends MarioPanel {
    private PanelsManagerCard cardPanel;
    private JButton login, signIn, exit, getSignIn,getLogin;
    private Image image;
    private JTextArea loginName = new JTextArea("user name:");
    private JTextArea loginPass = new JTextArea("pass:");
    private JTextArea signName = new JTextArea("user name:");
    private JTextArea signPass = new JTextArea("pass:");

    public StartPanel(PanelsManagerCard cardPanel){

        this.cardPanel = cardPanel;
        setDependencies();
        loadConfig();
    }
    @Override
    public void setDependencies() {


    }

    @Override
    public void loadConfig() {
        Config config = getClassConfig(this.getClass());
        setFocusable(true);
        setLayout(null);
//        try {
//            image = ImageIO.read(getClass().getResourceAsStream("/Images/BackGround.png"));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        setTextAreas(config);
        setButtons(config);
        addActions();
        add(signName);
        add(signPass);
        add(loginName);
        add(loginPass);
        revalidate();
    }
    // all design
    private void setButtons(Config config) {
        // TODO: you can change and use config


        signIn = new JButton("sign in");
        login = new JButton("login");
        exit = new JButton("exit");
        getLogin = new JButton("ok");
        getSignIn = new JButton("ok");

        signIn.setBounds(3 * 48 - 50 , 460,100,40);
        login.setBounds(3 * 48 - 50, 520,100,40);
        exit.setBounds(3 * 48 - 50,580,100,40);
        getSignIn.setBounds(3 * 48 + 280 + 30, 460,50,40);
        getLogin.setBounds(3 * 48 + 280 + 30, 520,50,40);

        signIn.setFocusable(false);
        login.setFocusable(false);
        exit.setFocusable(false);
        getSignIn.setFocusable(false);
        getLogin.setFocusable(false);

        getLogin.setVisible(false);
        getSignIn.setVisible(false);

        this.add(signIn);
        this.add(login);
        this.add(exit);
        this.add(getLogin);
        this.add(getSignIn);
        this.revalidate();
    }
    private void setTextAreas(Config config) {
        // TODO: you can change and use config

        LineBorder lineBorder = new LineBorder(Color.white, 8, true);
        loginName.setBorder(lineBorder);
//        loginName.setForeground(Color.LIGHT_GRAY);
        loginPass.setBorder(lineBorder);
//        loginPass.setForeground(Color.LIGHT_GRAY);
        signName.setBorder(lineBorder);
        signName.setForeground(Color.LIGHT_GRAY);
        signPass.setBorder(lineBorder);
        signPass.setForeground(Color.LIGHT_GRAY);
        loginName.setBounds(3*48 + 50 + 30,520,100,40);
        loginPass.setBounds(3*48 + 50 + 30 + 100 + 30,520,100,40);
        signName.setBounds(3*48 + 50 + 30,460,100,40);
        signPass.setBounds(3*48 + 50 + 30 +100 + 30,460,100,40);
        loginName.setVisible(false);
        loginPass.setVisible(false);
        signName.setVisible(false);
        signPass.setVisible(false);
    }
    private void addActions(){

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginName.setVisible(true);
                loginPass.setVisible(true);
                getLogin.setVisible(true);
                signName.setVisible(false);
                signPass.setVisible(false);
                getSignIn.setVisible(false);

            }
        });

        signIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginName.setVisible(false);
                loginPass.setVisible(false);
                getLogin.setVisible(false);
                signName.setVisible(true);
                signPass.setVisible(true);
                getSignIn.setVisible(true);
            }
        });

        getSignIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserRequestHandler userRequestHandler = new UserRequestHandler(cardPanel.getFrame().getGraphicManager().getLogicManager());
                if (userRequestHandler.signInRequest(signName.getText(),signPass.getText(),userRequestHandler)){
                    cardPanel.getCardLayout().show(cardPanel, "mainMenu");
                    cardPanel.getMainMenu().requestFocus();
                }
            }

        });

        getLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserRequestHandler userRequestHandler = new UserRequestHandler(cardPanel.getFrame().getGraphicManager().getLogicManager());
                if (userRequestHandler.loginRequest(loginName.getText(), loginPass.getText(),userRequestHandler)){
                    cardPanel.getCardLayout().show(cardPanel, "mainMenu");
                    cardPanel.getMainMenu().requestFocus();
                }
            }
        });

    }
    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        g.drawImage(image,0,0,1248,720,null);

    }
}
