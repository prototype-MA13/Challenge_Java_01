import javax.swing.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class appCrypto {
    public appCrypto(){
        double cantidad = obtenerCantidad();
        Map<String, Moneda> monedas = inicializarMonedas();
        String[] opciones = monedas.keySet().toArray(new String[0]);

        String seleccion = (String) JOptionPane.showInputDialog(null,
                "Elige la moneda a la que deseas convertir tu dinero",
                "Conversor de Monedas",
                JOptionPane.PLAIN_MESSAGE,
                null,
                opciones,
                opciones[0]);

        if (seleccion != null) {
            Moneda monedaSeleccionada = monedas.get(seleccion);
            if (monedaSeleccionada != null) {
                String resultado;
                // si se elige una opcion de conversion "Pesos a" se ejecuta
                // una conversion hacia al divisa elegida
                if (seleccion.startsWith("Pesos a ")) {
                    resultado = monedaSeleccionada.conversionMoneda(cantidad);
                    new Resultado(resultado);
                    // si se elige cualquier otra opcion se ejecuta
                    // una conversion hacia pesos
                } else {
                    resultado = monedaSeleccionada.conversionPesos(cantidad);
                    new Resultado(resultado);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Moneda no encontrada.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    private static double obtenerCantidad() {
        String cantidadStr = JOptionPane.showInputDialog(null, "Ingresa una cantidad:", "Conversor de Monedas", JOptionPane.PLAIN_MESSAGE);
        try {
            return Double.parseDouble(cantidadStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Cantidad inválida. Debes ingresar un número.", "Error", JOptionPane.ERROR_MESSAGE);
            return obtenerCantidad();
        }
    }
    private static Map<String, Moneda> inicializarMonedas() {
        Map<String, Moneda> monedas = new LinkedHashMap<>();
        Moneda dolar = new Moneda("Bitcoin", 501368.88, "Bitcoins", 'Ƀ');
        Moneda euro = new Moneda("Ethereum", 31827.37, "Ethereums", 'Ξ');
        Moneda libra = new Moneda("XRP", 13.12, "XRPs", 'Ɍ');
        Moneda yen = new Moneda("Litecoin", 1548.04, "Litecoins", 'Ł');
        Moneda won = new Moneda("Cardano", 5.33, "Cardanos", '₳');

        monedas.put("Pesos a Bitcoin", dolar);
        monedas.put("Pesos a Ethereum", euro);
        monedas.put("Pesos a XRP", libra);
        monedas.put("Pesos a Litecoin", yen);
        monedas.put("Pesos a Cardano", won);
        monedas.put("Bitcoin a Pesos", dolar);
        monedas.put("Ethereum a Pesos", euro);
        monedas.put("XRP a Pesos", libra);
        monedas.put("Litecoin a Pesos", yen);
        monedas.put("Cardano a Pesos", won);

        return monedas;
    }
}


