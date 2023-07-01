package Chats;

import java.awt.*;

public interface Observable {
    void suscribir(Observador observer);

    void desuscribir(Observador observer);

    void notificarObservadores(String mensaje);
}