package logic.requsethandler;

import logic.LogicManager;
import logic.datahandler.Loader;
import logic.datahandler.Saver;
import logic.gamestrucure.Game;
import logic.gamestrucure.GameState;
import logic.levelstructure.Level;
import logic.levelstructure.Section;
import logic.modelstructure.entity.player.Mario;
import logic.modelstructure.entity.player.Player;
import logic.userstructure.User;
import util.Loop;


public class UserRequestHandler {
    private LogicManager logicManager;
    public UserRequestHandler(LogicManager logicManager){
        this.logicManager = logicManager;
    }
    public boolean loginRequest(String username, String password){
        User user = Loader.getLoader().loadUser(username);
        if (user != null){
            if (user.getPassword().equals(password)) {
                //todo : initialize game user
                logicManager.setUser(user);
                logicManager.getGraphicManager().setUser(user);
                return true;
            }
            System.out.println("password is incorrect.");
        }
        return false;
    }
    public boolean signInRequest(String username, String password){
        User user = new User(username,password);
        Game game = new Game();
        game.setName("default");
        Level level = new Level();
        level.setSections(new Section[]{new Section(1)});
        game.setLevels(new Level[]{level});

        Game[] games = {game};
        user.setGames(games);
        // todo : dont add game here
        System.out.println("working on line 32 user request handler");
        boolean b = Saver.getSaver().saveUser(user);
        if (b){
            logicManager.setUser(user);
//             todo: do the things
              }
        return b;
    }
    public GameState newGameRequest(String gameName) {
        Game game = null;
        for (Game game1 :logicManager.getUser().getGames()){
            if (gameName.equals(game1.getName())){
                game = game1;
                break;
            }
        }
        // todo set game default
        if (game != null) {
            GameState gameState = new GameState();
            Player player = new Mario();
            player.setImageAddress("Right1");
            gameState.setPlayer(player);
            // todo: next line is really dirty
            logicManager.getGraphicManager().getFrame().getPanelsManagerCard().getGamePanel().setKeyListener(player);
            gameState.setCurrentLevel(game.getLevels()[0]);
            gameState.setCurrentSection(game.getLevels()[0].getSections()[0]);
            gameState.setCoins(0);
            gameState.setLevelNumber(1);
            gameState.setSectionNumber(1);
            gameState.setPaused(false);
            gameState.setRemainingHeart(game.getHearts());
            gameState.setRemainingTime(gameState.getCurrentSection().getTime());
            gameState.setScore(0);
            Loop gameLoop = new Loop(gameState,logicManager.getGraphicManager().getFrame()
                    .getPanelsManagerCard().getGamePanel(),60);
            gameLoop.start();
            return gameState;
        }
        return null;
    }
}
