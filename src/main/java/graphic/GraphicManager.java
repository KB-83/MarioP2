package graphic;

import graphic.panel.Frame;
import logic.LogicManager;
import logic.userstructure.User;

public class GraphicManager {
    private LogicManager logicManager;
    private User user;
    private Frame frame;
    public GraphicManager(LogicManager logicManager){
        this.logicManager = logicManager;
        frame = new Frame(this);
    }
    private void setPanelsDependencies(User user){
        frame.getPanelsManagerCard().getLastGamesPanel().setUserClearedDependencies(user);
        frame.getPanelsManagerCard().getNewGamePanel().setUserClearedDependencies(user);
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
        setPanelsDependencies(user);
    }

    public Frame getFrame() {
        return frame;
    }

    public void setFrame(Frame frame) {
        this.frame = frame;
    }

    public LogicManager getLogicManager() {
        return logicManager;
    }
}
