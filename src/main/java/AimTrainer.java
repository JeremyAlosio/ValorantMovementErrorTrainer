import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.w3c.dom.events.Event;

import java.util.logging.LogManager;

public class AimTrainer {

    public static void main(String[] args)
    {
        try {
            GlobalScreen.registerNativeHook();
            LogManager.getLogManager().reset();
        }
        catch (NativeHookException ex) {
            System.err.println("There was a problem registering the native hook.");
            System.err.println(ex.getMessage());

            System.exit(1);
        }
        GlobalScreen.addNativeKeyListener(new ListenForKeys());
    }
}
