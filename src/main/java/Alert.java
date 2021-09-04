public class Alert {

    private Timer timer;
    private final long gunTime;

    public Alert(long gunTime)
    {
        this.gunTime = gunTime;
        this.timer = new Timer(gunTime);
    }

    public void AlertStart()
    {
        timer.start();
    }

    public void AlertStop()
    {
        timer.timerInterrupt();
        this.timer = new Timer(gunTime);
    }

}
