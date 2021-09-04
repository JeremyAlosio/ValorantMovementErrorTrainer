import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import java.awt.event.KeyEvent;


public class ListenForKeys implements NativeKeyListener {

    private final long gun = Constants.gun_Phantom;

    private final Alert alert = new Alert(gun);
    private final Movement movement = new Movement();

    @Override
    public void nativeKeyTyped(NativeKeyEvent e) {

    }

    public void nativeKeyPressed(NativeKeyEvent e) {

        movement.addKeyToMovement(e);

        if(movement.isMoving())
            alert.AlertStop();
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent e) {

        movement.removeKeyFromMovement(e);

        if(!movement.isMoving())
            alert.AlertStart();
    }


}
