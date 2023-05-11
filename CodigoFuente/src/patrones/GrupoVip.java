package patrones;

import java.util.ArrayList;
import java.util.List;

public class GrupoVip implements Observable {
    public List<Observer> observadores;
    private String notificacion;

    public GrupoVip() {
        this.observadores = new ArrayList<>();
    }

    public void notificar(String mensaje) {
        this.notificacion = mensaje;
        this.notificarObservadores();
    }

    @Override
    public void suscribir(Observer observer) {
        // Agregamos el observador a la lista de observadores
        this.observadores.add(observer);
    }

    @Override
    public void desuscribir(Observer observer) {
        // Removemos al observador de la lista
        this.observadores.remove(observer);
    }

    @Override
    public void notificarObservadores() {
        for (Observer observer : this.observadores) {
            observer.actualizar(this.notificacion);
        }
    }
}
