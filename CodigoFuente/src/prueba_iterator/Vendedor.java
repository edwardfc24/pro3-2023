package prueba_iterator;

import java.util.Date;

public class Vendedor {
    private String nombre;
    private Date fecha;
    private double comision;

    public Vendedor(String nombre, Date fecha, double comision) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.comision = comision;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " - Fecha: " + fecha + " - Comisión: " + comision;
    }
}
