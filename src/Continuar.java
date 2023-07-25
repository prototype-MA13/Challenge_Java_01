import javax.swing.*;

import static javax.swing.JOptionPane.showOptionDialog;

public class Continuar {
    JOptionPane panel;
    Object[] options = {"Sí", "No", "Cancelar"};
    String mensaje = "¿Deseas continuar?";

    public Continuar(){
        panel = new JOptionPane();
        int opcion = showOptionDialog(null, mensaje, "Confirmar",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, options, options[0]);

        switch (opcion) {
            case JOptionPane.YES_OPTION -> new Menu();
            case JOptionPane.NO_OPTION, JOptionPane.CANCEL_OPTION ->  System.exit(0);
            default -> System.out.println("Opción inválida");
        }
    }
}
