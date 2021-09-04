import org.jnativehook.keyboard.NativeKeyEvent;

public class Movement {

    private boolean isWPressed = false;
    private boolean isAPressed = false;
    private boolean isSPressed = false;
    private boolean isDPressed = false;

    public boolean isMoving()
    {
        return isWPressed || isAPressed || isSPressed || isDPressed;
    }

    public void addKeyToMovement(NativeKeyEvent e)
    {
        if(e.getKeyCode() == NativeKeyEvent.VC_W)
            isWPressed = true;
        else if(e.getKeyCode() == NativeKeyEvent.VC_A)
            isAPressed = true;
        else if(e.getKeyCode() == NativeKeyEvent.VC_S)
            isSPressed = true;
        else if(e.getKeyCode() == NativeKeyEvent.VC_D)
            isDPressed = true;
    }

    public void removeKeyFromMovement(NativeKeyEvent e)
    {
        if(e.getKeyCode() == NativeKeyEvent.VC_W)
            isWPressed = false;
        else if(e.getKeyCode() == NativeKeyEvent.VC_A)
            isAPressed = false;
        else if(e.getKeyCode() == NativeKeyEvent.VC_S)
            isSPressed = false;
        else if(e.getKeyCode() == NativeKeyEvent.VC_D)
            isDPressed = false;
    }

}
