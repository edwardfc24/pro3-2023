package patrones;

public class Suscriptor implements Observer {


    private String nombre;

    public Suscriptor(String nombre) {
        this.nombre = nombre;
    }


    @Override
    public void actualizar(String mensaje) {
        System.out.println(nombre + " ha recibido este mensaje: " + mensaje + "\n");
    }
}
