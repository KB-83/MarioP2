package graphic.panel;

import javax.swing.*;
import java.awt.*;

public class PauseFrame extends JFrame {
    private JButton saveGameAndExit;
    private JButton soundButton;
    private Frame frame;

    public PauseFrame(Frame frame) {
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setResizable(false);
        this.frame = frame;
        setTitle("pause panel");
        setSize(200,100);
        setLayout(new FlowLayout());

        // افزودن دکمه‌ها
        saveGameAndExit = new JButton("save and exit");
        soundButton = new JButton("Mute/unMute");

        saveGameAndExit.addActionListener(e -> {
//            frame.getGraphicManager().getLogicManager().getUser().getCurrentGameState().
//                    getGameStateController().checkPointRequest(saveCheckPoint.getText());
            setVisible(false);
        });

        soundButton.addActionListener(e -> {
            setVisible(false);
            frame.getGraphicManager().getUser().getCurrentGameState().setPaused(false);
        });
        add(soundButton);
        add(saveGameAndExit);
        setLocationRelativeTo(null);


    }
}