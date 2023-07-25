import java.text.DecimalFormat;

public class Moneda {
    private String nombre;
    private double valor;
    private String plural;
    private char simbolo;

    public Moneda(String nombre, double valor, String plural, char simbolo) {
        this.nombre = nombre;
        this.valor = valor;
        this.plural = plural;
        this.simbolo = simbolo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getPlural() {
        return plural;
    }

    public void setPlural(String plural) {
        this.plural = plural;
    }

    public char getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(char simbolo) {
        this.simbolo = simbolo;
    }

    public String conversionPesos (double cantidad){
        double conversion = cantidad * valor;
        DecimalFormat formato = new DecimalFormat("#.00");
        String total = formato.format(conversion);
        String monto = "Peso";
        setSimbolo('$');
        if (conversion > 1) {
            monto = "Pesos";
        }
        String msg = "Tienes " + simbolo + total + " " + monto;
        return msg;
    }

    public String conversionMoneda (double cantidad){
        double conversion = cantidad / valor;
        DecimalFormat formato = new DecimalFormat("#.00");
        String total = formato.format(conversion);
        String monto = nombre;
        if (conversion > 1) {
            monto = plural;
        }
        return "Tienes " + simbolo + " "+ total + " " + monto;
    }
}
