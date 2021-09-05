public class Alert {

    private SoundTimer timer;
    private final long gunTime;

    public Alert(long gunTime)
    {
        this.gunTime = gunTime;
        this.timer = new SoundTimer(gunTime);
    }

    public void AlertStart()
    {
        timer.start();
    }

    public void AlertStop()
    {
        timer.timerInterrupt();
        this.timer = new SoundTimer(gunTime);
    }

}
