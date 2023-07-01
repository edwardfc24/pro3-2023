package Sockets.juego;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

class Barco {
    private int tamaño;
    private List<JButton> botones;
    private boolean completo;


    public Barco(int tamaño) {
        this.tamaño = tamaño;
        this.botones = new ArrayList<>();
    }

    public int getTamaño() {
        return tamaño;
    }

    public List<JButton> getBotones() {
        return botones;
    }

    public void setBotones(List<JButton> botones) {
        this.botones = botones;
    }

    public void agregarBotones(List<JButton> nuevosBotones, String rutaImagen) {
        botones.addAll(nuevosBotones);
        ImageIcon icono = new ImageIcon(rutaImagen);
        for (JButton boton : nuevosBotones) {
            boton.setIcon(icono);
        }
    }

    public boolean contieneBoton(Object boton) {
        return botones.contains(boton);
    }

    public boolean isCompleto() {
        return completo;
    }
}