package tareas.leonardo_loayza.chatMensajeriaa;

import java.util.ArrayList;

public class Persona implements Observer, Observable {
    private String nombre;
    private ArrayList<Observer> observadores;

    public Persona(String nombre) {
        this.nombre = nombre;
        observadores = new ArrayList<>();
    }
    @Override
    public void recibirMensaje(String mensaje, String remitente) {
        notificarObservadores(mensaje, remitente); // Agregar notificación a los observadores
    }
    @Override
    public void agregarObservador(Observer observador) {
        observadores.add(observador);
    }


    @Override
    public void notificarObservadores(String mensaje, String remitente) {
        for (Observer observador : observadores) {
            observador.recibirMensaje(mensaje, remitente);
        }
    }

}
