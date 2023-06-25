package logic.sound;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class Sound {
    private Clip clip;
    private URL[] soundURL= new URL[20];
    public Sound() {

        soundURL[0] = getClass().getResource("/database/sound/1.WAV");
    }
    public void setFile(int i){
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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
