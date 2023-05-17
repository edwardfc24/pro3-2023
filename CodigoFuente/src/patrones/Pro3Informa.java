package patrones;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Pro3Informa implements Observable {
    private static final Logger logger = LogManager.getLogger(Pro3Informa.class);
    public List<Observer> observadores;
    private String notificacion;

    public Pro3Informa() {

        this.observadores = new ArrayList<>();
        logger.info("Se inició la clase Pro3Informa Correctamente");
    }

    public void notificar(String mensaje) {
        this.notificacion = mensaje;
        logger.debug("Se envió el mensaje a los suscriptores");
        logger.error("Esto verías si habría un error");
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
        logger.warn("El Observer " + observer.getClass() + " se ha desuscrito");
        this.observadores.remove(observer);
    }

    @Override
    public void notificarObservadores() {
        for (Observer observer : this.observadores) {
            observer.actualizar(this.notificacion);
        }
    }
}
