package util;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;
import java.util.HashMap;

public class Sound {
    private Clip clip;
    private static HashMap<String,URL> sounds;
    public Sound(String s) {
        if(sounds == null){
            loadSounds();
        }
        setSound(s);
    }
    public void setSound(String s){
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(sounds.get(s));
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private void loadSounds(){
        sounds = new HashMap<>();

        URL url = getClass().getResource("/sound/main.WAV");
        sounds.put("MAIN",url);

        url = getClass().getResource("/sound/powerup.WAV");
        sounds.put("POWER_UP",url);

        url = getClass().getResource("/sound/bullet.WAV");
        sounds.put("BULLET",url);

        url = getClass().getResource("/sound/coin.WAV");
        sounds.put("COIN",url);

        url = getClass().getResource("/sound/telepipe.WAV");
        sounds.put("TELE_PIPE",url);

        url = getClass().getResource("/sound/breakblock.WAV");
        sounds.put("BREAK_BLOCK",url);

        url = getClass().getResource("/sound/gameover.WAV");
        sounds.put("GAME_OVER",url);

        url = getClass().getResource("/sound/heartloose.WAV");
        sounds.put("HEART-LOOSE",url);

        url = getClass().getResource("/sound/kick.WAV");
        sounds.put("KICK",url);
    }
    public void play(){
        clip.start();
    }
    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop(){
        clip.stop();
    }
}
