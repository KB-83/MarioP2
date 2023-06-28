package graphic.panel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckPointFrame extends JFrame {
    private JButton saveCheckPoint = new JButton("Save CheckPoint");
    private JButton getCoins = new JButton("Get Coins");
    private Frame frame;

    public CheckPointFrame(Frame frame) {
        this.frame = frame;
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(200, 100);
        setLayout(new FlowLayout());

        saveCheckPoint.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.getGraphicManager().getLogicManager().getUser().getCurrentGameState().
                        getGameStateController().checkPointRequest(saveCheckPoint.getText());
                setVisible(false);
            }
        });

        getCoins.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.getGraphicManager().getLogicManager().getUser().getCurrentGameState()
                        .getGameStateController().checkPointRequest(getCoins.getText());
                setVisible(false);
            }
        });
        add(saveCheckPoint);
        add(getCoins);
        setLocationRelativeTo(null);
    }
}
