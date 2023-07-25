import javax.swing.*;

import static javax.swing.JOptionPane.showOptionDialog;

public class Resultado {
    JOptionPane panel;
    String mensaje;
    public Resultado(String resultado){
        panel = new JOptionPane();
        mensaje = resultado;

        Object[] options = {"OK"};
        int option = showOptionDialog(null, mensaje, "Resultado",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                null, options, options[0]);
        if (option == JOptionPane.OK_OPTION) {
            new Continuar();
        }
    }
}
