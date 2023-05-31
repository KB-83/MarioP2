package logic;

import graphic.GraphicManager;
import logic.userstructure.User;

public class LogicManager {
    private User user;
    private GraphicManager graphicManager;
    public LogicManager() {
        graphicManager = new GraphicManager(this);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public GraphicManager getGraphicManager() {
        return graphicManager;
    }

    public void setGraphicManager(GraphicManager graphicManager) {
        this.graphicManager = graphicManager;
    }
}
