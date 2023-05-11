package patrones;

public interface Observable {
    void suscribir(Observer observer);

    void desuscribir(Observer observer);

    void notificarObservadores();
}
