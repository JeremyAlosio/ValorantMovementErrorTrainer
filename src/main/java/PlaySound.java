import com.sun.tools.javac.Main;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.util.Objects;

public class PlaySound {

    public static void playSound() {
        try {
            System.out.println("Alert!!!!");
            Clip clip = AudioSystem.getClip();
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(
                    Objects.requireNonNull(PlaySound.class.getClassLoader().getResourceAsStream("Hit.wav")));
            clip.open(inputStream);
            clip.start();
            System.out.println("Alert!!!!");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
