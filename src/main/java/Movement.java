import org.jnativehook.keyboard.NativeKeyEvent;

import java.util.HashMap;
import java.util.Map;

public class Movement {

    private boolean isWPressed = false;
    private boolean isAPressed = false;
    private boolean isSPressed = false;
    private boolean isDPressed = false;

    private final long movementErrorTime = 100L;

    private Map<Integer, Long> keyPressMap = new HashMap<>();

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


    public boolean isValidMovementKey(NativeKeyEvent e)
    {
        return e.getKeyCode() == NativeKeyEvent.VC_W || e.getKeyCode() == NativeKeyEvent.VC_A || e.getKeyCode() == NativeKeyEvent.VC_S || e.getKeyCode() == NativeKeyEvent.VC_D;
    }


    public void storeKeyEventTime(NativeKeyEvent e)
    {
        if(isValidMovementKey(e))
            keyPressMap.put(e.getKeyCode(), e.getWhen());
    }

    public boolean movementErrorStarted(NativeKeyEvent e)
    {
        return e.getWhen() - keyPressMap.get(e.getKeyCode()) > movementErrorTime;
    }


}
