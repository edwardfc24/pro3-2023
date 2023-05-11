package solucion_lista;

public class Nodo {

    private String nombre;
    private String contenido;
    private boolean esCarpeta;
    private SistemaArchivos datos;
    private Nodo anterior;
    private Nodo siguiente;

    public Nodo(String nombre, String contenido, boolean esCarpeta) {
        this.nombre = nombre;
        this.contenido = contenido;
        this.esCarpeta = esCarpeta;
        this.datos = new SistemaArchivos();
        this.anterior = null;
        this.siguiente = null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public boolean isEsCarpeta() {
        return esCarpeta;
    }

    public void setEsCarpeta(boolean esCarpeta) {
        this.esCarpeta = esCarpeta;
    }

    public Nodo getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public SistemaArchivos getDatos() {
        return datos;
    }

    public void setDatos(SistemaArchivos datos) {
        this.datos = datos;
    }

    @Override
    public String toString() {
        if (this.esCarpeta) {
            return this.nombre;
        }
        return this.nombre + "\nContenido:\n" + this.contenido;

    }
}
