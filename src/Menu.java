import javax.swing.*;

import static javax.swing.JOptionPane.showInputDialog;

public class Menu {
    JOptionPane panel;
    String[] opciones = {"Conversor de Moneda",
            "Conversor de Criptomonedas"};
    String mensaje;

    public Menu(){
        mensaje = "Selecciona una opcion de conversor";
        panel = new JOptionPane();
        String opcion = (String) showInputDialog(null,
                mensaje,"Menu",JOptionPane.QUESTION_MESSAGE,
                null, opciones, opciones[0]);

        if(opcion != null){
            if(opcion.equals(opciones[0])){
                new inputCantidad();
            }
            if(opcion.equals(opciones[1])){
                new appCrypto();
            }
        } else {
            System.out.println("No se seleccionó ninguna opción");
        }
    }
}
