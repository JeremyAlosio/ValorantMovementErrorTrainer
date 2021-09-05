import java.time.ZonedDateTime;

public class SoundTimer extends Thread {

    long timerLength;
    boolean continueTimer = true;

    public SoundTimer(long timerLength)
    {
        this.timerLength = (long) (timerLength);
    }

    public void run()
    {
        long startTime = ZonedDateTime.now().toInstant().toEpochMilli();
        long currentTime = ZonedDateTime.now().toInstant().toEpochMilli();
        continueTimer = true;

        while(continueTimer && currentTime - startTime <= timerLength)
        {
            currentTime = ZonedDateTime.now().toInstant().toEpochMilli();
        }

        if(currentTime - startTime >= timerLength)
            PlaySound.playSound();
    }

    public void timerInterrupt()
    {
        continueTimer = false;
    }


}
