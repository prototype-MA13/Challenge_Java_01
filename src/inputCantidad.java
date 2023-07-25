import javax.swing.*;

import static javax.swing.JOptionPane.showInputDialog;

public class inputCantidad {
    boolean entradaValida = false;
    String mensaje;

    public inputCantidad (){
        JOptionPane panel = new JOptionPane();

        // se inicia un bucle que no termina hasta que el usuario ingrese un valor valido
        while (!entradaValida) {
            mensaje = showInputDialog("Ingresa la cantidad de dinero que deseas convertir:");
            if (mensaje == null) {
                JOptionPane.showMessageDialog(null, "Debes ingresar una cantidad");
                return;
            } else if (esValido(mensaje)) {
                entradaValida = true;
            } else {
                JOptionPane.showMessageDialog(null, "Valor no válido");
            }
        }
        double cantidad = Double.parseDouble(mensaje);
        new appMonedas(cantidad);
    }

    // Comprueba que el dato ingresado sea de tipo numerico, sin caracteres alfabeticos
    private boolean esValido(String mensaje) {
        return mensaje.matches("\\d+(\\.\\d+)?");
    }
}
