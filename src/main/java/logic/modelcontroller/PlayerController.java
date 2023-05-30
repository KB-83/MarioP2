package logic.modelcontroller;

import logic.modelstructure.entity.player.Player;

public class PlayerController {
    private Player player;

    public PlayerController(Player player) {
        this.player = player;
    }

    public void jump(){
        System.out.println("jump method called from player controller");
    }
    public void right(){

    }
}
