import javax.swing.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class appMonedas {
    double cantidad;
    public appMonedas(double cantidad){
        this.cantidad = cantidad;
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
            }
            else {
                JOptionPane.showMessageDialog(null, "Moneda no encontrada.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    private static Map<String, Moneda> inicializarMonedas() {
        Map<String, Moneda> monedas = new LinkedHashMap<>();
        Moneda dolar = new Moneda("Dólar", 16.75, "Dólares", '$');
        Moneda euro = new Moneda("Euro", 18.75, "Euros", '€');
        Moneda libra = new Moneda("Libra", 21.63, "Libras", '£');
        Moneda yen = new Moneda("Yen", 0.12, "Yenes", '¥');
        Moneda won = new Moneda("Won", 0.013, "Wones", '₩');

        monedas.put("Pesos a Dólar", dolar);
        monedas.put("Pesos a Euros", euro);
        monedas.put("Pesos a Libras", libra);
        monedas.put("Pesos a Yen", yen);
        monedas.put("Pesos a Won", won);
        monedas.put("Dólar a Pesos", dolar);
        monedas.put("Euros a Pesos", euro);
        monedas.put("Libras a Pesos", libra);
        monedas.put("Yenes a Pesos", yen);
        monedas.put("Wones a Pesos", won);

        return monedas;
    }
}
