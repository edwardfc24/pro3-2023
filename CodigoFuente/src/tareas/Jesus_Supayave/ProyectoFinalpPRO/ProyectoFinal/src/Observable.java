public interface Observable {
    void suscribir(Observer observer);
    void desuscribir(Observer observe);
    void notificarObservadores(String mensaje);
}
