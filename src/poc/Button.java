package poc;

import java.io.Closeable;
import java.io.IOException;

public class Button extends Subject implements Observer {
    boolean disabled = false;

    public void click() {
        disabled = true;
        notificarAll(true);
    }

    public void onRelease() {
        disabled = false;
        notificarAll(false);
    }

    @Override
    public void notificar(boolean disabled) {
        String prefix = disabled? "DES": "H";

        System.out.println("BOTAO "+ prefix + "ABILITADO");
        this.disabled = disabled;
    }

}
