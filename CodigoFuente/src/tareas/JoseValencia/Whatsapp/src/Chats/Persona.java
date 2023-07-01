package Chats;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Persona implements Observador, Observable {
    private static final Logger logger = LogManager.getLogger(Persona.class);
    public List<Observador> observadores;
    private String mensaje;
    private String nombre;

    public Persona(String nombre) {
        this.nombre= nombre;
        this.observadores = new ArrayList<>();
        logger.info("se creo la persona");
    }

    ////****notifica los observadores****////
    public void notificar(String mensaje) {
        this.mensaje  = mensaje;
        this.notificarObservadores(this.mensaje);
        logger.info(nombre + " ha recibido este mensaje: " + mensaje + "\n");
    }
    /////////////////////////////////////////

    ////****observable****////
    @Override
    public void suscribir(Observador observer) {
        this.observadores.add(observer);
    }
    @Override
    public void desuscribir(Observador observer)  {
        logger.info("esto no se utiliza");
        this.observadores.remove(observer);
    }////****esto no se utiliza
    @Override
    public void notificarObservadores(String mensaje) {
        for (Observador observador : this.observadores) {
            observador.mostrarMensaje(mensaje);
        }
        logger.info(nombre + " ha enviado el siguiente mensaje : " + mensaje);
    }
    //////////////////////////

    ////****observador****////
    @Override
    public JLabel mostrarMensaje(String mensaje) {
        JLabel label = new JLabel(mensaje);
        label.setOpaque(true);
        return label;
    }
    //////////////////////////

    //////////////////////////
    @Override
    public String toString() {
        return super.toString();
    }
    //////////////////////////

    //////getter y setter//////
    public List<Observador> getObservadores() {
        return observadores;
    }
    public void setObservadores(List<Observador> observadores) {
        this.observadores = observadores;
    }
    public String getMensaje() {
        return mensaje;
    }
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    ///////////////////////////
}
